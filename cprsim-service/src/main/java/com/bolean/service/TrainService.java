package com.bolean.service;


import com.bolean.entity.Student;
import com.bolean.entity.Train;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TrainService extends BaseService<Train>{
    List<Train> selectByInfo(Map<String, Object> map);

    List<Train> selectByInfo(Train train);

    int batchDel(Map<String, Object> map);

    List<Student> selectStudentLeft(String trainId);

    List<Student> selectStudentRight(String trainId);
}
