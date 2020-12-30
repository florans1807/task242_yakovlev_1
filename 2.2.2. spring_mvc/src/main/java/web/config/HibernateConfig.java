package web.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
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

    @Autowired
    private Environment environment;

    //1
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");//environment.getRequiredProperty("db.driver"));
        dataSource.setUrl("jdbc:h2:C:db.mv.db/yakovlev;MV_STORE=false");//environment.getRequiredProperty("db.url"));
        dataSource.setUsername("root");//environment.getRequiredProperty("db.username"));
        dataSource.setPassword("Loskov10");//environment.getRequiredProperty("db.password"));
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

        /*lcemfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        lcemfb.setPersistenceUnitName("myJpaPersistenceUnit");*/

        return lcemfb;
    }

    //3
    private final Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", "none");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");//environment.getRequiredProperty("hibernate.dialect"));
        //properties.put("hibernate.show_sql", "true");//environment.getRequiredProperty("hibernate.show_sql"));
        return properties;
    }


    //4
    /*@Bean
    public JpaTransactionManager getJpaTransactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(getEntityManagerFactoryBean().getObject());
        return jpaTransactionManager;
    }*/


    //4
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }


  /*  @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("web.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }*/

   /* @Bean
    public JpaVendorAdapter getJpaVendorAdapter() {
        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        return adapter;
    }*/
}
