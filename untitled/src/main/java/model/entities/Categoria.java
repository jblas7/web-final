package Model.Entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Categoria {

    //Creamos los atributos del Objeto cliente, que hace referencia a las columnas de la Tabla CATEGORIA.
    private Integer idCategoria;

    private String nombre;


    //Crearemos el constructor con todos los campos de los atributos anteriores
    public Categoria (Integer idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }


    //Crearemos el constructor vacio de los atributos anteriores
    public Categoria() {
    }


    //Crear los Getter y setter de los atributos de la clase Categoria.
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    //Crear el metodo ToSting del objeto Categoria
    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", nombre='" + nombre + '\'' +
                '}';
    }


    //Creamos el método Json para pasar el arrayList a Json
    public static String toArrayJson(ArrayList<Categoria> Categoria) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        return gson.toJson(Categoria);
    }

}
