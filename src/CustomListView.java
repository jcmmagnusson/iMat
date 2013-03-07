import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import se.chalmers.ait.dat215.project.IMatDataHandler;


public class CustomListView extends JPanel {
	
	JPanel listPanel;
	JScrollPane scrollPane;
	
	public CustomListView(){
		setLayout(new BorderLayout(0, 0));
		
		listPanel = new JPanel();
		JPanel content = new JPanel(new BorderLayout());
		content.setOpaque(false);
		content.add(listPanel, BorderLayout.NORTH);
		JPanel centerFiller = new JPanel();
		centerFiller.setOpaque(false);
		content.add(centerFiller, BorderLayout.CENTER);
		scrollPane = new JScrollPane(content);
		add(scrollPane);
		listPanel.setBackground(UIManager.getColor("List.background"));
		listPanel.setSize(new Dimension(200, 16));
		
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		
		
		// reload
		addList("Carbonara", 37);
		addList("Frukost", 42);
	}
	
	
	private void addList(String listName, int totalCost){
		JPanel panel_19 = new JPanel();
		panel_19.setOpaque(false);
		panel_19.setPreferredSize(new Dimension(200, 35));
		panel_19.setOpaque(false);
		listPanel.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));
		
		JPanel rightPanel = new JPanel();
		rightPanel.setOpaque(false);
		JButton buyButton = new JButton("K\u00F6p");
		rightPanel.add(buyButton);
		//rightPanel.add(new JLabel(">"));
		panel_19.add(rightPanel, BorderLayout.EAST);
		
		JLabel lblPastaCarbonara = new JLabel(listName+" ("+totalCost+" kr)");
		panel_19.add(lblPastaCarbonara, BorderLayout.CENTER);
		panel_19.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
	}

}
