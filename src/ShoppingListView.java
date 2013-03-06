import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;


public class ShoppingListView extends JPanel implements ShoppingCartListener {
	
	private JPanel listPanel;
	
	public ShoppingListView(){
		setLayout(new BorderLayout(0, 0));
		
		listPanel = new JPanel();
		JPanel content = new JPanel(new BorderLayout());
		content.setOpaque(false);
		content.add(listPanel, BorderLayout.NORTH);
		JPanel centerFiller = new JPanel();
		centerFiller.setOpaque(false);
		content.add(centerFiller, BorderLayout.CENTER);
		add(new JScrollPane(content));
		listPanel.setBackground(UIManager.getColor("List.background"));
		listPanel.setSize(new Dimension(200, 16));
		
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		
		
		IMatDataHandler.getInstance().getShoppingCart().addShoppingCartListener(this);
		reloadShoppingCart();
	}
	
	public void addShoppingItem(ShoppingItem shoppingItem){
		JPanel panel_20 = new JPanel();
		panel_20.setOpaque(false);
		panel_20.setPreferredSize(new Dimension(220, 37));
		listPanel.add(panel_20);
		panel_20.setLayout(new BorderLayout(0, 0));

		JPanel panel_17 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel_17.setOpaque(false);
		panel_20.add(panel_17, BorderLayout.CENTER);
		
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(shoppingItem.getAmount(), 1, 99, 1));
		panel_17.add(spinner);
		
		JLabel lblSt_1 = new JLabel("st");
		panel_17.add(lblSt_1);
		
		Component rigidArea = Box.createRigidArea(new Dimension(7, 28));
		panel_17.add(rigidArea);

		JLabel lblMjlk = new JLabel(shoppingItem.getProduct().getName());
		panel_17.add(lblMjlk);
		
		JPanel panel_21 = new JPanel();
		panel_21.setOpaque(false);
		panel_20.add(panel_21, BorderLayout.EAST);
		
		JLabel lblKr_1 = new JLabel(NumberFormat.getInstance().format(shoppingItem.getTotal())+" kr");
		panel_21.add(lblKr_1);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(5, 28));
		panel_21.add(rigidArea_1);
	}
	
	private void reloadShoppingCart(){
		listPanel.removeAll();
		
		List<ShoppingItem> items = IMatDataHandler.getInstance().getShoppingCart().getItems();
		for(ShoppingItem item : items)
			addShoppingItem(item);
		
		listPanel.revalidate();
	}
	
	public void shoppingCartChanged(CartEvent event){
		reloadShoppingCart();
	}

}
