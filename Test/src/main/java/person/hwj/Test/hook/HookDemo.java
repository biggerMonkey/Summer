package person.hwj.Test.hook;

/**
 * @author huangwenjun
 * @Date 2018年3月15日
 */
public class HookDemo {
    public static void main(String[] args) {
        Restaurant waiter = new Restaurant();
        waiter.dozenRice(new Client() {
            @Override
            protected void before() {
                System.out.println("对服务员吹胡子瞪眼！！");
            }

            @Override
            public void appetite() {
                System.out.println("盛了一锅米饭");
            }
        });

    }
}
