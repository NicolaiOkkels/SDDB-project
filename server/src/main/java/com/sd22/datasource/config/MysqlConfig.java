package com.sd22.datasource.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.sd22.datasource.mysql.repository", transactionManagerRef = "mysqlTransactionManager", entityManagerFactoryRef = "entityManagerFactory")
@EnableTransactionManagement
public class MysqlConfig {

    @Value("${spring.datasource.url}")
    private String mysqlUri;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;


    @Bean(name = "mysql")
    @ConfigurationProperties(prefix = "spring.mysql")
    public DataSource dataSource(){
        return DataSourceBuilder.create().driverClassName("com.mysql.cj.jdbc.Driver")
                .url(mysqlUri)
                .username(username)
                .password(password)
                .build();
    }

    @Bean(name = "mysqlTransactionManager")
    public JpaTransactionManager mysqlTransactionManager(@Qualifier("entityManagerFactory")LocalContainerEntityManagerFactoryBean entityManagerFactory) throws Exception{
        return new JpaTransactionManager(entityManagerFactory.getObject());
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(@Qualifier("mysql") DataSource mysql){
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(mysql);
        entityManagerFactory.setPackagesToScan("com.sd22.datasource.mysql");
        entityManagerFactory.setPersistenceProvider(new HibernatePersistenceProvider());
        return entityManagerFactory;
    }

}
