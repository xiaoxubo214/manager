package com.wind.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.wind.annotation.BeanProperty;
import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class BaseBean implements Serializable {
    @Id
    @GeneratedValue(
            generator = "paymentableGenerator"
    )
    @GenericGenerator(
            name = "paymentableGenerator",
            strategy = "assigned"
    )
    @Column
    protected Integer id;
    @BeanProperty(
            description = "名称"
    )
    @Column(
            length = 150
    )
    protected String name;
    @BeanProperty(
            description = "英文名称"
    )
    @Column(
            length = 150
    )
    protected String enName;
    @BeanProperty(
            description = "编号"
    )
    @Column(
            length = 30
    )
    protected String number;
    @BeanProperty(
            description = "创建者姓名"
    )
    @Column(
            length = 40
    )
    protected String createdBy;
    @BeanProperty(
            description = "创建日期"
    )
    @Column(
            length = 15
    )
    protected String createDate;
    @BeanProperty(
            description = "创建时间"
    )
    @Column(
            length = 15
    )
    protected String createTime;
    @BeanProperty(
            description = "创建人员id"
    )
    @Column
    protected Integer createrId;
    @BeanProperty(
            description = "操作员id"
    )
    @Column
    protected Integer userId;
    @BeanProperty(
            description = "修改人员姓名"
    )
    @Column(
            length = 40
    )
    protected String modifiedBy;
    @BeanProperty(
            description = "修改人员id"
    )
    @Column
    protected Integer modifiedById;
    @BeanProperty(
            description = "修改时的操作员id"
    )
    @Column
    protected Integer modifyUserId;
    @BeanProperty(
            description = "修改日期"
    )
    @Column(
            length = 16
    )
    protected String modifyDate;
    @BeanProperty(
            description = "修改时间"
    )
    @Column(
            length = 12
    )
    protected String modifyTime;
    @BeanProperty(
            description = "状态"
    )
    @Column(
            length = 10
    )
    protected String status;
    @BeanProperty(
            description = "审核人员id"
    )
    @Column
    protected Integer auditedById;
    @BeanProperty(
            description = "审核人姓名"
    )
    @Column(
            length = 40
    )
    protected String auditedBy;
    @BeanProperty(
            description = "审核日期"
    )
    @Column(
            length = 15
    )
    protected String auditDate;
    @BeanProperty(
            description = "审核时间"
    )
    @Column(
            length = 12
    )
    protected String auditTime;
    @BeanProperty(
            description = "审核状态"
    )
    @Column(
            length = 10
    )
    protected String auditStatus;
    @BeanProperty(
            description = "描述"
    )
    @Column(
            length = 1000
    )
    protected String description;
    @BeanProperty(
            description = "公司id"
    )
    @Column
    protected Integer companyId;
    @BeanProperty(
            description = "部门id"
    )
    @Column
    private Integer departmentId;
    @BeanProperty(
            description = "打印次数"
    )
    @Column
    protected Integer printTimes;
    @BeanProperty(
            description = "记录项的顺序"
    )
    @Column
    protected Integer itemIndex;
    @BeanProperty(
            description = "关联父节点id"
    )
    @Column
    protected Integer parentId;
    @BeanProperty(
            description = "关联第三方系统主键id"
    )
    @Column
    protected Integer thirdSysId;
    @BeanProperty(
            description = "语言类型"
    )
    @Column(
            length = 10
    )
    protected String langKind;
    @BeanProperty(
            description = "工作流程的实例id"
    )
    @Column(
            length = 100
    )
    private String processInstanceId;
    @BeanProperty(
            description = "工作流程的key"
    )
    @Column(
            length = 100
    )
    private String processDefinitionKey;
    @BeanProperty(
            description = "审批人员Id集合"
    )
    @Column(
            length = 200
    )
    private String auditorIds;
    @Version
    @Column(
            name = "OBJ_VERSION"
    )
    private int version = 1;
    @BeanProperty(
            description = "提交数据来源，pc/mobile/flat"
    )
    @Column(
            length = 10
    )
    protected String submitDataSource = "pc";
    @Transient
    protected String recordOperateStatus;
    @BeanProperty(
            description = "用于ComboBox控件素否选中属性"
    )
    @Transient
    private boolean selected = false;
    @Transient
    public String appKey;
    @Transient
    public String parentName;
    @BeanProperty(
            description = "岗位名称"
    )
    @Transient
    public String positionName;
    @BeanProperty(
            description = "自定义字段1"
    )
    @Column(
            length = 50
    )
    private String customField1;
    @BeanProperty(
            description = "自定义字段2"
    )
    @Column(
            length = 50
    )
    private String customField2;
    @BeanProperty(
            description = "自定义字段3"
    )
    @Column(
            length = 50
    )
    private String customField3;
    @BeanProperty(
            description = "自定义字段4"
    )
    @Column(
            length = 50
    )
    private String customField4;

    @BeanProperty(
            description = "自定义字段5"
    )
    @Column(
            length = 50
    )
    private String customField5;

    @Transient
    private String rowSubmitFlag;
    @Transient
    private int hashCode = -2147483648;
    @Transient
    private String workFlowFlag;
    @Transient
    private String deptName;

    public BaseBean() {
    }

    public String getDeptName() {
        return this.deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCustomField3() {
        return this.customField3;
    }

    public void setCustomField3(String customField3) {
        this.customField3 = customField3;
    }

    public String getCustomField5() {
        return this.customField5;
    }

    public void setCustomField5(String customField5) {
        this.customField5 = customField5;
    }

    public String getCustomField4() {
        return this.customField4;
    }

    public void setCustomField4(String customField4) {
        this.customField4 = customField4;
    }

    public String getWorkFlowFlag() {
        return this.workFlowFlag;
    }

    public void setWorkFlowFlag(String workFlowFlag) {
        this.workFlowFlag = workFlowFlag;
    }

    public String getCustomField1() {
        return this.customField1;
    }

    public void setCustomField1(String customField1) {
        this.customField1 = customField1;
    }

    public String getCustomField2() {
        return this.customField2;
    }

    public void setCustomField2(String customField2) {
        this.customField2 = customField2;
    }

    public String getRowSubmitFlag() {
        return this.rowSubmitFlag;
    }

    public void setRowSubmitFlag(String rowSubmitFlag) {
        this.rowSubmitFlag = rowSubmitFlag;
    }

    public String getSubmitDataSource() {
        return this.submitDataSource;
    }

    public void setSubmitDataSource(String submitDataSource) {
        this.submitDataSource = submitDataSource;
    }

    public String getPositionName() {
        return this.positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getAuditorIds() {
        return this.auditorIds;
    }

    public void setAuditorIds(String auditorIds) {
        this.auditorIds = auditorIds;
    }

    public String getProcessInstanceId() {
        return this.processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessDefinitionKey() {
        return this.processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getLangKind() {
        return this.langKind;
    }

    public void setLangKind(String langKind) {
        this.langKind = langKind;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getParentName() {
        return this.parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getModifyUserId() {
        return this.modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Integer getThirdSysId() {
        return this.thirdSysId;
    }

    public void setThirdSysId(Integer thirdSysId) {
        this.thirdSysId = thirdSysId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnName() {
        return this.enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public int getHashCode() {
        return this.hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getCreaterId() {
        return this.createrId;
    }

    public void setCreaterId(Integer createrId) {
        this.createrId = createrId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Integer getModifiedById() {
        return this.modifiedById;
    }

    public void setModifiedById(Integer modifiedById) {
        this.modifiedById = modifiedById;
    }

    public String getModifyDate() {
        return this.modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getPrintTimes() {
        return this.printTimes;
    }

    public void setPrintTimes(Integer printTimes) {
        this.printTimes = printTimes;
    }

    public Integer getItemIndex() {
        return this.itemIndex;
    }

    public void setItemIndex(Integer itemIndex) {
        this.itemIndex = itemIndex;
    }

    public String getRecordOperateStatus() {
        return this.recordOperateStatus;
    }

    public void setRecordOperateStatus(String recordOperateStatus) {
        this.recordOperateStatus = recordOperateStatus;
    }

    public Integer getAuditedById() {
        return this.auditedById;
    }

    public void setAuditedById(Integer auditedById) {
        this.auditedById = auditedById;
    }

    public String getAuditedBy() {
        return this.auditedBy;
    }

    public void setAuditedBy(String auditedBy) {
        this.auditedBy = auditedBy;
    }

    public String getAuditDate() {
        return this.auditDate;
    }

    public void setAuditDate(String auditDate) {
        this.auditDate = auditDate;
    }

    public String getAuditTime() {
        return this.auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    public String getAuditStatus() {
        return this.auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BaseBean) {
            BaseBean object = (BaseBean)obj;
            if (object.getId() == null && this.id == null) {
                return true;
            } else if (object.getId() == null && this.id != null || object.getId() != null && this.id == null) {
                return false;
            } else {
                return object.getId() != null && this.id != null && this.id.intValue() == object.getId().intValue();
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        if (-2147483648 == this.hashCode) {
            if (this.getId() == null) {
                return super.hashCode();
            }

            String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
            this.hashCode = hashStr.hashCode();
        }

        return this.hashCode;
    }
}
