package com.bolean.dao;

import com.bolean.entity.Student;
import com.bolean.entity.Train;
import mybatis.basemapper.BaseMapper;

import java.util.List;

public interface TrainMapper extends BaseMapper<Train> {
    List<Student> selectStudentLeft(String trainId);

    List<Student> selectStudentRight(String trainId);
}