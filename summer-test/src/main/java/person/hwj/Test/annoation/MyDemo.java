package person.hwj.Test.annoation;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;

import person.summer.beans.annotation.Autowired;

import com.alibaba.fastjson.JSON;

/**
 * @author huangwenjun
 * @Date 2018年3月22日
 */
public class MyDemo {

    public static void main(String[] args) throws Exception {
        String className = MyDemo.class.getName();
        System.out.println(className);
        String packageName = className.substring(0, className.lastIndexOf("."));
        System.out.println(MyDemo.class.getPackage().getName());
        // 使用类加载器加载类
        Class<?> c = Class.forName("person.hwj.Test.annoation.MyTest");

        System.out.println("c==" + JSON.toJSONString(c));
        // 找到类上面的注解
        boolean isExist = c.isAnnotationPresent(MyAnnoation.class);
        // 上面的这个方法是用这个类来判断这个类是否存在Description这样的一个注解
        if (isExist) {
            // 拿到注解实例，解析类上面的注解
            MyAnnoation d = (MyAnnoation) c.getAnnotation(MyAnnoation.class);
            System.out.println(d.info());
        }
        // 获取所有的方法
        Method[] ms = c.getMethods();
        // 遍历所有的方法
        for (Method m : ms) {
            boolean isExist1 = m.isAnnotationPresent(Autowired.class);
            if (isExist1) {
                Autowired d1 = m.getAnnotation(Autowired.class);
                System.out.println(d1.info());
            }
        }
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof MyAnnoation) {
                    MyAnnoation myAnnoation = (MyAnnoation) annotation;
                    System.out.println("oooo:" + myAnnoation.info());
                } else if (annotation instanceof Autowired) {
                    Autowired autowired = (Autowired) annotation;
                    System.out.println("oooo:" + autowired.info());
                }
            }
            boolean isExist1 = field.isAnnotationPresent(Autowired.class);
            if (isExist1) {
                Autowired d1 = field.getAnnotation(Autowired.class);
                System.out.println(d1.info());
            }
        }
        getClasses();
    }

    public static void getClasses() throws Exception {
        String packageName = "person.hwj.Test.annoation";
        // Enumeration<URL> dirs =
        // Thread.currentThread().getContextClassLoader().getResources(packageName);
        Enumeration<URL> dirs = ClassLoader.getSystemResources(packageName.replace(".", "/"));
        System.out.println(dirs.hasMoreElements());
        while (dirs.hasMoreElements()) {
            ;
            URL url = (URL) dirs.nextElement();
            System.out.println("info=" + url.getPath() + " " + url.getProtocol());
            // 获取包的物理路径
            String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
            System.out.println(filePath);
            // 第一个class类的集合
            Set<Class<?>> classes = new LinkedHashSet<>();
            // 是否循环迭代
            boolean recursive = true;
            findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
            for (Class<?> class1 : classes) {
                System.out.println(class1.getName());
            }
        }
    }

    public static void findAndAddClassesInPackageByFile(String packageName, String packagePath,
            final boolean recursive, Set<Class<?>> classes) {
        // 获取此包的目录 建立一个File
        File dir = new File(packagePath);
        // 如果不存在或者 也不是目录就直接返回
        if (!dir.exists() || !dir.isDirectory()) {
            // log.warn("用户定义包名 " + packageName + " 下没有任何文件");
            return;
        }
        // 如果存在 就获取包下的所有文件 包括目录
        File[] dirfiles = dir.listFiles(new FileFilter() {
            // 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
            public boolean accept(File file) {
                return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
            }
        });
        // 循环所有文件
        for (File file : dirfiles) {
            // 如果是目录 则继续扫描
            if (file.isDirectory()) {
                findAndAddClassesInPackageByFile(packageName + "." + file.getName(),
                        file.getAbsolutePath(), recursive, classes);
            } else {
                // 如果是java类文件 去掉后面的.class 只留下类名
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                    // 添加到集合中去
                    // classes.add(Class.forName(packageName + '.' + className));
                    // 经过回复同学的提醒，这里用forName有一些不好，会触发static方法，没有使用classLoader的load干净
                    classes.add(Thread.currentThread().getContextClassLoader()
                            .loadClass(packageName + '.' + className));
                } catch (ClassNotFoundException e) {
                    // log.error("添加用户自定义视图类错误 找不到此类的.class文件");
                    e.printStackTrace();
                }
            }
        }
    }
}
