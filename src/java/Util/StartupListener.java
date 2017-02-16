
package Util;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import org.hibernate.SessionFactory;

@WebListener
public class StartupListener implements javax.servlet.ServletContextListener {
    private SessionFactory sessionFactory;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("StartupListener contextInitialized()...");
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        System.out.println("...contextInitialized() done.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("StartupListener contextDestroyed()");
    }
}
