package Model.Dao;

import Model.MotorSQL;
import Model.Entities.Productos;
import Model.Dao.IDao;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductosDao implements IDao<Productos, Integer> {

    private final String SQL_FIND_ALL = "SELECT * FROM Productos";

    @Override
    public int add(Productos productos) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(Integer e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int update(Productos productos) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Productos> findAll(Productos objeto) {
        ArrayList<Productos> productos = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            //Esto es para conectarnos a la bbdd
            motor.connect();

            //EJECUTAR LA SENTENCIA/CONSULTA/QUERY
            ResultSet rs = motor.executeQuery(SQL_FIND_ALL);

            //Mientras haya resultados se ejecuta el while
            while (rs.next()) {
                Productos producto = new Productos();
                producto.setIdProducto(rs.getInt("ID_Producto"));
                producto.setNombre(rs.getString("Nombre"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setPrecio(rs.getDouble("Precio"));
                producto.setRutaImagen(rs.getString("Ruta_Imagen"));
                producto.setIdCategoria(rs.getInt("ID_Categoria"));

                productos.add(producto);
            }
        } catch (Exception exception) {
            productos.clear();
        } finally {
            motor.disconnect();
        }

        return productos;
    }
}
