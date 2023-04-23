package battlerpg.builders;

import battlerpg.resources.story.Story;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class StoryBuilder implements AbstractBattleRPGBuilder{
    private final ArrayList<Object> element;
    private int appendCount;

    public StoryBuilder() {
        element = new ArrayList<>();
        appendCount = 1;
    }

    public void addElement(Object o) {
        element.add(o);
    }

    public void addElement(String str, Object o) {
        Object obj = element.get(element.size() - 1);
        if(obj instanceof LinkedHashMap) {
            Map map = (LinkedHashMap<?, ?>)obj;
            map.put(str, o);
        }
    }

    public void open() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        element.add(map);
        appendCount++;
    }

    public void close() {
        appendCount--;
    }

    public Story getStory() {
        return null;
    }
}
