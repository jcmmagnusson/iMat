import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.UIManager;

import se.chalmers.ait.dat215.project.Product;


public class ProductsGridView extends JPanel {
	
	private String title;
	
	public ProductsGridView(String title){
		this.title = title;
		
		this.setOpaque(false);
		this.setBackground(UIManager.getColor("List.background"));
		this.setLayout(new GridLayout(0, 4));
	}
	
	public String getTitle(){
		return title;
	}
	
	public void addProduct(Product product){
		JPanel p = new JPanel();
		p.setOpaque(false);
		p.add(new ShoppingProductView(product));
		this.add(p);
	}
	
	public void removeAllProducts(){
		this.removeAll();
	}
	
}
