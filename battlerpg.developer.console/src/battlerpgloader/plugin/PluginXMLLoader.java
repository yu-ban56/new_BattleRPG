package battlerpgloader.plugin;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;

public class PluginXMLLoader {
    public static void load() {
        try(InputStream is = new FileInputStream("ext.xml")) {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
            Element e = doc.getDocumentElement();
            NodeList node = e.getChildNodes();
            for (int i = 0; i < node.getLength(); i++) {
                if(node.item(i) instanceof Element child) {
                    if(child.getTagName().equals("load") && child.getAttribute("type").equals("plugin")) {
                        PluginLoader.loadPlugin(child.getAttribute("mainClass"));
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
