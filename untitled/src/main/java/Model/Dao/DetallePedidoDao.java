package Model.Dao;

import Model.Entities.DetallePedido;
import Model.MotorSQL;
import Model.Dao.IDao;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DetallePedidoDao implements IDao<DetallePedido,Integer> {

        private final String SQL_FIND_ALL = "SELECT * FROM CATEGORIA WHERE 1=1";

        @Override
        public int add(DetallePedido detallePedidos) {throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public int delete(Integer e) {throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public int update(DetallePedido detallePedidos) {throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public ArrayList<DetallePedido> findAll(DetallePedido objeto) {
            ArrayList <DetallePedido> detallesPedidos = new ArrayList<>();
            MotorSQL motor = new MotorSQL();
            try {
                //Esto es para conectarnos a la bbdd
                motor.connect();

                //EJECUTAR LA SENTENCIA/CONSULTA/QUERY
                ResultSet rs = motor.executeQuery(SQL_FIND_ALL);

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

}
