package net.ben.tutorialmod.item;

import net.ben.tutorialmod.TutorialMod;
import net.ben.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    // Use Identifier.of() instead of new Identifier() for 1.21.1+
    public static final Identifier RUBY_ID = Identifier.of(TutorialMod.MOD_ID, "ruby");

    // Create a RegistryKey for the ItemGroup
    public static final RegistryKey<ItemGroup> RUBY_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), RUBY_ID);

    // Create the actual ItemGroup
    public static final ItemGroup RUBY_GROUP = FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.ruby"))
            .icon(() -> new ItemStack(ModItems.RUBY))
            .entries((displayContext, entries) -> {

                entries.add(ModItems.RUBY); // Add Ruby item to the group
                entries.add(ModItems.RAW_RUBY);
                entries.add(ModBlocks.RUBY_BLOCK);
                entries.add(ModBlocks.RAW_RUBY_BLOCK);
            })
            .build();

    // Register the item group
    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, RUBY_GROUP_KEY, RUBY_GROUP);
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
