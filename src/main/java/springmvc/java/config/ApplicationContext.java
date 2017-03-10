package springmvc.java.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springmvc.java.service.BlogPostService;
import springmvc.java.service.UserService;
import springmvc.java.service.impl.BlogPostServiceImpl;
import springmvc.java.service.impl.UserServiceImpl;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by canogjo on 09/03/2017.
 */
@EnableJpaRepositories(basePackages = {"springmvc.java.dao"})
@EnableTransactionManagement
@Configuration
public class ApplicationContext {

    @Autowired
    private Environment environment;

    @Bean(name = "embedded")
    public DataSource dataSourceEmbedded() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase embeddedDatabase = builder
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("dbschema.sql")
                .addScript("test-data.sql")
                .build();
        return embeddedDatabase;
    }

    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClass.postgresql"));
        dataSource.setUrl(environment.getProperty("jdbc.url.postgresql"));
        dataSource.setUsername(environment.getProperty("jdbc.username.postgresql"));
        dataSource.setPassword(environment.getProperty("jdbc.password.postgresql"));
        return dataSource;
    }

    private DatabasePopulator databasePopulator() {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.setContinueOnError(true);
        databasePopulator.addScript(new ClassPathResource("test-dataPostgresql.sql"));
        return databasePopulator;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
        jpaVendorAdapter.setShowSql(true);
        return jpaVendorAdapter;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
//        DatabasePopulatorUtils.execute(databasePopulator(), dataSource());
        return jpaTransactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactory.setPackagesToScan("springmvc.java.domain");

        Properties jpaProperties = new Properties();
//        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "validate");
        jpaProperties.setProperty("hibernate.default_schema", "test");
        entityManagerFactory.setJpaProperties(jpaProperties);
        return entityManagerFactory;
    }

    @Bean
    public BlogPostService blogPostService() {
        return new BlogPostServiceImpl();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

}
