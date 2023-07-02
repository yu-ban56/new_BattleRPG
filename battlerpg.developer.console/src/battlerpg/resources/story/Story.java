package battlerpg.resources.story;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Story {
    private final ArrayList<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }
    public Iterator<?> get() {
        return list.iterator();
    }
}
