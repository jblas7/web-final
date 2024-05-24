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

        switch (action){
            case "find_all":
                resultado = findAll();
                break;
            case "add":     // ejemplo http://localhost:8080/PecBurger/Controller?action=cliente.add&id=1&nombre=Juan&apellido=Perez&telefono=123456789&email=juan.perez@example.com&contrasena=1234
                resultado = add(request);
                break;
            default:
                resultado = "ERROR. Invalid action";
        }

        return resultado;
    }

    private String findAll(){
        ClienteDao clienteDao = new ClienteDao();
        ArrayList<Cliente> clientes = clienteDao.findAll(null);
        return Cliente.toArrayJson(clientes);
    }

    private String add(HttpServletRequest request) {
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String contrasena = request.getParameter("contrasena");

        if (id == null || id.isEmpty() ||
                nombre == null || nombre.isEmpty() ||
                apellido == null || apellido.isEmpty() ||
                telefono == null || telefono.isEmpty() ||
                email == null || email.isEmpty() ||
                contrasena == null || contrasena.isEmpty()) {
            return "{ \"error\": \"Faltan datos obligatorios\" }";
        }

        Cliente cliente = new Cliente();
        try {
            cliente.setIdCliente(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            return "{ \"error\": \"ID de cliente inválido\" }";
        }
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
}
