package com.jsp.soes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

//import com.jsp.soes.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class UserSecurityConfig {

	@Autowired
	private com.jsp.service.CustomUserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain secure(HttpSecurity http) throws Exception {

		http.csrf(c -> c.disable());

		http.authorizeHttpRequests(r -> r
				.requestMatchers("/loginpage", "/entry", "/register", "/login", "/WEB-INF/views/**", "/css/**",
						"/error")
				.permitAll().requestMatchers("/admin/**").hasRole("ADMIN").requestMatchers("/teacher/**")
				.hasRole("TEACHER").requestMatchers("/student/**").hasRole("STUDENT").anyRequest().authenticated());

		http.formLogin(form -> form.loginPage("/loginpage").loginProcessingUrl("/login").usernameParameter("email")
				.passwordParameter("pass").successHandler((request, response, authentication) -> {
					boolean admin = authentication.getAuthorities().stream()
							.anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

					boolean teacher = authentication.getAuthorities().stream()
							.anyMatch(a -> a.getAuthority().equals("ROLE_TEACHER"));

					if (admin) {
						response.sendRedirect(request.getContextPath() + "/admin/dashboard");
					} else if (teacher) {
						response.sendRedirect(request.getContextPath() + "/teacher/dashboard");
					} else {
						response.sendRedirect(request.getContextPath() + "/student/dashboard");
					}
				}).permitAll());

		http.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/loginpage?logout")
				.invalidateHttpSession(true).clearAuthentication(true).permitAll());

		http.authenticationProvider(authenticationProvider());

		return http.build();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
		provider.setPasswordEncoder(encoder());
		return provider;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}