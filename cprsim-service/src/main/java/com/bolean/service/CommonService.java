package com.bolean.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public interface CommonService {
    boolean checkUnique(Map<String, Object> map);
}
