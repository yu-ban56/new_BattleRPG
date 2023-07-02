package battlerpg.resources.materials;

public abstract class Item {
    private static int ubdamage;
    private static int Umbreaking;
    protected static Item theInstance;
    protected ItemType itemtype;
    protected static String itemId;
    public static Item give(String ItemId) {
        if(ItemId.equals(itemId)){
            return theInstance;
        }else return null;
    }
    public Item getTheInstance() {
        theInstance = this;
        return theInstance;
    }
}
