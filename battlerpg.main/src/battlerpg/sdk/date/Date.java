package battlerpg.sdk.date;

import java.text.SimpleDateFormat;

public class Date {
    long date;
    public Date() {
        date = System.currentTimeMillis();
    }
    public Date(long date) {
        this.date = date;
    }
    public String format(String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(new java.util.Date(date));
    }
}
