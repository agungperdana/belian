/**
 * 
 */
package com.kratonsolution.belian.global.infra;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;

/**
 * @author agungdodiperdana
 *
 */
@Configuration
public class MySQLConfiguration
{
	@Bean
	public DataSource mysqlXADatasource()
	{
		MysqlXADataSource dataSource = new MysqlXADataSource();
		dataSource.setURL("jdbc:mysql://127.0.0.1:3306/belian");
		dataSource.setUser("belian");
		dataSource.setPassword("belian");
		
		return dataSource;
	}
}
