package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;

public class Goblin implements Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<Ability> abilities;
    private LootTable lootTable;

    public Goblin(String name, int health, int damage, int defense, int speed,
                  String element, List<Ability> abilities, LootTable lootTable) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = abilities;
        this.lootTable = lootTable;
    }

    @Override
    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getHealth() { return health; }

    @Override
    public int getDamage() { return damage; }

    @Override
    public int getDefense() { return defense; }

    @Override
    public int getSpeed() { return speed; }

    @Override
    public List<Ability> getAbilities() { return abilities; }

    @Override
    public LootTable getLootTable() { return lootTable; }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Goblin) ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("Abilities (" + abilities.size() + "): " + abilities);
        System.out.println("Loot: " + lootTable);
    }

    @Override
    public void multiplyStats(double multiplier) {
        this.health = (int)(health * multiplier);
        this.damage = (int)(damage * multiplier);
        this.defense = (int)(defense * multiplier);
        this.speed = (int)(speed * multiplier);
    }

    @Override
    public Enemy clone() {
        List<Ability> clonedAbilities = abilities.stream()
                .map(Ability::clone)
                .toList();
        LootTable clonedLoot = lootTable;

        return new Goblin(name, health, damage, defense, speed, element,
                clonedAbilities, clonedLoot);
    }
}
