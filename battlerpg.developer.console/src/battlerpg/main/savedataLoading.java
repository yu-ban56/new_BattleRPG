package battlerpg.main;

import battlerpg.resources.materials.Characterr;
import battlerpg.save.read.*;

import java.util.ArrayList;

public class savedataLoading {
    public static ArrayList<Characterr> loadCharacter(String[] names) {
        ArrayList<Characterr> characters = new ArrayList<>();
        try {
            for(int i = 0;;i++) {
                Characterr c = Heroread.read(names[i]);
                characters.add(c);
            }
        }catch(Exception e) {e.printStackTrace();}
        return characters;
    }
    public static ArrayList<Characterr> loadCharacter(ArrayList<String> names) {
        ArrayList<Characterr> characters = new ArrayList<>();
        try {
            for(int i = 0;;i++) {
                Characterr c = Heroread.read(names.get(i));
                characters.add(c);
            }
        }catch(Exception e) {e.printStackTrace();}
        return characters;
    }

}
