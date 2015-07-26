package pl.mfunda.app.library.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;

import pl.mfunda.app.library.lib.Library;

public class AddPanel extends MainPanel {

	private JPanel panel;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtPesel;
	private JTextField txtTitle;
	private JTextField txtAuthor;
	private Library lib;
	
	public AddPanel(){
		initialize();
	}
	
	public void initialize(){
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		panel.setLayout(null);
		setContentPane(panel);
		
		final JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPanel main = new MainPanel();
				main.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(12, 270, 426, 23);
		panel.add(button);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 12, 426, 24);
		comboBox.addItem("Books");
		comboBox.addItem("Readers");
		panel.add(comboBox);
		
		final JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedItem()=="Readers"){
					panel.removeAll();
					panel.add(comboBox);
					panel.add(button);
					panel.add(btnAccept);
					
					txtName = new JTextField();
					txtName.setText("name");
					txtName.setBounds(12, 125, 114, 19);
					panel.add(txtName);
					txtName.setColumns(10);
					
					txtSurname = new JTextField();
					txtSurname.setText("surname");
					txtSurname.setBounds(138, 125, 114, 19);
					panel.add(txtSurname);
					txtSurname.setColumns(10);
					
					txtPesel = new JTextField();
					txtPesel.setText("pesel");
					txtPesel.setBounds(12, 156, 240, 19);
					panel.add(txtPesel);
					txtPesel.setColumns(10);
					
					JButton btnAdd = new JButton("Add");
					btnAdd.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							lib = new Library();
							lib.insertReader(txtName.getText(), txtSurname.getText(), txtPesel.getText());
						}
						});
					btnAdd.setBounds(12, 190, 117, 25);
					panel.add(btnAdd);
					
					JLabel label = new JLabel("Add new Readers");
					label.setBounds(12, 74, 200, 50);
					panel.add(label);
					repaint();
				}
				if (comboBox.getSelectedItem()=="Books"){
					panel.removeAll();
					panel.add(comboBox);
					panel.add(button);
					panel.add(btnAccept);
					txtTitle = new JTextField();
					txtTitle.setText("title");
					txtTitle.setBounds(12, 125, 114, 19);
					panel.add(txtTitle);
					txtTitle.setColumns(10);
					
					txtAuthor = new JTextField();
					txtAuthor.setText("author");
					txtAuthor.setBounds(138, 125, 114, 19);
					panel.add(txtAuthor);
					txtAuthor.setColumns(10);
					
					JButton btnAdd = new JButton("Add");
					btnAdd.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							lib = new Library();
							lib.insertBook(txtTitle.getText(), txtAuthor.getText());
						}
						});
					btnAdd.setBounds(12, 159, 117, 25);
					panel.add(btnAdd);
					
					JLabel label = new JLabel("Add new Books");
					label.setBounds(12, 74, 200, 50);
					panel.add(label);
					repaint();					
				}
			}
		});
		btnAccept.setBounds(12, 43, 117, 25);
		panel.add(btnAccept);
		

	}
}
