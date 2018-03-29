package com.bolean.dao;

import com.bolean.entity.SysDict;
import mybatis.basemapper.BaseMapper;

public interface SysDictMapper extends BaseMapper<SysDict>{
    SysDict selectByDictName(String dictName);
}