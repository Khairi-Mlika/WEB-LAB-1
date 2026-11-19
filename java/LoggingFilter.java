import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter("/*")
public class LoggingFilter implements jakarta.servlet.Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoggingFilter : init");

        String chaine = filterConfig.getInitParameter("logPrefix");
        System.out.println("LoggingFilter : log prefix is " + chaine);
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest r = (HttpServletRequest)req;
        System.out.println("LoggingFilter : " + r.getRequestURL().toString());
        double t0 = System.nanoTime();
        chain.doFilter(req, res);
        double t1 = System.nanoTime();
        System.out.println("LoggingFilter : This HTTP request Took " + (t1 - t0)/1000000.0 + "ms");
    }

    public void destroy() {
        System.out.println("LoggingFilter : destroy");
    }
}
