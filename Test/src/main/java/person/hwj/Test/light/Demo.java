package person.hwj.Test.light;



public class Demo {

    public static void main(String[] args) {
        String sendMsg =
                CmdMsgUtils.assembleSendCmd("01", ReadWriteEnum.READ, "BI", Integer.valueOf("25"),
                        1);
        System.out.println(sendMsg);
        // String response = "010101005188";
        // List<String> result = CmdMsgUtils.analysisAnalogCmd(response);
        // List<String> result = CmdMsgUtils.analysisAnalogCmd(response);

        // System.out.println(JSON.toJSONString(result));
        //
        //
        // String info = "123124";
        // System.out.println(info.replace("12", ""));
        // System.out.println(info.indexOf("123"));
    }


}
