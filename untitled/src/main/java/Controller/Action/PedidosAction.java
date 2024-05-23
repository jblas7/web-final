package Controller.Action;

import Model.Dao.PedidosDao;
import Model.Entities.Pedidos;
import Controller.Action.IAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class PedidosAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        String strResultado = "";
        switch (action.toLowerCase())
        {
            case "find_all":
                //strReturn
                strResultado = findAll();
                break;

            default: strResultado = "ERROR. Invalid action";
        }

        return strResultado;
    }

    private String findAll (/*Categoria categoria*/){
        PedidosDao pedidosDao = new PedidosDao();
        ArrayList<Pedidos> pedidos = pedidosDao.findAll(null);
        return Pedidos.toArrayJson(pedidos);
    }

}