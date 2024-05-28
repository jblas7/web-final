package Model.Dao;

import Model.Entities.Pedidos;
import Model.MotorSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidosDao implements IDao<Pedidos, Integer> {

    private final String SQL_ADD = "INSERT INTO Pedidos (ID_Pedido, Tipo_Pedido, Modo_Entrega, Hora_Entrega, Estado, Direccion, Shop, Modo_Recoger, Hora_Recoger, ID_Cliente, ID_Trabajador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
    public int add(Pedidos pedido) {
        MotorSQL motor = new MotorSQL();
        int iFilasAnadidas = 0;
        try {
            motor.connect();
            PreparedStatement ps = motor.getPreparedStatement(SQL_ADD);
            ps.setInt(1, pedido.getIdPedido());
            ps.setString(2, pedido.getTipoPedido());
            ps.setString(3, pedido.getModoEntrega());
            ps.setString(4, pedido.getHoraEntrega());
            ps.setString(5, pedido.getEstado());
            ps.setString(6, pedido.getShop());
            ps.setString(7, pedido.getModoRecoger());
            ps.setString(8, pedido.getHoraRecoger());
            ps.setInt(9, pedido.getIdCliente());
            ps.setInt(10, pedido.getIdTrabajador());

            iFilasAnadidas = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            motor.disconnect();
        }
        return iFilasAnadidas;
    }
    @Override
    public int update(Pedidos pedido) {
        MotorSQL motor = new MotorSQL();
        int iFilasActualizadas = 0;
        try {
            motor.connect();
            PreparedStatement ps = motor.getPreparedStatement("UPDATE Pedidos SET Tipo_Pedido = ?, Modo_Entrega = ?, Hora_Entrega = ?, Estado = ?, Direccion = ?, Shop = ?, Modo_Recoger = ?, Hora_Recoger = ?, ID_Cliente = ?, ID_Trabajador = ? WHERE ID_Pedido = ?");
            ps.setString(1, pedido.getTipoPedido());
            ps.setString(2, pedido.getModoEntrega());
            ps.setString(3, pedido.getHoraEntrega());
            ps.setString(4, pedido.getEstado());
            ps.setString(5, pedido.getShop());
            ps.setString(6, pedido.getModoRecoger());
            ps.setString(7, pedido.getHoraRecoger());
            ps.setInt(8, pedido.getIdCliente());
            ps.setInt(9, pedido.getIdTrabajador());
            ps.setInt(10, pedido.getIdPedido());

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
