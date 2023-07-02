package battlerpg.resources.effect;

import java.util.HashMap;
import java.util.Map;

public class EffectRegister {
    static {
        effect = new HashMap<>();
    }
    private static final Map<String, EffectInfluenceDTO>effect;
    public EffectRegister registerChain(String effectName, EffectInfluenceDTO effect) {
        EffectRegister.effect.put(effectName, effect);
        return this;
    }

    public EffectInfluenceDTO register(String effectName, EffectInfluenceDTO effect) {
        return EffectRegister.effect.put(effectName, effect);
    }

    public static EffectInfluenceDTO getEffect(String effectName) {
        return effect.get(effectName);
    }
}
