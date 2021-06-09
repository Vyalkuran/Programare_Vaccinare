package com.programarevaccinnare.programare_vaccinare.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SimpleAuthenticationSuccessHandler successHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.jdbcAuthentication()
                .usersByUsernameQuery("select email, parola, 'true' as enabled "+
                        "from UTILIZATORI where email = ?" )
                .authoritiesByUsernameQuery("select u.email, a.autoritate "+
                        "from AUTORITATI a join UTILIZATORI u on u.id=a.utilizator_id where u.email = ?")
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login"))
                .and()
                .authorizeRequests()
                .antMatchers("/", "/register", "/register/save").permitAll()
                .antMatchers("/profile").hasAuthority("UTILIZATOR_CREAT")
                .antMatchers("/home").hasAuthority("PROFIL_CREAT")
                .and()
                .formLogin()
                .successHandler(successHandler)
                .defaultSuccessUrl("/", true)
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .requestCache();
//        httpSecurity.headers().frameOptions().sameOrigin();
    }

}