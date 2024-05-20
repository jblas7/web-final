package Model.Dao;


import Model.Entities.Pedidos;
import Model.MotorSQL;
import Model.Dao.IDao;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PedidosDao implements IDao<Pedidos,Integer> {

    private final String SQL_FIND_ALL = "SELECT * FROM CATEGORIA WHERE 1=1";
    //Preguntar a Antón
    @Override
    public int add(Pedidos pedidos) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(Integer e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int update(Pedidos pedidos) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Pedidos> findAll(Pedidos objeto) {
        ArrayList<Pedidos> pedido = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            //Esto es para conectarnos a la bbdd
            motor.connect();

            //EJECUTAR LA SENTENCIA/CONSULTA/QUERY
            ResultSet rs = motor.executeQuery(SQL_FIND_ALL);

            //Mientras haya resultados se ejecuta el while
            while (rs.next()) {
                Pedidos pedidos = new Pedidos();
                pedidos.setIdPedidos(rs.getInt("ID_Pedido"));
                pedidos.setFecha(rs.getDate("Fecha"));
                pedidos.setEstado(rs.getString("Estado"));
                pedidos.setDireccion(rs.getString("Direccion"));
                pedidos.setIdCliente(rs.getInt("ID_Cliente"));
                pedidos.setIdTrabajador(rs.getInt("ID_Trabajador"));
                pedido.add(pedidos);
            }
        }
        catch (Exception exception) {
            pedido.clear();
        }
        finally {
            motor.disconnect();
        }

        return pedido;
    }
}
