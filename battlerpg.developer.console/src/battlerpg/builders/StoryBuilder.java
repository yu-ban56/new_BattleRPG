package battlerpg.builders;

import battlerpg.resources.story.Story;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StoryBuilder implements AbstractBattleRPGBuilder{
    private final Map<String, Object> element;
    private int appendCount;

    public StoryBuilder() {
        element = new HashMap<>();
        appendCount = 1;
    }

    public void addElement(String str, Object o) {
        element.put(str, o);
    }

    public void close() {
        appendCount--;
    }

    public Story getStory() {
        return null;
    }
}
