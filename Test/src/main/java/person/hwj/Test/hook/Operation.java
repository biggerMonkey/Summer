package person.hwj.Test.hook;

/**
 * @author huangwenjun
 * @Date 2018年3月15日
 */
public class Operation {
    private ListenerInterface listenerInterface;

    public ListenerInterface getListenerInterface() {
        return listenerInterface;
    }

    public void setListenerInterface(ListenerInterface listenerInterface) {
        this.listenerInterface = listenerInterface;
    }

    public void say() {
        this.listenerInterface.say("监听");
    }
}
