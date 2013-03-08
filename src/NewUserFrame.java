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

public class NewUserFrame extends JDialog {
	
	private JPanel contentPane;
	
	private LoginFrame loginFrame;
	private JTextField emailTextField;
	private JPasswordField passwordTextField;
	private JPasswordField repeatPasswordTextField;
	private JTextField adressTextField;
	private JTextField postalCodeTextField;
	private JTextField cityTextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField cardNumberTextField;
	private final JComboBox monthComboBox;
	private final JComboBox yearComboBox;
	private JTextField cvcTextField;
	private JTextField nameTextField;
	private JTextField txtFirstName;
	private JTextField txtSurName;
	private JRadioButton cardRadioButton;
	private JRadioButton internetBankRadioButton;
	private JRadioButton inoviceRadioButton;
	private JRadioButton paypalRadioButton;

	/**
	 * Create the frame.
	 */
	public NewUserFrame(final LoginFrame loginFrame) {
		super(loginFrame, "Skapa konto", true);
		setResizable(false);
		this.loginFrame = loginFrame;
		
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
		tabbedPane.setEnabled(false);
		contentPane.add(tabbedPane, "2, 1, fill, fill");
		
		JPanel accountAndDeliveryPanel = new JPanel();
		accountAndDeliveryPanel.setVisible(false);
		tabbedPane.addTab("Konto och leverans", null, accountAndDeliveryPanel, null);
		accountAndDeliveryPanel.setLayout(null);
		
		JLabel emailLabel = new JLabel("Epost:");
		emailLabel.setBounds(114, 67, 31, 14);
		accountAndDeliveryPanel.add(emailLabel);
		emailLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(150, 65, 171, 19);
		accountAndDeliveryPanel.add(emailTextField);
		emailTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("LÃ¶senord:");
		passwordLabel.setBounds(90, 92, 55, 14);
		accountAndDeliveryPanel.add(passwordLabel);
		passwordLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(150, 90, 171, 19);
		accountAndDeliveryPanel.add(passwordTextField);
		passwordTextField.setEchoChar('*');
		passwordTextField.setColumns(10);
		
		JLabel repeatPasswordLabel = new JLabel("LÃ¶senord igen:");
		repeatPasswordLabel.setBounds(67, 117, 78, 14);
		accountAndDeliveryPanel.add(repeatPasswordLabel);
		repeatPasswordLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		repeatPasswordTextField = new JPasswordField();
		repeatPasswordTextField.setBounds(150, 115, 171, 19);
		accountAndDeliveryPanel.add(repeatPasswordTextField);
		repeatPasswordTextField.setEchoChar('*');
		repeatPasswordTextField.setColumns(10);
		
		JLabel adressLabel = new JLabel("Adress:");
		adressLabel.setBounds(108, 145, 37, 14);
		accountAndDeliveryPanel.add(adressLabel);
		adressLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel postalCodeLabel = new JLabel("Postnummer:");
		postalCodeLabel.setBounds(82, 170, 63, 14);
		accountAndDeliveryPanel.add(postalCodeLabel);
		postalCodeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel cityLabel = new JLabel("Stad:");
		cityLabel.setBounds(119, 195, 26, 14);
		accountAndDeliveryPanel.add(cityLabel);
		cityLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		adressTextField = new JTextField();
		adressTextField.setBounds(150, 143, 171, 19);
		accountAndDeliveryPanel.add(adressTextField);
		adressTextField.setColumns(10);
		
		postalCodeTextField = new JTextField();
		postalCodeTextField.setBounds(150, 168, 171, 19);
		accountAndDeliveryPanel.add(postalCodeTextField);
		postalCodeTextField.setColumns(10);
		postalCodeTextField.setDocument(new JTextFieldLimit(6));
		
		cityTextField = new JTextField();
		cityTextField.setBounds(150, 193, 171, 19);
		accountAndDeliveryPanel.add(cityTextField);
		cityTextField.setColumns(10);
		
		final JButton nextButton = new JButton("NÃ¤sta");
		nextButton.setBounds(204, 223, 117, 23);
		accountAndDeliveryPanel.add(nextButton);
		
		final JButton firstCancelButton = new JButton("Avbryt");
		firstCancelButton.setBounds(6, 223, 139, 23);
		accountAndDeliveryPanel.add(firstCancelButton);
		
		final JLabel emailErrorLabel = new JLabel("*");
		emailErrorLabel.setBounds(326, 67, 15, 14);
		emailErrorLabel.setForeground(Color.RED);
		emailErrorLabel.setVisible(false);
		accountAndDeliveryPanel.add(emailErrorLabel);
		
		final JLabel passwordErrorLabel = new JLabel("*");
		passwordErrorLabel.setBounds(326, 92, 15, 14);
		passwordErrorLabel.setForeground(Color.RED);
		passwordErrorLabel.setVisible(false);
		accountAndDeliveryPanel.add(passwordErrorLabel);
		
		final JLabel repeatPasswordErrorLabel = new JLabel("*");
		repeatPasswordErrorLabel.setBounds(326, 117, 15, 14);
		repeatPasswordErrorLabel.setForeground(Color.RED);
		repeatPasswordErrorLabel.setVisible(false);
		accountAndDeliveryPanel.add(repeatPasswordErrorLabel);
		
		final JLabel adressErrorLabel = new JLabel("*");
		adressErrorLabel.setBounds(326, 145, 15, 14);
		adressErrorLabel.setForeground(Color.RED);
		adressErrorLabel.setVisible(false);
		accountAndDeliveryPanel.add(adressErrorLabel);
		
		final JLabel postalCodeErrorLabel = new JLabel("*");
		postalCodeErrorLabel.setBounds(326, 170, 15, 14);
		postalCodeErrorLabel.setForeground(Color.RED);
		postalCodeErrorLabel.setVisible(false);
		accountAndDeliveryPanel.add(postalCodeErrorLabel);
		
		final JLabel cityErrorLabel = new JLabel("*");
		cityErrorLabel.setBounds(326, 195, 15, 14);
		cityErrorLabel.setForeground(Color.RED);
		cityErrorLabel.setVisible(false);
		accountAndDeliveryPanel.add(cityErrorLabel);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(150, 11, 171, 20);
		accountAndDeliveryPanel.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtSurName = new JTextField();
		txtSurName.setColumns(10);
		txtSurName.setBounds(150, 36, 171, 20);
		accountAndDeliveryPanel.add(txtSurName);
		
		final JLabel surNameErrorLabel = new JLabel("*");
		surNameErrorLabel.setVisible(false);
		surNameErrorLabel.setForeground(Color.RED);
		surNameErrorLabel.setBounds(326, 39, 15, 14);
		accountAndDeliveryPanel.add(surNameErrorLabel);
		
		final JLabel firstNameErrorLabel = new JLabel("*");
		firstNameErrorLabel.setVisible(false);
		firstNameErrorLabel.setForeground(Color.RED);
		firstNameErrorLabel.setBounds(326, 14, 15, 14);
		accountAndDeliveryPanel.add(firstNameErrorLabel);
		
		JLabel firstNameLabel = new JLabel("F\u00F6rnamn:");
		firstNameLabel.setBounds(99, 14, 46, 14);
		accountAndDeliveryPanel.add(firstNameLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Efternamn:");
		lblNewLabel_1.setBounds(90, 39, 55, 14);
		accountAndDeliveryPanel.add(lblNewLabel_1);
		
		
		
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
		
		JLabel paymentOptionLabel = new JLabel("VÃ¤lj betalsÃ¤tt:");
		paymentOptionLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		paymentPanel.add(paymentOptionLabel, "4, 4, 3, 1, left, top");
		
		cardRadioButton = new JRadioButton("Kortbetalning");
		buttonGroup.add(cardRadioButton);
		paymentPanel.add(cardRadioButton, "3, 6, 2, 1, left, top");
		
		internetBankRadioButton = new JRadioButton("Internetbank");
		buttonGroup.add(internetBankRadioButton);
		paymentPanel.add(internetBankRadioButton, "3, 8, 2, 1, left, top");
		
		inoviceRadioButton = new JRadioButton("Faktura");
		buttonGroup.add(inoviceRadioButton);
		paymentPanel.add(inoviceRadioButton, "3, 10, 2, 1, left, top");
		
		paypalRadioButton = new JRadioButton("PayPal");
		buttonGroup.add(paypalRadioButton);
		paymentPanel.add(paypalRadioButton, "3, 12, 2, 1, left, top");
		
		JButton previousButton = new JButton("FÃ¶regÃ¥ende");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		paymentPanel.add(previousButton, "2, 16, 3, 1, fill, top");
		
		final JButton doneButton = new JButton("Klar");
		paymentPanel.add(doneButton, "8, 16, fill, top");
		
		JButton secondCancelButton = new JButton("Avbryt");
		paymentPanel.add(secondCancelButton, "2, 14, 3, 1, fill, top");
		
		final JPanel cardPaymentPanel = new JPanel();
		cardPaymentPanel.setVisible(false);
		paymentPanel.add(cardPaymentPanel, "6, 6, 3, 9, fill, fill");
		cardPaymentPanel.setLayout(null);
		
		JLabel cardNumberLabel = new JLabel("Kortnummer");
		cardNumberLabel.setBounds(12, 0, 161, 15);
		cardPaymentPanel.add(cardNumberLabel);
		
		cardNumberTextField = new JTextField();
		cardNumberTextField.setBounds(12, 22, 170, 19);
		cardPaymentPanel.add(cardNumberTextField);
		cardNumberTextField.setColumns(10);
		cardNumberTextField.setDocument(new JTextFieldLimit(16));
		
		JLabel expireLabel = new JLabel("UtgÃ¥ngsdatum");
		expireLabel.setBounds(10, 53, 115, 15);
		cardPaymentPanel.add(expireLabel);
		
		JLabel cvcLabel = new JLabel("CVC");
		cvcLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		cvcLabel.setBounds(148, 53, 34, 15);
		cardPaymentPanel.add(cvcLabel);
		
		monthComboBox = new JComboBox();
		monthComboBox.setModel(new DefaultComboBoxModel(new String[] {"m", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthComboBox.setSelectedIndex(0);
		monthComboBox.setBounds(10, 80, 43, 24);
		cardPaymentPanel.add(monthComboBox);
		
		JLabel dividerLabel = new JLabel("/");
		dividerLabel.setBounds(55, 85, 11, 15);
		cardPaymentPanel.add(dividerLabel);
		
		yearComboBox = new JComboBox();
		yearComboBox.setModel(new DefaultComboBoxModel(new String[] {"y", "13", "14", "15", "16", "17", "18"}));
		yearComboBox.setSelectedIndex(0);
		yearComboBox.setBounds(65, 80, 43, 24);
		cardPaymentPanel.add(yearComboBox);
		
		cvcTextField = new JTextField();
		cvcTextField.setBounds(139, 80, 43, 19);
		cardPaymentPanel.add(cvcTextField);
		cvcTextField.setColumns(10);
		cvcTextField.setDocument(new JTextFieldLimit(3));
		
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
		
		final JTextField[] accountDeliveryInputs = { 	txtFirstName,
														txtSurName,
														emailTextField,
														passwordTextField,
														repeatPasswordTextField,
														adressTextField,
														postalCodeTextField,
														cityTextField };
		final JRadioButton[] paymentInputs = {	cardRadioButton,
												internetBankRadioButton,
												inoviceRadioButton,
												paypalRadioButton };
		
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
				NewUserFrame.this.dispose();
			}
			
		};

		firstCancelButton.addActionListener(cancelButtonListener);
		secondCancelButton.addActionListener(cancelButtonListener);
		
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean invalidInputFlag = false;
				
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
					NewUserFrame.this.dispose();
					if ( cardRadioButton.isSelected() )
						NewUserFrame.this.createAccount();
					else
						NewUserFrame.this.createAccount();
				}
			}
		});
		
		KeyAdapter actionKeyListener = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					switch (tabbedPane.getSelectedIndex()) {
					case 0:
						nextButton.doClick();
						break;
					case 1:
						doneButton.doClick();
						break;
					}
				}
				else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					firstCancelButton.doClick();
				}
			}
		};
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
		
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean invalidInputFlag = false;
				
				if (txtFirstName.getText().equals("")){
					firstNameErrorLabel.setVisible(true);
				}else{
					firstNameErrorLabel.setVisible(false);
				}
				
				if (txtSurName.getText().equals("")){
					surNameErrorLabel.setVisible(true);
				}else{
					surNameErrorLabel.setVisible(false);
				}
				
				if (emailTextField.getText().equals("") )
					emailErrorLabel.setVisible(true);
				else
					emailErrorLabel.setVisible(false);
				if ( passwordTextField.getText().equals("") || 
						!passwordTextField.getText().equals(repeatPasswordTextField.getText())) {
					passwordErrorLabel.setVisible(true);
					invalidInputFlag = true;
				} else
					passwordErrorLabel.setVisible(false);
				if ( repeatPasswordTextField.getText().equals("") || 
						!passwordTextField.getText().equals(repeatPasswordTextField.getText())) {
					repeatPasswordErrorLabel.setVisible(true);
					invalidInputFlag = true;
				} else
					repeatPasswordErrorLabel.setVisible(false);
				if ( adressTextField.getText().equals("") )
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
					if (input.getText().equals(""))
						invalidInputFlag = true;
				}
				if (!invalidInputFlag)
					tabbedPane.setSelectedIndex(1);
			}
		});
		
		pack();
		setLocationRelativeTo(loginFrame);
		setVisible(true);
	}
	
	
	
	public void createAccount() {
		IMatDataHandler2.isLoggedInAsUser = true;
		IMatDataHandler handler = IMatDataHandler.getInstance();
		handler.getOrders().clear();

		User user = handler.getUser();
		user.setUserName(emailTextField.getText());
		user.setPassword(passwordTextField.getText());
		
		
		Customer customer = handler.getCustomer();
		customer.setFirstName(txtFirstName.getText());
		customer.setLastName(txtSurName.getText());
		customer.setAddress(adressTextField.getText());
		customer.setPostCode(postalCodeTextField.getText());
		customer.setPostAddress(cityTextField.getText());
		
		if(cardRadioButton.isSelected()){
			customer.setPhoneNumber(IMatDataHandler2.CARD);
			CreditCard card = handler.getCreditCard();
			card.setCardNumber(cardNumberTextField.getText());
			card.setValidMonth(Integer.parseInt((String)monthComboBox.getSelectedItem()));
			card.setValidYear(Integer.parseInt((String)yearComboBox.getSelectedItem()));
			card.setVerificationCode(Integer.parseInt(cvcTextField.getText()));
			card.setHoldersName(nameTextField.getText());
		} else if (internetBankRadioButton.isSelected()){
			customer.setPhoneNumber(IMatDataHandler2.INTERNET);
		} else if (inoviceRadioButton.isSelected()){
			customer.setPhoneNumber(IMatDataHandler2.INOVICE);
		} else {
			customer.setPhoneNumber(IMatDataHandler2.PAYPAL);
		}
			
		loginFrame.execute_login();
		
	}
}


