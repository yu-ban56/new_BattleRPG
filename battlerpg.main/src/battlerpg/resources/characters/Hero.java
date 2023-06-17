package battlerpg.resources.characters;

import battlerpg.main.Main;
import battlerpg.resources.materials.Characterr;
import battlerpg.resources.materials.Monster;
import battlerpg.resources.weapons.Weapon;

public class Hero extends Characterr implements Cloneable{
    Weapon weapon = new Weapon();
    public Hero(String name) {
        super();
        this.hp = 100;
        this.name = name;
    }

    public Hero(String name, int hp, int lvl, int exp, int mp) {
        super(name, hp, lvl, exp, mp);
    }
    public void attack(Monster m) {
        Main.addMessage("[Client: Message]�q�[���[" + this.name + "�͍U�������B");
        m.hp =- 10;
    }
    public void run(){
        System.out.println("[Client: Message]�q�[���[" + this.name + "�͓����o����");
        Main.addMessage("�q�[���[" + this.name + "�͓����o����");
    }
    public void setHero(Hero data) {
        this.hp = data.hp;
        this.exp = data.exp;
        this.lvl = data.lvl;
    }

    public void setHero(int hp, int exp, int lvl) {
        this.hp = hp;
        this.exp = exp;
        this.lvl = lvl;
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
        Hero clone = new Hero(name);
        Hero result = new Hero();
        result.hp = this.hp;
        result.lvl = this.lvl;
        result.exp = this.exp;
        result.weapon = this.weapon.clone();
        return result;
    }
}

