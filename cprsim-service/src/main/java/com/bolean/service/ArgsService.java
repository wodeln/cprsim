package com.bolean.service;

import com.bolean.entity.Args;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArgsService extends BaseService<Args> {

    List<Args> selectByArgsTypeId(String argsTypeId);

    int deleteByArgsId(String argsId);

    int updateVersion();

    String selectArgsVersion();
}
