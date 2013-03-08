import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.UIManager;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.ButtonGroup;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import se.chalmers.ait.dat215.project.CreditCard;
import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.User;

public class AccountView extends JDialog {
  
	private JPanel contentPane;
	
	private JTextField emailTextField;
	private JTextField addressTextField;
	private JTextField postalCodeTextField;
	private JTextField cityTextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField cardNumberTextField;
	private final JComboBox monthComboBox;
	private final JComboBox yearComboBox;
	private JTextField cvcTextField;
	private JTextField nameTextField;
	private JTextField passwordTextField;
	private JTextField repeatPasswordTextField;

	/**
	 * Create the frame.
	 */
	public AccountView(JFrame mainFrame) {
		super(mainFrame, "Redigera Konto", true);
		setResizable(false);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Panel.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("365px"),},
			new RowSpec[] {
				RowSpec.decode("292px"),}));
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.add(tabbedPane, "2, 1, fill, fill");
		
		JPanel paymentPanel = new JPanel();
		tabbedPane.addTab("Betalning", null, paymentPanel, null);
		paymentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("11px"),
				ColumnSpec.decode("46px"),
				ColumnSpec.decode("73px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("16px"),
				ColumnSpec.decode("40px"),
				ColumnSpec.decode("138px"),},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				RowSpec.decode("25px"),
				RowSpec.decode("25px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("25px"),}));
		
		JLabel paymentInfoLabel = new JLabel("<html><span style=\"text-decoration: underline;\">Betalningsinformation</span>");
		paymentPanel.add(paymentInfoLabel, "2, 2, 5, 1, left, top");
		
		JLabel paymentOptionLabel = new JLabel("Välj betalsätt:");
		paymentOptionLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		paymentPanel.add(paymentOptionLabel, "4, 4, 3, 1, left, top");
		
		final JRadioButton cardRadioButton = new JRadioButton("Kortbetalning");
		buttonGroup.add(cardRadioButton);
		paymentPanel.add(cardRadioButton, "3, 6, 2, 1, left, top");
		
		JRadioButton internetBankRadioButton = new JRadioButton("Internetbank");
		buttonGroup.add(internetBankRadioButton);
		paymentPanel.add(internetBankRadioButton, "3, 8, 2, 1, left, top");
		
		JRadioButton inoviceRadioButton = new JRadioButton("Faktura");
		buttonGroup.add(inoviceRadioButton);
		paymentPanel.add(inoviceRadioButton, "3, 10, 2, 1, left, top");
		
		JRadioButton paypalRadioButton = new JRadioButton("PayPal");
		buttonGroup.add(paypalRadioButton);
		paymentPanel.add(paypalRadioButton, "3, 12, 2, 1, left, top");
		
		final JButton secondCancelButton = new JButton("Avbryt");
		secondCancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountView.this.dispose();
			}
		});
		paymentPanel.add(secondCancelButton, "3, 16, 2, 1, fill, top");
		
		final JButton doneButton = new JButton("Ok");
		paymentPanel.add(doneButton, "8, 16, fill, top");
		
		final JPanel cardPaymentPanel = new JPanel();
		cardPaymentPanel.setVisible(false);
		paymentPanel.add(cardPaymentPanel, "5, 6, 4, 9, fill, fill");
		cardPaymentPanel.setLayout(null);
		
		JLabel cardNumberLabel = new JLabel("Kortnummer");
		cardNumberLabel.setBounds(12, 0, 161, 15);
		cardPaymentPanel.add(cardNumberLabel);
		
		cardNumberTextField = new JTextField();
		cardNumberTextField.setBounds(12, 22, 143, 19);
		cardPaymentPanel.add(cardNumberTextField);
		cardNumberTextField.setColumns(10);
		
		JLabel expireLabel = new JLabel("Utgångsdatum");
		expireLabel.setBounds(10, 53, 115, 15);
		cardPaymentPanel.add(expireLabel);
		
		JLabel cvcLabel = new JLabel("CVC");
		cvcLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		cvcLabel.setBounds(153, 53, 34, 15);
		cardPaymentPanel.add(cvcLabel);
		
		monthComboBox = new JComboBox();
		monthComboBox.setModel(new DefaultComboBoxModel(new String[] {"m", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthComboBox.setSelectedIndex(0);
		monthComboBox.setBounds(12, 80, 63, 24);
		cardPaymentPanel.add(monthComboBox);
		
		JLabel dividerLabel = new JLabel("/");
		dividerLabel.setBounds(73, 84, 12, 15);
		cardPaymentPanel.add(dividerLabel);
		
		yearComboBox = new JComboBox();
		yearComboBox.setModel(new DefaultComboBoxModel(new String[] {"y", "13", "14", "15", "16", "17", "18"}));
		yearComboBox.setSelectedIndex(0);
		yearComboBox.setBounds(83, 80, 72, 24);
		cardPaymentPanel.add(yearComboBox);
		
		cvcTextField = new JTextField();
		cvcTextField.setBounds(153, 81, 43, 19);
		cardPaymentPanel.add(cvcTextField);
		cvcTextField.setColumns(10);
		
		JLabel nameLabel = new JLabel("Namn");
		nameLabel.setBounds(12, 116, 58, 15);
		cardPaymentPanel.add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(12, 131, 170, 19);
		cardPaymentPanel.add(nameTextField);
		nameTextField.setColumns(10);
		
		final JLabel cardErrorLabel = new JLabel("*");
		cardErrorLabel.setForeground(Color.RED);
		cardErrorLabel.setVisible(false);
		paymentPanel.add(cardErrorLabel, "2, 6, fill, center");
		
		final JLabel internetBankErrorLabel = new JLabel("*");
		internetBankErrorLabel.setForeground(Color.RED);
		internetBankErrorLabel.setVisible(false);
		paymentPanel.add(internetBankErrorLabel, "2, 8, fill, center");
		
		final JLabel inoviceErrorLabel = new JLabel("*");
		inoviceErrorLabel.setForeground(Color.RED);
		inoviceErrorLabel.setVisible(false);
		paymentPanel.add(inoviceErrorLabel, "2, 10, fill, center");
		
		final JLabel paypalErrorLabel = new JLabel("*");
		paypalErrorLabel.setForeground(Color.RED);
		paypalErrorLabel.setVisible(false);
		paymentPanel.add(paypalErrorLabel, "2, 12, fill, center");
		
		ActionListener radioButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton radioButton = (JRadioButton) e.getSource();
				if (radioButton == cardRadioButton)
					cardPaymentPanel.setVisible(true);
				else
					cardPaymentPanel.setVisible(false);
			}
			
		};
		cardRadioButton.addActionListener(radioButtonListener);
		internetBankRadioButton.addActionListener(radioButtonListener);
		inoviceRadioButton.addActionListener(radioButtonListener);
		paypalRadioButton.addActionListener(radioButtonListener);
		
		ActionListener cancelButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AccountView.this.dispose();
			}
			
		};
		
		
		
		KeyAdapter actionKeyListener = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					doneButton.doClick();
				}
				else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					secondCancelButton.doClick();
				}
			}
		};
		
		IMatDataHandler handler = IMatDataHandler.getInstance();
		
		User user = handler.getUser();
		
		Customer customer = handler.getCustomer();
		
		CreditCard card = handler.getCreditCard();
		cardNumberTextField.setText(card.getCardNumber());
		monthComboBox.setSelectedIndex(card.getValidMonth()-1);
		yearComboBox.setSelectedIndex(card.getValidYear()-13);
		cvcTextField.setText(card.getVerificationCode() + "");
		nameTextField.setText(card.getHoldersName());
		
		JPanel accountAndDeliveryPanel = new JPanel();
		tabbedPane.addTab("Information", null, accountAndDeliveryPanel, null);
		accountAndDeliveryPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("139px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("7px"),
				ColumnSpec.decode("47px"),
				ColumnSpec.decode("117px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("15px"),},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("25px"),}));
		
		JLabel accountInfoLabel = new JLabel("<html><span style=\"text-decoration: underline;\">Kontoinformation</span>");
		accountAndDeliveryPanel.add(accountInfoLabel, "2, 2, 3, 1, fill, top");
		
		JLabel emailLabel = new JLabel("Epost:");
		accountAndDeliveryPanel.add(emailLabel, "2, 4, right, center");
		emailLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		emailTextField = new JTextField();
		accountAndDeliveryPanel.add(emailTextField, "4, 4, 3, 1, fill, top");
		emailTextField.setColumns(10);
		
		JLabel deliveryInfoLabel = new JLabel("<html><span style=\"text-decoration: underline;\">Leveransinformation</span>");
		accountAndDeliveryPanel.add(deliveryInfoLabel, "2, 10, 3, 1, left, top");
		
		JLabel adressLabel = new JLabel("Adress:");
		accountAndDeliveryPanel.add(adressLabel, "2, 12, right, center");
		adressLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel postalCodeLabel = new JLabel("Postnummer:");
		accountAndDeliveryPanel.add(postalCodeLabel, "2, 14, right, center");
		postalCodeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel cityLabel = new JLabel("Stad:");
		accountAndDeliveryPanel.add(cityLabel, "2, 16, right, center");
		cityLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		addressTextField = new JTextField();
		accountAndDeliveryPanel.add(addressTextField, "4, 12, 3, 1, fill, top");
		addressTextField.setColumns(10);
		
		postalCodeTextField = new JTextField();
		accountAndDeliveryPanel.add(postalCodeTextField, "4, 14, 3, 1, fill, top");
		postalCodeTextField.setColumns(10);
		
		cityTextField = new JTextField();
		accountAndDeliveryPanel.add(cityTextField, "4, 16, 3, 1, fill, top");
		cityTextField.setColumns(10);
		
		final JButton secondDoneButton = new JButton("Ok");
		secondDoneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doneButton.doClick();
			}
		});
		accountAndDeliveryPanel.add(secondDoneButton, "6, 18, fill, top");
		
		final JButton firstCancelButton = new JButton("Avbryt");
		accountAndDeliveryPanel.add(firstCancelButton, "2, 18, fill, top");
		
		final JLabel emailErrorLabel = new JLabel("*");
		emailErrorLabel.setForeground(Color.RED);
		emailErrorLabel.setVisible(false);
		accountAndDeliveryPanel.add(emailErrorLabel, "8, 4, fill, center");
		
		final JLabel adressErrorLabel = new JLabel("*");
		adressErrorLabel.setForeground(Color.RED);
		adressErrorLabel.setVisible(false);
		accountAndDeliveryPanel.add(adressErrorLabel, "8, 12, fill, center");
		
		final JLabel postalCodeErrorLabel = new JLabel("*");
		postalCodeErrorLabel.setForeground(Color.RED);
		postalCodeErrorLabel.setVisible(false);
		accountAndDeliveryPanel.add(postalCodeErrorLabel, "8, 14, fill, center");
		
		final JLabel cityErrorLabel = new JLabel("*");
		cityErrorLabel.setForeground(Color.RED);
		cityErrorLabel.setVisible(false);
		accountAndDeliveryPanel.add(cityErrorLabel, "8, 16, fill, center");
		firstCancelButton.addActionListener(cancelButtonListener);
		
		JPanel passwordPanel = new JPanel();
		tabbedPane.addTab("Ändra lösenord", null, passwordPanel, null);
		passwordPanel.setLayout(null);
		
		JLabel lblndraLsenord = new JLabel("Ändra lösenord");
		lblndraLsenord.setBounds(12, 12, 119, 15);
		passwordPanel.add(lblndraLsenord);
		
		JLabel lblNyttLsenord = new JLabel("Nytt lösenord:");
		lblNyttLsenord.setBounds(22, 39, 109, 15);
		passwordPanel.add(lblNyttLsenord);
		
		JLabel lblRepetera = new JLabel("Repetera:");
		lblRepetera.setBounds(22, 79, 109, 15);
		passwordPanel.add(lblRepetera);
		
		JButton btnNewButton = new JButton("Avbryt");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountView.this.dispose();
			}
		});
		btnNewButton.setBounds(14, 228, 117, 25);
		passwordPanel.add(btnNewButton);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doneButton.doClick();
			}
		});
		btnOk.setBounds(231, 228, 117, 25);
		passwordPanel.add(btnOk);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(149, 37, 172, 19);
		passwordPanel.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		repeatPasswordTextField = new JTextField();
		repeatPasswordTextField.setBounds(149, 77, 172, 19);
		passwordPanel.add(repeatPasswordTextField);
		repeatPasswordTextField.setColumns(10);
		
		final JLabel passwordErrorLabel = new JLabel("*");
		passwordErrorLabel.setForeground(Color.RED);
		passwordErrorLabel.setBounds(328, 39, 32, 15);
		passwordPanel.add(passwordErrorLabel);
		passwordErrorLabel.setVisible(false);
		
		final JLabel repeatPasswordErrorLabel = new JLabel("*");
		repeatPasswordErrorLabel.setForeground(Color.RED);
		repeatPasswordErrorLabel.setBounds(328, 79, 32, 15);
		passwordPanel.add(repeatPasswordErrorLabel);
		repeatPasswordErrorLabel.setVisible(false);
		
		final JTextField[] accountDeliveryInputs = { 	emailTextField,
														passwordTextField,
														repeatPasswordTextField,
														addressTextField,
														postalCodeTextField,
														cityTextField };
		final JRadioButton[] paymentInputs = {	cardRadioButton,
												internetBankRadioButton,
												inoviceRadioButton,
												paypalRadioButton };

		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean invalidInputFlag = false;
				
				if (emailTextField.getText().equals("") )
					emailErrorLabel.setVisible(true);
				else
					emailErrorLabel.setVisible(false);
				if ( !passwordTextField.getText().equals(repeatPasswordTextField.getText()) ) {
					passwordErrorLabel.setVisible(true);
					invalidInputFlag = true;
				} else
					passwordErrorLabel.setVisible(false);
				if ( !passwordTextField.getText().equals(repeatPasswordTextField.getText()) ) {
					repeatPasswordErrorLabel.setVisible(true);
					invalidInputFlag = true;
				} else
					repeatPasswordErrorLabel.setVisible(false);
				if ( addressTextField.getText().equals("") )
					adressErrorLabel.setVisible(true);
				else
					adressErrorLabel.setVisible(false);
				if ( postalCodeTextField.getText().equals("") )
					postalCodeErrorLabel.setVisible(true);
				else
					postalCodeErrorLabel.setVisible(false);
				if ( cityTextField.getText().equals("") )
					cityErrorLabel.setVisible(true);
				else
					cityErrorLabel.setVisible(false);
				
				for(JTextField input : accountDeliveryInputs) {
					if (input.getText().equals("") && input.getClass() != JPasswordField.class )
						invalidInputFlag = true;
				}
				
				if ( buttonGroup.getSelection() == null ) {
					invalidInputFlag = true;
					cardErrorLabel.setVisible(true);
					internetBankErrorLabel.setVisible(true);
					inoviceErrorLabel.setVisible(true);
					paypalErrorLabel.setVisible(true);
				} else if ( 	cardRadioButton.isSelected() && (
							cardNumberTextField.getText().equals("") ||
							monthComboBox.getSelectedIndex() == 0 ||
							yearComboBox.getSelectedIndex() == 0 ||
							cvcTextField.getText().equals("") ||
							nameTextField.getText().equals(""))) {
					cardErrorLabel.setVisible(true);
					internetBankErrorLabel.setVisible(false);
					inoviceErrorLabel.setVisible(false);
					paypalErrorLabel.setVisible(false);
					invalidInputFlag = true;
				} else
					cardErrorLabel.setVisible(false);
				
				if ( !invalidInputFlag ) {
					AccountView.this.dispose();
					if ( cardRadioButton.isSelected() )
						AccountView.this.createAccount();
					else
						AccountView.this.createAccount();
				}
			}
		});
		
		emailTextField.setText(user.getUserName());
		addressTextField.setText(customer.getAddress());
		postalCodeTextField.setText(customer.getPostCode());
		cityTextField.setText(customer.getPostAddress());
		
		for (JTextField input : accountDeliveryInputs) {
			input.addKeyListener(actionKeyListener);
		}
		for (JRadioButton input : paymentInputs) {
			input.addKeyListener(actionKeyListener);
		}
		cardNumberTextField.addKeyListener(actionKeyListener);
		monthComboBox.addKeyListener(actionKeyListener);
		yearComboBox.addKeyListener(actionKeyListener);
		cvcTextField.addKeyListener(actionKeyListener);
		nameTextField.addKeyListener(actionKeyListener);
		
		pack();
		setLocationRelativeTo(mainFrame);
		setVisible(true);
	}
	
	
	
	public void createAccount() {
		IMatDataHandler handler = IMatDataHandler.getInstance();

		User user = handler.getUser();
		user.setUserName(emailTextField.getText());
		user.setPassword(passwordTextField.getText());
		
		Customer customer = handler.getCustomer();
		customer.setAddress(addressTextField.getText());
		customer.setPostCode(postalCodeTextField.getText());
		customer.setPostAddress(cityTextField.getText());
		
		CreditCard card = handler.getCreditCard();
		card.setCardNumber(cardNumberTextField.getText());
		card.setValidMonth(Integer.parseInt((String)monthComboBox.getSelectedItem()));
		card.setValidYear(Integer.parseInt((String)yearComboBox.getSelectedItem()));
		card.setVerificationCode(Integer.parseInt(cvcTextField.getText()));
		card.setHoldersName(nameTextField.getText());
	}
}


