/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Greg
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "thread_type")
public class ThreadType {
    @XmlElement(required = true)
    protected String name;
    @XmlAttribute(name = "date")
    protected String date;
    @XmlAttribute(name = "user")
    protected String user;
    @XmlAttribute(name = "forum")
    protected String forum;
    
    public String getName() {
        return name;
    }
    public void setName(String value) {
        this.name = value;
    }
    public String getUser() {
        return user;
    }
    public void setUser() {
        this.user = user;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String value) {
        this.date = value;
    }
    public String getForum() {
        return forum;
    }
    public void setForum(String value) {
        this.forum = value;
    }
    
}
