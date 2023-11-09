package software;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen
{
	public static void main(String[] args)
	{
		GameScreen screen = new GameScreen();
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setVisible(true);
	}
}


class GameScreen extends JFrame {
    public GameScreen() {
        setTitle("엎어라 뒤집어라");
        setSize(WIDTH, HEIGHT);
        
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);
        
        GridBagConstraints gbcT = new GridBagConstraints();
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        
        panel.setBackground(Color.WHITE);
        
        JLabel title1 = new JLabel("엎어라");
        JLabel title2 = new JLabel("뒤집어라");
        title1.setHorizontalAlignment(SwingConstants.CENTER);
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        Font titleFont = new Font("Yeongdeok Haeparang", Font.BOLD, 50);
        title1.setFont(titleFont);
        title2.setFont(titleFont);

        gbcT.gridx=0;
        gbcT.gridy=0;
        gbcT.insets = new Insets(10,10,200,100);
        panel.add(title1, gbcT);
        gbcT.insets = new Insets(10,100,10,10);
        panel.add(title2, gbcT);

        Font font = new Font("Yeongdeok sea", Font.BOLD, 20);
   
        Color colorG1 = new Color(125, 159, 104);
        Color colorG2 = new Color(80, 102, 67);

        JButton loginButton = new JButton("로그인");
        loginButton.setPreferredSize(new Dimension(200, 50));
        loginButton.setFont(font);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
            }
        });
        
        loginButton.setBackground(colorG1);
		loginButton.setBorder(BorderFactory.createLineBorder(colorG2));
		UIManager.put("Button.focus", new ColorUIResource(colorG1));
		
        JButton joinButton = new JButton("회원가입");
        joinButton.setPreferredSize(new Dimension(200, 50));
        joinButton.setFont(font);
        joinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        
            }
        });
        joinButton.setBackground(colorG1);
		joinButton.setBorder(BorderFactory.createLineBorder(colorG2));
		UIManager.put("Button.focus", new ColorUIResource(colorG1));
		
		GridBagConstraints gbcB = new GridBagConstraints();
        
		gbcB.gridy=1;
		gbcB.insets = new Insets(10,10,15,10);
		panel.add(loginButton, gbcB);
        
        gbcB.gridy=2;
        gbcB.insets = new Insets(10,10,15,10);
        panel.add(joinButton, gbcB);

        add(panel);
    }

	public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;
}
