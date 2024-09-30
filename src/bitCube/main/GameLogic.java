package bitCube.main;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


//BitCube miniProject Kasetsart university
public class GameLogic implements Runnable{
	private int stage = 1;
    private int currentScore = 0;
    public int currPlayerNumber = 0;
    public GamePanel gamePanel;
    public int defaultEnemySpawnpoint = 1600;
    public float defaultEnemySpeed = 2.50f;
    private int FPS = 60;
    //this game update thread 60 time per second so if this timer is 60 it's mean 1 second;
    private int secondTimer = 60;
  
    private boolean mainThreadIsRunning = false;
    private boolean playing = true;
    
    private SoundManager sounds;

    public Random rand = new Random();
    Thread gameThread;

    public GameLogic(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        gameThread = new Thread(this);
        sounds = new SoundManager();
    }

    public void gameStart(){
        if (!mainThreadIsRunning){
            mainThreadIsRunning = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
    }

    public void gamePause(){
        mainThreadIsRunning = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted.");
        }
    }

    public void newGame() {
        gamePause();
        playing = true;
        stageScaling(true);
        type = 0;
        currentScore=0;
        gamePanel.ScoreNum.setText("00");
        removeAllEnemy(true);
        resetToggleButtons(gamePanel.jToggleButton1, gamePanel.jToggleButton2, gamePanel.jToggleButton3, gamePanel.jToggleButton4,
                gamePanel.jToggleButton5, gamePanel.jToggleButton6, gamePanel.jToggleButton7, gamePanel.jToggleButton8);
        gamePanel.HPbar.setValue(gamePanel.HPbar.getMaximum());
        gameStart();
    }

    //TODO the enemy will get stronger and stronger by time or stage or score chose it yourself
    private void stageScaling(boolean reset) {
    	if (reset) {
			stage = 1;
			enemyTimer = 400;
			enemySpeed = defaultEnemySpeed;
		} else {
			
		}
    }
    
    
    public float enemySpeed;
    public int type = 0;
    public int prevEnemyLocation = 605;
    public int enemyTimer = 400;
    public ArrayList<Enemy> enemies = new ArrayList<>();
    
    public int SelectionType() {
    	if (SettingPanel.OctalIsSelect && (type == 0 || type >= 3)) {
			if(type >= 3) type = 0; //IDK either why it's work just put it here
			return 0;
		} else if (SettingPanel.DeciIsSelect && type == 1) {
			return 1;
		} else if (SettingPanel.HexIsSelect && type == 2) {
			return 2;
		}
    	return 999;
    }
    
    public void addEnemy(){
    	
        if (enemyTimer >= 400){
        	
            int location = rand.nextInt(80,605);
            if (location<= prevEnemyLocation-135 || location>=prevEnemyLocation+135){
            	
            	type = type%3;
            	System.out.println(type);
            	Enemy newEnemy = new Enemy(defaultEnemySpawnpoint, location, defaultEnemySpeed, SelectionType());
            	if (newEnemy.type != 999) {
            		enemies.add(newEnemy);
            		prevEnemyLocation = (int) newEnemy.y;
            		enemyTimer=0;
            		SwingUtilities.invokeLater(() -> { 
                		gamePanel.BackgroundPanel.add(newEnemy);
                        newEnemy.revalidate();
                        newEnemy.repaint();
                	});
				}
            	type++;
            }
        } else {
            enemyTimer++;
        }
    }
    
    
    //every second score++;
    private int scoreTimer = secondTimer;
    public void scoreUpdate(){
        if (scoreTimer<=0){
            currentScore++;
            gamePanel.ScoreNum.setText("0"+currentScore);
            scoreTimer = secondTimer;
        } else {
            scoreTimer--;
        }

    }

    public void terminalUpdate(){
        SwingUtilities.invokeLater(() -> {
            gamePanel.OctalNum.setText(Integer.toOctalString(currPlayerNumber));
            gamePanel.DeciNum.setText(currPlayerNumber+"");
            gamePanel.HexNum.setText(Integer.toHexString(currPlayerNumber).toUpperCase());
        });
    }

    private float defaultHealthRegen = 0.0030f;
    private float HpRegen = 0;
    public void healthUpdate(){

            HpRegen = HpRegen%1;
            HpRegen+=defaultHealthRegen;
            gamePanel.HPbar.setValue(gamePanel.HPbar.getValue()+(int)HpRegen);
    }

    public void removeAllEnemy(boolean gameover) {
    	Iterator<Enemy> enemyIterator = enemies.iterator();
        while (enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();
            SwingUtilities.invokeLater(() -> gamePanel.BackgroundPanel.remove(enemy));
            enemyIterator.remove();
            if (!gameover) {
            	currentScore += 10;
            }
        }
    }
    
    public void removeEnemy(){
        Iterator<Enemy> enemyIterator = enemies.iterator();
        while (enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();
            if (enemy.x < -155) {
                if (gamePanel.HPbar.getValue()>0){
                    gamePanel.HPbar.setValue(gamePanel.HPbar.getValue()-25);
                }
                SwingUtilities.invokeLater(() -> gamePanel.BackgroundPanel.remove(enemy));
                enemyIterator.remove();
                break;
            }
            if (enemy.numberRand==currPlayerNumber){
                sounds.playKillSound();
                currentScore+=10;
                gamePanel.ScoreNum.setText("0"+currentScore);
                resetToggleButtons(gamePanel.jToggleButton1, gamePanel.jToggleButton2, gamePanel.jToggleButton3, gamePanel.jToggleButton4,
                        gamePanel.jToggleButton5, gamePanel.jToggleButton6, gamePanel.jToggleButton7, gamePanel.jToggleButton8);
                SwingUtilities.invokeLater(() -> gamePanel.BackgroundPanel.remove(enemy));
                enemyIterator.remove();
            }
        }
    }

    private void resetToggleButtons(JToggleButton... toggleButtons) {
        for (JToggleButton toggleButton : toggleButtons) {
            toggleButton.setSelected(true);
            toggleButton.setText("0");
        }
        currPlayerNumber = 0;
    }

    public void gameOver(){
    	
        if (gamePanel.HPbar.getValue()<=0 && playing){
            JFrame gameOverFrame = new JFrame("GameOver");
            JLabel gameOver = new JLabel("Game Over!");
            JButton Restart = new JButton("Restart!");
            Restart.setFont(new Font("Monospaced", Font.BOLD, 60));
            gameOver.setFont(new Font("Monospaced", Font.BOLD, 102));
            gameOverFrame.setLayout(new BorderLayout());
            gameOverFrame.add(gameOver,BorderLayout.CENTER);
            gameOverFrame.add(Restart,BorderLayout.SOUTH);
            Restart.addActionListener((e -> {
                newGame();
                gameOverFrame.setVisible(false);
            }));
//            SwingUtilities.invokeLater(() -> playing = false);
           	playing = false;
            gameOverFrame.pack();
            gameOverFrame.setLocationRelativeTo(null);
            gameOverFrame.setVisible(true);
        }
    }


    public void update(){
        if(playing) {
//        	System.out.println("Update Called");
            scoreUpdate();
            healthUpdate();
            terminalUpdate();
            addEnemy();
            for (Enemy e : enemies) {
                e.update();
            }
            removeEnemy();
            gameOver();
            stageScaling(false);
        }
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (mainThreadIsRunning){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
//            	System.out.println("Thread is running");
            	
                update();
                gamePanel.repaint();
                delta--;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
