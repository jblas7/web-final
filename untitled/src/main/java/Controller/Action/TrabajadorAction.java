package Controller.Action;

import Model.Dao.TrabajadorDao;
import Model.Entities.Trabajador;
import Controller.Action.IAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class TrabajadorAction implements IAction {

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
        TrabajadorDao trabajadorDao = new TrabajadorDao();
        ArrayList<Trabajador> trabajador = trabajadorDao.findAll(null);
        return Trabajador.toArrayJson(trabajador);
    }

}