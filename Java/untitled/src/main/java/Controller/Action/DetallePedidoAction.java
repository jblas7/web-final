package Controller.Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Dao.DetallePedidoDao;
import Model.Dao.TrabajadorDao;
import Model.Entities.DetallePedido;
import Model.Entities.Trabajador;

public class DetallePedidoAction implements IAction {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        String strResultado = "";

        switch (action.toLowerCase()){
            case "find_all":
                strResultado = findAll ();
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
        DetallePedidoDao categoriaDao = new DetallePedidoDao();
        ArrayList<DetallePedido> detallepedido = categoriaDao.findAll(null);
        return DetallePedido.toArrayJson(detallepedido);
    }

    private String add (HttpServletRequest request){
        try {
            DetallePedidoDao detallePedidoDao = new DetallePedidoDao();

            Integer idDetalle = Integer.valueOf(request.getParameter("idDetallePedido"));
            Integer cantidad = Integer.valueOf(request.getParameter("cantidad"));
            Integer idPedido= Integer.valueOf(request.getParameter("idpedidos"));
            Integer idProducto= Integer.valueOf(request.getParameter("idProducto"));


            if (idDetalle == null || idDetalle <0 ||
                    cantidad == null || cantidad <0 ||
                    idPedido == null || idPedido <0 ||
                    idProducto == null) {
                return "{ \"error\": \"Faltan datos obligatorios\" }";
            }
            DetallePedido detallePedido = new DetallePedido();

            detallePedido.setIdDetallePedido(idDetalle);
            detallePedido.setCantidad(cantidad);
            detallePedido.setIdpedidos(idPedido);
            detallePedido.setIdProducto(idProducto);


            Integer numFilas = detallePedidoDao.add(detallePedido);
            return String.valueOf(numFilas);
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    private String update (HttpServletRequest request){
        try {
            DetallePedidoDao detallePedidoDao = new DetallePedidoDao();

            Integer idDetalle = Integer.parseInt(request.getParameter("idDetallePedido"));
            Integer cantidad = Integer.parseInt(request.getParameter("cantidad"));
            Integer idPedido = Integer.parseInt(request.getParameter("idPedidos"));
            Integer idProducto = Integer.parseInt(request.getParameter("idProducto"));



            if ( idDetalle == null || idDetalle<0 ){
                return "{ \"error\": \"Faltan datos obligatorios\" }";
            }
            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setIdDetallePedido(idDetalle);
            detallePedido.setCantidad(cantidad);
            detallePedido.setIdpedidos(idPedido);
            detallePedido.setIdProducto(idProducto);

            Integer numFilas = detallePedidoDao.update(detallePedido);
            return String.valueOf(numFilas);
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    private String delete(HttpServletRequest request) {
        Integer idTrabajador = Integer.valueOf(request.getParameter("id"));
        if (idTrabajador == null || idTrabajador==-1) {
            return "{ \"error\": \"No se proporcionó el ID del trabajador\" }";
        }

        TrabajadorDao trabajadorDao = new TrabajadorDao();
        int iNumeroEliminaciones = trabajadorDao.delete(idTrabajador);

        if (iNumeroEliminaciones > 0) {
            return "{ \"message\": \"Producto eliminado exitosamente\" }";
        } else {
            return "{ \"error\": \"No se pudo eliminar el producto\" }";
        }
    }

}