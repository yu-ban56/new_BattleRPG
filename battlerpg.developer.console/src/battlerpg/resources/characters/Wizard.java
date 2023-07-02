package battlerpg.resources.characters;

import battlerpg.resources.materials.Characterr;
import battlerpg.resources.materials.Monster;

public class Wizard extends Characterr {
    String name;
    public int mp;
    public void attack(Monster m) {

    }
    public Wizard(String name) {
        this.hp = 100;
        this.name = name;
        this.exp = 0;
        this.lvl = 1;
        this.mp = 80;

    }
    public void run() {

    }
    public String getName() {
        return this.name;
    }
    public int getHp() {
        return this.hp;
    }
    public void setWizard(int hp, int exp, int lvl, int mp) {
        this.hp = hp;
        this.exp = exp;
        this.lvl = lvl;
        this.mp = mp;
    }
}
