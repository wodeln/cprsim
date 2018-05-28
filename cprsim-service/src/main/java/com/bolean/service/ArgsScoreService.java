package com.bolean.service;

import com.bolean.entity.ArgsScore;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ArgsScoreService extends BaseService<ArgsScore> {
    Integer selectScoreByUserIdArgsId(Map<String,Object> map);
}
