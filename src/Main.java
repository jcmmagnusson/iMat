import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.swing.JFrame;

import se.chalmers.ait.dat215.project.IMatDataHandler;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// temporarily prevent output from IMatDataHandler
		PrintStream defaultSystemOut = System.out;
		try {
			System.setOut(new PrintStream("bin/output.txt"));
			IMatDataHandler.getInstance();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			System.setOut(defaultSystemOut);
		}
		
		MainView mainView = new MainView();
		mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainView.pack();
		mainView.setLocationRelativeTo(null);
		mainView.setVisible(true);
	}

}
