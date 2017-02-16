/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import Model.Food;
import Model.FoodData;
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
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;

/**
 * REST Web Service
 *
 * @author Rocke
 */
@Path("/foods")
public class FoodResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public FoodResource() {
    }

    /**
     * Retrieves representation of an instance of restAppConfig.FoodResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getJson() {
        Session session = HibernateStuff.getInstance().getSessionFactory().openSession();
        session.beginTransaction();
        System.out.println("im here");
        ArrayList<Food> a = new FoodData().getMenu();
        System.out.println(a);
        System.out.println("i am also here");
        return "done";
    }
}
