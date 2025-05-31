package derp.flinttools.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static derp.flinttools.FlintTools.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FlintToolsTabs {

    private static final DeferredRegister<CreativeModeTab> REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> BASE_CREATIVE_TAB = REGISTER.register("flint_tools_tab",
            () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.flint_tools_tab"))
                            .icon(() -> new ItemStack(FlintToolsItems.FLINT_KNIFE.get()))
                            .displayItems((params, output) -> {
                                output.accept(FlintToolsItems.FLINT_KNIFE.get());
                                output.accept(FlintToolsItems.FLINT_PICKAXE.get());
                                output.accept(FlintToolsItems.FLINT_AXE.get());
                                output.accept(FlintToolsItems.FLINT_PIECES.get());
                                output.accept(FlintToolsItems.GRASS_PIECES.get());
                                output.accept(FlintToolsItems.GRASS_FIBER.get());
                            })
                            .build()
            );

    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}
