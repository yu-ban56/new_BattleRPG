package battlerpg.main;

import javax.swing.*;
import java.awt.*;

class getMemory extends Thread{
    public void run() {
        JDialog frame = new JDialog(Main.frame1);
        frame.setTitle("BattleRPG - " + Main.getDefaultLanguage().getTranslate("battlerpg.memoryView"));
        Runtime r = Runtime.getRuntime();
        JLabel label = new JLabel();
        JProgressBar progressBar = new JProgressBar(0, (int)(r.maxMemory() / 1024));
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(label);
        frame.getContentPane().add(progressBar);
        frame.setSize(600, 200);
        frame.setVisible(true);
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
@SuppressWarnings("all")
class MemoryUsage {
    public static void run() {
        getMemory thread = new getMemory();
        thread.start();
    }
}
