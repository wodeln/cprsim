package com.bolean.service.iml;

import com.bolean.dao.SysDictMapper;
import com.bolean.entity.SysDict;
import com.bolean.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service("SysDictService")
public class SysDictServiceImpl implements SysDictService {
    @Autowired
    private SysDictMapper sysDictMapper;

    @Override
    public List<SysDict> selectAll() {
        return sysDictMapper.selectAll();
    }

    @Override
    public List<SysDict> select(SysDict sysDict) {
        return sysDictMapper.select(sysDict);
    }

    @Override
    public SysDict selectByPrimaryKey(Long id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }

    @Override
    public SysDict selectOne(SysDict sysDict) {
        return sysDictMapper.selectOne(sysDict);
    }

    @Override
    public int insert(SysDict sysDict) {
        return sysDictMapper.insert(sysDict);
    }

    @Override
    public int insertSelective(SysDict sysDict) {
        return 0;
    }

    @Override
    public int insertList(List<SysDict> sysDicts) {
        return sysDictMapper.insertList(sysDicts);
    }

    @Override
    public int updateByPrimaryKey(SysDict sysDict) {
        return sysDictMapper.updateByPrimaryKey(sysDict);
    }

    @Override
    public int updateByPrimaryKeySelective(SysDict sysDict) {
        return 0;
    }

    @Override
    public int selectCount(SysDict sysDict) {
        return sysDictMapper.selectCount(sysDict);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public SysDict selectByDictName(String dictName) {
        return sysDictMapper.selectByDictName(dictName);
    }
}
