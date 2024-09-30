package bitCube.main;

import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.*;

public class GamePanel extends JPanel {
    public Game frame;
    public GameLogic gameLogic;
    public GamePanel(Game frame){
        gameLogic = new GameLogic(this);
        this.frame = frame;
        initComponents();
        setButtonAction();
        setSkillAction();
    }

    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        TopPanel = new javax.swing.JPanel();
        HPbar = new javax.swing.JProgressBar();
        ScoreNum = new javax.swing.JLabel();
        ScoreLabel = new javax.swing.JLabel();
        MenuButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JToggleButton();
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
        BombSkillButton = new javax.swing.JButton();
        HealSkillButton = new javax.swing.JButton();
        FreezeSkillButton = new javax.swing.JButton();

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

        ScoreLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        ScoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        ScoreLabel.setText("Score:");

        MenuButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MenuButton.setText("Menu");
        MenuButton.addActionListener((e)->{
        	MenuButtonActionPerformed(e);
        });

        pauseButton.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        pauseButton.setText("| |");
        pauseButton.addActionListener((e)-> {
        	PauseButtonActionPerformed(e);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(HPbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, Short.MAX_VALUE)
                .addComponent(pauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MenuButton)
                .addGap(14, 14, 14))
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ScoreNum, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HPbar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(TopPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
        jToggleButton1.setPreferredSize(new java.awt.Dimension(136, 120));

        jToggleButton2.setBackground(new java.awt.Color(51, 0, 102));
        jToggleButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setSelected(true);
        jToggleButton2.setText("0");
        jToggleButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), null));
        jToggleButton2.setPreferredSize(new java.awt.Dimension(136, 120));

        jToggleButton3.setBackground(new java.awt.Color(51, 0, 102));
        jToggleButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jToggleButton3.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton3.setSelected(true);
        jToggleButton3.setText("0");
        jToggleButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), null));
        jToggleButton3.setPreferredSize(new java.awt.Dimension(136, 120));

        jToggleButton4.setBackground(new java.awt.Color(51, 0, 102));
        jToggleButton4.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jToggleButton4.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton4.setSelected(true);
        jToggleButton4.setText("0");
        jToggleButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), null));
        jToggleButton4.setPreferredSize(new java.awt.Dimension(136, 120));

        jToggleButton5.setBackground(new java.awt.Color(51, 0, 102));
        jToggleButton5.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jToggleButton5.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton5.setSelected(true);
        jToggleButton5.setText("0");
        jToggleButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), null));
        jToggleButton5.setPreferredSize(new java.awt.Dimension(136, 120));

        jToggleButton6.setBackground(new java.awt.Color(51, 0, 102));
        jToggleButton6.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jToggleButton6.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton6.setSelected(true);
        jToggleButton6.setText("0");
        jToggleButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), null));
        jToggleButton6.setPreferredSize(new java.awt.Dimension(136, 120));

        jToggleButton7.setBackground(new java.awt.Color(51, 0, 102));
        jToggleButton7.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jToggleButton7.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton7.setSelected(true);
        jToggleButton7.setText("0");
        jToggleButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), null));
        jToggleButton7.setPreferredSize(new java.awt.Dimension(136, 120));

        jToggleButton8.setBackground(new java.awt.Color(51, 0, 102));
        jToggleButton8.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jToggleButton8.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton8.setSelected(true);
        jToggleButton8.setText("0");
        jToggleButton8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), null));
        jToggleButton8.setPreferredSize(new java.awt.Dimension(136, 120));

        javax.swing.GroupLayout BitPanelLayout = new javax.swing.GroupLayout(BitPanel);
        BitPanel.setLayout(BitPanelLayout);
        BitPanelLayout.setHorizontalGroup(
            BitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BitPanelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        BitPanelLayout.setVerticalGroup(
            BitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BitPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        BombSkillButton.setBackground(new java.awt.Color(255, 102, 102));
        BombSkillButton.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        BombSkillButton.setForeground(new java.awt.Color(102, 51, 0));
        BombSkillButton.setText("Bomb");
        BombSkillButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 4, true));
        BombSkillButton.setPreferredSize(new java.awt.Dimension(117, 85));

        HealSkillButton.setBackground(new java.awt.Color(102, 255, 153));
        HealSkillButton.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        HealSkillButton.setForeground(new java.awt.Color(0, 102, 0));
        HealSkillButton.setText("Heal");
        HealSkillButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 4, true));
        HealSkillButton.setPreferredSize(new java.awt.Dimension(117, 85));

        FreezeSkillButton.setBackground(new java.awt.Color(102, 204, 255));
        FreezeSkillButton.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        FreezeSkillButton.setForeground(new java.awt.Color(0, 102, 255));
        FreezeSkillButton.setText("Freeze");
        FreezeSkillButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 4, true));
        FreezeSkillButton.setPreferredSize(new java.awt.Dimension(117, 85));
       

        javax.swing.GroupLayout SkillPanelLayout = new javax.swing.GroupLayout(SkillPanel);
        SkillPanel.setLayout(SkillPanelLayout);
        SkillPanelLayout.setHorizontalGroup(
            SkillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SkillPanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(BombSkillButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HealSkillButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FreezeSkillButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        SkillPanelLayout.setVerticalGroup(
            SkillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SkillPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SkillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BombSkillButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HealSkillButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FreezeSkillButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    	gameLogic.gamePause();
    	int response = JOptionPane.showConfirmDialog(
                BackgroundPanel,
                "This will reset your progress in the game. Do you want to proceed?",
                "Warning",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
    	if (response == JOptionPane.YES_OPTION) {
			gameLogic.gamePause();
			frame.switchToMenu();
		} else {
			gameLogic.gameStart();
		}
    }
    
    private void PauseButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	if (pauseButton.isSelected()) {
    		setButtonState(false);
    		for (Enemy e : gameLogic.enemies) {
				e.pauseState(true);
			}
    		
    		pauseButton.setText(">");
    		gameLogic.gamePause();
    	} else {
    		setButtonState(true);
    		for (Enemy e : gameLogic.enemies) {
    			e.pauseState(false);
    		}
    		
    		pauseButton.setText("| |");
    		gameLogic.gameStart();
    	}
    	togglePause(pauseButton.isSelected(),BombTimer,HealTimer,HealDuration,FreezeTimer,FreezeDuration);//this one for skill cool_down
    }

    
    // Variables declaration - do not modify
    private javax.swing.JToggleButton pauseButton;
    private javax.swing.JButton FreezeSkillButton;
    private javax.swing.JButton HealSkillButton;
    private javax.swing.JButton BombSkillButton;
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
    
    
    private void setSkillAction() {
    	
    	setBombSkillButtonAction();
    	setHealSkillButtonAction();
    	setFreezeSkillButtonAction();
    }
    
    private void setBombSkillButtonAction() {
    	BombSkillButton.addActionListener((e)-> {
    		gameLogic.removeAllEnemy(false);
    		startCooldown(BombSkillButton, 3, BombTimer);
    	});
    }
    
    private void setHealSkillButtonAction() {
    	HealSkillButton.addActionListener((e)-> {
    		//cool_down need to be more than skill duration if not it's going to be broken
    		healing(4,15);
    		startCooldown(HealSkillButton, 5, HealTimer);
    	});
    }
    
    private void healing(int second,int healing) {
    	HPbar.setValue(HPbar.getValue()+healing);
    	long startTime = System.currentTimeMillis();
    	HealDuration = new Timer(1000, (e)-> {
    		HPbar.setValue(HPbar.getValue()+healing);
    		long pastedTime = System.currentTimeMillis()-startTime;
    		if (pastedTime>=(second-1)*1000) {
				HealDuration.stop();
			}
    	});
    	HealDuration.setRepeats(true);
    	HealDuration.start();
    }
    
    private void setFreezeSkillButtonAction() {
    	FreezeSkillButton.addActionListener((e)-> {
    		//cool_down need to be more than skill duration if not it's going to be broken
    		freezing(5);
    		startCooldown(FreezeSkillButton, 6, FreezeTimer);
    	});
    }
    
    private void freezing(int second) {
    	
    	for (Enemy enemy : gameLogic.enemies) {
    		enemy.speed = enemy.speed/4;
    	}
    	FreezeDuration = new Timer(second*1000, (e)-> {
    		for (Enemy enemy : gameLogic.enemies) {
    			enemy.speed = gameLogic.defaultEnemySpeed;
    		}
    		FreezeDuration.stop();
    	});
    	FreezeDuration.setRepeats(false);
    	FreezeDuration.start();
    	
    	
    }
    
    private Timer BombTimer;
    private Timer HealTimer;
    private Timer HealDuration;
    private Timer FreezeTimer;
    private Timer FreezeDuration;

    
    
    
    private void pauseTimer(Timer timer) {
    	if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }
    
    private void resumeTimer(Timer timer) {
    	if (timer != null && !timer.isRunning()) {
            timer.start();
        }
    }
    
    public void togglePause(boolean isPaused, Timer... timers) {
    	
    	for (Timer timer : timers) {
    		if (isPaused) {
                pauseTimer(timer);
            } else {
                resumeTimer(timer);
            }


		}
     }
    
    private void startCooldown(JButton skillButton, int second, Timer skillTimer) {
    	String temp = skillButton.getText();
    	skillButton.setBackground(skillButton.getBackground().darker().darker().darker());
    	skillButton.setEnabled(false);
    	skillButton.setText("CD");
    	
    	skillTimer = new Timer(second*1000, (e)-> {
    		skillButton.setEnabled(true);
    		skillButton.setBackground(skillButton.getBackground().brighter().brighter().brighter());
    		skillButton.setText(temp);
    		((Timer) e.getSource()).stop();
    	});
    	
    	skillTimer.setRepeats(false);
    	skillTimer.start();
    	
    	if (skillButton == BombSkillButton) {
            BombTimer = skillTimer;
        } else if (skillButton == HealSkillButton) {
            HealTimer = skillTimer;
        } else if (skillButton == FreezeSkillButton) {
            FreezeTimer = skillTimer;
        }

    }
    
    private void setButtonState(boolean state) {
    	jToggleButton1.setEnabled(state);
    	jToggleButton2.setEnabled(state);
    	jToggleButton3.setEnabled(state);
    	jToggleButton4.setEnabled(state);
    	jToggleButton5.setEnabled(state);
    	jToggleButton6.setEnabled(state);
    	jToggleButton7.setEnabled(state);
    	jToggleButton8.setEnabled(state);
    	BombSkillButton.setEnabled(state);
    	HealSkillButton.setEnabled(state);
    	FreezeSkillButton.setEnabled(state);
    }
    
    private void setButtonAction() {
    	configureToggleButton(jToggleButton1,128);
    	configureToggleButton(jToggleButton2,64);
    	configureToggleButton(jToggleButton3,32);
    	configureToggleButton(jToggleButton4,16);
    	configureToggleButton(jToggleButton5,8);
    	configureToggleButton(jToggleButton6,4);
    	configureToggleButton(jToggleButton7,2);
    	configureToggleButton(jToggleButton8,1);
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

}
