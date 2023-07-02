package battlerpg.resources.materials;

public abstract class Characterr implements Creature{
    protected int hp;
    protected static long characterInstances;
    protected int exp;
    public int lvl;
    protected int mp;
    protected String name;
    protected abstract void attack(Monster m);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLevel() {
        return lvl;
    }

    public Characterr(String name, int hp, int lvl, int exp, int mp) {
        this.name = name;
        this.hp = hp;
        this.lvl = lvl;
        this.exp = exp;
        this.mp = mp;
    }
    public Characterr(String name) {
        this.name = name;
    }

    public Characterr() {
        this("Hero@" + String.format("%6d", characterInstances));
    }
}
