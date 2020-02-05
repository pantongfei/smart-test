package com.briup.smart.web.filter;

 //java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.briup.smart.bean.SmartUserMessages;*/
//import com.briup.smart.common.utils.jwt.JwtTokenUtils;
//import com.briup.smart.service.security.UserDetailService;
/**
* @program: paz
* @description: token过滤器，用来验证token的有效性
* @author: wangzh
* @create: 2019-03-21 15:41
*/
/*public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailService userDetailService;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String token = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
	        if(token != null && StringUtils.startsWith(token, JwtTokenUtils.TOKEN_PREFIX)) {
	            token = StringUtils.substring(token, JwtTokenUtils.TOKEN_PREFIX.length());
	        } else {
	            filterChain.doFilter(request, response);
	            return;
	        }

	        try {
	            String username = JwtTokenUtils.getUsername(token);
	            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	                 
	                 *  注意：
	                 *       这里代码不应该从数据库中去查，而是从缓存中根据token去查，目前只是做测试，无关紧要
	                 *      如果是真正的项目实际开发需要增加缓存
	                 
	                SmartUserMessages userDetails = userDetailService.
	                
	                if (JwtTokenUtils.validateToken(token, userDetails)) {
	                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
	                            userDetails, null, userDetails.getRole_name());
	                    authentication.setDetails(new WebAuthenticationDetails(request));


	                    SecurityContextHolder.getContext().setAuthentication(authentication);
	                }

	            }
	        } catch (Exception e) {
	            response.setContentType("application/json;charset=UTF-8");
	            response.getWriter().write(objectMapper.writeValueAsString(MessageUtil.error(401,"token已失效")));
	            return;
	        }

	        filterChain.doFilter(request, response);
	    }
	}

*/