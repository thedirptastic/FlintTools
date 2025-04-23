package derp.flinttools.item;

import derp.flinttools.init.FlintToolsItems;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class FlintAxeItem
        extends AxeItem {
    public FlintAxeItem() {
        super(new Tier() {
            @Override
            public int getUses() {
                return 32;
            }

            @Override
            public float getAttackDamageBonus() {
                return 1.0f;
            }

            @Override
            public float getSpeed() {
                return 0.9f; // You might want a positive value here!
            }

            @Override
            public int getLevel() {
                return 1;
            }

            @Override
            public int getEnchantmentValue() {
                return 0;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(new ItemStack(FlintToolsItems.FLINT_PIECES.get()));
            }
        }, 1.0f, -2.8f, new Item.Properties());
    }
}
