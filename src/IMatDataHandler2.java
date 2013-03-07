import java.util.ArrayList;
import java.util.List;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;


public class IMatDataHandler2 {
	
	public static boolean isLoggedInAsUser = false;
	
	private static List<ProductFavoriteListener> productFavoriteListeners = new ArrayList<ProductFavoriteListener>();
	private static List<Product> productFavoriteListenersProducts = new ArrayList<Product>();
	
	
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
		}
	}
	
	
	public static void setFavorite(Product product, boolean favorite){
		if(favorite)
			IMatDataHandler.getInstance().addFavorite(product);
		else
			IMatDataHandler.getInstance().removeFavorite(product);
		
		int listenerIndex = productFavoriteListenersProducts.indexOf(product);
		if(listenerIndex!=-1)
			productFavoriteListeners.get(listenerIndex).productFavorisationChanged(product);
	}
	
	public static void addProductFavoriteListener(ProductFavoriteListener listener, Product product){
		productFavoriteListeners.add(listener);
		productFavoriteListenersProducts.add(product);
	}

}
