package software;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * 정보 열람 화면을 실행하는 클래스이다. 
 * 사용자 닉네임, 최고 점수, 이미지를 보여준다.
 * 
 */
public class CardInfo extends JPanel{
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private String[] data;
	/**
	 * CardInfo 클래스의 생성자이다.
	 * @param layout	CardLayout을 설정하는데 사용되는 객체
	 * @param panel		CardLayout이 포함된 패널
	 * @param mainScreen	메인 화면으로 돌아가기 위한 객체
	 * @param data		사용자 정보를 담은 배열 (닉네임, 최고 점수)
	 */
	public CardInfo(CardLayout layout, JPanel panel, MainScreen mainScreen, String[] data){
		cardLayout = layout;
        cardPanel = panel;
        this.data = data;
        
		setLayout(cardLayout);
		GridBagConstraints gbc = new GridBagConstraints();
				
		JPanel panelI = new JPanel();
        panelI.setLayout(new GridBagLayout());
        panelI.setBackground(new Color(248,244,235));
        
        JPanel userRank = new JPanel();
        userRank.setLayout(new GridBagLayout());
        userRank.setBackground(new Color(237, 227, 206));
        
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
//        gbc.insets = new Insets(0,0,0,0);
        panelI.add(userRank,gbc);
  
//        Font font = new Font("Yeongdeok sea", Font.PLAIN, 30);
        Font font = Utility.setFont2(50);
        
        ImageIcon rankI = new ImageIcon(getClass().getResource("/image/trophy.png"));
        Image originalImage = rankI.getImage();
        Image scaledImage = originalImage.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        rankI = new ImageIcon(scaledImage);
        JLabel rankImage = new JLabel(rankI);
        gbc.insets = new Insets(10,10,10,10);
        userRank.add(rankImage);
        
        JLabel userNick = new JLabel(data[0]);
        JLabel userScore = new JLabel(data[1]);
        userNick.setFont(font);
        userScore.setFont(font);
        userScore.setForeground(new Color(125, 159, 104));
        
        gbc.gridx=1;
        gbc.insets = new Insets(10,10,10,10);
        userRank.add(userNick,gbc);
        
        gbc.gridx=2;
        gbc.insets = new Insets(10,10,10,10);
        userRank.add(userScore,gbc);
        
        JButton backButton = new JButton();
        ImageIcon homeImage = new ImageIcon(getClass().getResource("/image/yongyonghome.png"));
        Image originalhomeImage = homeImage.getImage();
        Image scaledhomeImage = originalhomeImage.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        homeImage= new ImageIcon(scaledhomeImage);
        
        backButton.setIcon(homeImage);
        backButton.setPreferredSize(new Dimension(80,80));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "mainPanel"); 
            }
        });
        backButton.setBackground(new Color(125, 159, 104));
        backButton.setBorder(BorderFactory.createLineBorder(new Color(80, 102, 67)));
        UIManager.put("Button.focus", new ColorUIResource(new Color(125, 159, 104)));
        
        gbc.gridx=3;
        gbc.insets = new Insets(10,10,10,10);
        userRank.add(backButton,gbc);
       
        JScrollPane scroll = new JScrollPane(panelI);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getVerticalScrollBar().setBackground(new Color(248,244,235));
        scroll.getHorizontalScrollBar().setBackground(new Color(248,244,235));
        
        ImageIcon cardplayground = new ImageIcon(getClass().getResource("/image/playground.jpg"));
        Image originalplayground = cardplayground.getImage();
        Image scaledplayground = originalplayground.getScaledInstance(225, 300, Image.SCALE_SMOOTH);
        cardplayground = new ImageIcon(scaledplayground);
        
        JLabel playground = new JLabel(cardplayground);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.insets = new Insets(10,10,10,10);
        panelI.add(playground,gbc);
        
        ImageIcon cardbongji = new ImageIcon(getClass().getResource("/image/bongji.jpg"));
        Image originalbongji = cardbongji.getImage();
        Image scaledbongji = originalbongji.getScaledInstance(225, 300, Image.SCALE_SMOOTH);
        cardbongji = new ImageIcon(scaledbongji);
        
        JLabel bongji = new JLabel(cardbongji);
        gbc.gridx=1;
        gbc.insets = new Insets(10,10,10,10);
        panelI.add(bongji,gbc);
        
        ImageIcon cardclockt = new ImageIcon(getClass().getResource("/image/clockt.jpg"));
        Image originalclockt = cardclockt.getImage();
        Image scaledclockt = originalclockt.getScaledInstance(225, 300, Image.SCALE_SMOOTH);
        cardclockt = new ImageIcon(scaledclockt);
        
        JLabel clockt = new JLabel(cardclockt);
        gbc.gridx=2;
        gbc.insets = new Insets(10,10,10,10);
        panelI.add(clockt,gbc);
        
        ImageIcon carddido = new ImageIcon(getClass().getResource("/image/dido.jpg"));
        Image originaldido = carddido.getImage();
        Image scaleddido = originaldido.getScaledInstance(225, 300, Image.SCALE_SMOOTH);
        carddido = new ImageIcon(scaleddido);
        
        JLabel dido = new JLabel(carddido);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.insets = new Insets(10,10,10,10);
        panelI.add(dido,gbc);
        
        ImageIcon cardhongdo = new ImageIcon(getClass().getResource("/image/hongdo.jpg"));
        Image originalhongdo = cardhongdo.getImage();
        Image scaledhongdo = originalhongdo.getScaledInstance(225, 300, Image.SCALE_SMOOTH);
        cardhongdo = new ImageIcon(scaledhongdo);
        
        JLabel hongdo = new JLabel(cardhongdo);
        gbc.gridx=1;
        gbc.insets = new Insets(10,10,10,10);
        panelI.add(hongdo,gbc);
        
        ImageIcon cardbaekdo = new ImageIcon(getClass().getResource("/image/baekdo.jpg"));
        Image originalbaekdo = cardbaekdo.getImage();
        Image scaledbaekdo = originalbaekdo.getScaledInstance(225, 300, Image.SCALE_SMOOTH);
        cardbaekdo = new ImageIcon(scaledbaekdo);
        
        JLabel baekdo = new JLabel(cardbaekdo);
        gbc.gridx=2;
        gbc.insets = new Insets(10, 10, 10, 10);
        panelI.add(baekdo,gbc);
       

        ImageIcon cardyongbongt = new ImageIcon(getClass().getResource("/image/yongbongt.jpg"));
        Image originalyongbongt = cardyongbongt.getImage();
        Image scaledyongbongt = originalyongbongt.getScaledInstance(225, 300, Image.SCALE_SMOOTH);
        cardyongbongt = new ImageIcon(scaledyongbongt);
        
        JLabel yongbongt = new JLabel(cardyongbongt);
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.insets = new Insets(10,10,10,10);
        panelI.add(yongbongt,gbc);
        
        ImageIcon cardyongji = new ImageIcon(getClass().getResource("/image/yongji.jpg"));
        Image originalyongji = cardyongji.getImage();
        Image scaledyongji = originalyongji.getScaledInstance(225, 300, Image.SCALE_SMOOTH);
        cardyongji = new ImageIcon(scaledyongji);
        
        JLabel yongji = new JLabel(cardyongji);
        gbc.gridx=1;
        gbc.insets = new Insets(10,10,10,10);
        panelI.add(yongji,gbc);
        
        add(scroll, "InfoPanel");
//        add(panelI, "InfoPanel");
	}
}
