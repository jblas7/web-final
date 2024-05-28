package Model.Entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class Pedidos {
    private String idPedido;
    private String tipoPedido;
    private String modoEntrega;
    private String horaEntrega;
    private String shop;
    private String modoRecoger;
    private String horaRecoger;
    private String estado;
    private Integer idCliente;
    private Integer idTrabajador;

    // Constructor para pedidos
    public Pedidos(String idPedido, String tipoPedido, String modoEntrega, String horaEntrega, String shop, String modoRecoger, String horaRecoger, String estado, Integer idCliente, Integer idTrabajador) {
        this.idPedido = idPedido;
        this.tipoPedido = tipoPedido;
        this.modoEntrega = modoEntrega;
        this.horaEntrega = horaEntrega;
        this.shop = shop;
        this.modoRecoger = modoRecoger;
        this.horaRecoger = horaRecoger;
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

    // ArrayList de Pedidos a JSON
    public static String toArrayJson(ArrayList<Pedidos> pedidosArray) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson.toJson(pedidosArray);
    }
}
