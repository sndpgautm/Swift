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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rocke
 */
@Entity
@XmlRootElement
public class Note implements Serializable {
    
    private Long noteId;
    private String message;
    private Employee author;
    
    public Note() {
        this("null", new Employee());
    }
    
    public Note(String msg, Employee author) {
        this.noteId = 0L;
        this.message = msg;
        this.author = author;
    }

    @XmlElement
    @Id
    @GeneratedValue
    public Long getNoteId() {
        return this.noteId;
    }

    @XmlElement
    @Basic
    public String getMessage() {
        return this.message;
    }

    @XmlElement
    @ManyToOne (targetEntity=Employee.class,
            fetch=FetchType.EAGER,
            cascade=CascadeType.ALL)
    public Employee getAuthor() {
        return this.author;
    }

    
    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAuthor(Employee author) {
        this.author = author;
    }
    
    
    
}
