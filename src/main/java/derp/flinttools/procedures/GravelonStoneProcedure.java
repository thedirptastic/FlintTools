package derp.flinttools.procedures;

import javax.annotation.Nullable;

import derp.flinttools.init.FlintToolsItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

@EventBusSubscriber
public class GravelonStoneProcedure {

    private static final Map<Block, String> validBlocks = Map.of(
            Blocks.STONE, "block.stone.break",
            Blocks.COBBLESTONE, "block.stone.break",
            Blocks.DEEPSLATE, "block.stone.break",
            Blocks.BLACKSTONE, "ambient.basalt_deltas.additions",
            Blocks.TUFF, "block.stone.break"
    );

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getHand() == event.getEntity().getUsedItemHand()) {
            execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
        }
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null || !(entity instanceof LivingEntity livingEntity)) return;

        ItemStack heldItem = livingEntity.getMainHandItem();
        if (!heldItem.is(Items.FLINT)) return;

        BlockPos pos = new BlockPos((int) x, (int) y, (int) z);
        Block blockAtPos = world.getBlockState(pos).getBlock();

        if (!validBlocks.containsKey(blockAtPos)) return;

        if (entity instanceof Player player) {
            ItemStack toRemove = new ItemStack(Items.FLINT);
            // Remove 1 flint from the player's inventory
            player.getInventory().clearOrCountMatchingItems(p -> toRemove.getItem() == p.getItem(), 1, player.inventoryMenu.getCraftSlots());
        }

        if (world instanceof Level level && !level.isClientSide()) {
            spawnFlintPieces(level, x, y + 1.0, z);
        }

        playBreakSound(world, pos, validBlocks.get(blockAtPos));
    }

    private static void spawnFlintPieces(Level level, double x, double y, double z) {
        // 50% chance to spawn two pieces, else spawn one
        int count = Math.random() < 0.5 ? 2 : 1;
        for (int i = 0; i < count; i++) {
            ItemEntity entityToSpawn = new ItemEntity(level, x, y, z, new ItemStack(FlintToolsItems.FLINT_PIECES.get()));
            entityToSpawn.setPickUpDelay(10);
            level.addFreshEntity(entityToSpawn);
        }
    }

    private static void playBreakSound(LevelAccessor world, BlockPos pos, String soundLocation) {
        if (world instanceof Level level) {
            SoundEvent sound = ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(soundLocation));
            if (sound != null) {
                if (!level.isClientSide()) {
                    level.playSound(null, pos, sound, SoundSource.PLAYERS, 1.0F, 2.0F);
                } else {
                    level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), sound, SoundSource.PLAYERS, 1.0F, 2.0F, false);
                }
            }
        }
    }
}
