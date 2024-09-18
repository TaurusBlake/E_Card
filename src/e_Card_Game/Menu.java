package e_Card_Game;

import java.awt.CardLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener{
	JFrame gameFrame;
	JPanel menuPanel;
	JButton startButton,logButton,exitButton;
	CardLayout cardLayout;
	
	public Menu() {
		setTitle("E-card Game");
		setSize(1295,839);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		cardLayout = new CardLayout();
		menuPanel = new bg_Panel("img/background/background2.jpg");
        menuPanel.setBounds(0, 0, 1295, 839);
        menuPanel.setLayout(cardLayout);
        
     // 創建按鈕面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // 使按鈕面板透明
        buttonPanel.setLayout(null);  // 使用 null 佈局以便設定按鈕位置
		
		ImageIcon startIcon = new ImageIcon("img/button/start_button.png");
		startButton = new JButton(startIcon);
		startButton.setBounds(530, 400, 208, 76);
		startButton.setContentAreaFilled(false); // 透明內容區域
		startButton.addActionListener(this);
		
		ImageIcon logIcon = new ImageIcon("img/button/log_button.png");
		logButton = new JButton(logIcon);
		logButton.setBounds(530, 500, 208, 76);
		logButton.setContentAreaFilled(false);
		logButton.addActionListener(this);
		
		ImageIcon exitIcon = new ImageIcon("img/button/exit_button.png");
		exitButton = new JButton(exitIcon);
		exitButton.setBounds(530, 600, 208, 76);
		exitButton.setContentAreaFilled(false);
		exitButton.addActionListener(this);
		
		buttonPanel.add(startButton);
		buttonPanel.add(exitButton);
		buttonPanel.add(logButton);
		
		// 創建規則面板
		Rule rulePanel = new Rule(menuPanel, cardLayout);
		
        CharacterSelect characterSelectPanel = new CharacterSelect(menuPanel, cardLayout);
        
        GUI guiPanel = new GUI();
      
//		 添加背景
        menuPanel.add(buttonPanel,"Menu");
        menuPanel.add(rulePanel, "Rule");
        menuPanel.add(characterSelectPanel, "CharacterSelect");
        menuPanel.add(guiPanel, "GUI");
        
     // 顯示默認面板
        
        cardLayout.show(menuPanel, "Menu");
        
        
		add(menuPanel);
		setVisible(true);
		};
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==startButton) {
				cardLayout.show(menuPanel, "Rule");
			}else if (e.getSource()==logButton) {
				System.out.println("log");
			}else if (e.getSource()==exitButton) {
				System.exit(0);
			}		
		}
}
