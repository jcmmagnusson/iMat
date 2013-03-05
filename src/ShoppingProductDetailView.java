import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.text.NumberFormat;

import javax.swing.SwingConstants;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JSpinner;


@SuppressWarnings("serial")
public class ShoppingProductDetailView extends JPanel {
	public ShoppingProductDetailView(final Product product) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(51dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(10dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_7.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_7, "2, 2, 3, 1, fill, fill");
		
		JLabel lblProdukt_3 = new JLabel(product.getName());
		panel_7.add(lblProdukt_3);
		lblProdukt_3.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6, "6, 2");
		panel_6.setPreferredSize(new Dimension(20, 20));
		panel_6.setSize(new Dimension(20, 20));
		panel_6.setLayout(null);
		
		JButton button = new JButton("\u2606");
		button.setBounds(0, 0, 20, 20);
		panel_6.add(button);
		button.setToolTipText("Favorisera");
		button.setOpaque(false);
		button.setForeground(new Color(255, 210, 0, 255));
		
		JLabel lblPris = new JLabel("Pris:");
		panel_2.add(lblPris, "2, 4");
		
		JLabel lblKr = new JLabel(NumberFormat.getInstance().format(product.getPrice())+" "+product.getUnit());
		panel_2.add(lblKr, "4, 4, 3, 1");
		
		JLabel lblTillverkare = new JLabel("Tillverkare:");
		panel_2.add(lblTillverkare, "2, 6");
		
		JLabel lblFretagAb = new JLabel("F\u00F6retag AB");
		panel_2.add(lblFretagAb, "4, 6, 3, 1");
		
		JLabel lblVolym = new JLabel("Volym:");
		panel_2.add(lblVolym, "2, 8");
		
		JLabel lblKg = new JLabel("0 kg");
		panel_2.add(lblKg, "4, 8, 3, 1");
		
		ProductIconView productIconView = new ProductIconView(product);
		/*final Dimension iconDimension = new Dimension(100, 100);
		productIconView.setSize(iconDimension);
		productIconView.setPreferredSize(iconDimension);
		productIconView.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));*/
		panel.add(productIconView, BorderLayout.WEST);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_5, BorderLayout.SOUTH);
		
		JSpinner spinner = new JSpinner();
		panel_5.add(spinner);
		
		JButton btnNewButton = new JButton("L\u00E4gg till");
		panel_5.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setBorder(BorderFactory.createTitledBorder("Andra k\u00F6pte \u00E4ven"));
		
		Dimension relatedProductSize = new Dimension(75, 75);
		
		JLabel lblProdukt = new JLabel("Produkt 1");
		lblProdukt.setIcon(IMatDataHandler.getInstance().getImageIcon(IMatDataHandler.getInstance().getProduct(20), relatedProductSize));
		lblProdukt.setVerticalTextPosition(JLabel.BOTTOM);
		lblProdukt.setHorizontalTextPosition(JLabel.CENTER);
		panel_1.add(lblProdukt);
		
		JLabel lblProdukt_1 = new JLabel("Produkt 2");
		lblProdukt_1.setIcon(IMatDataHandler.getInstance().getImageIcon(IMatDataHandler.getInstance().getProduct(21), relatedProductSize));
		lblProdukt_1.setVerticalTextPosition(JLabel.BOTTOM);
		lblProdukt_1.setHorizontalTextPosition(JLabel.CENTER);
		panel_1.add(lblProdukt_1);
		
		JLabel lblProdukt_2 = new JLabel("Produkt 3");
		lblProdukt_2.setIcon(IMatDataHandler.getInstance().getImageIcon(IMatDataHandler.getInstance().getProduct(22), relatedProductSize));
		lblProdukt_2.setVerticalTextPosition(JLabel.BOTTOM);
		lblProdukt_2.setHorizontalTextPosition(JLabel.CENTER);
		panel_1.add(lblProdukt_2);
		
		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.setBorder(BorderFactory.createTitledBorder("Inneh\u00E5llsf\u00F6rteckning"));
		
		JTextArea lblLoremIpsumDolor = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus sollicitudin magna id tellus auctor a mollis felis fermentum. Mauris nec nunc nisl. Etiam eget est eu augue rutrum iaculis id ut odio. Nunc sit amet justo purus, sed vehicula elit. Pellentesque auctor tellus lacus, quis lacinia eros. Nam vitae nulla sed enim auctor sagittis. Nam id tempus lacus. Morbi scelerisque hendrerit erat non auctor.");
		lblLoremIpsumDolor.setLineWrap(true);
		lblLoremIpsumDolor.setColumns(25);
		lblLoremIpsumDolor.setRows(10);
		lblLoremIpsumDolor.setBackground(UIManager.getColor("Label.background"));
		lblLoremIpsumDolor.setEditable(false);
		panel_4.add(lblLoremIpsumDolor, BorderLayout.CENTER);
	}

}