package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@ComponentScan("web.service")
@EnableTransactionManagement
//@PropertySource(value = "classpath:db.properties")
public class HibernateConfig {

    //@Autowired
    //private Environment environment;

    //1
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");//environment.getRequiredProperty("db.driver"));
        dataSource.setUrl("jdbc:mysql://localhost:3306/yakovlev?serverTimezone=Europe/Minsk&useSSL=false");//environment.getRequiredProperty("db.url"));
        dataSource.setUsername("root");//environment.getRequiredProperty("db.username"));
        dataSource.setPassword("root");//environment.getRequiredProperty("db.password"));
        return dataSource;
    }

    //2
    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(dataSource());
        lcemfb.setPackagesToScan("web");
        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        lcemfb.setJpaVendorAdapter(jpaVendorAdapter);
        lcemfb.setJpaProperties(hibernateProperties());
        return lcemfb;
    }

    //3
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.show_sql", "true");
        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

}
