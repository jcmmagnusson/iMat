import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CustomListView extends JPanel {
	
	JPanel listPanel;
	JScrollPane scrollPane;
	JPanel content;
	
	public CustomListView(){
		setLayout(new BorderLayout(0, 0));
		
		listPanel = new JPanel();
		content = new JPanel(new BorderLayout());
		content.setOpaque(false);
		content.add(listPanel, BorderLayout.NORTH);
		JPanel centerFiller = new JPanel();
		centerFiller.setOpaque(false);
		content.add(centerFiller, BorderLayout.CENTER);
		scrollPane = new JScrollPane(content);
		add(scrollPane);
		listPanel.setBackground(UIManager.getColor("List.background"));
		listPanel.setSize(new Dimension(200, 16));
		
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		
		
		// reload
		ShoppingItemList carbonara = new ShoppingItemList("Carbonara");
		carbonara.addShoppingItem(new ShoppingItem(IMatDataHandler.getInstance().getProduct(112), 1));
		carbonara.addShoppingItem(new ShoppingItem(IMatDataHandler.getInstance().getProduct(76), 1));
		carbonara.addShoppingItem(new ShoppingItem(IMatDataHandler.getInstance().getProduct(85), 1));
		addList(carbonara);

		ShoppingItemList breakfast = new ShoppingItemList("Frukost");
		breakfast.addShoppingItem(new ShoppingItem(IMatDataHandler.getInstance().getProduct(12), 1));
		breakfast.addShoppingItem(new ShoppingItem(IMatDataHandler.getInstance().getProduct(78), 1));
		breakfast.addShoppingItem(new ShoppingItem(IMatDataHandler.getInstance().getProduct(80), 1));
		breakfast.addShoppingItem(new ShoppingItem(IMatDataHandler.getInstance().getProduct(82), 1));
		addList(breakfast);
	}
	
	
	private void addList(final ShoppingItemList list){		
		JPanel panel_19 = new JPanel();
		panel_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				scrollPane.setViewportView(new CustomListProductsView(list));
				
				JPanel header = new JPanel(new BorderLayout());
				header.add(new JLabel("<html><b>"+list.getName(), JLabel.LEFT), BorderLayout.CENTER);
				JButton backButton = new JButton("<");
				backButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						scrollPane.setViewportView(content);
						scrollPane.setColumnHeaderView(null);
					}
				});
				JPanel backPanel = new JPanel();
				backPanel.add(backButton);
				backButton.setBounds(5, 5, 19, 19);
				backPanel.setPreferredSize(new Dimension(30, 30));
				backPanel.setSize(new Dimension(30, 30));
				backPanel.setLayout(null);
				header.add(backPanel, BorderLayout.WEST);
				header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
				scrollPane.setColumnHeaderView(header);
			}
		});
		panel_19.setOpaque(false);
		panel_19.setPreferredSize(new Dimension(200, 35));
		panel_19.setOpaque(false);
		listPanel.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));
		
		JPanel rightPanel = new JPanel();
		rightPanel.setOpaque(false);
		JButton buyButton = new JButton("K\u00F6p");
		rightPanel.add(buyButton);
		panel_19.add(rightPanel, BorderLayout.EAST);
		
		JLabel lblPastaCarbonara = new JLabel(list.getName()+" ("+list.getTotalCost()+" kr)");
		panel_19.add(lblPastaCarbonara, BorderLayout.CENTER);
		panel_19.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
	}

}
