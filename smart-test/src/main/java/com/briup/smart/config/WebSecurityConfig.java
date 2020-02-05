package com.briup.smart.config;

/*import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;*/
/**
 * ClassName:WebSecurityConfig <br/>
 * Function: security 配置类 <br/>
 * Date:  <br/>
 *
 * @author wangzh
 * @version
 * @since JDK 1.8
 * @see
 */
/*@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	//密码加密处理
	 @Bean
	    public PasswordEncoder getPasswordEncoderBean() {
	        return new BCryptPasswordEncoder();
	    }
    //实现token验证
	    @Bean
	    public JwtAuthenticationTokenFilter getauthenticationTokenFilterBean() {
	        return new JwtAuthenticationTokenFilter();
	    }
    //登录成功后的处理器
	    @Bean
	    public LoginSuccessHandler getLoginSuccessHandler() {
	        return new LoginSuccessHandler();
	    }
    //登录失败后的处理器
	    @Bean
	    public LoginFailHandler getLoginFailHandler() {
	        return new LoginFailHandler();
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    http.formLogin()
	            .loginPage("/authenticaion/login")          //登录时访问的地址
	            .loginProcessingUrl("/authentication/form") //登录的url地址
	            .successHandler(getLoginSuccessHandler())
	            .failureHandler(getLoginFailHandler())
	            .and()
	            .csrf().disable() //使用jwt，不需要csrf
	            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //基于token，不需要session
	            .and()
	            .authorizeRequests()
	            // 设置允许访问的资源
	            .antMatchers("/authenticaion/login").permitAll()
	            // 设置允许访问的资源
	            .antMatchers("/webjars/**").permitAll()
	            .antMatchers(
	                        "/v2/api-docs",
	                        "/swagger-resources",
	                        "/swagger-resources/**",
	                        "/configuration/ui",
	                        "/configuration/security",
	                        "/swagger-ui.html/**",
	                        "/webjars/**"

	                ).permitAll()
	                .anyRequest().authenticated();

	         // 禁用缓存
	        http.headers().cacheControl();

	        // 添加JWT filter
	        http.addFilterBefore(getauthenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
	    }

	
}
*/