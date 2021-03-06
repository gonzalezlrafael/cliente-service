package br.com.rd.agendamento.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Anotação @{@link Configuration} Determina que essa é uma classe de configuração do Spring
 * Anotação @{@link EnableWebMvc} Habilita o Spring mvc
 * Anotação @{@link EnableTransactionManagement} Habilita o spring para controlar as transaçãoes com o banco de dados
 * Anotação @{@link ComponentScan} Habilita o scaneamento do spring para que ele identifique as classes
 */
@Configuration
@EnableWebMvc
@ComponentScan("br.com.rd.agendamento")
public class SpringRootConfig {
	
}
