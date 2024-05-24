package Model.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Productos {

    //Creamos los atributos del Objeto cliente, que hace referencia a las columnas de la Tabla PRODUCTOS.
    private Integer idProducto;

    private String nombre;

    private String descripcion;

    private Double precio;

    private String rutaImagen;

    private Integer idCategoria; /*FK hace referencia a la tabla CATEGORIA */


    //Crearemos el constructor con todos los campos de los atributos anteriores
    public Productos(Integer idProducto, String nombre, String descripcion, Double precio, String rutaImagen, Integer idCategoria) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
        this.idCategoria = idCategoria;
    }

    //Crearemos el constructor vacio de los atributos anteriores
    public Productos() {
    }


    //Crear los Getter y setter de los atributos de la clase ProductosSBean.
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

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }




    //Crear el metodo ToSting del objeto Cliente
    @Override
    public String toString() {
        return "Productos{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", rutaImagen='" + rutaImagen + '\'' +
                ", idCategoria='" + idCategoria + '\'' +
                '}';
    }

    //Creamos el método Json para pasar el arrayList a Json
    public static String toArrayJson(ArrayList<Productos> Productos) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        return gson.toJson(Productos);
    }


}
