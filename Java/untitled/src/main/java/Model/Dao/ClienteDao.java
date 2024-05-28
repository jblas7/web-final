package Model.Dao;

import Model.Entities.Cliente;
import Model.MotorSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDao implements IDao<Cliente, Integer> {

    @Override
    public ArrayList<Cliente> findAll(Cliente objeto) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            motor.connect();
            String sql = "SELECT * FROM Cliente";
            ResultSet rs = motor.executeQuery(sql);
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

    @Override
    public int add(Cliente cliente) {
        MotorSQL motor = new MotorSQL();
        int iFilasAnadidas = 0;
        try {
            motor.connect();

            // Generar un ID único
            int nextId = generateUniqueClientId();

            // Verificar si se generó correctamente el ID único
            if (nextId != -1) {
                cliente.setIdCliente(nextId);

                String sql = "INSERT INTO Cliente (ID_Cliente, Nombre, Apellido, Telefono, Email, Contrasena) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = motor.getPreparedStatement(sql);
                ps.setInt(1, cliente.getIdCliente());
                ps.setString(2, cliente.getNombre());
                ps.setString(3, cliente.getApellido());
                ps.setString(4, cliente.getTelefono());
                ps.setString(5, cliente.getEmail());
                ps.setString(6, cliente.getContrasena());

                iFilasAnadidas = ps.executeUpdate();
                ps.close();
            } else {
                // No se pudo generar un ID único
                System.err.println("No se pudo generar un ID único para el cliente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            motor.disconnect();
        }
        return iFilasAnadidas;
    }

    private int generateUniqueClientId() {
        // Aquí puedes implementar la lógica para generar un ID único, por ejemplo, basado en la fecha y hora actual,
        // o utilizando una estrategia de generación de IDs como UUID.
        // Por ejemplo:
        int id = -1; // Valor por defecto si la generación falla
        try {
            // Ejemplo de generación de ID basado en la fecha y hora actual
            // Aquí puedes implementar tu lógica específica para generar el ID único
            // Por ejemplo, podrías usar un contador atómico, un UUID o cualquier otra estrategia de generación de IDs.

            // En este ejemplo, se genera un ID basado en la fecha y hora actual
            long timestamp = System.currentTimeMillis();
            id = (int) timestamp; // Puedes ajustar esta lógica según tus necesidades
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }


    @Override
    public int update(Cliente cliente) {
        MotorSQL motor = new MotorSQL();
        int iFilasActualizadas = 0;
        try {
            motor.connect();
            StringBuilder sql = new StringBuilder("UPDATE Cliente SET ");
            ArrayList<Object> params = new ArrayList<>();

            if (cliente.getNombre() != null) {
                sql.append("Nombre = ?, ");
                params.add(cliente.getNombre());
            }
            if (cliente.getApellido() != null) {
                sql.append("Apellido = ?, ");
                params.add(cliente.getApellido());
            }
            if (cliente.getTelefono() != null) {
                sql.append("Telefono = ?, ");
                params.add(cliente.getTelefono());
            }
            if (cliente.getEmail() != null) {
                sql.append("Email = ?, ");
                params.add(cliente.getEmail());
            }
            if (cliente.getContrasena() != null) {
                sql.append("Contrasena = ?, ");
                params.add(cliente.getContrasena());
            }

            if (params.size() > 0) {
                sql.setLength(sql.length() - 2);
                sql.append(" WHERE ID_Cliente = ?");
                params.add(cliente.getIdCliente());

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
    public int delete(Integer idCliente) {
        MotorSQL motor = new MotorSQL();
        int iFilasBorradas = 0;
        try {
            motor.connect();
            String sql = "DELETE from CLIENTE where ID_CLIENTE = ?";
            PreparedStatement ps = motor.getPreparedStatement(sql);
            ps.setInt(1, idCliente);

            iFilasBorradas = ps.executeUpdate();
            ps.close();

        } catch (Exception e){
            System.out.println(e.getMessage());
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
