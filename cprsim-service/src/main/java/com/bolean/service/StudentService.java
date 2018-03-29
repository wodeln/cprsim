package com.bolean.service;

import com.bolean.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StudentService extends BaseService<Student> {
    List<Student> selectByInfo(Map<String,Object> map);

    List<Student> selectByInfo(Student student);
}
