package person.hwj.Test.ucenter;

import java.util.Date;

/**
 * 职务表
 * 
 * @author hwj
 * @date 2017年09月13日
 */
public class DutiesEntity {

    private Integer id;
    /**
     * 集合ID,用来区分是哪个事业部的职务,数据来源EHR
     */
    private String groupId;
    /**
     * 职务代码,数据来源EHR
     */
    private String jobCode;
    /**
     * 职务名称,数据来源EHR
     */
    private String jobTitle;
    /**
     * 职务简称,数据来源EHR
     */
    private String jobShortTitle;
    /**
     * 职务序列,1、EHR中自定义的，例如：管理序列、销售序列,2、如果我们需要，可以提需求，建议我们先保留此逻辑,数据来源EHR
     */
    private String jobSequence;
    /**
     * 职务状态1、枚举：有效、无效,数据来源EHR
     */
    private Byte dutiesStatus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建人
     */
    private Integer createBy;
    /**
     * 更新人
     */
    private Integer updateBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobShortTitle() {
        return jobShortTitle;
    }

    public void setJobShortTitle(String jobShortTitle) {
        this.jobShortTitle = jobShortTitle;
    }

    public String getJobSequence() {
        return jobSequence;
    }

    public void setJobSequence(String jobSequence) {
        this.jobSequence = jobSequence;
    }

    public Byte getDutiesStatus() {
        return dutiesStatus;
    }

    public void setDutiesStatus(Byte dutiesStatus) {
        this.dutiesStatus = dutiesStatus;
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

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

}
