package com.bolean.service;

import com.bolean.entity.Train;
import com.bolean.entity.TrainStudent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainStudentService extends BaseService<TrainStudent> {
    int deleteByTrainId(String trainId);

    List<TrainStudent> selectByTrainId(String trainId);
}
