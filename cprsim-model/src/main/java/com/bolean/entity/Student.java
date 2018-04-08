package com.bolean.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 
 */
@Table(name="cpr_student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    /**
     * 用户姓名
     */
    private String userTrueName;

    /**
     * 性别 1:男 2:女
     */
    private Boolean userSex;

    /**
     * 学历
     */
    private String userDegree;

    /**
     * 身份证
     */
    private String userCardNo;

    /**
     * 单位
     */
    private String userCompany;

    /**
     * 家庭地址
     */
    private String userHomeAddress;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 项目id
     */
    private Integer examId;

    /**
     * 用户联系电话
     */
    private String userPhone;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserTrueName() {
        return userTrueName;
    }

    public void setUserTrueName(String userTrueName) {
        this.userTrueName = userTrueName;
    }

    public Boolean getUserSex() {
        return userSex;
    }

    public void setUserSex(Boolean userSex) {
        this.userSex = userSex;
    }

    public String getUserDegree() {
        return userDegree;
    }

    public void setUserDegree(String userDegree) {
        this.userDegree = userDegree;
    }

    public String getUserCardNo() {
        return userCardNo;
    }

    public void setUserCardNo(String userCardNo) {
        this.userCardNo = userCardNo;
    }

    public String getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(String userCompany) {
        this.userCompany = userCompany;
    }

    public String getUserHomeAddress() {
        return userHomeAddress;
    }

    public void setUserHomeAddress(String userHomeAddress) {
        this.userHomeAddress = userHomeAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Student other = (Student) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserTrueName() == null ? other.getUserTrueName() == null : this.getUserTrueName().equals(other.getUserTrueName()))
            && (this.getUserSex() == null ? other.getUserSex() == null : this.getUserSex().equals(other.getUserSex()))
            && (this.getUserDegree() == null ? other.getUserDegree() == null : this.getUserDegree().equals(other.getUserDegree()))
            && (this.getUserCardNo() == null ? other.getUserCardNo() == null : this.getUserCardNo().equals(other.getUserCardNo()))
            && (this.getUserCompany() == null ? other.getUserCompany() == null : this.getUserCompany().equals(other.getUserCompany()))
            && (this.getUserHomeAddress() == null ? other.getUserHomeAddress() == null : this.getUserHomeAddress().equals(other.getUserHomeAddress()))
            && (this.getUserEmail() == null ? other.getUserEmail() == null : this.getUserEmail().equals(other.getUserEmail()))
            && (this.getExamId() == null ? other.getExamId() == null : this.getExamId().equals(other.getExamId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserTrueName() == null) ? 0 : getUserTrueName().hashCode());
        result = prime * result + ((getUserSex() == null) ? 0 : getUserSex().hashCode());
        result = prime * result + ((getUserDegree() == null) ? 0 : getUserDegree().hashCode());
        result = prime * result + ((getUserCardNo() == null) ? 0 : getUserCardNo().hashCode());
        result = prime * result + ((getUserCompany() == null) ? 0 : getUserCompany().hashCode());
        result = prime * result + ((getUserHomeAddress() == null) ? 0 : getUserHomeAddress().hashCode());
        result = prime * result + ((getUserEmail() == null) ? 0 : getUserEmail().hashCode());
        result = prime * result + ((getExamId() == null) ? 0 : getExamId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userTrueName=").append(userTrueName);
        sb.append(", userSex=").append(userSex);
        sb.append(", userDegree=").append(userDegree);
        sb.append(", userCardNo=").append(userCardNo);
        sb.append(", userCompany=").append(userCompany);
        sb.append(", userHomeAddress=").append(userHomeAddress);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", examId=").append(examId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}