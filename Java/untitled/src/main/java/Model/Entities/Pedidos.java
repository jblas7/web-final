package Model.Entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Pedidos {
    private Integer idPedido; // Changed from idPedidos to idPedido
    private String tipoPedido; // New field for Tipo_Pedido
    private String modoEntrega; // New field for Modo_Entrega
    private String horaEntrega; // New field for Hora_Entrega
    private String shop; // New field for Shop
    private String modoRecoger; // New field for Modo_Recoger
    private String horaRecoger; // New field for Hora_Recoger
    private String estado;
    private Integer idCliente;
    private Integer idTrabajador;

    // Constructor for delivery orders
    public Pedidos(Integer idPedido, String tipoPedido, String modoEntrega, String horaEntrega, String estado, String shop, Integer idCliente, Integer idTrabajador) {
        this.idPedido = idPedido;
        this.tipoPedido = tipoPedido;
        this.modoEntrega = modoEntrega;
        this.horaEntrega = horaEntrega;
        this.estado = estado;
        this.shop = shop;
        this.idCliente = idCliente;
        this.idTrabajador = idTrabajador;
    }



    // Default constructor
    public Pedidos() {
    }

    // Getters and Setters
    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getModoEntrega() {
        return modoEntrega;
    }

    public void setModoEntrega(String modoEntrega) {
        this.modoEntrega = modoEntrega;
    }

    public String getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getModoRecoger() {
        return modoRecoger;
    }

    public void setModoRecoger(String modoRecoger) {
        this.modoRecoger = modoRecoger;
    }

    public String getHoraRecoger() {
        return horaRecoger;
    }

    public void setHoraRecoger(String horaRecoger) {
        this.horaRecoger = horaRecoger;
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
                "idPedido=" + idPedido +
                ", tipoPedido='" + tipoPedido + '\'' +
                ", modoEntrega='" + modoEntrega + '\'' +
                ", horaEntrega='" + horaEntrega + '\'' +
                ", shop='" + shop + '\'' +
                ", modoRecoger='" + modoRecoger + '\'' +
                ", horaRecoger='" + horaRecoger + '\'' +
                ", estado='" + estado + '\'' +
                ", idCliente=" + idCliente +
                ", idTrabajador=" + idTrabajador +
                '}';
    }

    // Method to convert ArrayList of Pedidos to JSON
    public static String toArrayJson(ArrayList<Pedidos> pedidos) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        return gson.toJson(pedidos);
    }
}
