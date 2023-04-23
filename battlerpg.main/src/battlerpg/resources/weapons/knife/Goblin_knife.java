package battlerpg.resources.weapons.knife;

import battlerpg.resources.materials.Characterr;
import battlerpg.resources.weapons.Weapon;
import battlerpg.resources.weapons.WeaponType;

public class Goblin_knife extends Weapon {
    public Goblin_knife() {
        this.damage = 15;
        this.WeaponType = WeaponType.knife;
    }
    public void attack(Characterr c) {
        int r = new java.util.Random().nextInt(100000);
        if(r <= 83915) {
            c.hp =- damage;
        }
    }
}
