package com.bolean.service;


import com.bolean.entity.Mould;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface MouldService extends BaseService<Mould>{
    List<Mould> selectByInfo(Map<String, Object> map);

    List<Mould> selectByInfo(Mould mould);

    int insertSelective(Mould mould);

    int batchDel(Map<String, Object> map);
}
