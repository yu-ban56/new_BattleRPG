package battlerpg.resources.characters;

import battlerpg.resources.materials.Monster;

public class SuperHero extends Hero{
    boolean fly;
    public void fly() {
        fly = true;
    }
    public void land() {
        fly = false;
    }
    public void attack(Monster m) {
        super.attack(m);
        if(fly) {
            super.attack(m);
        }
    }
    public void setHero(Hero data) {
        super.setHero(data);
    }
    public SuperHero clone() {
        Hero h = super.clone();
        SuperHero result = (SuperHero) h;
        result.fly = this.fly;
       return result;
    }
}
