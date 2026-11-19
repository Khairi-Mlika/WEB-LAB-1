import jakarta.servlet.*;

public class ApplicationListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        System.out.println("ApplicationListener : Listener Created :3 :3 :3");
        context.setAttribute("appName", "ING1 Web Application");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ApplicationListener : Listener Destroyed :3 :3 :3");
    }

}