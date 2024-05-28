// ClienteAction.java
package Controller.Action;

import Model.Dao.ClienteDao;
import Model.Entities.Cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ClienteAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        String resultado = "";

        switch (action) {
            case "find_all":
                resultado = findAll();
                break;
            case "add":
                resultado = add(request);
                break;
            case "update":
                resultado = update(request);
                break;
            case "delete":
                resultado = delete(request);
                break;
            case "login":
                resultado = login(request);
                break;
            default:
                resultado = "ERROR. Invalid action";
        }

        return resultado;
    }

    private String findAll() {
        ClienteDao clienteDao = new ClienteDao();
        ArrayList<Cliente> clientes = clienteDao.findAll(null);
        return Cliente.toArrayJson(clientes);
    }

    private String add(HttpServletRequest request) {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String contrasena = request.getParameter("contrasena");

        if (nombre == null || nombre.isEmpty() ||
                apellido == null || apellido.isEmpty() ||
                telefono == null || telefono.isEmpty() ||
                email == null || email.isEmpty() ||
                contrasena == null || contrasena.isEmpty()) {
            return "{ \"error\": \"Faltan datos obligatorios\" }";
        }

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setTelefono(telefono);
        cliente.setEmail(email);
        cliente.setContrasena(contrasena);

        ClienteDao clienteDao = new ClienteDao();
        int iFilasAnadidas = clienteDao.add(cliente);

        if (iFilasAnadidas > 0) {
            return "{ \"message\": \"Cliente registrado exitosamente\" }";
        } else {
            return "{ \"error\": \"No se pudo registrar el cliente\" }";
        }
    }

    private String update(HttpServletRequest request) {
        ClienteDao clienteDao = new ClienteDao();

        Integer id = Integer.valueOf(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String contrasena = request.getParameter("contrasena");

        if (id == null || id <= 0 || nombre == null || nombre.isEmpty() ||
                apellido == null || apellido.isEmpty() ||
                telefono == null || telefono.isEmpty() ||
                email == null || email.isEmpty() ||
                contrasena == null || contrasena.isEmpty()) {
            return "{ \"error\": \"Faltan datos obligatorios\" }";
        }

        Cliente cliente = new Cliente();
        cliente.setIdCliente(id);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setTelefono(telefono);
        cliente.setEmail(email);
        cliente.setContrasena(contrasena);

        int iFilasModificadas = clienteDao.update(cliente);

        if (iFilasModificadas > 0) {
            return "{ \"message\": \"El cliente se ha modificado exitosamente\" }";
        } else {
            return "{ \"error\": \"No se pudo modificar el cliente\" }";
        }
    }

    private String delete(HttpServletRequest request) {
        ClienteDao clienteDao = new ClienteDao();

        String idCliente = request.getParameter("id");

        if (idCliente == null || idCliente.isEmpty()) {
            return "{ \"error\": \"No se proporcionó el ID del cliente\" }";
        }

        int clienteId;
        try {
            clienteId = Integer.parseInt(idCliente);
        } catch (NumberFormatException e) {
            return "{ \"error\": \"ID del cliente inválido\" }";
        }

        int iNumeroEliminaciones = clienteDao.delete(clienteId);

        if (iNumeroEliminaciones > 0) {
            return "{ \"message\": \"Cliente eliminado exitosamente\" }";
        } else {
            return "{ \"error\": \"No se pudo eliminar el cliente\" }";
        }
    }

    private String login(HttpServletRequest request) {
        String email = request.getParameter("email");
        String contrasena = request.getParameter("contrasena");

        if (email == null || email.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            return "{ \"error\": \"Email y contraseña son obligatorios\" }";
        }

        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = clienteDao.login(email, contrasena);

        if (cliente != null) {
            return "{ \"message\": \"Login exitoso\", \"cliente\": " + cliente.toJson() + " }";
        } else {
            return "{ \"error\": \"Email o contraseña incorrectos\" }";
        }
    }
}
