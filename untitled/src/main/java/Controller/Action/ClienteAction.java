package Controller.Action;

import Model.Dao.ClienteDao;
import Model.Entities.Cliente;
import Controller.Action.IAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ClienteAction implements IAction{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        String resultado = "";

        switch (action){
            case "find_all":
                resultado = findAll ();
                break;

            default: resultado = "ERROR. Invalid action";
        }

        return resultado;
    }

    private String findAll (){
        ClienteDao clienteDao = new ClienteDao();
        ArrayList<Cliente> clientes = clienteDao.findAll(null);
        return Cliente.toArrayJson(clientes);
    }

}