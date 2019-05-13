package person.summer.tomcat.servlet;

import person.summer.context.ApplicationContext;
import person.summer.core.env.ControllerClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: huangwenjun
 * @Date: 2019/5/9 17:24
 */
public class HomeServlet extends HttpServlet {

    private ApplicationContext applicationContext;

    public HomeServlet(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String url = req.getRequestURI();
            System.out.println(url);
            ControllerClass controllerClass = applicationContext.getControlleClass(url);
            Object object = controllerClass.getClassInfo().newInstance();
            controllerClass.getMethod().invoke(object);
            System.out.println("request scheme: " + req.getRequestURI());
            resp.getWriter().print("hello tomcat");
        }
        catch (Exception e){

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("request scheme: " + req.getRequestURI());
        resp.getWriter().print("hello tomcat");
    }
}
