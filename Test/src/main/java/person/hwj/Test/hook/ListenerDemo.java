package person.hwj.Test.hook;

/**
 * @author huangwenjun
 * @Date 2018年3月15日
 */
public class ListenerDemo {
    public static void main(String[] args) {
        Operation operation = new Operation();
        operation.setListenerInterface(new ListenerInterface() {

            @Override
            public void say(String info) {
                System.out.println("我说：我正在被" + info);

            }
        });
        operation.say();
    }
}
