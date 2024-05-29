package Controller.Action;

import Model.Dao.CategoriaDao;
import Model.Dao.ClienteDao;
import Model.Entities.Categoria;
import Controller.Action.IAction;
import Model.Entities.Cliente;

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

            case "add":
                strResultado = add(request);
                break;

            case "update":
                strResultado = update(request);
                break;
            case "delete":
                strResultado = delete(request);
                break;
            default: strResultado = "ERROR. Invalid action";
        }

        return strResultado;
    }

    private String findAll (){
        CategoriaDao categoriaDao = new CategoriaDao();
        ArrayList<Categoria> categoria = categoriaDao.findAll(null);
        return Categoria.toArrayJson(categoria);
    }

    private String add (HttpServletRequest request){
        CategoriaDao categoriaDao = new CategoriaDao();

        String nombre = request.getParameter("nombre");

        //Integer id = 8;
        //String nombre ="Hamburguesas";

        if (nombre == null || nombre.isEmpty()){
            return "{ \"error\": \"Faltan datos obligatorios\" }";
        }
        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);

        int iFilasAnadidas = categoriaDao.add(categoria);

        if (iFilasAnadidas > 0) {
            return "{ \"message\": \"La categoria se ha registrado exitosamente\" }";
        } else {
            return "{ \"error\": \"No se pudo registrar la categoria\" }";
        }

    }


    private String update (HttpServletRequest request){
        CategoriaDao categoriaDao = new CategoriaDao();

        Integer id = Integer.valueOf(request.getParameter("idCategoria"));
        String nombre = request.getParameter("nombre");

        //Integer id = 8;
        //String nombre = "Hamburguesas pochas";

        if (id == null || id <0) {
            return "{ \"error\": \"Faltan datos obligatorios\" }";
        }

        Categoria categoria = new Categoria();
        categoria.setIdCategoria(id);
        categoria.setNombre(nombre);

        int iFilasModificadas = categoriaDao.update(categoria);

        if (iFilasModificadas > 0) {
            return "{ \"message\": \"La categoria se ha modificado exitosamente\" }";
        } else {
            return "{ \"error\": \"No se pudo modificar la categoria\" }";
        }

    }


    private String delete (HttpServletRequest request){
        CategoriaDao categoriaDao = new CategoriaDao();

        String idCategoria = request.getParameter("id");
        //String idCategoria = "8";

        if (idCategoria == null || idCategoria.isEmpty()) {
            return "{ \"error\": \"No se proporcionó el ID de la Categoría\" }";
        }

        int categoriaId;
        try {
            categoriaId = Integer.parseInt(idCategoria);
        } catch (NumberFormatException e) {
            return "{ \"error\": \"ID de CATEGORIA inválido\" }";
        }

        int iNumeroEliminaciones = categoriaDao.delete(categoriaId);

        if (iNumeroEliminaciones > 0) {
            return "{ \"message\": \"Categoria eliminada exitosamente\" }";
        } else {
            return "{ \"error\": \"No se pudo eliminar la categoría\" }";
        }

    }
}