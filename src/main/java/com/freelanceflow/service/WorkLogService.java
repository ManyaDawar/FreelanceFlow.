package com.freelanceflow.service;
import com.freelanceflow.model.WorkLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.freelanceflow.repository.WorkLogRepository;

import java.util.*;

@Service
public class WorkLogService {
    @Autowired
    private WorkLogRepository workLogRepository;

    public List <WorkLog> getAllWorkLogs(){
        return workLogRepository.findAll();
    }
}
