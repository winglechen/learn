package com.wingle.project.web.service;

import com.wingle.project.web.filter.RiskFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.LinkedTransferQueue;

@Service
public class DemoService {
    private final RiskFilter riskFilter;

    @Autowired
    public DemoService(RiskFilter riskFilter) {
        this.riskFilter = riskFilter;
    }

    public String show() {
        return "I am DemoService, Ha Ha!";
    }

    public void queue(){
        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();
    }
}
