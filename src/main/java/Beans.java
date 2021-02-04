import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@Configuration
@ComponentScan(basePackages = {"service","dao"})
@EnableWebMvc
public class Beans {

    @Bean
    public InternalResourceViewResolver view() {
        InternalResourceViewResolver v = new InternalResourceViewResolver();
        v.setPrefix("/WEB-INF/View/");
        v.setSuffix(".jsp");
        return v;
    }

    @Bean
    public DataSource dataSource() {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("db.properties");

        DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        driverManagerDataSource.setUsername("System");
        driverManagerDataSource.setPassword("root");

        return driverManagerDataSource;
    }


    @Bean
    public LocalSessionFactoryBean SessionFactory()
    {

        LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(new String[]{"model"});
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        //sessionFactoryBean.setAnnotatedClasses(new Class[]{model.Customer.class});
        return sessionFactoryBean;

    }

    @Bean
    public Properties hibernateProperties()
    {
        System.out.println("Properties *******************");
        Properties properties=new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle9Dialect");
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.hbm2ddl.auto","create");
        properties.put("hibernate.current_session_context_class","thread");
        //properties.put("hibernate.current_session_context_class","thread");
        return properties;
    }


}
