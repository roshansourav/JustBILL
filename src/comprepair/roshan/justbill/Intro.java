package comprepair.roshan.justbill;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Intro 
{
	public void introLogo()
	{
		ImageIcon iconLogo  = new ImageIcon("src/assets/LogoJW.png");//image
	    Image imageLogo = iconLogo.getImage();
	    imageLogo = imageLogo.getScaledInstance(300,300, Image.SCALE_SMOOTH);
	    iconLogo.setImage(imageLogo);
		
		JFrame frmLogo = new JFrame();
		frmLogo.setSize(300, 300);
		frmLogo.setLayout(null);
		frmLogo.setUndecorated(true);
		frmLogo.setLocationRelativeTo(null);
		
	    frmLogo.setIconImage(imageLogo);
	  
	    JLabel l1 = new JLabel();
	    l1.setIcon(iconLogo);
	    l1.setBounds(0, 0, 300, 300);
	    JPanel pnlLogo = new JPanel();
		pnlLogo.setLayout(null);
		pnlLogo.setBounds(0, 0, 300, 300);
		pnlLogo.add(l1);
		frmLogo.getContentPane().add(pnlLogo);
		
		
		frmLogo.setVisible(true);
		
		try
		{
			Thread.sleep(2000);
		}catch(Exception ex){}
		
		frmLogo.dispose();
		Animation objAnimation = new Animation();
		objAnimation.animate();
		
		
		
	}
}