package bitCube.main;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	public MenuPanel menuPanel;
    public GamePanel gamePanel;
    public GameLogic gameLogic;
    public SettingPanel settingPanel;

    public Game(){

        setTitle("BIT^3");
        setLayout(new CardLayout());
        menuPanel = new MenuPanel(this);
        add(menuPanel,"Menu");
        gamePanel = new GamePanel(this);
        gameLogic = gamePanel.gameLogic;
        add(gamePanel,"Game");
        settingPanel = new SettingPanel(this);
        add(settingPanel,"Setting");

        switchToMenu();

        pack();
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
    
    public void switchToSetting() {
    	CardLayout layout = (CardLayout) this.getContentPane().getLayout();
        layout.show(this.getContentPane(), "Setting");
    }

    public static void main(String[] args) {
        new Game();
    }

}
