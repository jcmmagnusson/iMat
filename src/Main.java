import javax.swing.JFrame;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainView mainView = new MainView();
		mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainView.pack();
		mainView.setLocationRelativeTo(null);
		mainView.setVisible(true);
	}

}
