package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class FireLootTable implements LootTable {

    private List<String> lootItems;

    public FireLootTable() {
        this.lootItems = new ArrayList<>();
        lootItems.add("Flame Core");
        lootItems.add("Burning Blade");
        lootItems.add("Molten Armor Shard");
        lootItems.add("Ember Essence");
    }

    private FireLootTable(List<String> lootItems) {
        this.lootItems = lootItems;
    }

    @Override
    public List<String> getPossibleLoot() {
        return new ArrayList<>(lootItems);
    }

    @Override
    public void displayLoot() {
        System.out.println("Loot Table (Fire):");
        for (String item : lootItems) {
            System.out.println(" - " + item);
        }
    }

    @Override
    public List<String> dropLoot() {
        List<String> loot = new ArrayList<>();
        loot.add("Fire Gem");
        loot.add("Flame Sword");
        loot.add("Burning Armor");
        return loot;
    }

    @Override
    public LootTable clone() {
        return new FireLootTable(new ArrayList<>(this.lootItems)); 
    }
}


