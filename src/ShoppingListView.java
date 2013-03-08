import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;


public class ShoppingListView extends JPanel implements ShoppingCartListener {
	
	private JPanel listPanel;
	private JScrollPane scrollPane;

	public static final Color HIGHLIGHT_COLOR = new Color(200,200,200, 50);
	public static final Color RECENTLY_ADDED_COLOR = new Color(255,255,50, 50);
	
	public ShoppingListView(){
		setLayout(new BorderLayout(0, 0));
		
		listPanel = new JPanel();
		JPanel content = new JPanel(new BorderLayout());
		content.setOpaque(false);
		content.add(listPanel, BorderLayout.NORTH);
		JPanel centerFiller = new JPanel();
		centerFiller.setOpaque(false);
		content.add(centerFiller, BorderLayout.CENTER);
		add(scrollPane = new JScrollPane(content));
		listPanel.setBackground(UIManager.getColor("List.background"));
		setPreferredSize(new Dimension(250, 37*8));
		
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		
		
		IMatDataHandler.getInstance().getShoppingCart().addShoppingCartListener(this);
		reloadShoppingCartItems();
	}
	
	public void addShoppingItem(final ShoppingItem shoppingItem){
		final JPanel panel_20 = new JPanel();
		panel_20.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
				JPanel panel = (JPanel)e.getSource();
				panel.setBackground(HIGHLIGHT_COLOR);
				panel.setOpaque(true);
			}
			@Override
			public void mouseExited(MouseEvent e){
				JPanel panel = (JPanel)e.getSource();
				panel.setBackground(null);
				panel.setOpaque(false);
			}
		});
		panel_20.setBackground(RECENTLY_ADDED_COLOR);
		new Thread(new Runnable(){
			public void run(){
				try{
					Thread.currentThread().sleep(500);
				}catch(InterruptedException e){}
				panel_20.setBackground(null);
				panel_20.setOpaque(false);
			}
		}).start();
		panel_20.setPreferredSize(new Dimension(220, 37));
		listPanel.add(panel_20);
		panel_20.setLayout(new BorderLayout(0, 0));

		JPanel panel_17 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel_17.setOpaque(false);
		panel_20.add(panel_17, BorderLayout.CENTER);
		
		final JSpinner spinner = new JSpinner(new SpinnerNumberModel(shoppingItem.getAmount(), shoppingItem.getProduct().getUnitSuffix().equals("kg") ? 0.1: 1, 99, shoppingItem.getProduct().getUnitSuffix().equals("kg") ? 0.1 : 1));
		panel_17.add(spinner);
		
		JLabel lblSt_1 = new JLabel(shoppingItem.getProduct().getUnitSuffix().equals("kg") ? "kg": "st");
		panel_17.add(lblSt_1);
		
		Component rigidArea = Box.createRigidArea(new Dimension(7, 28));
		panel_17.add(rigidArea);

		JLabel lblMjlk = new JLabel(shoppingItem.getProduct().getName());
		panel_17.add(lblMjlk);
		
		JPanel panel_21 = new JPanel();
		panel_21.setOpaque(false);
		panel_20.add(panel_21, BorderLayout.EAST);
		
		final JLabel lblKr_1 = new JLabel(NumberFormat.getInstance().format(shoppingItem.getTotal())+" kr");
		panel_21.add(lblKr_1);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(5, 28));
		panel_21.add(rigidArea_1);
		
		
		spinner.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent event) {
				shoppingItem.setAmount(Double.parseDouble(spinner.getValue().toString()));
				IMatDataHandler.getInstance().getShoppingCart().fireShoppingCartChanged(shoppingItem, false);
				lblKr_1.setText(NumberFormat.getInstance().format(shoppingItem.getTotal())+" kr");
			}
		});
	}
	
	private void reloadShoppingCartItems(){
		listPanel.removeAll();
		
		List<ShoppingItem> items = IMatDataHandler.getInstance().getShoppingCart().getItems();
		for(ShoppingItem item : items)
			addShoppingItem(item);
		
		listPanel.revalidate();
	}
	
	private void updateShoppingCartAmounts(){
		for(int i=0; i<listPanel.getComponentCount(); i++){
			JPanel panel = (JPanel)listPanel.getComponent(i);
			JPanel leftPanel = (JPanel)panel.getComponent(0);
			JSpinner spinner = (JSpinner)leftPanel.getComponent(0);
			spinner.setValue(IMatDataHandler.getInstance().getShoppingCart().getItems().get(i).getAmount());
		}
		
	}
	
	public void shoppingCartChanged(CartEvent event){		
		if(event.isAddEvent()){
			addShoppingItem(IMatDataHandler.getInstance().getShoppingCart().getItems().get(IMatDataHandler.getInstance().getShoppingCart().getItems().size()-1));
			new Thread(new Runnable(){
				public void run(){
					try{
						Thread.sleep(100);
					}catch(InterruptedException e){}
					scrollPane.revalidate();
					scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
				}
			}).start();
		}else if(IMatDataHandler.getInstance().getShoppingCart().getItems().size()>0)
			updateShoppingCartAmounts();
		else if(IMatDataHandler.getInstance().getShoppingCart().getItems().size()==0){
			listPanel.removeAll();
			listPanel.revalidate();
		}
	}

}
