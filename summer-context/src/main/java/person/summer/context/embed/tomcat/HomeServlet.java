package person.summer.context.embed.tomcat;

import com.alibaba.fastjson.JSON;
import person.summer.context.ApplicationContext;
import person.summer.core.env.ControllerClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;

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
        common(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        common(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        common(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        common(req, resp);
    }

    // 参数处理 uri ？ json
    private void common(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String url = req.getRequestURI();
            url = url.replace("//", "/");
            String method = req.getMethod();
            resp.setCharacterEncoding("utf8");
            resp.setContentType("application/json; charset=utf-8");
            ControllerClass controllerClass = applicationContext.getControlleClass(url);
            if (controllerClass == null) {
                resp.getWriter().print("autowire field");
                return;
            }
            if (!method.toUpperCase().equals(controllerClass.getMethodEnum().getName())) {
                resp.getWriter().print("method not allowed,must be " + controllerClass.getMethodEnum().getName() + " not " + method);
                return;
            }
            Object object = applicationContext.getBean(controllerClass.getClassInfo());
            for(Annotation[] annotations:controllerClass.getMethod().getParameterAnnotations()){
                for(Annotation annotation:annotations){
                    System.out.println(annotation.annotationType().getSimpleName());
                }
            }
            for (Parameter parameter : controllerClass.getMethod().getParameters()) {
                Annotation[] paramAnnotation = parameter.getAnnotations();
                System.out.println(paramAnnotation.length);
                String param = req.getParameter(parameter.getName());
                System.out.println(param);
                // if (param == null) {
                // resp.getWriter().print("parm: " + parameter.getName() + " not found");
                // return;
                // }
            }
            Object returnInfo = controllerClass.getMethod().invoke(object);

            if (controllerClass.getMethod().getReturnType() == String.class) {
                resp.getWriter().print(returnInfo);
                return;
            }
            resp.getWriter().print(JSON.toJSONString(returnInfo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
