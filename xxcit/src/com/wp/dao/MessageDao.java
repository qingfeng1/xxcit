package com.wp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.wp.model.Message;
import com.wp.model.Revert;
import com.wp.util.HibernateUtil;
import com.wp.util.PageModel;
/**
 * 留言信息数据库操作类
 * @author 吴鹏
 *
 */
public class MessageDao {
	/**
	 * 保存或修改留言信息
	 * @param message Message对象
	 */
	public void saveMessage(Message message){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事务
			session.saveOrUpdate(message);		//持久化留言信息
			session.getTransaction().commit(); 	//提交事务
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事务
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	/**
	 * 删除留言信息
	 * @param id 留言id
	 */
	public void deleteMessage(Integer id){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事务
			//加载指定id的留言信息
			Message message = (Message)session.get(Message.class, id);
			session.delete(message);			//删除留言
			session.getTransaction().commit(); 	//提交事务
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事务
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	/**
	 * 查询所有留言信息
	 * @return List集合
	 */
	public List<Message> findAllMessage(){
		Session session = null;					//Session对象
		List<Message> list = null;				//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事务
			String hql = "from Message";		//HQL查询语句
			list = session.createQuery(hql)		//创建Query对象
				          .list();				//获取结果集
			session.getTransaction().commit(); 	//提交事务
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事务
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return list;
	}
	/**
	 * 通过id加载留言信息
	 * @param id 留言id
	 * @return Message对象
	 */
	public Message getMessage(Integer id){
		Session session = null;					//Session对象
		Message message = null;					//Message对象
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事务
			//加载Message
			message = (Message)session.get(Message.class, id);
			session.getTransaction().commit(); 	//提交事务
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事务
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return message;
	}
	/**
	 * 分页查询留言信息
	 * @param currPage	当前页
	 * @param pageSize	每页记录数
	 * @return	PageModel 自定义分页组件
	 */
	public PageModel findPaging(int currPage, int pageSize){
		Session session = null;					//Session对象
		PageModel pageModel = null;
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事务
			


			//HQL查询语句，按留言时间降序排序
			String hql = "from Message m order by m.createTime desc";
			
		
			List<Message> list = session.createQuery(hql)		//创建Query对象
		  					.setFirstResult((currPage - 1) * pageSize)	//设置起始位置
		  					.setMaxResults(pageSize)	//设置记录数
		  					.list();	//返回结果集
	
			pageModel = new PageModel();		//实例化pageModel
			pageModel.setCurrPage(currPage);	//设置当前页
			pageModel.setList(list);			//设置结果集
			
			pageModel.setPageSize(pageSize);	//设置每页记录数
			//设置总记录数
			pageModel.setTotalRecords(getTotalRecords(session));
			session.getTransaction().commit(); 	//提交事务
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事务
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return pageModel;
	} 
	/**
	 * 查询留言的总记录数
	 * 
	 * @param session
	 *            Session对象
	 * @return 总记录数
	 */
	public int getTotalRecords(Session session) {
		// HQL查询语句
		String hql = "select count(*) from Message";
		// 创建Query对象
		Query query = session.createQuery(hql);
		// 单值检索
		Long totalRecords = (Long) query.uniqueResult();
		// 返回总记录数
		return totalRecords.intValue();
	}
}
