package com.bolean.service.iml;

import com.bolean.dao.ExamMapper;
import com.bolean.entity.Exam;
import com.bolean.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ExamService")
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamMapper examMapper;


    @Override
    public List<Exam> selectByInfo(Map<String, Object> map) {
        return examMapper.selectByInfo(map);
    }

    @Override
    public List<Exam> selectByInfo(Exam exam) {
        return examMapper.selectByInfo(exam);
    }

    @Override
    public List<Exam> selectAll() {
        return examMapper.selectAll();
    }

    @Override
    public List<Exam> select(Exam exam) {
        return examMapper.select(exam);
    }

    @Override
    public Exam selectByPrimaryKey(Long id) {
        return examMapper.selectByPrimaryKey(id);
    }

    @Override
    public Exam selectOne(Exam exam) {
        return examMapper.selectOne(exam);
    }

    @Override
    public int insert(Exam exam) {
        return examMapper.insert(exam);
    }

    @Override
    public int insertSelective(Exam exam) {
        return examMapper.insertSelective(exam);
    }

    @Override
    public int insertList(List<Exam> exams) {
        return examMapper.insertList(exams);
    }

    @Override
    public int updateByPrimaryKey(Exam exam) {
        return examMapper.updateByPrimaryKey(exam);
    }

    @Override
    public int updateByPrimaryKeySelective(Exam exam) {
        return examMapper.updateByPrimaryKeySelective(exam);
    }

    @Override
    public int selectCount(Exam exam) {
        return examMapper.selectCount(exam);
    }

    @Override
    public int batchDel(Map<String, Object> map) {
        return examMapper.batchDel(map);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return examMapper.deleteByPrimaryKey(id);
    }
}
