package model.dao;

import model.entities.Productos;
import model.factory.DatabaseFactory;
import model.motorsql.MotorMySQL;
import model.motorsql.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductosDAO implements DAO<Productos, Integer> {

    private final String SQL_FINDALL = "SELECT * FROM productos WHERE 1=1 ";
    private final String SQL_FIND_BY_CATEGORY = "SELECT p.Nombre, p.Descripcion, p.Precio, c.Nombre AS Categoria " +
            "FROM productos p " +
            "INNER JOIN categoria c ON p.idCategoria = c.idCategoria " +
            "WHERE c.Nombre LIKE ?";
    private final String SQL_ADD = "INSERT INTO productos (Nombre, Descripcion, Precio, Url_Imagen, idCategoria) VALUES (?, ?, ?, ?, ?)";
    private final String SQL_DELETE = "DELETE FROM productos WHERE idProducto=?";
    private final String SQL_UPDATE = "UPDATE productos SET Nombre=?, Descripcion=?, Precio=?, Url_Imagen=?, idCategoria=? WHERE idProducto=?";
    private MotorSQL motorSql;

    public ProductosDAO(String db) {
        motorSql = DatabaseFactory.getDatabase(db);
    }

    @Override
    public ArrayList<Productos> findAll(Productos bean) {
        ArrayList<Productos> productos = new ArrayList<>();
        String sql = SQL_FINDALL;
        try {
            motorSql.connect();
            if (bean != null) {
                if (bean.getIdProducto() != null && bean.getIdProducto() != 0) {
                    sql += " AND idProducto='" + bean.getIdProducto() + "'";
                }
                if (bean.getNombre() != null) {
                    sql += " AND Nombre='" + bean.getNombre() + "'";
                }
                if (bean.getDescripcion() != null) {
                    sql += " AND Descripcion LIKE('%" + bean.getDescripcion() + "%')";
                }
                if (bean.getPrecio() != null && bean.getPrecio() != 0) {
                    sql += " AND Precio='" + bean.getPrecio() + "'";
                }
                if (bean.getUrlImagen() != null) {
                    sql += " AND Url_Imagen='" + bean.getUrlImagen() + "'";
                }
                if (bean.getIdCategoria() != null) {
                    sql += " AND idCategoria='" + bean.getIdCategoria() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Productos producto = new Productos();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("Nombre"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setPrecio(rs.getDouble("Precio"));
                producto.setUrlImagen(rs.getString("Url_Imagen"));
                producto.setIdCategoria(rs.getString("idCategoria"));

                productos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return productos;
    }

    public ArrayList<Productos> findAllByCategory(String category) {
        ArrayList<Productos> productos = new ArrayList<>();
        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(SQL_FIND_BY_CATEGORY, "%" + category + "%");

            while (rs.next()) {
                Productos producto = new Productos();
                producto.setNombre(rs.getString("Nombre"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setPrecio(rs.getDouble("Precio"));
                // Assuming Categoria field exists in Producto entity for the example
                producto.setIdCategoria(rs.getString("Categoria"));

                productos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return productos;
    }

    @Override
    public int add(Productos bean) {
        int resp = 0;
        try {
            motorSql.connect();
            resp = motorSql.execute(SQL_ADD, bean.getNombre(), bean.getDescripcion(), bean.getPrecio(), bean.getUrlImagen(), bean.getIdCategoria());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        if (resp > 0) {
            System.out.println("Producto insertado con éxito.");
        }
        return resp;
    }

    @Override
    public int delete(Integer id) {
        int resp = 0;
        try {
            motorSql.connect();
            resp = motorSql.execute(SQL_DELETE, id);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        if (resp > 0) {
            System.out.println("Borrado con éxito.");
        } else {
            System.out.println("No se pudo borrar.");
        }
        return resp;
    }

    @Override
    public int update(Productos bean) {
        int resp = 0;
        try {
            motorSql.connect();
            resp = motorSql.execute(SQL_UPDATE, bean.getNombre(), bean.getDescripcion(), bean.getPrecio(), bean.getUrlImagen(), bean.getIdCategoria(), bean.getIdProducto());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        if (resp > 0) {
            System.out.println("Producto actualizado con éxito.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
        return resp;
    }

    public static void main(String[] args) {
        ProductosDAO productosDAO = new ProductosDAO(DatabaseFactory.ORACLE);

        ArrayList<Productos> lstProductos = productosDAO.findAll(null);
        System.out.println(lstProductos.toString());
    }
}