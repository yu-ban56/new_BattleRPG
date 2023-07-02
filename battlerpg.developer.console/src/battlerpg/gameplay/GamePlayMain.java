package battlerpg.gameplay;

import battlerpg.main.Main;
import battlerpg.resources.characters.Hero;
import battlerpg.resources.monsters.Goblin;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;

public class GamePlayMain {
    public static void launch(JFrame gameplayFrame, String file) {
        Hero h = new Hero("Hero", 100, 2, 50, 50);
        Goblin m = new Goblin();
        m.hp = 1000;
        m.name = "test";
        final JButton battleButton = new JButton("Battle");
        gameplayFrame.add(battleButton);
        battleButton.addActionListener(e->{
            JButton attacked = new JButton("攻撃");
            attacked.addActionListener(ev->{
                h.attack(m);
                try{
                    Thread.sleep(500);
                }catch(Exception ex){ex.printStackTrace();}
                m.attack(h);
                if(m.hp <= 0) {
                    System.out.println("[Client: Message]戦闘に勝利しました！");
                    Main.addMessage("戦闘に勝利しました！");
                    System.out.println("Loading...");
                    gameplayFrame.remove(0);
                    gameplayFrame.add(battleButton);
                    gameplayFrame.setVisible(false);
                    gameplayFrame.setVisible(true);
                }
            });
            gameplayFrame.remove(battleButton);
            gameplayFrame.add(new JLabel("モンスター" + m.name + "がやってきた！　　どうする？"));
            gameplayFrame.add(attacked);
            gameplayFrame.setVisible(false);
            gameplayFrame.setVisible(true);
            gameplayFrame.repaint();
        });
        gameplayFrame.setVisible(true);
    }
}
