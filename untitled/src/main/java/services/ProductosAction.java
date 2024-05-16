package services;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entities.Productos;
import model.dao.ProductosDAO;
import model.factory.DatabaseFactory;

public class ProductosAction implements IAction {

  @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "FIND_ALL":
                cadDestino = findAll(request, response);
                break;
            case "FILTER":
                cadDestino = findByFilter(request, response);
                break;
        }
        return cadDestino;
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {
        ProductosDAO productosDAO = new ProductosDAO(DatabaseFactory.POSTGRE); //SELECT * FROM PELICULAS
        ArrayList<Productos> productos = productosDAO.findAll(null);
        return Productos.toJSon(productos);//[{}, {}]
    }

    private String findByFilter(HttpServletRequest request, HttpServletResponse response) {
        ProductosDAO productosDAO = new ProductosDAO(DatabaseFactory.POSTGRE);
        String tipo = request.getParameter("FILTRO");
        Productos producto = new Productos();
        producto.setNombre(tipo);
        ArrayList<Productos> productos = productosDAO.findAllByCategory(tipo);
        return Productos.toJSon(productos);
    }
}
