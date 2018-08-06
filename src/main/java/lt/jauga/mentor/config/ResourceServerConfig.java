package lt.jauga.mentor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http
                .requestMatchers().antMatchers("/mentor/**", "/posts/**", "/account/**")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.GET,"/mentor/**").access("#oauth2.hasScope('mentor') and #oauth2.hasScope('read')")
                .antMatchers(HttpMethod.POST,"/mentor/**").access("#oauth2.hasScope('mentor') and #oauth2.hasScope('write')")
                .antMatchers(HttpMethod.GET,"/posts/**").access("#oauth2.hasScope('mentor') and #oauth2.hasScope('read')")
                .antMatchers(HttpMethod.POST,"/posts/**").access("#oauth2.hasScope('mentor') and #oauth2.hasScope('write')")
                .antMatchers("/account/**").permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler())
                .and().csrf().disable();
    }

    @Override
    public void configure (final ResourceServerSecurityConfigurer cfg){
        final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(this.tokenStore);
        cfg.tokenServices(defaultTokenServices);
    }
}
