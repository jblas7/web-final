package main.java.Model.Entities;

public class Categoria {

    //Creamos los atributos del Objeto cliente, que hace referencia a las columnas de la Tabla CATEGORIA.
    private Integer idCategoria;

    private String nombre;

    //Crearemos el constructor con todos los campos de los atributos anteriores
    public CategoriaBean(Integer idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }


    //Crearemos el constructor vacio de los atributos anteriores
    public CategoriaBean() {
    }

    //Crear los Getter y setter de los atributos de la claSE CategoriaBean.
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


    //Crear el metodo ToSting del objeto Cliente
    @Override
    public String toString() {
        return "Categoria{" + "idCategoria=" + idCategoria + ", nombre='" + nombre + '\'' + '}';
    }

    //Falta añadir el método Json en la clase.





}
