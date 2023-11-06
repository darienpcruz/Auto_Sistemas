import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class Bases_de_datos extends JFrame implements ActionListener {

    private JComboBox<String> databasesDropdown;
    private JPanel tablesPanel;
    private Connection connection;

    public Bases_de_datos() {
        // Establecer la conexión a la base de datos
        try {
            String url = "jdbc:mysql://localhost:3306"; // Cambia esto con tu URL de la base de datos
            String user = "root";
            String password = "12345";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Crear el marco principal
        JFrame frame01 = new JFrame("Interfaz");
        frame01.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Obtener el tamaño de la pantalla y establecer el tamaño y la posición del marco
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = 1000;
        int frameHeight = 700;
        frame01.setSize(frameWidth, frameHeight);
        frame01.setLocation((screenWidth - frameWidth) / 2, (screenHeight - frameHeight) / 2);

        // Crear el panel izquierdo con un botón para crear bases de datos
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(new Color(173, 216, 230));
        panelIzquierdo.setPreferredSize(new Dimension(frameWidth / 2, frameHeight));
        JButton createDBButton = new JButton("Crear Base de Datos");
        panelIzquierdo.add(createDBButton);
        createDBButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para crear una nueva base de datos
                // ...
            }
        });

        // Lista desplegable para mostrar bases de datos existentes
        databasesDropdown = new JComboBox<>();
        updateDatabaseDropdown();
        panelIzquierdo.add(databasesDropdown);
        databasesDropdown.addActionListener(this); // Asociar el ActionListener a la lista desplegable

        // Crear el panel derecho para mostrar las tablas
        tablesPanel = new JPanel();
        tablesPanel.setBackground(new Color(255, 255, 255));
        tablesPanel.setPreferredSize(new Dimension(frameWidth / 2, frameHeight));

        // Agregar los componentes al marco
        frame01.setLayout(new GridLayout(1, 2));
        frame01.add(panelIzquierdo);
        frame01.add(tablesPanel);
        frame01.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String selectedDatabase = (String) databasesDropdown.getSelectedItem();
        if (selectedDatabase != null) {
            loadTables(selectedDatabase); // Cargar y mostrar las tablas de la base de datos seleccionada
        }
    }

    private void loadTables(String selectedDatabase) {
        // Lógica para cargar las tablas de la base de datos seleccionada
        // ...
        // Debes implementar esta lógica para cargar las tablas
    }

    private void updateDatabaseDropdown() {
        databasesDropdown.removeAllItems();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SHOW DATABASES");
            while (resultSet.next()) {
                databasesDropdown.addItem(resultSet.getString(1));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Bases_de_datos();
    }
}

