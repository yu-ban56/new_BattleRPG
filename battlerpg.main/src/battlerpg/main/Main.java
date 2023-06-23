package battlerpg.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Properties;

import battlerpg.api.util.language.*;
import battlerpg.gameplay.GamePlayMain;
import battlerpg.sdk.btcl.BTCLInterpreter;
import battlerpg.sdk.btcl.Compiler;
import battlerpgloader.plugin.PluginLoader;
import battlerpgloader.plugin.PluginXMLLoader;

@SuppressWarnings("all")
public class Main {
    static JFrame messageframe;
    static JDialog saveframe;
    static JDialog shutdownframe;
    static JFrame frame1;
    static JLabel label1;
    static JTextField textbox1;
    public static String Filename;
    private static Language defaultLanguage;
    private static String[] arguments;

    static {
        defaultLanguage = new Language("default");
        defaultLanguage.addTranslate(new Translate("battlerpg.main.frameTitle", "BattleRPG"));
        defaultLanguage.addTranslate(new Translate("battlerpg.main.version", "取得できません。"));
        defaultLanguage.addTranslate(new Translate("battlerpg.messageLogWindowName", "BattleRPG - メッセージログ"));
        defaultLanguage.addTranslate(new Translate("battlerpg.openShutdownoption", "シャットダウンオプションを開く"));
        defaultLanguage.addTranslate(new Translate("battlerpg.forDeveloper", "開発者用"));
        defaultLanguage.addTranslate(new Translate("battlerpg.singleplay", "シングルプレイ"));
        defaultLanguage.addTranslate(new Translate("battlerpg.systemLog.frameTitle", "BattleRPG - システムログ"));
        defaultLanguage.addTranslate(new Translate("battlerpg.menuBar.log", "ログ"));
        defaultLanguage.addTranslate(new Translate("battlerpg.menu.log.message", "メッセージ"));
        defaultLanguage.addTranslate(new Translate("battlerpg.menuBar.help", "ヘルプ"));
        defaultLanguage.addTranslate(new Translate("battlerpg.getSavedata", "どのセーブデータで遊びますか?"));
        defaultLanguage.addTranslate(new Translate("battlerpg.versionInfo", "バージョン情報"));
        defaultLanguage.addTranslate(new Translate("battlerpg.memoryView", "メモリ表示"));
        defaultLanguage.addTranslate(new Translate("battlerpg.menu.log.sys", "システムログ"));
    }
    public static void play(String[] args) {
        arguments = args;
        frame1 = new JFrame(defaultLanguage.getTranslate("battlerpg.main.frameTitle"));
        if(args.length == 2 && args[0].equals("-c")) {
            Compiler.compile(args[1]);
            System.exit(0);
        }
        if(args.length == 2 && args[0].equals("-run")) {
            BTCLInterpreter.run(args[1]);
        }
        if(args.length == 1 && args[0].equals("-m")) {
            PluginLoader.loadPlugin("battlerpgloader.mod.ModLoader");
        }
        if(args.length == 2 && args[0].equals("-m")) {
            PluginLoader.loadPlugin("battlerpgloader.mod.ModLoader", args[1]);
        }
        if(args.length >= 2) {
            if(args[0].equals("-p")) {
                String[] argv = new String[args.length - 2];
                for (int i = 0; i < argv.length; i++) {
                    argv[i] = args[2 + i];
                }
                PluginLoader.loadPlugin(args[1], argv);
            }
        }
        if(args.length == 1 && args[0].equals("-p")) {
            PluginXMLLoader.load();
        }
        if(args.length == 1 && args[0].equals("--load-plugin-XML")) {
            PluginXMLLoader.load();
        }
        Properties p = new Properties();
        String version = defaultLanguage.getTranslate("battlerpg.main.version");
        try {
            FileReader fr = new FileReader("./System.properties");
            p.load(fr);
            version = p.getProperty("battlerpg.version");
        }catch(IOException e) {
            String exceptionMessege = e.getMessage();
            JOptionPane.showMessageDialog(null, exceptionMessege, "BattleRPG - Error", 0);
        }
        messageframe = new JFrame(defaultLanguage.getTranslate("battlerpg.messageLogWindowName"));
        saveframe = new JDialog(frame1);
        saveframe.setTitle(defaultLanguage.getTranslate("battlerpg.systemLog.frameTitle"));
        Container c = new Container();
        ImageIcon icon = new ImageIcon("./battlerpg.main/META-INF/logo.png");
        frame1.setIconImage(icon.getImage());
        saveframe.setIconImage(icon.getImage());
        messageframe.setIconImage(icon.getImage());
        saveframe.setIconImage(icon.getImage());
        label1 = new JLabel(defaultLanguage.getTranslate("battlerpg.getSavedata"));
        textbox1 = new JTextField(10);
        JButton button1 = new JButton("set");
        JButton button2 = new JButton("newGame");
        JButton button5 = new JButton(defaultLanguage.getTranslate("battlerpg.openShutdownoption"));
        saveframe.setSize(480, 220);
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu(defaultLanguage.getTranslate("battlerpg.menuBar.log"));
        Menu menu2 = new Menu(defaultLanguage.getTranslate("battlerpg.menuBar.help"));
        JLabel ver = new JLabel(version);
        MenuItem menu2_1 = new MenuItem(defaultLanguage.getTranslate("battlerpg.versionInfo"));
        menu2_1.addActionListener(e->{
            JLabel label = new JLabel("      BattleRPG " + ver.getText());
            JDialog frame = new JDialog(frame1);
            frame.setLayout(new FlowLayout());
            frame.setTitle("BattleRPG - " + defaultLanguage.getTranslate("battlerpg.versionInfo"));
            if(ver.getText().equals(defaultLanguage.getTranslate("battlerpg.main.version"))) {
                label.setText(ver.getText());
            }else {
                label.setText("      BattleRPG " + ver.getText());
            }
            frame.getContentPane().add(label);
            frame.setSize(300, 100);
            frame.setVisible(true);
        });
        Menu menu3 = new Menu(defaultLanguage.getTranslate("battlerpg.forDeveloper"));
        MenuItem menu3_1 = new MenuItem(defaultLanguage.getTranslate("battlerpg.memoryView"));
        menu3_1.addActionListener(ae->{MemoryUsage.run();});
        menu3.add(menu3_1);
        menuBar.add(menu3);
        MenuItem menuitem = new MenuItem(defaultLanguage.getTranslate("battlerpg.menu.log.message"));
        MenuItem item_1 = new MenuItem(defaultLanguage.getTranslate("battlerpg.menu.log.sys"));
        menu1.add(menuitem);
        menu2.add(menu2_1);
        menu1.add(item_1);
        item_1.addActionListener(e->{saveframe.setVisible(true);});
        menuitem.addActionListener(e->{message(true);});
        menuBar.add(menu1);
        menuBar.add(menu2);
        messageframe.setSize(500,300);
        button1.addActionListener(e->{
            System.out.println("Loading...");

        });
        button5.addActionListener(e->shutdownoption());
        button2.addActionListener(e->{
            JFrame frame = new JFrame("BattleRPG - " + defaultLanguage.getTranslate("battlerpg.singleplay") + ": " + textbox1.getText());
            frame.setIconImage(icon.getImage());
            frame.setLayout(new FlowLayout());
            frame.setSize(600, 200);
            GamePlayMain.launch(frame, textbox1.getText());
        });
        c.add(textbox1);
        c.add(label1);
        c.add(button1);
        c.add(button2);
        c.add(button5);
        c.setLayout(new FlowLayout());
        frame1.setContentPane(c);
        frame1.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (args.length == 2) {
                    PluginLoader.destroyPlugin();
                }
                System.exit(0);
            }
        });
        frame1.setSize(1000, 600);
        frame1.setMenuBar(menuBar);
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
        button.addActionListener(e->{
            if(label.getText().equals("Shutdown")){if(arguments.length == 2) {
                PluginLoader.destroyPlugin();}exit();}
            if(label.getText().equals("Reboot")){reboot();}
        });
        shutdownframe.setSize(400, 100);
        shutdownframe.setVisible(true);
    }

    public static void main(String[] args) {
        play(args);
        frame1.setVisible(true);
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
        play(new String[0]);
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

    public static Language getDefaultLanguage() {
        return defaultLanguage;
    }

    public static void addMainComponent(Component c) {
        frame1.add(c);
    }

    public static void removeMainComponent(Component c) {
        frame1.remove(c);
    }

    public static JFrame getMainFrame() {
        return frame1;
    }
}
