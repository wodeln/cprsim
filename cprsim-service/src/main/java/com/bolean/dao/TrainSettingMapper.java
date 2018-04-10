package com.bolean.dao;

import com.bolean.entity.TrainSetting;
import mybatis.basemapper.BaseMapper;

public interface TrainSettingMapper extends BaseMapper<TrainSetting> {
    TrainSetting selectByTrainId(String trainId);

    int deleteByTrainId(String trainId);
}
