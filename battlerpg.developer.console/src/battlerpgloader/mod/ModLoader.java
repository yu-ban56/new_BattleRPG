package battlerpgloader.mod;

import battlerpg.api.loader.LoaderRegister;
import battlerpg.api.util.language.Translate;
import battlerpg.main.Main;
import battlerpg.sdk.mods.Mod;
import battlerpg.sdk.plugins.Plugin;
import battlerpgloader.Register;
import battlerpgloader.RegisterObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * このクラスは、BattleRPGプラグインベースのModローダです。
 * @see battlerpg.sdk.mods.Mod
 * @see battlerpgloader.plugin.PluginLoader
 */
@SuppressWarnings("deprecation")
public class ModLoader extends Plugin {
    static {
        LoaderRegister.register("mod", ModLoader.class.getName());
    }
    final ArrayList<String> arrayString = new ArrayList<>();
    final ArrayList<RegisterObject<Mod>> arrayMods = new ArrayList<>();
    public void modLoad(String modClassName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> modClass = Class.forName(modClassName);
        RegisterObject<Mod> regMod = Register.registerMod((Mod) modClass.getConstructor().newInstance());
        regMod.getRegisterObject().init();
        arrayMods.add(regMod);
    }
    public void modListLoad() {
        try(InputStream is = new FileInputStream("ext.xml")) {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
            Element mod_loading = doc.getDocumentElement();
            NodeList node = mod_loading.getChildNodes();
            for (int i = 0; i < node.getLength(); i++) {
                if(node.item(i) instanceof Element child) {
                    if(child.getTagName().equals("load")) {
                        if(child.getAttribute("type").equals("mod")) {
                            modLoad(child.getAttribute("mainClass"));
                            arrayString.add(child.getAttribute("mainClass"));
                        }
                    }
                }
            }
        }catch(Exception e) {
            throw new ModLoadingCrash(e);
        }
    }

    @Override
    public void init(String... args) {
        Main.getDefaultLanguage().setTranslate(new Translate("battlerpg.modList.dialogTitle", "BattleRPG Modローダ - mod リスト"));
        if(args.length == 1) {
            try {
                modLoad(args[0]);
            } catch (Exception e) {
                throw new ModLoadingCrash(e);
            }
        }else modListLoad();
        outModList();
    }

    public void outModList() {
        try(BufferedWriter out = new BufferedWriter(new FileWriter("modList.html"))) {
            if (!new File("./.mod").exists()) Files.createDirectory(Paths.get(".mod"));
            if (!new File("./.mod/modDoc").exists()) Files.createDirectory(Paths.get(".mod/modDoc"));
            out.write("<!DOCTYPE html>\n");
            out.write("<html>\n");
            out.write("     <head>\n");
            out.write("         <title>BattleRPG modList</title>\n");
            out.write("     </head>\n     <body>\n");
            out.write("         <h1>BattleRPG ModLoader ModList</h1>\n");
            int i = 0;
            for(RegisterObject<Mod> s : arrayMods) {
                out.write("         <a href=\".mod/modDoc/" + arrayMods.get(i).getRegisterObject().getModName() + ".htm\">" + s.getRegisterObject().getModName() + "</a><br>\n");
                i++;
            }
            out.write("     <br><br><p>Copyright <a href=\"https://github.com/yu-ban56\">yu-ban56</a>.</p>");
            out.write("     </body>\n</html>");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        for (int i = 0; i < arrayString.size(); i++) {
            try(BufferedWriter out = new BufferedWriter(new FileWriter(".mod/modDoc/" + arrayMods.get(i).getRegisterObject().getModName() + ".htm"))) {
                out.write("<!DOCTYPE html>\n");
                out.write("<html>\n     <head>\n        <meta charset=\"windows-31j\">\n         <title>BattleRPG Mods - " + arrayMods.get(i).getRegisterObject().getModName() + "</title>\n      </head>");
                out.write("\n       <body>\n            \n");
                out.write("<p>Mod ID: " + arrayMods.get(i).getRegisterObject().getModId() + "</p><br>\n");
                out.write("<p>Desc: <br>" + arrayMods.get(i).getRegisterObject().getDesc() + "</p><br>");
                out.write("<p>URL: <a href=\"" + arrayMods.get(i).getRegisterObject().getURL() + "\">" + arrayMods.get(i).getRegisterObject().getModName() + "</>");
                out.write("<a href=\"../../modList.html\">Return Modlist</a>\n");
                out.write("     </body>\n</html>");
            }catch(IOException e) {e.printStackTrace();return;}
        }
        JButton show = new JButton("mods");
        show.addActionListener(e->{
            JDialog showDialog = new JDialog(Main.getMainFrame());
            showDialog.setTitle(Main.getDefaultLanguage().getTranslate("battlerpg.modList.dialogTitle"));
            showDialog.setLayout(new FlowLayout());
            for(String s : arrayString) {
                showDialog.add(new JLabel(s + " , "));
            }
            showDialog.setSize(900, 300);
            showDialog.pack();
            showDialog.setVisible(true);
        });
        Main.getMainFrame().getContentPane().add(show);
    }

    @Override
    public void destroy() {
        arrayMods.forEach(a -> a.getRegisterObject().destroy());
    }

    protected void finalize() {
        destroy();
    }
}
