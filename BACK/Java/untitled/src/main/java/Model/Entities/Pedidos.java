package Model.Entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class Pedidos {
    private String idPedido;
    private String estado;
    private Integer idCliente;
    private Integer idTrabajador;

    // Constructor para pedidos
    public Pedidos(String idPedido, String estado, Integer idCliente, Integer idTrabajador) {
        this.idPedido = idPedido;
        this.estado = estado;
        this.idCliente = idCliente;
        this.idTrabajador = idTrabajador;
    }

    // Constructor vacio
    public Pedidos() {
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
                "idPedido='" + idPedido + '\'' +
                ", estado='" + estado + '\'' +
                ", idCliente=" + idCliente +
                ", idTrabajador=" + idTrabajador +
                '}';
    }

    // ArrayList de Pedidos a JSON
    public static String toArrayJson(ArrayList<Pedidos> pedidosArray) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson.toJson(pedidosArray);
    }
}
