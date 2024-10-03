package main;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	public MenuPanel menuPanel;
	public HTPlayPanel htPlayPanel;
	public DifficultyPanel difficultyPanel;
    public GamePanel gamePanel;
    public GameLogic gameLogic;
    public SettingPanel settingPanel;

    public SoundManager sm;
    
    
    public Game(){
    	
		
        setTitle("BitCube");
        setLayout(new CardLayout());
        
        
        menuPanel = new MenuPanel(this);
        add(menuPanel,"Menu");
        htPlayPanel = new HTPlayPanel();
        add(htPlayPanel,"HTP");
        settingPanel = new SettingPanel(this);
        add(settingPanel,"Setting");
        sm = new SoundManager(settingPanel);
        gamePanel = new GamePanel(this);
        gameLogic = gamePanel.gameLogic;
        add(gamePanel,"Game");
        difficultyPanel = new DifficultyPanel(this);
        add(difficultyPanel, "Difficulty");
        
        
        switchToMenu();

        pack();
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        sm.playBGMusic();
        
    }

    public void switchToMenu(){
        CardLayout layout = (CardLayout) this.getContentPane().getLayout();
        layout.show(this.getContentPane(), "Menu");
    }
    
    public void switchToHTP() {
    	CardLayout layout = (CardLayout) this.getContentPane().getLayout();
        layout.show(this.getContentPane(), "HTP");
    }

    public void switchToGame() {
        CardLayout layout = (CardLayout) this.getContentPane().getLayout();
        layout.show(this.getContentPane(), "Game");
        gamePanel.requestFocusInWindow();
    }
    
    public void switchToSetting() {
    	CardLayout layout = (CardLayout) this.getContentPane().getLayout();
        layout.show(this.getContentPane(), "Setting");
    }
    
    public void switchToDifficulty() {
    	CardLayout layout = (CardLayout) this.getContentPane().getLayout();
        layout.show(this.getContentPane(), "Difficulty");
//        sm.playBGMusic();
    }

    public static void main(String[] args) {
        new Game();
    }

}
