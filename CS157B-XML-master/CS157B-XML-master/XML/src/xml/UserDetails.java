package xml;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan
 */
@Entity
@Table(name = "UserDetails")
public class UserDetails {

    
    
    private long id;
    private String emailAddress;
    
    public UserDetails(){}
    
    public UserDetails(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }
    
    @Id
    @GeneratedValue
    @Column(name="id")
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    
    @Column(name="emailAddress")
    public String getEmailAddress() {return emailAddress;}
    public void setEmailAddress(String address) 
    {
        this.emailAddress = address;
    } 
    static void addUserDetails(String email) {
            Session session = HibernateContext.getSession();
            UserDetails userDetails = new UserDetails(email);
            Transaction tx = session.beginTransaction(); 
            {
                session.save(userDetails);
            }
            tx.commit();
            session.close();
            
    }

    public static UserDetails find(String email) {
            Session session = HibernateContext.getSession();
            Query query = session.createQuery("from UserDetails where emailAddress = :emailvar");
            query.setString("emailvar", email);
            UserDetails userDetails = (UserDetails) query.uniqueResult();
            //System.out.printf("Name you searched for: %s\n", name);
            session.close();
            return userDetails;
    }
}
