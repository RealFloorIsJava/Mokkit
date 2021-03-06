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

package io.gitlab.lordkorea.mokkit;

import io.gitlab.lordkorea.mokkit.entity.MokkitEntity;
import io.gitlab.lordkorea.mokkit.entity.hanging.MokkitItemFrame;
import io.gitlab.lordkorea.mokkit.entity.hanging.MokkitLeashHitch;
import io.gitlab.lordkorea.mokkit.entity.hanging.MokkitPainting;
import io.gitlab.lordkorea.mokkit.entity.living.MokkitArmorStand;
import io.gitlab.lordkorea.mokkit.entity.living.animal.MokkitBat;
import io.gitlab.lordkorea.mokkit.entity.living.animal.MokkitChicken;
import io.gitlab.lordkorea.mokkit.entity.living.animal.MokkitCow;
import io.gitlab.lordkorea.mokkit.entity.living.animal.MokkitMushroomCow;
import io.gitlab.lordkorea.mokkit.entity.living.animal.MokkitOcelot;
import io.gitlab.lordkorea.mokkit.entity.living.animal.MokkitParrot;
import io.gitlab.lordkorea.mokkit.entity.living.animal.MokkitPig;
import io.gitlab.lordkorea.mokkit.entity.living.animal.MokkitPolarBear;
import io.gitlab.lordkorea.mokkit.entity.living.animal.MokkitRabbit;
import io.gitlab.lordkorea.mokkit.entity.living.animal.MokkitSheep;
import io.gitlab.lordkorea.mokkit.entity.living.animal.MokkitWolf;
import io.gitlab.lordkorea.mokkit.entity.living.animal.horse.MokkitDonkey;
import io.gitlab.lordkorea.mokkit.entity.living.animal.horse.MokkitHorse;
import io.gitlab.lordkorea.mokkit.entity.living.animal.horse.MokkitLlama;
import io.gitlab.lordkorea.mokkit.entity.living.animal.horse.MokkitMule;
import io.gitlab.lordkorea.mokkit.entity.living.animal.horse.MokkitSkeletonHorse;
import io.gitlab.lordkorea.mokkit.entity.living.animal.horse.MokkitZombieHorse;
import io.gitlab.lordkorea.mokkit.entity.living.boss.MokkitEnderDragon;
import io.gitlab.lordkorea.mokkit.entity.living.boss.MokkitWither;
import io.gitlab.lordkorea.mokkit.entity.living.golem.MokkitIronGolem;
import io.gitlab.lordkorea.mokkit.entity.living.golem.MokkitShulker;
import io.gitlab.lordkorea.mokkit.entity.living.golem.MokkitSnowman;
import io.gitlab.lordkorea.mokkit.entity.living.human.MokkitVillager;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitBlaze;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitCaveSpider;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitCreeper;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitElderGuardian;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitEnderman;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitEndermite;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitEvoker;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitGhast;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitGiant;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitGuardian;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitHusk;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitIllusioner;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitMagmaCube;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitPigZombie;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitSilverfish;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitSkeleton;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitSlime;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitSpider;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitStray;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitVex;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitVindicator;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitWitch;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitWitherSkeleton;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitZombie;
import io.gitlab.lordkorea.mokkit.entity.living.monster.MokkitZombieVillager;
import io.gitlab.lordkorea.mokkit.entity.living.water.MokkitSquid;
import io.gitlab.lordkorea.mokkit.entity.misc.MokkitAreaEffectCloud;
import io.gitlab.lordkorea.mokkit.entity.misc.MokkitEnderCrystal;
import io.gitlab.lordkorea.mokkit.entity.projectile.arrow.MokkitArrow;
import io.gitlab.lordkorea.mokkit.entity.projectile.arrow.MokkitSpectralArrow;
import io.gitlab.lordkorea.mokkit.entity.projectile.arrow.MokkitTippedArrow;
import io.gitlab.lordkorea.mokkit.entity.projectile.fireball.MokkitDragonFireball;
import io.gitlab.lordkorea.mokkit.entity.projectile.fireball.MokkitLargeFireball;
import io.gitlab.lordkorea.mokkit.entity.projectile.fireball.MokkitSmallFireball;
import io.gitlab.lordkorea.mokkit.entity.projectile.potion.MokkitLingeringPotion;
import io.gitlab.lordkorea.mokkit.entity.projectile.potion.MokkitSplashPotion;
import io.gitlab.lordkorea.mokkit.entity.vehicle.MokkitBoat;
import io.gitlab.lordkorea.mokkit.entity.vehicle.minecart.MokkitCommandMinecart;
import io.gitlab.lordkorea.mokkit.entity.vehicle.minecart.MokkitExplosiveMinecart;
import io.gitlab.lordkorea.mokkit.entity.vehicle.minecart.MokkitHopperMinecart;
import io.gitlab.lordkorea.mokkit.entity.vehicle.minecart.MokkitPoweredMinecart;
import io.gitlab.lordkorea.mokkit.entity.vehicle.minecart.MokkitRideableMinecart;
import io.gitlab.lordkorea.mokkit.entity.vehicle.minecart.MokkitSpawnerMinecart;
import io.gitlab.lordkorea.mokkit.entity.vehicle.minecart.MokkitStorageMinecart;
import io.gitlab.lordkorea.mokkit.internal.exception.InternalException;
import io.gitlab.lordkorea.mokkit.internal.exception.UnsupportedMockException;
import io.gitlab.lordkorea.mokkit.scheduler.TickListener;
import io.gitlab.lordkorea.mokkit.scheduler.Tickable;
import lombok.Getter;
import lombok.NonNull;
import org.bukkit.BlockChangeDelegate;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Difficulty;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.WorldType;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Item;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Consumer;
import org.bukkit.util.Vector;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @see org.bukkit.World
 */
public class MokkitWorld implements World, Tickable {

    /**
     * The spawnable entities.
     */
    private static final Map<EntityType, Class<? extends MokkitEntity>> spawnableEntities =
            new EnumMap<>(EntityType.class);

    static {
        spawnableEntities.put(EntityType.AREA_EFFECT_CLOUD, MokkitAreaEffectCloud.class);
        spawnableEntities.put(EntityType.ARMOR_STAND, MokkitArmorStand.class);
        spawnableEntities.put(EntityType.ARROW, MokkitArrow.class);
        spawnableEntities.put(EntityType.BAT, MokkitBat.class);
        spawnableEntities.put(EntityType.BLAZE, MokkitBlaze.class);
        spawnableEntities.put(EntityType.BOAT, MokkitBoat.class);
        spawnableEntities.put(EntityType.CAVE_SPIDER, MokkitCaveSpider.class);
        spawnableEntities.put(EntityType.CHICKEN, MokkitChicken.class);
        spawnableEntities.put(EntityType.COW, MokkitCow.class);
        spawnableEntities.put(EntityType.CREEPER, MokkitCreeper.class);
        spawnableEntities.put(EntityType.DONKEY, MokkitDonkey.class);
        spawnableEntities.put(EntityType.DRAGON_FIREBALL, MokkitDragonFireball.class);
        spawnableEntities.put(EntityType.ELDER_GUARDIAN, MokkitElderGuardian.class);
        spawnableEntities.put(EntityType.ENDER_CRYSTAL, MokkitEnderCrystal.class);
        spawnableEntities.put(EntityType.ENDER_DRAGON, MokkitEnderDragon.class);
        spawnableEntities.put(EntityType.ENDERMAN, MokkitEnderman.class);
        spawnableEntities.put(EntityType.ENDERMITE, MokkitEndermite.class);
        spawnableEntities.put(EntityType.EVOKER, MokkitEvoker.class);
        spawnableEntities.put(EntityType.FIREBALL, MokkitLargeFireball.class);
        spawnableEntities.put(EntityType.GHAST, MokkitGhast.class);
        spawnableEntities.put(EntityType.GIANT, MokkitGiant.class);
        spawnableEntities.put(EntityType.GUARDIAN, MokkitGuardian.class);
        spawnableEntities.put(EntityType.HORSE, MokkitHorse.class);
        spawnableEntities.put(EntityType.HUSK, MokkitHusk.class);
        spawnableEntities.put(EntityType.ILLUSIONER, MokkitIllusioner.class);
        spawnableEntities.put(EntityType.IRON_GOLEM, MokkitIronGolem.class);
        spawnableEntities.put(EntityType.ITEM_FRAME, MokkitItemFrame.class);
        spawnableEntities.put(EntityType.LEASH_HITCH, MokkitLeashHitch.class);
        spawnableEntities.put(EntityType.LINGERING_POTION, MokkitLingeringPotion.class);
        spawnableEntities.put(EntityType.LLAMA, MokkitLlama.class);
        spawnableEntities.put(EntityType.MAGMA_CUBE, MokkitMagmaCube.class);
        spawnableEntities.put(EntityType.MINECART, MokkitRideableMinecart.class);
        spawnableEntities.put(EntityType.MINECART_CHEST, MokkitStorageMinecart.class);
        spawnableEntities.put(EntityType.MINECART_COMMAND, MokkitCommandMinecart.class);
        spawnableEntities.put(EntityType.MINECART_FURNACE, MokkitPoweredMinecart.class);
        spawnableEntities.put(EntityType.MINECART_HOPPER, MokkitHopperMinecart.class);
        spawnableEntities.put(EntityType.MINECART_MOB_SPAWNER, MokkitSpawnerMinecart.class);
        spawnableEntities.put(EntityType.MINECART_TNT, MokkitExplosiveMinecart.class);
        spawnableEntities.put(EntityType.MULE, MokkitMule.class);
        spawnableEntities.put(EntityType.MUSHROOM_COW, MokkitMushroomCow.class);
        spawnableEntities.put(EntityType.OCELOT, MokkitOcelot.class);
        spawnableEntities.put(EntityType.PAINTING, MokkitPainting.class);
        spawnableEntities.put(EntityType.PARROT, MokkitParrot.class);
        spawnableEntities.put(EntityType.PIG, MokkitPig.class);
        spawnableEntities.put(EntityType.PIG_ZOMBIE, MokkitPigZombie.class);
        spawnableEntities.put(EntityType.POLAR_BEAR, MokkitPolarBear.class);
        spawnableEntities.put(EntityType.RABBIT, MokkitRabbit.class);
        spawnableEntities.put(EntityType.SHEEP, MokkitSheep.class);
        spawnableEntities.put(EntityType.SHULKER, MokkitShulker.class);
        spawnableEntities.put(EntityType.SILVERFISH, MokkitSilverfish.class);
        spawnableEntities.put(EntityType.SKELETON, MokkitSkeleton.class);
        spawnableEntities.put(EntityType.SKELETON_HORSE, MokkitSkeletonHorse.class);
        spawnableEntities.put(EntityType.SLIME, MokkitSlime.class);
        spawnableEntities.put(EntityType.SMALL_FIREBALL, MokkitSmallFireball.class);
        spawnableEntities.put(EntityType.SNOWMAN, MokkitSnowman.class);
        spawnableEntities.put(EntityType.SPECTRAL_ARROW, MokkitSpectralArrow.class);
        spawnableEntities.put(EntityType.SPIDER, MokkitSpider.class);
        spawnableEntities.put(EntityType.SPLASH_POTION, MokkitSplashPotion.class);
        spawnableEntities.put(EntityType.SQUID, MokkitSquid.class);
        spawnableEntities.put(EntityType.STRAY, MokkitStray.class);
        spawnableEntities.put(EntityType.TIPPED_ARROW, MokkitTippedArrow.class);
        spawnableEntities.put(EntityType.VEX, MokkitVex.class);
        spawnableEntities.put(EntityType.VILLAGER, MokkitVillager.class);
        spawnableEntities.put(EntityType.VINDICATOR, MokkitVindicator.class);
        spawnableEntities.put(EntityType.WITCH, MokkitWitch.class);
        spawnableEntities.put(EntityType.WITHER, MokkitWither.class);
        spawnableEntities.put(EntityType.WITHER_SKELETON, MokkitWitherSkeleton.class);
        spawnableEntities.put(EntityType.WOLF, MokkitWolf.class);
        spawnableEntities.put(EntityType.ZOMBIE, MokkitZombie.class);
        spawnableEntities.put(EntityType.ZOMBIE_HORSE, MokkitZombieHorse.class);
        spawnableEntities.put(EntityType.ZOMBIE_VILLAGER, MokkitZombieVillager.class);
    }

    /**
     * Updates the worlds for the given entity. Adds the entity to the correct world and removes it from all others.
     *
     * @param entity The entity.
     */
    public static void updateWorldsForEntity(final @NonNull Entity entity) {
        for (final World world : Bukkit.getWorlds()) {
            final MokkitWorld mWorld = (MokkitWorld) world;
            if (mWorld == entity.getWorld() && entity.isValid()) {
                mWorld.entities.add(entity);
            } else {
                mWorld.entities.remove(entity);
            }
        }
    }

    /**
     * The control object.
     */
    private final Mokkit mokkit = new Mokkit();

    /**
     * The server this world is in.
     */
    private final MokkitServer server;

    /**
     * The name of the world.
     */
    private @Getter final String name;

    /**
     * The loaded chunks of the world.
     */
    private final Map<MokkitChunkCoordinate, Chunk> loadedChunks = new HashMap<>();

    /**
     * The entities in the world.
     */
    private final Set<Entity> entities = new HashSet<>();

    /**
     * Constructor.
     *
     * @param name The name of the world.
     */
    public MokkitWorld(final @NonNull MokkitServer server, final @NonNull String name) {
        this.server = server;
        this.name = name;
    }

    @Override
    public Block getBlockAt(final int x, final int y, final int z) {
        assert 0 <= y && y < getMaxHeight() : "invalid y position " + y;
        final Chunk chunk = getChunkAt(x >> 4, z >> 4);
        final int chunkXOff = (x >> 4) * 16;
        final int chunkZOff = (z >> 4) * 16;
        return chunk.getBlock(x - chunkXOff, y, z - chunkZOff);
    }

    @Override
    public Block getBlockAt(final @NonNull Location location) {
        return getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    @Override
    public int getBlockTypeIdAt(final int x, final int y, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getBlockTypeIdAt(final Location location) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getHighestBlockYAt(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getHighestBlockYAt(final Location location) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Block getHighestBlockAt(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Block getHighestBlockAt(final Location location) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Chunk getChunkAt(final int x, final int z) {
        final MokkitChunkCoordinate coord = new MokkitChunkCoordinate(x, z);
        if (!loadedChunks.containsKey(coord)) {
            loadChunk(coord.getX(), coord.getZ());
        }
        return loadedChunks.get(coord);
    }

    @Override
    public Chunk getChunkAt(final @NonNull Location location) {
        return getChunkAt(location.getBlockX() >> 4, location.getBlockZ() >> 4);
    }

    @Override
    public Chunk getChunkAt(final @NonNull Block block) {
        return getChunkAt(block.getLocation());
    }

    @Override
    public boolean isChunkLoaded(final Chunk chunk) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Chunk[] getLoadedChunks() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void loadChunk(final Chunk chunk) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isChunkLoaded(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isChunkInUse(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void loadChunk(final int x, final int z) {
        loadChunk(x, z, true);
    }

    @Override
    public boolean loadChunk(final int x, final int z, final boolean generate) {
        final MokkitChunkCoordinate coord = new MokkitChunkCoordinate(x, z);
        if (loadedChunks.containsKey(coord)) {
            return true;
        }

        // Create the chunk.
        if (generate) {
            loadedChunks.put(coord, new MokkitSuperflatChunk(this, x, z));
        } else {
            loadedChunks.put(coord, new MokkitChunk(this, x, z));
        }
        return true;
    }

    @Override
    public boolean unloadChunk(final Chunk chunk) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean unloadChunk(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean unloadChunk(final int x, final int z, final boolean save) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean unloadChunk(final int x, final int z, final boolean save, final boolean safe) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean unloadChunkRequest(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean unloadChunkRequest(final int x, final int z, final boolean safe) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean regenerateChunk(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean refreshChunk(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Item dropItem(final Location location, final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Item dropItemNaturally(final Location location, final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Arrow spawnArrow(final @NonNull Location location, final @NonNull Vector direction, final float speed,
                            final float spread) {
        return spawnArrow(location, direction, speed, spread, Arrow.class);
    }

    @Override
    public <T extends Arrow> T spawnArrow(final @NonNull Location location, final @NonNull Vector direction,
                                          final float speed, final float spread, final @NonNull Class<T> clazz) {
        return spawn(location, clazz, arrow -> {
            arrow.setVelocity(direction.normalize().multiply(speed));
            // TODO spread?
        });
    }

    @Override
    public boolean generateTree(final Location location, final TreeType type) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean generateTree(final Location loc, final TreeType type, final BlockChangeDelegate delegate) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Entity spawnEntity(final @NonNull Location loc, final @NonNull EntityType type) {
        return spawn(loc, type.getEntityClass());
    }

    @Override
    public LightningStrike strikeLightning(final Location loc) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public LightningStrike strikeLightningEffect(final Location loc) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<Entity> getEntities() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<LivingEntity> getLivingEntities() {
        // TODO
        throw new UnsupportedMockException();
    }

    @SafeVarargs
    @Override
    public final <T extends Entity> Collection<T> getEntitiesByClass(final @NonNull Class<T>... classes) {
        final Collection<T> results = new LinkedList<>();
        for (final Class<T> clazz : classes) {
            results.addAll(getEntitiesByClass(clazz));
        }
        return results;
    }

    @Override
    public <T extends Entity> Collection<T> getEntitiesByClass(final @NonNull Class<T> cls) {
        return entities.stream()
                .filter(e -> cls.isAssignableFrom(e.getClass()))
                .map(cls::cast)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Entity> getEntitiesByClasses(final @NonNull Class<?>... classes) {
        final Collection<Entity> results = new LinkedList<>();
        for (final Class<?> clazz : classes) {
            if (Entity.class.isAssignableFrom(clazz)) {
                //noinspection unchecked clazz must extend Entity.
                results.addAll(getEntitiesByClass((Class<? extends Entity>) clazz));
            }
        }
        return results;
    }

    @Override
    public List<Player> getPlayers() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Collection<Entity> getNearbyEntities(final @NonNull Location location, final double x, final double y,
                                                final double z) {
        assert x >= 0 : "invalid x distance " + x;
        assert y >= 0 : "invalid x distance " + y;
        assert z >= 0 : "invalid x distance " + z;
        return entities.stream()
                .filter(e -> e.getWorld() == location.getWorld())
                .filter(e -> Math.abs(location.getX() - e.getLocation().getX()) <= x)
                .filter(e -> Math.abs(location.getY() - e.getLocation().getY()) <= y)
                .filter(e -> Math.abs(location.getZ() - e.getLocation().getZ()) <= z)
                .collect(Collectors.toList());
    }

    @Override
    public UUID getUID() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Location getSpawnLocation() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean setSpawnLocation(final Location location) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean setSpawnLocation(final int x, final int y, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public long getTime() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setTime(final long time) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public long getFullTime() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setFullTime(final long time) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasStorm() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setStorm(final boolean hasStorm) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getWeatherDuration() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setWeatherDuration(final int duration) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isThundering() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setThundering(final boolean thundering) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getThunderDuration() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setThunderDuration(final int duration) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean createExplosion(final double x, final double y, final double z, final float power) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean createExplosion(final double x, final double y, final double z, final float power,
                                   final boolean setFire) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean createExplosion(final double x, final double y, final double z, final float power,
                                   final boolean setFire, final boolean breakBlocks) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean createExplosion(final Location loc, final float power) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean createExplosion(final Location loc, final float power, final boolean setFire) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Environment getEnvironment() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public long getSeed() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getPVP() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setPVP(final boolean pvp) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ChunkGenerator getGenerator() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void save() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<BlockPopulator> getPopulators() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T extends Entity> T spawn(final @NonNull Location location, final @NonNull Class<T> clazz)
            throws IllegalArgumentException {
        return spawn(location, clazz, t -> {
        });
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Entity> T spawn(final @NonNull Location location, final @NonNull Class<T> clazz,
                                      final @NonNull Consumer<T> function) throws IllegalArgumentException {
        if (location.getWorld() != this) {
            throw new IllegalArgumentException("attempting to spawn in conflicting worlds");
        }

        // Determine the entity type.
        EntityType targetType = null;
        for (final EntityType possible : EntityType.values()) {
            if (possible.getEntityClass() == clazz) {
                targetType = possible;
                break;
            }
        }
        if (targetType == null) {
            throw new IllegalArgumentException("can not find entity for class: " + clazz.getName());
        }

        // Block illegal entity types.
        final Set<EntityType> illegal = EnumSet.noneOf(EntityType.class);
        illegal.addAll(Arrays.asList(EntityType.COMPLEX_PART, EntityType.LIGHTNING, EntityType.PLAYER,
                EntityType.UNKNOWN, EntityType.WEATHER));
        if (illegal.contains(targetType)) {
            throw new IllegalArgumentException("can not spawn " + targetType.name());
        }

        // Determine the spawnable entities.
        if (!spawnableEntities.containsKey(targetType)) {
            throw new UnsupportedMockException();
        }

        // Determine whether we can spawn this type.
        // switch (targetType) {
            /*case DROPPED_ITEM:
            case EXPERIENCE_ORB:
            case EGG:
            case SNOWBALL:
            case ENDER_PEARL:
            case ENDER_SIGNAL:
            case THROWN_EXP_BOTTLE:
            case WITHER_SKULL:
            case PRIMED_TNT:
            case FALLING_BLOCK:
            case FIREWORK:
            case SHULKER_BULLET:
            case EVOKER_FANGS:
            case LLAMA_SPIT:
            case FISHING_HOOK:
                // Not (yet) supported.
                throw new UnsupportedMockException();*/
        // }

        // Spawn the entity.
        final Class<? extends MokkitEntity> toSpawn = spawnableEntities.get(targetType);
        final T entity;
        try {
            entity = (T) toSpawn.getConstructor(MokkitServer.class, Location.class, UUID.class).newInstance(server,
                    location, UUID.randomUUID());
        } catch (final IllegalAccessException | InstantiationException | InvocationTargetException
                | NoSuchMethodException ex) {
            throw new InternalException("can not create entity", ex);
        }

        // TODO SpawnerSpawnEvent? Spawn reasons?
        if (entity instanceof Item) {
            final ItemSpawnEvent event = new ItemSpawnEvent((Item) entity);
            server.getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new IllegalArgumentException("can not spawn entity due to cancelled ItemSpawnEvent");
            }
        } else if (entity instanceof LivingEntity) {
            final CreatureSpawnEvent event = new CreatureSpawnEvent((LivingEntity) entity, SpawnReason.CUSTOM);
            server.getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new IllegalArgumentException("can not spawn entity due to cancelled CreatureSpawnEvent");
            }
        } else if (entity instanceof Projectile) {
            final ProjectileLaunchEvent event = new ProjectileLaunchEvent(entity);
            server.getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new IllegalArgumentException("can not spawn entity due to cancelled ProjectileLaunchEvent");
            }
        } else if (entity instanceof Vehicle) {
            final VehicleCreateEvent event = new VehicleCreateEvent((Vehicle) entity);
            server.getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new IllegalArgumentException("can not spawn entity due to cancelled VehicleCreateEvent");
            }
        } else {
            final EntitySpawnEvent event = new EntitySpawnEvent(entity);
            server.getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new IllegalArgumentException("can not spawn entity due to cancelled EntitySpawnEvent");
            }
        }

        // Invoke the callback.
        function.accept(entity);

        // Add to the world.
        entities.add(entity);

        return entity;
    }

    @Override
    public FallingBlock spawnFallingBlock(final Location location,
                                          final MaterialData data) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public FallingBlock spawnFallingBlock(final Location location, final Material material,
                                          final byte data) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public FallingBlock spawnFallingBlock(final Location location, final int blockId,
                                          final byte blockData) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void playEffect(final Location location, final Effect effect, final int data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void playEffect(final Location location, final Effect effect, final int data, final int radius) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T> void playEffect(final Location location, final Effect effect, final T data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T> void playEffect(final Location location, final Effect effect, final T data, final int radius) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ChunkSnapshot getEmptyChunkSnapshot(final int x, final int z, final boolean includeBiome,
                                               final boolean includeBiomeTempRain) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSpawnFlags(final boolean allowMonsters, final boolean allowAnimals) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getAllowAnimals() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getAllowMonsters() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Biome getBiome(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBiome(final int x, final int z, final Biome bio) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public double getTemperature(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public double getHumidity(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getMaxHeight() {
        return 256;
    }

    @Override
    public int getSeaLevel() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getKeepSpawnInMemory() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setKeepSpawnInMemory(final boolean keepLoaded) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isAutoSave() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setAutoSave(final boolean value) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void sendPluginMessage(final Plugin source, final String channel, final byte[] message) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Set<String> getListeningPluginChannels() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setMetadata(final String metadataKey, final MetadataValue newMetadataValue) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<MetadataValue> getMetadata(final String metadataKey) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasMetadata(final String metadataKey) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void removeMetadata(final String metadataKey, final Plugin owningPlugin) {
        // TODO
        throw new UnsupportedMockException();
    }

    /**
     * Fetch the control object.
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
    public class Mokkit implements TickListener {

        @Override
        public void tick(final long tick) {
            assert tick >= 0 : "invalid tick " + tick;
            final Collection<Entity> toTick = new ArrayList<>(entities);
            toTick.stream().filter(x -> x instanceof Tickable).map(x -> (Tickable) x).forEach(x -> x.tick(tick));
        }
    }

    @Override
    public boolean canGenerateStructures() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getAmbientSpawnLimit() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setAmbientSpawnLimit(final int limit) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getAnimalSpawnLimit() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setAnimalSpawnLimit(final int limit) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Difficulty getDifficulty() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setDifficulty(final Difficulty difficulty) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public String getGameRuleValue(final String rule) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public String[] getGameRules() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getMonsterSpawnLimit() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setMonsterSpawnLimit(final int limit) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public long getTicksPerAnimalSpawns() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setTicksPerAnimalSpawns(final int ticksPerAnimalSpawns) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public long getTicksPerMonsterSpawns() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setTicksPerMonsterSpawns(final int ticksPerMonsterSpawns) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getWaterAnimalSpawnLimit() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setWaterAnimalSpawnLimit(final int limit) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public WorldBorder getWorldBorder() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public File getWorldFolder() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public WorldType getWorldType() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isGameRule(final String rule) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void playSound(final Location location, final Sound sound, final float volume, final float pitch) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void playSound(final Location location, final String sound, final float volume, final float pitch) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void playSound(final Location location, final Sound sound, final SoundCategory category, final float volume,
                          final float pitch) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void playSound(final Location location, final String sound, final SoundCategory category, final float volume,
                          final float pitch) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean setGameRuleValue(final String rule, final String value) {
        // TODO
        throw new UnsupportedMockException();
    }


    @Override
    public void spawnParticle(final Particle particle, final Location location, final int count) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void spawnParticle(final Particle particle, final double x, final double y, final double z,
                              final int count) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T> void spawnParticle(final Particle particle, final Location location, final int count, final T data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T> void spawnParticle(final Particle particle, final double x, final double y, final double z,
                                  final int count, final T data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void spawnParticle(final Particle particle, final Location location, final int count, final double offsetX,
                              final double offsetY, final double offsetZ) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void spawnParticle(final Particle particle, final double x, final double y, final double z, final int count,
                              final double offsetX, final double offsetY, final double offsetZ) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T> void spawnParticle(final Particle particle, final Location location, final int count,
                                  final double offsetX, final double offsetY, final double offsetZ, final T data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T> void spawnParticle(final Particle particle, final double x, final double y, final double z,
                                  final int count, final double offsetX, final double offsetY, final double offsetZ,
                                  final T data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void spawnParticle(final Particle particle, final Location location, final int count, final double offsetX,
                              final double offsetY, final double offsetZ, final double extra) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void spawnParticle(final Particle particle, final double x, final double y, final double z, final int count,
                              final double offsetX, final double offsetY, final double offsetZ, final double extra) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T> void spawnParticle(final Particle particle, final Location location, final int count,
                                  final double offsetX, final double offsetY, final double offsetZ, final double extra,
                                  final T data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T> void spawnParticle(final Particle particle, final double x, final double y, final double z,
                                  final int count, final double offsetX, final double offsetY, final double offsetZ,
                                  final double extra, final T data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Spigot spigot() {
        // TODO
        throw new UnsupportedMockException();
    }
}
