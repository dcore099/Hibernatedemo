package com.example.config;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.services.TestService;

@Configuration
public class GeneralConfig {
	final static Logger logger = Logger.getLogger(GeneralConfig.class);

	@Bean
	public SessionFactory getSessionFactory() {
		logger.debug("CONFIGURANDO FACTORY..");
		
		SessionFactory factory;
		StandardServiceRegistry stRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();		
		Metadata metaData = new MetadataSources(stRegistry).getMetadataBuilder().build();		
		factory = metaData.getSessionFactoryBuilder().build();
		
		if(factory == null) {
			logger.error("FACTORY ES NULL EN CONFIG BEAN");
		}else {
			logger.debug("FACTORY INICIALIZADA!");
		}		
		return factory;
	}
	
}
