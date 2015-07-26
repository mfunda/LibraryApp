package pl.mfunda.app.library.panel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

import pl.mfunda.app.library.lib.Library;
public class ViewPanel extends MainPanel{
	
	private JPanel panel;
	private Library lib;
	public ViewPanel(){
		initialize();
	}
	private void initialize() {
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		panel.setLayout(null);
		setContentPane(panel);

		lib = new Library();
	
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 12, 426, 257);
		
		panel.add(tabbedPane);
		JTextPane textPane1 = new JTextPane();
		textPane1.setBounds(12, 12, 426, 276);
		tabbedPane.addTab("Books", textPane1);
		textPane1.setText(lib.selectBook().toString());
		
		JTextPane textPane2 = new JTextPane();
		textPane2.setBounds(12, 12, 426, 276);
		tabbedPane.addTab("Readers", textPane2);
		textPane2.setText(lib.selectReader().toString());
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPanel main = new MainPanel();
				main.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(12, 270, 426, 23);
		panel.add(button);
	}
}