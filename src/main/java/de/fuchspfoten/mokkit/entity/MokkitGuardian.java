package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Guardian;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Guardian
 */
public class MokkitGuardian extends MokkitMonster implements Guardian {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitGuardian(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Guardian", location, uuid, 30.0);
    }

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param name             The name of the entity.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     * @param defaultMaxHealth The default max health of the entity.
     */
    protected MokkitGuardian(final MokkitServer server, final String name, final Location location, final UUID uuid,
                             final double defaultMaxHealth) {
        super(server, name, location, uuid, defaultMaxHealth);
    }

    @Override
    public EntityType getType() {
        return EntityType.GUARDIAN;
    }

    @Override
    public boolean isElder() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setElder(final boolean shouldBeElder) {
        // TODO
        throw new UnsupportedMockException();
    }
}