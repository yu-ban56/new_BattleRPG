package battlerpg.api.util.language;

import java.util.*;

public class BattleRPGLanguage {
    private static final Map<String, Language> languages;

    static {
        languages = new HashMap<>();
    }

    public static Map<String, Language> getLanguages() {
        return languages;
    }

    public static void addLanguage(Language lang) {
        languages.put(lang.languageName, lang);
    }

    public static Language getLanguage(String languageName) {
        return languages.get(languageName);
    }

    public static Map<String, Language> getLanguageName() {
        return languages;
    }
}
