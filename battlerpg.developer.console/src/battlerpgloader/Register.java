package battlerpgloader;

import battlerpg.sdk.mods.Mod;
import battlerpg.sdk.plugins.Plugin;

public class Register {
    public static RegisterObject<Plugin> registerPlugin(Plugin p) {
        return RegisterObject.getPluginInstance(p);
    }

    public static RegisterObject<Mod> registerMod(Mod mod) {
        return RegisterObject.getModInstance(mod);
    }
}
