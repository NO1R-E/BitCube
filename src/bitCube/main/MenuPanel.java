package bitCube.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel {
    public Game frame;

    public MenuPanel(Game frame){
        this.frame = frame;
        initComponents();
    }

    private void initComponents() {
        setBackground(Color.BLUE);
        setPreferredSize(new Dimension(1600,900));
        setSize(1600,900);
        setLayout(new FlowLayout());
        JButton start = new JButton("Start");
        start.addActionListener((this::startAction));
        add(start);
        JButton settingButton = new JButton("Setting");
		settingButton.addActionListener((this::settingButtonAction));
		add(settingButton);
    }
    
    public void settingButtonAction(ActionEvent evt) {
    	frame.switchToSetting();
    }
    
    public void startAction(ActionEvent evt){
        frame.switchToGame();
        frame.gameLogic.newGame();
    }

}
