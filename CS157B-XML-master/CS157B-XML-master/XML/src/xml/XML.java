/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;
import java.io.File;
import java.util.List;
import javax.xml.bind.*;
import xml.generated.*;


/**
 *
 * @author Greg
 */
public class XML {

    /**
     * @param args the command line arguments
     */
    public void unMarshall(File xmlDocument) 
    {
        
       Class klasses[] = {Forum.class, Thread.class, MyForumPost.class,
                            User.class, UserDetails.class};
       HibernateContext.addClasses(klasses);
       HibernateContext.createSchema();
       
        File forumXML = new File("forum.xml");
        File postsXML = new File("forumPosts.xml");
        File userXML = new File("user.xml");
        File userDetailsXML = new File("userDetails.xml");
	try {
            
            JAXBContext jaxbContext = 
                JAXBContext.newInstance("xml.generated");
            Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
            //userdetails
            JAXBElement<UserDetailsListType> userDetailsListElement = 
                (JAXBElement<UserDetailsListType>) unMarshaller.unmarshal(userDetailsXML);
            UserDetailsListType userDetailsContainer = userDetailsListElement.getValue();
            List<UserDetailsType> userDetailsList = userDetailsContainer.getUserDetails();
            for (UserDetailsType userDetails : userDetailsList) {
                UserDetails.addUserDetails(userDetails.getEmail().trim());//add to database
                
		System.out.printf("\n    UserDetails email = '%s'\n",
                userDetails.getEmail().trim());
            }
           
           
          
            
            //forum
            JAXBElement<ForumListType> forumListElement = 
                (JAXBElement<ForumListType>) unMarshaller.unmarshal(forumXML);
            ForumListType forumContainer = forumListElement.getValue();
            List<ForumType> forumList = forumContainer.getForums();
            for (ForumType forum : forumList) {
                Forum.addForum(forum.getName().trim());//add to database
                
		System.out.printf("\n    Forum name = '%s'\n",
                forum.getName().trim());
            }
            
            
            //thread
            JAXBElement<ThreadListType> threadListElement = 
                (JAXBElement<ThreadListType>) unMarshaller.unmarshal(xmlDocument);
            ThreadListType threadContainer = threadListElement.getValue();
            List<ThreadType> threadList = threadContainer.getThreads();
                
            for (ThreadType thread : threadList) {
                Thread.addThread(thread.getName().trim(), thread.getForum());
		System.out.printf("\n    THREAD name = '%s'\n",
                thread.getName().trim());
		System.out.printf("           user = '%s'\n", thread.getUser());
		System.out.printf("           date = '%s'\n", thread.getDate());
		System.out.printf("           forum = '%s'\n", 
                        thread.getForum());
            }
            
            //user
             JAXBElement<UserListType> userListElement = 
                (JAXBElement<UserListType>) unMarshaller.unmarshal(userXML);
            UserListType userContainer = userListElement.getValue();
            List<UserType> userList = userContainer.getUserList();
            for (UserType user : userList) {
                User.addUser(user.getName().trim(),user.getEmail().trim());//add to database
                //UserDetails u = UserDetails.find("mac@email.com");
                //System.out.println(u.getEmailAddress());
		System.out.printf("\n    User name = '%s' + email = '%s'\n",
                user.getName().trim(),user.getEmail().trim());
            }
            //posts
            JAXBElement<ForumPostListType> forumPostListElement = 
                (JAXBElement<ForumPostListType>) unMarshaller.unmarshal(postsXML);
            ForumPostListType forumPostsContainer = forumPostListElement.getValue();
            List<ForumPostType> postList = forumPostsContainer.getPosts();
            for (ForumPostType post : postList) {
                MyForumPost.addForumPost(post.getContent(), post.getUser(), post.getThread());
                
//		System.out.printf("\n    Post content = '%s'\n",
//                post.getContent());
//                System.out.printf("\n         user    = '%s'\n",
//                post.getUser());
//                System.out.printf("\n         thread  = '%s'\n",
//                post.getThread());
            }
             
	} 
        catch (JAXBException ex) {
            ex.printStackTrace();
	}
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        File xmlDocument = new File("thread.xml");
        XML jaxbUnmarshaller = new XML();
        jaxbUnmarshaller.unMarshall(xmlDocument);
        
    }
}
