import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.AbstractListModel;

import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingItem;


public class CheckOut extends JDialog {
	private JTextField txtFirstName;
	private JTextField txtSurname;
	private JTextField txtAddress;
	private JTextField txtPostalCode;
	private JTextField txtPostTown;
	private JPanel panel_5;
	private JTextField txtCardNumber;
	private JTextField txtCvc;
	private JLabel lblJohan;
	private JLabel lblMagnusson;
	private JLabel lblSolarvsplan;
	private JLabel label_5;
	private JLabel lblAskim;
	private JLabel lblVanligLeverans;
	private JLabel lblVisa;
	private JLabel lblCardNumberCensored;
	private JRadioButton rdbtnVisa;
	private JRadioButton rdbtnMastercard;
	private JRadioButton rdbtnPaypal;
	private JRadioButton rdbtnInternetbank;
	private JRadioButton rdbtnHmtaIButik;
	private JRadioButton rdbtnNormalLeverans;
	private JRadioButton rdbtnExpressleveransKr;
	private JButton btnBakt;
	private int counter = 0;
	private JButton btnNsta;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextField txtHoldersName;
	private JList list_1;
	private JList list_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut dialog = new CheckOut();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public CheckOut() {
		setTitle("Kassan");
		setResizable(false);
		setBounds(100, 100, 601, 483);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		getContentPane().add(northPanel, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_northPanel = new GroupLayout(northPanel);
		gl_northPanel.setHorizontalGroup(
			gl_northPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_northPanel.createSequentialGroup()
					.addGap(166)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(226, Short.MAX_VALUE))
		);
		gl_northPanel.setVerticalGroup(
			gl_northPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_northPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_northPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel label_3 = new JLabel("4");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 32));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label_3, BorderLayout.CENTER);
		
		JLabel lblKvitto = new JLabel("Kvitto");
		lblKvitto.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblKvitto, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel label_2 = new JLabel("3");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 32));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_2, BorderLayout.CENTER);
		
		JLabel lblBetalning = new JLabel("Betalning");
		lblBetalning.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblBetalning, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label_1 = new JLabel("2");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_1, BorderLayout.CENTER);
		
		JLabel lblLeverans = new JLabel("Leverans");
		lblLeverans.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblLeverans, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGranska = new JLabel("Granska");
		lblGranska.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblGranska, BorderLayout.SOUTH);
		
		JLabel label = new JLabel("1");
		label.setFont(new Font("Tahoma", Font.BOLD, 32));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label, BorderLayout.CENTER);
		northPanel.setLayout(gl_northPanel);
		
		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4, BorderLayout.SOUTH);
		
		btnBakt = new JButton("Bak\u00E5t");
		btnBakt.setVisible(false);
		btnBakt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backActionPerformed(e);
			}
		});
		
		btnNsta = new JButton("N\u00E4sta");
		btnNsta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stekActionPerformed(e);
			}
		});
		
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(166)
					.addComponent(btnBakt)
					.addPreferredGap(ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
					.addComponent(btnNsta)
					.addGap(166))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBakt)
						.addComponent(btnNsta))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		panel_5 = new JPanel();
		getContentPane().add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new CardLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, "name_10081260351632");
		
		ShoppingListView panel_7 = new ShoppingListView();
		panel_7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_7.setBackground(Color.WHITE);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(50)
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		list_2 = new JList();
		panel_7.add(list_2, BorderLayout.CENTER);
		panel_6.setLayout(gl_panel_6);
		list_2.setCellRenderer(new CustomCellRenderer());
		
		JPanel panel_8 = new JPanel();
		panel_5.add(panel_8, "name_13325310248430");
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_8.createSequentialGroup()
					.addGap(149)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_11, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_9, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(142, Short.MAX_VALUE))
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_11, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblLeveransmetod = new JLabel("Leveransmetod:");
		
		rdbtnHmtaIButik = new JRadioButton("H\u00E4mta i butik");
		rdbtnHmtaIButik.setSelected(true);
		
		rdbtnNormalLeverans = new JRadioButton("Normal leverans (+29 kr)");
		
		rdbtnExpressleveransKr = new JRadioButton("Expressleverans (+59 kr)");
		GroupLayout gl_panel_11 = new GroupLayout(panel_11);
		gl_panel_11.setHorizontalGroup(
			gl_panel_11.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_11.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_11.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnExpressleveransKr)
						.addComponent(rdbtnNormalLeverans)
						.addComponent(lblLeveransmetod)
						.addComponent(rdbtnHmtaIButik))
					.addContainerGap(199, Short.MAX_VALUE))
		);
		gl_panel_11.setVerticalGroup(
			gl_panel_11.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_11.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLeveransmetod)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnHmtaIButik)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnNormalLeverans)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnExpressleveransKr)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		panel_11.setLayout(gl_panel_11);
		
		JLabel lblFrnamn = new JLabel("F\u00F6rnamn:");
		
		Customer customer = IMatDataHandler.getInstance().getCustomer();
		
		txtFirstName = new JTextField(customer.getFirstName());
		txtFirstName.setColumns(10);
		
		JLabel lblEfternamn = new JLabel("Efternamn:");
		
		txtSurname = new JTextField(customer.getLastName());
		txtSurname.setColumns(10);
		
		JLabel lblAdress = new JLabel("Adress:");
		
		txtAddress = new JTextField(customer.getAddress());
		txtAddress.setColumns(10);
		
		txtPostalCode = new JTextField(customer.getPostCode());
		txtPostalCode.setColumns(10);
		
		JLabel lblPostort = new JLabel("Postort:");
		
		txtPostTown = new JTextField(customer.getPostAddress());
		txtPostTown.setColumns(10);
		
		JLabel lblPostnummer = new JLabel("Postnummer:");
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFrnamn)
								.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_9.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_9.createSequentialGroup()
									.addGap(30)
									.addComponent(lblEfternamn)
									.addGap(76))
								.addGroup(Alignment.LEADING, gl_panel_9.createSequentialGroup()
									.addGap(18)
									.addComponent(txtSurname, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))))
						.addComponent(lblAdress)
						.addComponent(txtAddress)
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPostalCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPostnummer))
							.addGap(18)
							.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPostort)
								.addComponent(txtPostTown))))
					.addGap(16))
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFrnamn)
						.addComponent(lblEfternamn))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSurname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAdress)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPostnummer)
						.addComponent(lblPostort))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPostalCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPostTown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel_9.setLayout(gl_panel_9);
		panel_8.setLayout(gl_panel_8);
		
		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10, "name_9950859440097");
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_panel_10 = new GroupLayout(panel_10);
		gl_panel_10.setHorizontalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addGap(149)
					.addGroup(gl_panel_10.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_13, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_12, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(138, Short.MAX_VALUE))
		);
		gl_panel_10.setVerticalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_12, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_13, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblKortnummer = new JLabel("Kortnummer:");
		
		txtCardNumber = new JTextField(IMatDataHandler.getInstance().getCreditCard().getCardNumber());
		txtCardNumber.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtCardNumber.setColumns(10);
		txtCardNumber.setDocument(new JTextFieldLimit(16));
		
		JLabel lblValidThru = new JLabel("Valid thru:");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox.setSelectedItem(IMatDataHandler.getInstance().getCreditCard().getValidMonth());
		
		JLabel label_4 = new JLabel("/");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboBox_1.setSelectedItem(IMatDataHandler.getInstance().getCreditCard().getValidYear());
		
		txtCvc = new JTextField();
		txtCvc.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtCvc.setColumns(10);
		txtCvc.setDocument(new JTextFieldLimit(3));
		txtCvc.setText("" + IMatDataHandler.getInstance().getCreditCard().getVerificationCode());
		
		JLabel lblCvc = new JLabel("CVC:");
		
		JLabel lblHoldersName = new JLabel("Holders name:");
		
		txtHoldersName = new JTextField(IMatDataHandler.getInstance().getCreditCard().getHoldersName());
		txtHoldersName.setColumns(10);
		GroupLayout gl_panel_13 = new GroupLayout(panel_13);
		gl_panel_13.setHorizontalGroup(
			gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_13.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_13.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblKortnummer)
						.addGroup(gl_panel_13.createSequentialGroup()
							.addGroup(gl_panel_13.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_13.createSequentialGroup()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblValidThru))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_13.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCvc, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCvc)))
						.addComponent(txtCardNumber)
						.addComponent(lblHoldersName)
						.addComponent(txtHoldersName))
					.addContainerGap(166, Short.MAX_VALUE))
		);
		gl_panel_13.setVerticalGroup(
			gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_13.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKortnummer)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtCardNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_13.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValidThru)
						.addComponent(lblCvc))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_13.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCvc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblHoldersName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtHoldersName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_13.setLayout(gl_panel_13);
		
		JLabel lblBetalningsmetod = new JLabel("Betalningsmetod:");
		
		rdbtnVisa = new JRadioButton("Visa");
		rdbtnVisa.setSelected(true);
		
		rdbtnMastercard = new JRadioButton("MasterCard");
		
		rdbtnPaypal = new JRadioButton("PayPal");
		
		rdbtnInternetbank = new JRadioButton("Internetbank");
		
		GroupLayout gl_panel_12 = new GroupLayout(panel_12);
		gl_panel_12.setHorizontalGroup(
			gl_panel_12.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_12.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnInternetbank)
						.addComponent(rdbtnPaypal)
						.addComponent(rdbtnMastercard)
						.addComponent(rdbtnVisa)
						.addComponent(lblBetalningsmetod))
					.addContainerGap(189, Short.MAX_VALUE))
		);
		gl_panel_12.setVerticalGroup(
			gl_panel_12.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_12.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBetalningsmetod)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnVisa)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnMastercard)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnPaypal)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnInternetbank)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_12.setLayout(gl_panel_12);
		panel_10.setLayout(gl_panel_10);
		
		ButtonGroup btngrp = new ButtonGroup();
		btngrp.add(rdbtnHmtaIButik);
		btngrp.add(rdbtnNormalLeverans);
		btngrp.add(rdbtnExpressleveransKr);
		
		ButtonGroup btngrp2 = new ButtonGroup();
		btngrp2.add(rdbtnVisa);
		btngrp2.add(rdbtnMastercard);
		btngrp2.add(rdbtnPaypal);
		btngrp2.add(rdbtnInternetbank);
		
		JPanel panel_14 = new JPanel();
		panel_5.add(panel_14, "name_15128205839726");
		
		JLabel lblKvitto_1 = new JLabel("KVITTO");
		lblKvitto_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JSeparator separator = new JSeparator();
		
		JLabel lblTotalt = new JLabel("Totalt:");
		lblTotalt.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblKr = new JLabel("1337 kr");
		lblKr.setText(IMatDataHandler.getInstance().getShoppingCart().getTotal() + " kr");
		
		JLabel lblLeverans_1 = new JLabel("Leveransadress:");
		
		lblJohan = new JLabel("Johan");
		
		lblMagnusson = new JLabel("Magnusson");
		
		lblSolarvsplan = new JLabel("Solarvsplan 9");
		
		label_5 = new JLabel("43643");
		
		lblAskim = new JLabel("Askim");
		
		lblVanligLeverans = new JLabel("Vanlig leverans");
		
		lblVisa = new JLabel("Visa");
		
		lblCardNumberCensored = new JLabel("************1789");
		
		JPanel panel_15 = new JPanel();
		GroupLayout gl_panel_14 = new GroupLayout(panel_14);
		gl_panel_14.setHorizontalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addGap(166)
					.addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_14.createSequentialGroup()
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAskim))
						.addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel_14.createSequentialGroup()
								.addComponent(lblSolarvsplan)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblCardNumberCensored))
							.addGroup(gl_panel_14.createSequentialGroup()
								.addComponent(lblJohan)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblMagnusson)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblVisa))
							.addGroup(gl_panel_14.createSequentialGroup()
								.addComponent(lblLeverans_1)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblVanligLeverans))
							.addGroup(gl_panel_14.createSequentialGroup()
								.addComponent(lblTotalt)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblKr))
							.addComponent(lblKvitto_1)
							.addGroup(gl_panel_14.createSequentialGroup()
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_15, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED))))
					.addContainerGap(151, Short.MAX_VALUE))
		);
		gl_panel_14.setVerticalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKvitto_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_14.createParallelGroup(Alignment.TRAILING)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_15, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_14.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalt)
						.addComponent(lblKr))
					.addGap(18)
					.addGroup(gl_panel_14.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLeverans_1)
						.addComponent(lblVanligLeverans))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_14.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJohan)
						.addComponent(lblMagnusson)
						.addComponent(lblVisa))
					.addGap(2)
					.addGroup(gl_panel_14.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSolarvsplan)
						.addComponent(lblCardNumberCensored))
					.addGap(2)
					.addGroup(gl_panel_14.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(lblAskim))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		list_1 = new JList();
		list_1.setCellRenderer(new CustomCellRenderer());
		
		fixStuff();
		
		
		panel_15.add(list_1);
		panel_14.setLayout(gl_panel_14);

	}
	
	
	public void stekActionPerformed(ActionEvent e) {
		if (counter % 4 == 3) {
			this.dispose();
		}
		btnBakt.setVisible(true);
		CardLayout cl = (CardLayout)panel_5.getLayout();
		cl.next(panel_5);
		counter++;
		
		onCardSwitch();
		
		lblJohan.setText(txtFirstName.getText());
		lblMagnusson.setText(txtSurname.getText());
		lblSolarvsplan.setText(txtAddress.getText());
		label_5.setText(txtPostalCode.getText());
		lblAskim.setText(txtPostTown.getText());
		
		String deliveryMethod = "";
		if (rdbtnHmtaIButik.isSelected()) {
			deliveryMethod = rdbtnHmtaIButik.getText();
		}
		else if (rdbtnExpressleveransKr.isSelected()) {
			deliveryMethod = rdbtnExpressleveransKr.getText();
		}
		else if (rdbtnNormalLeverans.isSelected()) {
			deliveryMethod = rdbtnNormalLeverans.getText();
		}
		
		lblVanligLeverans.setText(deliveryMethod);
		
		String paymentMethod = "";
		if (rdbtnVisa.isSelected()) {
			paymentMethod = rdbtnVisa.getText();
		}
		else if (rdbtnMastercard.isSelected()) {
			paymentMethod = rdbtnMastercard.getText();
		}
		else if (rdbtnInternetbank.isSelected()) {
			paymentMethod = rdbtnInternetbank.getText();
		}
		else if (rdbtnPaypal.isSelected()) {
			paymentMethod = rdbtnPaypal.getText();
		}
		lblVisa.setText(paymentMethod);
		
	}
	
	public void backActionPerformed(ActionEvent e) {
		counter--;
		CardLayout cl = (CardLayout)panel_5.getLayout();
		
		//if (counter % 4 != 0) {
			cl.previous(panel_5);
		//}
		onCardSwitch();
	}
	
	private void onCardSwitch() {
		if (counter % 4 == 0) {
			btnBakt.setVisible(false);
			panel.setBackground(Color.GRAY);
			panel_1.setBackground(new Color(240, 240, 240));
			panel_2.setBackground(new Color(240, 240, 240));
			panel_3.setBackground(new Color(240, 240, 240));
			btnNsta.setText("N�sta");
		}
		if (counter % 4 == 1) {
			panel.setBackground(Color.LIGHT_GRAY);
			panel_1.setBackground(Color.GRAY);
			panel_2.setBackground(new Color(240, 240, 240));
			panel_3.setBackground(new Color(240, 240, 240));
			btnNsta.setText("N�sta");
			
			
		}
		if (counter % 4 == 2) {
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_2.setBackground(Color.GRAY);
			panel_3.setBackground(new Color(240, 240, 240));
			btnNsta.setText("Betala");
		}
		else if (counter % 4 == 3) {
			IMatDataHandler.getInstance().placeOrder(true);
			
			panel_2.setBackground(Color.LIGHT_GRAY);
			panel_3.setBackground(Color.GRAY);
			btnNsta.setText("St�ng");
			btnBakt.setVisible(false);
			try {
				StringBuilder stringBuilder = new StringBuilder(txtCardNumber.getText());
				lblCardNumberCensored.setText("************" + stringBuilder.substring(12));
			} catch (Exception e) {
				lblCardNumberCensored.setText("");
			}
			
		}
	}
	
	private void fixStuff() {
		ArrayList aList = new ArrayList();
		
		for (ShoppingItem shoppingItem : IMatDataHandler.getInstance().getShoppingCart().getItems()) {
			JPanel recipePanel = new JPanel(new GridLayout(1,2));
			Product product = shoppingItem.getProduct();
			recipePanel.add(new JLabel((int)shoppingItem.getAmount() + " st " + product.getName()));
			recipePanel.add(new JLabel("" + shoppingItem.getTotal(), SwingConstants.RIGHT));
			aList.add(recipePanel);
			}
		list_1.setListData(aList.toArray());
		
		aList = new ArrayList();
		
		for (ShoppingItem shoppingItem : IMatDataHandler.getInstance().getShoppingCart().getItems()) {
			JPanel recipePanel = new JPanel(new GridLayout(1,3));
			Product product = shoppingItem.getProduct();
			recipePanel.add(new JLabel((int)shoppingItem.getAmount() + " st " + product.getName()));
			recipePanel.add(new JLabel("" + shoppingItem.getTotal() + "  [ta bort]", SwingConstants.RIGHT));
			aList.add(recipePanel);
			}
		list_2.setListData(aList.toArray());
	}
	
	class CustomCellRenderer implements ListCellRenderer {
        public Component getListCellRendererComponent
        (JList list, Object value, int index, 
        boolean isSelected,boolean cellHasFocus) {
            Component component = (Component)value;
            component.setBackground(isSelected ? Color.BLUE : Color.WHITE);
            component.setForeground(isSelected ? Color.white : Color.black);
            return component;
        }
    }
}
