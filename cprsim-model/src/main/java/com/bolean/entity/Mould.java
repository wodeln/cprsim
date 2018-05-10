package com.bolean.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Table(name="cpr_mould")
public class Mould implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mId;

    /**
     * 模型名称/设备名称
     */
    private String mName;

    /**
     * 模型型号
     */
    private String mVersion;

    /**
     * 编码
     */
    private String mSerialNumber;

    /**
     * 编码
     */
    private String mNo;

    /**
     * 购买时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date mBuyTime;

    /**
     * 保修期
     */
    private String mRepairDays;

    /**
     * 存放地点
     */
    private String mPlace;

    /**
     * 使用次数
     */
    private Integer mUseTime;

    /**
     * 维修电话
     */
    private String mRepairTel;

    private Integer mStatus;

    private static final long serialVersionUID = 1L;

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmVersion() {
        return mVersion;
    }

    public void setmVersion(String mVersion) {
        this.mVersion = mVersion;
    }

    public String getmNo() {
        return mNo;
    }

    public void setmNo(String mNo) {
        this.mNo = mNo;
    }

    public Date getmBuyTime() {
        return mBuyTime;
    }

    public void setmBuyTime(Date mBuyTime) {
        this.mBuyTime = mBuyTime;
    }

    public String getmRepairDays() {
        return mRepairDays;
    }

    public void setmRepairDays(String mRepairDays) {
        this.mRepairDays = mRepairDays;
    }

    public String getmPlace() {
        return mPlace;
    }

    public void setmPlace(String mPlace) {
        this.mPlace = mPlace;
    }

    public Integer getmUseTime() {
        return mUseTime;
    }

    public void setmUseTime(Integer mUseTime) {
        this.mUseTime = mUseTime;
    }

    public String getmRepairTel() {
        return mRepairTel;
    }

    public void setmRepairTel(String mRepairTel) {
        this.mRepairTel = mRepairTel;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getmSerialNumber() {
        return mSerialNumber;
    }

    public void setmSerialNumber(String mSerialNumber) {
        this.mSerialNumber = mSerialNumber;
    }

    public Integer getmStatus() {
        return mStatus;
    }

    public void setmStatus(Integer mStatus) {
        this.mStatus = mStatus;
    }
}