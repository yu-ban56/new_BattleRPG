package battlerpgloader.plugin;

import battlerpg.api.plugin.PluginType;
import battlerpg.sdk.plugins.Plugin;
import battlerpgloader.Register;
import battlerpgloader.RegisterObject;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class PluginLoader {
    private static final ArrayList<RegisterObject<Plugin>> registerObject = new ArrayList<>();
    private static int realTimeCounts = 1;
    public static void loadPlugin(String pluginClass, String... args) {
        try {
            RegisterObject<Plugin> registerObject = Register.registerPlugin((Plugin) ClassLoader.getSystemClassLoader().loadClass(pluginClass).getConstructor().newInstance());
            registerObject.getRegisterObject().init(args);
            PluginLoader.registerObject.add(registerObject);
            if(registerObject.getRegisterObject().getPluginType() == PluginType.REAL_TIME_PROGRAM) {
                Thread run = new Thread(()->registerObject.getRegisterObject().runThread(), "Plugin Worker Thread " + realTimeCounts);
                run.start();
                realTimeCounts++;
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new PluginLoadingCrash(e);
        }
    }
    public static void destroyPlugin() {
        registerObject.forEach(a -> a.getRegisterObject().destroy());
    }

    public static void loadPlugin(Plugin p, String... args) {
        RegisterObject<Plugin> registerObject = Register.registerPlugin(p);
        registerObject.getRegisterObject().init(args);
        if(registerObject.getRegisterObject().getPluginType() == PluginType.REAL_TIME_PROGRAM) {
            Thread run = new Thread(()->registerObject.getRegisterObject().runThread(), "Plugin Worker Thread " + realTimeCounts);
            run.start();
            realTimeCounts++;
        }
    }
}
