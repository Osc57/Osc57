package proyecto2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;

public class Prueba2 {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba2 window = new Prueba2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Prueba2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"klmñkmnoljkn"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		frame.getContentPane().add(list, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		table = new JTable();
		frame.getContentPane().add(table, BorderLayout.CENTER);
	}
}
