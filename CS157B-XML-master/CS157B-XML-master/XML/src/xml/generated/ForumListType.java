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
 * @author Greg
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "forumList_type", propOrder = {"forum"})
public class ForumListType {
    protected List<ForumType> forum;
    
    public List<ForumType> getForums() {
        if (forum == null) {
            forum = new ArrayList<ForumType>();
        }
        return this.forum;
    }
    
}
