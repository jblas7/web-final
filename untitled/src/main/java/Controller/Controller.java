package Controller;

import Controller.Actions.ClienteAction;
import Controller.Actions.ProductosAction;
import Controller.Actions.CategoriaAction;
import Model.Person;
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
import java.lang.reflect.Array;


@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*"); // Permitir acceso desde cualquier origen
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // Permitir los métodos HTTP
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization"); // Permitir ciertos encabezados
        response.setHeader("Access-Control-Max-Age", "3600"); // Cache de opciones preflight durante 1 hora

        PrintWriter out = response.getWriter();
        String strAction = request.getParameter("action"); // strAction = value from the parameter "action"
        String[] arrayAction = new String[2];
        if (strAction != null && !strAction.isEmpty()) {
            arrayAction = strAction.split("\\."); // [0] = productos / [1] = find_all
        }

        switch (arrayAction[0].toLowerCase()) {
            case "productos": {
                out.print(new ProductosAction().execute(response, request, arrayAction[1]));
                break;
            }
            case "clientes": {
                out.print(new ClienteAction().execute(response, request, arrayAction[1]));
                break;
            }
            case "categoria": {
                out.print(new CategoriaAction().execute(response, request, arrayAction[1]));
                break;
            }
            default: {
                System.out.println(arrayAction[0]);
                throw new ServletException("Acción " + arrayAction[0] + " no válida");
            }
        }
        System.out.println(strAction);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        JsonParser parser = new JsonParser();
        Gson gson = new Gson();
        Person p = gson.fromJson(parser.parse(getBody(request)), Person.class);

        System.out.println(gson.toJson(p));

        response.getWriter().print("Hola " + p.name + "\r\n");
    }

    private static String getBody(HttpServletRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead;
                while ((bytesRead = bufferedReader.read(charBuffer)) != -1) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }
        } catch (IOException ex) {
            return "";
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                }
            }
        }
        return stringBuilder.toString();
    }
}
