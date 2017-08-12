package com.wp.service;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wp.dao.MessageDao;
import com.wp.dao.RevertDao;
import com.wp.model.Message;
import com.wp.model.ReRevert;
import com.wp.model.Revert;
import com.wp.model.User;
import com.wp.util.PageModel;

/**
 * 留言Servlet类，通过doPost()方法进行请求处理
 * @author 吴鹏
 *
 */
public class MessageServlet extends HttpServlet {

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
			// 留言
			if ("save".equalsIgnoreCase(method)) {
				
				// 判断用户是否登录
				
				if (!this.isLogin(request, response)) {
					return;
				}
		
				// 标题
				String title = request.getParameter("title");
			
				// 内容
				String content = request.getParameter("content");
				// 如果留言内容含有换行符，将替换为<br>
				if (content.indexOf("\n") != -1) {
					content = content.replaceAll("\n", "<br>");
				}
				// 用户
				User user = (User) request.getSession().getAttribute("user");
				// 创建Message对象并对其进行赋值
				Message message = new Message();
				message.setTitle(title);
				
				message.setContent(content);
				message.setCreateTime(new Date());
				message.setUser(user);
				// 实例化MessageDao
				MessageDao dao = new MessageDao();
				dao.saveMessage(message); // 保存留言
				request.getRequestDispatcher("MessageServlet?method=view")
						.forward(request, response);
			}
			
			//回复留言
			else if("update".equalsIgnoreCase(method)){
				// 判断用户是否登录
				if (!this.isLogin(request, response)) {
					return;
				}
		
				//获取留言的ID号
				String msgId = request.getParameter("id");
				//实例化MessageDao
	
				MessageDao dao = new MessageDao();
				//加载留言
				Message message = dao.getMessage(Integer.valueOf(msgId));
				   System.out.println(message.getId());  
		            
		            System.out.println(message.getContent());  
		            System.out.println(message.getRevert()); 
				
				request.setAttribute("message", message);
				request.getRequestDispatcher("update.jsp").forward(request, response);
			}
			
			// 修改留言
			else if ("updateSave".equalsIgnoreCase(method)) {
							// 判断用户是否登录
							if (!this.isLogin(request, response)) {
									return;
							}
		
							String id=request.getParameter("id");
							
							// 标题
							String title = request.getParameter("title");
							
						
							// 内容
							String content = request.getParameter("content");
							// 如果留言内容含有换行符，将替换为<br>
							if (content.indexOf("\n") != -1) {
								content = content.replaceAll("\n", "<br>");
							}
							// 用户
							User user = (User) request.getSession().getAttribute("user");
							MessageDao dao = new MessageDao(); // 实例化MessageDao
							// 对Message对象进行赋值
							Message message=dao.getMessage(Integer.valueOf(id));
							message.setTitle(title);
							
							message.setContent(content);
							message.setCreateTime(new Date());
							message.setUser(user);
							
							dao.saveMessage(message); // 保存留言
							request.getRequestDispatcher("MessageServlet?method=view")
									.forward(request, response);
						}
			
			
			// 查看留言
			else if ("view".equalsIgnoreCase(method)) {
				// 获取页码
				String page = request.getParameter("currPage");
				int currPage = 1; // 当前页
				int pageSize = 5; // 每页显示5条记录
				// 如果page变量不为空则对currPage赋值
				if (page != null) {
					currPage = Integer.parseInt(page);
				}
				MessageDao dao = new MessageDao(); // 实例化MessageDao
				// 获取分页组件
				PageModel pageModel = dao.findPaging(currPage, pageSize);
				

				
				request.setAttribute("pageModel", pageModel);

				request.getRequestDispatcher("blog.jsp").forward(
						request, response);
				
			}
			
			//删除留言信息
			else if("delete".equalsIgnoreCase(method)){
				String id = request.getParameter("id");
				String username=request.getParameter("user");
				MessageDao dao=new MessageDao();
				Message message=dao.getMessage(Integer.valueOf(id));
				User user=message.getUser();
			
				if(this.isMe(request, response,username,user)){
					if(id != null){
						
						//删除留言信息
						dao.deleteMessage(Integer.valueOf(id));
						
					}
				}
				request.getRequestDispatcher("message_list.jsp").forward(request, response);
			}
			//删除回复信息
			else if("revertdelete".equalsIgnoreCase(method)){
				String id = request.getParameter("id");
				String username=request.getParameter("user");
				RevertDao dao=new RevertDao();
				Revert revert=dao.getRevert(Integer.valueOf(id));
				User user=revert.getUserid();
		
				if(this.isMe(request, response,username,user)){
					if(id != null){
						
						//删除留言信息
						dao.deleteRevert(Integer.valueOf(id));
					}
				}
				request.getRequestDispatcher("message_list.jsp").forward(request, response);
			}
			
			//回复留言
			else if("revert".equalsIgnoreCase(method)){
				// 判断用户是否登录
				if (!this.isLogin(request, response)) {
						return;
				}
				//获取留言的ID号
				String msgId = request.getParameter("id");
				//实例化MessageDao
	
				MessageDao dao = new MessageDao();
				//加载留言
				Message message = dao.getMessage(Integer.valueOf(msgId));
				   System.out.println(message.getId());  
		            
		            System.out.println(message.getContent());  
		            System.out.println(message.getRevert()); 
				
				request.setAttribute("message", message);
				request.getRequestDispatcher("revert.jsp").forward(request, response);
			}
			//保存回复信息
			else if("saveRevert".equalsIgnoreCase(method)){
				//获取留言的ID号
				String msgid = request.getParameter("id");
				
				//获取回复的内容
				String content = request.getParameter("content");
				//如果回复的内容含有换行符，将替换为<br>
				if(content.indexOf("\n") != -1){
					content = content.replaceAll("\n", "<br>");
				}
				// 用户
				User userid = (User) request.getSession().getAttribute("user");
				
				
				//创建MessageDao
				MessageDao dao = new MessageDao();
				//加载留言
				Message message = dao.getMessage(Integer.valueOf(msgid));
				if(message != null){
					/*//从留言中加载回复信息
					Revert revert =  (Revert) message.getRevert();
					
					if(revert == null){
						//创建回复
						revert = new Revert();
					}*/
					
					Revert revert =new Revert();
					revert.setContent(content);
					revert.setRevertTime(new Date());
					revert.setUserid(userid);
					revert.setMessage(message);
					 
					
				
					//向留言中添加回复
				/*	message.setRevert(revert);*/
					message.getRevert().add(revert);
					//更新留言
					dao.saveMessage(message);
				}
				request.getRequestDispatcher("message_list.jsp").forward(request, response);
			}
			
			//回复 留言的回复
			else if("rerevert".equalsIgnoreCase(method)){
				// 判断用户是否登录
				if (!this.isLogin(request, response)) {
						return;
				}
				//获取留言的ID号
				String revertid = request.getParameter("id");
				//实例化RevertDao
				
				RevertDao dao = new RevertDao();
				//加载留言
				Revert revert = dao.getRevert(Integer.valueOf(revertid));
			
				request.setAttribute("revert", revert);
				request.getRequestDispatcher("rerevert.jsp").forward(request, response);
			}
			//保存回复信息
			else if("saveOrUpdateReRevert".equalsIgnoreCase(method)){
				//获取留言的ID号
				
				String revertid = request.getParameter("id");
				
				//获取回复的内容
				String content = request.getParameter("content");
				//如果回复的内容含有换行符，将替换为<br>
				if(content.indexOf("\n") != -1){
					content = content.replaceAll("\n", "<br>");
				}
				// 用户
				User re_userid = (User) request.getSession().getAttribute("user");
				
		

				//创建RevertDao()
				RevertDao dao = new RevertDao();
				//加载留言
				Revert revert = dao.getRevert(Integer.valueOf(revertid));
			
						
				if(revert != null){
					/*//从留言中加载回复信息
					Revert revert =  message.getRevert();
					if(revert == null){
						//创建回复
						revert = new Revert();
					}*/
					//创建回复
					ReRevert rerevert = new ReRevert();
					rerevert.setContent(content);
					rerevert.setRevertTime(new Date());
					rerevert.setRe_userid(re_userid);
					rerevert.setRevert(revert);
				
						
				
					//向留言回复中添加回复
				/*	message.setRevert(revert);*/
					
					revert.getRerevert().add(rerevert);
					//更新留言
					dao.saveRevert(revert);
				}
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
	
	/**
	 * 判断是否是用户本人操作
	 * @param request
	 * @param response
	 * @param user 
	 * @param username 
	 * @throws ServletException
	 * @throws IOException
	 */
	public Boolean isMe(HttpServletRequest request, HttpServletResponse response
			, String username, User user)
			throws ServletException, IOException {
		//判断是否是管理员身份
		if (!username.toString().trim().equals(user.getUsername().toString().trim())) {
			request.setAttribute("error", "对不起，请本人操作");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
			return false;
		}
		return true;
	}

	
	
	
}
