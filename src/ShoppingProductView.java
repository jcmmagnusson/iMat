import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;


public class ShoppingProductView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ShoppingProductView() {
		setPreferredSize(new Dimension(170, 200));
		setLayout(new BorderLayout(0, 0));
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		JButton btnLggTill = new JButton("L\u00E4gg till");
		add(btnLggTill, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(6, 137, 37, 28);
		panel.add(spinner);
		
		JLabel lblKr = new JLabel("0 kr");
		lblKr.setBounds(103, 143, 61, 16);
		panel.add(lblKr);
		
		JButton btnNewButton = new JButton("i");
		btnNewButton.setBounds(135, 6, 29, 29);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 6, 158, 125);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblProdukt = new JLabel("Produkt");
		lblProdukt.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblProdukt.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdukt.setBounds(0, 96, 158, 29);
		panel_1.add(lblProdukt);
		
		JButton btnX = new JButton("\u2605");
		btnX.setBounds(129, 96, 29, 29);
		panel_1.add(btnX);
		
		JLabel lblIcon = new JLabel("[bild]");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setBounds(0, 0, 158, 125);
		panel_1.add(lblIcon);

	}
}
