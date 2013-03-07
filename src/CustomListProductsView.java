import javax.swing.JPanel;
import javax.swing.UIManager;

public class CustomListProductsView extends JPanel {
	
	public CustomListProductsView(ShoppingItemList shoppingList){
		setBackground(UIManager.getColor("List.background"));
	}
}
