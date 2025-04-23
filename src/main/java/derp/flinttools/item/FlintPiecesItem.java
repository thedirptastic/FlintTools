package derp.flinttools.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;

public class FlintPiecesItem extends Item {
    public FlintPiecesItem() {
        super(new Item.Properties()
                .stacksTo(64)
                .rarity(Rarity.COMMON)
        );
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemstack) {
        return UseAnim.EAT;
    }

    @Override
    public int getUseDuration(ItemStack itemstack) {
        return 0;
    }
}
