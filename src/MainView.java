import javax.swing.JFrame;
import se.chalmers.ait.dat215.project.*;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSplitPane;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JSpinner;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainView extends JFrame implements ShoppingCartListener {
	
	private ProductsGridView homeView = new ProductsGridView("Startsida");
	private ProductsGridView favoritesView = new ProductsGridView("Favoriter");
	
	private JScrollPane centerViewScrollPane;
	private JLabel centerViewTitleLabel;
	
	private JLabel lblKr;
	private JLabel lblSt;
	private JButton btnTmKundvagnen;
	private JButton btnGTillKassan;
	
	public MainView() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_30 = new JPanel();
		panel.add(panel_30, BorderLayout.SOUTH);
		panel_30.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_31 = new JPanel();
		panel_30.add(panel_31, BorderLayout.WEST);
		
		JLabel lblImat = new JLabel("<html><font color=\"#33CC33\">i</font>Mat");
		lblImat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				setCenterView(homeView);
			}
		});
		panel_31.add(lblImat);
		lblImat.setBounds(new Rectangle(0, 0, 100, 50));
		lblImat.setFont(new Font("Lucida Grande", Font.BOLD, 50));
		
		JButton btnFavoriter = new JButton("Favoriter");
		btnFavoriter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// refresh/initialize favorites view
				favoritesView.removeAllProducts();
				for(Product product : IMatDataHandler.getInstance().favorites())
					favoritesView.addProduct(product);
				setCenterView(favoritesView);
			}
		});
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		panel_31.add(rigidArea_1);
		panel_31.add(btnFavoriter);
		
		JButton btnFrdigaKassar = new JButton("F\u00E4rdiga kassar");
		panel_31.add(btnFrdigaKassar);
		
		JPanel panel_3 = new JPanel();
		panel_30.add(panel_3, BorderLayout.EAST);
		
		JPanel panel_26 = new JPanel();
		panel_3.add(panel_26);
		
		JButton btnBliMedlem = new JButton("Bli medlem");
		btnBliMedlem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				NewUserFrame newUserFrame = new NewUserFrame(null);
			}
		});
		
		Component rigidArea = Box.createRigidArea(new Dimension(220, 20));
		panel_26.add(rigidArea);
		panel_26.add(btnBliMedlem);
		
		JPanel panel_27 = new JPanel();
		panel_3.add(panel_27);
		
		JLabel lblExamplefoobar = new JLabel("example@foo.bar");
		panel_27.add(lblExamplefoobar);
		
		JButton btnTidigareKp = new JButton("Tidigare k\u00F6p");
		panel_27.add(btnTidigareKp);
		
		JButton btnNewButton = new JButton("Konto");
		panel_27.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Logga ut");
		panel_27.add(btnNewButton_1);
		
		if(IMatDataHandler2.isLoggedInAsUser)
			panel_26.setVisible(false);
		else
			panel_27.setVisible(false);
		
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(1, 60));
		panel_3.add(rigidArea_2);
		
		JPanel panel_25 = new JPanel();
		panel_30.add(panel_25, BorderLayout.CENTER);
		
		JTextField txtSk = new JTextField(){
			public void paint(Graphics g){
			    super.paint(g);
				if(super.getText().length() == 0){
			        g.setColor(Color.GRAY);
			        g.setFont(getFont().deriveFont(Font.ITALIC));
			        g.drawString("S\u00F6k...", 7, 19);
			    }
			}
		};
		txtSk.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				final JTextField field = (JTextField)e.getSource();
				final String searchText = field.getText();
				
				new Thread(new Runnable(){
					public void run(){
						// add a short delay to reduce lag
						try{
							Thread.currentThread().sleep(50);
						}catch(InterruptedException e){}
						
						// perform search only if search text has not been changed
						if(field.getText().equals(searchText)){
							searchProducts(searchText);
						}
					}
				}).start();
			}
			
			@Override
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					searchProducts(((JTextField)e.getSource()).getText());
			}
		});
		txtSk.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent event) {
				JTextField field = (JTextField)event.getSource();
				
				if(!field.getText().equals("")){
					field.selectAll();
					searchProducts(field.getText());
				}
			}
		});
		panel_25.add(txtSk);
		txtSk.setColumns(15);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(1, 60));
		panel_25.add(rigidArea_3);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		splitPane.setDividerLocation(400);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		getContentPane().add(splitPane, BorderLayout.EAST);
		
		JPanel panel_6 = new JPanel();
		splitPane.setLeftComponent(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.NORTH);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblKundvagn = new JLabel("Kundvagn");
		lblKundvagn.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		panel_7.add(lblKundvagn, BorderLayout.CENTER);
		
		btnGTillKassan = new JButton("G\u00E5 till kassan");
		panel_7.add(btnGTillKassan, BorderLayout.EAST);
		btnGTillKassan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				CheckOut checkOut = new CheckOut();
				//checkOut.pack();
				checkOut.setLocationRelativeTo(Main.getMainFrame());
				checkOut.setVisible(true);
			}
		});
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8, BorderLayout.SOUTH);
		panel_8.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_22 = new JPanel();
		panel_8.add(panel_22);
		panel_22.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_22.add(panel_14);
		FlowLayout flowLayout_2 = (FlowLayout) panel_14.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		
		JLabel lblTotalt = new JLabel("Totalt: ");
		lblTotalt.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_14.add(lblTotalt);
		
		lblKr = new JLabel("0 kr");
		panel_14.add(lblKr);
		
		JPanel panel_15 = new JPanel();
		panel_22.add(panel_15);
		FlowLayout flowLayout_3 = (FlowLayout) panel_15.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		
		JLabel lblAntalVaror = new JLabel("Antal varor: ");
		lblAntalVaror.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_15.add(lblAntalVaror);
		
		lblSt = new JLabel("0 st");
		panel_15.add(lblSt);
		
		JPanel panel_16 = new JPanel();
		panel_8.add(panel_16);
		
		btnTmKundvagnen = new JButton("T\u00F6m");
		btnTmKundvagnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(JOptionPane.showConfirmDialog(Main.getMainFrame(), "Vill du verkligen t\u00F6mma kundvagnen?", "T\u00F6ma kundvagn", JOptionPane.YES_NO_OPTION)==0)
					IMatDataHandler.getInstance().getShoppingCart().clear();
			}
		});
		panel_16.add(btnTmKundvagnen);
		
		ShoppingListView panel_9 = new ShoppingListView();
		panel_6.add(panel_9, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		splitPane.setRightComponent(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_10.add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JLabel lblListor = new JLabel("Listor");
		lblListor.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		panel_11.add(lblListor, BorderLayout.WEST);
		
		JPanel panel_29 = new JPanel();
		panel_29.setPreferredSize(new Dimension(30, 30));
		panel_29.setSize(new Dimension(30, 30));
		panel_11.add(panel_29, BorderLayout.EAST);
		panel_29.setLayout(null);
		
		JButton button_2 = new JButton("+");
		button_2.setBounds(5, 5, 19, 19);
		panel_29.add(button_2);
		
		JPanel panel_12 = new JPanel();
		panel_10.add(panel_12, BorderLayout.SOUTH);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JButton btnRedigera = new JButton("Redigera");
		panel_12.add(btnRedigera, BorderLayout.EAST);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(UIManager.getColor("List.background"));
		panel_10.add(new JScrollPane(panel_13), BorderLayout.CENTER);
		panel_13.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_19 = new JPanel();
		panel_19.setPreferredSize(new Dimension(225, 20));
		panel_19.setOpaque(false);
		panel_13.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel(">");
		panel_19.add(label, BorderLayout.EAST);
		
		JLabel lblPastaCarbonara = new JLabel("Pasta carbonara (0 kr)");
		panel_19.add(lblPastaCarbonara, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

		centerViewScrollPane = new JScrollPane();
		
		JPanel panel_24 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel_24.setBackground(UIManager.getColor("List.background"));
		centerViewScrollPane.setColumnHeaderView(panel_24);
		
		JPanel panel_23 = new JPanel();
		panel_23.setOpaque(false);
		panel_24.add(panel_23);
		panel_23.setSize(new Dimension(74, 40));
		panel_23.setPreferredSize(new Dimension(74, 40));
		panel_23.setLayout(null);
		
		JButton button = new JButton("\u21FD");
		button.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		button.setBounds(6, 5, 29, 29);
		panel_23.add(button);
		
		JButton button_1 = new JButton("\u21FE");
		button_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		button_1.setBounds(39, 5, 29, 29);
		panel_23.add(button_1);
		
		centerViewTitleLabel = new JLabel("Startsida");
		centerViewTitleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		panel_24.add(centerViewTitleLabel);
		panel_24.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		
		centerViewScrollPane.setPreferredSize(new Dimension((ShoppingProductView.SIZE.width+10)*4+10+10, (ShoppingProductView.SIZE.height+10)*3+10+panel_24.getPreferredSize().height+5));
		panel_4.add(centerViewScrollPane, BorderLayout.CENTER);
		
		JPanel panel_28 = new JPanel();
		panel_28.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		getContentPane().add(panel_28, BorderLayout.WEST);
		panel_28.setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				JList list = (JList)event.getSource();
				int selectedIndex = list.getSelectedIndex();
				
				List<Product> products = IMatDataHandler.getInstance().getProducts(getProductCategoryForString(list.getSelectedValue().toString()));
				ProductsGridView grid = new ProductsGridView(list.getSelectedValue().toString());
				for(Product product : products)
					grid.addProduct(product);
				setCenterView(grid);
			}
		});
		JScrollPane scrollPane = new JScrollPane(list);
		panel_28.add(scrollPane);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"S\u00F6tsaker", "Dryck >", " - Varma", " - Kalla", "Mejeri", "K\u00F6tt", "Fisk", "Br\u00F6d", "Skafferi >", " - Potatis & ris", " - Pasta", " - Mj\u00F6l, socker & salt", " - Kryddor", "Frukt >", " - Citrusfrukter", " - Exotiska frukter", " - Meloner", " - B\u00E4r", " - Stenfrukter", "Gr\u00F6nsaker >", " - Baljv\u00E4xter", " - Gr\u00F6nsaksfrukter", " - K\u00E5l", " - Rotfrukter", " - N\u00F6tter & fr\u00F6n"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblKategorier = new JLabel("Kategorier");
		lblKategorier.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		scrollPane.setColumnHeaderView(lblKategorier);
		

		// set up sub views
		for(int i=1; i<=4*5; i++)
			homeView.addProduct(IMatDataHandler.getInstance().getProduct(i));
		
		setCenterView(homeView);
		
		IMatDataHandler.getInstance().getShoppingCart().addShoppingCartListener(this);
		updateShoppingTotals();
		
	}
	
	public void setCenterView(ProductsGridView gridView){
		centerViewScrollPane.setViewportView(gridView);
		centerViewTitleLabel.setText(gridView.getTitle());
	}
	
	public ProductCategory getProductCategoryForString(String string){
		if(string.contains("S\u00F6tsaker"))
			return ProductCategory.SWEET;
		
		else if(string.contains("Varma"))
			return ProductCategory.HOT_DRINKS;
		else if(string.contains("Kalla"))
			return ProductCategory.COLD_DRINKS;
		
		else if(string.contains("Mejeri"))
			return ProductCategory.DAIRIES;
		
		else if(string.contains("K\u00F6tt"))
			return ProductCategory.MEAT;
		
		else if(string.contains("Fisk"))
			return ProductCategory.FISH;
		
		else if(string.contains("Br\u00F6d"))
			return ProductCategory.BREAD;
		
		else if(string.contains("Potatis & ris"))
			return ProductCategory.POTATO_RICE;
		else if(string.contains("Pasta"))
			return ProductCategory.PASTA;
		else if(string.contains("Mj\u00F6l, socker & salt"))
			return ProductCategory.FLOUR_SUGAR_SALT;
		else if(string.contains("Kryddor"))
			return ProductCategory.HERB;
		
		else if(string.contains("Citrusfrukter"))
			return ProductCategory.CITRUS_FRUIT;
		else if(string.contains("Exotiska frukter"))
			return ProductCategory.EXOTIC_FRUIT;
		else if(string.contains("Meloner"))
			return ProductCategory.MELONS;
		else if(string.contains("B\u00E4r"))
			return ProductCategory.BERRY;
		else if(string.contains("Stenfrukter"))
			return ProductCategory.FRUIT;
		
		else if(string.contains("Baljv\u00E4xter"))
			return ProductCategory.POD;
		else if(string.contains("Gr\u00F6nsaksfrukter"))
			return ProductCategory.VEGETABLE_FRUIT;
		else if(string.contains("K\u00E5l"))
			return ProductCategory.CABBAGE;
		else if(string.contains("Rotfrukter"))
			return ProductCategory.ROOT_VEGETABLE;
		else if(string.contains("N\u00F6tter & fr\u00F6n"))
			return ProductCategory.NUTS_AND_SEEDS;
			
		return null;
	}
	
	private void searchProducts(String searchText){
		List<Product> matchingProducts = IMatDataHandler.getInstance().findProducts(searchText);
		ProductsGridView gridView = new ProductsGridView("S\u00F6kresultat");
		for(Product product : matchingProducts)
			gridView.addProduct(product);
		setCenterView(gridView);
	}

	@Override
	public void shoppingCartChanged(CartEvent evt) {
		updateShoppingTotals();
	}
	
	private void updateShoppingTotals(){
		lblKr.setText(NumberFormat.getInstance().format(IMatDataHandler.getInstance().getShoppingCart().getTotal())+" kr");
		
		double count = 0;
		for(ShoppingItem item : IMatDataHandler.getInstance().getShoppingCart().getItems())
			count += item.getAmount();
		lblSt.setText(Integer.toString((int)count));
		
		btnGTillKassan.setEnabled(!IMatDataHandler.getInstance().getShoppingCart().getItems().isEmpty());
		btnTmKundvagnen.setEnabled(!IMatDataHandler.getInstance().getShoppingCart().getItems().isEmpty());
	}

}
