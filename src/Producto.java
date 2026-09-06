// La clase Producto representa un producto con sus atributos básicos.

public class Producto {
    // Atributos del producto: nombre, precio y stock.
    private String nombre;
    private double precio;
    private int stock;

    // Constructor: inicializa los valores del producto cuando se crea un objeto.
    public Producto(String nombre, double precio, int stock) {
        
        // Modificacion 4: Evitar que el precio y el stock sean negativos
        if (precio < 0) {
             throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        if (stock < 0) {
             throw new IllegalArgumentException("El stock no puede ser negativo.");
        }

        this.nombre = nombre; // Asigna el nombre recibido al atributo nombre.
        this.precio = precio; // Asigna el precio recibido al atributo precio.
        this.stock = stock; // Asigna el stock recibido al atributo stock.
    }

    // Método getter para obtener el nombre del producto.
    public String getNombre() {
        return nombre;
    }

    // Método getter para obtener el precio del producto.
    public double getPrecio() {
        return precio;
    }

    // Método getter para obtener la cantidad de stock del producto.
    public int getStock() {
        return stock;
    }

    // Método que devuelve una cadena con los datos del producto formateados.
    public String mostrarInformacion() {
        return "Producto: " + nombre +
               "\nPrecio: $" + precio +
               "\nStock: " + stock;
    }
}