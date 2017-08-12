package com.wp.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wp.dao.StudentDao;
import com.wp.model.Student;


/**
 * 学生用户操作Servlet类
 * 通过doPost()方法进行处理
 * @author 吴鹏
 *
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1380736560965055473L;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
		
		
				//学生姓名
				String name = request.getParameter("name");
				//学生性别
				String sex=request.getParameter("sex");
				//学生学号
				String number = request.getParameter("number");
				//学生所在学院
				String college=request.getParameter("college");
				//学生所在专业
				String major=request.getParameter("major");
				//学生所在班级
				String st_class=request.getParameter("st_class");
				
				//学生电话号码
				String phonenumber=request.getParameter("phonenumber");
				//QQ号码 
				String qqnumber=request.getParameter("qqnumber");
				
				
				
				//创建UserDao
				StudentDao dao = new StudentDao();
				//判断用户名是否为null或空的字符串
				
				if(name != null && !name.isEmpty()){
					//判断用户名是否存在
					
					if(dao.findUserByName(name)){
						//如果用户名已存在，进行行错误处理
						
						request.setAttribute("error", "您已报名");
						
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}else{
						//实例化一个Student对象
						Student student = new Student();
						//对Student中的属性赋值
						student.setName(name);
						student.setSex(sex);
						student.setNumber(number);
						student.setCollege(college);
						student.setMajor(major);
						student.setSt_class(st_class);
						student.setPhonenumber(phonenumber);
						student.setQqnumber(qqnumber);
						
						//保存user
						System.out.println("////////////");
						System.out.println("student::==="+student.toString());
						dao.saveUser(student);
						System.out.println("--------------------------");
						System.out.println("dao.findAllUser();"+dao.findAllUser());
						request.setAttribute("info", "恭喜您，报名成功");
						request.getRequestDispatcher("message.jsp").forward(request, response);
					}
				}
			
	}
}
