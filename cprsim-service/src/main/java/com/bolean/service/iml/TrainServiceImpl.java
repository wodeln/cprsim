package com.bolean.service.iml;

import com.bolean.dao.TrainMapper;
import com.bolean.entity.Train;
import com.bolean.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("TrainService")
public class TrainServiceImpl implements TrainService {
    @Autowired
    private TrainMapper trainMapper;


    @Override
    public List<Train> selectByInfo(Map<String, Object> map) {
        return trainMapper.selectByInfo(map);
    }

    @Override
    public List<Train> selectByInfo(Train train) {
        return trainMapper.selectByInfo(train);
    }

    @Override
    public List<Train> selectAll() {
        return trainMapper.selectAll();
    }

    @Override
    public List<Train> select(Train train) {
        return trainMapper.select(train);
    }

    @Override
    public Train selectByPrimaryKey(Long id) {
        return trainMapper.selectByPrimaryKey(id);
    }

    @Override
    public Train selectOne(Train train) {
        return trainMapper.selectOne(train);
    }

    @Override
    public int insert(Train train) {
        return trainMapper.insert(train);
    }

    @Override
    public int insertSelective(Train train) {
        return trainMapper.insertSelective(train);
    }

    @Override
    public int insertList(List<Train> trains) {
        return trainMapper.insertList(trains);
    }

    @Override
    public int updateByPrimaryKey(Train train) {
        return trainMapper.updateByPrimaryKey(train);
    }

    @Override
    public int updateByPrimaryKeySelective(Train train) {
        return trainMapper.updateByPrimaryKeySelective(train);
    }

    @Override
    public int selectCount(Train train) {
        return trainMapper.selectCount(train);
    }

    @Override
    public int batchDel(Map<String, Object> map) {
        return trainMapper.batchDel(map);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return trainMapper.deleteByPrimaryKey(id);
    }
}
