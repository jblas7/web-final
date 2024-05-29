package Model.Dao;

import Model.Entities.DetallePedido;
import Model.Entities.Trabajador;
import Model.MotorSQL;
import Model.Dao.IDao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetallePedidoDao implements IDao<DetallePedido,Integer> {

        @Override
        public ArrayList<DetallePedido> findAll(DetallePedido objeto) {
            ArrayList <DetallePedido> detallesPedidos = new ArrayList<>();
            MotorSQL motor = new MotorSQL();
            try {
                //Esto es para conectarnos a la bbdd
                motor.connect();
                String sql = "SELECT * FROM CATEGORIA WHERE 1=1";

                //EJECUTAR LA SENTENCIA/CONSULTA/QUERY
                ResultSet rs = motor.executeQuery(sql);

                //Mientras haya resultados se ejecuta el while
                while (rs.next()){
                    DetallePedido detallePedido = new DetallePedido();
                    detallePedido.setIdDetallePedido(rs.getInt("ID_Detalle"));
                    detallePedido.setCantidad(rs.getInt("Cantidad"));
                    detallePedido.setIdpedidos(rs.getInt("ID_Pedido"));
                    detallePedido.setIdProducto(rs.getInt("ID_Producto"));
                    detallesPedidos.add(detallePedido);
                }
            }
            catch (Exception exception) {
                    detallesPedidos.clear();
            }

            finally {
                motor.disconnect();
            }

            return detallesPedidos;
        }


    @Override
    public int add(DetallePedido detallePedidos) {
        MotorSQL motor = new MotorSQL();
        int iFilasAnadidas = 0;
        try {
            motor.connect();
            String sql ="insert into DETALLE_PEDIDO (ID_DETALLE,CANTIDAD,ID_PEDIDO,ID_PRODUCTO) values (?,?,?,?)";
            PreparedStatement ps = motor.getPreparedStatement(sql);
            ps.setInt(1,detallePedidos.getIdDetallePedido());
            ps.setInt(2, detallePedidos.getCantidad());
            ps.setInt(3,detallePedidos.getIdpedidos());
            ps.setInt(4,detallePedidos.getIdProducto());

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
    public int update(DetallePedido detallePedidos) {
        MotorSQL motor = new MotorSQL();
        int iFilasActualizadas = 0;
        try {
            motor.connect();
            StringBuilder sql = new StringBuilder("UPDATE DETALLE_PEDIDO SET ");
            ArrayList<Object> params = new ArrayList<>();

            if (detallePedidos.getIdDetallePedido() != null) {
                sql.append("ID_DETALLE = ?, ");
                params.add(detallePedidos.getIdDetallePedido());
            }
            if (detallePedidos.getCantidad() != null) {
                sql.append("CANTIDAD = ?, ");
                params.add(detallePedidos.getCantidad());
            }
            if (detallePedidos.getIdpedidos() != null) {
                sql.append("ID_PEDIDO = ?, ");
                params.add(detallePedidos.getIdpedidos());
            }
            if (detallePedidos.getIdProducto() != null) {
                sql.append("ID_PRODUCTO = ?, ");
                params.add(detallePedidos.getIdProducto());
            }

            if (params.size() > 0) {
                sql.setLength(sql.length() - 2);
                sql.append(" WHERE ID_DETALLE = ?");
                params.add(detallePedidos.getIdDetallePedido());

                PreparedStatement ps = motor.getPreparedStatement(sql.toString());
                for (int i = 0; i < params.size(); i++) {
                    ps.setObject(i + 1, params.get(i));
                }

                iFilasActualizadas = ps.executeUpdate();
                ps.close();
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            motor.disconnect();
        }
        return iFilasActualizadas;
    }


    @Override
    public int delete(Integer idDetallePedido) {
        MotorSQL motor = new MotorSQL();
        int iFilasBorradas = 0;

        String sql="DELETE FROM DETALLE_PEDIDO WHERE ID_DETALLE=?";
        try {
            PreparedStatement ps = motor.getPreparedStatement(sql);
            ps.setInt(1, idDetallePedido);
            iFilasBorradas = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return iFilasBorradas;
    }

}
