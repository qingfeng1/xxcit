package com.wp.dao;

import org.hibernate.Session;

import com.wp.model.ReRevert;
import com.wp.util.HibernateUtil;
/**
 * 留言回复信息数据库操作类
 * @author 吴鹏
 *
 */
public class ReRevertDao {
	/**
	 * 保存或修改留言回复信息
	 * @param revert Revert对象
	 */
	public void saveReRevert(ReRevert rerevert){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事务
			session.saveOrUpdate(rerevert);		//持久化留言回复信息
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
	public ReRevert getReRevert(Integer id){
		Session session = null;					//Session对象
		ReRevert rerevert = null;					//Message对象
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事务
			//加载Message
			rerevert = (ReRevert)session.get(ReRevert.class, id);
			session.getTransaction().commit(); 	//提交事务
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事务
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return rerevert;
	}
	

}
