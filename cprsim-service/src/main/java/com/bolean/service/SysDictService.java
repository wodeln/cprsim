package com.bolean.service;

import com.bolean.entity.SysDict;
import org.springframework.stereotype.Service;

@Service
public interface SysDictService extends BaseService<SysDict> {
    SysDict selectByDictName(String dictName);
}
