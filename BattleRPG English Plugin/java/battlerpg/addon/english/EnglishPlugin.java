package battlerpg.addon.english;

import battlerpg.api.plugin.PluginType;
import battlerpg.sdk.plugins.*;

public class EnglishPlugin extends Plugin{
    public void init() {
        System.out.print("BattleRPG English Translate Plugin beta 1.0\n\nStarting Translate\n");
        Translator.main();
    }

    public void destroy() {
        System.out.println("\nShutdown English Translate Plugin");
    }

    @Override
    public PluginType getPluginType() {
        return PluginType.LANGUAGE_PACK;
    }
}
