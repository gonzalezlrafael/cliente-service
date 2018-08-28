package br.com.rd.agendamento.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Classe de configuração para o uso do Spring JPA e Hibernate.
 */
@Configuration
@EnableTransactionManagement
public class SpringJpaConfig{

	/**
	 * Metodo necessario poos contem as configuracoes do banco de dados
	 *
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		
		try {
			
			JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
			jndiObjectFactoryBean.setJndiName("jdbc/ws");
			jndiObjectFactoryBean.setProxyInterface(DataSource.class);
			jndiObjectFactoryBean.setLookupOnStartup(false);
			jndiObjectFactoryBean.afterPropertiesSet();
			
			DataSource lookup = (DataSource) jndiObjectFactoryBean.getObject();
			return lookup;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		// return ds;
	}


	/**
	 * Metodo necessario para o spring criar o EM
	 *
	 * @return
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		factory.setPersistenceUnitName("R102");
		factory.setDataSource(dataSource());
		factory.setPackagesToScan("br.com.rd.agendamento.entity");
		factory.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
		factory.setJpaProperties(jpaProperties());
		factory.afterPropertiesSet();
		EntityManagerFactory object = factory.getObject();
		return object;
	}

	/**
	 * Metodo que faz com que o spring gerencie as transacoes
	 *
	 * @return
	 */
	@Bean
	public JpaTransactionManager  transactionManager() {
		EntityManagerFactory entityManagerFactory = entityManagerFactory();
		JpaTransactionManager tx = new JpaTransactionManager();
		tx.setEntityManagerFactory(entityManagerFactory);
		tx.setJpaDialect(new EclipseLinkJpaDialect());
		return tx;
	}
	
	
	private Properties jpaProperties() {
		Properties props = new Properties();

		props.setProperty("eclipselink.target-server", "WebLogic_10");
		props.setProperty("eclipselink.logging.level", "ALL");
		props.setProperty("eclipselink.logging.level.sql", "ALL");
		props.setProperty("eclipselink.logging.parameters", "ALL");
		props.setProperty("eclipselink.logging.level.connection", "ALL");
		props.setProperty("eclipselink.logging.level.sequencing", "ALL");
		props.setProperty("eclipselink.logging.level.transaction", "ALL");
		props.setProperty("eclipselink.logging.level.query", "ALL");
		props.setProperty("eclipselink.logging.timestamp", "true");
		props.setProperty("eclipselink.logging.logger", "DefaultLogger");


		return props;
	}
	
}
