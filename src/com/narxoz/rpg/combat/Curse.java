package com.narxoz.rpg.combat;

public class Curse implements Ability {

    @Override
    public String getName() { return "Curse"; }

    @Override
    public int getDamage() { return 0; }

    @Override
    public String getDescription() { return "Curses the enemy, reducing their defense."; }

    @Override
    public AbilityType getType() { return AbilityType.DAMAGE; }

    @Override
    public Ability clone() { return new Curse(); }
}