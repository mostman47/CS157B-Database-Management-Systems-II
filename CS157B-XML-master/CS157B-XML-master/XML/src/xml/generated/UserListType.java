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
@XmlType(name = "userList_type", propOrder = {
    "user"
})
public class UserListType {
     protected List<UserType> user;
    
    public List<UserType> getUserList() {
        if (user == null) {
            user = new ArrayList<UserType>();
        }
        return this.user;
    }
}
