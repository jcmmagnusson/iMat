import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.UIManager;

import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;


public class DishGridView extends JPanel {
	
	private String title;
	
	public DishGridView(String title){
		this.title = title;
		
		this.setOpaque(false);
		this.setBackground(UIManager.getColor("List.background"));
		this.setLayout(new GridLayout(0, 4));
	}
	
	public String getTitle(){
		return title;
	}
	
	public void addItem(ArrayList<ShoppingItem> item, String name ){
		JPanel p = new JPanel();
		p.setOpaque(false);
		p.add(new CompleteDishView(item, name));
		this.add(p);
	}
	
	public void removeAllProducts(){
		this.removeAll();
	}
	
}
