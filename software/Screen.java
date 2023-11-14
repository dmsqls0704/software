package software;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** 전체 게임 실행을 담당하는 클래스 */ 
public class Screen
{
	public static void main(String[] args)
	{
		GameScreen screen = new GameScreen();
		
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setVisible(true);
	}
}

/** 게임 시작 화면을 실행하는 클래스이다. */
class GameScreen extends JFrame {
	private CardLayout cardLayout;
	private JPanel cardPanel;
    /**
     * GameScreen클래스의 생성자이다.
     */
    public GameScreen() {
    	/** 전체 게임이름 설정 */
        setTitle("엎어라 뒤집어라");
        /** 게임 프레임 크기 설정 */
        setSize(WIDTH, HEIGHT);
        
        /** 게임 아이콘 변경 */
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
        
        /** 게임 제목 생성 */
        JLabel title1 = new JLabel("엎어라");
        JLabel title2 = new JLabel("뒤집어라");
        title1.setHorizontalAlignment(SwingConstants.CENTER);
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        //Font titleFont = new Font("Yeongdeok Haeparang", Font.PLAIN, 100);
        /** 게임 제목 폰트 설정 */
        Font titleFont = Utility.setFont1(100);
        title1.setFont(titleFont);
        title2.setFont(titleFont);
        
        /** 타이틀 이미지 생성 */
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

        //Font font = new Font("Yeongdeok sea", Font.PLAIN, 30);
        Font font = Utility.setFont2(30);
        
        /** 로그인 버튼을 생성 */
        JButton loginButton = new JButton("로그인");
        loginButton.setPreferredSize(new Dimension(220, 60));
        loginButton.setFont(font);
        /** 버튼을 누르면 로그인 화면으로 넘어가도록 한다.*/
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            	saveOriginalSize();
                cardLayout.show(cardPanel, "loginPanel");
//                setSize(800, 600);
//                setResizable(false);
            }
        });
        /** 로그인 버튼에 마우스 커서를 올렸을 때 타이틀 이미지가 변경되도록 한다. */
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
        
        loginButton.setBackground(new Color(125, 159, 104));
		loginButton.setBorder(BorderFactory.createLineBorder(new Color(80, 102, 67)));
		UIManager.put("Button.focus", new ColorUIResource(new Color(125, 159, 104)));
		
	/** 회원가입 버튼을 생성 */
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
        /** 버튼을 누르면 화면가입 화면으로 넘어가도록 한다. */
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
        
        joinButton.setBackground(new Color(125, 159, 104));
		joinButton.setBorder(BorderFactory.createLineBorder(new Color(80, 102, 67)));
		UIManager.put("Button.focus", new ColorUIResource(new Color(125, 159, 104)));
		
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
