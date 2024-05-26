package Model.Dao;

import Model.Entities.DetallePedido;
import Model.MotorSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetallePedidoDao implements IDao<DetallePedido, Integer> {

    private final String SQL_ADD = "INSERT INTO Detalle_Pedido (ID_Detalle, Cantidad, ID_Pedido, ID_Producto) VALUES (?, ?, ?, ?)";
    private final String SQL_FIND_ALL = "SELECT * FROM Detalle_Pedido WHERE 1=1";

    @Override
    public int add(DetallePedido detallePedido) {
        MotorSQL motor = new MotorSQL();
        int filasAnadidas = 0;
        try {
            motor.connect();
            PreparedStatement ps = motor.getPreparedStatement(SQL_ADD);
            ps.setInt(1, detallePedido.getIdDetallePedido());
            ps.setInt(2, detallePedido.getCantidad());
            ps.setInt(3, detallePedido.getIdpedidos());
            ps.setInt(4, detallePedido.getIdProducto());

            filasAnadidas = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            motor.disconnect();
        }
        return filasAnadidas;
    }

    @Override
    public int delete(Integer e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int update(DetallePedido detallePedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<DetallePedido> findAll(DetallePedido objeto) {
        ArrayList<DetallePedido> detallesPedidos = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            motor.connect();
            ResultSet rs = motor.executeQuery(SQL_FIND_ALL);
            while (rs.next()) {
                DetallePedido detallePedido = new DetallePedido();
                detallePedido.setIdDetallePedido(rs.getInt("ID_Detalle"));
                detallePedido.setCantidad(rs.getInt("Cantidad"));
                detallePedido.setIdpedidos(rs.getInt("ID_Pedido"));
                detallePedido.setIdProducto(rs.getInt("ID_Producto"));
                detallesPedidos.add(detallePedido);
            }
        } catch (Exception exception) {
            detallesPedidos.clear();
        } finally {
            motor.disconnect();
        }
        return detallesPedidos;
    }
}
