package springmvc.java.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Configuration class dispatcher-servlet.xml
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"springmvc.java"})
@Import(ApplicationContext.class)
@PropertySource("classpath:application.properties")
public class WebConfig extends WebMvcConfigurerAdapter {

    // more custom rules/beans

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // index mapping
        // / -> index.jsp
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/newblogpost.html").setViewName("/newblogpost");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        // string to views
        // success from a controller -> prefix/success/suffix
        // success from a controller -> /WEB-INF/pages/success.jsp
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }


}
