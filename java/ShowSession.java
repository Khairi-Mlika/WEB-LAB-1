import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ShowSession extends HttpServlet {
    private static int nb_visits = 0;

    private int getDay(String str_date) {
        if(str_date.isEmpty()) { return -1;}

        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        MonthDay target = MonthDay.from(LocalDate.parse(str_date,formater));

        LocalDate today = LocalDate.now();

        LocalDate nextDate = target.atYear(today.getYear());
        if(nextDate.isBefore(today)) {
            nextDate = target.atYear(nextDate.getYear()+1);
        }

        long days = ChronoUnit.DAYS.between(today,nextDate);

        return (int)days;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(true);

        if (session.isNew()){
            nb_visits++;

            out.println("<h1>Welcome on my site</h1>");
            out.println("<form action='http://localhost:8080/demo1/ShowSession' method='POST'>");
            out.println("<table>");
            out.println("<tr><td>Name</td><td><input type='text' name='full_name'/></td></tr>");
            out.println("<tr><td>Birthday</td><td><input type='date' name='date_of_birth'/></td></tr>");
            out.println("</table>");
            out.println("<button type='submit'>Submit</button>");
            out.print("</form>");
        }else{
            out.println("<h1>Welcome back on my site</h1>");

            String full_name = session.getAttribute("full_name") == null ? "" : session.getAttribute("full_name").toString();
            String date_of_birth = session.getAttribute("date_of_birth") == null ? "" : session.getAttribute("date_of_birth").toString();

            int days = getDay(date_of_birth);

            ServletContext context = session.getServletContext();

            out.println("Hi, "+full_name+". There are "+days+" days till your birthday.");
            out.println("Current Active Users : "+ context.getAttribute("activeSessions"));
        }

        session.setAttribute("nb_visits",nb_visits);
        System.out.println(nb_visits);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String full_name =  request.getParameter("full_name");
        String date_of_birth =  request.getParameter("date_of_birth");

        HttpSession session = request.getSession(true);

        session.setAttribute("full_name", full_name);
        session.setAttribute("date_of_birth", date_of_birth);

        response.sendRedirect("http://localhost:8080/demo1/ShowSession");
    }
}