package battlerpg.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

import battlerpg.api.util.language.*;
import battlerpg.gameplay.GamePlayMain;
import battlerpg.sdk.btcl.Interpreter;
import battlerpgloader.plugin.PluginLoader;
import battlerpgloader.plugin.PluginXMLLoader;


public class Main {
    static {
        new MemoryUsage();
        System.gc();
    }
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
        if(args.length == 2 && args[0].equals("-run")) {
            Interpreter.compile(args[1]);
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
        ImageIcon icon = new ImageIcon("META-INF/logo.png");
        try {
            if (!new File("saves").exists()) if (!new File("saves").exists()) Files.createDirectory(Paths.get("saves"));
            FileReader fr = new FileReader("./System.properties");
            p.load(fr);
            version = p.getProperty("battlerpg.version");
        }catch(IOException e) {
            String exceptionMessege = e.getMessage();
            JOptionPane.showMessageDialog(null, exceptionMessege, "BattleRPG - Error", JOptionPane.ERROR_MESSAGE, icon);
        }
        messageframe = new JFrame(defaultLanguage.getTranslate("battlerpg.messageLogWindowName"));
        saveframe = new JDialog(frame1);
        saveframe.setTitle(defaultLanguage.getTranslate("battlerpg.systemLog.frameTitle"));
        Container c = new Container();
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
            if (!new File("saves/" + textbox1.getText()).exists()) {
                try {
                    Files.createDirectory(Paths.get("saves/" + textbox1.getText()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
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
                } else if (args.length == 1) {
                    PluginLoader.destroyPlugin();
                }
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
        Shutdown.addActionListener(e->{label.setText("Shutdown");

        });
        menu.add(Shutdown);
        shutdownframe.getContentPane().add(label);
        shutdownframe.getContentPane().add(button);
        option_shutdown.add(menu);
        shutdownframe.setJMenuBar(option_shutdown);
        shutdownframe.setLayout(new FlowLayout());
        button.addActionListener(e->{
            if (label.getText().equals("Shutdown")) if (arguments.length == 2) PluginLoader.destroyPlugin();
        });
        shutdownframe.setSize(400, 100);
        shutdownframe.setVisible(true);
    }
    private static JTextArea console = new JTextArea("Starting BattleRPG Console.\n\n");

    public static void main(String[] args) {
        JScrollPane scroll = new JScrollPane(console);
        JLabel comm = new JLabel();
        play(args);
        try{Class.forName("battlerpgloader.mod.ModLoader");}catch(Exception e){e.printStackTrace();}
        if(args.length == 0) {
            JFrame frame = new JFrame("BattleRPG Console");
            JTextField enter = new JTextField();
            console.setEditable(false);
            enter.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (e.getKeyChar() == '\n') {
                        runStatement(enter.getText());
                        comm.setText(enter.getText());
                        enter.setText("");
                        frame.repaint();
                    }
                }
            });
            enter.addMouseWheelListener(e->enter.setText(comm.getText()));
            enter.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        enter.setText(comm.getText());
                    }
                }
            });

            frame.setMinimumSize(new Dimension(600, 200));
            frame.setSize(900, 300);
            JPanel c = new JPanel(new BorderLayout());
            c.add(console, BorderLayout.CENTER);
            frame.setLayout(new BorderLayout());
            frame.add(enter, BorderLayout.SOUTH);
            frame.add(c, BorderLayout.CENTER);
            c.add(scroll, BorderLayout.EAST);
            c.setSize(frame.getWidth(), frame.getHeight() - enter.getHeight());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } else if (args.length >= 1 && Arrays.stream(args).toList().contains("nogui")) {
            for (;;) {
                System.out.print("console>");
                String enter = new Scanner(System.in).nextLine();
                System.out.println();
                runStatement(enter);
            }
        }
    }

    public static void runStatement(String str) {
        String[] statement = str.split(" ");
        if (statement[0].equals("load")) {
            if (statement[1].equals("plugin")) {
                append("Load Plugin...");
                PluginLoader.loadPlugin(statement[2]);
            } else if (statement[1].equals("class")){
                try {
                    append("Load Class...");
                    Class.forName(statement[2]);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } else if (statement[0].equals("launch")) {
            frame1.setVisible(true);
        } else if (statement[0].equals("destroy")) {
            frame1.setVisible(false);
        } else if (statement[0].equals("echo")) {
            append(statement[1]);
        } else if (statement[0].equals("script")) {
            if (statement[1].equals("shell")) {
                Interpreter.runningStatement(statement[2]);
            } else if (statement[1].equals("run")) {
                Interpreter.compile(statement[2]);
            } else if (statement[1].equals("help")) {
                append("BattleRPG Console Script Command v0.1");
                append("\n run - Running Script File.\n shell - Running Script.");
            } else {
                append("BattleRPG Console Script Command v0.1");
                append("\n run - Running Script File.\n shell - Running Script.");
            }
        } else if (statement[0].equals("exit")) {
            System.exit(0);
        } else if (statement[0].equals("cat")) {
            if (statement[1].equals("arch")) {
                append(System.getProperty("os.arch"));
            } else if (statement[1].equals("memory")) {
                if (statement[2].equals("free")) {
                    append(Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
                } else if (statement[2].equals("total")) {
                    append(Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
                } else if (statement[2].equals("max")) {
                    append(Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
                } else if (statement[2].equals("usage")) {
                    append((Runtime.getRuntime().totalMemory() / 1024 / 1024 - Runtime.getRuntime().freeMemory() / 1024 / 1024) + "M / " + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
                }
            } else if (statement[1].equals("ver")) {
                if (statement[2].equals("jvm")) {
                    append(System.getProperty("java.vm.version") + "(" + System.getProperty("java.vendor") + ")");
                } else if (statement[2].equals("java")) {
                    append(System.getProperty("java.version"));
                }
            } else if (statement[1].equals("os")) {
                append(System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ")");
            }
        } else if (statement[0].equals("system")) {
            if (statement[1].equals("gc")) {
                append("Request Garbage Collection...");
                System.gc();
            } else if (statement[1].equals("get")) {
                append(System.getProperty(statement[2]));
            }
        } else append("そのような構文はありません。");
    }

    private static void append(String msg) {
        console.append(msg + "\n");
        System.out.println(msg);
    }
    public static void addMessage(String text) {
        JLabel label = new JLabel(text);
        messageframe.add(label);
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
        System.gc();
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
