package Model.Dao;

import Model.Entities.Pedido;
import Model.Entities.Pedidos;
import Model.MotorSQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidosDao {

    private final String SQL_ADD = "INSERT INTO Pedidos (ID_Pedido, Hora, Estado, Direccion, ID_Cliente, ID_Trabajador) VALUES (?, ?, ?, ?, ?, ?)";

    public int add(Pedidos pedido) {
        MotorSQL motor = new MotorSQL();
        int iFilasAnadidas = 0;
        try {
            motor.connect();
            PreparedStatement ps = motor.getPreparedStatement(SQL_ADD);
            ps.setInt(1, pedido.getIdPedidos());
            ps.setString(2, pedido.getHora());
            ps.setString(3, pedido.getEstado());
            ps.setString(4, pedido.getDireccion());
            ps.setInt(5, pedido.getIdCliente());
            ps.setInt(6, pedido.getIdTrabajador());

            iFilasAnadidas = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            motor.disconnect();
        }
        return iFilasAnadidas;
    }

    // add para los pedidos q se lleven a casa
    public int entregacasa(Pedidos pedido) {
        return add(pedido);
    }
}
