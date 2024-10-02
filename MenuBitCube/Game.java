package MenuBitCube;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    public MenuPanel menuPanel;
    public GamePanel gamePanel;
    public GameLogic gameLogic;

    public Game(){

        setTitle("BIT^3");
        
        setLayout(new CardLayout());

        menuPanel = new MenuPanel(this);
        gamePanel = new GamePanel(this);
        add(menuPanel,"Menu");
        gameLogic = gamePanel.gameLogic;
        add(gamePanel,"Game");


        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void switchToMenu(){
        CardLayout layout = (CardLayout) this.getContentPane().getLayout();
        layout.show(this.getContentPane(), "Menu");
    }

    public void switchToGame() {
        CardLayout layout = (CardLayout) this.getContentPane().getLayout();
        layout.show(this.getContentPane(), "Game");
    }

    public static void main(String[] args) {
        new Game();
    }

}
