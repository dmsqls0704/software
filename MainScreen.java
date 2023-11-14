package software;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class MainScreen extends JPanel{
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private LoginScreen loginScreen;
	
	public MainScreen(CardLayout layout, JPanel panel,LoginScreen loginScreen) {  
		cardLayout = layout;
    cardPanel = panel;
    this.loginScreen = loginScreen;
    		
		setLayout(cardLayout);
		Utility.playMusic();
    
		JPanel panelM = new JPanel();
    panelM.setLayout(new GridBagLayout());
    panelM.setBackground(new Color(248,244,235));
    
    JButton checkButton = new JButton("정보 열람");
    checkButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		String[] userData = loginScreen.getUser();
		        CardInfo cardInfo = new CardInfo(cardLayout, cardPanel, MainScreen.this, userData);
				cardPanel.add(cardInfo, "infoPanel");
				cardLayout.show(cardPanel, "infoPanel");
    	}
    });		
    panelM.add(checkButton);
    
    JButton soundOnButton = new JButton("on");
    JButton soundOffButton = new JButton("off");
    soundOnButton.setBackground(new Color(125,159,104));
		soundOnButton.setBorder(BorderFactory.createLineBorder(new Color(80,102,67)));
		UIManager.put("Button.focus", new ColorUIResource(new Color(125,159,104)));
		
		soundOffButton.setBackground(new Color(248,244,235));
		soundOffButton.setBorder(BorderFactory.createLineBorder(new Color(237,227,206)));
		UIManager.put("Button.focus", new ColorUIResource(new Color(248,244,235)));
		
    soundOnButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		Utility.startMusic();

    		soundOnButton.setBackground(new Color(125,159,104));
      		soundOnButton.setBorder(BorderFactory.createLineBorder(new Color(80,102,67)));
      		UIManager.put("Button.focus", new ColorUIResource(new Color(125,159,104)));
      		
      		soundOffButton.setBackground(new Color(248,244,235));
      		soundOffButton.setBorder(BorderFactory.createLineBorder(new Color(237,227,206)));
      		UIManager.put("Button.focus", new ColorUIResource(new Color(248,244,235)));
    	}
    });
    soundOffButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		Utility.stopMusic();
    		
    		soundOffButton.setBackground(new Color(125,159,104));
      		soundOffButton.setBorder(BorderFactory.createLineBorder(new Color(80,102,67)));
      		UIManager.put("Button.focus", new ColorUIResource(new Color(125,159,104)));
      		
      		soundOnButton.setBackground(new Color(248,244,235));
      		soundOnButton.setBorder(BorderFactory.createLineBorder(new Color(237,227,206)));
      		UIManager.put("Button.focus", new ColorUIResource(new Color(248,244,235)));
    	}
    });

    panelM.add(soundOnButton);
    panelM.add(soundOffButton);
    
    add(panelM, "MainPanel");
	}
}