import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Servlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        // getting the information from the request
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String birth_date = request.getParameter("birth_date");
        String sexe = request.getParameter("sexe");

        // checking if visit coockie exists
        Cookie[] cookies = request.getCookies();

        int i = 0;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("nb_visits")) {
                break;
            }
            i++;
        }

        if (i < cookies.length) {
            int val = 0;

            try {
                val = (Integer.parseInt(cookies[i].getValue()));
            } catch (Exception e) {
            }

            response.addCookie(new Cookie("nb_visits", String.valueOf(++val)));
        } else {
            response.addCookie(new Cookie("nb_visits", "0"));
        }

        // cookie creation
        Cookie c_first = new Cookie("first_name", first_name);
        Cookie c_last = new Cookie("last_name", last_name);
        Cookie c_birth = new Cookie("birth_date", birth_date);
        Cookie c_sexe = new Cookie("sexe", sexe);

        response.addCookie(c_first);
        response.addCookie(c_last);
        response.addCookie(c_birth);
        response.addCookie(c_sexe);

        // starts formating the html page
        PrintWriter out = response.getWriter();
        out.println("<h1>Information recieved :</h1>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<td>");
        out.print("First Name : ");
        out.println("</td>");
        out.println("<td>");
        out.print(first_name);
        out.println("</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>");
        out.print("Last Name : ");
        out.println("</td>");
        out.println("<td>");
        out.print(last_name);
        out.println("</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>");
        out.print("Date Of Birth : ");
        out.println("</td>");
        out.println("<td>");
        out.print(birth_date);
        out.println("</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>");
        out.print("Sexe : ");
        out.println("</td>");
        out.println("<td>");
        out.print(sexe);
        out.println("</td>");
        out.println("</tr>");

        out.println("</table>");
    }
}
