/*
package Controller.Action;

import Model.Dao.PedidosDao;
import model.entities.Pedidos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PedidosAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        String resultado = "";

        switch (action) {
            case "entregacasa": // EJEMPLO http://localhost:8080/PecBurger/Controller?action=pedidos.entregacasa&idPedido=1&hora=12:00&direccion=CALLE34&idCliente=1&idTrabajador=2
                resultado = entregacasa(request);
                break;
            case "recogidalocal":  // EJEMPLO http://localhost:8080/PecBurger/Controller?action=pedidos.recogidalocal&idPedido=2&hora=15:00&nombre=Juan

                resultado = recogidaLocal(request);
                break;
            default:
                resultado = "ERROR. Invalid action";
        }

        return resultado;
    }

    private String entregacasa(HttpServletRequest request) {
        String idPedido = request.getParameter("idPedido");
        String hora = request.getParameter("hora");
        String direccion = request.getParameter("direccion");
        String idCliente = request.getParameter("idCliente");
        String idTrabajador = request.getParameter("idTrabajador");

        if (idPedido == null || idPedido.isEmpty() ||
                hora == null || hora.isEmpty() ||
                direccion == null || direccion.isEmpty() ||
                idCliente == null || idCliente.isEmpty() ||
                idTrabajador == null || idTrabajador.isEmpty()) {
            return "{ \"error\": \"Faltan datos obligatorios\" }";
        }

        Pedidos pedido;
        try {
            pedido = new Pedidos(
                    Integer.parseInt(idPedido),
                    hora,
                    "En proceso", // Estado inicial
                    direccion,
                    Integer.parseInt(idCliente),
                    Integer.parseInt(idTrabajador)
            );
        } catch (NumberFormatException e) {
            return "{ \"error\": \"Datos inválidos\" }";
        }

        PedidosDao pedidosDao = new PedidosDao();
        int iFilasAnadidas = pedidosDao.add(pedido);

        if (iFilasAnadidas > 0) {
            return "{ \"message\": \"Pedido añadido exitosamente\" }";
        } else {
            return "{ \"error\": \"No se pudo añadir el pedido\" }";
        }
    }

    private String recogidaLocal(HttpServletRequest request) {
        String idPedido = request.getParameter("idPedido");
        String hora = request.getParameter("hora");
        String nombre = request.getParameter("nombre");

        if (idPedido == null || idPedido.isEmpty() ||
                hora == null || hora.isEmpty() ||
                nombre == null || nombre.isEmpty()) {
            return "{ \"error\": \"Faltan datos obligatorios\" }";
        }

        Pedidos pedido;
        try {
            pedido = new Pedidos(
                    Integer.parseInt(idPedido),
                    hora,
                    "En proceso", // Estado inicial
                    nombre
            );
        } catch (NumberFormatException e) {
            return "{ \"error\": \"Datos inválidos\" }";
        }

        PedidosDao pedidosDao = new PedidosDao();
        /*int iFilasAnadidas = pedidosDao.addRecogidaLocal(pedido);

        if (iFilasAnadidas > 0) {
            return "{ \"message\": \"Pedido añadido exitosamente\" }";
        } else {
            return "{ \"error\": \"No se pudo añadir el pedido\" }";
        }
    }
}

 */
