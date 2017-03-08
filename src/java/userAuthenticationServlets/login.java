/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userAuthenticationServlets;

import Model.Employee;
import Model.userAccount;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Util.HibernateStuff;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rocke
 */
@WebServlet("/login")
public class login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Session s = HibernateStuff.getInstance().getSessionFactory().openSession();
        s.beginTransaction();
        List<userAccount> uA = s.createCriteria(userAccount.class).add(Restrictions.eq("username", username)).list();
        System.out.println(uA.size());
        System.out.println("i'm here");
        if (uA.size() > 0) {
            List<Employee> e = s.createCriteria(Employee.class).add(Restrictions.eq("username", username)).list();
            System.out.println(e.size());
            s.getTransaction().commit();
            if (uA.get(0).getUsername().equals(username) && uA.get(0).getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("employeeName", e.get(0).getName());
                session.setAttribute("eId", e.get(0).getEmployeeId());
                session.setAttribute("position", e.get(0).getPosition());
                response.sendRedirect("menu.jsp");
            } else {
                response.sendRedirect("login.html");
            }
            
        } else {
            response.sendRedirect("login.html");
        }

        /*if(!(uA.isEmpty())){
            if(uA.get(0).getUsername().equals(username) && uA.get(0).getPassword().equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("employeeName", e.get(0).getName());
            session.setAttribute("eId", e.get(0).getEmployeeId());
            session.setAttribute("position", e.get(0).getPosition());
            response.sendRedirect("menu.jsp");
        }else{
            response.sendRedirect("login.html");
        }
            response.sendRedirect("login.html");
        }*/
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
