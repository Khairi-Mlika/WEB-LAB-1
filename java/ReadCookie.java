import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class ReadCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HashMap<String, String> cookie_map = new HashMap<>();
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie_map.put(cookie.getName(), cookie.getValue());
            }

            out.println("<table>");
            cookie_map.forEach((k, v) -> {
                out.println("<tr>");
                out.println("<td>" + k + ": </td>");
                out.println("<td>" + v + "</td>");
                out.println("</tr>");
            });
            out.println("</table>");
        } else {
            out.println("there was no cookies");
        }
    }
}
