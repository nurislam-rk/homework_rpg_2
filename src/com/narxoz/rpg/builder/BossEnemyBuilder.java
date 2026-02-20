package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BossEnemyBuilder {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;

    private List<Ability> abilities = new ArrayList<>();
    private Map<Integer, Integer> phases = new HashMap<>();

    private LootTable lootTable;
    private String aiBehavior;

    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    public BossEnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public BossEnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    public BossEnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    public BossEnemyBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    public BossEnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public BossEnemyBuilder setElement(String element) {
        this.element = element;
        return this;
    }

    public BossEnemyBuilder addAbility(Ability ability) {
        this.abilities.add(ability);
        return this;
    }

    public BossEnemyBuilder addPhase(int phaseNumber, int threshold) {
        this.phases.put(phaseNumber, threshold);
        return this;
    }

    public BossEnemyBuilder setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
        return this;
    }

    public BossEnemyBuilder setAI(String aiBehavior) {
        this.aiBehavior = aiBehavior;
        return this;
    }

    public BossEnemyBuilder setCanFly(boolean canFly) {
        this.canFly = canFly;
        return this;
    }

    public BossEnemyBuilder setBreathAttack(boolean hasBreathAttack) {
        this.hasBreathAttack = hasBreathAttack;
        return this;
    }

    public BossEnemyBuilder setWingspan(int wingspan) {
        this.wingspan = wingspan;
        return this;
    }

    public Enemy build() {
        return new DragonBoss(
                name,
                health,
                damage,
                defense,
                speed,
                element,
                abilities,
                phases,
                lootTable,
                aiBehavior,
                canFly,
                hasBreathAttack,
                wingspan
        );
    }
}
