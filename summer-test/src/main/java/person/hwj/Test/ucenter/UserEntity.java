package person.hwj.Test.ucenter;

import java.util.Date;

/**
 * 用户信息表
 *
 * @author hwj
 * @date 2017年09月13日
 */
public class UserEntity {

    private Long id;
    /**
     * 员工唯一编码,数据来源EHR
     */
    private String newJobNumber;
    /**
     * 员工以前的工号,数据来源EHR
     */
    private String oldJobNumber;
    /**
     * 真实姓名,数据来源EHR
     */
    private String fullName;
    /**
     * 用户名(1、和员工工号相同,2、为每一位员工创建账号)
     */

    private String userName;
    /**
     * 密码(1、自动随机生成2、账号生成后，自动邮件发送信息)
     */
    private String password;
    /**
     * 支付密码(放款支付等功能需求，需要时设置，默认为空)
     */
    private String paymentPassword;
    /**
     * 所属部门id,数据来源EHR
     */
    private Integer departmentId;
    /**
     * 职务id,数据来源EHR
     */
    private Integer positionId;
    /**
     * 性别（1->男,2->女）,数据来源EHR
     */
    private Integer gender;
    /**
     * 手机号码,数据来源EHR
     */
    private String phoneNum;
    /**
     * 身份证,数据来源EHR
     */
    private String idCard;
    /**
     * 邮箱,数据来源EHR
     */
    private String email;
    /**
     * 工作地点,数据来源EHR
     */
    private String workplace;

    /**
     * 入职时间
     */
    private Date entryTime;

    /**
     * 辞职时间
     */
    private Date resignationTime;
    /**
     * 职务序列,数据来源EHR
     */
    private String jobSequence;
    /**
     * 销售星级,数据来源EHR
     */
    private String salesStars;
    /**
     * 人员状态,数据来自ehr,在职、离职
     */
    private Integer jobStatus;
    /**
     * 账号状态,数据来源EHR
     */
    private Integer accountStatus;
    /**
     * 备注,数据来源EHR
     */
    private String remarks;
    /**
     * 创建人
     */
    private Long createBy;
    /**
     * 更新人
     */
    private Long updateBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标志位 0->未删除 1->删除
     */
    private Byte isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewJobNumber() {
        return newJobNumber;
    }

    public void setNewJobNumber(String newJobNumber) {
        this.newJobNumber = newJobNumber;
    }

    public String getOldJobNumber() {
        return oldJobNumber;
    }

    public void setOldJobNumber(String oldJobNumber) {
        this.oldJobNumber = oldJobNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPaymentPassword() {
        return paymentPassword;
    }

    public void setPaymentPassword(String paymentPassword) {
        this.paymentPassword = paymentPassword;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkplace() {
        return workplace;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getResignationTime() {
        return resignationTime;
    }

    public void setResignationTime(Date resignationTime) {
        this.resignationTime = resignationTime;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getJobSequence() {
        return jobSequence;
    }

    public void setJobSequence(String jobSequence) {
        this.jobSequence = jobSequence;
    }

    public String getSalesStars() {
        return salesStars;
    }

    public void setSalesStars(String salesStars) {
        this.salesStars = salesStars;
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public enum Code {
        NOTDELETE((byte) 0, "未删除"), DELETE((byte) 1, "删除");
        private Byte code;
        private String msg;

        Code(Byte code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Byte getCode() {
            return code;
        }

        public void setCode(Byte code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
