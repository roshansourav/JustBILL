package comprepair.roshan.justbill;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Animation 
{
	public void animate()
	{
		ImageIcon iconLogo  = new ImageIcon("src/assets/LogoJW.png");
	    Image imageLogo = iconLogo.getImage();
	    imageLogo = imageLogo.getScaledInstance(350,350, Image.SCALE_SMOOTH);
	    iconLogo.setImage(imageLogo);
	    
	    JFrame frmAnim = new JFrame();
	    frmAnim.setSize(450, 450);
	    frmAnim.setLayout(null);
	    frmAnim.setUndecorated(true);
	    frmAnim.setLocationRelativeTo(null);
	    frmAnim.setIconImage(imageLogo);
	    
	    ImageIcon iconAnim = new ImageIcon("src/assets/giphy.gif");
	    JLabel l1 = new JLabel();
	    l1.setIcon(iconAnim);
	    l1.setBounds(0, 0, 450, 450); 
	    
	    
	    JPanel pnlAnim = new JPanel();
		pnlAnim.setLayout(null);
		pnlAnim.setBounds(0, 0, 450, 450);
		pnlAnim.add(l1);
		frmAnim.getContentPane().add(pnlAnim);
		
	    frmAnim.setVisible(true);
	    
	    try
		{
			Thread.sleep(5800);
		}catch(Exception ex){}
		
		frmAnim.dispose();
		Login objLogin = new Login();
		objLogin.loginFunction();
	}
}