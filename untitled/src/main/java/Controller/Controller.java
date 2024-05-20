package Controller;

import Controller.Action.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;


    @WebServlet(name = "Controller", urlPatterns = {"/Controller"})
    public class Controller extends HttpServlet {

        private void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException
        {
            //request.getMethod()
            //request.getQueryString()
            response.setContentType("text/plan;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String strAction = request.getParameter("action"); // strAction = value from the parameter "action"
            //ACTION=PELICULA.FIND_ALL --> HAMBURGUER.FIND_ALL // USER.FIND
            String[] arrayAction = new String[2];
            if (strAction != "")
            {
                arrayAction = strAction.split("\\."); // [0] = film / [1] = find_all
            }
            switch (arrayAction[0].toLowerCase())
            {
                case "productos":
                {
                    out.print(new ProductosAction().execute(response, request, arrayAction[1]));
                    break;
                }

                case "clientes":
                {
                    out.print(new ClienteAction().execute(response, request, arrayAction[1]));
                    break;
                }

                case "categoria":
                {
                    out.print(new CategoriaAction().execute(response, request, arrayAction[1]));
                    break;
                }

                default:
                {
                    System.out.println(arrayAction[0]);
                    throw new ServletException("Acción " + arrayAction[0] + " no válida");
                }
            }
            System.out.println(strAction);
        }


        // get the http
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }
    }
