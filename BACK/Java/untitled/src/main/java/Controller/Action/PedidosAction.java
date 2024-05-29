package Controller.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Dao.PedidosDao;
import Model.Entities.Pedidos;

public class PedidosAction implements IAction {

    private HttpServletRequest request;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        String strResultado = "";

        switch (action.toLowerCase()) {
            case "find_all":
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

            default:
                strResultado = "ERROR. Invalid action";
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

            String estado = request.getParameter("estado");
            Integer idCliente = Integer.valueOf(request.getParameter("idCliente"));
            Integer idTrabajador = Integer.valueOf(request.getParameter("idTrabajador"));

            if (idCliente == 0 || idTrabajador == 0) {
                return "{ \"error\": \"Mandatory data missing\" }";
            }

            Pedidos pedido = new Pedidos("1", estado, idCliente, idTrabajador);

            int numFilas = pedidosDao.add(pedido);
            return "Successfully saved data";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failure in the add order operation";
        }
    }

    private String update(HttpServletRequest request) {
        try {
            PedidosDao pedidosDao = new PedidosDao();

            String idPedido = request.getParameter("idPedido");
            String estado = request.getParameter("estado");
            Integer idCliente = Integer.valueOf(request.getParameter("idCliente"));
            Integer idTrabajador = Integer.valueOf(request.getParameter("idTrabajador"));

            Pedidos pedido = new Pedidos(idPedido, estado, idCliente, idTrabajador);

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
                return "{ \"error\": \"Order ID not provided\" }";
            }

            PedidosDao pedidosDao = new PedidosDao();
            int numEliminaciones = pedidosDao.delete(idPedido);

            if (numEliminaciones > 0) {
                return "{ \"message\": \"Order successfully deleted\" }";
            } else {
                return "{ \"error\": \"Order could not be deleted\" }";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

