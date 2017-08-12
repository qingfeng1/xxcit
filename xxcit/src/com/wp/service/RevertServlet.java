package com.wp.service;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wp.dao.ReRevertDao;
import com.wp.model.ReRevert;
import com.wp.model.Revert;
import com.wp.model.User;

/**
 * 回复Servlet类，通过doPost()方法进行请求处理
 * @author 吴鹏
 *
 */
public class RevertServlet extends HttpServlet {

	private static final long serialVersionUID = 6018004479179335118L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求类型
		String method = request.getParameter("method");
		if (method != null) {
			
			
			//回复 回复 留言的回复
			if("reply".equalsIgnoreCase(method)){
				// 判断用户是否登录
				if (!this.isLogin(request, response)) {
						return;
				}
				//获取留言的ID号
				String rerevertid = request.getParameter("id");
				//实例化RevertDao
				
				ReRevertDao dao = new ReRevertDao();
				//加载留言
				ReRevert rerevert = dao.getReRevert(Integer.valueOf(rerevertid));
		
				request.setAttribute("rerevert", rerevert);
				request.getRequestDispatcher("reply.jsp").forward(request, response);
			}
			//保存回复信息
			else if("saveOrUpdateReply".equalsIgnoreCase(method)){
				//获取留言的ID号
				String rerevertid = request.getParameter("id");
				//实例化RevertDao
				
				ReRevertDao dao = new ReRevertDao();
				//加载留言
				ReRevert rerevert = dao.getReRevert(Integer.valueOf(rerevertid));
				
				Revert revert=rerevert.getRevert();
			
				
				//获取回复的内容
				String content = request.getParameter("content");
				//如果回复的内容含有换行符，将替换为<br>
				if(content.indexOf("\n") != -1){
					content = content.replaceAll("\n", "<br>");
				}
				
				User re_user=rerevert.getRe_userid();
				// 用户
				User re_userid = (User) request.getSession().getAttribute("user");
				
				//创建回复
				ReRevert rerevert1 = new ReRevert();
				
				rerevert1.setContent(content);
				rerevert1.setRevertTime(new Date());
				rerevert1.setRe_user(re_user);
				rerevert1.setRe_userid(re_userid);
				
				rerevert1.setRevert(revert);
				//更新留言
				dao.saveReRevert(rerevert1);
				
				request.getRequestDispatcher("message_list.jsp").forward(request, response);
			}
			
			

		} else {
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		}
	}


	/**
	 * 判断用户是否登录
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @return true  用户已登录  false 未登录
	 */
	public boolean isLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 判断session中的user值是否为null
		if (request.getSession().getAttribute("user") == null) {
			// 用户没有登录进行错误处理
			request.setAttribute("error", "对不起，您还没有登录！");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
			return false;
			
		}
		return true;
	}
}
