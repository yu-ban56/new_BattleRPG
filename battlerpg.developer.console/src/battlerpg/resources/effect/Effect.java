package battlerpg.resources.effect;


import battlerpg.resources.materials.Creature;

import java.util.*;

public class Effect {
    protected static int effects;

    private final static Map<Creature, String> res;
    private int seconds;
    static {
        res = new HashMap<>();
    }

    public Effect(String effectName, Creature target) {
        res.put(target, effectName);
    }
}
