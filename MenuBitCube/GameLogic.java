package main;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GameLogic implements Runnable{
    private int currentScore = 0;
    public int currPlayerNumber = 0;
    public GamePanel gamePanel;
    public int defaultEnemyX = 1600;
    public float defaultEnemySpeed = 0.40f;
    private int FPS = 60;

    public ArrayList<Enemy> enemies = new ArrayList<>();
    private boolean running = false;
    private boolean playing = true;
    //BitCube Project Kasetsart university


    public Random rand = new Random();
    Thread gameThread;

    public GameLogic(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        gameThread = new Thread(this);
    }

    public void gameStart(){
        if (!running){
            running = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
    }

    public void pause(){
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted.");
        }
    }

    public void resetGame() {
        running = false;
        playing = true;
        enemyTimer = 500;
        type = 0;
        currentScore=0;
        gamePanel.ScoreNum.setText("00");
        Iterator<Enemy> enemyIterator = enemies.iterator();
        while (enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();
            SwingUtilities.invokeLater(() -> gamePanel.BackgroundPanel.remove(enemy));
            enemyIterator.remove();
        }
        resetToggleButtons(gamePanel.jToggleButton1, gamePanel.jToggleButton2, gamePanel.jToggleButton3, gamePanel.jToggleButton4,
                gamePanel.jToggleButton5, gamePanel.jToggleButton6, gamePanel.jToggleButton7, gamePanel.jToggleButton8);
        gamePanel.HPbar.setValue(gamePanel.HPbar.getMaximum());
    }


    public int type = 0;
    public int currentEnemy = 605;
    public int enemyTimer = 500;
    public void addEnemy(){
        if (enemyTimer >= 500){
            int temp = rand.nextInt(605);
            if (temp<= currentEnemy-135 || temp>=currentEnemy+135){
                SwingUtilities.invokeLater(() -> {
                    Enemy newEnemy = new Enemy(defaultEnemyX, temp, defaultEnemySpeed, type % 3);
                    enemies.add(newEnemy);
                    gamePanel.BackgroundPanel.add(newEnemy);
                    newEnemy.revalidate();
                    newEnemy.repaint();
                    currentEnemy = (int) newEnemy.y;
                });
                enemyTimer=0;
                type++;
            }
        } else {
            enemyTimer++;
        }
        for (Enemy e : enemies){
            gamePanel.BackgroundPanel.add(e);
        }
    }
    private int second = 60;
    public void scoreUpdate(){
        if (second<=0){
            currentScore++;
            gamePanel.ScoreNum.setText("0"+currentScore);
            second = 60;
        } else {
            second--;
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
                playSound("resources/sound1.wav");
                currentScore+=10;
                gamePanel.ScoreNum.setText("0"+currentScore);
                resetToggleButtons(gamePanel.jToggleButton1, gamePanel.jToggleButton2, gamePanel.jToggleButton3, gamePanel.jToggleButton4,
                        gamePanel.jToggleButton5, gamePanel.jToggleButton6, gamePanel.jToggleButton7, gamePanel.jToggleButton8);
                SwingUtilities.invokeLater(() -> gamePanel.BackgroundPanel.remove(enemy));
                enemyIterator.remove();
            }
        }
    }
    public void removeallEnemy(){
        Iterator<Enemy> enemyIterator = enemies.iterator();
        while (enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();
           
                playSound("resources/sound1.wav");
                currentScore+=10;
                gamePanel.ScoreNum.setText("0"+currentScore);
                resetToggleButtons(gamePanel.jToggleButton1, gamePanel.jToggleButton2, gamePanel.jToggleButton3, gamePanel.jToggleButton4,
                        gamePanel.jToggleButton5, gamePanel.jToggleButton6, gamePanel.jToggleButton7, gamePanel.jToggleButton8);
                SwingUtilities.invokeLater(() -> gamePanel.BackgroundPanel.remove(enemy));
                enemyIterator.remove();
            
        }
    }
    public void skill2(){
        Iterator<Enemy> enemyIterator = enemies.iterator();
        while (enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();
            enemy.setText1();
            
        }
    }
    public void skill3(){
        Iterator<Enemy> enemyIterator = enemies.iterator();
        while (enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();
            enemy.setText2();
        }
    }
    public void Skill4(){
        Iterator<Enemy> enemyIterator = enemies.iterator();
        while (enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();
            enemy.setText3();
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
        if (gamePanel.HPbar.getValue()<=0&&playing){
            JFrame gameOverFrame = new JFrame("GameOver");
            JLabel gameOver = new JLabel("Game Over!");
            JButton Restart = new JButton("Restart!");
            Restart.setFont(new Font("Monospaced", Font.BOLD, 60));
            gameOver.setFont(new Font("Monospaced", Font.BOLD, 102));
            gameOverFrame.setLayout(new BorderLayout());
            gameOverFrame.add(gameOver,BorderLayout.CENTER);
            gameOverFrame.add(Restart,BorderLayout.SOUTH);
            Restart.addActionListener((e -> {
                resetGame();
                gameOverFrame.setVisible(false);

            }));
            playing = false;
            gameOverFrame.pack();
            gameOverFrame.setLocationRelativeTo(null);
            gameOverFrame.setVisible(true);
        }
    }


    public void playSound(String soundFilePath) {
        try {
            InputStream audioStream = getClass().getResourceAsStream(soundFilePath);
            if (audioStream == null) {
                System.out.println("Audio file not found: " + soundFilePath);
                return;
            }
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioStream);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }


    public void update(){
        if(playing) {
            scoreUpdate();
            healthUpdate();
            terminalUpdate();
            addEnemy();
            for (Enemy e : enemies) {
                e.update();
            }
            removeEnemy();
            gameOver();
        }
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (running){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                //System.out.println("game is running");
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
