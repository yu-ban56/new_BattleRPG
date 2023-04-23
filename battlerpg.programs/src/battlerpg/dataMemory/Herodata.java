package battlerpg.dataMemory;

import battlerpg.resources.characters.Hero;

@SuppressWarnings("all")
public class Herodata {
    private String name;
    private int hp;
    private int exp;
    private int Level;
    private Hero Logic;

    public int getExp() {
        return exp;
    }
    public boolean equals(Object o) {
        if (o instanceof Hero) {
            this.Logic = (Hero)o;
        } else {
            return false;
        }
        return this.hp == this.Logic.hp && this.exp == this.Logic.exp && this.Level == this.Logic.lvl;
    }

    public int hashCode() {
        final int CODE = 36;
        int hashhp = this.hp / 3;
        int hashexp = this.exp / 3;
        int hashlvl = this.Level / 3;
        int HashCode = hashhp + hashexp + hashlvl + CODE;
        return HashCode / 4;
    }

    public String toString() {
        return "Herodata{" +
                "name=" + name +
                 ",hp=" + hp + ",exp=" + exp + ",Level=" + Level +
                '}';
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getLevel() {
        return Level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Hero getInstance() {
        Hero result = new Hero();
        result.setHero(hp, exp, Level);
        return result;
    }
    public Hero getInstance(String name) {
        Hero result = new Hero(name);
        result.setHero(hp, exp, Level);
        return result;
    }
}