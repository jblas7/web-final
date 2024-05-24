package Model.Dao;

import Model.Entities.Cliente;
import Model.MotorSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDao implements IDao<Cliente, Integer> {

    private final String SQL_FIND_ALL = "SELECT * FROM Cliente";
    private final String SQL_INSERT = "INSERT INTO Cliente (ID_Cliente, Nombre, Apellido, Telefono, Email, Contrasena) VALUES (?, ?, ?, ?, ?, ?)";
    private final String SQL_LOGIN = "SELECT * FROM Cliente WHERE Email = ? AND Contrasena = ?";

    @Override
    public int add(Cliente cliente) {
        MotorSQL motor = new MotorSQL();
        int iFilasAnadidas = 0;
        try {
            motor.connect();
            PreparedStatement ps = motor.getPreparedStatement(SQL_INSERT);
            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getEmail());
            ps.setString(6, cliente.getContrasena());

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
    public int delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int update(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Cliente> findAll(Cliente objeto) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            motor.connect();
            ResultSet rs = motor.executeQuery(SQL_FIND_ALL);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("ID_Cliente"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellido(rs.getString("Apellido"));
                cliente.setTelefono(rs.getString("Telefono"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setContrasena(rs.getString("Contrasena"));

                clientes.add(cliente);
            }
        } catch (Exception exception){
            clientes.clear();
        } finally{
            motor.disconnect();
        }

        return clientes;
    }

    public Cliente login(String email, String contrasena){
        MotorSQL motor = new MotorSQL();
        Cliente cliente = null;
        try {
            motor.connect();
            PreparedStatement ps = motor.getPreparedStatement(SQL_LOGIN);
            ps.setString(1, email);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("ID_Cliente"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellido(rs.getString("Apellido"));
                cliente.setTelefono(rs.getString("Telefono"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setContrasena(rs.getString("Contrasena"));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            motor.disconnect();
        }
        return cliente;
    }
}
