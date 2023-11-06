package Menus;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class BD extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BD frame = new BD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BD() {
		setBounds(100, 100, 900, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
