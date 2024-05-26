package model.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Pedidos {
    private Integer idPedidos;
    private String nombre;
    private String hora;
    private String estado;
    private String direccion;
    private Integer idCliente;
    private Integer idTrabajador;

    // Constructor para entrega a domicilio
    public Pedidos(Integer idPedidos, String hora, String estado, String direccion, Integer idCliente, Integer idTrabajador) {
        this.idPedidos = idPedidos;
        this.hora = hora;
        this.estado = estado;
        this.direccion = direccion;
        this.idCliente = idCliente;
        this.idTrabajador = idTrabajador;
    }

    // Constructor para recogida local
    public Pedidos(Integer idPedidos, String hora, String estado, String nombre) {
        this.idPedidos = idPedidos;
        this.hora = hora;
        this.estado = estado;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(Integer idPedidos) {
        this.idPedidos = idPedidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "idPedidos=" + idPedidos +
                ", nombre='" + nombre + '\'' +
                ", hora='" + hora + '\'' +
                ", estado='" + estado + '\'' +
                ", direccion='" + direccion + '\'' +
                ", idCliente=" + idCliente +
                ", idTrabajador=" + idTrabajador +
                '}';
    }

    // Metodo para convertir ArrayList de Pedidos a JSON
    public static String toArrayJson(ArrayList<Pedidos> pedidos) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        return gson.toJson(pedidos);
    }
}
