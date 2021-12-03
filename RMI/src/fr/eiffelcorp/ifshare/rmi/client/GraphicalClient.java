package fr.eiffelcorp.ifshare.rmi.client;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import fr.eiffelcorp.ifshare.rmi.common.IProduct;
import fr.eiffelcorp.ifshare.rmi.common.IShop;



@SuppressWarnings("deprecation")
public class GraphicalClient {
	private String nickname;
	private int token;
	private IShop s;
	public static void main(String[] args)  {
		try {
			String secpath = "src/fr/eiffelcorp/ifshare/rmi/client/.settings/";
			System.setProperty("java.security.policy", secpath + "sec.policy");
			System.setSecurityManager(new RMISecurityManager());
			IShop s = (IShop) Naming.lookup("rmi://localhost:8081/ShopService");
			
			
			var client = new GraphicalClient();
			client.setShop(s);
			client.getNickname();
			
			

			
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}
	
	public void setShop(IShop s) {
		this.s = s;
	}
	
	private void getNickname() {
		JFrame frame = new JFrame("IfIShare");
	       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	       frame.setSize(500,100);
	       frame.getContentPane().setLayout(new FlowLayout());
	       JPanel pane = (JPanel) frame.getContentPane();
	       var pseudo = new JLabel("Nickname: ");
	       pane.add(pseudo);
	       JPanel pannel = new JPanel();

	       JTextField  textNickname = new JTextField ();
	       textNickname.setPreferredSize(new Dimension(100, 20));
	       pannel.add(textNickname);
	       
	       
	       JButton bouton1 = new JButton("Send");
	       pannel.add(bouton1);

	       frame.getContentPane().add(pannel);
	       frame.setLocationRelativeTo(null);
	       frame.setVisible(true);
	       
	       bouton1.addActionListener( new ActionListener() {
	       			@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(textNickname.getText());
					nickname = textNickname.getText();
					frame.dispose();
					try {
						token = s.registerClient(nickname, new Observator());
						mainFrame();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					
				}
	        });
	}
	
	private void mainFrame () throws RemoteException {	
		JFrame frame = new JFrame("IfIShare");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(1200,700);
		JPanel pane = (JPanel) frame.getContentPane();
		
		pane.add(new JLabel(nickname), BorderLayout.NORTH);
		
		this.sellingBar(pane, frame);
		this.productsBar(pane);
		
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void productsBar(JPanel pane) {
		
		var bar = new JToolBar(1);
		
		bar.setPreferredSize(new Dimension(400, 20));
		try {
			var products = this.s.storeProducts().split(", ");
			System.out.println(s.storeProducts());
			
			for (var product: products) {
				
				bar.add(new JLabel(product));
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		pane.add(bar, BorderLayout.EAST);
		JScrollPane p = new JScrollPane(bar);
		pane.add(p, BorderLayout.EAST);
	}
	
	private void sellingBar(JPanel pane, JFrame frame) {
		JToolBar sellingBar = new JToolBar(1);
		sellingBar.setPreferredSize(new Dimension(300, 20));
		
		JTextField  productName = new JTextField ("Name");
		sellingBar.add(productName);
		
		JTextField  productKind = new JTextField ("Kind");
		sellingBar.add(productKind);
		
		
		
		JTextField  productPrice = new JTextField ("Price");
		sellingBar.add(productPrice);
		JTextArea  productComment = new JTextArea ("Comment");
		sellingBar.add(productComment);
		
		JButton sellButton =  new JButton("Sell");
		sellingBar.add(sellButton);
		
		JTextField  productNameToBuy = new JTextField ("Product name");
		sellingBar.add(productNameToBuy);
		
		JButton buyButton =  new JButton("Buy");
		sellingBar.add(buyButton);
		
		JButton refreshButton =  new JButton("Refresh");
		sellingBar.add(refreshButton);
		
		pane.add(sellingBar, BorderLayout.WEST);
		
		sellButton.addActionListener( new ActionListener() {
   			@Override
			public void actionPerformed(ActionEvent e) {
	   			try {
					IProduct product = new Product(productName.getText(), productKind.getText(), nickname, Double.parseDouble(productPrice.getText()), productComment.getText());
					System.out.println(s.buyFromClient(token, product));
					
					updateFrame(frame);
				} catch (NumberFormatException | RemoteException e2) {
					e2.printStackTrace();
				}	
   			}
   			
		});
		
		buyButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(s.sellToClient(token, productNameToBuy.getText()));
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		refreshButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				updateFrame(frame);
				
			}
		});
		
	}
	
	

	private void updateFrame(JFrame frame) {
		frame.dispose();
		try {
			this.mainFrame();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	

}
