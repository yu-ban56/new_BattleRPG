package battlerpg.resources.materials;

public abstract class Characterr implements Creature{
    public int hp;
    public int exp;
    public int lvl;
    public int mp;
    private String name;
    protected abstract void attack(Monster m);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
