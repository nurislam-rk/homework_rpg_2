package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class IceLootTable implements LootTable {

    private List<String> lootItems;

    public IceLootTable() {
        this.lootItems = new ArrayList<>();
        lootItems.add("Ice Crystal");
        lootItems.add("Frozen Armor Fragment");
        lootItems.add("Glacial Sword");
        lootItems.add("Snow Essence");
    }

    private IceLootTable(List<String> lootItems) {
        this.lootItems = lootItems;
    }

    @Override
    public List<String> getPossibleLoot() {
        return new ArrayList<>(lootItems);
    }

    @Override
    public void displayLoot() {
        System.out.println("Loot Table (Ice):");
        for (String item : lootItems) {
            System.out.println(" - " + item);
        }
    }

    @Override
    public List<String> dropLoot() {
        List<String> loot = new ArrayList<>();
        loot.add("Ice Crystal");
        loot.add("Frost Sword");
        loot.add("Glacial Armor");
        return loot;
    }

    @Override
    public LootTable clone() {
        return new IceLootTable(new ArrayList<>(this.lootItems)); 
    }
}

