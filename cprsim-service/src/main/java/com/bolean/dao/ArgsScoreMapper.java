package com.bolean.dao;

import com.bolean.entity.ArgsScore;
import mybatis.basemapper.BaseMapper;

import java.util.Map;

public interface ArgsScoreMapper extends BaseMapper<ArgsScore> {
    Integer selectScoreByUserIdArgsId(Map<String,Object> map);
}
