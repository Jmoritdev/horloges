package nl.inholland.config;


import nl.inholland.filter.ApiKeyFilter;
import nl.inholland.repository.ApiKeyRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@Order(2)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private ApiKeyRepository apiKeyRepository;

    public SecurityConfig (ApiKeyRepository apiKeyRepository){
        this.apiKeyRepository = apiKeyRepository;
    }

    @Value("X-AUTHTOKEN")
    private String header;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("{noop}password")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/").permitAll()// Everybody can see root
                .antMatchers(HttpMethod.POST, "/horloges/**").hasRole("ADMIN") // Only Admin can POST
                .antMatchers(HttpMethod.GET,"/horloges/**").permitAll() // All users can GET
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll(); // The login page can be seen by everybody

        ApiKeyFilter filter = new ApiKeyFilter(header);

        filter.setAuthenticationManager(authentication -> {
            String principal = (String) authentication.getPrincipal();

            if (!apiKeyRepository.findById(principal).isPresent()) {
                throw new BadCredentialsException("API Key not found");
            }

            authentication.setAuthenticated(true);
            return authentication;
        });

        http
                .antMatcher("/horloges/**")
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(filter).authorizeRequests()
                .anyRequest().authenticated();
    }

//    @Override
//    protected void configure (HttpSecurity http ) throws Exception{
//
//        ApiKeyFilter filter = new ApiKeyFilter(header);
//
//        filter.setAuthenticationManager(authentication -> {
//            String principal = (String) authentication.getPrincipal();
//
//            if (!apiKeyRepository.findById(principal).isPresent()) {
//                throw new BadCredentialsException("API Key not found");
//            }
//
//            authentication.setAuthenticated(true);
//            return authentication;
//        });
//
//        http
//                .antMatcher("/horloges/**")
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .addFilter(filter).authorizeRequests()
//                .anyRequest().authenticated();
//    }
}
