package battlerpg.resources.materials;

import battlerpg.main.Main;

public interface Creature {
    default void run() {
        System.out.println("[Client: Message] 生き物は逃げ出した！");
        Main.addMessage("生き物は逃げ出した！");
    }
}
