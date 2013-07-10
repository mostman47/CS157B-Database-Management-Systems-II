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
@XmlType(name = "threadList_type", propOrder = {
    "thread"
})
public class ThreadListType {
    protected List<ThreadType> thread;
    
    public List<ThreadType> getThreads() {
        if (thread == null) {
            thread = new ArrayList<ThreadType>();
        }
        return this.thread;
    }
    
}
