package person.hwj.Test.tomcat;

import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.startup.Tomcat.FixContextListener;

/**
 * @author huangwenjun
 * @Date 2018年4月2日
 */
public class TomcatDemo {
    static final int port = 9080;
    static final String docBase = "e:/tmp/tomcat";

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.setBaseDir(docBase);
        tomcat.getHost().setAutoDeploy(false);

        String contextPath = "/book";
        StandardContext context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new FixContextListener());
        tomcat.getHost().addChild(context);

        tomcat.addServlet(contextPath, "homeServlet", new HomeServlet());
        context.addServletMappingDecoded("/home", "homeServlet");
        tomcat.start();
        tomcat.getServer().await();
    }
}
