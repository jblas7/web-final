package Model.Dao;

import Model.Entities.Cliente;
import Model.MotorSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDao implements IDao<Cliente, Integer> {

    private final String SQL_ADD = "INSERT INTO Cliente (ID_Cliente, Nombre, Apellido, Telefono, Email, Contrasena, Calle, Portal, Piso, Letra) VALUES (CLIENTE_SEQ1.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public ArrayList<Cliente> findAll(Cliente objeto) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            motor.connect();
            ResultSet rs = motor.executeQuery("SELECT * FROM Cliente");
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("ID_Cliente"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellido(rs.getString("Apellido"));
                cliente.setTelefono(rs.getString("Telefono"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setContrasena(rs.getString("Contrasena"));
                cliente.setCalle(rs.getString("Calle"));
                cliente.setPortal(rs.getString("Portal"));
                cliente.setPiso(rs.getString("Piso"));
                cliente.setLetra(rs.getString("Letra"));
                clientes.add(cliente);
            }
        } catch (Exception exception) {
            clientes.clear();
        } finally {
            motor.disconnect();
        }
        return clientes;
    }

    @Override
    public int add(Cliente cliente) {
        MotorSQL motor = new MotorSQL();
        int iFilasAnadidas = 0;
        try {
            motor.connect();
            PreparedStatement ps = motor.getPreparedStatement(SQL_ADD);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getContrasena());
            ps.setString(6, cliente.getCalle());
            ps.setString(7, cliente.getPortal());
            ps.setString(8, cliente.getPiso());
            ps.setString(9, cliente.getLetra());

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
    public int update(Cliente cliente) {
        MotorSQL motor = new MotorSQL();
        int iFilasActualizadas = 0;
        try {
            motor.connect();
            PreparedStatement ps = motor.getPreparedStatement("UPDATE Cliente SET Nombre = ?, Apellido = ?, Telefono = ?, Email = ?, Contrasena = ?, Calle = ?, Portal = ?, Piso = ?, Letra = ? WHERE ID_Cliente = ?");
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getContrasena());
            ps.setString(6, cliente.getCalle());
            ps.setString(7, cliente.getPortal());
            ps.setString(8, cliente.getPiso());
            ps.setString(9, cliente.getLetra());
            ps.setInt(10, cliente.getIdCliente());

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
    public int delete(Integer idCliente) {
        MotorSQL motor = new MotorSQL();
        int iFilasBorradas = 0;
        try {
            motor.connect();
            PreparedStatement ps = motor.getPreparedStatement("DELETE FROM Cliente WHERE ID_Cliente = ?");
            ps.setInt(1, idCliente);
            iFilasBorradas = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            motor.disconnect();
        }
        return iFilasBorradas;
    }

    public Cliente login(String email, String contrasena) {
        MotorSQL motor = new MotorSQL();
        Cliente cliente = null;
        try {
            motor.connect();
            String sql = "SELECT * FROM Cliente WHERE Email = ? AND Contrasena = ?";
            PreparedStatement ps = motor.getPreparedStatement(sql);
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
                cliente.setCalle(rs.getString("Calle"));
                cliente.setPortal(rs.getString("Portal"));
                cliente.setPiso(rs.getString("Piso"));
                cliente.setLetra(rs.getString("Letra"));
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
