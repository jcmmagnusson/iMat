import java.awt.Graphics;

import javax.swing.JLabel;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;


public class ProductIconView extends JLabel {
	
	private Product product;
	
	public ProductIconView(Product product){
		this.product = product;
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(IMatDataHandler.getInstance().getImageIcon(product).getImage(), 0, 0, getWidth(), getHeight(), null);
		super.paintComponent(g);
	}

}
