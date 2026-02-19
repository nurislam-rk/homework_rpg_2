package com.narxoz.rpg.combat;

public class ShadowStrike implements Ability {

    @Override
    public String getName() { return "Shadow Strike"; }

    @Override
    public int getDamage() { return 35; }

    @Override
    public String getDescription() { return "Strikes from the shadows with critical precision."; }

    @Override
    public AbilityType getType() { return AbilityType.DAMAGE; }

    @Override
    public Ability clone() { return new ShadowStrike(); }
}