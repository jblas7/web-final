package Model.Dao;

import Model.Entities.Cliente;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDao implements IDao<Cliente,Integer> {

        private final String SQL_FIND_ALL = "SELECT * FROM CLIENTE";

        @Override
        public int add(Cliente clientes) {throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public int delete(Integer e) {throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public int update(Cliente clientes) {throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public ArrayList<Cliente> findAll(Cliente objeto) {
            ArrayList <Cliente> clientes = new ArrayList<>();
            Model.MotorSQL motor = new Model.MotorSQL();
            try {
                //Esto es para conectarnos a la bbdd
                motor.connect();

                //EJECUTAR LA SENTENCIA/CONSULTA/QUERY
                ResultSet rs = motor.executeQuery(SQL_FIND_ALL);

                //Mientras haya resultados se ejecuta el while
                while (rs.next()){
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt("ID_Cliente"));
                    cliente.setNombre(rs.getString("Nombre"));
                    cliente.setApellido(rs.getString("Apellido"));
                    cliente.setTelefono(rs.getString("Telefono"));
                    cliente.setEmail(rs.getString("Email"));
                    cliente.setContrasena(rs.getString("Contrasena"));

                    clientes.add(cliente);
                }
            }
            catch (Exception exception) {
                clientes.clear();
            }
            finally {
                motor.disconnect();
            }

            return clientes;
        }

}
