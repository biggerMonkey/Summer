package person.hwj.Test.third;

/**
 * @author huangwenjun
 * @Datetime 2018年2月1日
 */
public class LemonRes<T> {
    private String errorCode;
    private String errorMsg;
    private String uid;
    private T data;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LemonRes [errorCode=" + errorCode + ", errorMsg=" + errorMsg + ", uid=" + uid
                + ", data=" + data + "]";
    }
}
