package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class GameEnemy implements Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private List<Ability> abilities;
    private LootTable lootTable;
    private String element;

    public GameEnemy(String name, int health, int damage, int defense, int speed,
                     List<Ability> abilities, LootTable lootTable, String element) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.abilities = abilities != null ? new ArrayList<>(abilities) : new ArrayList<>();
        this.lootTable = lootTable;
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
    public List<Ability> getAbilities() {
        return new ArrayList<>(abilities);
    }

    @Override
    public LootTable getLootTable() { return lootTable; }

    @Override
    public void displayInfo() {
        System.out.println("=== Enemy Info ===");
        System.out.println("Name: " + name + " | Element: " + element);
        System.out.println("Health: " + health + " | Damage: " + damage + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Abilities:");
        for (Ability ability : abilities) {
            System.out.println(" - " + ability.getName() + " (" + ability.getType() + ") - " + ability.getDescription());
        }
        if (lootTable != null) {
            lootTable.displayLoot();
        } else {
            System.out.println("No loot table assigned.");
        }
        System.out.println("==================");
    }

    @Override
    public void setElement(String element) { this.element = element; }

    @Override
    public void multiplyStats(double multiplier) {
        this.health = (int) (this.health * multiplier);
        this.damage = (int) (this.damage * multiplier);
        this.defense = (int) (this.defense * multiplier);
        this.speed = (int) (this.speed * multiplier);
    }

    @Override
    public Enemy clone() {
        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability ability : this.abilities) {
            clonedAbilities.add(ability.clone());
        }

        LootTable clonedLoot = null;
        if (this.lootTable != null) {
            clonedLoot = this.lootTable.clone();
        }

        return new GameEnemy(this.name, this.health, this.damage, this.defense, this.speed,
                clonedAbilities, clonedLoot, this.element);
    }

}
