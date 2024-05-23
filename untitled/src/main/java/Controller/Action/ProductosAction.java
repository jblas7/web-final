package Controller.Action;

import Model.Dao.ProductosDao;
import Controller.Action.IAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ProductosAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        String resultado = "";

        switch (action) {
            case "find_all":
                resultado = findAll();
                break;
            case "delete":
                resultado = delete(request);
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

}
