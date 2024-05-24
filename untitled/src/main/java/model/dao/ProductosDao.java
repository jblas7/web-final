package Model.Dao;

import Model.MotorSQL;
import Model.Entities.Productos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductosDao implements IDao<Productos, Integer> {

    private final String SQL_FIND_ALL = "SELECT * FROM Productos";
    private final String SQL_DELETE = "DELETE FROM Productos WHERE ID_Producto = ?";

    @Override
    public int add(Productos productos) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(Integer id) {
        MotorSQL motor = new MotorSQL();
        int iNumeroEliminaciones = 0;
        try {
            // Conectar a la base de datos
            motor.connect();
            ResultSet rs = motor.executeQuery(SQL_DELETE);


            iNumeroEliminaciones = motor.executeUpdate(SQL_DELETE, id);

        } catch (Exception e) {
            e.printStackTrace();
            iNumeroEliminaciones = 0;
        }
        return iNumeroEliminaciones;
    }



    @Override
    public int update(Productos producto) {
        MotorSQL motor = new MotorSQL();
        int iFilasActualizadas = 0;
        try {
            motor.connect();
            StringBuilder sql = new StringBuilder("UPDATE Productos SET ");
            ArrayList<Object> params = new ArrayList<>();

            if (producto.getNombre() != null) {
                sql.append("Nombre = ?, ");
                params.add(producto.getNombre());
            }
            if (producto.getDescripcion() != null) {
                sql.append("Descripcion = ?, ");
                params.add(producto.getDescripcion());
            }
            if (producto.getPrecio() != null) {
                sql.append("Precio = ?, ");
                params.add(producto.getPrecio());
            }
            if (producto.getRutaImagen() != null) {
                sql.append("Ruta_Imagen = ?, ");
                params.add(producto.getRutaImagen());
            }
            if (producto.getIdCategoria() != null) {
                sql.append("ID_Categoria = ?, ");
                params.add(producto.getIdCategoria());
            }

            if (params.size() > 0) {
                sql.setLength(sql.length() - 2);
                sql.append(" WHERE ID_Producto = ?");
                params.add(producto.getIdProducto());

                // Preparar y ejecutar la consulta
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
    public ArrayList<Productos> findAll(Productos objeto) {
        ArrayList<Productos> productos = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            // Esto es para conectarnos a la bbdd
            motor.connect();

            // EJECUTAR LA SENTENCIA/CONSULTA/QUERY
            ResultSet rs = motor.executeQuery(SQL_FIND_ALL);

            // Mientras haya resultados se ejecuta el while
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
