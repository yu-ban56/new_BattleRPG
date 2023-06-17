package battlerpg.resources.materials;

public abstract class Monster implements Creature{
    public int hp;
    public String name;

    @Override
    public void run() {

    }

    public final void attack(Characterr c) {
        doAttack(c);
    }

    protected abstract void doAttack(Characterr c);
}
