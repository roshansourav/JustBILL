package comprepair.roshan.justbill;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Update 
{
	int qty, price, counter = 0, counter2 = 0, qtyCheck, newQty;
	String line;
	BufferedReader br;
	BufferedWriter bwTemp, bw;
	
	public void init()
	{
		ImageIcon iconLogo  = new ImageIcon("src/assets/LogoJW.png");
	    Image imageLogo = iconLogo.getImage();
	    imageLogo = imageLogo.getScaledInstance(300,300, Image.SCALE_SMOOTH);
	    iconLogo.setImage(imageLogo);
		
		JFrame frmUpdate = new JFrame();
		frmUpdate.setSize(380, 500);
		frmUpdate.setLayout(null);
		frmUpdate.setLocationRelativeTo(null);
		frmUpdate.setBackground(Color.ORANGE);
		frmUpdate.setUndecorated(true);
		frmUpdate.setIconImage(imageLogo);
		frmUpdate.setOpacity(0.9f);
		
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
		
		JPanel pnlUpdateHeader = new JPanel(); //Header of the frame, because default-decoration being disabled
		pnlUpdateHeader.setBounds(0, 0, 380, 60);
		pnlUpdateHeader.setLayout(null);
		pnlUpdateHeader.setBackground(Color.BLACK);
		frmUpdate.getContentPane().add(pnlUpdateHeader);
		pnlUpdateHeader.add(btnExit);
		
		JLabel lblUpdateTitle = new JLabel("Update");
		lblUpdateTitle.setBounds(140, 10, 200, 40);
		lblUpdateTitle.setFont(new Font("SansSerif", Font.BOLD, 26));
		lblUpdateTitle.setForeground(Color.WHITE);
		pnlUpdateHeader.add(lblUpdateTitle);
		
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
						Home objHomeUpdate = new Home();
						objHomeUpdate.init();
						frmUpdate.dispose();
					}
				});
		pnlUpdateHeader.add(btnBack);  
		
		
		JPanel pnlUpdateBody = new JPanel();
		pnlUpdateBody.setBounds(0,60, 380, 440);
		pnlUpdateBody.setBackground(Color.CYAN);
		pnlUpdateBody.setLayout(null);
		frmUpdate.getContentPane().add(pnlUpdateBody);
		
		JLabel lblUpdateItem = new JLabel("Item :");
		lblUpdateItem.setBounds(10, 45, 60, 40);
		lblUpdateItem.setFont(new Font("SansSerif", Font.BOLD, 16));
		pnlUpdateBody.add(lblUpdateItem);
		
		JComboBox<String> jcbUpdateItem = new JComboBox<String>();
		jcbUpdateItem.setBounds(115, 50, 250, 30);
		jcbUpdateItem.setBorder(new LineBorder(Color.BLACK, 2));
		pnlUpdateBody.add(jcbUpdateItem);
		
		JLabel lblUpdateQty = new JLabel("Quantity :");
		lblUpdateQty.setBounds(10, 105, 100, 40);
		lblUpdateQty.setFont(new Font("SansSerif", Font.BOLD, 16));
		pnlUpdateBody.add(lblUpdateQty);
		
		JTextField txtUpdateQty = new JTextField();
		txtUpdateQty.setBounds(120, 105, 140, 30);
		txtUpdateQty.setBorder(new LineBorder(Color.BLACK, 1));
		txtUpdateQty.setFont(new Font("SansSerif", Font.BOLD, 18));
		pnlUpdateBody.add(txtUpdateQty);
		
		JLabel lblUpdatePrice = new JLabel("Price :");
		lblUpdatePrice.setBounds(10, 155, 100, 40);
		lblUpdatePrice.setFont(new Font("SansSerif", Font.BOLD, 16));
		pnlUpdateBody.add(lblUpdatePrice);
		
		JTextField txtUpdatePrice = new JTextField();
		txtUpdatePrice.setBounds(120, 155, 140, 30);
		txtUpdatePrice.setBorder(new LineBorder(Color.BLACK, 1));
		txtUpdatePrice.setFont(new Font("SansSerif", Font.BOLD, 18));
		pnlUpdateBody.add(txtUpdatePrice);
		
		ImageIcon iconUploadGif1 = new ImageIcon("src/assets/UploadStill.gif");
		ImageIcon iconUploadGif2 = new ImageIcon("src/assets/UploadProcessing.gif");
		JLabel l1 = new JLabel();
		l1.setIcon(iconUploadGif1);
		l1.setBounds(80, 180, 380, 280); 
		pnlUpdateBody.add(l1);
		
		ImageIcon iconUpdate  = new ImageIcon("src/assets/btnUpdateAdd.png");
	    Image imageUpdate = iconUpdate.getImage();
	    imageUpdate = imageUpdate.getScaledInstance(78,78, Image.SCALE_SMOOTH);
	    iconUpdate.setImage(imageUpdate);
		
		JButton btnUpdateAdd = new JButton(iconUpdate);
		btnUpdateAdd.setBounds(280, 105, 80, 80);
		btnUpdateAdd.setToolTipText("Update");
		btnUpdateAdd.setBackground(Color.CYAN);
		btnUpdateAdd.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		btnUpdateAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					qty = Integer.parseInt(txtUpdateQty.getText());
					price = Integer.parseInt(txtUpdatePrice.getText());
					
					if(qty == 0 || price == 0)
					{
						JOptionPane.showMessageDialog(null, "'Qty' or 'Price' should not be zero");
					}
					else
					{	
						l1.setIcon(iconUploadGif2);
						br = new BufferedReader(new FileReader("src/assets/Qty.txt"));
	
						do
						{
							line = br.readLine();									
								
							if(counter == jcbUpdateItem.getSelectedIndex()) 
							{
								qtyCheck = Integer.parseInt(line);
								break;
							}
							counter++;
							
						}while(line != null);
							
							
						br = new BufferedReader(new FileReader("src/assets/Qty.txt"));
						bwTemp = new BufferedWriter(new FileWriter("src/assets/QtyTemp.txt"));
						line = br.readLine();
						newQty = qtyCheck+qty;
						while(line != null)
						{
							if(counter == counter2)
								bwTemp.write(""+newQty);
							else
								bwTemp.write(line);
							bwTemp.newLine();
							line = br.readLine();
							counter2++;
						}
							
						br.close();
						bwTemp.close();
							
						br = new BufferedReader(new FileReader("src/assets/QtyTemp.txt"));
						bw = new BufferedWriter(new FileWriter("src/assets/Qty.txt"));
						line = br.readLine();
						while(line != null)
						{
							bw.write(line);
							bw.newLine();
							line = br.readLine();
						}
						bw.close();
						br.close();

							
						counter2 = 0;
						br = new BufferedReader(new FileReader("src/assets/Price.txt"));
						bwTemp = new BufferedWriter(new FileWriter("src/assets/PriceTemp.txt"));
						line = br.readLine();
						while(line != null)
						{
							if(counter == counter2)
								bwTemp.write(""+price);
							else
								bwTemp.write(line);
							bwTemp.newLine();
							line = br.readLine();
							counter2++;
						}
					
						br.close();
						bwTemp.close();
					
						br = new BufferedReader(new FileReader("src/assets/PriceTemp.txt"));
						bw = new BufferedWriter(new FileWriter("src/assets/Price.txt"));
						line = br.readLine();
						while(line != null)
						{
							bw.write(line);
							bw.newLine();
							line = br.readLine();
						}
						bw.close();
						br.close();
							
				 
						counter=0;
						counter2 = 0;
						br.close();
						JOptionPane.showMessageDialog(null, "The item '"+jcbUpdateItem.getSelectedItem()+"' updated with quantity"
								+ " from "+qtyCheck+" to "+newQty+" and price "+price);
						l1.setIcon(iconUploadGif1);
						
					}//ELSE closed here
				}//Try closed here
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
					l1.setIcon(iconUploadGif1);
				}
			}
		});
		pnlUpdateBody.add(btnUpdateAdd);
		
		
		txtUpdateQty.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				btnUpdateAdd.doClick();
			}
		});// action listener for Qty
		txtUpdatePrice.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				btnUpdateAdd.doClick();
			}
		});// action listener for Price
		try
		{
			br = new BufferedReader(new FileReader("src/assets/Item.txt"));
			String line = br.readLine();
			while(line != null)
			{
				jcbUpdateItem.addItem(line);
				line = br.readLine();
			}
			br.close();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "The file 'Item.txt' is missing");
		}
		
		
		MoveMouseListener mmlUpdate = new MoveMouseListener(pnlUpdateHeader);
		pnlUpdateHeader.addMouseListener(mmlUpdate);
		pnlUpdateHeader.addMouseMotionListener(mmlUpdate);
		
		frmUpdate.setVisible(true);
	
		
	}//init()_method closed here
}