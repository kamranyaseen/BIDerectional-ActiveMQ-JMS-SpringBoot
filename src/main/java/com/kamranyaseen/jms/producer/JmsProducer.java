package com.kamranyaseen.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.kamranyaseen.model.Company;

@Component
public class JmsProducer {
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${activemq.queue}")
	String queue;
	
	public void send(Company company){
		jmsTemplate.convertAndSend(queue, company);
	}
}