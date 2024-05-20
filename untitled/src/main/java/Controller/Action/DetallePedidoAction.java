package Controller.Action;

import Model.Entities.DetallePedido;
import Model.Dao.DetallePedidoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class DetallePedidoAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        String resultado = "";

        switch (action.toLowerCase()){
            case "find_all":
                resultado = findAll ();
                break;

            default: resultado = "ERROR. Invalid action";
        }

        return resultado;
    }

    private String findAll (){
        DetallePedidoDao categoriaDao = new DetallePedidoDao();
        ArrayList<DetallePedido> detallepedido = categoriaDao.findAll(null);
        return DetallePedido.toArrayJson(detallepedido);
    }

}