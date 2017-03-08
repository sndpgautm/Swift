
package Util;

import Model.Employee;
import Model.Food;
import Model.FoodData;
import Model.Position;
import Model.userAccount;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebListener
public class StartupListener implements javax.servlet.ServletContextListener {
    private SessionFactory sessionFactory;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("StartupListener contextInitialized()...");
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        //codes to add menu and admin employees when app is started
        Session session = HibernateStuff.getInstance().getSessionFactory().openSession();
        session.beginTransaction();
        List<Food> menu = new FoodData().getMenu();
        for(Food f : menu){
            session.saveOrUpdate(f);
        }
        userAccount u = new userAccount("sandipg","demo");
        session.saveOrUpdate(u);
        Employee e = new Employee("Sandip Gautam", "Kirstinharju 1 A 4",Position.MANAGER,"sandipg");
        session.saveOrUpdate(e);
        userAccount u2 = new userAccount("saugata","demo");
        session.saveOrUpdate(u2);
        Employee e2 = new Employee("Saugat Awale", "Kilonrinne 10 D 2", Position.COOK,"saugata");
        session.saveOrUpdate(e2);
        session.getTransaction().commit();
        //end of those codes
        System.out.println("...contextInitialized() done.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("StartupListener contextDestroyed()");
    }
}
