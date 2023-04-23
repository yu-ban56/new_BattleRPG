package battlerpg.main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class marketplace {
    public void start() {
        SimpleDateFormat simple = new SimpleDateFormat("today is yyyy年 dd日");
        System.out.println(simple.format(new Date()));
    }
}
