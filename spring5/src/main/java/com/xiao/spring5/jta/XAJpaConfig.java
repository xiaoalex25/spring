package com.study.transaction.jta;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories
public class XAJpaConfig {

    private static Logger logger = LoggerFactory.getLogger(XAJpaConfig.class);

    @Bean
    public DataSource dataSourceA() {
        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setUniqueResourceName("XADBMSA");
        dataSource.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
        dataSource.setXaProperties(xaAProperties());
        dataSource.setPoolSize(1);
        return dataSource;
    }

    @Bean
    public DataSource dataSourceB() {
        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setUniqueResourceName("XADBMSA");
        dataSource.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
        dataSource.setXaProperties(xaBProperties());
        dataSource.setPoolSize(1);
        return dataSource;
    }

    @Bean
    public Properties xaAProperties() {
        Properties properties = new Properties();
        properties.put("databaseName", "musicdb_a");
        properties.put("user", "prospring5_a");
        properties.put("password", "prospring5_a");
        return properties;
    }

    @Bean
    public Properties xaBProperties() {
        Properties properties = new Properties();
        properties.put("databaseName", "musicdb_b");
        properties.put("user", "prospring5_b");
        properties.put("password", "prospring5_b");
        return properties;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JTATransactionFactory");
        return properties;
    }


}
