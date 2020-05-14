package comprepair.roshan.justbill;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

public class Login 
{
	JButton btnLogin;
	
	public void loginFunction()
	{
		ImageIcon iconLogo  = new ImageIcon("src/assets/LogoJW.png");
	    Image imageLogo = iconLogo.getImage();
	    imageLogo = imageLogo.getScaledInstance(300,300, Image.SCALE_SMOOTH);
	    iconLogo.setImage(imageLogo);
		
		JFrame frmLogin = new JFrame(); //JFrame for login
		frmLogin.setSize(400, 350);
		frmLogin.setLayout(null);
		frmLogin.setUndecorated(true);
		frmLogin.setOpacity(0.9f);
		frmLogin.setIconImage(imageLogo);
		frmLogin.setLocationRelativeTo(null);
		
		
		
		JPanel pnlLoginHeader = new JPanel(); //Header of the frame, because default-decoration being disabled
		pnlLoginHeader.setBounds(0, 0, 400, 60);
		pnlLoginHeader.setLayout(null);
		pnlLoginHeader.setBackground(Color.BLACK);
		frmLogin.getContentPane().add(pnlLoginHeader);
		
		JPanel pnlLoginBody = new JPanel();// panel for the login body excluding header
		pnlLoginBody.setBounds(0, 60, 400, 290);
		pnlLoginBody.setLayout(null);
		pnlLoginBody.setBackground(Color.ORANGE);
		frmLogin.getContentPane().add(pnlLoginBody);
	    
		ImageIcon iconExit  = new ImageIcon("src/assets/ButtonCloseicon.png");
	    Image imageExit = iconExit.getImage();
	    imageExit = imageExit.getScaledInstance(40,40, Image.SCALE_SMOOTH);
	    iconExit.setImage(imageExit);
		
		JButton btnExit = new JButton(iconExit);         //exit_button 
		btnExit.setBounds(355, 10, 40, 40);
		btnExit.setBackground(Color.BLACK);
		btnExit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnExit.setToolTipText("QUIT");
		btnExit.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.exit(0);
					}
				});
		pnlLoginHeader.add(btnExit);
		
		Font fntLblTitle = new Font("SansSerif", Font.BOLD, 18);
		
		JLabel lblTitle = new JLabel("Login Please"); //label for frame title
		lblTitle.setBounds(10, 10, 320, 40);
		lblTitle.setFont(fntLblTitle);
		lblTitle.setForeground(Color.WHITE);
		pnlLoginHeader.add(lblTitle);
		
		Font fntPasswd = new Font("SansSerif", Font.BOLD, 18);
		JLabel lblPasswd = new JLabel("Password: ");
		lblPasswd.setBounds(40, 60, 150, 60);
		lblPasswd.setFont(fntPasswd);
		pnlLoginBody.add(lblPasswd);
		
		Font fntLblPwd = new Font("SansSerif", Font.BOLD, 42);
		
		JPasswordField pwdField = new JPasswordField();// passwordField  #textField for password
		pwdField.setBounds(160, 60, 200, 60);
		pwdField.setFont(fntLblPwd);
		pwdField.setBorder(new LineBorder(Color.YELLOW,2));
		pwdField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				btnLogin.doClick();
			}
		});
		
		pnlLoginBody.add(pwdField);
		
		ImageIcon iconLogin  = new ImageIcon("src/assets/ButtonLogin1.png");
	    Image imageLogin = iconLogin.getImage();
	    imageLogin = imageLogin.getScaledInstance(150,80, Image.SCALE_SMOOTH);
	    iconLogin.setImage(imageLogin);
		
	    
		btnLogin = new JButton(iconLogin);
		btnLogin.setBounds(210, 160, 150, 80);
		btnLogin.setBackground(Color.ORANGE);
		btnLogin.setBorder(new LineBorder(Color.ORANGE,1));
		btnLogin.setToolTipText("Login");
		pnlLoginBody.add(btnLogin);
		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String password1 = new String(pwdField.getPassword());
					int pw = Integer.parseInt(password1);
					if(pw == 1234)
					{
						Home objHome = new Home();
						objHome.init();
						frmLogin.dispose();	
					}
					else
						JOptionPane.showMessageDialog(null, "Incorrect Password. Please try again..");
				}catch(Exception ex) 
				{
					JOptionPane.showMessageDialog(null, "Incorrect Password. Please try again..");
					pwdField.requestFocusInWindow();
				}
			}
		});
		
		
		MoveMouseListener mml = new MoveMouseListener(pnlLoginHeader);
	    pnlLoginHeader.addMouseListener(mml);
	    pnlLoginHeader.addMouseMotionListener(mml);
		
	    frmLogin.setVisible(true);
	    pwdField.requestFocusInWindow();
	}

}