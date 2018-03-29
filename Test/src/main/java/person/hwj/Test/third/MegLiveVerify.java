package person.hwj.Test.third;

/**
 * @author huangwenjun
 * @Datetime 2018年2月8日
 */
public class MegLiveVerify {
    private String creditOrderId;
    private byte[] refImage;
    private byte[] bestImage;
    private byte[] envImage;
    private String uuid;
    private String delta;
    private String checkDelta;

    public String getCreditOrderId() {
        return creditOrderId;
    }

    public void setCreditOrderId(String creditOrderId) {
        this.creditOrderId = creditOrderId;
    }

    public byte[] getRefImage() {
        return refImage;
    }

    public void setRefImage(byte[] refImage) {
        this.refImage = refImage;
    }

    public byte[] getBestImage() {
        return bestImage;
    }

    public void setBestImage(byte[] bestImage) {
        this.bestImage = bestImage;
    }

    public byte[] getEnvImage() {
        return envImage;
    }

    public void setEnvImage(byte[] envImage) {
        this.envImage = envImage;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDelta() {
        return delta;
    }

    public void setDelta(String delta) {
        this.delta = delta;
    }

    public String getCheckDelta() {
        return checkDelta;
    }

    public void setCheckDelta(String checkDelta) {
        this.checkDelta = checkDelta;
    }
}
