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
@XmlType(name = "forumPost_type")
public class ForumPostType {
    @XmlElement(required = true)
    protected String user;
    @XmlElement(required = true)
    protected String thread;
    @XmlElement(required = true)
    protected String content;
    
    public String getUser() {
        return user;
    }
    public void setUser(String value) {
        this.user = user;
    }
    public String getThread() {
        return thread;
    }
    public void setThread(String value) {
        this.thread = thread;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String value) {
        this.content = content;
    }
}
