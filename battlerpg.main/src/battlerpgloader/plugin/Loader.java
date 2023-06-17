package battlerpgloader.plugin;

import battlerpg.api.plugin.PluginType;
import battlerpg.sdk.plugins.Plugin;
import battlerpgloader.Register;
import battlerpgloader.RegisterObject;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Loader {

    private static final ArrayList<RegisterObject<Plugin>> registerObject = new ArrayList<>();
    public static void loadPlugin(String pluginClass) {
        try {
            RegisterObject<Plugin> registerObject = Register.registerPlugin((Plugin) ClassLoader.getSystemClassLoader().loadClass(pluginClass).getConstructor().newInstance());
            registerObject.getRegisterObject().init();
            Loader.registerObject.add(registerObject);
            if(registerObject.getRegisterObject().getPluginType() == PluginType.REAL_TIME_PROGRAM) {
                Thread run = new Thread(()->registerObject.getRegisterObject().runThread(), "Plugin Worker " + Loader.registerObject.size());
                run.start();
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void destroyPlugin() {
        registerObject.parallelStream().forEach(a -> a.getRegisterObject().destroy());
    }
}
