package lt.jauga.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class CustomPageFilterConfig  {


    // uncomment this and comment the @Component in the filter class definition to register only for a url pattern
    @Bean
    public FilterRegistrationBean<CustomPageFilter> loggingFilter() {
        FilterRegistrationBean<CustomPageFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new CustomPageFilter());

        registrationBean.addUrlPatterns("*");

        return registrationBean;

    }
}
