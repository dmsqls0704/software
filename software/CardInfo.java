package software;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardInfo extends JPanel{
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private String[] data;
	
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
        
        gbc.gridy=0;
        panelI.add(userRank,gbc);
  
        Font font = new Font("Yeongdeok sea", Font.PLAIN, 30);
        
        ImageIcon rankI = new ImageIcon(getClass().getResource("/image/yongyong3.png"));
        Image originalImage = rankI.getImage();
        Image scaledImage = originalImage.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        rankI = new ImageIcon(scaledImage);
        JLabel rankImage = new JLabel(rankI);
        
        userRank.add(rankImage);
        
        JLabel userNick = new JLabel(data[0]);
        JLabel userScore = new JLabel(data[1]);
        userNick.setFont(font);
        userScore.setFont(font);
        
        userRank.add(userNick);
        userRank.add(userScore);
        
        JButton backButton = new JButton();
        ImageIcon homeImage = new ImageIcon(getClass().getResource("/image/yongyong4.png"));
        Image originalhomeImage = homeImage.getImage();
        Image scaledhomeImage = originalhomeImage.getScaledInstance(50,50, Image.SCALE_SMOOTH);
        homeImage= new ImageIcon(scaledhomeImage);
        
        backButton.setIcon(homeImage);
        backButton.setPreferredSize(new Dimension(50,50));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "mainPanel"); 
            }
        });
        backButton.setBackground(new Color(125, 159, 104));
        backButton.setBorder(BorderFactory.createLineBorder(new Color(80, 102, 67)));
        UIManager.put("Button.focus", new ColorUIResource(new Color(125, 159, 104)));
		
        userRank.add(backButton);
       
        JScrollPane scroll = new JScrollPane(panelI);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getVerticalScrollBar().setBackground(new Color(248,244,235));
        scroll.getHorizontalScrollBar().setBackground(new Color(248,244,235));
        
        ImageIcon cardbaekdo = new ImageIcon(getClass().getResource("/image/baekdo.jpg"));
        Image originalbaekdo = cardbaekdo.getImage();
        Image scaledbaekdo = originalbaekdo.getScaledInstance(225, 300, Image.SCALE_SMOOTH);
        cardbaekdo = new ImageIcon(scaledbaekdo);
        
        JLabel baekdo = new JLabel(cardbaekdo);
        gbc.gridy=1;
        gbc.insets = new Insets(10, 10, 10, 10);
        panelI.add(baekdo,gbc);
       
        ImageIcon cardbongji = new ImageIcon(getClass().getResource("/image/bongji.jpg"));
        Image originalbongji = cardbongji.getImage();
        Image scaledbongji = originalbongji.getScaledInstance(225, 300, Image.SCALE_SMOOTH);
        cardbongji = new ImageIcon(scaledbongji);
        
        JLabel bongji = new JLabel(cardbongji);
        gbc.insets = new Insets(10,10,10,10);
        panelI.add(bongji,gbc);
        
        ImageIcon cardclockt = new ImageIcon(getClass().getResource("/image/clockt.jpg"));
        Image originalclockt = cardclockt.getImage();
        Image scaledclockt = originalclockt.getScaledInstance(225, 300, Image.SCALE_SMOOTH);
        cardclockt = new ImageIcon(scaledclockt);
        
        JLabel clockt = new JLabel(cardclockt);
        gbc.insets = new Insets(10,10,10,10);
        panelI.add(clockt,gbc);
        
        ImageIcon carddido = new ImageIcon(getClass().getResource("/image/dido.jpg"));
        Image originaldido = carddido.getImage();
        Image scaleddido = originaldido.getScaledInstance(225, 300, Image.SCALE_SMOOTH);
        carddido = new ImageIcon(scaleddido);
        
        JLabel dido = new JLabel(carddido);
        gbc.gridy=2;
        gbc.insets = new Insets(10,10,10,10);
        panelI.add(dido,gbc);
        
        ImageIcon cardhongdo = new ImageIcon(getClass().getResource("/image/hongdo.jpg"));
        Image originalhongdo = cardhongdo.getImage();
        Image scaledhongdo = originalhongdo.getScaledInstance(225, 300, Image.SCALE_SMOOTH);
        cardhongdo = new ImageIcon(scaledhongdo);
        
        JLabel hongdo = new JLabel(cardhongdo);
        gbc.insets = new Insets(10,10,10,10);
        panelI.add(hongdo,gbc);
        
        ImageIcon cardplayground = new ImageIcon(getClass().getResource("/image/playground.jpg"));
        Image originalplayground = cardplayground.getImage();
        Image scaledplayground = originalplayground.getScaledInstance(225, 300, Image.SCALE_SMOOTH);
        cardplayground = new ImageIcon(scaledplayground);
        
        JLabel playground = new JLabel(cardplayground);
        gbc.insets = new Insets(10,10,10,10);
        panelI.add(playground,gbc);

        ImageIcon cardyongbongt = new ImageIcon(getClass().getResource("/image/yongbongt.jpg"));
        Image originalyongbongt = cardyongbongt.getImage();
        Image scaledyongbongt = originalyongbongt.getScaledInstance(225, 300, Image.SCALE_SMOOTH);
        cardyongbongt = new ImageIcon(scaledyongbongt);
        
        JLabel yongbongt = new JLabel(cardyongbongt);
        gbc.gridy=3;
        gbc.insets = new Insets(10,10,10,10);
        panelI.add(yongbongt,gbc);
        
        ImageIcon cardyongji = new ImageIcon(getClass().getResource("/image/yongji.jpg"));
        Image originalyongji = cardyongji.getImage();
        Image scaledyongji = originalyongji.getScaledInstance(225, 300, Image.SCALE_SMOOTH);
        cardyongji = new ImageIcon(scaledyongji);
        
        JLabel yongji = new JLabel(cardyongji);
        gbc.insets = new Insets(10,10,10,10);
        panelI.add(yongji,gbc);
        
        
        
        
        add(scroll, "InfoPanel");
//        add(panelI, "InfoPanel");
	}
}
