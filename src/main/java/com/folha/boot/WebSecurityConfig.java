package com.folha.boot;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;





@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private com.folha.boot.service.seguranca.UsuarioService usuarioService;
	
	@Autowired
	private DataSource dataSource;

	public AuthenticationFilter authenticationFilter() throws Exception {
		AuthenticationFilter filter = new AuthenticationFilter();
		filter.setAuthenticationManager(authenticationManagerBean());
		
		filter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler() {
			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
												AuthenticationException exception) throws IOException, ServletException {
				System.out.println("Login error: " + exception.getMessage());
				super.setDefaultFailureUrl("/login?msg=" + exception.getMessage());
				super.onAuthenticationFailure(request, response, exception);
			}
		});
		
		
		return filter;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.cors();
		
		http
		.addFilterBefore(authenticationFilter(),
				UsernamePasswordAuthenticationFilter.class)
		
		.authorizeRequests()
		
			//Permissões
			//.antMatchers("/anomes/**").hasAnyAuthority("ANO_MES")
			//.antMatchers("/areasdecapacitacoes/**").hasAnyAuthority("PERMISSAO 3")
		
		
			.antMatchers("/css/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/fonts/**").permitAll()
			.antMatchers("/img/**").permitAll()
			.antMatchers("/image/**").permitAll()
			.anyRequest().authenticated().and()

				.formLogin(form -> form.loginPage("/login")
						
						.failureHandler(new AuthenticationFailureHandler() {
							@Override
							public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
								String email = request.getParameter("email");
								String error = exception.getMessage();
								System.out.println("Teste: " + error);
								String redirectUrl = request.getContextPath() + "/login?error";
								response.sendRedirect(redirectUrl);
							}
						})
						
				.defaultSuccessUrl("/", true).permitAll())
				
				.logout(logout -> logout.logoutUrl("/logout")).csrf().disable()
				.exceptionHandling().accessDeniedPage("/acesso-negado")
				
				
				
			
		.and()	
			.sessionManagement()
				.maximumSessions(30)
				.expiredUrl("/login");
			
				
				
	}
	

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		
		auth.userDetailsService(usuarioService).passwordEncoder(encoder);
		
		//Usuário inicial
		//UserDetails user = 
		//		User.builder()
		//		.username("marcos")
		//		.password(encoder.encode("123"))
		//		.roles("ADM")
		//		.build();

		//Utilizando autenticação automática
//		auth.jdbcAuthentication()
//			.dataSource(dataSource)
//			.passwordEncoder(encoder);
			//.withUser(user);
	}
	
	
	
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		// Usuário inicial comentar após a ciração do usuário
		
		
		//  UserDetails user = User.builder() .username("marlon")
		//  .password(encoder.encode("123")) .roles("ADM") .build();
		

		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encoder);
		
		
		//.withUser(user);
		
	
	}
	*/
	
	
	
	
	

	
}
