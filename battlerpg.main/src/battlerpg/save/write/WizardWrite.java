package battlerpg.save.write;

import battlerpg.resources.materials.Characterr;

import static battlerpg.main.Main.Filename;

import java.io.FileWriter;
import java.util.Properties;

public class WizardWrite implements CharacterWriter{
    public void write(Characterr w) throws Exception{
        Integer a = w.hp;
        String hp = a.toString(w.hp);
        String exp = a.toString(w.exp);
        String lvl = a.toString(w.lvl);
        String mp = a.toString(w.mp);
        Properties p = new Properties();
        FileWriter fw = new FileWriter("../../../saves/" + Filename +"/Character/Wizard/" + w.getName() + ".properties");
        p.setProperty("WizardName", w.getName());
        p.setProperty("WizardHp", hp);
        p.setProperty("WizardExp", exp);
        p.setProperty("WizardLvl", lvl);
        p.setProperty("WizardMp", mp);
        p.store(fw, "WizardAttributes");
    }
}
