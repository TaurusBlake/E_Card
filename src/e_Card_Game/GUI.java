package e_Card_Game;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class GUI extends JPanel  {
	Game game = new Game();
	CardLayout cardLayout;
	JPanel cardPanel = new JPanel();
	JPanel npcPanel = new JPanel();
	JPanel infPanel = new JPanel();
	JPanel playerboxPanel = new JPanel();
	JPanel npcboxPanel = new JPanel();
    JPanel plbetPanel = new JPanel(); // 下注區
    JPanel npcbetPanel = new JPanel();
    JLabel plcoinsLabel = new JLabel("Coins:"); // 顯示持有金幣的標籤
    JLabel npccoinsLabel = new JLabel("Coins:"); // 顯示持有金幣的標籤
    JLabel RoundLabel = new JLabel("Round:"+game.getRound());
    JTextField plbetField = new JTextField("0"); // 下注金額輸入框
    JTextField npcbetField = new JTextField("0"); // 下注金額輸入框
    
	GUI(){
		this.setSize(1280, 800);
		this.setLayout(null);
		
		LineBorder infBorder = new LineBorder(Color.BLACK, 4); 
        infPanel.setBorder(infBorder);
		infPanel.setBounds(1000, 0, 280, 800);
		infPanel.setBackground(Color.green);
		infPanel.setLayout(new FlowLayout());
		
		LineBorder npcBorder = new LineBorder(Color.BLACK, 4); 
        npcPanel.setBorder(npcBorder);
		npcPanel.setBounds(0, 0, 1000, 380);
		npcPanel.setBackground(Color.green);
		npcPanel.setLayout(new FlowLayout());
		
		LineBorder playerBorder = new LineBorder(Color.BLACK, 4); 
        cardPanel.setBorder(playerBorder);
		cardPanel.setBounds(0, 380, 1000, 430);
		cardPanel.setBackground(Color.green);
		cardPanel.setLayout(new FlowLayout());
		
		LineBorder boxBorder = new LineBorder(new Color(165,42,42), 4); 
		playerboxPanel.setBorder(boxBorder);
		playerboxPanel.setBounds(500, 200, 110, 150);
		playerboxPanel.setBackground(Color.green);
		
        npcboxPanel.setBorder(boxBorder);
		npcboxPanel.setBounds(500, 400, 110, 150);
		npcboxPanel.setBackground(Color.green);
		
		 // 設置 betPanel（下注區）
        plbetPanel.setBorder(new LineBorder(Color.BLACK, 4));
        plbetPanel.setBounds(700, 400, 180, 100); // 設置位置和大小
        plbetPanel.setBackground(Color.LIGHT_GRAY);
        plbetPanel.setLayout(new GridLayout(2, 1)); // 使用 GridLayout 以便排版
        
        // 設置持有金幣的標籤
        plcoinsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        plcoinsLabel.setFont(new Font("Arial", Font.BOLD, 28));
        plbetPanel.add(plcoinsLabel);
        
        // 設置下注金額的輸入框
        plbetField.setHorizontalAlignment(SwingConstants.CENTER);
        plbetField.setFont(new Font("Arial", Font.BOLD, 28));
        plbetPanel.add(plbetField);
        
		 // 設置 npcbetPanel（下注區）
        npcbetPanel.setBorder(new LineBorder(Color.BLACK, 4));
        npcbetPanel.setBounds(700, 250, 180, 100); // 設置位置和大小
        npcbetPanel.setBackground(Color.LIGHT_GRAY);
        npcbetPanel.setLayout(new GridLayout(2, 1)); // 使用 GridLayout 以便排版
        
        // 設置持有金幣的標籤
        npccoinsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        npccoinsLabel.setFont(new Font("Arial", Font.BOLD, 28));
        npcbetPanel.add(npccoinsLabel);
        
        // 設置下注金額的輸入框
        npcbetField.setHorizontalAlignment(SwingConstants.CENTER);
        npcbetField.setFont(new Font("Arial", Font.BOLD, 28));
        npcbetPanel.add(npcbetField);
        
        // 設置持Round標籤
        RoundLabel.setHorizontalAlignment(SwingConstants.CENTER);
        RoundLabel.setFont(new Font("Arial", Font.BOLD, 40));
        infPanel.add(RoundLabel);
        
        
        this.add(npcbetPanel);
        this.add(plbetPanel);
        this.add(npcboxPanel);
        this.add(playerboxPanel);
        this.add(infPanel);
        this.add(npcPanel);
        this.add(cardPanel);
        this.setVisible(true);		
		
	}
}
