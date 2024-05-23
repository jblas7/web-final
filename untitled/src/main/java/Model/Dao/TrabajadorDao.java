package Model.Dao;


import Model.Entities.Trabajador;
import Model.MotorSQL;
import Model.Dao.IDao;

import java.sql.ResultSet;
import java.util.ArrayList;

public class TrabajadorDao implements IDao<Trabajador,Integer> {

    private final String SQL_FIND_ALL = "SELECT * FROM CATEGORIA WHERE 1=1";

    @Override
    public int add(Trabajador trabajador) {throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(Integer e) {throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int update(Trabajador trabajador) {throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Trabajador> findAll(Trabajador objeto) {
        ArrayList <Trabajador> trabajador = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            //Esto es para conectarnos a la bbdd
            motor.connect();

            //EJECUTAR LA SENTENCIA/CONSULTA/QUERY
            ResultSet rs = motor.executeQuery(SQL_FIND_ALL);

            //Mientras haya resultados se ejecuta el while
            while (rs.next()){
                Trabajador trabajadores = new Trabajador();
                trabajadores.setIdTrabajador(rs.getInt("ID_Trabajador"));
                trabajadores.setNombre(rs.getString("Nombre"));
                trabajadores.setApellido(rs.getString("Apellido"));
                trabajadores.setNumeroSS(rs.getInt("Numero_SS"));
                trabajadores.setSalario(rs.getDouble("Salario"));
                trabajadores.setTelefono(rs.getString("Telefono"));
                trabajadores.setEmail(rs.getString("Email"));
                trabajadores.setContrasena(rs.getString("Contrasena"));
                trabajadores.setTipoTrabajo(rs.getString("Tipo_Trabajo"));
                trabajadores.setFechaContratacion(rs.getDate("Fecha_Contratacion"));
                trabajador.add(trabajadores);
            }
        }
        catch (Exception exception) {
            trabajador.clear();
        }
        finally {
            motor.disconnect();
        }

        return trabajador;
    }

}