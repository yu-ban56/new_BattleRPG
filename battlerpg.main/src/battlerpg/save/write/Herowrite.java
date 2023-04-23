package battlerpg.save.write;

import battlerpg.resources.materials.Characterr;
import battlerpg.resources.characters.Hero;
import java.io.*;
import java.util.Properties;

import static battlerpg.main.Main.Filename;

public class Herowrite implements CharacterWriter{
    public void write(Characterr c) throws Exception{
        if(!(c instanceof Hero)) return;
        Integer a = c.hp;
        String hp = a.toString();
        a = c.exp;
        String exp = a.toString();
        a = c.lvl;
        String lvl = a.toString();
        FileWriter fw = new FileWriter("../../../../saves/" + Filename + "/Characters/Hero/" + c.getName() + ".properties");
        Properties p = new Properties();
        p.setProperty("HeroName", c.getName());
        p.setProperty("HeroHp", hp);
        p.setProperty("HeroExp", exp);
        p.setProperty("HeroLvl", lvl);
        p.store(fw, "HeroAttributes");
    }
}
