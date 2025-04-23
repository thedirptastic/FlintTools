package derp.flinttools.item;

import derp.flinttools.init.FlintToolsItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class FlintPickaxeItem extends PickaxeItem {
    public FlintPickaxeItem() {
        super(new Tier() {
            @Override
            public int getUses() {
                return 32;
            }

            @Override
            public float getAttackDamageBonus() {
                return 1.0F;
            }

            @Override
            public float getSpeed() {
                return 1.2F; // likely a mistake — usually positive like 2.0F+
            }

            @Override
            public int getLevel() {
                return 1; // Iron-level
            }

            @Override
            public int getEnchantmentValue() {
                return 0;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(new ItemStack(FlintToolsItems.FLINT_PIECES.get()));
            }
        }, 1, -2.8F, new Item.Properties());
    }
}
