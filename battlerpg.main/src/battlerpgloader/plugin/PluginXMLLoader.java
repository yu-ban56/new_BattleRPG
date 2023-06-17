package battlerpgloader.plugin;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class PluginXMLLoader {
    public static void load() {
        try(InputStream is = new FileInputStream("ext.xml")) {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
            Element e = doc.getDocumentElement();
            NodeList node = e.getChildNodes();
            for (int i = 0; i < node.getLength(); i++) {
                if(node.item(i) instanceof Element child) {
                    if(child.getTagName().equals("load") && child.getAttribute("type").equals("plugin")) {
                        Loader.loadPlugin(child.getAttribute("mainClass"));
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
