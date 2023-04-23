package battlerpg.resources.monsters;

import battlerpg.resources.materials.Monster;

public class WelkWolf extends Monster{
    char name;
    public char getName() {
        return name;
    }
    public WelkWolf(char name) {
        this.name = name;
        this.hp = 40;
    }

    public void run() {

    }
}