package com.bolean.service;

import com.bolean.entity.TrainStudent;
import org.springframework.stereotype.Service;

@Service
public interface TrainStudentService extends BaseService<TrainStudent> {
    int deleteByTrainId(String trainId);
}
