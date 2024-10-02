package main;

import javax.swing.*;

import javafx.event.ActionEvent;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
public class GamePanel extends JPanel {
    public Game frame;
    public GameLogic gameLogic;
    private static final int Cooldownskill1 = 5000;
    public GamePanel(Game frame){
        gameLogic = new GameLogic(this);
        this.frame = frame;
        initComponents();
    }

    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        TopPanel = new javax.swing.JPanel();
        HPbar = new javax.swing.JProgressBar();
        ScoreNum = new javax.swing.JLabel();
        ScoreLabel = new javax.swing.JLabel();
        MenuButton = new javax.swing.JButton();
        BottomPanel = new javax.swing.JPanel();
        BitPanel = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        jToggleButton8 = new javax.swing.JToggleButton();
        numTabPanel = new javax.swing.JTabbedPane();
        OcPanel = new javax.swing.JPanel();
        OctalLabel = new javax.swing.JLabel();
        OctalNum = new javax.swing.JLabel();
        DeciPanel = new javax.swing.JPanel();
        DeciLabel = new javax.swing.JLabel();
        DeciNum = new javax.swing.JLabel();
        HexPanel = new javax.swing.JPanel();
        HexLabel = new javax.swing.JLabel();
        HexNum = new javax.swing.JLabel();
        SkillPanel = new javax.swing.JPanel();
        Skill1= new JButton();
        Skill2= new JButton();
        Skill3= new JButton();
        Skill4= new JButton();

        setPreferredSize(new java.awt.Dimension(1600, 900));

        BackgroundPanel.setBackground(new java.awt.Color(25, 0, 51));
        BackgroundPanel.setLayout(null);

        TopPanel.setBackground(new java.awt.Color(0, 51, 102));
        TopPanel.setPreferredSize(new java.awt.Dimension(1600, 80));

        HPbar.setBackground(new java.awt.Color(0, 0, 0));
        HPbar.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        HPbar.setForeground(new java.awt.Color(0, 255, 0));
        HPbar.setValue(100);
        HPbar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        HPbar.setPreferredSize(new java.awt.Dimension(600, 60));
        HPbar.setString("HP");
        HPbar.setStringPainted(true);

        ScoreNum.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        ScoreNum.setForeground(new java.awt.Color(255, 255, 255));
        ScoreNum.setText("00");

        ScoreLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 35)); // NOI18N
        ScoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        ScoreLabel.setText("Score:");

        MenuButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MenuButton.setText("Menu");
        MenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
                TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TopPanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(ScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ScoreNum, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(HPbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 410, Short.MAX_VALUE)
                                .addComponent(MenuButton)
                                .addGap(14, 14, 14))
        );
        TopPanelLayout.setVerticalGroup(
                TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TopPanelLayout.createSequentialGroup()
                                .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(TopPanelLayout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(MenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(TopPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(ScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ScoreNum, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(HPbar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(15, Short.MAX_VALUE))
        );

        BackgroundPanel.add(TopPanel);
        TopPanel.setBounds(0, 0, 1600, 80);

        BottomPanel.setBackground(new java.awt.Color(0, 51, 102));
        BottomPanel.setPreferredSize(new java.awt.Dimension(1600, 160));

        BitPanel.setPreferredSize(new java.awt.Dimension(1200, 148));

        jToggleButton1.setBackground(new java.awt.Color(51, 0, 102));
        jToggleButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setSelected(true);
        jToggleButton1.setText("0");
        jToggleButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), null));
        jToggleButton1.setPreferredSize(new java.awt.Dimension(138, 57));
        configureToggleButton(jToggleButton1,128);

        jToggleButton2.setBackground(new java.awt.Color(51, 0, 102));
        jToggleButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setSelected(true);
        jToggleButton2.setText("0");
        jToggleButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), null));
        jToggleButton2.setPreferredSize(new java.awt.Dimension(138, 57));
        configureToggleButton(jToggleButton2,64);

        jToggleButton3.setBackground(new java.awt.Color(51, 0, 102));
        jToggleButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jToggleButton3.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton3.setSelected(true);
        jToggleButton3.setText("0");
        jToggleButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), null));
        jToggleButton3.setPreferredSize(new java.awt.Dimension(138, 57));
        configureToggleButton(jToggleButton3,32);

        jToggleButton4.setBackground(new java.awt.Color(51, 0, 102));
        jToggleButton4.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jToggleButton4.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton4.setSelected(true);
        jToggleButton4.setText("0");
        jToggleButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), null));
        jToggleButton4.setPreferredSize(new java.awt.Dimension(138, 57));
        configureToggleButton(jToggleButton4,16);

        jToggleButton5.setBackground(new java.awt.Color(51, 0, 102));
        jToggleButton5.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jToggleButton5.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton5.setSelected(true);
        jToggleButton5.setText("0");
        jToggleButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), null));
        jToggleButton5.setPreferredSize(new java.awt.Dimension(138, 57));
        configureToggleButton(jToggleButton5, 8);

        jToggleButton6.setBackground(new java.awt.Color(51, 0, 102));
        jToggleButton6.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jToggleButton6.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton6.setSelected(true);
        jToggleButton6.setText("0");
        jToggleButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), null));
        jToggleButton6.setPreferredSize(new java.awt.Dimension(138, 57));
        configureToggleButton(jToggleButton6,4);

        jToggleButton7.setBackground(new java.awt.Color(51, 0, 102));
        jToggleButton7.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jToggleButton7.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton7.setSelected(true);
        jToggleButton7.setText("0");
        jToggleButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), null));
        jToggleButton7.setPreferredSize(new java.awt.Dimension(138, 57));
        configureToggleButton(jToggleButton7,2);

        jToggleButton8.setBackground(new java.awt.Color(51, 0, 102));
        jToggleButton8.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jToggleButton8.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton8.setSelected(true);
        jToggleButton8.setText("0");
        jToggleButton8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), null));
        jToggleButton8.setPreferredSize(new java.awt.Dimension(138, 57));
        configureToggleButton(jToggleButton8,1);

        javax.swing.GroupLayout BitPanelLayout = new javax.swing.GroupLayout(BitPanel);
        BitPanel.setLayout(BitPanelLayout);
        BitPanelLayout.setHorizontalGroup(
                BitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BitPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(jToggleButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        BitPanelLayout.setVerticalGroup(
                BitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BitPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(BitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToggleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToggleButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToggleButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToggleButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToggleButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToggleButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        numTabPanel.setToolTipText("");
        numTabPanel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        OcPanel.setForeground(new java.awt.Color(255, 102, 102));

        OctalLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        OctalLabel.setForeground(new java.awt.Color(255, 51, 51));
        OctalLabel.setText("Octal:");

        OctalNum.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        OctalNum.setForeground(new java.awt.Color(255, 51, 51));
        OctalNum.setText("377");


        javax.swing.GroupLayout OcPanelLayout = new javax.swing.GroupLayout(OcPanel);
        OcPanel.setLayout(OcPanelLayout);
        OcPanelLayout.setHorizontalGroup(
                OcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(OcPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(OctalLabel)
                                .addGap(18, 18, 18)
                                .addComponent(OctalNum)
                                .addContainerGap(119, Short.MAX_VALUE))
        );
        OcPanelLayout.setVerticalGroup(
                OcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(OcPanelLayout.createSequentialGroup()
                                .addContainerGap(24, Short.MAX_VALUE)
                                .addGroup(OcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(OctalLabel)
                                        .addComponent(OctalNum))
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        numTabPanel.addTab("0o", OcPanel);

        DeciLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 42)); // NOI18N
        DeciLabel.setForeground(new java.awt.Color(51, 153, 0));
        DeciLabel.setText("Decimal:");

        DeciNum.setFont(new java.awt.Font("Segoe UI Black", 1, 42)); // NOI18N
        DeciNum.setForeground(new java.awt.Color(51, 153, 0));
        DeciNum.setText("255");

        javax.swing.GroupLayout DeciPanelLayout = new javax.swing.GroupLayout(DeciPanel);
        DeciPanel.setLayout(DeciPanelLayout);
        DeciPanelLayout.setHorizontalGroup(
                DeciPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DeciPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(DeciLabel)
                                .addGap(18, 18, 18)
                                .addComponent(DeciNum)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DeciPanelLayout.setVerticalGroup(
                DeciPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DeciPanelLayout.createSequentialGroup()
                                .addContainerGap(28, Short.MAX_VALUE)
                                .addGroup(DeciPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DeciLabel)
                                        .addComponent(DeciNum))
                                .addContainerGap(28, Short.MAX_VALUE))
        );

        numTabPanel.addTab("0d", DeciPanel);

        HexLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        HexLabel.setForeground(new java.awt.Color(0, 0, 204));
        HexLabel.setText("Hexadecimal:");

        HexNum.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        HexNum.setForeground(new java.awt.Color(0, 0, 204));
        HexNum.setText("FF");

        javax.swing.GroupLayout HexPanelLayout = new javax.swing.GroupLayout(HexPanel);
        HexPanel.setLayout(HexPanelLayout);
        HexPanelLayout.setHorizontalGroup(
                HexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HexPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(HexLabel)
                                .addGap(18, 18, 18)
                                .addComponent(HexNum)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HexPanelLayout.setVerticalGroup(
                HexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HexPanelLayout.createSequentialGroup()
                                .addContainerGap(32, Short.MAX_VALUE)
                                .addGroup(HexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(HexLabel)
                                        .addComponent(HexNum))
                                .addContainerGap(31, Short.MAX_VALUE))
        );

        numTabPanel.addTab("0x", HexPanel);


        Skill1.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Skill1.setBounds(0, 0, WIDTH, HEIGHT);
        Skill1.setForeground(new java.awt.Color(255, 51, 51));
        Skill1.setText("skill1");

        Skill2.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Skill4.setBounds(0, 60, WIDTH, HEIGHT);
        Skill2.setForeground(new java.awt.Color(255, 51, 51));
        Skill2.setText("skill2");

        Skill3.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Skill3.setForeground(new java.awt.Color(255, 51, 51));
        Skill3.setText("skill3");

        Skill4.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Skill4.setForeground(new java.awt.Color(255, 51, 51));
        Skill4.setText("skill4");


        Skill1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                        System.out.println("Skill 1 button clicked!");
                        Skill1.setEnabled(false);
                        gameLogic.removeallEnemy();
                        
                }
            });
            Skill2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                        System.out.println("Skill 2 button clicked!");
                        //Skill2.setEnabled(false);
                        gameLogic.skill2();;
                }
            });
            Skill3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                        System.out.println("Skill 3 button clicked!");
                        //Skill2.setEnabled(false);
                        gameLogic.skill3();
                }
            });
            Skill4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                        System.out.println("Skill 4 button clicked!");
                        //Skill2.setEnabled(false);
                        gameLogic.Skill4();
                }
            });

        

        javax.swing.GroupLayout SkillPanelLayout = new javax.swing.GroupLayout(SkillPanel);
        SkillPanel.setLayout(new GridLayout());
        SkillPanelLayout.setHorizontalGroup(
                SkillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SkillPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Skill1)//, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Skill2)//, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Skill3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Skill4) //,javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
           ) );
            
            SkillPanelLayout.setVerticalGroup(
                SkillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SkillPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Skill1)//, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE) 
                       .addComponent(Skill2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addComponent(Skill3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addComponent(Skill4)//,, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                       // .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            ));
        SkillPanelLayout.addLayoutComponent(Skill1, SkillPanelLayout);
        numTabPanel.addTab("Skill", SkillPanel);

        javax.swing.GroupLayout BottomPanelLayout = new javax.swing.GroupLayout(BottomPanel);
        BottomPanel.setLayout(BottomPanelLayout);
        BottomPanelLayout.setHorizontalGroup(
                BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BottomPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(BitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numTabPanel)
                                .addContainerGap())
        );
        BottomPanelLayout.setVerticalGroup(
                BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BottomPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(numTabPanel)
                                        .addComponent(BitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        BackgroundPanel.add(BottomPanel);
        BottomPanel.setBounds(0, 740, 1600, 160);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
    }// </editor-fold>

    private void MenuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        gameLogic.pause();
        frame.switchToMenu();
    }

    private void configureToggleButton(JToggleButton toggleButton, int playerValue) {
        toggleButton.addActionListener((e -> {
            if (toggleButton.isSelected()) {
                gameLogic.currPlayerNumber -= playerValue;
                toggleButton.setText("0");
            } else {
                gameLogic.currPlayerNumber += playerValue;
                toggleButton.setText("1");
            }
        }));
    }

    // Variables declaration - do not modify
    public javax.swing.JPanel BackgroundPanel;
    private javax.swing.JPanel BitPanel;
    private javax.swing.JPanel BottomPanel;
    private javax.swing.JLabel DeciLabel;
    public javax.swing.JLabel DeciNum;
    private javax.swing.JPanel DeciPanel;
    public javax.swing.JProgressBar HPbar;
    private javax.swing.JLabel HexLabel;
    public javax.swing.JLabel HexNum;
    private javax.swing.JPanel HexPanel;
    private javax.swing.JButton MenuButton;
    private javax.swing.JPanel OcPanel;
    private javax.swing.JLabel OctalLabel;
    public javax.swing.JLabel OctalNum;
    private javax.swing.JLabel ScoreLabel;
    public javax.swing.JLabel ScoreNum;
    private javax.swing.JPanel SkillPanel;
    private javax.swing.JButton Skill1;
    private javax.swing.JButton Skill2;
    private javax.swing.JButton Skill3;
    private javax.swing.JButton Skill4;
    private javax.swing.JPanel TopPanel;
    public javax.swing.JToggleButton jToggleButton1;
    public javax.swing.JToggleButton jToggleButton2;
    public javax.swing.JToggleButton jToggleButton3;
    public javax.swing.JToggleButton jToggleButton4;
    public javax.swing.JToggleButton jToggleButton5;
    public javax.swing.JToggleButton jToggleButton6;
    public javax.swing.JToggleButton jToggleButton7;
    public javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JTabbedPane numTabPanel;
}
