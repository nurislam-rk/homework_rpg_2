package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class ShadowLootTable implements LootTable {

    private List<String> lootItems;

    public ShadowLootTable() {
        this.lootItems = new ArrayList<>();
        lootItems.add("Shadow Dagger");
        lootItems.add("Dark Cloak");
        lootItems.add("Night Essence");
        lootItems.add("Cursed Amulet");
    }

    private ShadowLootTable(List<String> lootItems) {
        this.lootItems = lootItems;
    }

    @Override
    public List<String> getPossibleLoot() {
        return new ArrayList<>(lootItems); 
    }

    @Override
    public void displayLoot() {
        System.out.println("Loot Table (Shadow):");
        for (String item : lootItems) {
            System.out.println(" - " + item);
        }
    }

    @Override
    public List<String> dropLoot() {
        List<String> loot = new ArrayList<>();
        loot.add("Shadow Orb");
        loot.add("Dark Dagger");
        loot.add("Cloak of Shadows");
        return loot;
    }

    @Override
    public LootTable clone() {
        return new ShadowLootTable(new ArrayList<>(this.lootItems)); 
    }
}

