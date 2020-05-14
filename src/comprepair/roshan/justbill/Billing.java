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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Billing 
{
	
	ImageIcon iconLogo, iconExit, iconBack, iconLogoGif, iconAdd;
	Image imageLogo, imageExit, imageBack, imageAdd;
	JFrame frmBilling;
	JButton btnExit, btnBack, btnAdd;
	JPanel pnlBillingHeader, pnlBillingBody, pnlBillingBody2;
	Font fntTitle, fntItemQty, fntQty;
	JLabel lblBillingTitle, lblBillingItem2, lblBillingQty2, l1, lblBillingPricePer, lblBillingPriceGross;
	JLabel lblBillingTotal, lblBillingItem, lblBillingQty;
	JTextArea txtArItemBilling, txtArQtyBilling, txtArPricePerBilling, txtArPriceGrossBilling;
	JTextField txtBillingQty;
	BufferedReader br;
	BufferedWriter bwTemp, bw;
	
	int Sum, qty, qtyCheck, i, counter = 0, counter2 = 0, newQty, pricePer, priceGross;
	String line, item;
	MoveMouseListener mmlBilling;
	
	
	public void init()
	{
		iconLogo  = new ImageIcon("src/assets/LogoJW.png");//LOGO_button image
	    imageLogo = iconLogo.getImage();
	    imageLogo = imageLogo.getScaledInstance(300,300, Image.SCALE_SMOOTH);
	    iconLogo.setImage(imageLogo);
		
		frmBilling = new JFrame();
		frmBilling.setSize(1100, 600);
		frmBilling.setLayout(null);
		frmBilling.setLocationRelativeTo(null);
		frmBilling.setUndecorated(true);
		frmBilling.setIconImage(imageLogo);
		frmBilling.setOpacity(0.9f);
		
		iconExit  = new ImageIcon("src/assets/ButtonCloseicon.png");
	    imageExit = iconExit.getImage();
	    imageExit = imageExit.getScaledInstance(40,40, Image.SCALE_SMOOTH);
	    iconExit.setImage(imageExit);
		
		btnExit = new JButton(iconExit);
		btnExit.setBounds(1055, 10, 40, 40);
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
		
		
		pnlBillingHeader = new JPanel(); //Header of the frame, because default-decoration being disabled
		pnlBillingHeader.setBounds(0, 0, 1100, 60);
		pnlBillingHeader.setLayout(null);
		pnlBillingHeader.setBackground(Color.BLACK);
		frmBilling.getContentPane().add(pnlBillingHeader);
		pnlBillingHeader.add(btnExit);
		
		fntTitle = new Font("SansSerif", Font.BOLD, 26);
		lblBillingTitle = new JLabel("Jaiswal Wheels"); 
		lblBillingTitle.setForeground(Color.WHITE);
		lblBillingTitle.setBounds(450, 7, 250, 40);
		lblBillingTitle.setFont(fntTitle);
		pnlBillingHeader.add(lblBillingTitle);
		

		iconBack  = new ImageIcon("src/assets/backButton.png");
	    imageBack = iconBack.getImage();
	    imageBack = imageBack.getScaledInstance(40,40, Image.SCALE_SMOOTH);
	    iconBack.setImage(imageBack);

		btnBack = new JButton(iconBack);         //Back_button 
		btnBack.setBounds(5, 10, 40, 40);
		btnBack.setBackground(Color.BLACK);
		btnBack.setToolTipText("Back");
		btnBack.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnBack.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						Home objHomeBilling = new Home();
						objHomeBilling.init();
						frmBilling.dispose();
					}
				});
		pnlBillingHeader.add(btnBack);  
		
		
		pnlBillingBody = new JPanel();
		pnlBillingBody.setBounds(0, 60, 400, 540);
		pnlBillingBody.setLayout(null);
		pnlBillingBody.setBackground(Color.CYAN);
		frmBilling.getContentPane().add(pnlBillingBody);
		
		lblBillingItem2 = new JLabel("Item");
		lblBillingItem2.setBounds(20, 10, 300, 20);
		pnlBillingBody.add(lblBillingItem2);
		
		lblBillingQty2 = new JLabel("Qty");
		lblBillingQty2.setBounds(350, 10, 60, 30);
		pnlBillingBody.add(lblBillingQty2);
		
		
		iconLogoGif = new ImageIcon("src/assets/Bicycle2.gif");
		l1 = new JLabel();
		l1.setIcon(iconLogoGif);
		l1.setBounds(0, 210, 400, 330); 
		pnlBillingBody.add(l1);
			

		pnlBillingBody2 = new JPanel();
		pnlBillingBody2.setBounds(410, 60, 790, 540);
		pnlBillingBody2.setLayout(null);
		pnlBillingBody2.setBackground(Color.CYAN);
		frmBilling.getContentPane().add(pnlBillingBody2);
		
		pnlBillingBody2.add(lblBillingItem2);
		pnlBillingBody2.add(lblBillingQty2);
		
		lblBillingPricePer = new JLabel("Price/per");
		lblBillingPricePer.setBounds(440, 10, 80, 30);
		pnlBillingBody2.add(lblBillingPricePer);
	
		lblBillingPriceGross = new JLabel("Price Gross");
		lblBillingPriceGross.setBounds(550, 10, 100, 30);
		pnlBillingBody2.add(lblBillingPriceGross);
		
		fntItemQty = new Font("SansSerif", Font.PLAIN, 14);
		
		txtArItemBilling = new JTextArea();
		txtArItemBilling.setBounds(20, 40, 300, 450);
		txtArItemBilling.setEditable(false);
		txtArItemBilling.setBackground(new Color(185, 255, 251));
		txtArItemBilling.setFont(fntItemQty);
		pnlBillingBody2.add(txtArItemBilling);
		
		txtArQtyBilling = new JTextArea();
		txtArQtyBilling.setBounds(350, 40, 60, 450);
		txtArQtyBilling.setFont(fntItemQty);
		txtArQtyBilling.setEditable(false);
		txtArQtyBilling.setBackground(new Color(185, 255, 251));
		pnlBillingBody2.add(txtArQtyBilling);
		
		txtArPricePerBilling = new JTextArea();
		txtArPricePerBilling.setBounds(440, 40, 80, 450);
		txtArPricePerBilling.setFont(fntItemQty);
		txtArPricePerBilling.setEditable(false);
		txtArPricePerBilling.setBackground(new Color(185, 255, 251));
		pnlBillingBody2.add(txtArPricePerBilling);
		
		txtArPriceGrossBilling = new JTextArea();
		txtArPriceGrossBilling.setBounds(550, 40, 100, 450);
		txtArPriceGrossBilling.setFont(fntItemQty);
		txtArPriceGrossBilling.setEditable(false);
		txtArPriceGrossBilling.setBackground(new Color(185, 255, 251));
		pnlBillingBody2.add(txtArPriceGrossBilling);
		
		Sum = 0;
		
		lblBillingTotal = new JLabel("Total = "+Sum);
		lblBillingTotal.setBounds(400, 480, 500, 60);
		lblBillingTotal.setFont(new Font("SansSerif", Font.BOLD, 18));
		pnlBillingBody2.add(lblBillingTotal);
		
	
		
		lblBillingItem = new JLabel("Item");
		lblBillingItem.setBounds(10, 10, 300, 20);
		pnlBillingBody.add(lblBillingItem);
		
		lblBillingQty = new JLabel("Qty");
		lblBillingQty.setBounds(330, 10, 60, 30);
		pnlBillingBody.add(lblBillingQty);
		
		
		
		
		JComboBox<String> jcbItemBilling = new JComboBox<String>();
		jcbItemBilling.setBounds(10, 40, 300, 30);
		jcbItemBilling.setBorder(new LineBorder(Color.BLACK,2));
		
		
		
		
		txtBillingQty = new JTextField();
		fntQty = new Font("SansSerif", Font.BOLD, 18);
		txtBillingQty.setBounds(330, 40, 60, 30);
		txtBillingQty.setBorder(new LineBorder(Color.BLACK,2));
		txtBillingQty.setFont(fntQty);
		txtBillingQty.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						btnAdd.doClick();
					}
				});
		
		pnlBillingBody.add(txtBillingQty);
		pnlBillingBody.add(jcbItemBilling);
		
		
		iconAdd  = new ImageIcon("src/assets/addButton.png");//add_button image
	    imageAdd = iconAdd.getImage();
	    imageAdd = imageAdd.getScaledInstance(160,60, Image.SCALE_SMOOTH);
	    iconAdd.setImage(imageAdd);
		 
	    btnAdd = new JButton(iconAdd);         //Add_button 
	    btnAdd.setBounds(220, 100, 160, 60);
	    btnAdd.setBackground(Color.CYAN);
	    btnAdd.setToolTipText("Add");
	    btnAdd.setBorder(BorderFactory.createLineBorder(Color.CYAN));
	    i=1;
	    btnAdd.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						try
						{
							qty = Integer.parseInt(txtBillingQty.getText());
							qtyCheck = 0;
							if(qty == 0)
							{
								JOptionPane.showMessageDialog(null, "'Qty' should not be zero");
							}
							else
							{	
								br = new BufferedReader(new FileReader("src/assets/Qty.txt"));
								
								do
								{
									line = br.readLine();									
										
									if(counter == jcbItemBilling.getSelectedIndex()) 
									{
										qtyCheck = Integer.parseInt(line);
										break;
									}
									counter++;
									
								}while(line != null);
								
								if (qty <= qtyCheck)
								{
									txtArQtyBilling.append("  "+qty+"\n");
									item = String.valueOf(jcbItemBilling.getSelectedItem());
									txtArItemBilling.append(" "+i+".  "+item+"\n");
									i++;
									
									br = new BufferedReader(new FileReader("src/assets/Qty.txt"));
									bwTemp = new BufferedWriter(new FileWriter("src/assets/QtyTemp.txt"));
									line = br.readLine();
									newQty = qtyCheck-qty;
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

									
									counter = 0;
									br = new BufferedReader(new FileReader("src/assets/Price.txt"));
									do
									{
										line = br.readLine();									
											
										if(counter == jcbItemBilling.getSelectedIndex()) 
										{
											pricePer = Integer.parseInt(line);
											break;
										}
										counter++;
									}while(line != null);
									
									txtArPricePerBilling.append(" ₹ "+pricePer+".00"+"\n");
									priceGross = pricePer*qty;
									txtArPriceGrossBilling.append(" ₹ "+priceGross+".00"+"\n");
									Sum = Sum + priceGross;
									lblBillingTotal.setText("Total = ₹ "+Sum+".00");
									
									br.close();

									
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Only "+qtyCheck+" quantity are available of the selected item");
								} 
								counter=0;
								counter2 = 0;
								br.close();
								
							}//ELSE closed here
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null, ex);
						}
					}
				});//btnAdd_event closed here
		pnlBillingBody.add(btnAdd); 
		
		try
		{
			br = new BufferedReader(new FileReader("src/assets/Item.txt"));
			String line = br.readLine();
			while(line != null)
			{
				jcbItemBilling.addItem(line);
				line = br.readLine();
			}
			br.close();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "The file 'Item.txt' is missing");
		}
		
		
		
		mmlBilling = new MoveMouseListener(pnlBillingHeader);
		pnlBillingHeader.addMouseListener(mmlBilling);
		pnlBillingHeader.addMouseMotionListener(mmlBilling);
		
		frmBilling.setVisible(true);
	}//init()_method closed here
	
}