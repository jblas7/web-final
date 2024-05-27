package Model.Dao;

import Model.Entities.Categoria;
import Model.Entities.Producto;
import Model.MotorSQL;
import Model.Dao.IDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDao implements IDao<Categoria,Integer> {

    @Override
    public ArrayList<Categoria> findAll(Categoria objeto) {
        ArrayList <Categoria> categorias = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            //Esto es para conectarnos a la bbdd
            motor.connect();

            //EJECUTAR LA SENTENCIA/CONSULTA/QUERY
            ResultSet rs = motor.executeQuery("SELECT * FROM CATEGORIA");

            //Mientras haya resultados se ejecuta el while
            while (rs.next()){
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("ID_Categoria"));
                categoria.setNombre(rs.getString("Nombre"));
                categorias.add(categoria);
            }
        }
        catch (Exception exception) {
            categorias.clear();
        }
        finally {
            motor.disconnect();
        }

        return categorias;
    }


    @Override
    public int add (Categoria categoria){
        MotorSQL motor =new MotorSQL();
        int iFilasAnadidas = 0;
        try {
            motor.connect();
            PreparedStatement ps =motor.getPreparedStatement("INSERT INTO CATEGORIA (Nombre) VALUES (?)");
            ps.setInt(1,categoria.getIdCategoria());
            ps.setString(2,categoria.getNombre());

            iFilasAnadidas = ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            motor.disconnect();
        }
         return iFilasAnadidas;
    }


    @Override
    public int update(Categoria categoria) {
        MotorSQL motor = new MotorSQL();
        int iFilasActualizadas = 0;
        try {
            motor.connect();
            StringBuilder sql = new StringBuilder("UPDATE Categoria SET ");
            ArrayList<Object> params = new ArrayList<>();

            if (categoria.getNombre() != null) {
                sql.append("Nombre = ?, ");
                params.add(categoria.getNombre());
            }

            if (params.size() > 0) {
                sql.setLength(sql.length() - 2);
                sql.append(" WHERE ID_Categoria = ?");
                params.add(categoria.getIdCategoria());

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
    public int delete(Integer idCategoria) {
        MotorSQL motor = new MotorSQL();
        int iFilasBorradas = 0;
        try{
            motor.connect();
            String sql = "DELETE from CATEGORIA where ID_CATEGORIA = ?";
            PreparedStatement ps = motor.getPreparedStatement(sql);
            ps.setInt(1, idCategoria);

            iFilasBorradas = ps.executeUpdate();
            ps.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            motor.disconnect();
        }
        return iFilasBorradas;

    }


}