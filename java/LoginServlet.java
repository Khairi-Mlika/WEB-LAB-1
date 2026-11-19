import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("http://localhost:8080/demo1/login.html");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        SessionUser sUser = new SessionUser();
        String username = request.getParameter("username");
        HttpSession session = request.getSession(true);

        session.setAttribute("username", username);
        session.setAttribute("user" , sUser);

        session.removeAttribute("user");

        PrintWriter out = response.getWriter();
        out.print("<h1>Hello " + username + " </h1>");
        out.print("<a href='http://localhost:8080/demo1/items.html' >Click here to go to the items page</a>");
    }
}
