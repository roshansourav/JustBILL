package comprepair.roshan.justbill;

import java.awt.Color;
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
import javax.swing.border.LineBorder;

public class Home 
{
	ImageIcon iconLogo, iconAnim, iconExit, iconHome, iconBilling, iconInsert, iconUpdate, iconDelete;
	Image imageLogo, imageExit, imageHome, imageBilling, imageInsert, imageUpdate, imageDelete;
	JFrame frameMenu;
	JPanel pnlOptBody, pnlOptHeader;
	JLabel l1;
	JButton btnExit, btnHome, btnOptBilling, btnOptInsert, btnOptUpdate, btnOptDelete;
	
	MoveMouseListener mmlHome;
	
	public void init()
	{
		Billing objBilling = new Billing();
		Insert objInsert = new Insert();
		Update objUpdate = new Update();
		Delete objDelete = new Delete();
		
		iconLogo  = new ImageIcon("src/assets/LogoJW.png");
	    imageLogo = iconLogo.getImage();
	    imageLogo = imageLogo.getScaledInstance(300,300, Image.SCALE_SMOOTH);
	    iconLogo.setImage(imageLogo);
		
		frameMenu = new JFrame();
		frameMenu.setSize(380, 500);
		frameMenu.setLayout(null);
		frameMenu.setLocationRelativeTo(null);
		frameMenu.setBackground(Color.ORANGE);
		frameMenu.setUndecorated(true);
		frameMenu.setIconImage(imageLogo);
		frameMenu.setOpacity(0.95f);
		
		
		pnlOptBody = new JPanel();
		pnlOptBody.setBounds(0, 60, 380, 440);
		pnlOptBody.setLayout(null);
		pnlOptBody.setBackground(Color.cyan);
		frameMenu.getContentPane().add(pnlOptBody);

		iconAnim = new ImageIcon("src/assets/girlBicycleCyan1.gif");
		
		l1 = new JLabel();
		l1.setIcon(iconAnim);
		pnlOptBody.add(l1);
		l1.setBounds(230, 320, 150, 100);
				
		
		pnlOptHeader = new JPanel(); //Header of the frame, because default-decoration being disabled
		pnlOptHeader.setBounds(0, 0, 380, 60);
		pnlOptHeader.setLayout(null);
		pnlOptHeader.setBackground(Color.BLACK);
		frameMenu.getContentPane().add(pnlOptHeader);
		
		
		iconExit  = new ImageIcon("src/assets/ButtonCloseicon.png");
	    imageExit = iconExit.getImage();
	    imageExit = imageExit.getScaledInstance(40,40, Image.SCALE_SMOOTH);
	    iconExit.setImage(imageExit);
		
		btnExit = new JButton(iconExit);
		btnExit.setBounds(335, 10, 40, 40);
		btnExit.setBackground(Color.BLACK);
		btnExit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnExit.setToolTipText("QUIT");
		btnExit.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if(JOptionPane.showConfirmDialog(null, "Are you sure to Exit the App ?") == JOptionPane.YES_OPTION)
						{
							System.exit(0);
						}
					}
				});
		pnlOptHeader.add(btnExit);  
		
		
		iconHome  = new ImageIcon("src/assets/homeButton.png");
		imageHome = iconHome.getImage();
	    imageHome = imageHome.getScaledInstance(40,40, Image.SCALE_SMOOTH);
	    iconHome.setImage(imageHome);

		btnHome = new JButton(iconHome);          
		btnHome.setBounds(5, 10, 40, 40);
		btnHome.setBackground(Color.BLACK);
		btnHome.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnHome.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						
					}
				});
		pnlOptHeader.add(btnHome);  
		
		iconBilling  = new ImageIcon("src/assets/btnBilling.png");//Billing_button image
	    imageBilling = iconBilling.getImage();
	    imageBilling = imageBilling.getScaledInstance(195,58, Image.SCALE_SMOOTH);
	    iconBilling.setImage(imageBilling);
		
		btnOptBilling = new JButton(iconBilling);
		btnOptBilling.setBounds(30, 25, 200, 60);
		btnOptBilling.setBackground(Color.CYAN);
		btnOptBilling.setToolTipText("Create bill / Sell item");
		btnOptBilling.setBorder(new LineBorder(Color.CYAN,1));
		btnOptBilling.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				objBilling.init();
				frameMenu.dispose();
			}
		});
		pnlOptBody.add(btnOptBilling);
		
		iconInsert  = new ImageIcon("src/assets/btnInsert.png");//Insert_button image
	    imageInsert = iconInsert.getImage();
	    imageInsert = imageInsert.getScaledInstance(195,58, Image.SCALE_SMOOTH);
	    iconInsert.setImage(imageInsert);
		
		btnOptInsert = new JButton(iconInsert);
		btnOptInsert.setBounds(30, 120, 200, 60);
		btnOptInsert.setBackground(Color.CYAN);
		btnOptInsert.setBorder(new LineBorder(Color.CYAN,1));
		btnOptInsert.setToolTipText("Insert new item to the list");
		btnOptInsert.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				objInsert.init();
				frameMenu.dispose();
			}
		});
		pnlOptBody.add(btnOptInsert);
		
		iconUpdate  = new ImageIcon("src/assets/btnUpdate.png");//Update_button image
		imageUpdate = iconUpdate.getImage();
	    imageUpdate = imageUpdate.getScaledInstance(195,58, Image.SCALE_SMOOTH);
	    iconUpdate.setImage(imageUpdate);
		
		btnOptUpdate = new JButton(iconUpdate);
		btnOptUpdate.setBounds(30, 215, 200, 60);
		btnOptUpdate.setBackground(Color.CYAN);
		btnOptUpdate.setToolTipText("Update quantity / price");
		btnOptUpdate.setBorder(new LineBorder(Color.CYAN,1));
		btnOptUpdate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				objUpdate.init();
				frameMenu.dispose();
			}
		});
		pnlOptBody.add(btnOptUpdate);
		
		iconDelete  = new ImageIcon("src/assets/btnDelete.png");//Delete_button image
	    imageDelete = iconDelete.getImage();
	    imageDelete = imageDelete.getScaledInstance(195,58, Image.SCALE_SMOOTH);
	    iconDelete.setImage(imageDelete);
		
		btnOptDelete = new JButton(iconDelete);
		btnOptDelete.setBounds(30, 310, 200, 60);
		btnOptDelete.setBackground(Color.CYAN);
		btnOptDelete.setToolTipText("Delete item from the list");
		btnOptDelete.setBorder(new LineBorder(Color.CYAN,1));
		btnOptDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				objDelete.init();
				frameMenu.dispose();
			}
		});
		pnlOptBody.add(btnOptDelete);
		
		
		mmlHome = new MoveMouseListener(pnlOptHeader);
		pnlOptHeader.addMouseListener(mmlHome);
		pnlOptHeader.addMouseMotionListener(mmlHome);
		
		frameMenu.setVisible(true);
		
	}//init()_method closed here	
}