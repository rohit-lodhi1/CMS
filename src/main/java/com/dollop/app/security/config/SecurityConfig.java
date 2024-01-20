
package com.dollop.app.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dollop.app.security.InvalidEntry.InvalidAuthenticationEntryPoint;
import com.dollop.app.security.filter.SecurityFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private InvalidAuthenticationEntryPoint invalidAuthenticationEntryPoint;

	@Autowired
	private SecurityFilter securityFilter;

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	String[] apiEmployee = { "/rise/admin/department/** ", "/rise/admin/holidays", "/rise/employee/**",
			"/rise/employee/projectComments/project/{taskId}" };

	String permiteAll[] = { "/rise/auth/**", "/rise/administration/manageJobs/**",
			"/rise/admin/appliedCandidate/create", "/rise/admin/CompanySettings/{id}", "/socket/**" };

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable();

		httpSecurity.authorizeRequests().requestMatchers(permiteAll).permitAll()

				.requestMatchers("/ws/**").permitAll()

				.requestMatchers("/rise/admin/**", "/rise/employee/**").hasAnyAuthority("ADMIN", "EMPLOYEE")

				.anyRequest().authenticated().and().exceptionHandling()
				.authenticationEntryPoint(invalidAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);

		return httpSecurity.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/v3/api-docs/**");
	}
}
