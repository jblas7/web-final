package main.java.Model.Entities;

import java.util.Date;

public class Pedidos {
    //Creamos los atributos del objeto pedidos, que hace referencia a las columnas de la Tabla PEDIDOS.
    private Integer idPedidos;

    private Date fecha;

    private String estado; /*3Estados */
    /*¿¿?? private Enum  state; /* 1- Pendiente, 2- En proceso, 3- Finalizado ¿??*/

    private String direccion;

    private Integer idCliente; /*FK de la tabla de Cliente */

    private Integer idTrabajador; /* FK de la tabla de Trabajador */


    //Crearemos el constructor con todos los campos de los atributos anteriores
    public Pedidos(Integer id_pedidos, Date fecha, String estado, String direccion, Integer idCliente, Integer idTrabajador) {
        this.idPedidos = id_pedidos;
        this.fecha = fecha;
        this.estado = estado;
        this.direccion = direccion;
        this.idCliente = idCliente;
        this.idTrabajador = idTrabajador;
    }

    //Crearemos el constructor vacio de los atributos anteriores
    public Pedidos() {
    }


    //Crear los Getter y setter de los atributos de la clase PedidosBean.
    public Integer getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(Integer idPedidos) {
        this.idPedidos = idPedidos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    //Crearemos en método to String del objeto Pedidos
    @Override
    public String toString() {
        return "Pedidos{" + "idPedidos=" + idPedidos + ", fecha=" + fecha + ", estado='" + estado + '\'' + ", direccion='" + direccion + '\'' + ", idCliente=" + idCliente + ", idTrabajador=" + idTrabajador + '}';
    }

    //Falta añadir el método Json en la clase.








}
