package derp.flinttools.procedures;

import derp.flinttools.init.FlintToolsItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class FlintKnifeBlockDestroyedWithToolProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        BlockPos pos = new BlockPos((int) x, (int) y, (int) z);
        if (world.getBlockState(pos).getBlock() == Blocks.GRASS
                || world.getBlockState(pos).getBlock() == Blocks.TALL_GRASS
                || world.getBlockState(pos).getBlock() == Blocks.FERN) {

            if (Math.random() < 0.25 && world instanceof Level level && !level.isClientSide()) {
                ItemEntity entityToSpawn = new ItemEntity(level, x, y + 1.0, z,
                        new ItemStack(FlintToolsItems.GRASS_PIECES.get()));
                entityToSpawn.setPickUpDelay(10);
                level.addFreshEntity(entityToSpawn);
            }
        }
    }
}
