package battlerpg.save.read;

import battlerpg.resources.characters.Wizard;
import java.io.FileReader;
import java.util.Properties;
import static battlerpg.main.Main.Filename;


public class Wizardread implements CharacterReader{
    public static Wizard read(String name) throws Exception{
        FileReader fr = new FileReader("../../../saves/" + Filename + "/Characters/Wizard/" + name + ".properties");
        Properties p = new Properties();
        p.load(fr);
        String WizardName = p.getProperty("WizardName");
        String strHp = p.getProperty("WizardHp");
        String strExp = p.getProperty("WizardExp");
        String strLvl = p.getProperty("WizardLvl");
        String strMp = p.getProperty("WizardMp");
        int hp = Integer.parseInt(strHp);
        int Exp = Integer.parseInt(strExp);
        int lvl = Integer.parseInt(strLvl);
        int mp = Integer.parseInt(strMp);
        Wizard w = new Wizard(WizardName);
        w.setWizard(hp, Exp, lvl, mp);
        return w;
    }
}
