package battlerpg.resources;

import battlerpg.resources.materials.Item;

public class Command {
    public static void addStatement(String command) {
        Item item = Item.give(command);
    }
}
