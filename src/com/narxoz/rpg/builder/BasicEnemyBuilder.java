package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.GameEnemy;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class BasicEnemyBuilder implements EnemyBuilder {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;
    private String element = "None";

    @Override
    public EnemyBuilder setName(String name) { this.name = name; return this; }

    @Override
    public EnemyBuilder setHealth(int health) { this.health = health; return this; }

    @Override
    public EnemyBuilder setDamage(int damage) { this.damage = damage; return this; }

    @Override
    public EnemyBuilder setDefense(int defense) { this.defense = defense; return this; }

    @Override
    public EnemyBuilder setSpeed(int speed) { this.speed = speed; return this; }

    @Override
    public EnemyBuilder setAbilities(List<Ability> abilities) { this.abilities = abilities; return this; }

    @Override
    public EnemyBuilder setLootTable(LootTable loot) { this.lootTable = loot; return this; }

    public EnemyBuilder setElement(String element) { this.element = element; return this; }

    @Override
    public Enemy build() {
        return new GameEnemy(name, health, damage, defense, speed, abilities, lootTable, element);
    }

}
