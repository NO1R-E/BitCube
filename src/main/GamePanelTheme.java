package main;

import java.awt.Color;

public class GamePanelTheme {
	
	Color backgroundColor;
	Color topPanelColor;
	Color hpBarBackgroundColor;
	Color hpBarForegroundColor;
	Color scoreNumColor;
	Color scoreLabelColor;
	Color showStageColor;
	Color bottomPanelColor;
	Color toggleButtonColor;
	
	//TODO not all button include here
	public GamePanelTheme() {
		backgroundColor = new Color(25, 0, 51);
		topPanelColor = new Color(0, 51, 102);
		hpBarBackgroundColor = new Color(0, 0, 0);
		hpBarForegroundColor = new Color(0, 255, 0);
		scoreNumColor = new Color(255, 255, 255);
		scoreLabelColor = new Color(255, 255, 255);
		showStageColor = new Color(255, 255, 255);
		bottomPanelColor = new Color(0, 51, 102);
		toggleButtonColor = new Color(51, 0, 102);
	}
	
	public void setTheme(String theme) {
		switch(theme) {
			case "test":
				theme1();
				break;
			default:
				break;
		}
	}
	
	private void theme1() {
		backgroundColor = new Color(25, 25, 112); // Midnight Blue
		topPanelColor = new Color(0, 51, 102);    // Top Panel
		hpBarBackgroundColor = new Color(0, 0, 0); // HP Bar Background
		hpBarForegroundColor = new Color(0, 255, 0); // HP Bar Foreground
		scoreNumColor = new Color(255, 255, 255); // Score Number
		scoreLabelColor = new Color(255, 255, 255); // Score Label
		showStageColor = new Color(255, 255, 255); // Show Stage
		bottomPanelColor = new Color(112, 128, 144); // Slate Gray
		toggleButtonColor = new Color(128, 128, 0); // Olive Green
	}
	
}

