package Model.Dao;

import Model.Entities.Pedidos;
import Model.MotorSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidosDao implements IDao<Pedidos, Integer> {

    private final String SQL_ADD = "INSERT INTO Pedidos (ID_Pedido, Tipo_Pedido, Modo_Entrega, Hora_Entrega, Shop, Modo_Recoger, Hora_Recoger, Estado, ID_Cliente, ID_Trabajador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public ArrayList<Pedidos> findAll(Pedidos objeto) {
        ArrayList<Pedidos> pedidos = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            motor.connect();
            ResultSet rs = motor.executeQuery("SELECT * FROM Pedidos");

            while (rs.next()) {
                Pedidos pedido = new Pedidos();
                pedido.setIdPedido(rs.getInt("ID_Pedido"));
                pedido.setTipoPedido(rs.getString("Tipo_Pedido"));
                pedido.setModoEntrega(rs.getString("Modo_Entrega"));
                pedido.setHoraEntrega(rs.getString("Hora_Entrega"));
                pedido.setEstado(rs.getString("Estado"));
                pedido.setShop(rs.getString("Shop"));
                pedido.setModoRecoger(rs.getString("Modo_Recoger"));
                pedido.setHoraRecoger(rs.getString("Hora_Recoger"));
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
            ps.setInt(1, pedidoAnadir.getIdPedido());
            ps.setString(2, pedidoAnadir.getTipoPedido());
            ps.setString(3, pedidoAnadir.getModoEntrega());
            ps.setString(4, pedidoAnadir.getHoraEntrega());
            ps.setString(5, pedidoAnadir.getShop());
            ps.setString(6, pedidoAnadir.getModoEntrega());
            ps.setString(7, pedidoAnadir.getHoraRecoger());
            ps.setString(8, pedidoAnadir.getEstado());
            ps.setInt(9, pedidoAnadir.getIdCliente());
            ps.setInt(10, pedidoAnadir.getIdTrabajador());

            iFilasAnadidas = ps.executeUpdate();
        return iFilasAnadidas;
    }
    @Override
    public int update(Pedidos pedidoActualizar) {
        MotorSQL motor = new MotorSQL();
        int iFilasActualizadas = 0;
        try {
            motor.connect();
            PreparedStatement ps = motor.getPreparedStatement("UPDATE Pedidos SET Tipo_Pedido = ?, Modo_Entrega = ?, Hora_Entrega = ?, Estado = ?, Direccion = ?, Shop = ?, Modo_Recoger = ?, Hora_Recoger = ?, ID_Cliente = ?, ID_Trabajador = ? WHERE ID_Pedido = ?");
            ps.setString(1, pedidoActualizar.getTipoPedido());
            ps.setString(2, pedidoActualizar.getModoEntrega());
            ps.setString(3, pedidoActualizar.getHoraEntrega());
            ps.setString(4, pedidoActualizar.getEstado());
            ps.setString(5, pedidoActualizar.getShop());
            ps.setString(6, pedidoActualizar.getModoRecoger());
            ps.setString(7, pedidoActualizar.getHoraRecoger());
            ps.setInt(8, pedidoActualizar.getIdCliente());
            ps.setInt(9, pedidoActualizar.getIdTrabajador());
            ps.setInt(10, pedidoActualizar.getIdPedido());

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
