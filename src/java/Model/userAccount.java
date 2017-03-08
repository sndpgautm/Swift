/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class userAccount implements Serializable {
    private String username;
    private String password;
    
    public userAccount() {
        this("null", "null");
    }
    
    public userAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    @XmlElement
    @Id
    public String getUsername() {
        return this.username;
    }
    
    @XmlElement
    @Basic
    public String getPassword() {
        return this.password;
    }
    
    public void setUsername(String un){
        this.username = un;
    }
    
    public void setPassword(String p){
        this.password = p;
    }
}
