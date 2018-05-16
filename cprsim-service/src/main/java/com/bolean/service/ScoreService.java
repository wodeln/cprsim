package com.bolean.service;

import com.bolean.entity.Score;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ScoreService extends BaseService<Score> {
    Map<String,Object> selectSetFilds(String trainId);

    Map<String,Object> selectInfosByTrainId(Map<String,Object> map);

    int selectCountGtVaule(Map<String,Object> map);

    int selectCountGteVaule(Map<String,Object> map);
}
