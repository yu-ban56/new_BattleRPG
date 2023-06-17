package battlerpg.resources.effect;

import battlerpg.resources.materials.*;

public class RegenerationEffect extends Effect implements EffectInfluenceDTO{
    public RegenerationEffect(String effectName, Creature target) {
        super(effectName, target);
    }

    public void effect(Monster target) {
        temp = target;
        Thread t = new Thread() {
            public void run() {
                try {
                    sleep(2005);
                    Object t = temp;
                    Characterr c = (Characterr) t;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.setName("Effect Counting Thread " + effects);
        t.setDaemon(true);
        t.start();
        temp = null;
    }
    protected Object temp = null;

    public void effect(Characterr target) {
        temp = target;
        Thread t = new Thread() {
            public void run() {
                try {
                    sleep(2005);
                    Object t = temp;
                    Characterr c = (Characterr) t;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.setName("Effect Counting Thread " + effects);
        t.setDaemon(true);
        t.start();
        temp = null;
    }
}
