package person.summer.context.support;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author huangwenjun
 * @Date 2018年3月30日
 */
public class ClassPathBeanDefinitionScanner {

    public Set<Class<?>> scan(String... basePackages) throws Exception {
        // DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        Set<Class<?>> classes = new LinkedHashSet<>();
        for (String packageName : basePackages) {
            Enumeration<URL> dirs = ClassLoader.getSystemResources(packageName.replace(".", "/"));
            while (dirs.hasMoreElements()) {
                ;
                URL url = (URL) dirs.nextElement();
                // 获取包的物理路径
                String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                // 第一个class类的集合
                // 是否循环迭代
                boolean recursive = true;
                findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
            }
        }
        return classes;
    }

    private void findAndAddClassesInPackageByFile(String packageName, String packagePath,
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
