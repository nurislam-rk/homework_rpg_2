package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.*;
import java.util.ArrayList;
import java.util.List;

public class IceComponentFactory implements EnemyComponentFactory {

    @Override
    public List<Ability> createAbilities() {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new IceSpike());
        abilities.add(new Blizzard());
        return abilities;
    }

    @Override
    public LootTable createLootTable() {
        return new IceLootTable();
    }
}
