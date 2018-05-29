package com.bolean.dao;

import com.bolean.entity.Event;
import mybatis.basemapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface EventMapper extends BaseMapper<Event> {
    List<Event> selectByUseridAndprojectId(Map<String,Object> map);
}
