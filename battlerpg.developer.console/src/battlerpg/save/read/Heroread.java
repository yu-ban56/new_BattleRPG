package battlerpg.save.read;

import java.io.FileReader;
import java.util.Properties;
import battlerpg.resources.characters.Hero;

import static battlerpg.main.Main.Filename;

public class Heroread implements CharacterReader{
    public static Hero read(String name) throws Exception {
        FileReader fr = new FileReader("../../../saves/" + Filename + "/Characters/Hero/" + name + ".properties");
        Properties p = new Properties();
        p.load(fr);
        String HeroName = p.getProperty("HeroName");
        String strHp = p.getProperty("HeroHp");
        String strExp = p.getProperty("HeroExp");
        String strLvl = p.getProperty("HeroLvl");
        int hp = Integer.parseInt(strHp);
        int exp = Integer.parseInt(strExp);
        int Lvl = Integer.parseInt(strLvl);
        Hero h = new Hero(HeroName);
        h.setHero(hp, exp, Lvl);
        return h;
    }
}
