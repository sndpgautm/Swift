/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import Model.Employee;
import Model.Position;
import Util.HibernateStuff;
import java.util.List;
import javax.json.JsonObject;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rocke
 */
@Path("/employees")
public class EmployeeResource {
    
    public EmployeeResource() {
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees() {
        Session session = HibernateStuff.getInstance().getSessionFactory().openSession();
        session.beginTransaction();
        List employees = session.createCriteria(Employee.class).list();
        session.getTransaction().commit();
        return employees;
    }
    
    /*Data is sent in format:
    { "employee_name" : "abc",
      "address" : "xyz",
      "position" : "manager" or "waiter" or "cook"
    }
    */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee addEmployee(JsonObject ob) {
        Session session = HibernateStuff.getInstance().getSessionFactory().openSession();
        session.beginTransaction();
        Position positionToBeAdded;
        String givenPosition = ob.getString("position");
        switch (givenPosition) {
            case "manager":
                positionToBeAdded = Position.MANAGER;
                break;
            case "waiter":
                positionToBeAdded = Position.WAITER;
                break;
            default:
                positionToBeAdded = Position.COOK;
                break;
        }
        Employee e = new Employee(ob.getString("employee_name"), ob.getString("address"), positionToBeAdded);
        session.saveOrUpdate(e);
        session.getTransaction().commit();
        return e;
    }
    
    
    @Path("/{employeeId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployeeById(@PathParam("employeeId") int eId) {
        Session session  = HibernateStuff.getInstance().getSessionFactory().openSession();
        session.beginTransaction();
        List<Employee> e = session.createCriteria(Employee.class).add(Restrictions.eq("employeeId", eId)).list();
        session.getTransaction().commit();
        return e;
    }
}
