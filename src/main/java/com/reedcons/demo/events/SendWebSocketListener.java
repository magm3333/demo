package com.reedcons.demo.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendWebSocketListener  implements ApplicationListener<SendWebSocketEvent>{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void onApplicationEvent(SendWebSocketEvent event) {
		log.info("Se envió info sobre: "+event.getTopic());
		wSock.convertAndSend(event.getTopic(),event.getSource());
	}
	@Autowired
	private SimpMessagingTemplate wSock;
}
