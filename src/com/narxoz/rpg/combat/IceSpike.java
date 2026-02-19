package com.narxoz.rpg.combat;

public class IceSpike implements Ability {

    @Override
    public String getName() { return "Ice Spike"; }

    @Override
    public int getDamage() { return 25; }

    @Override
    public String getDescription() { return "Launches a sharp spike of ice at the enemy."; }

    @Override
    public AbilityType getType() { return AbilityType.DAMAGE; }

    @Override
    public Ability clone() { return new IceSpike(); }
}