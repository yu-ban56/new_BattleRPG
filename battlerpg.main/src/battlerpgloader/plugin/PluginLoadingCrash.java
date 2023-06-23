package battlerpgloader.plugin;

import battlerpg.api.Crash;

public class PluginLoadingCrash extends Crash {
    @Override
    public String getSubMessage() {
        return "pluginloader";
    }

    public PluginLoadingCrash() {
        super();
    }

    public PluginLoadingCrash(String message) {
        super(message);
    }

    public PluginLoadingCrash(Throwable caused) {
        super(caused);
    }
}
