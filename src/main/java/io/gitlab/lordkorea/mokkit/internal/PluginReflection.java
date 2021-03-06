/*
 * Copyright (c) 2018.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.gitlab.lordkorea.mokkit.internal;

import io.gitlab.lordkorea.mokkit.internal.exception.InternalException;
import org.bukkit.Server;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;
import sun.reflect.ReflectionFactory;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Helps with plugin reflection.
 */
public final class PluginReflection {

    /**
     * Creates a plugin from the given class.
     *
     * @param clazz The class.
     * @param <T>   The type of the plugin.
     * @return The plugin.
     */
    public static <T extends JavaPlugin> T createPlugin(final Class<T> clazz, final Server server,
                                                        final JavaPluginLoader loader,
                                                        final PluginDescriptionFile pluginDescriptionFile,
                                                        final File dataFolder, final File file) {
        final T pluginRaw = createWithoutConstructor(clazz);
        ReflectionHelper.invokeMethod(JavaPlugin.class, pluginRaw, "init", new Class[]{PluginLoader.class,
                        Server.class, PluginDescriptionFile.class, File.class, File.class, ClassLoader.class},
                new Object[]{loader, server, pluginDescriptionFile, dataFolder, file,
                        new ProtectionDomainFilteringResourceLoader(clazz)});

        // By now the plugin is initialized but nothing else has been done.
        return pluginRaw;
    }

    /**
     * Evil black magic creates objects without invoking the constructor.
     *
     * @param clazz The class.
     * @param <T>   The type of the class.
     * @return The uninitialized instance.
     */
    private static <T> T createWithoutConstructor(final Class<T> clazz) {
        // Evil, dark magic. Breaks on other JVMs... works on Oracle JDK & OpenJDK.
        try {
            final ReflectionFactory evil = ReflectionFactory.getReflectionFactory();
            final Constructor<Object> objCons = Object.class.getDeclaredConstructor();
            final Constructor<?> surrogate = evil.newConstructorForSerialization(clazz, objCons);
            return clazz.cast(surrogate.newInstance());
        } catch (final IllegalAccessException | IllegalArgumentException | InstantiationException | SecurityException
                | NoSuchMethodException | InvocationTargetException ex) {
            throw new InternalException("could not create plugin instance", ex);
        }
    }

    /**
     * Private constructor to prevent instance creation.
     */
    private PluginReflection() {
    }
}
