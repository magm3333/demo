package com.reedcons.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.reedcons.demo.business.IGraphBusiness;

@Configuration
@EnableScheduling
public class ScheduledEvents {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IGraphBusiness graphService;
	
	
	// @Scheduled(cron = " 0 0/1 * 1/1 * ? *")
	@Scheduled(fixedDelay=10000,initialDelay=5000)
	public void serverPush() {
		graphService.pushGraphData();
	}
	
	//@Scheduled(fixedDelay=1000)
	//public void otroEvento() {
	//	log.info("******************* evento ***************************");
	//}

}
