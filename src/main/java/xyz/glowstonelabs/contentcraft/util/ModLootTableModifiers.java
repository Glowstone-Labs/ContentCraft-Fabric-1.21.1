package xyz.glowstonelabs.contentcraft.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;

import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import xyz.glowstonelabs.contentcraft.init.ModItems;

import javax.smartcardio.CardTerminal;

public class ModLootTableModifiers {
    private static final Identifier CARROTS_ID
            = Identifier.of("minecraft", "blocks/carrots");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {
            if(CARROTS_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f)) // Drops 2% of the time
                        .with(ItemEntry.builder(ModItems.POISONOUS_CARROT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
    }

    //all this shit just for a poisonous carrot -_-
}
