package battlerpg.save;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import battlerpg.resources.materials.*;

public class Loader {
    public static final List<Monster> monsters = new ArrayList<>();
    public static final List<Characterr> characters = new ArrayList<>();

    public static void loadAll(String profileName) {
        try(ObjectInputStream heroReader = new ObjectInputStream(new FileInputStream(profileName + "/data/hero.bta"));ObjectInputStream wizardReader = new ObjectInputStream(new FileInputStream(profileName + "/data/wizard.bta"))) {
            characters.add((Characterr) heroReader.readObject());
        }catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
