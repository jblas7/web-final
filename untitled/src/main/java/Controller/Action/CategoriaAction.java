package Controller.Action;

import Model.Dao.CategoriaDao;
import Model.Entities.Categoria;
import Controller.Action.IAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class CategoriaAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response,  String action) {
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
        CategoriaDao categoriaDao = new CategoriaDao();
        ArrayList<Categoria> categoria = categoriaDao.findAll(null);
        return Categoria.toArrayJson(categoria);
    }

}