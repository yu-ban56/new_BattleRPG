package battlerpg.save.read;

import battlerpg.resources.Field.*;

public class FieldReader implements reader{
    public FieldReader() {
        grasspane gs = new grasspane();
        int[][] grasspane = loadField(gs);
        gs = null;

    }
    public int[][] loadField(Field field) {
        return field.getdimention();
    }
}
