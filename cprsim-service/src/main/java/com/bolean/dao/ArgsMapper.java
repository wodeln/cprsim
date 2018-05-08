package com.bolean.dao;

import com.bolean.entity.Args;
import mybatis.basemapper.BaseMapper;

import java.util.List;

public interface ArgsMapper extends BaseMapper<Args> {
    List<Args> selectByArgsTypeId(String argsTypeId);

    int deleteByArgsId(String argsId);

    int updateVersion();
}
