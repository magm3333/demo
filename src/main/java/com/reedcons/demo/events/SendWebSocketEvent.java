package com.reedcons.demo.events;

import org.springframework.context.ApplicationEvent;

public class SendWebSocketEvent extends ApplicationEvent{


	private static final long serialVersionUID = 3475809294212271995L;

	public SendWebSocketEvent(Object source, String topic) {
		super(source);
		this.topic=topic;
		
	}

	private String topic;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	
}
