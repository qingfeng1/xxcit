package com.wp.service;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wp.dao.MessageDao;
import com.wp.model.Message;
import com.wp.model.Revert;

/**
 * 系统管理的Servlet类,
 * 只有管理员权限可以操作
 * @author 吴鹏
 *
 */
public class ManagerServlet extends HttpServlet {

	private static final long serialVersionUID = 47334074575945894L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//判断管理员是否具有管理员权限
		this.isAdmin(request, response);
		//获取请求类型
		String method = request.getParameter("method");
		//删除留言信息
		if("delete".equalsIgnoreCase(method)){
			String id = request.getParameter("id");
			if(id != null){
				//实例化MessageDao
				MessageDao dao = new MessageDao();
				//删除留言信息
				dao.deleteMessage(Integer.valueOf(id));
			}
			request.getRequestDispatcher("message_list.jsp").forward(request, response);
		}
		//回复留言
		else if("revert".equalsIgnoreCase(method)){
			//获取留言的ID号
			String msgId = request.getParameter("id");
			//实例化MessageDao
			MessageDao dao = new MessageDao();
			//加载留言
			Message message = dao.getMessage(Integer.valueOf(msgId));
			request.setAttribute("message", message);
			request.getRequestDispatcher("admin_revert.jsp").forward(request, response);
		}
		//保存回复信息
		else if("saveOrUpdateRevert".equalsIgnoreCase(method)){
			//获取留言的ID号
			String msgId = request.getParameter("id");
			//获取回复的内容
			String content = request.getParameter("content");
			//如果回复的内容含有换行符，将替换为<br>
			if(content.indexOf("\n") != -1){
				content = content.replaceAll("\n", "<br>");
			}
			//创建MessageDao
			MessageDao dao = new MessageDao();
			//加载留言
			Message message = dao.getMessage(Integer.valueOf(msgId));
			if(message != null){
				//从留言中加载回复信息
				Revert revert = (Revert) message.getRevert();
				if(revert == null){
					//创建回复
					revert = new Revert();
				}
				revert.setContent(content);
				revert.setRevertTime(new Date());
				//向留言中添加回复
				message.getRevert().add(revert);
				//更新留言
				dao.saveMessage(message);
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		//没有传递参数值method
		else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	/**
	 * 判断用户是否具有管理员权限
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void isAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//判断是否是管理员身份
		if (request.getSession().getAttribute("admin") == null) {
			request.setAttribute("error", "对不起，您没有权限进行操作！");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
			return;
		}
	}

}
