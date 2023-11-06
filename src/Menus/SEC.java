package Menus;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import Menus.Login;
import java.awt.SystemColor;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;

public class SEC extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Usuario;
	private JPasswordField Contrasena;
	private JTextField Host;
	private JTextField Port;

	public SEC() {
		setBackground(SystemColor.desktop);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Inicio");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Hacer conexcion");
		mntmNewMenuItem.setEnabled(false);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cerrar Conexion");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
				
                SEC sec = new SEC();
				sec.setVisible(false);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Sin funcion");
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 445, 439);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(444, 0, 440, 439);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		panel_2.setLayout(null);
		panel_2.setBounds(45, 99, 349, 242);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Fuzzy Bubbles", lblNewLabel.getFont().getStyle(), 11));
		lblNewLabel.setBounds(10, 33, 46, 14);
		panel_2.add(lblNewLabel);
		
		Usuario = new JTextField();
		Usuario.setColumns(10);
		Usuario.setBounds(85, 30, 218, 20);
		panel_2.add(Usuario);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setFont(new Font("Fuzzy Bubbles", lblNewLabel_1.getFont().getStyle(), lblNewLabel_1.getFont().getSize()));
		lblNewLabel_1.setBounds(10, 80, 77, 14);
		panel_2.add(lblNewLabel_1);
		
		Contrasena = new JPasswordField();
		Contrasena.setBounds(85, 77, 218, 20);
		panel_2.add(Contrasena);
		
		JLabel lblNewLabel_2 = new JLabel("Host");
		lblNewLabel_2.setFont(new Font("Fuzzy Bubbles", lblNewLabel_2.getFont().getStyle(), lblNewLabel_2.getFont().getSize()));
		lblNewLabel_2.setBounds(10, 129, 46, 14);
		panel_2.add(lblNewLabel_2);
		
		Host = new JTextField();
		Host.setColumns(10);
		Host.setBounds(85, 126, 218, 20);
		panel_2.add(Host);
		
		JLabel lblNewLabel_3 = new JLabel("Port");
		lblNewLabel_3.setFont(new Font("Fuzzy Bubbles", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(10, 176, 46, 14);
		panel_2.add(lblNewLabel_3);
		
		Port = new JTextField();
		Port.setColumns(10);
		Port.setBounds(84, 173, 219, 20);
		panel_2.add(Port);
		
		JButton btnNewButton = new JButton("Conectar!");
		btnNewButton.setFont(new Font("Fuzzy Bubbles", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				String usuario = Usuario.getText();
                String contrasena = new String(Contrasena.getPassword());
                String host = Host.getText();
                String puerto = Port.getText();
                String jdbcUrl = "jdbc:mysql://" + host + ":" + puerto;

                try {
           
                	
                    Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contrasena);
                    JOptionPane.showMessageDialog(btnNewButton, "Exito");
                    connection.close();
                    

                    
                   
                     
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(btnNewButton, "Error al conectar a MySQL: " + ex.getMessage());
                    ex.printStackTrace();
                }
			}
		});
		btnNewButton.setBounds(10, 208, 89, 23);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Testear!");
		btnNewButton_1.setFont(new Font("Fuzzy Bubbles", Font.PLAIN, 11));
		btnNewButton_1.setBounds(214, 208, 89, 23);
		panel_2.add(btnNewButton_1);
	}
}
