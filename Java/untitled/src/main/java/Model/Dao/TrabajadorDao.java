package Model.Dao;


import Model.Entities.Trabajador;
import Model.MotorSQL;
import Model.Dao.IDao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrabajadorDao implements IDao<Trabajador,Integer> {

    @Override
    public ArrayList<Trabajador> findAll(Trabajador objeto) {
        ArrayList <Trabajador> trabajador = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            //Esto es para conectarnos a la bbdd
            motor.connect();
            String sql = "SELECT Nombre, Apellido, Numero_SS, Salario, Telefono, Email, Contrasena, Tipo_Trabajo FROM TRABAJADOR";

            //EJECUTAR LA SENTENCIA/CONSULTA/QUERY
            ResultSet rs = motor.executeQuery(sql);

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

    @Override
    public int add(Trabajador trabajador) {
        MotorSQL motor = new MotorSQL();
        int iFilasAnadidas = 0;
        try {
            motor.connect();
            String sql ="insert into TRABAJADOR (NOMBRE,APELLIDO,NUMERO_SS,SALARIO,TELEFONO,EMAIL,CONTRASENA,TIPO_TRABAJO,FECHA_CONTRATACION) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = motor.getPreparedStatement(sql);
            ps.setString(1, trabajador.getNombre());
            ps.setString(2, trabajador.getApellido());
            ps.setInt(3, trabajador.getNumeroSS());
            ps.setDouble(4, trabajador.getSalario());
            ps.setString(5, trabajador.getTelefono());
            ps.setString(6, trabajador.getEmail());
            ps.setString(7, trabajador.getContrasena());
            ps.setString(8, trabajador.getTipoTrabajo());
            ps.setDate(9, (Date) trabajador.getFechaContratacion());

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
    public int update(Trabajador trabajador) {
        MotorSQL motor = new MotorSQL();
        int iFilasActualizadas = 0;
        try {
            motor.connect();
            StringBuilder sql = new StringBuilder("UPDATE TRABAJADOR SET ");
            ArrayList<Object> params = new ArrayList<>();

            if (trabajador.getNombre() != null) {
                sql.append("NOMBRE = ?, ");
                params.add(trabajador.getNombre());
            }
            if (trabajador.getApellido() != null) {
                sql.append("APELLIDO = ?, ");
                params.add(trabajador.getApellido());
            }
            if (trabajador.getNumeroSS() != null) {
                sql.append("NUMERO_SS = ?, ");
                params.add(trabajador.getNumeroSS());
            }
            if (trabajador.getSalario() != null) {
                sql.append("SALARIO = ?, ");
                params.add(trabajador.getSalario());
            }
            if (trabajador.getTelefono() != null) {
                sql.append("TELEFONO = ?, ");
                params.add(trabajador.getTelefono());
            }
            if (trabajador.getEmail() != null) {
                sql.append("EMAIL = ?, ");
                params.add(trabajador.getEmail());
            }if (trabajador.getContrasena() != null) {
                sql.append("CONTRASENA = ?, ");
                params.add(trabajador.getContrasena());
            }if (trabajador.getTipoTrabajo() != null) {
                sql.append("TIPO_TRABAJO = ?, ");
                params.add(trabajador.getTipoTrabajo());
            }if (trabajador.getFechaContratacion() != null) {
                sql.append("FECHA_CONTRATACION = ?, ");
                params.add(trabajador.getFechaContratacion());
            }

            if (params.size() > 0) {
                sql.setLength(sql.length() - 2);
                sql.append(" WHERE ID_TRABAJADOR = ?");
                params.add(trabajador.getIdTrabajador());

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
    public int delete(Integer idTrabajador) {
        MotorSQL motor = new MotorSQL();
        int iFilasBorradas = 0;
        String sql="DELETE FROM TRABAJADOR WHERE ID_TRABAJADOR=?";
        try {
            PreparedStatement ps = motor.getPreparedStatement(sql);
            ps.setInt(1, idTrabajador);
            iFilasBorradas = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return iFilasBorradas;
    }

}