package com.bolean.service.iml;

import com.bolean.dao.MouldMapper;
import com.bolean.entity.Mould;
import com.bolean.service.MouldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("MouldService")
public class MouldServiceImpl implements MouldService {
    @Autowired
    private MouldMapper mouldMapper;


    @Override
    public List<Mould> selectByInfo(Map<String, Object> map) {
        return mouldMapper.selectByInfo(map);
    }

    @Override
    public List<Mould> selectByInfo(Mould mould) {
        return mouldMapper.selectByInfo(mould);
    }

    @Override
    public List<Mould> selectAll() {
        return mouldMapper.selectAll();
    }

    @Override
    public List<Mould> select(Mould mould) {
        return mouldMapper.select(mould);
    }

    @Override
    public Mould selectByPrimaryKey(Long id) {
        return mouldMapper.selectByPrimaryKey(id);
    }

    @Override
    public Mould selectOne(Mould mould) {
        return mouldMapper.selectOne(mould);
    }

    @Override
    public int insert(Mould mould) {
        return mouldMapper.insert(mould);
    }

    @Override
    public int insertSelective(Mould mould) {
        return mouldMapper.insertSelective(mould);
    }

    @Override
    public int insertList(List<Mould> moulds) {
        return mouldMapper.insertList(moulds);
    }

    @Override
    public int updateByPrimaryKey(Mould mould) {
        return mouldMapper.updateByPrimaryKey(mould);
    }

    @Override
    public int updateByPrimaryKeySelective(Mould mould) {
        return mouldMapper.updateByPrimaryKeySelective(mould);
    }

    @Override
    public int selectCount(Mould mould) {
        return mouldMapper.selectCount(mould);
    }

    @Override
    public int batchDel(Map<String, Object> map) {
        return mouldMapper.batchDel(map);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return mouldMapper.deleteByPrimaryKey(id);
    }
}
