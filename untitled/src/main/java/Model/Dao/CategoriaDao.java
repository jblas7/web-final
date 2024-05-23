package Model.Dao;

import Model.Entities.Categoria;
import Model.MotorSQL;
import Model.Dao.IDao;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoriaDao implements IDao<Categoria,Integer> {

    private final String SQL_FIND_ALL = "SELECT * FROM CATEGORIA WHERE 1=1";

    @Override
    public int add(Categoria categoria) {throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(Integer e) {throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int update(Categoria categoria) {throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Categoria> findAll(Categoria objeto) {
        ArrayList <Categoria> categorias = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            //Esto es para conectarnos a la bbdd
            motor.connect();

            //EJECUTAR LA SENTENCIA/CONSULTA/QUERY
            ResultSet rs = motor.executeQuery(SQL_FIND_ALL);

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

}