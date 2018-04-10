package com.bolean.service;

import com.bolean.entity.TrainSetting;
import org.springframework.stereotype.Service;

@Service
public interface TrainSettingService extends BaseService<TrainSetting> {

    TrainSetting selectByTrainId(String trainId);

    int deleteByTrainId(String trainId);
}
