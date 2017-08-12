package com.wp.dao;

import org.hibernate.Session;

import com.wp.model.Revert;
import com.wp.util.HibernateUtil;
/**
 * 留言回复信息数据库操作类
 * @author 吴鹏
 *
 */
public class RevertDao {
	/**
	 * 保存或修改留言回复信息
	 * @param revert Revert对象
	 */
	public void saveRevert(Revert revert){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事务
			session.saveOrUpdate(revert);		//持久化留言回复信息
			session.getTransaction().commit(); 	//提交事务
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事务
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}

	/**
	 * 通过id加载留言信息
	 * @param id 留言id
	 * @return revert对象
	 */
	public Revert getRevert(Integer id){
		Session session = null;					//Session对象
		Revert revert = null;					//Message对象
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事务
			//加载Message
			revert = (Revert)session.get(Revert.class, id);
			session.getTransaction().commit(); 	//提交事务
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事务
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return revert;
	}

		/**
	 * 删除回复信息
	 * @param id 留言id
	 */
	public void deleteRevert(Integer id){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事务
			//加载指定id的留言信息
			Revert revert = (Revert)session.get(Revert.class, id);
			session.delete(revert);			//删除留言
			session.getTransaction().commit(); 	//提交事务
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事务
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	

}
