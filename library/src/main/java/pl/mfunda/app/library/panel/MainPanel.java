package pl.mfunda.app.library.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class MainPanel extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	private Image back;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPanel frame = new MainPanel();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPanel() {
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		Toolkit kit = Toolkit.getDefaultToolkit();
		back = kit.getImage("dollars.jpg");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLocation(dim.width/2 - contentPane.getWidth()/2, dim.height/2 - contentPane.getHeight()/2);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewPanel view = new ViewPanel();
				view.setVisible(true);
				setVisible(false);
			}
		});
		btnView.setBounds(156, 90, 117, 25);
		contentPane.add(btnView);
		
		
		JButton btnDodaj = new JButton("Add");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddPanel addPanel = new AddPanel();
				addPanel.setVisible(true);
				setVisible(false);
			}
		});
		btnDodaj.setBounds(156, 127, 117, 25);
		contentPane.add(btnDodaj);
		
		JButton btnUsun = new JButton("Remove");
		btnUsun.setBounds(156, 164, 117, 25);
		contentPane.add(btnUsun);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnClose.setBounds(156, 201, 117, 25);
		contentPane.add(btnClose);
		
		JLabel lblLibraryDatabase = new JLabel("Library database");
		lblLibraryDatabase.setBounds(123, 12, 200, 50);
		lblLibraryDatabase.setFont(new Font("Ubuntu", Font.BOLD, 23));
		contentPane.add(lblLibraryDatabase);
	}
	public void paintComponent(Graphics comp){
		Graphics2D comp2D = (Graphics2D)comp;
		if (back != null)
		comp2D.drawImage(back, 0, 0, this);
	}
}
