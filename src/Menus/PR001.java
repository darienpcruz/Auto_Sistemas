package Menus;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PR001 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Conexión a Base de Datos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextField textField = new JTextField(20);
        JButton connectButton = new JButton("Conectar a MySQL");
        JButton showTablesButton = new JButton("Mostrar Tablas");

        // Acción del botón de conexión a MySQL
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String databaseName = textField.getText();
                String message;

                try {
                    // Establece la conexión a MySQL usando la información proporcionada en la caja de texto
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, "root", "12345");
                    connection.close();
                    // Si la conexión es exitosa, muestra el mensaje con el nombre de la base de datos
                    message = "Usando la base de datos: " + databaseName;

                    // Habilita el botón para mostrar las tablas después de la conexión exitosa
                    showTablesButton.setEnabled(true);

                } catch (SQLException ex) {
                    // Si hay un error en la conexión, muestra un mensaje de error
                    message = "Error al conectar a la base de datos: " + ex.getMessage();
                    // Deshabilita el botón para mostrar las tablas en caso de error
                    showTablesButton.setEnabled(false);
                }

                // Muestra el mensaje usando JOptionPane
                JOptionPane.showMessageDialog(frame, message);
            }
        });

        // Acción del botón para mostrar las tablas
        showTablesButton.setEnabled(false);
        showTablesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	
            	
            	
                // Conectar a la base de datos y obtener información sobre las tablas
                DefaultTableModel tableModel = new DefaultTableModel();
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + textField.getText(), "root", "12345");
                    DatabaseMetaData metaData = connection.getMetaData();
                    ResultSet resultSet = metaData.getTables(null, null, null, new String[]{"TABLE"});
                    while (resultSet.next()) {
                        String tableName = resultSet.getString("TABLE_NAME");
                        tableModel.addRow(new Object[]{tableName});
                    }
                    // Cerrar la conexión después de obtener la información de las tablas
                    resultSet.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                // Crear el JTable y mostrar las tablas
                JTable table = new JTable(tableModel);
                JFrame tableFrame = new JFrame("Tablas de la Base de Datos");
                tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                tableFrame.getContentPane().add(new JScrollPane(table));
                tableFrame.pack();
                tableFrame.setVisible(true);
            }
        });

        panel.add(textField, BorderLayout.NORTH);
        panel.add(connectButton, BorderLayout.CENTER);
        panel.add(showTablesButton, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
