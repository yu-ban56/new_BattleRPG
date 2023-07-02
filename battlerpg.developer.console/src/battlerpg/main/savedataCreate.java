package battlerpg.main;

import battlerpg.save.write.*;
import battlerpg.resources.characters.*;
import battlerpg.resources.materials.*;

public class savedataCreate {
    public static void create(Characterr[] characters) {
        for (Characterr character : characters) {
            Characterr c;
            try {
                CharacterWriter cw;
                Main.addDialog("[function,load]:Character data Loading...");
                c = character;
                if (c instanceof Hero) {
                    Main.addDialog("[function,Hero,write]:HeroData Writer...");
                    cw = new Herowrite();
                    cw.write(c);
                } else if (c instanceof Wizard) {
                    Main.addDialog("[function,Wizard,write]:WizardData Writer...");
                    cw = new WizardWrite();
                    cw.write(c);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
