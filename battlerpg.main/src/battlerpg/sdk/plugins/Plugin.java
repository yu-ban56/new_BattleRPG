package battlerpg.sdk.plugins;

import battlerpg.api.plugin.PluginType;
import battlerpg.sdk.*;

public abstract class Plugin implements Software{

    public void starting() {

    }

    public abstract void init(String... args);

    public void destroy() {

    }

    public PluginType getPluginType() {
        return PluginType.EXTENDS_PROGRAM;
    }

    public void runThread() {

    }
}
