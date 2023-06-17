package battlerpg.addon.logging;

import battlerpg.api.plugin.PluginType;
import battlerpg.sdk.plugins.Plugin;

import battlerpg.api.util.logging.Logger;

import java.util.Iterator;
import java.util.Map;

public class LoggingPlugin extends Plugin {

    Logger log;
    @Override
    public void init() {
        log = Logger.getInstance();
        log.info("Starting BattleRPG");
    }

    @Override
    public PluginType getPluginType() {
        return PluginType.REAL_TIME_PROGRAM;
    }

    @Override
    public void destroy() {
        log.info("Shutdown BattleRPG");
    }

    public void runThread() {
        for (;;) {
            Map<Thread, StackTraceElement[]> m = Thread.getAllStackTraces();
            Iterator<Thread> it = m.keySet().iterator();
            for (int i = 0; i < m.keySet().size()||it.hasNext(); i++) {
                StackTraceElement[] elements = m.get(it.next());
                for (StackTraceElement s : elements) {
                    log.info(s.toString());
                }
            }
        }
    }
}
