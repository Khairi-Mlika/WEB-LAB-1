import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class ListItems extends HttpServlet {

    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        String itemName = request.getParameter("newItem");

        HashMap<String, Integer> items = (HashMap<String, Integer>) session.getAttribute("items");

        if (items == null) {
            items = new HashMap<>();
        }

        if (items.containsKey(itemName)) {
            items.put(itemName, items.get(itemName) + 1);
        } else {
            items.put(itemName, 1);
        }
        session.setAttribute("items", items);
        response.sendRedirect("http://localhost:8080/demo1/items.html");
    }

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("http://localhost:8080/demo1/items.html");
            return;
        }

        HashMap<String, Integer> items = (HashMap<String, Integer>) session.getAttribute("items");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet ListItems </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet ListItems </h1>");
        if (items != null) {
            items.forEach((k, v) -> {
                out.println(k + ": " + v + "<br>");
            });
        }
        out.println("</body>");
        out.println("</html>");
    }
}
