package Controller.Action;

import Model.Dao.TrabajadorDao;
import Model.Entities.Trabajador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;

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
            case "add":
                //strReturn
                strResultado = add(request);
                break;
            case "update":
                //strReturn
                strResultado = update(request);
                break;
            case "delete":
                //strReturn
                strResultado = delete(request);
                break;


            default: strResultado = "ERROR. Invalid action";
        }

        return strResultado;
    }

    private String findAll (){
        TrabajadorDao trabajadorDao = new TrabajadorDao();
        ArrayList<Trabajador> trabajador = trabajadorDao.findAll(null);
        return Trabajador.toArrayJson(trabajador);
    }

    private String add (HttpServletRequest request){
        try {
            TrabajadorDao trabajadorDao = new TrabajadorDao();

            String nombre=request.getParameter("nombre");
            String apellido= request.getParameter("apellido");
            Integer numeroSS= Integer.valueOf(request.getParameter("num_ss"));
            Double salario= Double.valueOf(request.getParameter("salario"));
            String telefono= request.getParameter("telefono");
            String email= request.getParameter("email");
            String contrasena= request.getParameter("contrasena");
            String tipoTrabajo= request.getParameter("tipo_trabajo");
            String FechaContratacion= request.getParameter("fecha_contratacion");

            if (nombre == null || nombre.isEmpty() ||
                    apellido == null || apellido.isEmpty() ||
                    numeroSS == null || numeroSS==0 ||
                    salario == null || salario==0 ||
                    telefono == null || telefono.isEmpty() ||
                    email == null || email.isEmpty() ||
                    contrasena == null || contrasena.isEmpty() ||
                    tipoTrabajo == null || tipoTrabajo.isEmpty() ||
                    FechaContratacion == null) {
                return "{ \"error\": \"Faltan datos obligatorios\" }";
            }
            Trabajador trabajador=new Trabajador();
            trabajador.setNombre(nombre);
            trabajador.setApellido(apellido);
            trabajador.setNumeroSS(numeroSS);
            trabajador.setSalario(salario);
            trabajador.setTelefono(telefono);
            trabajador.setEmail(email);
            trabajador.setContrasena(contrasena);
            trabajador.setTipoTrabajo(tipoTrabajo);

            Integer numFilas = trabajadorDao.add(trabajador);
            return String.valueOf(numFilas);
        }catch (Exception e){
            e.getMessage();
            return null;
        }

    }

    private String update (/*Categoria categoria*/HttpServletRequest request){
        try {
            TrabajadorDao trabajadorDao = new TrabajadorDao();

            Integer id= Integer.parseInt(request.getParameter("id"));
            String nombre=request.getParameter("nombre");
            String apellido= request.getParameter("apellido");
            Integer numeroSS= Integer.valueOf(request.getParameter("num_ss"));
            Double salario= Double.valueOf(request.getParameter("salario"));
            String telefono= request.getParameter("telefono");
            String email= request.getParameter("email");
            String contrasena= request.getParameter("contrasena");
            String tipoTrabajo= request.getParameter("tipo_trabajo");
            String FechaContratacion= request.getParameter("fecha_contratacion");

            if ( id == null || id<0 ){
                return "{ \"error\": \"Faltan datos obligatorios\" }";
            }
            Trabajador trabajador=new Trabajador();
            trabajador.setIdTrabajador(id);
            trabajador.setNombre(nombre);
            trabajador.setApellido(apellido);
            trabajador.setNumeroSS(numeroSS);
            trabajador.setSalario(salario);
            trabajador.setTelefono(telefono);
            trabajador.setEmail(email);
            trabajador.setContrasena(contrasena);
            trabajador.setTipoTrabajo(tipoTrabajo);

            Integer numFilas = trabajadorDao.update(trabajador);
            return String.valueOf(numFilas);
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    private String delete(HttpServletRequest request) {
        Integer idTrabajador = Integer.valueOf(request.getParameter("id"));
        if (idTrabajador == null || idTrabajador==-1) {
            return "{ \"error\": \"Worker ID not provided\" }";
        }

        TrabajadorDao trabajadorDao = new TrabajadorDao();
        int iNumeroEliminaciones = trabajadorDao.delete(idTrabajador);

        if (iNumeroEliminaciones > 0) {
            return "{ \"message\": \"Product successfully removed\" }";
        } else {
            return "{ \"error\": \"Product could not be removed\" }";
        }
    }

}