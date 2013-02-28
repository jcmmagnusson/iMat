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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;

public class MainView extends JFrame {
	
	public MainView() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.WEST);
		
		JLabel lblImat = new JLabel("<html><font color=\"#33CC33\">i</font>Mat");
		lblImat.setFont(new Font("Lucida Grande", Font.BOLD, 50));
		panel_2.add(lblImat);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		panel_2.add(rigidArea_4);
		
		JPanel panel_23 = new JPanel();
		panel_23.setSize(new Dimension(74, 40));
		panel_23.setPreferredSize(new Dimension(74, 40));
		panel_2.add(panel_23);
		panel_23.setLayout(null);
		
		JButton button = new JButton("\u21FD");
		button.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		button.setBounds(6, 5, 29, 29);
		panel_23.add(button);
		
		JButton button_1 = new JButton("\u21FE");
		button_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		button_1.setBounds(39, 5, 29, 29);
		panel_23.add(button_1);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.EAST);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(1, 60));
		panel_3.add(rigidArea_2);
		
		JPanel panel_26 = new JPanel();
		panel_3.add(panel_26);
		
		JButton btnBliMedlem = new JButton("Bli medlem");
		panel_26.add(btnBliMedlem);
		
		JPanel panel_27 = new JPanel();
		panel_3.add(panel_27);
		
		JButton btnNewButton = new JButton("Konto");
		panel_27.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Logga ut");
		panel_27.add(btnNewButton_1);
		
		JPanel panel_25 = new JPanel();
		panel_1.add(panel_25, BorderLayout.CENTER);
		
		JTextField txtSk = new JTextField();
		panel_25.add(txtSk);
		txtSk.setText("S\u00F6k...");
		txtSk.setColumns(15);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(1, 60));
		panel_25.add(rigidArea_3);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBorder(null);
		splitPane.setDividerLocation(400);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		getContentPane().add(splitPane, BorderLayout.EAST);
		
		JPanel panel_6 = new JPanel();
		splitPane.setLeftComponent(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblKundvagn = new JLabel("Kundvagn");
		lblKundvagn.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		panel_7.add(lblKundvagn);
		
		JButton btnGTillKassan = new JButton("G\u00E5 till kassan >");
		panel_7.add(btnGTillKassan);
		
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
		
		JLabel lblKr = new JLabel("0 kr");
		panel_14.add(lblKr);
		
		JPanel panel_15 = new JPanel();
		panel_22.add(panel_15);
		FlowLayout flowLayout_3 = (FlowLayout) panel_15.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		
		JLabel lblAntalVaror = new JLabel("Antal varor: ");
		lblAntalVaror.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_15.add(lblAntalVaror);
		
		JLabel lblSt = new JLabel("0 st");
		panel_15.add(lblSt);
		
		JPanel panel_16 = new JPanel();
		panel_8.add(panel_16);
		
		JButton btnTmKundvagnen = new JButton("T\u00F6m");
		panel_16.add(btnTmKundvagnen);
		
		JPanel panel_9 = new JPanel();
		panel_6.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_18 = new JPanel();
		panel_9.add(new JScrollPane(panel_18));
		panel_18.setBackground(UIManager.getColor("List.background"));
		panel_18.setSize(new Dimension(200, 16));
		panel_18.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_20 = new JPanel();
		panel_20.setOpaque(false);
		panel_20.setPreferredSize(new Dimension(225, 37));
		panel_20.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		panel_18.add(panel_20);
		panel_20.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_17 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel_17.setOpaque(false);
		panel_20.add(panel_17, BorderLayout.CENTER);
		
		JSpinner spinner = new JSpinner();
		panel_17.add(spinner);
		
		JLabel lblSt_1 = new JLabel("st");
		panel_17.add(lblSt_1);
		
		Component rigidArea = Box.createRigidArea(new Dimension(7, 28));
		panel_17.add(rigidArea);
		
		JLabel lblMjlk = new JLabel("Mj\u00F6lk");
		panel_17.add(lblMjlk);
		
		JPanel panel_21 = new JPanel();
		panel_21.setOpaque(false);
		panel_20.add(panel_21, BorderLayout.EAST);
		
		JLabel lblKr_1 = new JLabel("0 kr");
		panel_21.add(lblKr_1);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(5, 28));
		panel_21.add(rigidArea_1);
		
		JPanel panel_10 = new JPanel();
		splitPane.setRightComponent(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_10.add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JButton button_2 = new JButton("+");
		panel_11.add(button_2, BorderLayout.EAST);
		
		JLabel lblListor = new JLabel("Listor");
		lblListor.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		panel_11.add(lblListor, BorderLayout.WEST);
		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_12.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_10.add(panel_12, BorderLayout.SOUTH);
		
		JButton btnRedigera = new JButton("Redigera");
		panel_12.add(btnRedigera);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(UIManager.getColor("List.background"));
		panel_10.add(new JScrollPane(panel_13), BorderLayout.CENTER);
		panel_13.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_19 = new JPanel();
		panel_19.setOpaque(false);
		panel_13.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel(">");
		panel_19.add(label, BorderLayout.EAST);
		
		JLabel lblPastaCarbonara = new JLabel("Pasta carbonara");
		panel_19.add(lblPastaCarbonara, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblStartsida = new JLabel("Startsida");
		lblStartsida.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		panel_4.add(lblStartsida, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_5.setBackground(UIManager.getColor("List.background"));
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		panel_5.setPreferredSize(new Dimension((170+10)*4+10, (230+10)*3+10));

		JScrollPane scrollPane_2 = new JScrollPane(panel_5);
		panel_4.add(scrollPane_2, BorderLayout.CENTER);
		
		for(int i=1; i<=12; i++){
			Product p = IMatDataHandler.getInstance().getProduct(i);
			panel_5.add(new ShoppingProductView(p));
		}
		
		
		
		JPanel panel_28 = new JPanel();
		getContentPane().add(panel_28, BorderLayout.WEST);
		panel_28.setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		panel_28.add(new JScrollPane(list));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Favoriter", "F\u00E4rdiga kassar", "Tidigare k\u00F6p", " ", "S\u00F6tsaker", "Dryck >", " - Varma", " - Kalla", "Mejeri", "K\u00F6tt", "Fisk", "Br\u00F6d", "Skafferi >", " - Potatis & ris", " - Pasta", " - Mj\u00F6l, socker & salt", " - Kryddor", "Frukt >", " - Citrusfrukter", " - Exotiska frukter", " - Meloner", " - B\u00E4r", " - Stenfrukter", "Gr\u00F6nsaker >", " - Baljv\u00E4xter", " - Gr\u00F6nsaksfrukter", " - K\u00E5l", " - Rotfrukter", " - N\u00F6tter & fr\u00F6n"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
	}

}
