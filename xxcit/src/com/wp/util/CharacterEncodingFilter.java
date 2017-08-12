/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wp.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 过滤器
 * @author 吴鹏
 *
 */
public class CharacterEncodingFilter implements Filter{
	
	//字符编码（初始化参数）
    protected String encoding = null;
    //FilterConfig对象
    protected FilterConfig filterConfig = null;
    //初始化方法
    public void init(FilterConfig filterConfig) throws ServletException {
    	//对filterConfig赋值
        this.filterConfig = filterConfig;
        //对初始化参数进行赋值
        this.encoding = filterConfig.getInitParameter("encoding");
    }
    
    //过滤器处理方法
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //判断字符码是否有效
    	if (encoding != null) {
    		//获得request的字符编码
            request.setCharacterEncoding(encoding);
            response.setContentType("text/html; charset=UTF-8");
        }
    	//传递给下一个过滤器
        chain.doFilter(request, response);
    }
    
    //销毁方法 
    public void destroy() {
    	//释放资源
        this.encoding = null;
        this.filterConfig = null;
    }
}
