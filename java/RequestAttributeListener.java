
import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener 
public class RequestAttributeListener implements ServletRequestAttributeListener {

    @Override 
    public void attributeAdded(ServletRequestAttributeEvent event) {
        System.out.println("RequestAttributeListener : attributeAdded");
    }

    @Override 
    public void attributeReplaced(ServletRequestAttributeEvent event){
        System.out.println("RequestAttributeListener : attributeReplaced");
    }

    @Override 
    public void attributeRemoved(ServletRequestAttributeEvent event){
        System.out.println("RequestAttributeListener : attributeRemoved");       
    }
    
}
