package battlerpg.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.Properties;

@SuppressWarnings("all")
public class Main {
    static JFrame messageframe;
    static JDialog saveframe;
    static JDialog shutdownframe;
    static JFrame frame1;
    static JLabel label1;
    static JTextField textbox1;
    public static String Filename;

    public static void play() {
        Properties p = new Properties();
        try {
            FileReader fr = new FileReader("./System.properties");
            p.load(fr);
        }catch(IOException e) {e.printStackTrace();}
        messageframe = new JFrame("BattleRPG - メッセージログ");
        saveframe = new JDialog(frame1);
        saveframe.setTitle("BattleRPG - ダイアログ");
        String version = new String("alpha 2.2");
        frame1 = new JFrame("BattleRPG");
        Container c = new Container();
        ImageIcon icon = new ImageIcon("./mainicon.png");
        frame1.setIconImage(icon.getImage());
        saveframe.setIconImage(icon.getImage());
        messageframe.setIconImage(icon.getImage());
        saveframe.setIconImage(icon.getImage());
        label1 = new JLabel( "どのセーブデータ遊びますか?");
        textbox1 = new JTextField(10);
        JButton button1 = new JButton("set");
        JButton button2 = new JButton("newGame");
        JButton button5 = new JButton("シャットダウンオプションを開く");
        saveframe.setSize(480, 220);
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("ログ");
        Menu menu2 = new Menu("ヘルプ");
        MenuItem menu2_1 = new MenuItem("バージョン情報");
        menu2_1.addActionListener(e->{
            JFrame frame = new JFrame("BattleRPG - バージョン情報");
            JLabel label = new JLabel("      BattleRPG " + version);
            frame.getContentPane().add(label);
            frame.setSize(480, 220);
            frame.setVisible(true);
        });
        Menu menu3 = new Menu("開発者用");
        MenuItem menu3_1 = new MenuItem("メモリ表示");
        menu3_1.addActionListener(ae->{MemoryUsage.run();});
        menu3.add(menu3_1);
        menuBar.add(menu3);
        MenuItem menuitem = new MenuItem("メッセージ");
        MenuItem item_1 = new MenuItem("ダイアログ");
        menu1.add(menuitem);
        menu2.add(menu2_1);
        menu1.add(item_1);
        item_1.addActionListener(e->{saveframe.setVisible(true);});
        menuitem.addActionListener(e->{message(true);});
        menuBar.add(menu1);
        menuBar.add(menu2);
        messageframe.setSize(500,300);
        button1.addActionListener(e->{
            
        });
        button5.addActionListener(e->{shutdownoption();});
        button2.addActionListener(ae->{
            try {
                FileWriter fw = new FileWriter("./saves/" + textbox1.getText() + "/savedata.config");
                fw.write("dataname = " + textbox1.getText());
                fw.write("path = " + "%appdata%/.gaming/battlerpg/saves/" + textbox1.getText());
                fw.close();
                Path path = Paths.get("../../saves/" + textbox1.getText());
                Files.createDirectory(path);
            }catch(IOException e){e.printStackTrace();System.out.println(e.getMessage());return;}});
        c.add(textbox1);
        c.add(label1);
        c.add(button1);
        c.add(button2);
        c.add(button5);
        c.setLayout(new FlowLayout());
        frame1.setContentPane(c);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(1000, 600);
        frame1.setMenuBar(menuBar);
        frame1.setVisible(true);
    }
    public static void shutdownoption() {
        shutdownframe = new JDialog(frame1);
        JLabel label = new JLabel("Shutdown");
        JButton button = new JButton("OK");
        JMenuBar option_shutdown = new JMenuBar();
        JMenu menu = new JMenu("Option");
        JMenuItem Shutdown = new JMenuItem("Shutdown");
        JMenuItem Reboot = new JMenuItem("Reboot");
        Shutdown.addActionListener(e->{label.setText("Shutdown");

        });
        Reboot.addActionListener(e->{label.setText("Reboot");
            
        });
        menu.add(Shutdown);
        menu.add(Reboot);
        shutdownframe.getContentPane().add(label);
        shutdownframe.getContentPane().add(button);
        option_shutdown.add(menu);
        shutdownframe.setJMenuBar(option_shutdown);
        shutdownframe.setLayout(new FlowLayout());
        button.addActionListener((ActionEvent ae)->{
            if(label.getText().equals("Shutdown")){exit();}
            if(label.getText().equals("Reboot")){reboot();}
        });
        shutdownframe.setSize(400, 100);
        shutdownframe.setVisible(true);
    }


    public static void main(String[] args) {
        play();
    }
    public static void addMessage(String text) {
        JLabel label = new JLabel(text);
        messageframe.getContentPane().add(label);
    }
    public static void exit() {
        System.exit(0);
    }
    public static void message(boolean b) {
        messageframe.setVisible(b);
    }
    public static void reboot() {
        closeallframe();
        frame1 = null;
        messageframe = null;
        saveframe = null;
        shutdownframe = null;
        play();
    }
    public static void addDialog(String text) {
        JLabel label = new JLabel(text);
        saveframe.getContentPane().add(label);
    }
    public static void closeallframe() {
        frame1.setVisible(false);
        messageframe.setVisible(false);
        saveframe.setVisible(false);
        shutdownframe.setVisible(false);
    }
}
