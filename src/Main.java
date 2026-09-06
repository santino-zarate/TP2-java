import javax.swing.*; // Importa los componentes gráficos de Swing para crear la ventana y sus controles.
import java.awt.*; // Importa clases de AWT para layouts y utilidades gráficas.

// La clase Main representa la ventana principal de la aplicación.
public class Main extends JFrame {

    // Campos de texto para ingresar los datos del producto.
    private JTextField txtNombre, txtPrecio, txtStock;
    // Botón que dispara la acción de registrar el producto.
    private JButton btnRegistrar;
    // Modificacion 3: Se agrega un boton para limpiar los campos de texto.
    private JButton btnLimpiar;
    // Área de texto donde se muestra la información del producto.
    private JTextArea txtResultado;

    // Constructor de la ventana principal.
    public Main() {
        setTitle("Sistema de Productos"); // Establece el título de la ventana.
        setSize(400, 400); // Define el ancho y alto de la ventana.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana.*/
        setLocationRelativeTo(null); // Centra la ventana en la pantalla.

        // Etiquetas para indicar qué dato ingresar en cada campo.
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblPrecio = new JLabel("Precio:");
        JLabel lblStock = new JLabel("Stock:");

        // Se crean los campos donde el usuario ingresa nombre, precio y stock.
        txtNombre = new JTextField();
        txtPrecio = new JTextField();
        txtStock = new JTextField();
        btnRegistrar = new JButton("Registrar"); // Botón para guardar el producto.
        btnRegistrar.setBackground(new Color(76, 175, 80)); // Modificacion 5: Cambio de color del boton registrar
        btnRegistrar.setForeground(Color.WHITE); // Modificacion 5: Cambio de color del texto registrar
        btnLimpiar = new JButton("Limpiar"); // Modificacion 3: Boton para limpiar 
        btnLimpiar.setBackground(new Color(76, 175, 80)); // Modificacion 5: Cambio de color del boton limpiar
        btnLimpiar.setForeground(Color.WHITE); // Modificacion 5: Cambio de color del texto limpiar
        txtResultado = new JTextArea(); // Área para mostrar resultados.
        txtResultado.setEditable(false); // Evita que el usuario modifique el resultado manualmente.

        // Define un diseño en cuadrícula con 5 filas y 2 columnas.
        setLayout(new GridLayout(5, 2, 10, 10));
        add(lblNombre); // Agrega la etiqueta de nombre.
        add(txtNombre); // Agrega el campo de texto del nombre.
        add(lblPrecio); // Agrega la etiqueta de precio.
        add(txtPrecio); // Agrega el campo de texto del precio.
        add(lblStock); // Agrega la etiqueta de stock.
        add(txtStock); // Agrega el campo de texto del stock.
        // Modificacion 3: Se agrego el boton de limpiar y usar el espacio de al lado de boton registrar
        add(btnRegistrar); // Agrega el botón registrar.
        add(btnLimpiar); // Agrega el botón limpiar
        add(new JLabel("Resultado:")); // Etiqueta para mostrar el resultado.
        add(new JScrollPane(txtResultado)); // Agrega un scroll para ver el contenido del texto.

        // Cuando se presiona el botón, ejecuta el método registrarProducto.
        btnRegistrar.addActionListener(e -> registrarProducto());
        btnLimpiar.addActionListener(e -> limpiarFormulario());
        setVisible(true); // Hace visible la ventana.
    }

    // Método que toma los datos ingresados y crea un objeto Producto.
    private void registrarProducto() {
        String nombre = txtNombre.getText(); // Obtiene el nombre escrito por el usuario.

        // Modificacion 1: Validacion de que los campos no este vacios
        if (nombre.isEmpty() || txtPrecio.getText().trim().isEmpty() || txtStock.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Modificacion 2: Validacion de que el precio y stock sean numeros
        try {
             double precio = Double.parseDouble(txtPrecio.getText());
             int stock = Integer.parseInt(txtStock.getText());

             Producto producto = new Producto(nombre, precio, stock);
             txtResultado.setText(producto.mostrarInformacion());
        }
        // Modificacion 3: Excepcion de valores numericos en stock y precio 
        catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Precio y Stock deben ser valores numéricos.", "Error de formato", JOptionPane.ERROR_MESSAGE);  
        } 
        // Modificacion 4: Excepcion de valores negativos en stock y precio
        catch (IllegalArgumentException ex) {
         JOptionPane.showMessageDialog(this, ex.getMessage(), "Datos inválidos", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Modificacion 3: Metodo para limpiar los campos de texto y el area de resultado
    private void limpiarFormulario() {
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        txtResultado.setText("");
        txtNombre.requestFocus();
}
    // Método principal que inicia la aplicación.
    public static void main(String[] args) {
        new Main(); // Crea una instancia de la ventana principal.
    }
}