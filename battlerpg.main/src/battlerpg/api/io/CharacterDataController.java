package battlerpg.api.io;

import battlerpg.resources.characters.Hero;
import battlerpg.resources.materials.Characterr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class CharacterDataController implements AutoCloseable{

    private Document doc;

    private final OutputStream out;

    private final InputStream in;

    public CharacterDataController(File file, boolean append) throws IOException, ParserConfigurationException, SAXException {
        out = new BufferedOutputStream(new FileOutputStream(file, append));
        in = new BufferedInputStream(new FileInputStream(file));
        doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
    }

    public CharacterDataController(File file) throws IOException, ParserConfigurationException, SAXException {
        this(file, false);
    }

    public CharacterDataController(String fileName, boolean append) throws IOException, ParserConfigurationException, SAXException {
        this(new File(fileName), append);
    }

    public CharacterDataController(String fileName) throws IOException, ParserConfigurationException, SAXException {
        this(fileName, false);
    }

    public InputStream getIn() {
        return in;
    }

    public OutputStream getOut() {
        return out;
    }

    public Characterr getCharacter(String characterName) {
        Element characters = doc.getDocumentElement();
        NodeList nodes = characters.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            if(nodes.item(i) instanceof Element child) {
                if(child.getAttribute("name").equals(characterName)) {
                    if(child.getTagName().equals("hero")) {
                        Hero out = new Hero(characterName);
                        out.setHero(Integer.parseInt(child.getAttribute("hp")), Integer.parseInt(child.getAttribute("xp")), Integer.parseInt(child.getAttribute("level")));
                        return out;
                    }
                }
            }
        }
        return null;
    }

    private static Element getChildrenElement(Element e, String name) {
        NodeList node = e.getChildNodes();
        for (int i = 0; i < node.getLength(); i++) {
            if(node.item(i) instanceof Element child) {
                if(child.getTagName().equals(name)) {
                    return child;
                }
            }
        }
        return null;
    }

    public void close() throws IOException {
        out.close();
        in.close();
    }
}
