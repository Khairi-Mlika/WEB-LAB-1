import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener 
public class SessionAttributeListener implements HttpSessionAttributeListener {

    @Override 
    public void attributeAdded(HttpSessionBindingEvent event){
        System.out.println("SessionAttributeListener : attributeAdded ");
    }

    @Override 
    public void attributeReplaced(HttpSessionBindingEvent event){
        System.out.println("SessionAttributeListener : attributeReplaced ");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event){
        System.out.println("SessionAttributeListener : attributeRemoved");
    }
}
