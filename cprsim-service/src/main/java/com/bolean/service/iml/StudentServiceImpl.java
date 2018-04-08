package com.bolean.service.iml;

import com.bolean.dao.StudentMapper;
import com.bolean.entity.Student;
import com.bolean.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public List<Student> select(Student student) {
        return studentMapper.select(student);
    }

    @Override
    public Student selectByPrimaryKey(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Student selectOne(Student student) {
        return studentMapper.selectOne(student);
    }

    @Override
    public int insert(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public int insertSelective(Student student) {
        return studentMapper.insertSelective(student);
    }

    @Override
    public int insertList(List<Student> students) {
        return studentMapper.insertList(students);
    }

    @Override
    public int updateByPrimaryKey(Student student) {
        return studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public int updateByPrimaryKeySelective(Student student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public int selectCount(Student student) {
        return studentMapper.selectCount(student);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public List<Student> selectByInfo(Map<String,Object> map){
        return studentMapper.selectByInfo(map);
    }

    @Override
    public List<Student> selectByInfo(Student student){
        return studentMapper.selectByInfo(student);
    }

    @Override
    public int batchDel(Map<String, Object> map) {
        return studentMapper.batchDel(map);
    }
}
