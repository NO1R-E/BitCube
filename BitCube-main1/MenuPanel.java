package main;

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
    }

    public void startAction(ActionEvent evt){
        frame.switchToGame();
        frame.gameLogic.resetGame();
        frame.gameLogic.gameStart();
    }

}
