/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rocke
 */
@XmlRootElement
@Entity
public class Employee implements Serializable {
    
    private int employeeId;
    private String name;
    private Position position;
    private String address;
    private String username;
    
    public Employee() {
        this("unknown", "unknown", null, "null");
    }
    
    public Employee(String name, String address, Position p, String u) {
        this.employeeId = 0;
        this.name = name;
        this.address = address;
        this.position = p;
        this.username = u;
    }
    
    @XmlElement
    @Id
    @GeneratedValue
    public int getEmployeeId() {
        return this.employeeId;
    }
    
    @XmlElement
    @Basic
    public String getName() {
        return this.name;
    }
    
    @XmlElement
    @Basic
    public String getAddress() {
        return this.address;
    }
    
    @XmlElement
    @Enumerated(EnumType.ORDINAL)
    public Position getPosition() {
        return this.position;
    }

    @XmlElement
    @Basic
    public String getUsername() {
        return this.username;
    }

    
    
    public void setUsername(String a) {
        this.username = a;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    
    


    
    
}
