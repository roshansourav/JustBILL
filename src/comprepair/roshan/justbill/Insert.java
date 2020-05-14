package comprepair.roshan.justbill;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Insert 
{
	JButton btnAdd;
	BufferedWriter bw;
	
	public void init()
	{
		ImageIcon iconLogo  = new ImageIcon("src/assets/LogoJW.png");
	    Image imageLogo = iconLogo.getImage();
	    imageLogo = imageLogo.getScaledInstance(300,300, Image.SCALE_SMOOTH);
	    iconLogo.setImage(imageLogo);
		
		JFrame frmInsert = new JFrame();
		frmInsert.setSize(380, 500);
		frmInsert.setLayout(null);
		frmInsert.setLocationRelativeTo(null);
		frmInsert.setBackground(Color.ORANGE);
		frmInsert.setUndecorated(true);
		frmInsert.setIconImage(imageLogo);
		frmInsert.setOpacity(0.9f);
		
		ImageIcon iconExit  = new ImageIcon("src/assets/ButtonCloseicon.png");
	    Image imageExit = iconExit.getImage();
	    imageExit = imageExit.getScaledInstance(40,40, Image.SCALE_SMOOTH);
	    iconExit.setImage(imageExit);
		
		JButton btnExit = new JButton(iconExit);         
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
		
		JPanel pnlInsertHeader = new JPanel(); //Header of the frame, because default-decoration being disabled
		pnlInsertHeader.setBounds(0, 0, 380, 60);
		pnlInsertHeader.setLayout(null);
		pnlInsertHeader.setBackground(Color.BLACK);
		frmInsert.getContentPane().add(pnlInsertHeader);
		pnlInsertHeader.add(btnExit);
		
		ImageIcon iconBack  = new ImageIcon("src/assets/backButton.png");
	    Image imageBack = iconBack.getImage();
	    imageBack = imageBack.getScaledInstance(40,40, Image.SCALE_SMOOTH);
	    iconBack.setImage(imageBack);

		JButton btnBack = new JButton(iconBack);         
		btnBack.setBounds(5, 10, 40, 40);
		btnBack.setBackground(Color.BLACK);
		btnBack.setToolTipText("Back");
		btnBack.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnBack.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						Home objHomeInsert = new Home();
						objHomeInsert.init();
						frmInsert.dispose();
					}
				});
		pnlInsertHeader.add(btnBack);  
		
		Font fntTitle = new Font("SansSerif", Font.BOLD, 26);
		
		JLabel lblInsertTitle = new JLabel("Enter New Item");
		lblInsertTitle.setBounds(70, 10, 240, 40);
		lblInsertTitle.setFont(fntTitle);
		lblInsertTitle.setForeground(Color.WHITE);
		pnlInsertHeader.add(lblInsertTitle);
		
		JPanel pnlInsertBody = new JPanel();
		pnlInsertBody.setBounds(0,60,380, 440);
		pnlInsertBody.setBackground(Color.CYAN);
		pnlInsertBody.setLayout(null);
		frmInsert.getContentPane().add(pnlInsertBody);
		
		Font fnt1 = new Font("SansSerif", Font.BOLD, 18);
		
		JLabel lblInsertItem = new JLabel("Item Name :");
		lblInsertItem.setBounds(10, 20, 150, 40);
		lblInsertItem.setFont(fnt1);
		pnlInsertBody.add(lblInsertItem);
		
		Font fnt2 = new Font("SansSerif", Font.PLAIN, 16);
		
		JTextField txtInsertItem = new JTextField();
		txtInsertItem.setBounds(160, 20, 200, 30);
		txtInsertItem.setFont(fnt2);
		txtInsertItem.setForeground(Color.BLACK);
		txtInsertItem.setBorder(new LineBorder(Color.BLACK, 1));
		txtInsertItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				btnAdd.doClick();
			}
		});
		pnlInsertBody.add(txtInsertItem);
		
		Font fnt3 = new Font("SansSerif", Font.BOLD, 14);
		JLabel lblInsertQty = new JLabel("Quantity :");
		lblInsertQty.setBounds(10, 72, 80, 40);
		lblInsertQty.setFont(fnt3);
		pnlInsertBody.add(lblInsertQty);
		
		JTextField txtInsertQty = new JTextField();
		txtInsertQty.setBounds(100, 80, 70, 25);
		txtInsertQty.setForeground(Color.BLACK);
		txtInsertQty.setBorder(new LineBorder(Color.BLACK, 1));
		txtInsertQty.setFont(fnt2);
		txtInsertQty.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				btnAdd.doClick();
			}
		});
		pnlInsertBody.add(txtInsertQty);
		
		JLabel lblInsertPrice = new JLabel("Price :");
		lblInsertPrice.setBounds(230, 72, 70, 40);
		lblInsertPrice.setFont(fnt3);
		pnlInsertBody.add(lblInsertPrice);
		
		JTextField txtInsertPrice = new JTextField();
		txtInsertPrice.setBounds(290, 80, 70, 25);
		txtInsertPrice.setForeground(Color.BLACK);
		txtInsertPrice.setBorder(new LineBorder(Color.BLACK, 1));
		txtInsertPrice.setToolTipText("Selling Price");
		txtInsertPrice.setFont(fnt2);
		txtInsertPrice.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				btnAdd.doClick();
			}
		});
		pnlInsertBody.add(txtInsertPrice);
		
		
		ImageIcon iconUploadGif1 = new ImageIcon("src/assets/UploadStill.gif");
		ImageIcon iconUploadGif2 = new ImageIcon("src/assets/UploadProcessing.gif");
		JLabel l1 = new JLabel();
		l1.setIcon(iconUploadGif1);
		l1.setBounds(80, 180, 380, 280); 
		pnlInsertBody.add(l1);
		    
		ImageIcon iconAdd  = new ImageIcon("src/assets/addButton.png");//add_button image
		Image imageAdd = iconAdd.getImage();
		imageAdd = imageAdd.getScaledInstance(160,60, Image.SCALE_SMOOTH);
		iconAdd.setImage(imageAdd);
			 
		btnAdd = new JButton(iconAdd);         //Add_button 
		btnAdd.setBounds(200, 120, 160, 60);
		btnAdd.setBackground(Color.CYAN);
		btnAdd.setToolTipText("Add");
		btnAdd.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		    
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
				int q;//quantity
				int p;//price
				try
				{
					q = Integer.parseInt(txtInsertQty.getText());
					p = Integer.parseInt(txtInsertPrice.getText());
					if(txtInsertItem.getText().length() < 1)
					{
						JOptionPane.showMessageDialog(null, "Item_Name should not be empty");
					}	
					else
					{
						try
						{
							l1.setIcon(iconUploadGif2);
							bw = new BufferedWriter(new FileWriter("src/assets/Item.txt", true));
							bw.write(""+txtInsertItem.getText());
							bw.newLine();
							bw.close();
							bw = new BufferedWriter(new FileWriter("src/assets/Qty.txt", true));
							bw.write(""+q);
							bw.newLine();
							bw.close();
							bw = new BufferedWriter(new FileWriter("src/assets/Price.txt", true));
							bw.write(""+p);
							bw.newLine();
							bw.close();
							JOptionPane.showMessageDialog(null, "Item '"+txtInsertItem.getText()+"' with "+q+" quantity added successfully");
							l1.setIcon(iconUploadGif1);
							txtInsertItem.setText("");
							txtInsertQty.setText("");
							txtInsertPrice.setText("");
							txtInsertItem.requestFocusInWindow();
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null, ex);
						}
					}//else closed here
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Quantity/Price entered is not valid");
				}
			}
		});
		pnlInsertBody.add(btnAdd);
		
		
		MoveMouseListener mmlInsert = new MoveMouseListener(pnlInsertHeader);
		pnlInsertHeader.addMouseListener(mmlInsert);
		pnlInsertHeader.addMouseMotionListener(mmlInsert);
		
		
		frmInsert.setVisible(true);

	}//init()_method closed here
}