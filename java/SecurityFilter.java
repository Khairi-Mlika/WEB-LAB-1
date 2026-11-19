import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

public class SecurityFilter extends HttpFilter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SecurityFilter : init");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        if (session == null) {
            res.sendRedirect("http://localhost:8080/demo1/login.html");
            return;
        }

        var username = session.getAttribute("username");
        if (username == null) {
            res.sendRedirect("http://localhost:8080/demo1/login.html");
            return;
        }

        System.out.println("SecurityFilter : entered doFilter");

        chain.doFilter(request, response);

        System.out.println("SecurityFilter : left doFilter");
    }

    public void destroy() {
        System.out.println("SecurityFilter : destroy");
    }
}
