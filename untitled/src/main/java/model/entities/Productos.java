package model.entities;

/*    EJEMPLO DE ALBERO AKKARI PARA USAR DE REFERENCIA, ELIMINAR CUANDO LOS DATOS SE PUEDAN MANEJAR CORRECTAMENTE    */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class Productos {

    // Creamos los atributos del objeto cliente, que hace referencia a las columnas de la Tabla PRODUCTOS.
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String urlImagen;
    private String idCategoria; /*FK hace referencia a la tabla CATEGORIA */

    // Constructor con todos los campos de los atributos anteriores
    public Productos(Integer idProducto, String nombre, String descripcion, Double precio, String urlImagen, String idCategoria) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.urlImagen = urlImagen;
        this.idCategoria = idCategoria;
    }

    // Constructor vacío de los atributos anteriores
    public Productos() {
    }

    // Getters y setters de los atributos de la clase Productos.
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", urlImagen='" + urlImagen + '\'' +
                ", idCategoria='" + idCategoria + '\'' +
                '}';
    }

    public static String toJSon(ArrayList<Productos> productos) { //  conversor para la ddbb a json para el JS
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting(); /* Da formato automatico sin tener que definir el formato del resp a mano */
        Gson gson = builder.create();
        return gson.toJson(productos);
    }
}