package main.java.Model.Entities;

public class DetallePedido {

    //Creamos los atributos del Objeto cliente, que hace referencia a las columnas de la Tabla DETALLES PEDIDO.
    private Integer idDetallePedido;

    private Integer cantidad;

    private Integer idpedidos; /*FK hace referencia a la Tabla Pedido */

    private Integer idProducto; /*FK hace referencia a la tabla Productos */


    //Crearemos el constructor con todos los campos de los atributos anteriores
    public DetallePedido(Integer idDetallePedido, Integer cantidad, Integer idpedidos, Integer idProducto) {
        this.idDetallePedido = idDetallePedido;
        this.cantidad = cantidad;
        this.idpedidos = idpedidos;
        this.idProducto = idProducto;
    }


    //Crearemos el constructor vacio de los atributos anteriores
    public DetallePedido(Integer cantidad) {
        this.cantidad = cantidad;
    }

    //Crear los Getter y setter de los atributos de la clase DetallesPedidoBean.
    public Integer getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Integer idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdpedidos() {
        return idpedidos;
    }

    public void setIdpedidos(Integer idpedidos) {
        this.idpedidos = idpedidos;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }


    //Crearemos en método to String del objeto DetallePedido
    @Override
    public String toString() {
        return "DetallePedido{" + "idDetallePedido=" + idDetallePedido + ", cantidad=" + cantidad + ", idpedidos=" + idpedidos + ", idProducto=" + idProducto + '}';
    }


    //Falta añadir el método Json en la clase.





}
