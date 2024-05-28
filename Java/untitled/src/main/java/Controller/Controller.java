package Controller;

import Controller.Action.*;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Controller", urlPatterns = {"/Controller", "/mi-endpoint"})
public class Controller extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Max-Age", "3600");

        PrintWriter out = response.getWriter();
        String strAction = request.getParameter("action");
        String[] arrayAction = new String[2];

        if (strAction != null && !strAction.isEmpty()) {
            arrayAction = strAction.split("\\.");
        }

        if (arrayAction.length == 2 && arrayAction[0] != null && arrayAction[1] != null) {
            try {
                switch (arrayAction[0].toLowerCase()) {
                    case "productos":
                        out.print(new ProductosAction().execute(request, response, arrayAction[1]));
                        break;
                    case "clientes":
                        out.print(new ClienteAction().execute(request, response, arrayAction[1]));
                        break;
                    case "categoria":
                        out.print(new CategoriaAction().execute(request, response, arrayAction[1]));
                        break;
                    case "trabajador":
                        out.print(new TrabajadorAction().execute(request, response, arrayAction[1]));
                        break;
                    case "detallePedidos":
                        out.print(new DetallePedidoAction().execute(request, response, arrayAction[1]));
                        break;
                     case "pedidos":
                        out.print(new PedidosAction().execute(request, response, arrayAction[1]));
                        break;
                    default:
                        throw new ServletException("Acción " + arrayAction[0] + " no válida");
                }
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                out.print("{\"error\": \"" + e.getMessage() + "\"}");
                e.printStackTrace();
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"error\": \"El parámetro 'action' es requerido y debe tener el formato 'entidad.accion'\"}");
        }
        System.out.println(strAction);
    }

    private void processJsonRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        // Parsear JSON
        Gson gson = new Gson();
        Map<String, String> formData = gson.fromJson(sb.toString(), HashMap.class);

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(formData));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getServletPath().equals("/mi-endpoint")) {
            processJsonRequest(request, response);
        } else {
            processRequest(request, response);
        }
    }
}
