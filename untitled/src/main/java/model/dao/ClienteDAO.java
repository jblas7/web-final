/* Sin terminar*/

package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.entities.Cliente;
import model.factory.DatabaseFactory;
import model.motorsql.MotorSQL;

public class ClienteDAO implements DAO<Cliente, Integer> {

    private final String SQL_FINDALL = "SELECT * FROM cliente WHERE 1=1 ";
    private final String SQL_ADD = "INSERT INTO cliente (ID_Cliente, Nombre, Telefono, Email, Contrasena) VALUES (?, ?, ?, ?, ?)";
    private final String SQL_DELETE = "DELETE FROM cliente WHERE ID_Cliente=?";
    private final String SQL_UPDATE = "UPDATE cliente SET Nombre=?, Telefono=?, Email=?, Contrasena=? WHERE ID_Cliente=?";
    private MotorSQL motorSql;

    public ClienteDAO(String db) {
        motorSql = DatabaseFactory.getDatabase(db);
    }

    @Override
    public ArrayList<Cliente> findAll(Cliente bean) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = SQL_FINDALL;
        try {
            motorSql.connect();
            if (bean != null) {
                if (bean.getIdCliente() != 0) {
                    sql += "AND ID_Cliente='" + bean.getIdCliente() + "'";
                }
                if (bean.getNombre() != null) {
                    sql += "AND Nombre='" + bean.getNombre() + "'";
                }
                if (bean.getApellido() != null) {
                    sql += "AND Apellido='" + bean.getApellido() + "'";
                }
                if (bean.getTelefono() != null) {
                    sql += "AND Telefono='" + bean.getTelefono() + "'";
                }
                if (bean.getEmail() != null) {
                    sql += "AND Email='" + bean.getEmail() + "'";
                }
                if (bean.getContrasena() != null) {
                    sql += "AND Contrasena='" + bean.getContrasena() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("ID_Cliente"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setTelefono(rs.getString("Telefono"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setContrasena(rs.getString("Contrasena"));

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return clientes;
    }

    @Override
    public int add(Cliente bean) {
        int resp = 0;
        try {
            motorSql.connect();
            resp = motorSql.execute(SQL_ADD, bean.getIdCliente(), bean.getNombre(), bean.getTelefono(), bean.getEmail(), bean.getContrasena());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        if (resp > 0) {
            System.out.println("Cliente insertado con éxito.");
        }
        return resp;
    }

    @Override
    public int delete(Integer id) {
        int resp = 0;
        try {
            motorSql.connect();
            resp = motorSql.execute(SQL_DELETE, id);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        if (resp > 0) {
            System.out.println("Borrado con éxito.");
        } else {
            System.out.println("No se pudo borrar.");
        }
        return resp;
    }

    @Override
    public int update(Cliente bean) {
        int resp = 0;
        try {
            motorSql.connect();
            resp = motorSql.execute(SQL_UPDATE, bean.getNombre(), bean.getTelefono(), bean.getEmail(), bean.getContrasena(), bean.getIdCliente());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        if (resp > 0) {
            System.out.println("Cliente actualizado con éxito.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
        return resp;
    }
}