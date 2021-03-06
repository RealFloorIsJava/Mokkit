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

package io.gitlab.lordkorea.mokkit.inventory;

import lombok.NonNull;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.InventoryHolder;

/**
 * A custom inventory.
 */
public class MokkitCustomInventory extends MokkitInventory {

    /**
     * Constructor.
     *
     * @param size   The size of inventory.
     * @param holder The holder of the inventory.
     * @param title  The title of the inventory.
     */
    public MokkitCustomInventory(final int size, final InventoryHolder holder, final @NonNull String title) {
        super(size, holder, title, InventoryType.CHEST);
    }

    @Override
    public SlotType getSlotType(final int slot) {
        return SlotType.CONTAINER;
    }
}
