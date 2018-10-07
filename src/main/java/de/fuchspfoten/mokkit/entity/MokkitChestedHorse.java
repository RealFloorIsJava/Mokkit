package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.ChestedHorse;

import java.util.UUID;

/**
 * @see org.bukkit.entity.ChestedHorse
 */
public abstract class MokkitChestedHorse extends MokkitAbstractHorse implements ChestedHorse {

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param name             The name of the entity.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     * @param defaultMaxHealth The default max health of the entity.
     */
    public MokkitChestedHorse(final MokkitServer server, final String name, final Location location, final UUID uuid,
                              final double defaultMaxHealth) {
        super(server, name, location, uuid, defaultMaxHealth);
    }

    @Override
    public boolean isCarryingChest() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCarryingChest(final boolean chest) {
        // TODO
        throw new UnsupportedMockException();
    }
}