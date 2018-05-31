package com.bolean.service.iml;

import com.bolean.dao.ScoreMapper;
import com.bolean.entity.Score;
import com.bolean.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ScoreService")
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public List<Score> selectAll() {
        return scoreMapper.selectAll();
    }

    @Override
    public List<Score> select(Score score) {
        return scoreMapper.select(score);
    }

    @Override
    public Score selectByPrimaryKey(Long id) {
        return scoreMapper.selectByPrimaryKey(id);
    }

    @Override
    public Score selectOne(Score score) {
        return scoreMapper.selectOne(score);
    }

    @Override
    public int insert(Score score) {
        return scoreMapper.insert(score);
    }

    @Override
    public int insertSelective(Score score) {
        return scoreMapper.insertSelective(score);
    }

    @Override
    public int insertList(List<Score> score) {
        return scoreMapper.insertList(score);
    }

    @Override
    public int updateByPrimaryKey(Score score) {
        return scoreMapper.updateByPrimaryKey(score);
    }

    @Override
    public int updateByPrimaryKeySelective(Score score) {
        return scoreMapper.updateByPrimaryKeySelective(score);
    }

    @Override
    public int selectCount(Score score) {
        return scoreMapper.selectCount(score);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return scoreMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Score> selectByInfo(Score score) {
        return scoreMapper.selectByInfo(score);
    }

    @Override
    public List<Score> selectByInfo(Map<String, Object> map) {
        return scoreMapper.selectByInfo(map);
    }

    @Override
    public Map<String, Object> selectSetFilds(String trainId) {
        return scoreMapper.selectSetFilds(trainId);
    }

    @Override
    public Map<String, Object> selectInfosByTrainId(Map<String, Object> map) {
        return scoreMapper.selectInfosByTrainId(map);
    }

    @Override
    public int selectCountGtVaule(Map<String, Object> map) {
        return scoreMapper.selectCountGtVaule(map);
    }

    @Override
    public int selectCountGteVaule(Map<String, Object> map) {
        return scoreMapper.selectCountGteVaule(map);
    }

    @Override
    public List<Map<String, Object>> selectStudentByTrainid(String trainId) {
        return scoreMapper.selectStudentByTrainid(trainId);
    }

    @Override
    public List<Map<String, Object>> selectCountByTrainId(Map<String, Object> map) {
        return scoreMapper.selectCountByTrainId(map);
    }

    @Override
    public Integer selectPassCountByTrainId(Map<String, Object> map) {
        return scoreMapper.selectPassCountByTrainId(map);
    }

    @Override
    public List<Map<String, Object>> selectTrainByUserId(String userId) {
        return scoreMapper.selectTrainByUserId(userId);
    }

    @Override
    public int selectTrainPassCountByUserId(Map<String, Object> map) {
        return scoreMapper.selectTrainPassCountByUserId(map);
    }

    @Override
    public int selectSumFalTrainCountByUserid(String userId) {
        return scoreMapper.selectSumFalTrainCountByUserid(userId);
    }

    @Override
    public int selectSumPassTrainCountByUserid(String userId) {
        return scoreMapper.selectSumPassTrainCountByUserid(userId);
    }

    @Override
    public int selectTrainCountByUserid(String userId) {
        return scoreMapper.selectTrainCountByUserid(userId);
    }


}
