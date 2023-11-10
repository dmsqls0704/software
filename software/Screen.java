package software;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.*;

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
	private CardLayout cardLayout;
	private JPanel cardPanel;
	
    public GameScreen() {
        setTitle("엎어라 뒤집어라");
        setSize(WIDTH, HEIGHT);
        
        try {
            Image iconImage = ImageIO.read(Screen.class.getResource("/image/logo.jpg"));
            setIconImage(iconImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        
        GridBagConstraints gbcT = new GridBagConstraints();
        
        JPanel startPanel = new JPanel();
        startPanel.setLayout(new GridBagLayout());
        
        startPanel.setBackground(new Color(248,244,235));
        
        JLabel title1 = new JLabel("엎어라");
        JLabel title2 = new JLabel("뒤집어라");
        title1.setHorizontalAlignment(SwingConstants.CENTER);
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        Font titleFont = new Font("Yeongdeok Haeparang", Font.PLAIN, 100);
        title1.setFont(titleFont);
        title2.setFont(titleFont);
        
        ImageIcon titleI = new ImageIcon(getClass().getResource("/image/yongyong3.png"));
        Image originaltitleImage = titleI.getImage();
        Image scaledtitleImage = originaltitleImage.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        titleI = new ImageIcon(scaledtitleImage);

        JLabel titleImage = new JLabel(titleI); 
        gbcT.insets = new Insets(10,400,200,50);
        startPanel.add(titleImage, gbcT);
        
        gbcT.gridx=0;
        gbcT.gridy=0;
        gbcT.insets = new Insets(10,10,100,150);
        startPanel.add(title1, gbcT);
        gbcT.insets = new Insets(150,100,10,10);
        startPanel.add(title2, gbcT);

        Font font = new Font("Yeongdeok sea", Font.PLAIN, 30);
   
        Color colorG1 = new Color(125, 159, 104);
        Color colorG2 = new Color(80, 102, 67);
        
        JButton loginButton = new JButton("로그인");
        loginButton.setPreferredSize(new Dimension(220, 60));
        loginButton.setFont(font);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            	saveOriginalSize();
                cardLayout.show(cardPanel, "loginPanel");
//                setSize(800, 600);
//                setResizable(false);
            }
        });
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
        	public void mouseEntered(java.awt.event.MouseEvent e) {
        		ImageIcon changeI = new ImageIcon(getClass().getResource("/image/yongyong4.png"));
        		Image originalchangeImage = changeI.getImage();
        		Image scaledchangeImage = originalchangeImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        		changeI = new ImageIcon(scaledchangeImage);
        		titleImage.setIcon(changeI);
        	}
        	public void mouseExited(java.awt.event.MouseEvent e) {
        		ImageIcon previousI = new ImageIcon(getClass().getResource("/image/yongyong3.png"));
        		Image originalpreviousImage = previousI.getImage();
        		Image scaledpreviousImage = originalpreviousImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        		previousI = new ImageIcon(scaledpreviousImage);
        		titleImage.setIcon(previousI);
        	}
        });
        
        loginButton.setBackground(colorG1);
		loginButton.setBorder(BorderFactory.createLineBorder(colorG2));
		UIManager.put("Button.focus", new ColorUIResource(colorG1));
		
        JButton joinButton = new JButton("회원가입");
        joinButton.setPreferredSize(new Dimension(220, 60));
        joinButton.setFont(font);
        joinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            	saveOriginalSize();
            	cardLayout.show(cardPanel, "joinPanel");
//                setSize(800, 600);
//                setResizable(false);
            }
        });
        joinButton.addMouseListener(new java.awt.event.MouseAdapter() {
        	public void mouseEntered(java.awt.event.MouseEvent e) {
        		ImageIcon changeI = new ImageIcon(getClass().getResource("/image/yongyong4.png"));
        		Image originalchangeImage = changeI.getImage();
        		Image scaledchangeImage = originalchangeImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        		changeI = new ImageIcon(scaledchangeImage);
        		titleImage.setIcon(changeI);
        	}
        	public void mouseExited(java.awt.event.MouseEvent e) {
        		ImageIcon previousI = new ImageIcon(getClass().getResource("/image/yongyong3.png"));
        		Image originalpreviousImage = previousI.getImage();
        		Image scaledpreviousImage = originalpreviousImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        		previousI = new ImageIcon(scaledpreviousImage);
        		titleImage.setIcon(previousI);
        	}
        });
        
        joinButton.setBackground(colorG1);
		joinButton.setBorder(BorderFactory.createLineBorder(colorG2));
		UIManager.put("Button.focus", new ColorUIResource(colorG1));
		
		GridBagConstraints gbcB = new GridBagConstraints();
		
		gbcB.gridy=1;
		gbcB.insets = new Insets(10,10,10,10);
		startPanel.add(loginButton, gbcB);
        
        gbcB.gridy=2;
        gbcB.insets = new Insets(10,10,150,10);
        startPanel.add(joinButton, gbcB);

        add(cardPanel);
        cardPanel.add(startPanel, "startPanel");

        LoginScreen loginScreen = new LoginScreen(cardLayout, cardPanel);
        cardPanel.add(loginScreen, "loginPanel");

        JoinScreen joinScreen = new JoinScreen(cardLayout, cardPanel);
        cardPanel.add(joinScreen, "joinPanel");
        
        cardLayout.show(cardPanel, "startPanel");
    }
    /*
    private int originalWidth;
    private int originalHeight;
    
    public void saveOriginalSize() {
        originalWidth = getWidth();
        originalHeight = getHeight();
    }
    public void returnScreenSize() {
        setSize(originalWidth, originalHeight);
        setResizable(true);
    }
    */
	public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;
}

class LoginScreen extends JPanel{
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private JTextField nickname;
	private JTextField password;
	private DataManager dataManager;
	private String[] userData; 
	
	public LoginScreen(CardLayout layout, JPanel panel) {  
        cardLayout = layout;
        cardPanel = panel;
        dataManager = new DataManager();
        
		setLayout(cardLayout);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        
        JPanel panelL = new JPanel();
        panelL.setLayout(new GridBagLayout());
        panelL.setBackground(new Color(248,244,235));
        
        Font titleFont = new Font("Yeongdeok Haeparang", Font.PLAIN, 50);
        Font font = new Font("Yeongdeok sea", Font.PLAIN, 40);
        
        JLabel titleLogin = new JLabel("로그인");
        titleLogin.setFont(titleFont);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10,10,10,10);
        panelL.add(titleLogin, gbc);
        
        JLabel titleName = new JLabel("닉네임");
        gbc.gridy=1;
        titleName.setFont(font);
        gbc.insets = new Insets(10,10,10,10);
        panelL.add(titleName, gbc);
        
        nickname = new JTextField(10);
        gbc.gridy=2;
        nickname.setFont(font);
        gbc.insets = new Insets(10,10,10,10);
        panelL.add(nickname,gbc);
        
        JLabel titlePW = new JLabel("비밀번호");
        gbc.gridy=3;
        titlePW.setFont(font);
        gbc.insets = new Insets(10,10,10,10);
        panelL.add(titlePW, gbc);
        
        password = new JPasswordField(10);
        gbc.gridy=4;
        password.setFont(font);
        gbc.insets = new Insets(10,10,10,10);
        panelL.add(password,gbc);
       
        Font fontB = new Font("Yeongdeok sea", Font.PLAIN, 30);
        Color colorG1 = new Color(125, 159, 104);
        Color colorG2 = new Color(80, 102, 67);
        
        JButton checkButton = new JButton("확인");
        checkButton.setPreferredSize(new Dimension(220, 60));
        checkButton.setFont(fontB);
        checkButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(dataManager.dataCheck(nickname.getText(), password.getText())){
        			userData = dataManager.getData(nickname.getText());
        	      
        	        MainScreen mainScreen = new MainScreen(cardLayout, cardPanel, LoginScreen.this);
        	        cardPanel.add(mainScreen, "mainPanel");
        			cardLayout.show(cardPanel, "mainPanel");
        		}
        		else {
        			JOptionPane.showMessageDialog(LoginScreen.this, "회원가입 후 로그인하세요", "입력 오류", JOptionPane.ERROR_MESSAGE);
        			cardLayout.show(cardPanel, "startPanel");
        			dataManager.clear(nickname, password);
        /*			GameScreen gameScreen = (GameScreen) SwingUtilities.getWindowAncestor(LoginScreen.this);
                    if (gameScreen != null) {
                        gameScreen.returnScreenSize();
                    } */
        		}
        	
        	}
        });
        
        checkButton.setBackground(colorG1);
		checkButton.setBorder(BorderFactory.createLineBorder(colorG2));
		UIManager.put("Button.focus", new ColorUIResource(colorG1));
		
		gbc.gridx=1;
		gbc.gridy=4;
		gbc.insets = new Insets(10,10,10,10);
		panelL.add(checkButton, gbc);
    
        add(panelL, "loginPanel");
	}
	
	public String[] getUser() {
		return userData;
	}
}

class JoinScreen extends JPanel{
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private JTextField nickname;
	private JTextField password;
	private DataManager dataManager;
	
	public JoinScreen(CardLayout layout, JPanel panel) {
		cardLayout = layout;
        cardPanel = panel;
        dataManager = new DataManager();
        
		setLayout(cardLayout);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        
        JPanel panelJ = new JPanel();
        panelJ.setLayout(new GridBagLayout());
        panelJ.setBackground(new Color(248,244,235));
        
        Font titleFont = new Font("Yeongdeok Haeparang", Font.PLAIN, 50);
        Font font = new Font("Yeongdeok sea", Font.PLAIN, 40);
        
        JLabel titleJoin = new JLabel("회원가입");
        titleJoin.setFont(titleFont);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10,10,10,10);
        panelJ.add(titleJoin, gbc);
        
        JLabel titleName = new JLabel("닉네임");
        gbc.gridy=1;
        titleName.setFont(font);
        gbc.insets = new Insets(10,10,10,10);
        panelJ.add(titleName, gbc);
        
        nickname = new JTextField(10);
        gbc.gridy=2;
        nickname.setFont(font);
        gbc.insets = new Insets(10,10,10,10);
        panelJ.add(nickname,gbc);
        
        JLabel titlePW = new JLabel("비밀번호");
        gbc.gridy=3;
        titlePW.setFont(font);
        gbc.insets = new Insets(10,10,10,10);
        panelJ.add(titlePW, gbc);
        
        password = new JPasswordField(10);
        gbc.gridy=4;
        password.setFont(font);
        gbc.insets = new Insets(10,10,10,10);
        panelJ.add(password,gbc);
       
        Font fontB = new Font("Yeongdeok sea", Font.PLAIN, 30);
        Color colorG1 = new Color(125, 159, 104);
        Color colorG2 = new Color(80, 102, 67);
        
        JButton checkButton = new JButton("확인");
        checkButton.setPreferredSize(new Dimension(220, 60));
        checkButton.setFont(fontB);
        checkButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                if (nickname.getText().trim().isEmpty() || password.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(JoinScreen.this, "닉네임과 비밀번호를 입력하세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
                } 
                else {
                    dataManager.saveData(nickname.getText(), password.getText());
                    dataManager.clear(nickname,password);
                    cardLayout.show(cardPanel, "startPanel");
              /*      GameScreen gameScreen = (GameScreen) SwingUtilities.getWindowAncestor(JoinScreen.this);
                    if (gameScreen != null) {
                        gameScreen.returnScreenSize();
                    }*/
                }
        	}	
        });
        checkButton.setBackground(colorG1);
		checkButton.setBorder(BorderFactory.createLineBorder(colorG2));
		UIManager.put("Button.focus", new ColorUIResource(colorG1));
		
		gbc.gridx=1;
		gbc.gridy=4;
		gbc.insets = new Insets(10,10,10,10);
		panelJ.add(checkButton, gbc);
    
        add(panelJ, "joinPanel");
	}
	
}

class MainScreen extends JPanel{
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private LoginScreen loginScreen;
	
	public MainScreen(CardLayout layout, JPanel panel,LoginScreen loginScreen) {  
		cardLayout = layout;
        cardPanel = panel;
        this.loginScreen = loginScreen;
        		
		setLayout(cardLayout);
		
		JPanel panelM = new JPanel();
        panelM.setLayout(new GridBagLayout());
        panelM.setBackground(new Color(248,244,235));
        
        JButton checkButton = new JButton("정보 열람");
        checkButton.setPreferredSize(new Dimension(220, 60));
        
        checkButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String[] userData = loginScreen.getUser();
		        CardInfo cardInfo = new CardInfo(cardLayout, cardPanel, MainScreen.this, userData);
				cardPanel.add(cardInfo, "infoPanel");
				cardLayout.show(cardPanel, "infoPanel");
        	}
        });		
        panelM.add(checkButton);
        
        add(panelM, "MainPanel");
	}
}

