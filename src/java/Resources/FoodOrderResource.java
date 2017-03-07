/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import Model.Food;
import Model.FoodData;
import Model.FoodOrder;
import Util.HibernateStuff;
import java.util.ArrayList;
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
@Path("/orders")
public class FoodOrderResource {
    
    public FoodOrderResource() {
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FoodOrder> getOrders() {
        Session session = HibernateStuff.getInstance().getSessionFactory().openSession();
        session.beginTransaction();
        List<FoodOrder> orders = session.createCriteria(FoodOrder.class).list();
        for(FoodOrder f : orders){
            System.out.println(f.getItems());
        }
        session.getTransaction().commit();
        return orders;
    }
    
    @Path("/{orderId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FoodOrder> getOrderById(@PathParam("orderId") Long oId) {
        Session session = HibernateStuff.getInstance().getSessionFactory().openSession();
        session.beginTransaction();
        List<FoodOrder> orders = session.createCriteria(FoodOrder.class).add(Restrictions.eq("orderId", oId)).list();
        for(FoodOrder f : orders){
            System.out.println(f.getItems());
        }
        session.getTransaction().commit();
        return orders;
    }
    
    /*Data is sent in json format as
    {"order_status" : "cooked" or "delivered"}
    */
    @Path("/{orderId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<FoodOrder> updateOrderStatus(@PathParam("orderId") Long oId, JsonObject ob) {
        Session session = HibernateStuff.getInstance().getSessionFactory().openSession();
        session.beginTransaction();
        List<FoodOrder> orders = session.createCriteria(FoodOrder.class).add(Restrictions.eq("orderId", oId)).list();
        for(FoodOrder f : orders){
            if(ob.getString("order_status").equals("cooked")){
                f.orderCooked();
            }else if (ob.getString("order_status").equals("delivered")){
                f.orderDelivered();
            }
            System.out.println(f.getItems());
            session.saveOrUpdate(f);
        }
        
        session.getTransaction().commit();
        return orders;
    }
    
    /*DATA is sent in json form as
    {
    "table_No": 11,
    "food_Id": [1, 2]
    }*/
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public FoodOrder addOrder(JsonObject ob) {
        Session session = HibernateStuff.getInstance().getSessionFactory().openSession();
        session.beginTransaction();
        List<Food> foods = new ArrayList<>();
        
        for(int i=0; i < ob.getJsonArray("food_Id").size(); i++){
            int a = ob.getJsonArray("food_Id").getInt(i);
            List tempList = session.createCriteria(Food.class).add(Restrictions.eq("foodId",a)).list();
            foods.addAll(tempList);
            System.out.println(foods);
            
        }
        
        FoodOrder a = new FoodOrder(ob.getInt("table_No"), foods,ob.getString("status"));
        session.saveOrUpdate(a);
        session.getTransaction().commit();
        return a;
    }
    
}
