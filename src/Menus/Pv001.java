package Menus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Pv001 {

    private static final String URL = "jdbc:mysql://localhost:3306/kike";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";
    private static DatabaseManager databaseManager;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ver Tablas");
        JButton verTablasButton = new JButton("Ver Tablas");
        JButton agregarRegistroButton = new JButton("Agregar Registro");

        databaseManager = new DatabaseManager();

        verTablasButton.addActionListener(e -> databaseManager.mostrarTablas());
        agregarRegistroButton.addActionListener(e -> databaseManager.agregarRegistro());

        JPanel panel = new JPanel();
        panel.add(verTablasButton);
        panel.add(agregarRegistroButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }

    private static class DatabaseManager {
        private DefaultTableModel model;
        private JTable table;

        public void mostrarTablas() {
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SHOW TABLES");

                model = new DefaultTableModel();
                table = new JTable(model);

                while (resultSet.next()) {
                    String tableName = resultSet.getString(1);
                    model.addColumn(tableName);
                }

                JOptionPane.showMessageDialog(null, new JScrollPane(table), "Tablas de la Base de Datos", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al mostrar las tablas: " + e.getMessage());
            }
        }

        public void agregarRegistro() {
        	 if (table != null && table.getSelectedColumn() != -1) {
        	        String tableName = model.getColumnName(table.getSelectedColumn());

        	        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        	            Statement statement = connection.createStatement();
        	            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
        	            ResultSetMetaData metaData = resultSet.getMetaData();
        	            int columnCount = metaData.getColumnCount();

        	            StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " VALUES (");

        	            for (int i = 1; i <= columnCount; i++) {
        	                String columnName = metaData.getColumnName(i);
        	                String input = JOptionPane.showInputDialog("Ingrese valor para " + columnName);
        	                if (input != null && !input.isEmpty()) {
        	                    query.append("'").append(input.trim()).append("',");
        	                } else {
        	                    // Si el usuario no ingresa un valor, se inserta NULL en la base de datos
        	                    query.append("NULL,");
        	                }
        	            }

        	            query.setLength(query.length() - 1); // Elimina la última coma
        	            query.append(")");

        	            statement.executeUpdate(query.toString());
        	            JOptionPane.showMessageDialog(null, "Registro agregado correctamente.");

        	        } catch (Exception e) {
        	            e.printStackTrace();
        	            JOptionPane.showMessageDialog(null, "Error al agregar el registro: " + e.getMessage());
        	        }
        	    } else {
        	        JOptionPane.showMessageDialog(null, "Por favor, seleccione una tabla antes de agregar un registro.");
        	    }
        	}
        }
    }








