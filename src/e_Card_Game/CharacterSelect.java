package e_Card_Game;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CharacterSelect extends JPanel implements ActionListener{
	
	JLabel selectLabel;
	JPanel menuPanel;
	CardLayout cardLayout;
    JButton kingButton,slaveButton;
    
	public CharacterSelect(JPanel menuPanel, CardLayout cardLayout){
		this.menuPanel = menuPanel;
		this.cardLayout = cardLayout;
		
		setLayout(null);
		setBounds(0, 0, 1280, 800);
		setBackground(Color.black);
		
        selectLabel = new JLabel("請選擇角色");
        selectLabel.setBounds(550, 30, 280, 50);
        selectLabel.setForeground(Color.WHITE);
        selectLabel.setFont(new Font("SimSun", Font.BOLD, 36));
        add(selectLabel);
		
		
		ImageIcon kingIcon = new ImageIcon("img/character/king.jpg");
		kingButton = new JButton(kingIcon);
		kingButton.setBounds(230, 100, kingIcon.getIconWidth(), kingIcon.getIconHeight());
		kingButton.setContentAreaFilled(false);
		kingButton.addActionListener(this);
		
		ImageIcon slaveIcon = new ImageIcon("img/character/slave.png");
		slaveButton = new JButton(slaveIcon);
		slaveButton.setBounds(730, 100, slaveIcon.getIconWidth(), slaveIcon.getIconHeight());
		slaveButton.setContentAreaFilled(false);
		slaveButton.addActionListener(this);
		
		add(slaveButton);
		add(kingButton);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == kingButton) {
            System.out.println("King selected");
            cardLayout.show(menuPanel, "GUI");
            // 添加角色選擇后的邏輯
        } else if (e.getSource() == slaveButton) {
            System.out.println("Slave selected");
            cardLayout.show(menuPanel, "GUI");
            // 添加角色選擇后的邏輯
        }
		
	}

}

