package person.hwj.Test.light;

/**
 * @author huangwenjun
 * @Datetime 2018年1月26日
 */
public enum ReadWriteEnum {
        READ(0), WRITE(1);

    private int code;

    /**
     * @param code
     * @Datetime 2018年1月26日
     */
    private ReadWriteEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
