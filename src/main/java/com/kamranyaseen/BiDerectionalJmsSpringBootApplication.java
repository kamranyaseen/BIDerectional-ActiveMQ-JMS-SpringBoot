package com.kamranyaseen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kamranyaseen.jms.producer.JmsProducer;
import com.kamranyaseen.model.Company;
import com.kamranyaseen.model.Product;

@SpringBootApplication
public class BiDerectionalJmsSpringBootApplication implements CommandLineRunner{
	
	@Autowired
	JmsProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(BiDerectionalJmsSpringBootApplication.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception{
		
		/// Apple
		Product macbook = new Product("Macbook");
		Product iPad = new Product("IPad");
		Product iPhone = new Product("IPhone");
		Product iMac = new Product("IMac");
		
		List<Product> appleProducts = new ArrayList<Product>(Arrays.asList(macbook, iPad,iPhone, iMac));
		
		Company apple = new Company("Apple", appleProducts);
		
		macbook.setCompany(apple);
		iPad.setCompany(apple);
		iPhone.setCompany(apple);
		iMac.setCompany(apple);
		
        producer.send(apple);
        
        /// Microsoft 
        
		Product surface = new Product("Surface Pro");
		Product surfacelaptop = new Product("Surface Laptop");
		Product lumia = new Product("Microsoft Mobile");
		Product office = new Product("Microsoft Office");
		
		List<Product> MSProducts = new ArrayList<Product>(Arrays.asList(surface, surfacelaptop,lumia, office));
		
		Company microsoft = new Company("Microsoft", MSProducts);
		
		surface.setCompany(microsoft);
		surfacelaptop.setCompany(microsoft);
		lumia.setCompany(microsoft);
		office.setCompany(microsoft);
		
        producer.send(microsoft);
	}
}
