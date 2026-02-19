package com.narxoz.rpg.combat;

public class Fireball implements Ability {

    @Override
    public String getName() { return "Fireball"; }

    @Override
    public int getDamage() { return 40; }

    @Override
    public String getDescription() { return "Throws a fireball at the enemy."; }

    @Override
    public AbilityType getType() { return AbilityType.DAMAGE; }

    @Override
    public Ability clone() { return new Fireball(); }
}