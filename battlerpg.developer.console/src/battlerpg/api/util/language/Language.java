package battlerpg.api.util.language;

import java.util.*;

public class Language {
    Map<String, String> translateData;
    List<String> translateValue;
    String languageName;

    public Language(String languageName) {
        translateData = new HashMap<>();
        translateValue = new ArrayList<>();
        this.languageName = languageName;
    }

    public void addTranslate(Translate t) {
        translateData.put(t.key, t.value);
        translateValue.add(t.key);
    }

    public String getTranslate(String key) {
        return translateData.get(key);
    }

    public void setTranslate(Translate t) {
        translateData.remove(t.key);
        translateData.put(t.key, t.value);
    }
}
