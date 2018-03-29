package com.bolean.service.iml;

import com.bolean.dao.CommonMapper;
import com.bolean.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("CommonService")
public class CommonServiceImpl implements CommonService {
    @Autowired
    private CommonMapper commonMapper;

    @Override
    public boolean checkUnique(Map<String, Object> map) {
        return commonMapper.checkUnique(map) <= 0;
    }
}
