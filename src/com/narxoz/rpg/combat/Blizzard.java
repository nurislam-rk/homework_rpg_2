package com.narxoz.rpg.combat;

public class Blizzard implements Ability {

    @Override
    public String getName() { return "Blizzard"; }

    @Override
    public int getDamage() { return 60; }

    @Override
    public String getDescription() { return "Summons a powerful snowstorm damaging all enemies."; }

    @Override
    public AbilityType getType() { return AbilityType.DAMAGE; }

    @Override
    public Ability clone() { return new Blizzard(); }
}