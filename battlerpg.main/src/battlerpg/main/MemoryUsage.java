package battlerpg.main;

import javax.swing.*;
import java.awt.*;

class getMemory extends Thread{
    public void run() {
        JDialog frame = new JDialog(Main.frame1);
        frame.setTitle("BattleRPG - 開発者用メモリ容量表示");
        Runtime r = Runtime.getRuntime();
        JLabel label = new JLabel();
        JProgressBar progressBar = new JProgressBar(0, (int)(r.maxMemory() / 1028));
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(label);
        frame.getContentPane().add(progressBar);
        frame.setSize(600, 200);
        frame.setVisible(true);
        for(;;) {
            try{
                long totalMBMemory = r.totalMemory() / 1028 / 1028;
                long freeMBMemory = r.freeMemory() / 1028 / 1028;
                long usage = totalMBMemory - freeMBMemory;
                String maxMemory = totalMBMemory + "M";
                label.setText("          " + usage + "M / " + maxMemory);
                progressBar.setValue((int)(r.totalMemory() - r.freeMemory()) / 1028);
            }catch(Exception e){break;}
        }
    }
}
@SuppressWarnings("all")
public class MemoryUsage {
    public static void run() {
        getMemory thread = new getMemory();
        thread.start();
    }
}
