package person.hwj.Test.third;

/**
 * @author huangwenjun
 * @Datetime 2018年2月1日
 */
public class ElementCheckRes {
    private String checkStatus;// S成功，F失败，U未知
    private String message;

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
