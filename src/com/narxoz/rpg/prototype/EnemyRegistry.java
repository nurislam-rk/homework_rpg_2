package com.narxoz.rpg.prototype;

import com.narxoz.rpg.enemy.Enemy;
import java.util.HashMap;
import java.util.Map;

public class EnemyRegistry {

    private final Map<String, Enemy> templates = new HashMap<>();

    public void register(String key, Enemy enemy) { templates.put(key, enemy); }

    public Enemy create(String key) { return templates.get(key).clone(); }
}
