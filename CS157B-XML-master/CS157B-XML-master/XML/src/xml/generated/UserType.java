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
 * @author mr.nam
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user_type")
public class UserType {
    @XmlElement(required = true)
    protected String name;
    @XmlAttribute(name = "email")
    protected String email;
    
    public String getName() {
        return name;
    }
    public void setName(String value) {
        this.name = value;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
   
}
