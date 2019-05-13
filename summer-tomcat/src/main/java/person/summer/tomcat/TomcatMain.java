package person.summer.tomcat;


import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import person.summer.context.support.DefaultApplicationContext;
import person.summer.tomcat.servlet.HomeServlet;

/**
 * Hello world!
 *
 */
public class TomcatMain {
    static final int port = 9080;
    static final String docBase = "e:/tmp/tomcat";

    public static void init(DefaultApplicationContext applicationContext) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.setBaseDir(docBase);
        tomcat.getHost().setAutoDeploy(false);

        String contextPath = "";
        StandardContext context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());
        tomcat.getHost().addChild(context);

        tomcat.addServlet(contextPath, "homeServlet", new HomeServlet(applicationContext));
        context.addServletMappingDecoded("/", "homeServlet");
        tomcat.start();
        tomcat.getServer().await();
    }
}
