package v1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
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

public class NewUserFrame extends JFrame {

  private JPanel contentPane;
	
	private LoginFrame loginFrame;
	private JTextField emailTextField;
	private JPasswordField passwordTextField;
	private JPasswordField repeatPasswordTextField;
	private JTextField adressTextField;
	private JTextField postalCodeTextfield;
	private JTextField cityTextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField cardNumberTextField;
	private JTextField cvcTextField;
	private JTextField nameTextField;

	/**
	 * Create the frame.
	 */
	public NewUserFrame(final LoginFrame loginFrame) {
		setResizable(false);
		setTitle("Skapa konto");
		this.loginFrame = loginFrame;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 370, 340);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Panel.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setEnabled(false);
		tabbedPane.setBounds(12, 0, 344, 292);
		contentPane.add(tabbedPane);
		
		JPanel accountAndDeliveryPanel = new JPanel();
		tabbedPane.addTab("Konto och leverans", null, accountAndDeliveryPanel, null);
		accountAndDeliveryPanel.setLayout(null);
		
		JLabel accountInfoLabel = new JLabel("<html><span style=\"text-decoration: underline;\">Kontoinformation</span>");
		accountInfoLabel.setBounds(12, 12, 151, 15);
		accountAndDeliveryPanel.add(accountInfoLabel);
		
		JLabel emailLabel = new JLabel("Epost:");
		emailLabel.setBounds(106, 41, 45, 15);
		accountAndDeliveryPanel.add(emailLabel);
		emailLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(156, 39, 171, 19);
		accountAndDeliveryPanel.add(emailTextField);
		emailTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Lösenord:");
		passwordLabel.setBounds(79, 68, 72, 15);
		accountAndDeliveryPanel.add(passwordLabel);
		passwordLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(156, 66, 171, 19);
		accountAndDeliveryPanel.add(passwordTextField);
		passwordTextField.setEchoChar('*');
		passwordTextField.setColumns(10);
		
		JLabel repeatPasswordLabel = new JLabel("Lösenord igen:");
		repeatPasswordLabel.setBounds(44, 95, 107, 15);
		accountAndDeliveryPanel.add(repeatPasswordLabel);
		repeatPasswordLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		repeatPasswordTextField = new JPasswordField();
		repeatPasswordTextField.setBounds(156, 93, 171, 19);
		accountAndDeliveryPanel.add(repeatPasswordTextField);
		repeatPasswordTextField.setEchoChar('*');
		repeatPasswordTextField.setColumns(10);
		
		JLabel deliveryInfoLabel = new JLabel("<html><span style=\"text-decoration: underline;\">Leveransinformation</span>");
		deliveryInfoLabel.setBounds(12, 122, 147, 15);
		accountAndDeliveryPanel.add(deliveryInfoLabel);
		
		JLabel adressLabel = new JLabel("Adress:");
		adressLabel.setBounds(97, 149, 54, 15);
		accountAndDeliveryPanel.add(adressLabel);
		adressLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel postalCodeLabel = new JLabel("Postnummer:");
		postalCodeLabel.setBounds(57, 176, 94, 15);
		accountAndDeliveryPanel.add(postalCodeLabel);
		postalCodeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel cityLabel = new JLabel("Stad:");
		cityLabel.setBounds(113, 203, 38, 15);
		accountAndDeliveryPanel.add(cityLabel);
		cityLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		adressTextField = new JTextField();
		adressTextField.setBounds(156, 147, 171, 19);
		accountAndDeliveryPanel.add(adressTextField);
		adressTextField.setColumns(10);
		
		postalCodeTextfield = new JTextField();
		postalCodeTextfield.setBounds(156, 174, 171, 19);
		accountAndDeliveryPanel.add(postalCodeTextfield);
		postalCodeTextfield.setColumns(10);
		
		cityTextField = new JTextField();
		cityTextField.setBounds(156, 201, 171, 19);
		accountAndDeliveryPanel.add(cityTextField);
		cityTextField.setColumns(10);
		
		JButton nextButton = new JButton("Nästa");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		nextButton.setBounds(210, 233, 117, 25);
		accountAndDeliveryPanel.add(nextButton);
		
		JButton firstCancelButton = new JButton("Avbryt");
		firstCancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		firstCancelButton.setBounds(12, 233, 117, 25);
		accountAndDeliveryPanel.add(firstCancelButton);
		
		JPanel paymentPanel = new JPanel();
		tabbedPane.addTab("Betalning", null, paymentPanel, null);
		paymentPanel.setLayout(null);
		
		JLabel paymentInfoLabel = new JLabel("<html><span style=\"text-decoration: underline;\">Betalningsinformation</span>");
		paymentInfoLabel.setBounds(12, 12, 158, 15);
		paymentPanel.add(paymentInfoLabel);
		
		JLabel paymentOptionLabel = new JLabel("Välj betalsätt:");
		paymentOptionLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		paymentOptionLabel.setBounds(69, 39, 101, 15);
		paymentPanel.add(paymentOptionLabel);
		
		final JRadioButton cardPaymentRadioButton = new JRadioButton("Kortbetalning");
		buttonGroup.add(cardPaymentRadioButton);
		cardPaymentRadioButton.setBounds(19, 62, 123, 23);
		paymentPanel.add(cardPaymentRadioButton);
		
		JRadioButton internetBankRadioButton = new JRadioButton("Internetbank");
		buttonGroup.add(internetBankRadioButton);
		internetBankRadioButton.setBounds(19, 89, 123, 23);
		paymentPanel.add(internetBankRadioButton);
		
		JRadioButton inoviceRadioButton = new JRadioButton("Faktura");
		buttonGroup.add(inoviceRadioButton);
		inoviceRadioButton.setBounds(19, 116, 123, 23);
		paymentPanel.add(inoviceRadioButton);
		
		JRadioButton paypalRadioButton = new JRadioButton("PayPal");
		buttonGroup.add(paypalRadioButton);
		paypalRadioButton.setBounds(19, 143, 123, 23);
		paymentPanel.add(paypalRadioButton);
		
		JButton previousButton = new JButton("Föregående");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		previousButton.setBounds(12, 228, 130, 25);
		paymentPanel.add(previousButton);
		
		JButton doneButton = new JButton("Klar");
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewUserFrame.this.dispose();
				loginFrame.createAccount();
			}
		});
		doneButton.setBounds(210, 228, 117, 25);
		paymentPanel.add(doneButton);
		
		JButton secondCancelButton = new JButton("Avbryt");
		secondCancelButton.setBounds(12, 191, 130, 25);
		paymentPanel.add(secondCancelButton);
		
		final JPanel cardPaymentPanel = new JPanel();
		cardPaymentPanel.setVisible(false);
		cardPaymentPanel.setBounds(154, 66, 173, 150);
		paymentPanel.add(cardPaymentPanel);
		cardPaymentPanel.setLayout(null);
		
		JLabel cardNumberLabel = new JLabel("Kortnummer");
		cardNumberLabel.setBounds(0, 0, 173, 15);
		cardPaymentPanel.add(cardNumberLabel);
		
		cardNumberTextField = new JTextField();
		cardNumberTextField.setBounds(0, 22, 173, 19);
		cardPaymentPanel.add(cardNumberTextField);
		cardNumberTextField.setColumns(10);
		
		JLabel expireLabel = new JLabel("Utgångsdatum");
		expireLabel.setBounds(0, 53, 115, 15);
		cardPaymentPanel.add(expireLabel);
		
		JLabel cvcLabel = new JLabel("CVC");
		cvcLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		cvcLabel.setBounds(127, 53, 34, 15);
		cardPaymentPanel.add(cvcLabel);
		
		JComboBox monthComboBox = new JComboBox();
		monthComboBox.setBounds(0, 80, 43, 24);
		cardPaymentPanel.add(monthComboBox);
		
		JLabel dividerLabel = new JLabel("/");
		dividerLabel.setBounds(45, 85, 11, 15);
		cardPaymentPanel.add(dividerLabel);
		
		JComboBox yearComboBox = new JComboBox();
		yearComboBox.setBounds(55, 80, 43, 24);
		cardPaymentPanel.add(yearComboBox);
		
		cvcTextField = new JTextField();
		cvcTextField.setBounds(118, 80, 43, 19);
		cardPaymentPanel.add(cvcTextField);
		cvcTextField.setColumns(10);
		
		JLabel nameLabel = new JLabel("Namn");
		nameLabel.setBounds(0, 116, 70, 15);
		cardPaymentPanel.add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(1, 131, 172, 19);
		cardPaymentPanel.add(nameTextField);
		nameTextField.setColumns(10);
		
		ActionListener radioButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton radioButton = (JRadioButton) e.getSource();
				if (radioButton == cardPaymentRadioButton)
					cardPaymentPanel.setVisible(true);
				else
					cardPaymentPanel.setVisible(false);
			}
			
		};
		cardPaymentRadioButton.addActionListener(radioButtonListener);
		internetBankRadioButton.addActionListener(radioButtonListener);
		inoviceRadioButton.addActionListener(radioButtonListener);
		paypalRadioButton.addActionListener(radioButtonListener);
		
		ActionListener cancelButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewUserFrame.this.dispose();
			}
			
		};
		firstCancelButton.addActionListener(cancelButtonListener);
		secondCancelButton.addActionListener(cancelButtonListener);
		
		setVisible(true);
	}
}
