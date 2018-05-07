package com.bolean.service.iml;

import com.bolean.dao.ArgsTypeMapper;
import com.bolean.entity.ArgsType;
import com.bolean.service.ArgsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ArgsTypeService")
public class ArgsTypeServiceImpl implements ArgsTypeService {

    @Autowired
    private ArgsTypeMapper ArgsTypeMapper;

    @Override
    public List<ArgsType> selectAll() {
        return ArgsTypeMapper.selectAll();
    }

    @Override
    public List<ArgsType> select(ArgsType ArgsType) {
        return ArgsTypeMapper.select(ArgsType);
    }

    @Override
    public ArgsType selectByPrimaryKey(Long id) {
        return ArgsTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public ArgsType selectOne(ArgsType ArgsType) {
        return ArgsTypeMapper.selectOne(ArgsType);
    }

    @Override
    public int insert(ArgsType ArgsType) {
        return ArgsTypeMapper.insert(ArgsType);
    }

    @Override
    public int insertSelective(ArgsType ArgsType) {
        return ArgsTypeMapper.insertSelective(ArgsType);
    }

    @Override
    public int insertList(List<ArgsType> ArgsType) {
        return ArgsTypeMapper.insertList(ArgsType);
    }

    @Override
    public int updateByPrimaryKey(ArgsType ArgsType) {
        return ArgsTypeMapper.updateByPrimaryKey(ArgsType);
    }

    @Override
    public int updateByPrimaryKeySelective(ArgsType ArgsType) {
        return ArgsTypeMapper.updateByPrimaryKeySelective(ArgsType);
    }

    @Override
    public int selectCount(ArgsType ArgsType) {
        return ArgsTypeMapper.selectCount(ArgsType);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return ArgsTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ArgsType> selectByInfo(ArgsType ArgsType) {
        return ArgsTypeMapper.selectByInfo(ArgsType);
    }

    @Override
    public List<ArgsType> selectByInfo(Map<String, Object> map) {
        return ArgsTypeMapper.selectByInfo(map);
    }
}
