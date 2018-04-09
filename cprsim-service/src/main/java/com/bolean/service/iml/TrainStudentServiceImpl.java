package com.bolean.service.iml;

import com.bolean.dao.TrainStudentMapper;
import com.bolean.entity.TrainStudent;
import com.bolean.service.TrainStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("TrainStudentService")
public class TrainStudentServiceImpl implements TrainStudentService {

    @Autowired
    TrainStudentMapper trainStudentMapper;

    @Override
    public List<TrainStudent> selectAll() {
        return null;
    }

    @Override
    public List<TrainStudent> select(TrainStudent trainStudent) {
        return null;
    }

    @Override
    public TrainStudent selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public TrainStudent selectOne(TrainStudent trainStudent) {
        return null;
    }

    @Override
    public int insert(TrainStudent trainStudent) {
        return 0;
    }

    @Override
    public int insertSelective(TrainStudent trainStudent) {
        return 0;
    }

    @Override
    public int insertList(List<TrainStudent> trainStudents) {
        return trainStudentMapper.insertList(trainStudents);
    }

    @Override
    public int updateByPrimaryKey(TrainStudent trainStudent) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(TrainStudent trainStudent) {
        return 0;
    }

    @Override
    public int selectCount(TrainStudent trainStudent) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public List<TrainStudent> selectByInfo(TrainStudent trainStudent) {
        return null;
    }

    @Override
    public List<TrainStudent> selectByInfo(Map<String, Object> map) {
        return null;
    }

    @Override
    public int deleteByTrainId(String trainId) {
        return trainStudentMapper.deleteByTrainId(trainId);
    }
}
