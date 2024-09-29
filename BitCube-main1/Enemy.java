package main;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Enemy extends JPanel {
    public int defaultEnemySizeWidth = 243;
    public int defaultEnemySizeHeight = 135;
    public Random rand = new Random();
    public int numberRand = rand.nextInt(255);
    public float x;
    public float y;
    public float speed;
    public int type;

    public int getNumberRand() {
        return numberRand;
    }

    public Enemy(float x, float y ,float speed, int type){
        this.x = x;
        this.y = y;
        this.speed =speed;
        this.type = type;
        initComponents();
        setText();
        setBounds((int)x,(int)y,defaultEnemySizeWidth,defaultEnemySizeHeight);
    }
    private void initComponents() {

        number = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 255, 0));
        //setBorder(new javax.swing.border.MatteBorder(new javax.swing.ImageIcon(getClass().getResource("resources/greenBorder.png")))); // NOI18N
        setPreferredSize(new java.awt.Dimension(243, 135));

        number.setEditable(false);
        number.setBackground(new java.awt.Color(51, 102, 0));
        number.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        number.setForeground(new java.awt.Color(255, 255, 255));
        number.setText(" 0d");
        number.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(number, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(number, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }// </editor-fold>

    private void numberActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    // Variables declaration - do not modify
    private javax.swing.JTextField number;

    public void update(){
        x-=speed;
        this.setBounds((int)x,(int)y,243,135);
        this.add(number);
        //setText();
    }

    public void setText(){
        switch (type){
            case 0:
                number.setText(" 0o"+Integer.toOctalString(numberRand));
                number.setBackground(Color.red.darker().darker().darker());
                setBackground(Color.red);
                break;
            case 1:
                number.setText(" 0d"+numberRand);
                number.setBackground(Color.GREEN.darker().darker().darker());
                setBackground(Color.GREEN);
                break;
            case 2:
                number.setText(" 0x"+Integer.toHexString(numberRand).toUpperCase());
                number.setBackground(Color.blue.darker().darker().darker());
                setBackground(Color.blue);
                break;
        }
        this.add(number);
        this.revalidate();
        this.repaint();
    }
    public void setText1(){
                number.setText(" 0d"+numberRand);
                number.setBackground(Color.GREEN.darker().darker().darker());
                setBackground(Color.GREEN);
        this.add(number);
        this.revalidate();
        this.repaint();
    }
    public void setText2(){
         int numberRand2 = rand.nextInt(255);
         switch (type){
            case 0:
                number.setText(" 0o"+Integer.toOctalString(numberRand2));
                number.setBackground(Color.red.darker().darker().darker());
                setBackground(Color.red);
                break;
            case 1:
                number.setText(" 0d"+numberRand2);
                number.setBackground(Color.GREEN.darker().darker().darker());
                setBackground(Color.GREEN);
                break;
            case 2:
                number.setText(" 0x"+Integer.toHexString(numberRand2).toUpperCase());
                number.setBackground(Color.blue.darker().darker().darker());
                setBackground(Color.blue);
                break;
        }
        this.add(number);
        this.revalidate();
        this.repaint();
}
    public void setText3(){
        int numberRand2 = rand.nextInt(16);
        switch (type){
            case 0:
              number.setText(" 0o"+Integer.toOctalString(numberRand2));
             number.setBackground(Color.red.darker().darker().darker());
             setBackground(Color.red);
           break;
       case 1:
           number.setText(" 0d"+numberRand2);
           number.setBackground(Color.GREEN.darker().darker().darker());
           setBackground(Color.GREEN);
           break;
       case 2:
           number.setText(" 0x"+Integer.toHexString(numberRand2).toUpperCase());
           number.setBackground(Color.blue.darker().darker().darker());
           setBackground(Color.blue);
           break;
   }
   this.add(number);
   this.revalidate();
   this.repaint();
}

}
