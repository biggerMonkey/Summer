package person.hwj.Test.hook;

/**
 * @author huangwenjun
 * @Date 2018年3月15日
 */
/**
 * 模板方法模式：在一个方法中定义一个算法的骨架，而将一些步 骤延迟到子类中。模板方法使得子类可以在不改变算法结构的情 况下，重新定义算法中的某些步骤。
 * 【钩子方法】：原理就是实现为空的方法，在某任务之前、之后、 执行中、报异常后调用的方法（是不是有种熟悉的感觉）。 通常钩子方法是通过抽象类或是本类中的空方法来实现的。
 *
 */
abstract class Client {
    /**
     * 【模板方法】
     */
    public void templateMethod() {
        before();
        appetite();
        after();
    }

    /**
     * 【钩子方法】在盛饭前（一个空的实现）
     */
    protected void before() {};

    /**
     * 【抽象方法】告诉服务员其饭量
     * 
     * @return 饭量
     */
    public abstract void appetite();

    /**
     * 【具体方法】盛饭后
     */
    private void after() {
        // 实际项目这里是共有的业务逻辑
        System.out.println("拿筷子，找桌子，开吃...");
    }
}
