package derp.flinttools.item;

import derp.flinttools.init.FlintToolsItems;
import derp.flinttools.procedures.FlintKnifeBlockDestroyedWithToolProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
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
        FlintKnifeBlockDestroyedWithToolProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
        return result;
    }
}
