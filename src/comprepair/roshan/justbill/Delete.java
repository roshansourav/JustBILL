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
import javax.swing.border.LineBorder;

public class Delete 
{
	String line;
	int counter, counter2;
	BufferedReader br;
	BufferedWriter bwTemp;
	
	public void init()
	{
		ImageIcon iconLogo  = new ImageIcon("src/assets/LogoJW.png");
	    Image imageLogo = iconLogo.getImage();
	    imageLogo = imageLogo.getScaledInstance(300,300, Image.SCALE_SMOOTH);
	    iconLogo.setImage(imageLogo);
		
		JFrame frmDelete = new JFrame();
		frmDelete.setSize(380, 500);
		frmDelete.setLayout(null);
		frmDelete.setLocationRelativeTo(null);
		frmDelete.setBackground(Color.ORANGE);
		frmDelete.setUndecorated(true);
		frmDelete.setIconImage(imageLogo);
		frmDelete.setOpacity(0.9f);
		
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
		
		JPanel pnlDeleteHeader = new JPanel(); //Header of the frame, because default-decoration being disabled
		pnlDeleteHeader.setBounds(0, 0, 380, 60);
		pnlDeleteHeader.setLayout(null);
		pnlDeleteHeader.setBackground(Color.BLACK);
		frmDelete.getContentPane().add(pnlDeleteHeader);
		pnlDeleteHeader.add(btnExit);
		
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
						Home objHomeDelete = new Home();
						objHomeDelete.init();
						frmDelete.dispose();
					}
				});
		pnlDeleteHeader.add(btnBack);  
		
		JLabel lblDeleteteTitle = new JLabel("Delete");
		lblDeleteteTitle.setBounds(140, 10, 200, 40);
		lblDeleteteTitle.setFont(new Font("SansSerif", Font.BOLD, 26));
		lblDeleteteTitle.setForeground(Color.WHITE);
		pnlDeleteHeader.add(lblDeleteteTitle);
		
		JPanel pnlDeleteBody = new JPanel();
		pnlDeleteBody.setBounds(0,60, 380, 440);
		pnlDeleteBody.setBackground(Color.CYAN);
		pnlDeleteBody.setLayout(null);
		frmDelete.getContentPane().add(pnlDeleteBody);
		
		
		JLabel lblDeleteItem = new JLabel("Item :");
		lblDeleteItem.setBounds(10, 45, 60, 40);
		lblDeleteItem.setFont(new Font("SansSerif", Font.BOLD, 16));
		pnlDeleteBody.add(lblDeleteItem);
		
		JComboBox<String> jcbDeleteItem = new JComboBox<String>();
		jcbDeleteItem.setBounds(115, 50, 250, 30);
		jcbDeleteItem.setBorder(new LineBorder(Color.BLACK, 2));
		pnlDeleteBody.add(jcbDeleteItem);
		
		try
		{
			br = new BufferedReader(new FileReader("src/assets/Item.txt"));
			String line = br.readLine();
			while(line != null)
			{
				jcbDeleteItem.addItem(line);
				line = br.readLine();
			}
			br.close();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "The file 'Item.txt' is missing");
		}
		
		ImageIcon iconDeleteItem  = new ImageIcon("src/assets/btnDeleteItem.png");
	    Image imageDeleteItem = iconDeleteItem.getImage();
	    imageDeleteItem = imageDeleteItem.getScaledInstance(78,78, Image.SCALE_SMOOTH);
	    iconDeleteItem.setImage(imageDeleteItem);
		
	    ImageIcon iconDeleteGif1 = new ImageIcon("src/assets/gifDelete.gif");
	    ImageIcon iconDeleteGif2 = new ImageIcon("src/assets/UploadProcessing.gif");
		JLabel l1 = new JLabel();
		l1.setIcon(iconDeleteGif1);
		l1.setBounds(80, 180, 380, 280); 
		pnlDeleteBody.add(l1);
	    
		JButton btnDeleteItem = new JButton(iconDeleteItem);
		btnDeleteItem.setBounds(160, 105, 80, 80);
		btnDeleteItem.setToolTipText("Delete");
		btnDeleteItem.setBackground(Color.CYAN);
		btnDeleteItem.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		btnDeleteItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if(JOptionPane.showConfirmDialog(null, "Are you sure to delete the item '"+jcbDeleteItem.getSelectedItem()+"' ?") == JOptionPane.YES_OPTION)
				{
					try 
					{
						counter = 0;
						counter2 = jcbDeleteItem.getSelectedIndex();
						l1.setIcon(iconDeleteGif2);
						
						br = new BufferedReader(new FileReader("src/assets/Item.txt"));
						bwTemp = new BufferedWriter(new FileWriter("src/assets/ItemTemp.txt"));
						line = br.readLine();
						while(line != null)
						{
							if(counter != counter2)
							{
								bwTemp.write(line);
								bwTemp.newLine();
							}
							line = br.readLine();
							counter++;
						}
						br.close();
						bwTemp.close();
						br = new BufferedReader(new FileReader("src/assets/ItemTemp.txt"));
						bwTemp = new BufferedWriter(new FileWriter("src/assets/Item.txt"));
						line = br.readLine();
						while(line != null)
						{
							bwTemp.write(line);
							bwTemp.newLine();
							line = br.readLine();
						}
						br.close();
						bwTemp.close();
						counter = 0;
						
				
						br = new BufferedReader(new FileReader("src/assets/Qty.txt"));
						bwTemp = new BufferedWriter(new FileWriter("src/assets/QtyTemp.txt"));
						line = br.readLine();
						while(line != null)
						{
							if(counter != counter2)
							{
								bwTemp.write(line);
								bwTemp.newLine();
							}
							line = br.readLine();
							counter++;
						}
						br.close();
						bwTemp.close();
						br = new BufferedReader(new FileReader("src/assets/QtyTemp.txt"));
						bwTemp = new BufferedWriter(new FileWriter("src/assets/Qty.txt"));
						line = br.readLine();
						while(line != null)
						{
							bwTemp.write(line);
							bwTemp.newLine();
							line = br.readLine();
						}
						br.close();
						bwTemp.close();
						counter = 0;
							
						br = new BufferedReader(new FileReader("src/assets/Price.txt"));
						bwTemp = new BufferedWriter(new FileWriter("src/assets/PriceTemp.txt"));
						line = br.readLine();
						while(line != null)
						{
							if(counter != counter2)
							{
								bwTemp.write(line);
								bwTemp.newLine();
							}
							line = br.readLine();
							counter++;
						}
						br.close();
						bwTemp.close();
						br = new BufferedReader(new FileReader("src/assets/PriceTemp.txt"));
						bwTemp = new BufferedWriter(new FileWriter("src/assets/Price.txt"));
						line = br.readLine();
						while(line != null)
						{
							bwTemp.write(line);
							bwTemp.newLine();
							line = br.readLine();
						}
						br.close();
						bwTemp.close();
						counter = 0;
						JOptionPane.showMessageDialog(null, "Successfully deleted the item '"+jcbDeleteItem.getSelectedItem()+"'");
						l1.setIcon(iconDeleteGif1);
						
						frmDelete.dispose();
						init();
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, ex);
						l1.setIcon(iconDeleteGif1);
					}
				}//IF closed here
			}
		});
		pnlDeleteBody.add(btnDeleteItem);
		
		
		
		
		
		
		MoveMouseListener mmlDelete = new MoveMouseListener(pnlDeleteHeader);
		pnlDeleteHeader.addMouseListener(mmlDelete);
		pnlDeleteHeader.addMouseMotionListener(mmlDelete);
		
		frmDelete.setVisible(true);
	
	}//init()_method closed here
}