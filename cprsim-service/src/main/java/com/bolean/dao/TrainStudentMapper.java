package com.bolean.dao;

import com.bolean.entity.TrainStudent;
import mybatis.basemapper.BaseMapper;

import java.util.List;

public interface TrainStudentMapper extends BaseMapper<TrainStudent> {
    int deleteByTrainId(String trainId);

    List<TrainStudent> selectByTrainId(String trainId);
}