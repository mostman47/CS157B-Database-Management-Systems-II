/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author mr.nam
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userDetails_type" )
public class UserDetailsType {
    @XmlElement(required = true)
    protected String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String emailaddress) {
        this.email = emailaddress;
    }
    
}
