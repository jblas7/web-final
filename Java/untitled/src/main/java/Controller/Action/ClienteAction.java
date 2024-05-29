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
        String calle = request.getParameter("calle");
        String portal = request.getParameter("portal");
        String piso = request.getParameter("piso");
        String letra = request.getParameter("letra");

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
        cliente.setCalle(calle);
        cliente.setPortal(portal);
        cliente.setPiso(piso);
        cliente.setLetra(letra);

        ClienteDao clienteDao = new ClienteDao();
        int iFilasAnadidas = clienteDao.add(cliente);

        if (iFilasAnadidas > 0) {
            return "{ \"message\": \"Customer successfully registered\" }";
        } else {
            return "{ \"error\": \"Customer could not be registered\" }";
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
        String calle = request.getParameter("calle");
        String portal = request.getParameter("portal");
        String piso = request.getParameter("piso");
        String letra = request.getParameter("letra");

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
        cliente.setCalle(calle);
        cliente.setPortal(portal);
        cliente.setPiso(piso);
        cliente.setLetra(letra);

        int iFilasModificadas = clienteDao.update(cliente);

        if (iFilasModificadas > 0) {
            return "{ \"message\": \"The customer has been successfully modified\" }";
        } else {
            return "{ \"error\": \"Client could not be modified\" }";
        }
    }

    private String delete(HttpServletRequest request) {
        ClienteDao clienteDao = new ClienteDao();

        String idCliente = request.getParameter("id");

        if (idCliente == null || idCliente.isEmpty()) {
            return "{ \"error\": \"Customer ID not provided\" }";
        }

        int clienteId;
        try {
            clienteId = Integer.parseInt(idCliente);
        } catch (NumberFormatException e) {
            return "{ \"error\": \"Invalid Customer ID\" }";
        }

        int iNumeroEliminaciones = clienteDao.delete(clienteId);

        if (iNumeroEliminaciones > 0) {
            return "{ \"message\": \"Customer successfully deleted\" }";
        } else {
            return "{ \"error\": \"Client could not be deleted\" }";
        }
    }

    private String login(HttpServletRequest request) {
        String email = request.getParameter("email");
        String contrasena = request.getParameter("contrasena");

        if (email == null || email.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            return "{ \"error\": \"Email and password are required\" }";
        }

        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = clienteDao.login(email, contrasena);

        if (cliente != null) {
            return "{ \"message\": \"Successful login\", \"customer\": " + cliente.toJson() + " }";
        } else {
            return "{ \"error\": \"Incorrect email or password\" }";
        }
    }
}
