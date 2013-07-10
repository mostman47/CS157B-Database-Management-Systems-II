/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author mr.nam
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userDetailsList_type", propOrder = {
    "userDetails"})
public class UserDetailsListType {
    protected List<UserDetailsType> userDetails;
    
    public List<UserDetailsType> getUserDetails() {
        if (userDetails == null) {
            userDetails = new ArrayList<UserDetailsType>();
        }
        return this.userDetails;
    }
}
