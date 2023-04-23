package battlerpg.resources.characters;

public class HyperHero extends SuperHero{
    public HyperHero clone() {
        SuperHero sh = super.clone();
        return (HyperHero)sh;
    }
}
