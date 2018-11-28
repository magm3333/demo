package com.reedcons.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.reedcons.demo.business.IGraphBusiness;

@Configuration
@EnableScheduling
public class ScheduledEvents {
	
	@Autowired
	private IGraphBusiness graphService;
	
	@Scheduled(fixedDelay=3000,initialDelay=5000)
	public void serverPush() {
		graphService.pushGraphData();
	}

}
