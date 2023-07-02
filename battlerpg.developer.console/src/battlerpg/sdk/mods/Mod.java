package battlerpg.sdk.mods;

import battlerpg.sdk.*;
import org.w3c.dom.Document;

public abstract class Mod implements Software {
    public abstract void init(String... args);

    public void destroy() {}

    public abstract String getModId();

    public abstract String getModName();

    public String getDesc() {return "";}

    public String getURL() {return "None";}
}
