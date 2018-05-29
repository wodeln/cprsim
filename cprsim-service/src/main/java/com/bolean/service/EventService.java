package com.bolean.service;

import com.bolean.entity.Event;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface EventService extends BaseService<Event> {
    List<Event> selectByUseridAndprojectId(Map<String,Object> map);
}
