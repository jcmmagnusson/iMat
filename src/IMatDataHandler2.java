import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;


public class IMatDataHandler2 {
	
	public static boolean isLoggedInAsUser = false;
	
	
	public static void addProduct(Product product){
		addProduct(product, 1);
	}
	
	public static void addProduct(Product product, double amount){
		ShoppingItem productShoppingItem = null;
		for(ShoppingItem shoppingItem : IMatDataHandler.getInstance().getShoppingCart().getItems()){
			if(shoppingItem.getProduct().equals(product)){
				shoppingItem.setAmount(shoppingItem.getAmount() + amount);
				IMatDataHandler.getInstance().getShoppingCart().fireShoppingCartChanged(shoppingItem, false);
				productShoppingItem = shoppingItem;
				break;
			}
		}
		
		if(productShoppingItem==null){
			productShoppingItem = new ShoppingItem(product, amount);
			IMatDataHandler.getInstance().getShoppingCart().addItem(productShoppingItem);
			IMatDataHandler.getInstance().getShoppingCart().fireShoppingCartChanged(productShoppingItem, true);
		}
	}

}
