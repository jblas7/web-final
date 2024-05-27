package Model.Dao;

import Model.Entities.Categoria;
import model.entities.Pedidos;
import Model.MotorSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidosDao implements IDao<Pedidos,Integer> {

    private final String SQL_ADD_ENTREGA_CASA = "INSERT INTO Pedidos (ID_Pedido, Hora, Estado, Direccion, ID_Cliente, ID_Trabajador) VALUES (?, ?, ?, ?, ?, ?)";
    private final String SQL_ADD_RECOGIDA_LOCAL = "INSERT INTO Pedidos (ID_Pedido, Hora, Estado, Nombre) VALUES (?, ?, ?, ?)";

    @Override
    public ArrayList<Pedidos> findAll(Pedidos objeto) {
        ArrayList <Pedidos> pedidos = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            //Esto es para conectarnos a la bbdd
            motor.connect();

            //EJECUTAR LA SENTENCIA/CONSULTA/QUERY
            ResultSet rs = motor.executeQuery("SELECT * FROM PEDIDOS");

            //Mientras haya resultados se ejecuta el while
            while (rs.next()){
                Pedidos pedido = new Pedidos();
                pedido.setIdPedidos(rs.getInt("ID_Pedido"));
                pedido.setHora(rs.getString("hora"));
                pedido.setEstado(rs.getString("estado"));
                pedido.setDireccion(rs.getString("direccion"));
                pedido.setIdCliente(rs.getInt("idCliente"));
                pedido.setIdTrabajador(rs.getInt("idTrabajador"));
                pedidos.add(pedido);
            }
        }
        catch (Exception exception) {
            pedidos.clear();
        }
        finally {
            motor.disconnect();
        }
        return pedidos;
    }


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

    //Esto lo quitaria
    /*public int addRecogidaLocal(Pedidos pedido) {
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
    }*/


}
