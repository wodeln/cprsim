package com.bolean.service.iml;

import com.bolean.dao.ArgsScoreMapper;
import com.bolean.entity.ArgsScore;
import com.bolean.service.ArgsScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ArgsScoreService")
public class ArgsScoreServiceImpl implements ArgsScoreService {

    @Autowired
    private ArgsScoreMapper argsScoreMapper;

    @Override
    public List<ArgsScore> selectAll() {
        return argsScoreMapper.selectAll();
    }

    @Override
    public List<ArgsScore> select(ArgsScore argsScore) {
        return argsScoreMapper.select(argsScore);
    }

    @Override
    public ArgsScore selectByPrimaryKey(Long id) {
        return argsScoreMapper.selectByPrimaryKey(id);
    }

    @Override
    public ArgsScore selectOne(ArgsScore argsScore) {
        return argsScoreMapper.selectOne(argsScore);
    }

    @Override
    public int insert(ArgsScore argsScore) {
        return argsScoreMapper.insert(argsScore);
    }

    @Override
    public int insertSelective(ArgsScore argsScore) {
        return argsScoreMapper.insertSelective(argsScore);
    }

    @Override
    public int insertList(List<ArgsScore> argsScore) {
        return argsScoreMapper.insertList(argsScore);
    }

    @Override
    public int updateByPrimaryKey(ArgsScore argsScore) {
        return argsScoreMapper.updateByPrimaryKey(argsScore);
    }

    @Override
    public int updateByPrimaryKeySelective(ArgsScore argsScore) {
        return argsScoreMapper.updateByPrimaryKeySelective(argsScore);
    }

    @Override
    public int selectCount(ArgsScore argsScore) {
        return argsScoreMapper.selectCount(argsScore);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return argsScoreMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ArgsScore> selectByInfo(ArgsScore argsScore) {
        return argsScoreMapper.selectByInfo(argsScore);
    }

    @Override
    public List<ArgsScore> selectByInfo(Map<String, Object> map) {
        return argsScoreMapper.selectByInfo(map);
    }

    @Override
    public Integer selectScoreByUserIdArgsId(Map<String, Object> map) {
        return argsScoreMapper.selectScoreByUserIdArgsId(map);
    }
}
