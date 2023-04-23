package battlerpg.resources.characters;

import battlerpg.resources.materials.Characterr;
import battlerpg.resources.materials.Monster;
import battlerpg.resources.weapons.Weapon;

public class Hero extends Characterr implements Cloneable{
    String name;
    Weapon weapon = new Weapon();
    public Hero(String name) {
        this.hp = 100;
        this.name = name;
    }
    public void attack(Monster m) {

    }
    public void run(){
        System.out.println("ÉqÅ[ÉçÅ[" + this.name + "ÇÕÇ…Ç∞ÇæÇµÇΩ");
    }
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }
    public int gethp() {
            return hp;
        }
        public int getlevel() {
            return lvl;
        }
        public void setHero(int hp, int exp, int lvl) {
        this.hp = hp;
        this.exp = exp;
        this.lvl = lvl;
    }
    public void setHero(Hero data) {
        this.hp = data.hp;
        this.exp = data.exp;
        this.lvl = data.lvl;
    }
    public Hero() {
        this("Hero");
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }
    public Hero clone() {
        Hero result = new Hero();
        result.name = this.name;
        result.hp = this.hp;
        result.lvl = this.lvl;
        result.exp = this.exp;
        result.weapon = this.weapon.clone();
        return result;
    }
}

