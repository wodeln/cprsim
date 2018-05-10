package com.bolean.service.iml;

import com.bolean.dao.ArgsMapper;
import com.bolean.entity.Args;
import com.bolean.service.ArgsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ArgsService")
public class ArgsServiceImpl implements ArgsService {

    @Autowired
    private ArgsMapper argsMapper;

    @Override
    public List<Args> selectAll() {
        return argsMapper.selectAll();
    }

    @Override
    public List<Args> select(Args args) {
        return argsMapper.select(args);
    }

    @Override
    public Args selectByPrimaryKey(Long id) {
        return argsMapper.selectByPrimaryKey(id);
    }

    @Override
    public Args selectOne(Args args) {
        return argsMapper.selectOne(args);
    }

    @Override
    public int insert(Args args) {
        return argsMapper.insert(args);
    }

    @Override
    public int insertSelective(Args args) {
        return argsMapper.insertSelective(args);
    }

    @Override
    public int insertList(List<Args> args) {
        return argsMapper.insertList(args);
    }

    @Override
    public int updateByPrimaryKey(Args args) {
        return argsMapper.updateByPrimaryKey(args);
    }

    @Override
    public int updateByPrimaryKeySelective(Args args) {
        return argsMapper.updateByPrimaryKeySelective(args);
    }

    @Override
    public int selectCount(Args args) {
        return argsMapper.selectCount(args);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return argsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Args> selectByInfo(Args args) {
        return argsMapper.selectByInfo(args);
    }

    @Override
    public List<Args> selectByInfo(Map<String, Object> map) {
        return argsMapper.selectByInfo(map);
    }

    @Override
    public List<Args> selectByArgsTypeId(String argsTypeId) {
        return argsMapper.selectByArgsTypeId(argsTypeId);
    }

    @Override
    public int deleteByArgsId(String argsId) {
        return argsMapper.deleteByArgsId(argsId);
    }

    @Override
    public int updateVersion() {
        return argsMapper.updateVersion();
    }

    @Override
    public String selectArgsVersion() {
        return argsMapper.selectArgsVersion();
    }
}
