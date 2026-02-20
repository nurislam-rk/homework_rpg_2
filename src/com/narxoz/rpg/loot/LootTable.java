package com.narxoz.rpg.loot;

import java.util.List;

public interface LootTable {
    List<String> getPossibleLoot();

    void displayLoot();

    List<String> dropLoot();

    LootTable clone();
}