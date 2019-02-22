package fr.epsi.jeeProject.Listener;

import fr.epsi.jeeProject.beans.Blog;
import fr.epsi.jeeProject.beans.Utilisateur;
import fr.epsi.jeeProject.dao.IBlogDao;
import fr.epsi.jeeProject.dao.mockImpl.MockBlogDao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.List;

@WebListener()
public class StartupListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public StartupListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        System.out.println("Démarrage application");
        IBlogDao blogDao = new MockBlogDao();
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail("t.b@epsi.fr");
        List<Blog> listOfBlogs = blogDao.getBlogs(utilisateur);
        System.out.println("nb blogs = " + listOfBlogs.size());
    }
}
