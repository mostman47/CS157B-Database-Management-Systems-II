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
@XmlType(name = "forumPostList_type", propOrder = {
    "forumPost"
})
public class ForumPostListType {
    protected List<ForumPostType> forumPost;
    
    public List<ForumPostType> getPosts() {
        if (forumPost == null) {
            forumPost = new ArrayList<ForumPostType>();
        }
        return this.forumPost;
    }
    
}
