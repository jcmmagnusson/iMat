import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.swing.JFrame;

import se.chalmers.ait.dat215.project.IMatDataHandler;


public class Main {
	
	private static PrintStream defaultSystemOut = System.out;
	
	private static JFrame mainView;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// prevent output from IMatDataHandler at start
		disableIMatDataHandlerOutput();
		IMatDataHandler.getInstance(); // initialize
		enableIMatDataHandlerOutput();
		
		// saves the current state of IMatDataHandler upon application exit
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	        public void run() {
	        	disableIMatDataHandlerOutput(); // prevent save logging
	        	IMatDataHandler.getInstance().shutDown();
	        }
	    }));
		
		mainView = new MainView();
		mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainView.pack();
		mainView.setResizable(false);
		mainView.setLocationRelativeTo(null);
		mainView.setVisible(true);
	}
	
	protected static JFrame getMainFrame(){
		return mainView;
	}
	
	private static void disableIMatDataHandlerOutput(){
		try {
			System.setOut(new PrintStream("bin/output.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void enableIMatDataHandlerOutput(){
		System.setOut(defaultSystemOut);
	}

}
