import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    JButton button;
    Timer timer;
    int buttonY = 0;
    final int STEP = 3;
    final int DELAY = 40; 
    JButton[] binary = new JButton[8];
    int over = 394;
    int y = 300;
    static int x = 5;

    public Game() {

        setTitle("8bit");
        setSize(460, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        button = new JButton("2B");
        button.setBounds(150, buttonY, 100, 50);
        button.setEnabled(false);
        add(button);tt
        JButton line = new JButton("");
        line.setBounds(0, 440, 460, 5);
        line.setEnabled(false);


        add(line);
        for(int i = 0 ; i < 8 ; i++){
            binary[i] = new JButton("0");
            binary[i].setBounds(x, 500, 50, 50);
            x+=55;
            add(binary[i]);
        } 
        

        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonY += STEP;
                if (buttonY >= y) {
                     
                    button = null;
                    
                }
                if (buttonY >= over) {
                    
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Game Over!");  // แสดงข้อความ Game Over
                }
                button.setBounds(150, buttonY, 100, 50);
            }
        });
        timer.start();
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Game bit = new Game();
            bit.setVisible(true);
        });
    }
}
