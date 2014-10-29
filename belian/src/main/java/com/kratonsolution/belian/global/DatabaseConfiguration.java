/**
 * 
 */
package com.kratonsolution.belian.global;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * @author agungdodiperdana
 *
 */
@Configuration
public class DatabaseConfiguration
{
	@Bean
	public Mongo mongoServer() throws UnknownHostException
	{
		return new MongoClient("127.0.0.1");
	}
	
	@Bean
	public MongoDbFactory connectionFactory() throws UnknownHostException
	{
		return new SimpleMongoDbFactory(mongoServer(),"belian");
	}
	
	@Bean
	public MongoTemplate mongoTemplate() throws UnknownHostException
	{
		return new MongoTemplate(connectionFactory());
	}
}
