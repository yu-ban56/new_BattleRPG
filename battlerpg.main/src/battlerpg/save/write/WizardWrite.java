package battlerpg.save.write;

import battlerpg.resources.characters.Wizard;
import battlerpg.resources.materials.Characterr;

import static battlerpg.main.Main.Filename;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.Objects;
import java.util.Properties;

public class WizardWrite implements CharacterWriter{
    public void write(Wizard w) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("saves/Wizard.bta"));
        oos.writeObject(w);
        oos.close();
    }


    public void write(Characterr c) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("saves/" + Filename + "/data/Wizard.bta"));
        oos.writeObject(c);
        oos.close();
    }
}
