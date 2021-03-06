import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;

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


public class CompleteDishView extends JPanel {
	
	private ArrayList<ShoppingItem> dishProducts = new ArrayList<ShoppingItem>();
	private JSpinner numberOfItemsSpinner;
		
	public static final Dimension SIZE = new Dimension(170, 230);


	public CompleteDishView(final ArrayList<ShoppingItem> p, final String name) {
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
		this.dishProducts = p;
		
		setPreferredSize(SIZE);
		setLayout(new BorderLayout(0, 0));
		setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		JButton addButton = new JButton("L\u00E4gg till");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0;i<dishProducts.size();i++){
					IMatDataHandler2.addProduct(dishProducts.get(i).getProduct(), dishProducts.get(i).getAmount());
				}	
			}
		});
		add(addButton, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		numberOfItemsSpinner = new JSpinner();
		numberOfItemsSpinner.setModel(new SpinnerNumberModel(1, 1, 99, 1));
		numberOfItemsSpinner.setBounds(6, 165, 45, 28);
		panel.add(numberOfItemsSpinner);
		
		int temp = 0;
		for(int i = 0;i<dishProducts.size();i++){
			temp += dishProducts.get(i).getProduct().getPrice() * dishProducts.get(i).getAmount();
		}
		
		JLabel priceLabel = new JLabel(temp + "kr/st");
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
				CompleteDishDetailView detailView = new CompleteDishDetailView(p, name);
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
		
		
		JLabel titleLabel = new JLabel(name);
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
			    g.drawImage(IMatDataHandler.getInstance().getImageIcon(dishProducts.get(0).getProduct()).getImage(), 0, 0, getWidth(), getHeight(), null);
			    
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

	}
	
	public ArrayList<ShoppingItem> getProducts(){
		return dishProducts;
	}
}
