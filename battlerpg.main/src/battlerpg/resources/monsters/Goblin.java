package battlerpg.resources.monsters;

import battlerpg.resources.materials.Characterr;
import battlerpg.resources.materials.Monster;
import battlerpg.resources.weapons.knife.Goblin_knife;

public class Goblin extends Monster {
    Goblin_knife knife = new Goblin_knife();
    private static final int Level = 12;
    public void attack(Characterr c) {
        knife.attack(c);
    }
    public void run() {

    }
}
