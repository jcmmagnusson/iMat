import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingItem;

public class CustomListProductsView extends JPanel {
	
	public CustomListProductsView(ShoppingItemList shoppingList){
		setBackground(UIManager.getColor("List.background"));
		
		for(ShoppingItem item : shoppingList.getItems()){
			JLabel label = new JLabel(item.getProduct().getName());
			label.setIcon(IMatDataHandler.getInstance().getImageIcon(item.getProduct(), new Dimension(40, 40)));
			label.setVerticalTextPosition(JLabel.BOTTOM);
			label.setHorizontalTextPosition(JLabel.CENTER);
			add(label);
		}
	}
}
