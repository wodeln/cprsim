package com.bolean.service;

import com.bolean.entity.Exam;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ExamService extends BaseService<Exam>{

    int batchDel(Map<String, Object> map);
}
