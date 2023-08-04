/*
 * package com.example.useful.Configuration;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter;
 * 
 * import com.example.useful.service.CustomOAuth2UserService;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class WebSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Autowired private CustomOAuth2UserService oauthUserService;
 * 
 * @Autowired private DataSource dataSource;
 * 
 * // @Override // protected void configure(HttpSecurity http) throws Exception
 * { // http.authorizeRequests() // .antMatchers("/", "/login",
 * "/oauth/**").permitAll() // .anyRequest().authenticated() // .and() //
 * .formLogin().permitAll() // .and() // .oauth2Login() // .loginPage("/login")
 * // .userInfoEndpoint() // .userService(oauthUserService); // }
 * 
 * 
 * 
 * 
 * }
 */