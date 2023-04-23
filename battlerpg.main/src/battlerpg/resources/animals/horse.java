package battlerpg.resources.animals;

import battlerpg.resources.familys.Animal;

public class horse extends Animal {
    private int energy;
    private int hunger;

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getHunger() {
        return hunger;
    }
}
