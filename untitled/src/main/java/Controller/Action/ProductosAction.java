package Controller.Action;

import Model.Dao.ProductosDao;
import Controller.Action.IAction;
import Model.MotorSQL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductosAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        String resultado = "";

        switch (action) {
            case "find_all":
                resultado = findAll();  // EJEMPLO http://localhost:8080/PecBurger/Controller?action=productos.find_all
                break;
            case "delete":
                resultado = delete(request);    // EJEMPLO http://localhost:8080/PecBurger/Controller?action=productos.delete&id=47
                break;
            case "update":
                resultado = update(request);   // EJEMPLO http://localhost:8080//PecBurger/Controller?action=productos.update&id=2&nombre=juan
                break;
            case "add":
                resultado = add(request);       // EJEMPLO http://localhost:8080/PecBurger/Controller?action=productos.add&id=60&nombre=juan&precio=1.00&rutaImagen=1&idCategoria=2
                break;
            default:
                resultado = "ERROR. Invalid action";
        }

        return resultado;
    }

    private String findAll() {
        ProductosDao productosDao = new ProductosDao();
        ArrayList<Model.Entities.Productos> producto = productosDao.findAll(null);
        return Model.Entities.Productos.toArrayJson(producto);
    }

    private String delete(HttpServletRequest request) {
        String ID_Producto = request.getParameter("id");
        if (ID_Producto == null || ID_Producto.isEmpty()) {
            return "{ \"error\": \"No se proporcionó el ID del producto\" }";
        }

        int productoId;
        try {
            productoId = Integer.parseInt(ID_Producto);
        } catch (NumberFormatException e) {
            return "{ \"error\": \"ID de producto inválido\" }";
        }

        ProductosDao productosDao = new ProductosDao();
        int iNumeroEliminaciones = productosDao.delete(productoId);

        if (iNumeroEliminaciones > 0) {
            return "{ \"message\": \"Producto eliminado exitosamente\" }";
        } else {
            return "{ \"error\": \"No se pudo eliminar el producto\" }";
        }
    }


    private String update(HttpServletRequest request) {
        String ID_Producto = request.getParameter("id");
        if (ID_Producto == null || ID_Producto.isEmpty()) {
            return "{ \"error\": \"No se proporcionó el ID del producto\" }";
        }

        int productoId;
        try {
            productoId = Integer.parseInt(ID_Producto);
        } catch (NumberFormatException e) {
            return "{ \"error\": \"ID de producto inválido\" }";
        }

        Model.Entities.Productos producto = new Model.Entities.Productos();
        producto.setIdProducto(productoId);

        String nombre = request.getParameter("nombre");
        if (nombre != null && !nombre.isEmpty()) {
            producto.setNombre(nombre);
        }

        String descripcion = request.getParameter("descripcion");
        if (descripcion != null && !descripcion.isEmpty()) {
            producto.setDescripcion(descripcion);
        }

        String precio = request.getParameter("precio");
        if (precio != null && !precio.isEmpty()) {
            try {
                producto.setPrecio(Double.parseDouble(precio));
            } catch (NumberFormatException e) {
                return "{ \"error\": \"Precio de producto inválido\" }";
            }
        }

        String rutaImagen = request.getParameter("rutaImagen");
        if (rutaImagen != null && !rutaImagen.isEmpty()) {
            producto.setRutaImagen(rutaImagen);
        }

        String idCategoria = request.getParameter("idCategoria");
        if (idCategoria != null && !idCategoria.isEmpty()) {
            try {
                producto.setIdCategoria(Integer.parseInt(idCategoria));
            } catch (NumberFormatException e) {
                return "{ \"error\": \"ID de categoría inválido\" }";
            }
        }

        ProductosDao productosDao = new ProductosDao();
        int updatedRows = productosDao.update(producto);

        if (updatedRows > 0) {
            return "{ \"message\": \"Producto actualizado exitosamente\" }";
        } else {
            return "{ \"error\": \"No se pudo actualizar el producto\" }";
        }
    }
    private String add(HttpServletRequest request) {
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String precio = request.getParameter("precio");
        String rutaImagen = request.getParameter("rutaImagen");
        String idCategoria = request.getParameter("idCategoria");

        if (id == null || id.isEmpty() ||
                nombre == null || nombre.isEmpty() ||
                precio == null || precio.isEmpty() ||
                rutaImagen == null || rutaImagen.isEmpty() ||
                idCategoria == null || idCategoria.isEmpty()) {
            return "{ \"error\": \"Faltan datos obligatorios\" }";
        }

        Model.Entities.Productos producto = new Model.Entities.Productos();
        try {
            producto.setIdProducto(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            return "{ \"error\": \"ID de producto inválido\" }";
        }
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        try {
            producto.setPrecio(Double.parseDouble(precio));
        } catch (NumberFormatException e) {
            return "{ \"error\": \"Precio inválido\" }";
        }
        producto.setRutaImagen(rutaImagen);
        try {
            producto.setIdCategoria(Integer.parseInt(idCategoria));
        } catch (NumberFormatException e) {
            return "{ \"error\": \"ID de categoría inválido\" }";
        }

        ProductosDao productosDao = new ProductosDao();
        int iFilasAnadidas = productosDao.add(producto);

        if (iFilasAnadidas > 0) {
            return "{ \"message\": \"Producto añadido exitosamente\" }";
        } else {
            return "{ \"error\": \"No se pudo añadir el producto\" }";
        }
    }


}
