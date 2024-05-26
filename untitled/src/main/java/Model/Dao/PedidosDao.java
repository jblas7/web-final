package Model.Dao;

import model.entities.Pedidos;
import Model.MotorSQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidosDao {

    private final String SQL_ADD_ENTREGA_CASA = "INSERT INTO Pedidos (ID_Pedido, Hora, Estado, Direccion, ID_Cliente, ID_Trabajador) VALUES (?, ?, ?, ?, ?, ?)";
    private final String SQL_ADD_RECOGIDA_LOCAL = "INSERT INTO Pedidos (ID_Pedido, Hora, Estado, Nombre) VALUES (?, ?, ?, ?)";

    public int add(Pedidos pedido) {
        MotorSQL motor = new MotorSQL();
        int iFilasAnadidas = 0;
        try {
            motor.connect();
            PreparedStatement ps = motor.getPreparedStatement(SQL_ADD_ENTREGA_CASA);
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

    public int addRecogidaLocal(Pedidos pedido) {
        MotorSQL motor = new MotorSQL();
        int iFilasAnadidas = 0;
        try {
            motor.connect();
            PreparedStatement ps = motor.getPreparedStatement(SQL_ADD_RECOGIDA_LOCAL);
            ps.setInt(1, pedido.getIdPedidos());
            ps.setString(2, pedido.getHora());
            ps.setString(3, pedido.getEstado());
            ps.setString(4, pedido.getNombre());

            iFilasAnadidas = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            motor.disconnect();
        }
        return iFilasAnadidas;
    }
}
