package com.wp.service;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wp.dao.UserDao;
import com.wp.model.Administrator;
import com.wp.model.Guest;
import com.wp.model.User;
/**
 *   用户操作Servlet类
 * 通过doPost()方法进行处理
 * @author 吴鹏
 *
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1380736560965055473L;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//请求参数
		String method = request.getParameter("method");
		if(method != null){
			//用户注册
			if("guestReg".equalsIgnoreCase(method)){
				/*
				 * 校验验证码
				 * 1. 从session中获取正确的验证码
				 * 2. 从表单中获取用户填写的验证码
				 * 3. 进行比较！
				 * 4. 如果相同，向下运行，否则保存错误信息到request域，转发到error.jsp
				 */
				String sessionCode = (String) request.getSession().getAttribute("Code");
				String paramCode = request.getParameter("paramCode");
				
				if(!paramCode.equalsIgnoreCase(sessionCode)) {
					request.setAttribute("error", "验证码错误！");
					request.getRequestDispatcher("error.jsp").forward(request, response);
					return;
				}
				
				//用户名
				String username = request.getParameter("username");
				//密码
				String password = request.getParameter("password");
				//头像 
				Random random = new Random();
				String img_head="images/img_head/"+random.nextInt(10)+".jpg";
				//创建UserDao
				UserDao dao = new UserDao();
				//判断用户名是否为null或空的字符串
				if(username != null && !username.isEmpty()){
					//判断用户名是否存在
					if(dao.findUserByName(username)){
						//如果用户名已存在，进行行错误处理
						request.setAttribute("error", "您注册的用户名已存在！");
						System.out.println("您注册的用户名已存在！");
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}else{
						//实例化一个User对象
						User user = new Guest();
						//对user中的属性赋值
						user.setUsername(username);
						user.setPassword(password);
						user.setImg_head(img_head);
						
						//保存user
						dao.saveUser(user);
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				}
			}
			//用户登录
			else if("userLogin".equalsIgnoreCase(method)){
				/*
				 * 校验验证码
				 * 1. 从session中获取正确的验证码
				 * 2. 从表单中获取用户填写的验证码
				 * 3. 进行比较！
				 * 4. 如果相同，向下运行，否则保存错误信息到request域，转发到error.jsp
				 */
				String sessionCode = (String) request.getSession().getAttribute("Code");
				String paramCode = request.getParameter("paramCode");
				
				if(!paramCode.equalsIgnoreCase(sessionCode)) {
					request.setAttribute("error", "验证码错误！");
					request.getRequestDispatcher("error.jsp").forward(request, response);
					return;
				}
				
				
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				//实例化UserDao
				UserDao dao = new UserDao();
				//根据用户名、密码查询User
				User user = dao.findUser(username, password);
				//判断用户是否登录成功
				if(user != null){
					//判断user是否是管理员对象
					if(user instanceof Administrator){
						//将管理员对象放入到session中
						request.getSession().setAttribute("admin", user);
					}
					//将用户对象放入到session中
					request.getSession().setAttribute("user", user);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}else{
					//登录失败
					request.setAttribute("error", "用户名或密码错误 ！");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}
			//退出登录
			else if("exit".equalsIgnoreCase(method)){
				request.getSession().removeAttribute("user");
				if(request.getSession().getAttribute("admin") != null){
					request.getSession().removeAttribute("admin");
				}
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}
