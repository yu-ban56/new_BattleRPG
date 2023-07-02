package battlerpg.main;

import javax.swing.*;
import java.awt.*;

import static battlerpg.main.getMemory.frame;

class getMemory extends Thread{
    static JDialog frame;
    public void run() {
        frame = new JDialog(Main.frame1);
        frame.setTitle("BattleRPG - " + Main.getDefaultLanguage().getTranslate("battlerpg.memoryView"));
        Runtime r = Runtime.getRuntime();
        JLabel label = new JLabel();
        JProgressBar progressBar = new JProgressBar(0, (int)(r.maxMemory() / 1024));
        frame.setLayout(new BorderLayout());
        frame.add(label, BorderLayout.WEST);
        frame.add(progressBar, BorderLayout.EAST);
        frame.setSize(600, 200);
        for(;;) {
            try{
                long maxMBMemory = r.totalMemory() / 1024 / 1024;
                long freeMBMemory = r.freeMemory() / 1024 / 1024;
                long usage = r.totalMemory() / 1024 / 1024 - freeMBMemory;
                String maxMemory = maxMBMemory + "M";
                label.setText("          " + usage + "M / " + maxMemory);
                progressBar.setValue((int)(r.totalMemory() - r.freeMemory()) / 1024);
            }catch(Exception e){break;}
        }
    }
}
class MemoryUsage {
    static {
        getMemory thread = new getMemory();
        thread.setName("Memory Usage Thread");
        thread.start();
    }
    public static void run() {
        frame.setVisible(true);
    }
}
