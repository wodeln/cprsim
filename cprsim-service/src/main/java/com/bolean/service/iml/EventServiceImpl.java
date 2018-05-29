package com.bolean.service.iml;

import com.bolean.dao.EventMapper;
import com.bolean.entity.Event;
import com.bolean.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("EventService")
public class EventServiceImpl implements EventService {

    @Autowired
    private EventMapper eventMapper;

    @Override
    public List<Event> selectAll() {
        return eventMapper.selectAll();
    }

    @Override
    public List<Event> select(Event event) {
        return eventMapper.select(event);
    }

    @Override
    public Event selectByPrimaryKey(Long id) {
        return eventMapper.selectByPrimaryKey(id);
    }

    @Override
    public Event selectOne(Event event) {
        return eventMapper.selectOne(event);
    }

    @Override
    public int insert(Event event) {
        return eventMapper.insert(event);
    }

    @Override
    public int insertSelective(Event event) {
        return eventMapper.insertSelective(event);
    }

    @Override
    public int insertList(List<Event> event) {
        return eventMapper.insertList(event);
    }

    @Override
    public int updateByPrimaryKey(Event event) {
        return eventMapper.updateByPrimaryKey(event);
    }

    @Override
    public int updateByPrimaryKeySelective(Event event) {
        return eventMapper.updateByPrimaryKeySelective(event);
    }

    @Override
    public int selectCount(Event event) {
        return eventMapper.selectCount(event);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return eventMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Event> selectByInfo(Event event) {
        return eventMapper.selectByInfo(event);
    }

    @Override
    public List<Event> selectByInfo(Map<String, Object> map) {
        return eventMapper.selectByInfo(map);
    }

    @Override
    public List<Event> selectByUseridAndprojectId(Map<String, Object> map) {
        return eventMapper.selectByUseridAndprojectId(map);
    }
}
