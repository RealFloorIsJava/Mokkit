package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Bat
 */
public class MokkitBat extends MokkitAmbient implements Bat {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitBat(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Bat", location, uuid, 6.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.BAT;
    }

    @Override
    public boolean isAwake() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setAwake(final boolean state) {
        // TODO
        throw new UnsupportedMockException();
    }
}
