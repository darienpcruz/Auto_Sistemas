package Menus;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Sesion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField Usuario;
	private JPasswordField Contra;
	private JTextField Host;
	private JTextField Port;

	public Sesion() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(56, 102, 330, 242);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(10, 33, 46, 14);
		panel.add(lblNewLabel);
		
		Usuario = new JTextField();
		Usuario.setBounds(85, 30, 218, 20);
		panel.add(Usuario);
		Usuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(10, 80, 65, 14);
		panel.add(lblNewLabel_1);
		
		Contra = new JPasswordField();
		Contra.setBounds(85, 77, 218, 20);
		panel.add(Contra);
		
		JLabel lblNewLabel_2 = new JLabel("Host");
		lblNewLabel_2.setBounds(10, 129, 46, 14);
		panel.add(lblNewLabel_2);
		
		Host = new JTextField();
		Host.setBounds(85, 126, 218, 20);
		panel.add(Host);
		Host.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Port");
		lblNewLabel_3.setBounds(10, 176, 46, 14);
		panel.add(lblNewLabel_3);
		
		Port = new JTextField();
		Port.setBounds(84, 173, 219, 20);
		panel.add(Port);
		Port.setColumns(10);

	}
}
