package battlerpg.resources.weapons;

import battlerpg.resources.materials.Item;
import battlerpg.resources.materials.ItemType;

public class Weapon extends Item
        implements Cloneable{
    protected int damage;
    protected WeaponType WeaponType;
    private String name;
    public Weapon clone() {
        Weapon w = new Weapon();
        w.damage = this.damage;
        return w;
    }
    public Weapon() {
        theInstance = getTheInstance();
        this.itemtype = ItemType.weapon;
    }
    public Weapon(String name) {
        this.itemtype = ItemType.weapon;
        this.name = name;
    }
    public int getDamage() {
        return damage;
    }
    public WeaponType getWeaponType() {
        return WeaponType;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
