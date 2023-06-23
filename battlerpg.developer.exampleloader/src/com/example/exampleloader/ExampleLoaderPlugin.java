package com.example.exampleloader;

import battlerpg.api.loader.LoaderRegister;
import battlerpg.sdk.plugins.Plugin;
import javax.xml.parsers.*;

import battlerpgloader.RegisterObject;
import org.w3c.dom.*;

import java.io.FileInputStream;
import java.util.ArrayList;

public class ExampleLoaderPlugin extends Plugin {
    static {
        LoaderRegister.register("example", ExampleLoaderPlugin.class.getName());
    }

    private static final ArrayList<ExampleSoftware> regObj = new ArrayList<>();
    @Override
    public void init(String... args) {
        loadSoftware();
    }

    public void loadSoftware() {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new FileInputStream("ext.xml"));
            Element docElement = doc.getDocumentElement();
            NodeList list = docElement.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                if(list.item(i) instanceof Element e && e.getTagName().equals("load") && e.getAttribute("type").equals("example")) {
                    String mainClassName = e.getAttribute("mainClass");
                    ExampleSoftware obj  = (ExampleSoftware) ClassLoader.getSystemClassLoader().loadClass(mainClassName).getConstructor().newInstance();
                    regObj.add(obj);
                }
            }
            regObj.forEach(ExampleSoftware::init);
        } catch (Exception e) {
            throw new ExampleSoftwareLoadingCrash(e);
        }
    }

    @Override
    public void destroy() {
        regObj.forEach(ExampleSoftware::destroy);
    }
}
