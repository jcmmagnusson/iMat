import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CheckOut extends JDialog {

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
		setBounds(100, 100, 508, 378);
		
		JButton btnOmgSoPhat = new JButton("OMG SO PHAT");
		getContentPane().add(btnOmgSoPhat, BorderLayout.CENTER);
		
		
		JButton btnDisablePhatPls = new JButton("disable phat pls");
		btnDisablePhatPls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JButton btn = (JButton)arg0.getSource();
				btn.setVisible(false);
			}
		});
		getContentPane().add(btnDisablePhatPls, BorderLayout.WEST);

	}

}
