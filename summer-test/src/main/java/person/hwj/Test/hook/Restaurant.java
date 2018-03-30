package person.hwj.Test.hook;

/**
 * @author huangwenjun
 * @Date 2018年3月15日
 */
/**
 * 食堂
 */
class Restaurant {
    /**
     * 打饭方法，前提是客户要告知服务员你的饭量，他会根据你的饭量给你“盛”饭
     * 
     * @param client 排队的客户
     * @return
     */
    public void dozenRice(Client client) {
        client.templateMethod();
    }
}
