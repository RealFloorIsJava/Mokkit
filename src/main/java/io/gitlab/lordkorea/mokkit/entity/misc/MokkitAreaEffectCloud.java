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

package io.gitlab.lordkorea.mokkit.entity.misc;

import io.gitlab.lordkorea.mokkit.MokkitServer;
import io.gitlab.lordkorea.mokkit.entity.MokkitEntity;
import io.gitlab.lordkorea.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.AreaEffectCloudApplyEvent;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @see org.bukkit.entity.AreaEffectCloud
 */
public class MokkitAreaEffectCloud extends MokkitEntity implements AreaEffectCloud {

    /**
     * The control object.
     */
    private final Mokkit mokkit = new Mokkit();

    /**
     * The custom potion effects of this cloud.
     */
    private final Set<PotionEffect> customEffects = new HashSet<>();

    /**
     * The ticks in which the effects were last applied to the given entities.
     */
    private final Map<LivingEntity, Long> lastAppliedTick = new HashMap<>();

    /**
     * The duration this cloud will live for.
     */
    private @Getter @Setter int duration = 600;

    /**
     * The target-individual wait time before effects apply to targets.
     */
    private @Getter @Setter int waitTime = 0;

    /**
     * The per entity cooldown time needed after an application.
     */
    private @Getter
    @Setter
    int reapplicationDelay = 5;

    /**
     * The amount that is subtracted from the duration on use.
     */
    private @Getter
    @Setter
    int durationOnUse = 0;

    /**
     * The radius of the cloud.
     */
    private @Getter
    @Setter
    float radius = 3.0f;

    /**
     * The amount that is subtracted from the radius on use.
     */
    private @Getter
    @Setter
    float radiusOnUse = 0.5f;

    /**
     * The amount that is subtracted from the radius per tick.
     */
    private @Getter
    @Setter
    float radiusPerTick = 3.0f / 600.0f;

    /**
     * The source that created this cloud.
     */
    private @Getter
    @Setter
    ProjectileSource source;

    /**
     * The underlying potion.
     */
    private @Getter
    @Setter
    PotionData basePotionData;

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitAreaEffectCloud(final @NonNull MokkitServer server, final @NonNull Location location,
                                 final @NonNull UUID uniqueId) {
        super(server, "AreaEffectCloud", location, uniqueId);
    }

    @Override
    public Particle getParticle() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setParticle(final Particle particle) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasCustomEffects() {
        return !customEffects.isEmpty();
    }

    @Override
    public List<PotionEffect> getCustomEffects() {
        return new ArrayList<>(customEffects);
    }

    @Override
    public boolean addCustomEffect(final PotionEffect effect, final boolean overwrite) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean removeCustomEffect(final @NonNull PotionEffectType type) {
        return customEffects.removeIf(e -> e.getType().equals(type));
    }

    @Override
    public boolean hasCustomEffect(final @NonNull PotionEffectType type) {
        return customEffects.stream().anyMatch(e -> e.getType().equals(type));
    }

    @Override
    public void clearCustomEffects() {
        customEffects.clear();
    }

    @Override
    public Color getColor() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setColor(final Color color) {
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

    @Override
    public EntityType getType() {
        return EntityType.AREA_EFFECT_CLOUD;
    }

    /**
     * Class for the control object.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    public class Mokkit extends MokkitEntity.Mokkit {

        @Override
        public void tick(final long tick) {
            assert tick >= 0 : "invalid tick number " + tick;

            if (tick % 5 != 0) {
                // Once per five ticks.
                return;
            }

            final Collection<Entity> targets =
                    getWorld().getNearbyEntities(getLocation(), getRadius(), 0.5, getRadius());

            // TODO: waitTime

            final List<LivingEntity> realTargets = targets.stream()
                    .filter(x -> x instanceof LivingEntity)
                    .map(x -> (LivingEntity) x)
                    .filter(x -> tick - lastAppliedTick.getOrDefault(x, 0L) >= getReapplicationDelay())
                    .collect(Collectors.toList());

            final AreaEffectCloudApplyEvent event =
                    new AreaEffectCloudApplyEvent(MokkitAreaEffectCloud.this, realTargets);
            getServer().getPluginManager().callEvent(event);

            realTargets.forEach(x -> {
                // TODO these numbers are not accurate.
                x.addPotionEffect(new PotionEffect(basePotionData.getType().getEffectType(),
                        basePotionData.isExtended() ? 300 : 100, basePotionData.isUpgraded() ? 1 : 0));
                for (final PotionEffect effect : customEffects) {
                    x.addPotionEffect(new PotionEffect(effect.getType(), effect.getDuration(), effect.getAmplifier(),
                            effect.isAmbient(), effect.hasParticles(), effect.getColor()));
                }
                lastAppliedTick.put(x, tick);
            });
            duration -= getDurationOnUse() * realTargets.size();
            radius -= getRadiusOnUse() * realTargets.size();

            duration--;
            radius -= getRadiusPerTick();
            if (duration <= 0 || radius <= 0) {
                remove();
            }
        }
    }
}
