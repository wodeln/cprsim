package com.bolean.dao;

import com.bolean.entity.TrainStudent;
import mybatis.basemapper.BaseMapper;

public interface TrainStudentMapper extends BaseMapper<TrainStudent> {
    int deleteByTrainId(String trainId);
}