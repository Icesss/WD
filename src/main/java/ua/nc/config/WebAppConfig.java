package ua.nc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ua.nc.service.UserDetailsServiceImpl;

/**
 * Created by Pavel on 18.04.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan("ua.nc")
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/jsp/**").addResourceLocations("/jsp/");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public UserDetailsService getUserDetailsService() {
        return new UserDetailsServiceImpl();
    }
}
