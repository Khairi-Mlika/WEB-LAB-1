package lab.mvc.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lab.mvc.Model.Person;

import java.io.IOException;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstname = request.getParameter("firstName");
        String lastname = request.getParameter("lastName");
        String birthday = request.getParameter("birthday");
        String sexe = request.getParameter("sexe");

        if (firstname == null || lastname == null || birthday == null || sexe == null) {
            response.sendError(400, "Invalid Request");
            return;
        }

        Person person = new Person(firstname, lastname, birthday, sexe);
        request.setAttribute("person", person);

        int year = Integer.parseInt(birthday.split("-")[0]);

        RequestDispatcher dispatcher;
        if (year < 1990){
            dispatcher = getServletContext().getRequestDispatcher("/old.jsp");
        }
        else {
            dispatcher = getServletContext().getRequestDispatcher("/new.jsp");
        }
        dispatcher.include(request, response);
    }
}
