package derp.flinttools.item;

import derp.flinttools.init.FlintToolsItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class FlintKnifeItem extends SwordItem {
    public FlintKnifeItem() {
        super(new Tier() {
            @Override
            public int getUses() {
                return 16;
            }

            @Override
            public float getAttackDamageBonus() {
                return 0.1F;
            }

            @Override
            public float getSpeed() {
                return 0.9F; // might want a positive value here!
            }

            @Override
            public int getLevel() {
                return 0;
            }

            @Override
            public int getEnchantmentValue() {
                return 2;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(new ItemStack(FlintToolsItems.FLINT_PIECES.get()));
            }
        }, 3, -2.3F, new Item.Properties());
    }

    @Override
    public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
        boolean result = super.mineBlock(itemstack, world, blockstate, pos, entity);

        if (!world.isClientSide()) {
            Block block = blockstate.getBlock();
            if (block == Blocks.GRASS || block == Blocks.TALL_GRASS || block == Blocks.FERN) {
                if (Math.random() < 0.25) {
                    ItemStack drop = new ItemStack(FlintToolsItems.GRASS_PIECES.get());
                    ItemEntity entityToSpawn = new ItemEntity(world, pos.getX(), pos.getY() + 1.0, pos.getZ(), drop);
                    entityToSpawn.setPickUpDelay(10);
                    world.addFreshEntity(entityToSpawn);
                }
            }
        }

        return result;
    }
}
