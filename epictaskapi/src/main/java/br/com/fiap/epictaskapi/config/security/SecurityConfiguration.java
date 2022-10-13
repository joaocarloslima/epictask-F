package br.com.fiap.epictaskapi.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    
        http
            .httpBasic()
            .and()
            .authorizeHttpRequests()
                // Tarefas
                .antMatchers(HttpMethod.GET, "/api/task/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/task").authenticated()
                .antMatchers(HttpMethod.DELETE, "/api/task").hasRole("ADMIN")
                
                // Usuários
                .antMatchers(HttpMethod.GET, "/api/user/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/user").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/user/**").authenticated()
                .antMatchers(HttpMethod.PUT, "/api/user/**").authenticated()
                
                // Web
                .antMatchers(HttpMethod.GET, "/task").authenticated()
                .antMatchers(HttpMethod.POST, "/task").hasRole("ADMIN")

                
                // Infra
                .antMatchers("/h2-console/**").permitAll()
                
               
                .anyRequest().permitAll()
            .and()
                .csrf().disable()
                .headers().frameOptions().disable()
            .and()
                //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            //.and()
                .formLogin()
                //.loginPage("/minhapaginadelogin")
        ;

       return http.build();
    }

    // @Bean
    // public UserDetailsService users(){
    //     UserDetails user = User.builder()
    //         .username("joao@fiap.com.br")
    //         .password(new BCryptPasswordEncoder().encode("123"))
    //         .roles("USER")
    //     .build();

    //     return new InMemoryUserDetailsManager(user);
    // }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}
