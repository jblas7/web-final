package Controller.Action;

import Model.Dao.ProductosDao;
import Model.Entities.Productos;
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

            default:
                resultado = "ERROR. Invalid action";
        }

        return resultado;
    }

    private String findAll() {
        ProductosDao productosDao = new ProductosDao();
        ArrayList<Productos> producto = productosDao.findAll(null);
        return Productos.toArrayJson(producto);
    }
}
