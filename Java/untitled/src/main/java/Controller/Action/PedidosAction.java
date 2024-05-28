package Controller.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.Dao.PedidosDao;
import Model.Entities.Pedidos;

public class PedidosAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        String strResultado = "";

        switch (action.toLowerCase()) {
            case "find_all":
                strResultado = findAll();
                break;

            case "add":         // http://localhost:8080/PecBurger/Controller?action=pedidos.add&modoEntrega=Casa&horaEntrega=18:00&estado=preparacion&idCliente=1&idTrabajador=1
                strResultado = add(request);
                break;

            case "update":
                strResultado = update(request);
                break;

            case "delete":
                strResultado = delete(request);
                break;

            default:
                strResultado = "ERROR. Acción inválida";
        }

        return strResultado;
    }

    private String findAll() {
        PedidosDao pedidosDao = new PedidosDao();
        return Pedidos.toArrayJson(pedidosDao.findAll(null));
    }

    private String add(HttpServletRequest request) {
        try {
            PedidosDao pedidosDao = new PedidosDao();

            String tipoPedido = request.getParameter("tipoPedido");
            String modoEntrega = request.getParameter("modoEntrega");
            String horaEntrega = request.getParameter("horaEntrega");
            String shop = request.getParameter("shop");
            String modoRecoger = request.getParameter("modoRecoger");
            String horaRecoger = request.getParameter("horaRecoger");
            String estado = request.getParameter("estado");
            Integer idCliente = Integer.valueOf(request.getParameter("idCliente"));
            Integer idTrabajador = Integer.valueOf(request.getParameter("idTrabajador"));

            if(
                    estado == null || estado.isEmpty() ||
                    idCliente == null || idCliente == 0 ||
                    idTrabajador == null || idTrabajador == 0) {
                return "{ \"error\": \"Faltan datos obligatorios\" }";
            }

            Pedidos pedido = new Pedidos("0", tipoPedido, modoEntrega, horaEntrega, shop, modoRecoger, horaRecoger, estado, idCliente, idTrabajador);

            int numFilas = pedidosDao.add(pedido);
            return "Datos guardados de forma exitosa";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fallo en la operación de agregar pedido";
        }
    }

    private String update(HttpServletRequest request) {
        try {
            PedidosDao pedidosDao = new PedidosDao();

            String idPedido = request.getParameter("idPedido");
            String tipoPedido = request.getParameter("tipoPedido");
            String modoEntrega = request.getParameter("modoEntrega");
            String horaEntrega = request.getParameter("horaEntrega");
            String shop = request.getParameter("shop");
            String modoRecoger = request.getParameter("modoRecoger");
            String horaRecoger = request.getParameter("horaRecoger");
            String estado = request.getParameter("estado");
            Integer idCliente = Integer.valueOf(request.getParameter("idCliente"));
            Integer idTrabajador = Integer.valueOf(request.getParameter("idTrabajador"));

            Pedidos pedido = new Pedidos(idPedido, tipoPedido, modoEntrega, horaEntrega, shop, modoRecoger, horaRecoger, estado, idCliente, idTrabajador);

            int numFilas = pedidosDao.update(pedido);
            return String.valueOf(numFilas);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String delete(HttpServletRequest request) {
        try {
            Integer idPedido = Integer.valueOf(request.getParameter("idPedido"));
            if (idPedido == null || idPedido == -1) {
                return "{ \"error\": \"No se proporcionó el ID del pedido\" }";
            }

            PedidosDao pedidosDao = new PedidosDao();
            int numEliminaciones = pedidosDao.delete(idPedido);

            if (numEliminaciones > 0) {
                return "{ \"message\": \"Pedido eliminado exitosamente\" }";
            } else {
                return "{ \"error\": \"No se pudo eliminar el pedido\" }";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
