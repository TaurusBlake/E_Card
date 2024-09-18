package e_Card_Game;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rule extends JPanel implements ActionListener {
    JPanel menuPanel;
    CardLayout cardLayout;
    JButton continueButton;

    public Rule(JPanel menuPanel, CardLayout cardLayout) {
        this.menuPanel = menuPanel;
        this.cardLayout = cardLayout;

        // 設置面板佈局
        setLayout(null);
        setBackground(Color.BLACK);
        // 設置背景圖片
        ImageIcon background = new ImageIcon("img/background/rule2.gif");
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 1280, 800);
        
        add(backgroundLabel);

        // 設置“繼續”按鈕
        ImageIcon continueIcon = new ImageIcon("img/button/start_button.png");
        continueButton = new JButton(continueIcon);
        continueButton.setBounds(1000, 700, 208, 76);
        continueButton.setContentAreaFilled(false);
        continueButton.addActionListener(this);

        // 將“繼續”按鈕添加到背景標籤
        add(continueButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == continueButton) {
        	cardLayout.show(menuPanel, "CharacterSelect");

        }
    }
}