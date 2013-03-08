import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JList;
import java.awt.FlowLayout;
import java.util.ArrayList;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import javax.swing.AbstractListModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.BoxLayout;

class ShoppingItemPanel extends JPanel {
  
	private ShoppingItem item;
	private JButton buyButton;
	
	public ShoppingItemPanel(final ShoppingItem item) {
		
		setLayout(new BorderLayout(0, 0));
		
		this.item = item;
		buyButton = new JButton("Köp");
		buyButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				IMatDataHandler2.addProduct(item.getProduct(), item.getAmount());
			}
			
		});
		
		Product product = item.getProduct();
		add(new JLabel(product.getName() + " Antal: " + item.getAmount() + " Pris: " + item.getTotal()), BorderLayout.WEST);
		add(buyButton,BorderLayout.EAST);
		
		setVisible(true);
	}
}

public class HistoryView extends JPanel {
	
	private JList orderJList;
	private ArrayList<Order> orderList = new ArrayList<Order>();
	private String recipeName = "2012 20/4";
	
	public HistoryView() {
		IMatDataHandler handler = IMatDataHandler.getInstance();
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel orderPanel = new JPanel();
		add(orderPanel, BorderLayout.CENTER);
		orderPanel.setLayout(new BorderLayout(0, 0));
		
		final JLabel orderLabel = new JLabel("");
		orderPanel.add(orderLabel, BorderLayout.NORTH);
		
//		final JList productList = new JList();
//		orderPanel.add(productList, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		orderPanel.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		final JLabel totalLabel = new JLabel("");
		panel.add(totalLabel);
		
		final JButton buyButton = new JButton("Köp");
		buyButton.setVisible(false);
		panel.add(buyButton);
		
		final JPanel productListPanel = new JPanel();
		orderPanel.add(productListPanel, BorderLayout.CENTER);
		productListPanel.setLayout(new BoxLayout(productListPanel, BoxLayout.Y_AXIS));
		
		JPanel historyListPanel = new JPanel();
		add(historyListPanel, BorderLayout.WEST);
		historyListPanel.setLayout(new BorderLayout(0, 0));
		
		orderJList = new JList();
		orderList = (ArrayList) handler.getOrders();
		String[] list = new String[orderList.size()];
		for (int i = 0; i < orderList.size(); i++) {
			list[i] = orderList.get(i).getDate().toString();
		}
		setList(orderJList,list); //Lägg till alla ordrar
		orderJList.setSelectedIndex(-1);
		historyListPanel.add(orderJList);
		orderJList.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting())
					return;
				buyButton.setVisible(true);
				Order current = orderList.get(orderJList.getSelectedIndex());
				orderLabel.setText(current.getDate().toString());
				
				ArrayList<ShoppingItem> shoppingItems = (ArrayList<ShoppingItem>) current.getItems();
				for (int i = 0; i < shoppingItems.size(); i++) {
					System.out.println(shoppingItems.get(i).getProduct().getName());
				}
				ShoppingItemPanel[] itemPanelList = new ShoppingItemPanel[shoppingItems.size()];
				int total = 0;
				for (int i = 0; i < shoppingItems.size(); i++) {
					itemPanelList[i] = new ShoppingItemPanel(shoppingItems.get(i));
					total += shoppingItems.get(i).getTotal();
				}
				totalLabel.setText("Totalt: " + total + " kr");
				setList(productListPanel,itemPanelList);
			}
			
		});
		
		buyButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Order current = orderList.get(orderJList.getSelectedIndex());
				ArrayList<ShoppingItem> products = (ArrayList<ShoppingItem>) current.getItems();
				for (int i = 0; i < products.size(); i++)
					IMatDataHandler2.addProduct(products.get(i).getProduct(),1);
			}
			
		});
		
	}
	
	public void setList(final JList list, final String[] newValues) {
		list.setModel(new AbstractListModel() {
			String[] values = newValues;
			
			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
			
		});
		
	}
	
	public void setList(final JPanel listPanel, final JPanel[] newValues) {
		listPanel.removeAll();
		listPanel.repaint();
		for( JPanel panel : newValues ){
			panel.setMaximumSize(new Dimension(500,20));
			listPanel.add(panel);
		}
	}
}
