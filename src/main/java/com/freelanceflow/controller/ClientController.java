package com.freelanceflow.controller;

import com.freelanceflow.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.freelanceflow.repository.ClientRepository;



import java.util.*;


@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/chartData")
    public List<Map<String , Object>> getClientChartData(){
            List<Client> clients = clientRepository.findAll();
            List<Map<String , Object>> result = new ArrayList<>();

            for(Client c : clients){
                Map<String , Object> map = new HashMap <>();
                map.put("projectName", c.getProjectName());
                map.put("freelancerCount", c.getFreelancerCount());
                map.put("budget", c.getBudget());
                map.put("progressPercent", c.getProgressPercent());
                result.add(map);
            }
            return result;
    }

}
