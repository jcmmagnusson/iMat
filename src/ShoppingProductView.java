import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

import se.chalmers.ait.dat215.project.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class ShoppingProductView extends JPanel implements ProductFavoriteListener {
	
	private Product product;
	
	private JSpinner numberOfItemsSpinner;
	private JButton favoriteToggleButton;
	
	public static final String FAVORITE_STAR_CHARACTER_FILLED = "\u2605";
	public static final String FAVORITE_STAR_CHARACTER_HOLLOW = "\u2606";
	
	public static final Color FAVORITE_INACTIVE_COLOR = new Color(255, 255, 0, 150);
	
	public static final Dimension SIZE = new Dimension(170, 230);


	public ShoppingProductView(final Product product) {
		addMouseListener(new MouseAdapter() {
			int diff = 15;
			
			@Override
			public void mouseEntered(MouseEvent e) {
				JPanel view = (JPanel)e.getSource();
				Color bg = view.getBackground();
				Color highlightedBG = new Color(bg.getRed()+diff, bg.getGreen()+diff, bg.getRed()+diff);
				view.setBackground(highlightedBG);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				JPanel view = (JPanel)e.getSource();
				Color bg = view.getBackground();
				Color highlightedBG = new Color(bg.getRed()-diff, bg.getGreen()-diff, bg.getRed()-diff);
				view.setBackground(highlightedBG);
			}
		});
		this.product = product;
		
		setPreferredSize(SIZE);
		setLayout(new BorderLayout(0, 0));
		setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		JButton addButton = new JButton("L\u00E4gg till");
		addButton.setToolTipText("L\u00E4gg till i kundvagnen");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IMatDataHandler2.addProduct(product, Double.parseDouble((numberOfItemsSpinner.getValue().toString())));
			}
		});
		add(addButton, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		numberOfItemsSpinner = new JSpinner();
		numberOfItemsSpinner.setToolTipText("\u00C4ndra antal som ska l\u00E4ggas till");
		numberOfItemsSpinner.setModel(new SpinnerNumberModel(1, 1, 99, 1));
		numberOfItemsSpinner.setBounds(6, 165, 45, 28);
		panel.add(numberOfItemsSpinner);
		
		JLabel priceLabel = new JLabel(NumberFormat.getInstance().format(product.getPrice())+" "+product.getUnit());
		priceLabel.setToolTipText("Pris");
		priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		priceLabel.setBounds(63, 171, 99, 16);
		panel.add(priceLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 6, 156, 153);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton detailsButton = new JButton("i"){
			@Override
			public void paintComponent(Graphics g){
				// draw white circle
			    g.setColor(new Color(255,255,255, 150));
				g.fillOval(3, 3, 21, 21);
				// draw light border
				g.setColor(new Color(180,180,180, 50));
				g.drawOval(3, 3, 21, 21);
				
				// draw hover border if needed
				if(isBorderPainted()){
					g.setColor(Color.LIGHT_GRAY);
					g.drawOval(3, 3, 21, 21);
				}
				// draw focus border if needed
				if(hasFocus()){
					g.setColor(Color.GRAY);
					g.drawOval(3, 3, 21, 21);
				}
				
				super.paintComponent(g);
			}
		};
		detailsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JDialog dialog = new JDialog(Main.getMainFrame());
				dialog.setTitle("Detailjer");
				dialog.setModal(true);
				ShoppingProductDetailView detailView = new ShoppingProductDetailView(product);
				detailView.setPanelDialog(dialog);
				dialog.getContentPane().add(detailView);
				dialog.pack();
				dialog.setResizable(false);
				dialog.setLocationRelativeTo(Main.getMainFrame());
				dialog.setVisible(true);
			}
		});
		detailsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent event) {
				// paint hover border
				JButton button = (JButton)event.getSource();
				button.setBorderPainted(true);
				button.repaint();
			}
			@Override
			public void mouseExited(MouseEvent event) {
				// remove hover border
				JButton button = (JButton)event.getSource();
				button.setBorderPainted(false);
				button.repaint();
			}
		});
		detailsButton.setToolTipText("Mer information");
		detailsButton.setBounds(126, 0, 29, 29);
		panel_1.add(detailsButton);
		detailsButton.setFont(new Font("Georgia", Font.ITALIC+Font.BOLD, 14));
		detailsButton.setOpaque(false);
		detailsButton.setBorder(null);
		detailsButton.setBorderPainted(false);
		
		favoriteToggleButton = new JButton(FAVORITE_STAR_CHARACTER_HOLLOW);
		favoriteToggleButton.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				((JButton)e.getSource()).setForeground(Color.YELLOW);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(!IMatDataHandler.getInstance().isFavorite(product))
					((JButton)e.getSource()).setForeground(FAVORITE_INACTIVE_COLOR);
			}
		});
		favoriteToggleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				((JButton)e.getSource()).setForeground(Color.YELLOW);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!IMatDataHandler.getInstance().isFavorite(product))
					((JButton)e.getSource()).setForeground(FAVORITE_INACTIVE_COLOR);
			}
		});
		favoriteToggleButton.setToolTipText("Favorisera");
		favoriteToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JButton button = (JButton)event.getSource();
				
				if(!IMatDataHandler.getInstance().isFavorite(product)){
					// favorite product
					IMatDataHandler2.setFavorite(product, true);
					button.setText(FAVORITE_STAR_CHARACTER_FILLED);
					button.setToolTipText("Ta bort favorisering");
				}else{
					// un-favorite product
					IMatDataHandler2.setFavorite(product, false);
					button.setText(FAVORITE_STAR_CHARACTER_HOLLOW);
					button.setToolTipText("Favorisera");
				}
				
				// reset opaque & border
				button.setOpaque(false);
				button.setBorder(null);
			}
		});
		favoriteToggleButton.setForeground(FAVORITE_INACTIVE_COLOR);
		if(IMatDataHandler.getInstance().isFavorite(product)){
			favoriteToggleButton.setToolTipText("Ta bort favorisering");
			favoriteToggleButton.setText(FAVORITE_STAR_CHARACTER_FILLED);
			favoriteToggleButton.setForeground(Color.YELLOW);
		}
		favoriteToggleButton.setOpaque(false);
		favoriteToggleButton.setBorder(null);
		favoriteToggleButton.setBounds(126, 125, 29, 29);
		panel_1.add(favoriteToggleButton);
		
		JLabel titleLabel = new JLabel(product.getName());
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(0, 124, 155, 29);
		panel_1.add(titleLabel);
		
		@SuppressWarnings("serial")
		JLabel iconLabel = new JLabel(){
			@Override
			public void paintComponent(Graphics g) {
				// draw image of product
			    g.drawImage(IMatDataHandler.getInstance().getImageIcon(product).getImage(), 0, 0, getWidth(), getHeight(), null);
			    
			    // draw black opaque gradient over image
			    Graphics2D g2 = (Graphics2D) g;
			    g2.setPaint(new GradientPaint(
				    new Point(0, getHeight()*7/10), 
				    new Color(0.0f, 0.0f, 0.0f, 0.0f), 
				    new Point(0, getHeight()), 
				    new Color(0.0f, 0.0f, 0.0f, 0.7f)));
			    g2.fillRect(0,0, getWidth(), getHeight());
			    
			    super.paintComponent(g);
			    
			}
		};
		iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		iconLabel.setBounds(0, 0, 155, 153);
		iconLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panel_1.add(iconLabel);

		
		IMatDataHandler2.addProductFavoriteListener(this, product);
	}
	
	public void productFavorisationChanged(Product productChanged){
		if(IMatDataHandler.getInstance().isFavorite(product)){
			// make product look favorited
			favoriteToggleButton.setText(FAVORITE_STAR_CHARACTER_FILLED);
			favoriteToggleButton.setToolTipText("Ta bort favorisering");
		}else{
			// make product look not favorited
			favoriteToggleButton.setText(FAVORITE_STAR_CHARACTER_HOLLOW);
			favoriteToggleButton.setToolTipText("Favorisera");
		}
		favoriteToggleButton.setBorder(null);
	}
}
