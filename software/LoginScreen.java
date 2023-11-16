package software;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/** 
 * 
 * 로그인 화면을 실행하는 클래스이다. 
 * 
 */
public class LoginScreen extends JPanel{
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private JTextField nickname;
	private JTextField password;
	private DataManager dataManager;
	private String[] userData; 
	/**
	 * LoginScreen 클래스의 생성자이다.
	 * @param layout	CardLayout을 설정하는데 사용되는 객체
	 * @param panel		CardLayout이 포함된 패널
	 */
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
	    
	//    Font titleFont = new Font("Yeongdeok Haeparang", Font.PLAIN, 50);
	//    Font font = new Font("Yeongdeok sea", Font.PLAIN, 40);
	    Font titleFont = Utility.setFont1(50);
	    Font font = Utility.setFont2(40);
	    
	    /** 로그인 화면임을 알려주는 제목을 생성한다. */ 
	    JLabel titleLogin = new JLabel("로그인");
	    titleLogin.setFont(titleFont);
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.insets = new Insets(10,10,10,100);
	    panelL.add(titleLogin, gbc);
	    
	    /** 닉네임을 입력 받는 필드임을 알려주는 제목을 생성한다. */
	    JLabel titleName = new JLabel("닉네임");
	    gbc.gridy=1;
	    titleName.setFont(font);
	    gbc.insets = new Insets(10,10,10,100);
	    panelL.add(titleName, gbc);
	    /** 닉네임을 입력 받을 수 있는 필드를 생성한다. */
	    nickname = new JTextField(10);
	    gbc.gridy=2;
	    nickname.setFont(font);
	    gbc.insets = new Insets(10,10,10,100);
	    panelL.add(nickname,gbc);
	    
	    /** 비밀번호를 입력 받는 필드임을 알려주는 제목을 생성한다. */
	    JLabel titlePW = new JLabel("비밀번호");
	    gbc.gridy=3;
	    titlePW.setFont(font);
	    gbc.insets = new Insets(10,10,10,100);
	    panelL.add(titlePW, gbc);
	    /** 비밀번호를 입력 받을 수 있는 필드를 생성한다. */
	    password = new JPasswordField(10);
	    gbc.gridy=4;
	    password.setFont(font);
	    gbc.insets = new Insets(10,10,10,100);
	    panelL.add(password,gbc);
	   
	//    Font fontB = new Font("Yeongdeok sea", Font.PLAIN, 30);
	    Font fontB = Utility.setFont2(30);
	    
	    JButton backButton = new RoundedButton("");
	    backButton.setPreferredSize(new Dimension(80, 80));
	    backButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		cardLayout.show(cardPanel,"startPanel");
	    	}
	    });
	    backButton.setBackground(new Color(125, 159, 104));
	    backButton.setBorder(BorderFactory.createLineBorder(new Color(80, 102, 67)));
		UIManager.put("Button.focus", new ColorUIResource(new Color(125, 159, 104)));
		
		ImageIcon homeImage = new ImageIcon(getClass().getResource("/image/yongyonghome.png"));
	    Image originalhomeImage = homeImage.getImage();
	    Image scaledhomeImage = originalhomeImage.getScaledInstance(100,100, Image.SCALE_SMOOTH);
	    homeImage= new ImageIcon(scaledhomeImage);
	    
	    backButton.setIcon(homeImage);
	    
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.insets = new Insets(10,10,10,10);
		panelL.add(backButton, gbc);
		
	    /** 확인 버튼을 생성 */
	    JButton checkButton = new RoundedButton("확인");
	    checkButton.setPreferredSize(new Dimension(150, 50));
	    checkButton.setFont(fontB);
	    /** 버튼을 누르고 로그인에 성공했을 경우 메인 화면으로 넘어가도록 한다. */
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
    			
    		/*
      			GameScreen gameScreen = (GameScreen) SwingUtilities.getWindowAncestor(LoginScreen.this);
                	if (gameScreen != null) {
                    	gameScreen.returnScreenSize();
                	} */
	    		}
	    	
	    	}
	    });
	    
	    checkButton.setBackground(new Color(125, 159, 104));
		checkButton.setBorder(BorderFactory.createLineBorder(new Color(80, 102, 67)));
		UIManager.put("Button.focus", new ColorUIResource(new Color(125, 159, 104)));
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx=1;
		gbc.gridy=4;
		gbc.insets = new Insets(10,10,10,10);
		panelL.add(checkButton, gbc);
	
	    add(panelL, "loginPanel");
	}
	
	/** 유저의 정보를 받아오는 메소드이다. */
	public String[] getUser() {
		return userData;
	}
	
}
