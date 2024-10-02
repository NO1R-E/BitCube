package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class SettingPanel extends JPanel{
	
	private Game frame;
	
	public static boolean OctalIsSelect = true;
	public static boolean DeciIsSelect = true;
	public static boolean HexIsSelect = true;
	public static int SelectedValue = 3;
	
	JSlider soundSlider;
	JSlider musicSlider;
	
	public SettingPanel(Game frame) {
		this.frame = frame;
		initComponents();
	}
	
	private void initComponents() {
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener((this::backButtonAction));
		add(backButton);
		
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(1600,900));
		setBackground(Color.CYAN);
		JCheckBox OctalCheckBox = new JCheckBox("Octal");
		add(OctalCheckBox);
		JCheckBox DeciCheckBox = new JCheckBox("Decimal");
		add(DeciCheckBox);
		JCheckBox HexCheckBox = new JCheckBox("Hexidecimal");
		add(HexCheckBox);
		
		OctalCheckBox.setSelected(true);
		OctalCheckBox.addActionListener((e)->{
			OctalIsSelect = OctalCheckBox.isSelected();
			if (OctalIsSelect) {
				SelectedValue++;
			} else {
				SelectedValue--;
			}
		});
		DeciCheckBox.setSelected(true);
		DeciCheckBox.addActionListener((e)->{
			DeciIsSelect = DeciCheckBox.isSelected();
			if (DeciIsSelect) {
				SelectedValue++;
			} else {
				SelectedValue--;
			}
		});
		HexCheckBox.setSelected(HexIsSelect);
		HexCheckBox.addActionListener((e)->{
			HexIsSelect = HexCheckBox.isSelected();
			if (HexIsSelect) {
				SelectedValue++;
			} else {
				SelectedValue--;
			}
		});
		
		soundSlider = new JSlider(0,100,30);
		add(soundSlider);
		soundSlider.addChangeListener(e -> {
            if (frame.sm.sound != null && frame.sm.soundVolumeControl != null) {
                frame.sm.setSoundVolume(soundSlider.getValue());
            }
        });

		
		musicSlider = new JSlider(0,100,05);
		add(musicSlider);
		musicSlider.addChangeListener(e -> {
            if (frame.sm.music != null && frame.sm.musicVolumeControl != null) {
                frame.sm.setMusicVolume(musicSlider.getValue());
            }
        });
	}
	
	
	public void backButtonAction(ActionEvent evt) {
		
		frame.switchToMenu();
	}
	
	
}

