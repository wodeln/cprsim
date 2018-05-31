package com.bolean.dao;

import com.bolean.entity.Score;
import mybatis.basemapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface ScoreMapper extends BaseMapper<Score> {
    Map<String,Object> selectSetFilds(String trainId);

    Map<String,Object> selectInfosByTrainId(Map<String,Object> map);

    int selectCountGtVaule(Map<String,Object> map);

    int selectCountGteVaule(Map<String,Object> map);

    List<Map<String,Object>> selectStudentByTrainid(String trainId);

    List<Map<String,Object>> selectCountByTrainId(Map<String,Object> map);

    Integer selectPassCountByTrainId(Map<String,Object> map);

    List<Map<String,Object>> selectTrainByUserId(String userId);

    int selectTrainPassCountByUserId(Map<String,Object> map);

    int selectSumFalTrainCountByUserid(String userId);

    int selectSumPassTrainCountByUserid(String userId);

    int selectTrainCountByUserid(String userId);
}
