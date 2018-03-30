package person.hwj.Test.ucenter;

import java.util.Date;

/**
 * 部门表
 * 
 * @author hwj
 * @date 2017年09月13日
 */
public class DepartmentEntity {

    private int id;
    /**
     * 部门编码,数据来源EHR
     */
    private String departmentCode;
    /**
     * 生效日期,数据来源EHR
     */
    private Date effectiveDate;
    /**
     * 部门名称,数据来源EHR
     */
    private String departmentName;
    /**
     * 部门简称,数据来源EHR
     */
    private String departmentAbbreviation;
    /**
     * 部门状态1,数据来源EHR
     */
    private int departmentStatus1;
    /**
     * 部门状态2
     */
    private int departmentStatus2;
    /**
     * 上级部门id,数据来源EHR
     */
    private String parentId;
    /**
     * 第一部门负责人,数据来源EHR
     */
    private String firstPrincipal;
    /**
     * 第二部门负责人,数据来源EHR
     */
    private String secondaryPrincipal;
    /**
     * 第三部门负责人,数据来源EHR
     */
    private String threePrincipal;
    /**
     * 备注
     */
    private String remarks;
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
    private int createBy;
    /**
     * 更新人
     */
    private int updateBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAbbreviation() {
        return departmentAbbreviation;
    }

    public void setDepartmentAbbreviation(String departmentAbbreviation) {
        this.departmentAbbreviation = departmentAbbreviation;
    }

    public int getDepartmentStatus1() {
        return departmentStatus1;
    }

    public void setDepartmentStatus1(int departmentStatus1) {
        this.departmentStatus1 = departmentStatus1;
    }

    public int getDepartmentStatus2() {
        return departmentStatus2;
    }

    public void setDepartmentStatus2(int departmentStatus2) {
        this.departmentStatus2 = departmentStatus2;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getFirstPrincipal() {
        return firstPrincipal;
    }

    public void setFirstPrincipal(String firstPrincipal) {
        this.firstPrincipal = firstPrincipal;
    }

    public String getSecondaryPrincipal() {
        return secondaryPrincipal;
    }

    public void setSecondaryPrincipal(String secondaryPrincipal) {
        this.secondaryPrincipal = secondaryPrincipal;
    }

    public String getThreePrincipal() {
        return threePrincipal;
    }

    public void setThreePrincipal(String threePrincipal) {
        this.threePrincipal = threePrincipal;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }

}
