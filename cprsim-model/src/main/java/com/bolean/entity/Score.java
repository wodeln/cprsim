package com.bolean.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="cpr_score")
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //总成绩
    private Float sumGrade;

    //客观评分值
    private Float gradeObj;

    //主观评分值
    private Float gradeSub;

    //满分值
    private Float fullMark;

    //最大用时（单位：秒）
    private Integer sumTime;

    //实际操作时间（单位：秒）
    private Integer opTime;

    //项目名称
    private String project;

    //练习(0x00)，考核(0x01)
    private boolean type;

    //操作成功(0x01),失败(0x00)
    private boolean opSuccess;

    //中断时间(单位：秒)
    private Integer interruptTime;

    //按压比例 CCF > 60%
    private Float CCF;

    //除颤次数
    private Integer defibrNum;

    //按压正确百分比
    private Float pressurePce;

    //breath_pce
    private Float breathPce;

    //按压总次数
    private Integer pSumNum;

    //按压正确次数
    private Integer pRight;

    //按压错误次数
    private Integer pError;

    //按压过大
    private Integer pOver;

    //按压过小
    private Integer pLower;

    //释放不足次数
    private Integer releaseError;

    //按压位置错误次数
    private Integer posError;

    //按压过左
    private Integer posL;

    //按压过右
    private Integer posR;

    //按压过高
    private Integer posT;

    //按压过低
    private Integer posB;

    //按压多按次数
    private Integer pOverNum;

    //按压少按次数
    private Integer pLowerNum;

    //按压正确频率百分百
    private Integer pRatePce;

    //按压平均深度
    private Integer pAverageDepth;

    //吹气总次数
    private Integer bSumNum;

    //吹气正确次数
    private Integer bRight;

    //吹气错误次数
    private Integer bError;

    //吹气过大
    private Integer bOver;

    //吹气过小
    private Integer bLower;

    //气道未开放次数
    private Integer pipeClose;

    //进胃次数
    private Integer stomach;

    //吹气多吹次数
    private Integer bOverNum;

    //吹气少吹次数
    private Integer bLowerNume;

    //用户ID
    private Long userId;

    //联考计划ID
    private Long projectId;

    @Transient
    private String userIds;

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getSumGrade() {
        return sumGrade;
    }

    public void setSumGrade(Float sumGrade) {
        this.sumGrade = sumGrade;
    }

    public Float getGradeObj() {
        return gradeObj;
    }

    public void setGradeObj(Float gradeObj) {
        this.gradeObj = gradeObj;
    }

    public Float getGradeSub() {
        return gradeSub;
    }

    public void setGradeSub(Float gradeSub) {
        this.gradeSub = gradeSub;
    }

    public Float getFullMark() {
        return fullMark;
    }

    public void setFullMark(Float fullMark) {
        this.fullMark = fullMark;
    }

    public Integer getSumTime() {
        return sumTime;
    }

    public void setSumTime(Integer sumTime) {
        this.sumTime = sumTime;
    }

    public Integer getOpTime() {
        return opTime;
    }

    public void setOpTime(Integer opTime) {
        this.opTime = opTime;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean isOpSuccess() {
        return opSuccess;
    }

    public void setOpSuccess(boolean opSuccess) {
        this.opSuccess = opSuccess;
    }

    public Integer getInterruptTime() {
        return interruptTime;
    }

    public void setInterruptTime(Integer interruptTime) {
        this.interruptTime = interruptTime;
    }

    public Float getCCF() {
        return CCF;
    }

    public void setCCF(Float CCF) {
        this.CCF = CCF;
    }

    public Integer getDefibrNum() {
        return defibrNum;
    }

    public void setDefibrNum(Integer defibrNum) {
        this.defibrNum = defibrNum;
    }

    public Float getPressurePce() {
        return pressurePce;
    }

    public void setPressurePce(Float pressurePce) {
        this.pressurePce = pressurePce;
    }

    public Float getBreathPce() {
        return breathPce;
    }

    public void setBreathPce(Float breathPce) {
        this.breathPce = breathPce;
    }

    public Integer getpSumNum() {
        return pSumNum;
    }

    public void setpSumNum(Integer pSumNum) {
        this.pSumNum = pSumNum;
    }

    public Integer getpRight() {
        return pRight;
    }

    public void setpRight(Integer pRight) {
        this.pRight = pRight;
    }

    public Integer getpError() {
        return pError;
    }

    public void setpError(Integer pError) {
        this.pError = pError;
    }

    public Integer getpOver() {
        return pOver;
    }

    public void setpOver(Integer pOver) {
        this.pOver = pOver;
    }

    public Integer getpLower() {
        return pLower;
    }

    public void setpLower(Integer pLower) {
        this.pLower = pLower;
    }

    public Integer getReleaseError() {
        return releaseError;
    }

    public void setReleaseError(Integer releaseError) {
        this.releaseError = releaseError;
    }

    public Integer getPosError() {
        return posError;
    }

    public void setPosError(Integer posError) {
        this.posError = posError;
    }

    public Integer getPosL() {
        return posL;
    }

    public void setPosL(Integer posL) {
        this.posL = posL;
    }

    public Integer getPosR() {
        return posR;
    }

    public void setPosR(Integer posR) {
        this.posR = posR;
    }

    public Integer getPosT() {
        return posT;
    }

    public void setPosT(Integer posT) {
        this.posT = posT;
    }

    public Integer getPosB() {
        return posB;
    }

    public void setPosB(Integer posB) {
        this.posB = posB;
    }

    public Integer getpOverNum() {
        return pOverNum;
    }

    public void setpOverNum(Integer pOverNum) {
        this.pOverNum = pOverNum;
    }

    public Integer getpLowerNum() {
        return pLowerNum;
    }

    public void setpLowerNum(Integer pLowerNum) {
        this.pLowerNum = pLowerNum;
    }

    public Integer getpRatePce() {
        return pRatePce;
    }

    public void setpRatePce(Integer pRatePce) {
        this.pRatePce = pRatePce;
    }

    public Integer getpAverageDepth() {
        return pAverageDepth;
    }

    public void setpAverageDepth(Integer pAverageDepth) {
        this.pAverageDepth = pAverageDepth;
    }

    public Integer getbSumNum() {
        return bSumNum;
    }

    public void setbSumNum(Integer bSumNum) {
        this.bSumNum = bSumNum;
    }

    public Integer getbRight() {
        return bRight;
    }

    public void setbRight(Integer bRight) {
        this.bRight = bRight;
    }

    public Integer getbError() {
        return bError;
    }

    public void setbError(Integer bError) {
        this.bError = bError;
    }

    public Integer getbOver() {
        return bOver;
    }

    public void setbOver(Integer bOver) {
        this.bOver = bOver;
    }

    public Integer getbLower() {
        return bLower;
    }

    public void setbLower(Integer bLower) {
        this.bLower = bLower;
    }

    public Integer getPipeClose() {
        return pipeClose;
    }

    public void setPipeClose(Integer pipeClose) {
        this.pipeClose = pipeClose;
    }

    public Integer getStomach() {
        return stomach;
    }

    public void setStomach(Integer stomach) {
        this.stomach = stomach;
    }

    public Integer getbOverNum() {
        return bOverNum;
    }

    public void setbOverNum(Integer bOverNum) {
        this.bOverNum = bOverNum;
    }

    public Integer getbLowerNume() {
        return bLowerNume;
    }

    public void setbLowerNume(Integer bLowerNume) {
        this.bLowerNume = bLowerNume;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
