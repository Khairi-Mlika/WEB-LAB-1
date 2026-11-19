import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

import jakarta.servlet.annotation.WebListener;

@WebListener 
public class RequestListener implements ServletRequestListener {

    public void requestInitialized(ServletRequestEvent sre){
        System.out.println("RequestListener : Request Created <3");
    }

    public void requestDestroyed(ServletRequestEvent sre){
        System.out.println("RequestListener : Request Destroyed <3");
    }
    
}
