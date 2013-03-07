import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import se.chalmers.ait.dat215.project.ShoppingItem;


public class ShoppingItemList {
	
	private List<ShoppingItem> list;
	private String name;
	
	public ShoppingItemList(String name){
		this.name = name;
		list = new ArrayList<ShoppingItem>();
	}
	
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void addShoppingItem(ShoppingItem item){
		list.add(item);
	}
	
	public void removeShoppingItem(ShoppingItem item){
		list.remove(item);
	}
	
	public int size(){
		return list.size();
	}
	
	public double getTotalCost(){
		double totalCost = 0;
		for(ShoppingItem item : list)
			totalCost += item.getTotal();
		return totalCost;
	}
	
	public void delete(){
		File listFolder = new File(System.getProperty("user.home") + "/.dat215/imat/lists");
		File listFile = new File(listFolder, name+".list");
		
		if(listFile.exists())
			listFile.delete();
	}
	
	public void save() throws IOException{
		File listFolder = new File(System.getProperty("user.home") + "/.dat215/imat/lists");
		if(!listFolder.exists())
			listFolder.mkdir();
		
		File listFile = new File(listFolder, name+".list");
		FileOutputStream fos = new FileOutputStream(listFile);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeChars(name);
		oos.writeObject(list);

		oos.close();
	}

}
