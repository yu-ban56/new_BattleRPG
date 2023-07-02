package battlerpg.resources.monsters;

import battlerpg.resources.materials.Characterr;
import battlerpg.resources.materials.Monster;

public class WelkWolf extends Monster{
    char name;
    public char getName() {
        return name;
    }
    public WelkWolf(char name) {
        this.name = name;
        this.hp = 40;
    }


    @Override
    protected void doAttack(Characterr c) {
        c.setHp(c.getHp() - 8);
    }
}
