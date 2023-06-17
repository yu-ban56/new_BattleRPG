package battlerpg.addon.english;

import battlerpg.api.util.language.Translate;

import static battlerpg.main.Main.*;

@SuppressWarnings("all")
public class Translator {
    public static void main(){
        getDefaultLanguage().setTranslate(new Translate("battlerpg.messageLogWindowName", "BattleRPG - Message Log"));
        getDefaultLanguage().setTranslate(new Translate("battlerpg.openShutdownoption", "Open Shutdown Option"));
        getDefaultLanguage().setTranslate(new Translate("battlerpg.main.version", "Failed Load."));
        getDefaultLanguage().setTranslate(new Translate("battlerpg.forDeveloper", "For Developer"));
        getDefaultLanguage().setTranslate(new Translate("battlerpg.singleplay", "Single Play"));
        getDefaultLanguage().setTranslate(new Translate("battlerpg.systemLog.frameTitle", "BattleRPG - System Log"));
        getDefaultLanguage().setTranslate(new Translate("battlerpg.menuBar.log", "Log"));
        getDefaultLanguage().setTranslate(new Translate("battlerpg.menu.log.message", "Message"));
        getDefaultLanguage().setTranslate(new Translate("battlerpg.menuBar.help", "Help"));
        getDefaultLanguage().setTranslate(new Translate("battlerpg.getSavedata", "What save data are you playing with?"));
        getDefaultLanguage().setTranslate(new Translate("battlerpg.versionInfo", "Version Infomation"));
        getDefaultLanguage().setTranslate(new Translate("battlerpg.memoryView", "Used Memory Info"));
        getDefaultLanguage().setTranslate(new Translate("battlerpg.menu.log.sys", "System Log"));
        getDefaultLanguage().setTranslate(new Translate("battlerpg.modList.dialogTitle", "BattleRPG ModLoader - modList"));
    }
}
