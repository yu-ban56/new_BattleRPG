package battlerpgloader.mod;

import battlerpg.api.Crash;

public class ModLoadingCrash extends Crash {

    @Override
    public String getSubMessage() {
        return "modloader";
    }

    public ModLoadingCrash() {
        super();
    }

    public ModLoadingCrash(String message) {
        super(message);
    }

    public ModLoadingCrash(Throwable caused) {
        super(caused);
    }
}
