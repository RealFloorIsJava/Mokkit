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

package io.gitlab.lordkorea.mokkit.entity.projectile.potion;

import io.gitlab.lordkorea.mokkit.MokkitServer;
import io.gitlab.lordkorea.mokkit.entity.projectile.MokkitProjectile;
import io.gitlab.lordkorea.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.UUID;

/**
 * @see org.bukkit.entity.ThrownPotion
 */
public abstract class MokkitThrownPotion extends MokkitProjectile implements ThrownPotion {

    /**
     * The control object.
     */
    private final Mokkit mokkit = new Mokkit();

    /**
     * The potion effects of the potion.
     */
    private final Collection<PotionEffect> effects = new HashSet<>();

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param name     The name of the entity.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    protected MokkitThrownPotion(final @NonNull MokkitServer server, final @NonNull String name,
                                 final @NonNull Location location, final @NonNull UUID uniqueId) {
        super(server, name, location, uniqueId);
    }

    @Override
    public Collection<PotionEffect> getEffects() {
        return Collections.unmodifiableCollection(effects);
    }

    @Override
    public ItemStack getItem() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setItem(final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }

    /**
     * Fetches the control object.
     *
     * @return The control object.
     */
    @Override
    public Mokkit mokkit() {
        return mokkit;
    }

    /**
     * The class for the control object.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    public class Mokkit extends MokkitProjectile.Mokkit {

        /**
         * Adds the given effect to the potion, overwriting existing effects.
         *
         * @param effect The effect.
         */
        public void addEffect(final @NonNull PotionEffect effect) {
            effects.removeIf(e -> e.getType().equals(effect.getType()));
            effects.add(effect);
        }
    }
}
