package org.sid.security;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityController extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	@Autowired
	MyLoginServiseDetails userServise;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	
		/*
		 * auth.jdbcAuthentication().dataSource(dataSource) .usersByUsernameQuery(
		 * "select username as principal, pwd as credentials, active from login where username =?"
		 * ) .authoritiesByUsernameQuery(
		 * "select username as principal,role as role from users_roles where username =?"
		 * ). rolePrefix("ROLE_"). passwordEncoder(NoOpPasswordEncoder.getInstance() ) ;
		 */
		auth.authenticationProvider(authenticationProvider());
		
	}
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
    	DaoAuthenticationProvider daoAuth = new DaoAuthenticationProvider();
    	daoAuth.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
    	daoAuth.setUserDetailsService(userServise);
    	return daoAuth;
    }
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.formLogin(); 
	//	http.formLogin().loginPage("/login"); //

	//

		http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/user/*").hasRole("USER");
		http.authorizeRequests().antMatchers("/home","/login","/css/**").permitAll();
		http.exceptionHandling().accessDeniedPage("/403");
		//http.authorizeRequests().anyRequest().authenticated();
		
	}
	
	
}
