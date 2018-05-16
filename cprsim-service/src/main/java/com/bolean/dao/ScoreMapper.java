package com.bolean.dao;

import com.bolean.entity.Score;
import mybatis.basemapper.BaseMapper;

import java.util.Map;

public interface ScoreMapper extends BaseMapper<Score> {
    Map<String,Object> selectSetFilds(String trainId);

    Map<String,Object> selectInfosByTrainId(Map<String,Object> map);

    int selectCountGtVaule(Map<String,Object> map);

    int selectCountGteVaule(Map<String,Object> map);
}
