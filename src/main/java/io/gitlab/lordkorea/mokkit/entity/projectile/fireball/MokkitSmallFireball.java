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

package io.gitlab.lordkorea.mokkit.entity.projectile.fireball;

import io.gitlab.lordkorea.mokkit.MokkitServer;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.SmallFireball;

import java.util.UUID;

/**
 * @see org.bukkit.entity.SmallFireball
 */
public class MokkitSmallFireball extends MokkitFireball implements SmallFireball {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitSmallFireball(final @NonNull MokkitServer server, final @NonNull Location location,
                               final @NonNull UUID uniqueId) {
        super(server, "SmallFireball", location, uniqueId);
    }

    @Override
    public EntityType getType() {
        return EntityType.SMALL_FIREBALL;
    }
}
