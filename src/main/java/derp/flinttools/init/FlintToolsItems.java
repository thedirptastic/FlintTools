package derp.flinttools.init;

import derp.flinttools.FlintTools;
import derp.flinttools.item.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FlintToolsItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, FlintTools.MODID);
    public static final RegistryObject<Item> FLINT_KNIFE = REGISTRY.register("flint_knife", FlintKnifeItem::new);
    public static final RegistryObject<Item> FLINT_PICKAXE = REGISTRY.register("flint_pickaxe", FlintPickaxeItem::new);
    public static final RegistryObject<Item> FLINT_AXE = REGISTRY.register("flint_axe", FlintAxeItem::new);
    public static final RegistryObject<Item> FLINT_PIECES = REGISTRY.register("flint_pieces", FlintPiecesItem::new);
    public static final RegistryObject<Item> GRASS_PIECES = REGISTRY.register("grass_pieces", GrassPiecesItem::new);
    public static final RegistryObject<Item> GRASS_FIBER = REGISTRY.register("grass_fiber", GrassFiberItem::new);
}
