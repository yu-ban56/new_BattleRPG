package battlerpg.api.loader;

import java.util.ArrayList;
import java.util.HashMap;

public class LoaderRegister {
    private static final HashMap<String, String> reg = new HashMap<>();
    public static void register(String loaderName, String loaderClassName) {
        reg.put(loaderName, loaderClassName);
    }

    public static String get(String loaderName) {
        return reg.get(loaderName);
    }

    public static HashMap<String, String> getRegister() {
        return reg;
    }
}
