package battlerpgloader;


import battlerpg.sdk.Software;
import battlerpg.sdk.mods.Mod;
import battlerpg.sdk.plugins.Plugin;

public class RegisterObject<E extends Software> {
    private E obj;
    protected static RegisterObject<Plugin> getPluginInstance(Plugin p) {
        RegisterObject<Plugin> registerObject = new RegisterObject<>();
        registerObject.obj = p;
        return registerObject;
    }

    public E getRegisterObject() {
        return obj;
    }

    protected static RegisterObject<Mod> getModInstance(Mod mod) {
        RegisterObject<Mod> registerObject = new RegisterObject<>();
        registerObject.obj = mod;
        return registerObject;
    }
}
