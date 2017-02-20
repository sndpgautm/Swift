/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import Model.Employee;
import Model.Note;
import Util.HibernateStuff;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import javax.json.JsonObject;

/**
 *
 * @author Rocke
 */
@Path("/notes")
public class NoteResource {
    
    public NoteResource() {}
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Note> getNotes() {
        Session session = HibernateStuff.getInstance().getSessionFactory().openSession();
        session.beginTransaction();
        List<Note> notes = session.createCriteria(Note.class).list();
        session.getTransaction().commit();
        return notes;
    }
    
    /*Data is sent in format
    {   "employee_id" : 123   
        "message" : "example message"
    }*/
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Note addNote(JsonObject ob) {
        Session session = HibernateStuff.getInstance().getSessionFactory().openSession();
        session.beginTransaction();
        List<Employee> employee = session.createCriteria(Employee.class).add(Restrictions.eq("employeeId", ob.getInt("employee_id"))).list();
        Note noteToBeAdded = new Note(ob.getString("message"), employee.get(0));
        session.saveOrUpdate(noteToBeAdded);
        session.getTransaction().commit();
        return noteToBeAdded;
    }
    
    @Path("/{noteId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Note> getNoteByID(@PathParam("noteId") Long id ){
        Session session = HibernateStuff.getInstance().getSessionFactory().openSession();
        session.beginTransaction();
        List<Note> notes = session.createCriteria(Note.class).add(Restrictions.eq("noteId", id)).list();
        session.getTransaction().commit();
        return notes;
    }
    
    // Work on progress
    /*Data is sent in format
    {   "note_id" : 123   
        "new_message" : "example message"
    }
    @Path("/{noteId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Note> editNote(@)*/
    
    @Path("employeeId/{employeeId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Note> getNotesByEmployeeId(@PathParam("employeeId") int eId){
        Session session = HibernateStuff.getInstance().getSessionFactory().openSession();
        session.beginTransaction();
        List<Employee> eList = session.createCriteria(Employee.class).add(Restrictions.eq("employeeId", eId)).list();
        Employee eTemp = eList.get(0);
        List<Note> notes = session.createCriteria(Note.class).add(Restrictions.eq("author", eTemp)).list();
        session.getTransaction().commit();
        return notes;
    }
    
}
