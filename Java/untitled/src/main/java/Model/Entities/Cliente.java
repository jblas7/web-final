package Model.Entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Cliente {

    //Creamos los atributos del Objeto cliente, que hace referencia a las columnas de la Tabla CLIENTE.
    private Integer idCliente;

    private String nombre;

    private String apellido;

    private String telefono;

    private String email;

    private String contrasena;

    private String calle;

    private String portal;

    private String piso;

    private String letra;

    //Crearemos el constructor con todos los campos de los atributos anteriores
    public Cliente(Integer idCliente, String nombre, String apellido, String telefono, String email, String contrasena,
                   String calle, String portal, String piso, String letra) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.contrasena = contrasena;
        this.calle = calle;
        this.portal = portal;
        this.piso = piso;
        this.letra = letra;
    }

    //Crearemos el constructor vacio de los atributos anteriores
    public Cliente() {
    }

    //Crear los Getter y setter de los atributos de la clase ClienteBean.
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    //Crear el metodo ToString del objeto Cliente
    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", calle='" + calle + '\'' +
                ", portal='" + portal + '\'' +
                ", piso='" + piso + '\'' +
                ", letra='" + letra + '\'' +
                '}';
    }

    //objeto del Cliente a formato JSON
    public String toJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

    // Lista de Clientes a JSON
    public static String toArrayJson(ArrayList<Cliente> clientes) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(clientes);
    }
}
