package Model.Dao;

import Model.Entities.Pedidos;
import Model.MotorSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidosDao implements IDao<Pedidos, Integer> {

    private final String SQL_ADD = "INSERT INTO Pedidos (ID_Pedido, Estado, ID_Cliente, ID_Trabajador) VALUES (PEDIDOS_SEQ1.nextval, ?, ?, ?)";

    @Override
    public ArrayList<Pedidos> findAll(Pedidos objeto) {
        ArrayList<Pedidos> pedidos = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            motor.connect();
            ResultSet rs = motor.executeQuery("SELECT Estado FROM Pedidos");

            while (rs.next()) {
                Pedidos pedido = new Pedidos();
                pedido.setIdPedido(rs.getString("ID_Pedido"));
                pedido.setEstado(rs.getString("Estado"));
                pedido.setIdCliente(rs.getInt("ID_Cliente"));
                pedido.setIdTrabajador(rs.getInt("ID_Trabajador"));
                pedidos.add(pedido);
            }
        } catch (Exception exception) {
            pedidos.clear();
        } finally {
            motor.disconnect();
        }
        return pedidos;
    }

    @Override
    public int add(Pedidos pedidoAnadir) throws SQLException {
        MotorSQL motor = new MotorSQL();
        int iFilasAnadidas = 0;
        motor.connect();
        PreparedStatement ps = motor.getPreparedStatement(SQL_ADD);
        ps.setString(1, pedidoAnadir.getEstado());
        ps.setInt(2, pedidoAnadir.getIdCliente());
        ps.setInt(3, pedidoAnadir.getIdTrabajador());

        iFilasAnadidas = ps.executeUpdate();
        return iFilasAnadidas;
    }

    @Override
    public int update(Pedidos pedidoActualizar) {
        MotorSQL motor = new MotorSQL();
        int iFilasActualizadas = 0;
        try {
            motor.connect();
            PreparedStatement ps = motor.getPreparedStatement("UPDATE Pedidos SET Estado = ?, ID_Cliente = ?, ID_Trabajador = ? WHERE ID_Pedido = ?");
            ps.setString(1, pedidoActualizar.getEstado());
            ps.setInt(2, pedidoActualizar.getIdCliente());
            ps.setInt(3, pedidoActualizar.getIdTrabajador());
            ps.setString(4, pedidoActualizar.getIdPedido());

            iFilasActualizadas = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            motor.disconnect();
        }
        return iFilasActualizadas;
    }

    @Override
    public int delete(Integer id) {
        MotorSQL motor = new MotorSQL();
        int iNumeroEliminaciones = 0;
        try {
            motor.connect();
            PreparedStatement ps = motor.getPreparedStatement("DELETE FROM Pedidos WHERE ID_Pedido = ?");
            ps.setInt(1, id);
            iNumeroEliminaciones = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            motor.disconnect();
        }
        return iNumeroEliminaciones;
    }
}
