package person.hwj.Test.third;


public class Demo {

    public static void main(String[] args) throws Exception {
        // String info =
        // "{\"errorCode\":200,\"errorMsg\":\"请求成功\",\"uid\":\"20180226121330780zAWayAsdqkJREMc\",\"data\":{\"checkStatus\":\"U\",\"message\":\"服务结果:库中无此号，请到户籍所在地进行核实\"}}";
        // LemonRes<ElementCheckRes> lemonRes =
        // JSON.parseObject(info, new TypeReference<LemonRes<ElementCheckRes>>() {});
        // System.out.println(lemonRes.toString());
        // ElementCheckRes elementCheckRes = lemonRes.getData();
        // System.out.println(elementCheckRes);

        // ByteSource byteSource =
        // Files.asByteSource(new File("C:/Users/Administrator/Desktop/img/idcard.jpeg"));
        // byte[] bytes = byteSource.read();
        // MegLiveVerify megLiveVerify = new MegLiveVerify();
        // megLiveVerify.setBestImage(bytes);
        // megLiveVerify.setEnvImage(bytes);
        // megLiveVerify.setRefImage(bytes);
        // System.out.println(JSON.toJSONString(megLiveVerify));
        testTimedOutException();
    }

    public static void testTimedOutException() {
        int[] nums = new int[1];
        try {
            System.out.println(nums[3]);
        } catch (Exception e) {
            if (e instanceof ArrayIndexOutOfBoundsException) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
