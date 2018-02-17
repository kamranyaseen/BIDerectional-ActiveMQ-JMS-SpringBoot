package com.kamranyaseen.jms.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.kamranyaseen.model.Company;

@Component
public class JmsConsumer {
	
	@JmsListener(destination = "${activemq.queue}", containerFactory="testFactory")
	public void receive(Company company){
		System.out.println("Recieved Message: " + company);
	}
}
