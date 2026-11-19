import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener 
public class ActiveSessionListener implements HttpSessionListener {
    public static AtomicInteger session_counter = new AtomicInteger(0);

    public void sessionCreated(HttpSessionEvent se){
        ServletContext context = se.getSession().getServletContext();
        session_counter.incrementAndGet();
        context.setAttribute("activeSessions", session_counter);
    }

    public void serssionDestroyed(HttpSessionEvent se){
        ServletContext context = se.getSession().getServletContext();
        session_counter.decrementAndGet();
        context.setAttribute("activeSessions", session_counter);
    }
    
}
