package com.freelanceflow.controller;
import com.freelanceflow.model.WorkLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.freelanceflow.repository.WorkLogRepository;


import java.util.*;

@RestController
@RequestMapping("/api/worklogs")
public class WorkLogController {

    @Autowired
    private WorkLogRepository workLogRepository;

    //API endpoint that frontend (Chart.js) will call
    @PostMapping
    public List<Map<String, Object>> getWorkLogChartData() {
        List<WorkLog> workLogs = workLogRepository.findAll();
        List<Map<String, Object>> result = new ArrayList<>();

        for (WorkLog wl : workLogs) {
            Map<String, Object> map = new HashMap<>();
            map.put("projectName", wl.getProjectName());
            map.put("hoursSpent", wl.getHoursSpent());
            map.put("earnings", wl.getEarnings());
            result.add(map);
        }
        return result;
    }

}
