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
}
