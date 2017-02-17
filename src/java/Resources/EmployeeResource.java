/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import Model.Employee;
import Util.HibernateStuff;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
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
