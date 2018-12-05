package com.reedcons.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.reedcons.demo.web.Constantes;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint(Constantes.URL_WEBSOCKET_ENPOINT).withSockJS(); // Nombre del endpoints server. Para new SockJs( endpoint ) client side
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/reedcons"); // subscribe('/reedcons/graph'), se genera con  @SendTo en el controller o del template
		registry.setApplicationDestinationPrefixes("/reedconsin"); // send('/reedconsin/toServer'), toServer -> ingresa al @MessageMapping en el controller
	}

}
