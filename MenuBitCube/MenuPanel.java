package main;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class MenuPanel extends JPanel {
    public Game frame;
    public MainMenuPanel mainmenu;
    public DifficultyPanel selectmode;

    public LogoPanel logo;
    public EffectLeft effectL;
    public EffectRight effectR;
    
    private CardLayout cardLayout;
    public JPanel switchpanel;

    public MenuPanel(Game frame){
        this.frame = frame;

        cardLayout = new CardLayout(); 
        switchpanel = new JPanel(cardLayout); 

        mainmenu = new MainMenuPanel(frame); // Initialize mainmenu
        selectmode = new DifficultyPanel(frame); // Initialize selectmode

        //about effect
        logo = new LogoPanel(); // Initialize logo
        effectL = new EffectLeft(); // Initialize effectL
        effectR = new EffectRight(); // Initialize effectR

        switchpanel.add(mainmenu, "MainMenu");
        switchpanel.add(selectmode, "SelectMode");


        initComponents();
    }

    //เริ่มการทำงานต่างๆของ Panel
    private void initComponents() {
        setPreferredSize(new Dimension(1600,900));
        setSize(1600,900);
        
        //ปุ่ม start เลืกหน้าเมนู
        mainmenu.start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                mainmenu.start.setForeground(Color.WHITE);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                showDiffiSelect();
            }
            @Override
            public void mouseExited(MouseEvent e) {
               mainmenu.start.setForeground(Color.BLUE);
            }
        });

        //ปุ่มย้อนจากหน้าเลือกระดับไปหน้าเมนู
        selectmode.Jback.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                showMainMenu();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                selectmode.Jback.setForeground(Color.RED);
                selectmode.Jback.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                selectmode.Jback.setForeground(Color.GRAY);
            }
        });

         //จัดตำแหน่งใน frame
        setLayout(new BorderLayout());
        add(logo,BorderLayout.NORTH);
        add(switchpanel,BorderLayout.CENTER);
        add(effectL,BorderLayout.WEST);
        add(effectR,BorderLayout.EAST);

    }
    private void showDiffiSelect(){
        cardLayout.show(switchpanel, "SelectMode");
    }

    private void showMainMenu(){    
        cardLayout.show(switchpanel, "MainMenu");
    }

}

class MainMenuPanel extends JPanel{
    public Game frame;
    public MainMenuPanel mainmenu;
    public LogoPanel logo;
    public EffectLeft effectL;
    public EffectRight effectR;
    public DifficultyPanel selectmode;
    public JPanel menuSelect;
    Color darkblue = new Color(255-102-102);
    JLabel start = new JLabel("START",SwingConstants.CENTER);
    JLabel howTo = new JLabel("How to play?",SwingConstants.CENTER);
    JLabel setting = new JLabel("Setting",SwingConstants.CENTER);
    JLabel exit = new JLabel("Exit",SwingConstants.CENTER);

    public MainMenuPanel(Game frame){
        this.frame = frame;

        logo = new LogoPanel();
        effectL = new EffectLeft(); 
        effectR = new EffectRight();
        
        menuSelect = new JPanel();
        


        // ตั้งค่าฟอนต์ของตัวแปรต่างๆ
        start.setFont(new Font("MV Boli", Font.BOLD, 100));
        start.setForeground(Color.BLUE);
        start.setCursor(new Cursor(Cursor.HAND_CURSOR));
        howTo.setFont(new Font("MV Boli",Font.BOLD,100));
        howTo.setForeground(Color.BLUE);
        howTo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        setting.setFont(new Font("MV Boli",Font.BOLD,100));
        setting.setForeground(Color.BLUE);
        setting.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.setFont(new Font("MV Boli",Font.BOLD,100));
        exit.setForeground(Color.BLUE);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        setBackground(darkblue);

        howTo.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                howTo.setForeground(Color.WHITE);
            }
            @Override 
            public void mouseReleased(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Label clicked!");
                //ลิ้งไปหน้า how to play
            }
            @Override
            public void mouseExited(MouseEvent e) {
               howTo.setForeground(Color.BLUE);
            }
        });
        //ตั้งปุ่ม setting
        setting.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                setting.setForeground(Color.WHITE);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Label clicked!");
                //ลิ้งไปหน้า setting
            }
            @Override
            public void mouseExited(MouseEvent e) {
               setting.setForeground(Color.BLUE);
            }
        });
        exit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                exit.setForeground(Color.RED);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                int answer = JOptionPane.showConfirmDialog(null,"Do you want to exit",
                                                 "Exit confirm",JOptionPane.YES_NO_OPTION);
                if(answer==JOptionPane.YES_OPTION){                              
                    System.exit(0);
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
               exit.setForeground(Color.BLUE);
            }
        });

        setBackground(darkblue);
        setLayout(new GridLayout(4,1));
        add(start);
        add(howTo);
        add(setting);
        add(exit);

    }
}



/************************************************************************************************************************************/
class DifficultyPanel extends JPanel{
    public MainMenuPanel mainmenu;
    public LogoPanel logo;
    public EffectLeft effectL;
    public EffectRight effectR;
    public JPanel select;
    JLabel easy = new JLabel("Easy", SwingConstants.CENTER);
    JLabel normal = new JLabel("Normal", SwingConstants.CENTER);
    JLabel hard = new JLabel("Hard", SwingConstants.CENTER);
    JLabel Jback = new JLabel("Back",SwingConstants.CENTER);
    Color darkblue = new Color(255-102-102);
    public Game frame;

    public DifficultyPanel(Game frame){
        this.frame = frame;

        setBackground(darkblue);

        logo = new LogoPanel();
        effectL = new EffectLeft(); 
        effectR = new EffectRight();

        select = new JPanel();
        // ตั้งค่าฟอนต์ของตัวแปรต่างๆ
        Font labelFont = new Font("MV Boli", Font.PLAIN, 80);
        easy.setFont(labelFont);
        easy.setForeground(Color.GRAY);
        normal.setFont(labelFont);
        normal.setForeground(Color.GRAY);
        hard.setFont(labelFont);
        hard.setForeground(Color.GRAY);
        Jback.setFont(labelFont);
        Jback.setForeground(Color.GRAY);
        setBackground(darkblue);


        // Add mouse listeners to the new difficulty labels

        easy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //ลิ้ง easy mode
                frame.switchToGame();
                frame.gameLogic.resetGame();
                frame.gameLogic.gameStart();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                easy.setForeground(Color.GREEN);
                easy.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                easy.setForeground(Color.GRAY);
            }
        });

        normal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //ลิ้ง normal mode
                JOptionPane.showMessageDialog(null, "You selected Normal difficulty!");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                normal.setForeground(Color.ORANGE);
                normal.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                normal.setForeground(Color.GRAY);
            }
        });

        hard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //ลิ้ง hard mode
                JOptionPane.showMessageDialog(null, "You selected Hard difficulty!");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hard.setForeground(Color.RED);
                hard.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hard.setForeground(Color.GRAY);
            }
        });

        setBackground(darkblue);

        select.setLayout(new GridLayout(4,1));
        select.setBackground(darkblue);
        select.add(easy);
        select.add(normal);
        select.add(hard);
        select.add(Jback);

        setLayout(new BorderLayout());
        add(select,BorderLayout.CENTER);
    }

}



/************************************************************************************************************************************/
class LogoPanel extends JPanel{
    JLabel gamelogo = new JLabel("Bit Cube",SwingConstants.CENTER);
    Color darkblue = new Color(255-102-102);
    public LogoPanel(){
        // ตั้งค่าฟอนต์ของตัวแปรต่างๆ
        gamelogo.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 200));
        gamelogo.setForeground(Color.YELLOW);

        setBackground(darkblue);
        add(gamelogo);

    }
}




/************************************************************************************************************************************/
class EffectLeft extends JPanel{
    private int x = 200; // Initial x position of the textbox
    private int y = 200; // Initial y position of the textbox
    private int deltaX = 2; // Movement in x direction
    private int deltaY = 2; // Movement in y direction

    private int x2 = 100; 
    private int y2 = 100;
    private int deltaX2 = 3; 
    private int deltaY2 = 3;

    private Timer timer;

    Random rand = new Random();
    Font useFont = new Font("Papyrus", Font.PLAIN, 30);
    Color darkblue = new Color(255-102-102);
    public EffectLeft(){
        // Set the size of the panel
        setPreferredSize(new Dimension(400, 400));
        
        setBackground(darkblue);

        // Use a lambda or anonymous ActionListener for the Timer
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the position of the textbox
                x += deltaX;
                y += deltaY;

                // Bounce off the edges of the panel
                if (x < 0 || x + 200 > getWidth()) {
                    deltaX *= -1;
                }
                if (y < 0 || y + 30 > getHeight()) {
                    deltaY *= -1;
                }

                // Update the position of the second box
                x2 += deltaX2;
                y2 += deltaY2;

                // Bounce off the edges of the frame for the second box
                if (x2 < 0 || x2 + 70 > getWidth()) {
                    deltaX2 *= -1;
                }
                if (y2 < 0 || y2 + 30 > getHeight()) {
                    deltaY2 *= -1;
                }

                // Repaint the frame to update the animation
                repaint();
            }
        });
        timer.start(); // Start the animation
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int randonint1 = rand.nextInt(2);
        int randonint2 = rand.nextInt(2);
        int randonint3 = rand.nextInt(2);
        int randonint4 = rand.nextInt(2);
        int randomint5 = rand.nextInt(10);
        int randomint6 = rand.nextInt(10);
    
        // Draw a background
        g.setColor(darkblue);
        g.fillRect(0, 0, getWidth(), getHeight());
    
        // Draw a textbox (rectangle with text)
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, 200, 30); // Rectangle for the textbox
        g.setFont(useFont);
        g.setColor(Color.BLACK);
        g.drawString("0b0010 "+randonint1+randonint2+randonint3+randonint4, x + 10, y + 20); // Text inside the textbox
    
        // Draw the second moving textbox
        g.setColor(Color.GRAY);
        g.fillRect(x2, y2, 70, 30);
        g.setFont(useFont);
        g.setColor(Color.BLACK);
        g.drawString("2"+randomint5+randomint6, x2 + 10, y2 + 20);
            
    }
}

/***********************************************************************************************************************************/
class EffectRight extends JPanel{
    private int x = 50; // Initial x position of the textbox
    private int y = 50; // Initial y position of the textbox
    private int deltaX = 2; // Movement in x direction
    private int deltaY = 2; // Movement in y direction
    
    private int x2 = 300; 
    private int y2 = 300;
    private int deltaX2 = 3; 
    private int deltaY2 = 3;
    
    private Timer timer;
    
    Random rand = new Random();
    Font useFont = new Font("Papyrus", Font.PLAIN, 30);
    Color darkblue = new Color(255-102-102);

    public EffectRight(){
        // Set the size of the panel
        setPreferredSize(new Dimension(400, 400));
            
        setBackground(darkblue);
    
        // Use a lambda or anonymous ActionListener for the Timer
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the position of the textbox
                x += deltaX;
                y += deltaY;
                
                // Bounce off the edges of the panel
                if (x < 0 || x + 120 > getWidth()) {
                    deltaX *= -1;
                }
                if (y < 0 || y + 30 > getHeight()) {
                    deltaY *= -1;
                }
    
                // Update the position of the second box
                x2 += deltaX2;
                y2 += deltaY2;

                // Bounce off the edges of the frame for the second box
                if (x2 < 0 || x2 + 100 > getWidth()) {
                    deltaX2 *= -1;
                }
                if (y2 < 0 || y2 + 30 > getHeight()) {
                    deltaY2 *= -1;
                }
    
                // Repaint the frame to update the animation
                repaint();
            }
        });
        timer.start(); // Start the animation
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int randomint1 = rand.nextInt(10);
        int randomint2 = rand.nextInt(10);
        int randomint3 = rand.nextInt(9);
        int randomint4 = rand.nextInt(9);
        int randomindex = rand.nextInt(7);
        char randomchar1 = (char) ('a'+randomindex);
        char randomchar2 = (char) ('a'+randomindex);

        // Draw a background
        g.setColor(darkblue);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw a textbox (rectangle with text)
        g.setColor(Color.RED);
        g.fillRect(x, y, 120, 30); // Rectangle for the textbox
        g.setFont(useFont);
        g.setColor(Color.BLACK);
        g.drawString("0o8"+randomint3+randomint1+randomint4, x + 10, y + 20); // Text inside the textbox

        // Draw the second moving textbox
        g.setColor(Color.GREEN);
        g.fillRect(x2, y2, 100, 30);
        g.setFont(useFont);
        g.setColor(Color.BLACK);
        g.drawString("0xf"+randomchar1+randomint2+randomchar2, x2 + 10, y2 + 20);

    }
}
