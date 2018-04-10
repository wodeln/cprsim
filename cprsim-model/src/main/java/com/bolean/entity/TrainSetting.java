package com.bolean.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "cpr_train_setting")
public class TrainSetting implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainSettingId;

    private Integer handleTime;

    private Integer interruptionTime;

    private Integer massageTimePercent;

    private Integer massageRightPercent;

    private Integer ventilateRightPercent;

    private Integer massageFrequencyPercent;

    private int optType;

    private Integer massageSpeedMin;

    private Integer massageSpeedMax;

    private Integer massageDeepMin;

    private Integer massageDeepMax;

    private Integer ventilateTimeMin;

    private Integer ventilateTimeMax;

    private Integer ventilateVolumeMin;

    private Integer ventilateVolumeMax;

    private String rhythm;

    private boolean voicePrompt;

    private int defibrillation;

    private Integer defibrillationTimes;

    private String successCondition;

    private Long trainId;

    public Integer getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Integer handleTime) {
        this.handleTime = handleTime;
    }

    public Long getTrainSettingId() {
        return trainSettingId;
    }

    public void setTrainSettingId(Long trainSettingId) {
        this.trainSettingId = trainSettingId;
    }

    public Integer getInterruptionTime() {
        return interruptionTime;
    }

    public void setInterruptionTime(Integer interruptionTime) {
        this.interruptionTime = interruptionTime;
    }

    public Integer getMassageTimePercent() {
        return massageTimePercent;
    }

    public void setMassageTimePercent(Integer massageTimePercent) {
        this.massageTimePercent = massageTimePercent;
    }

    public Integer getMassageRightPercent() {
        return massageRightPercent;
    }

    public void setMassageRightPercent(Integer massageRightPercent) {
        this.massageRightPercent = massageRightPercent;
    }

    public Integer getVentilateRightPercent() {
        return ventilateRightPercent;
    }

    public void setVentilateRightPercent(Integer ventilateRightPercent) {
        this.ventilateRightPercent = ventilateRightPercent;
    }

    public Integer getMassageFrequencyPercent() {
        return massageFrequencyPercent;
    }

    public void setMassageFrequencyPercent(Integer massageFrequencyPercent) {
        this.massageFrequencyPercent = massageFrequencyPercent;
    }

    public int getOptType() {
        return optType;
    }

    public void setOptType(int optType) {
        this.optType = optType;
    }

    public Integer getMassageSpeedMin() {
        return massageSpeedMin;
    }

    public void setMassageSpeedMin(Integer massageSpeedMin) {
        this.massageSpeedMin = massageSpeedMin;
    }

    public Integer getMassageSpeedMax() {
        return massageSpeedMax;
    }

    public void setMassageSpeedMax(Integer massageSpeedMax) {
        this.massageSpeedMax = massageSpeedMax;
    }

    public Integer getMassageDeepMin() {
        return massageDeepMin;
    }

    public void setMassageDeepMin(Integer massageDeepMin) {
        this.massageDeepMin = massageDeepMin;
    }

    public Integer getMassageDeepMax() {
        return massageDeepMax;
    }

    public void setMassageDeepMax(Integer massageDeepMax) {
        this.massageDeepMax = massageDeepMax;
    }

    public Integer getVentilateTimeMin() {
        return ventilateTimeMin;
    }

    public void setVentilateTimeMin(Integer ventilateTimeMin) {
        this.ventilateTimeMin = ventilateTimeMin;
    }

    public Integer getVentilateTimeMax() {
        return ventilateTimeMax;
    }

    public void setVentilateTimeMax(Integer ventilateTimeMax) {
        this.ventilateTimeMax = ventilateTimeMax;
    }

    public Integer getVentilateVolumeMin() {
        return ventilateVolumeMin;
    }

    public void setVentilateVolumeMin(Integer ventilateVolumeMin) {
        this.ventilateVolumeMin = ventilateVolumeMin;
    }

    public Integer getVentilateVolumeMax() {
        return ventilateVolumeMax;
    }

    public void setVentilateVolumeMax(Integer ventilateVolumeMax) {
        this.ventilateVolumeMax = ventilateVolumeMax;
    }

    public String getRhythm() {
        return rhythm;
    }

    public void setRhythm(String rhythm) {
        this.rhythm = rhythm;
    }

    public boolean isVoicePrompt() {
        return voicePrompt;
    }

    public void setVoicePrompt(boolean voicePrompt) {
        this.voicePrompt = voicePrompt;
    }

    public int getDefibrillation() {
        return defibrillation;
    }

    public void setDefibrillation(int defibrillation) {
        this.defibrillation = defibrillation;
    }

    public Integer getDefibrillationTimes() {
        return defibrillationTimes;
    }

    public void setDefibrillationTimes(Integer defibrillationTimes) {
        this.defibrillationTimes = defibrillationTimes;
    }

    public String getSuccessCondition() {
        return successCondition;
    }

    public void setSuccessCondition(String successCondition) {
        this.successCondition = successCondition;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }
}
