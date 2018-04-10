package com.bolean.service.iml;

import com.bolean.dao.TrainSettingMapper;
import com.bolean.entity.TrainSetting;
import com.bolean.service.TrainSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("TrainSettingService")
public class TrainSettingServiceImpl implements TrainSettingService {
    @Autowired
    private TrainSettingMapper trainSettingMapper;

    @Override
    public List<TrainSetting> selectAll() {
        return trainSettingMapper.selectAll();
    }

    @Override
    public List<TrainSetting> select(TrainSetting trainSetting) {
        return trainSettingMapper.select(trainSetting);
    }

    @Override
    public TrainSetting selectByPrimaryKey(Long id) {
        return trainSettingMapper.selectByPrimaryKey(id);
    }

    @Override
    public TrainSetting selectOne(TrainSetting trainSetting) {
        return trainSettingMapper.selectOne(trainSetting);
    }

    @Override
    public int insert(TrainSetting trainSetting) {
        return trainSettingMapper.insert(trainSetting);
    }

    @Override
    public int insertSelective(TrainSetting trainSetting) {
        return trainSettingMapper.insertSelective(trainSetting);
    }

    @Override
    public int insertList(List<TrainSetting> trainSettings) {
        return trainSettingMapper.insertList(trainSettings);
    }

    @Override
    public int updateByPrimaryKey(TrainSetting trainSetting) {
        return trainSettingMapper.updateByPrimaryKey(trainSetting);
    }

    @Override
    public int updateByPrimaryKeySelective(TrainSetting trainSetting) {
        return trainSettingMapper.updateByPrimaryKeySelective(trainSetting);
    }

    @Override
    public int selectCount(TrainSetting trainSetting) {
        return trainSettingMapper.selectCount(trainSetting);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return trainSettingMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TrainSetting> selectByInfo(TrainSetting trainSetting) {
        return trainSettingMapper.selectByInfo(trainSetting);
    }

    @Override
    public List<TrainSetting> selectByInfo(Map<String, Object> map) {
        return trainSettingMapper.selectByInfo(map);
    }

    @Override
    public TrainSetting selectByTrainId(String trainId) {
        return trainSettingMapper.selectByTrainId(trainId);
    }

    @Override
    public int deleteByTrainId(String trainId) {
        return trainSettingMapper.deleteByTrainId(trainId);
    }
}
