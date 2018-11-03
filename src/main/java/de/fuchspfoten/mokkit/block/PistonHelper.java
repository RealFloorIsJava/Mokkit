package de.fuchspfoten.mokkit.block;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Helper for piston movement.
 */
public final class PistonHelper {

    /**
     * Calculates the push list for pushing target in the given direction.
     *
     * @param target    The target.
     * @param direction The direction.
     * @return The list of blocks to push.
     */
    public static List<Block> calculatePushList(final Block target, final BlockFace direction) {
        return new ArrayList<>(calculatePushSet(target, direction, new HashSet<>(), 0));
    }

    /**
     * Moves the given blocks in the given direction.
     *
     * @param blocks    The blocks.
     * @param direction The direction.
     */
    public static void moveBlocks(final List<Block> blocks, final BlockFace direction) {
        // TODO drops of removed blocks?
        final Set<Block> toDoSet = new HashSet<>(blocks);
        final Queue<Block> toDoQueue = new ArrayDeque<>(blocks);
        while (!toDoSet.isEmpty()) {
            final Block next = toDoQueue.poll();
            assert next != null;

            // Check if we can move the "next" block.
            final Block toBlock = next.getRelative(direction);
            if (toDoSet.contains(toBlock)) {
                toDoQueue.add(next);
                continue;
            }

            // Update the target block.
            final BlockState state = toBlock.getState();
            state.setType(next.getType());
            state.setData(next.getState().getData());
            state.update(true);

            // Remove the source block.
            final BlockState oldState = next.getState();
            oldState.setType(Material.AIR);
            oldState.setData(new MaterialData(Material.AIR));
            oldState.update(true);

            // Remove the block from the todo set.
            toDoSet.remove(next);
        }
    }

    /**
     * Calculates the push set for pushing target in the given direction.
     *
     * @param target    The target.
     * @param direction The direction.
     * @param closedSet The blocks which will not be considered.
     * @param limit     If this number is over 100, we stop.
     * @return The set of blocks to push.
     */
    private static Set<Block> calculatePushSet(final Block target, final BlockFace direction, final Set<Block> closedSet,
                                               final int limit) {
        final Set<Block> pushSet = new HashSet<>();
        if (isImmobile(target.getType())) {
            // Block is immobile and blocks the push in this direction.
            throw new PushBlockedException();
        }
        if (!isMovable(target.getType())) {
            // Target is not movable and not immobile: Do not add any blocks to the push list for this block.
            return pushSet;
        }

        // Target closed?
        if (closedSet.contains(target)) {
            return pushSet;
        }

        // Flood limit reached?
        if (limit > 100) {
            throw new PushBlockedException();
        }

        // The block is pushable.
        pushSet.add(target);
        closedSet.add(target);
        pushSet.addAll(calculatePushSet(target.getRelative(direction), direction, closedSet, limit + 1));

        // If this is a slime block, push neighbors.
        if (target.getType() == Material.SLIME_BLOCK) {
            final BlockFace[] faces =
                    {BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST, BlockFace.UP, BlockFace.DOWN};
            for (final BlockFace face : faces) {
                if (face == direction) {
                    continue;
                }
                final Block next = target.getRelative(face);

                // Push this with our current closed set.
                try {
                    final HashSet<Block> tmpSet = new HashSet<>(closedSet);
                    pushSet.addAll(calculatePushSet(next, direction, tmpSet, limit + pushSet.size()));
                    closedSet.addAll(tmpSet);
                } catch (final PushBlockedException ex) {
                    // Just ignore this block.
                }
            }
        }

        return pushSet;
    }

    /**
     * Checks whether or not the given material is immobile.
     *
     * @param mat The material.
     * @return True iff it is immobile.
     */
    private static boolean isImmobile(final Material mat) {
        // TODO pistons can not be pushed right now.
        // TODO this list is likely incomplete / wrong
        switch (mat) {
            case BEDROCK:
            case DISPENSER:
            case NOTE_BLOCK:
            case BED_BLOCK:
            case PISTON_STICKY_BASE:
            case PISTON_BASE:
            case PISTON_EXTENSION:
            case PISTON_MOVING_PIECE:
            case OBSIDIAN:
            case MOB_SPAWNER:
            case CHEST:
            case SOIL:
            case FURNACE:
            case BURNING_FURNACE:
            case SIGN_POST:
            case WOODEN_DOOR:
            case WALL_SIGN:
            case IRON_DOOR_BLOCK:
            case JUKEBOX:
            case ENCHANTMENT_TABLE:
            case BREWING_STAND:
            case ENDER_PORTAL_FRAME:
            case ENDER_CHEST:
            case COMMAND:
            case BEACON:
            case ANVIL:
            case TRAPPED_CHEST:
            case DAYLIGHT_DETECTOR:
            case HOPPER:
            case DROPPER:
            case BARRIER:
            case STANDING_BANNER:
            case WALL_BANNER:
            case DAYLIGHT_DETECTOR_INVERTED:
            case SPRUCE_DOOR:
            case BIRCH_DOOR:
            case JUNGLE_DOOR:
            case ACACIA_DOOR:
            case DARK_OAK_DOOR:
            case GRASS_PATH:
            case STRUCTURE_BLOCK:
            case COMMAND_REPEATING:
            case COMMAND_CHAIN:
            case FROSTED_ICE:
            case OBSERVER:
                return true;
            default:
                return false;
        }
    }

    /**
     * Checks whether or not the given material is movable.
     *
     * @param mat The material.
     * @return True iff it is movable.
     */
    private static boolean isMovable(final Material mat) {
        // TODO pistons can not be pushed right now.
        // TODO this list is likely incomplete / wrong
        switch (mat) {
            case AIR:
            case BEDROCK:
            case DISPENSER:
            case NOTE_BLOCK:
            case BED_BLOCK:
            case PISTON_STICKY_BASE:
            case PISTON_BASE:
            case PISTON_EXTENSION:
            case PISTON_MOVING_PIECE:
            case OBSIDIAN:
            case MOB_SPAWNER:
            case CHEST:
            case SOIL:
            case FURNACE:
            case BURNING_FURNACE:
            case SIGN_POST:
            case WOODEN_DOOR:
            case WALL_SIGN:
            case STONE_PLATE:
            case IRON_DOOR_BLOCK:
            case WOOD_PLATE:
            case CACTUS:
            case JUKEBOX:
            case PUMPKIN:
            case JACK_O_LANTERN:
            case CAKE_BLOCK:
            case MELON_BLOCK:
            case ENCHANTMENT_TABLE:
            case BREWING_STAND:
            case ENDER_PORTAL_FRAME:
            case DRAGON_EGG:
            case ENDER_CHEST:
            case COMMAND:
            case BEACON:
            case ANVIL:
            case TRAPPED_CHEST:
            case DAYLIGHT_DETECTOR:
            case HOPPER:
            case DROPPER:
            case BARRIER:
            case STANDING_BANNER:
            case WALL_BANNER:
            case DAYLIGHT_DETECTOR_INVERTED:
            case SPRUCE_DOOR:
            case BIRCH_DOOR:
            case JUNGLE_DOOR:
            case ACACIA_DOOR:
            case DARK_OAK_DOOR:
            case GRASS_PATH:
            case STRUCTURE_BLOCK:
            case COMMAND_REPEATING:
            case COMMAND_CHAIN:
            case FROSTED_ICE:
            case NETHER_WART_BLOCK:
            case OBSERVER:
            case WHITE_SHULKER_BOX:
            case ORANGE_SHULKER_BOX:
            case MAGENTA_SHULKER_BOX:
            case LIGHT_BLUE_SHULKER_BOX:
            case YELLOW_SHULKER_BOX:
            case LIME_SHULKER_BOX:
            case PINK_SHULKER_BOX:
            case GRAY_SHULKER_BOX:
            case SILVER_SHULKER_BOX:
            case CYAN_SHULKER_BOX:
            case PURPLE_SHULKER_BOX:
            case BLUE_SHULKER_BOX:
            case BROWN_SHULKER_BOX:
            case GREEN_SHULKER_BOX:
            case RED_SHULKER_BOX:
            case BLACK_SHULKER_BOX:
                return false;
            default:
                return true;
        }
    }

    /**
     * Private constructor to prevent instance creation.
     */
    private PistonHelper() {
    }
}