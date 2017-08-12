package com.wp.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;

import com.wp.model.User;
import com.wp.util.HibernateUtil;

/**
 * 用户数据库处理类
 * @author 吴鹏
 *
 */
public class UserDao {
	/**
	 * 保存用户
	 * @param user User对象
	 */
	public void saveUser(User user){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事务
			session.save(user);					//持久化user
			session.getTransaction().commit(); 	//提交事务
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事务
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	/**
	 * 查询所有用户信息
	 * @return List集合
	 */
	public List<User> findAllUser(){
		Session session = null;					//Session对象
		List<User> list = null;					//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事务
			String hql = "from User";
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
	 * 通过用户名和密码查询用户
	 * 用于登录
	 * @param username 用户名
	 * @param password 密码
	 * @return User对象
	 */
	public User findUser(String username, String password){
		Session session = null;					//Session对象
		User user = null;						//用户
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事务
			//HQL查询语句
			String hql = "from User u where u.username=? and u.password=?";
			Query query = session.createQuery(hql)		//创建Query对象
								.setParameter(0, username)//动态赋值
								.setParameter(1, password);//动态赋值
			user = (User)query.uniqueResult();			//返回User对象
			session.getTransaction().commit(); 	//提交事务
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事务
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return user;
	}
	/**
	 * 判断指定用户名的用户是否存在
	 * @param username 用户名
	 * @return
	 */
	public boolean findUserByName(String username){
		Session session = null;					//Session对象
		boolean exist = false;
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事务
			//HQL查询语句
			String hql = "from User u where u.username=?";
			Query query = session.createQuery(hql)		//创建Query对象
								 .setParameter(0, username);//动态赋值
			Object user = query.uniqueResult();			//返回User对象
			//如果用户存在exist为true
			if(user != null){
				exist = true;
			}
			session.getTransaction().commit(); 	//提交事务
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事务
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
		return exist;
	}
}
