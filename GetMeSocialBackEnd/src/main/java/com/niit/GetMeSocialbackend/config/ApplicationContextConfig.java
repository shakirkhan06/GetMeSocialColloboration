package com.niit.GetMeSocialbackend.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.GetMeSocialbackend.model.Blog;
import com.niit.GetMeSocialbackend.model.Chat;
import com.niit.GetMeSocialbackend.model.Comment;
import com.niit.GetMeSocialbackend.model.Forum;
import com.niit.GetMeSocialbackend.model.ForumMessage;
import com.niit.GetMeSocialbackend.model.Job;
import com.niit.GetMeSocialbackend.model.JobApplication;
import com.niit.GetMeSocialbackend.model.ReportUserChat;
import com.niit.GetMeSocialbackend.model.User;


@Configuration
@ComponentScan(basePackages="com.niit.GetMeSocialbackend")
@EnableTransactionManagement
public class ApplicationContextConfig {
	
private static final Logger logger=LoggerFactory.getLogger(ApplicationContextConfig.class);
	
	@Bean(name = "dataSource")
	public DataSource getOracleDataSource() {
/*		logger.debug("Starting of the method getOracleDataSource");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");

		dataSource.setUsername("STMTDB");
		dataSource.setPassword("jcoll123");

		Properties connectionProperties = new Properties();

		connectionProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");

		dataSource.setConnectionProperties(connectionProperties);
		logger.debug("Setting the data source :" + dataSource.getConnectionProperties());
		logger.debug("Ending of the method getOracleDataSource");
		return dataSource;*/
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("org.h2.Driver");
        datasource.setUrl("jdbc:h2:tcp://localhost/~/collabDb");
        datasource.setUsername("sa");
        datasource.setPassword("");		
		return datasource;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		logger.debug("Starting of the method getSessionFactory");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		Properties connectionProperties = new Properties();

		//connectionProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		connectionProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		connectionProperties.put("hibernate.hbm2ddl.auto", "update");
		connectionProperties.put("hibernate.show_sql", "true");
		sessionBuilder.addProperties(connectionProperties);
		sessionBuilder.addAnnotatedClass(ForumMessage.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(ReportUserChat.class);
		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(Chat.class);
		sessionBuilder.addAnnotatedClass(Forum.class);
		sessionBuilder.addAnnotatedClass(Job.class);
		sessionBuilder.addAnnotatedClass(JobApplication.class);
		sessionBuilder.addAnnotatedClass(Comment.class);
		logger.debug("Ending of the method getSessionFactory");
		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

		logger.debug("Starting of the method getTransactionManager");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		logger.debug("Ending of the method getTransactionManager");
		return transactionManager;
	}


}
