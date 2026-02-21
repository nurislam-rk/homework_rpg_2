package com.narxoz.rpg;

import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.factory.ShadowComponentFactory;
import com.narxoz.rpg.prototype.EnemyRegistry;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        // ================================================
        // PART 1: ABSTRACT FACTORY - Themed Components
        // ================================================
        FireComponentFactory fireFactory = new FireComponentFactory();
        IceComponentFactory iceFactory = new IceComponentFactory();
        ShadowComponentFactory shadowFactory = new ShadowComponentFactory();

        System.out.println("Fire abilities + loot:");
        fireFactory.createAbilities().forEach(a -> System.out.println(" - " + a.getName()));
        System.out.println("Loot: " + fireFactory.createLootTable().dropLoot() + "\n");

        System.out.println("Ice abilities + loot:");
        iceFactory.createAbilities().forEach(a -> System.out.println(" - " + a.getName()));
        System.out.println("Loot: " + iceFactory.createLootTable().dropLoot() + "\n");

        System.out.println("Shadow abilities + loot:");
        shadowFactory.createAbilities().forEach(a -> System.out.println(" - " + a.getName()));
        System.out.println("Loot: " + shadowFactory.createLootTable().dropLoot() + "\n");

        // ================================================
        // PART 2: BUILDER - Complex Enemy Construction
        // ================================================
        Enemy goblin = new BasicEnemyBuilder()
                .setName("Goblin Grunt")
                .setHealth(100)
                .setDamage(20)
                .setDefense(5)
                .setSpeed(10)
                .build();

        Enemy fireDragon = new BossEnemyBuilder()
                .setName("Fire Dragon")
                .setHealth(50000)
                .setDamage(500)
                .setDefense(200)
                .setSpeed(50)
                .setElement("FIRE")
                .addAbility(fireFactory.createAbilities().get(0))
                .addAbility(fireFactory.createAbilities().get(1))
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .addPhase(3, 15000)
                .setLootTable(fireFactory.createLootTable())
                .setAI("AGGRESSIVE")
                .setCanFly(true)
                .setBreathAttack(true)
                .setWingspan(20)
                .build();

        System.out.println("\n--- BASIC ENEMY ---");
        goblin.displayInfo();

        System.out.println("\n--- BOSS ENEMY (Fire Dragon) ---");
        fireDragon.displayInfo();

        // ================================================
        // PART 3: PROTOTYPE - Enemy Cloning & Variants
        // ================================================
        EnemyRegistry registry = new EnemyRegistry();
        registry.register("goblin", goblin);
        registry.register("fireDragon", fireDragon);

        Enemy eliteGoblin = registry.create("goblin");
        eliteGoblin.multiplyStats(2.0); 
        eliteGoblin.displayInfo();

        Enemy fireDragonClone = registry.create("fireDragon");
        fireDragonClone.setElement("LAVA");
        fireDragonClone.displayInfo();

        // ================================================
        // PART 4: ALL PATTERNS WORKING TOGETHER
        // ================================================
        Enemy demonLord = new BossEnemyBuilder()
                .setName("Demon Lord")
                .setHealth(80000)
                .setDamage(800)
                .setDefense(300)
                .setSpeed(60)
                .setElement("SHADOW")
                .addAbility(shadowFactory.createAbilities().get(0))
                .addAbility(shadowFactory.createAbilities().get(1))
                .addPhase(1, 80000)
                .addPhase(2, 50000)
                .addPhase(3, 20000)
                .setLootTable(shadowFactory.createLootTable())
                .setAI("CUNNING")
                .setCanFly(true)
                .setBreathAttack(false)
                .setWingspan(30)
                .build();

        registry.register("demonLord", demonLord);

        Enemy greaterDemon = registry.create("demonLord");
        greaterDemon.multiplyStats(2.0);
        greaterDemon.displayInfo();

        System.out.println("\n=== Demo Complete ===");
    }
}
