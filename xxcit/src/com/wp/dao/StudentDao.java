package com.wp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.wp.model.Student;
import com.wp.util.HibernateUtil;


/**
 * 学生用户数据库处理类
 * @author 吴鹏
 *
 */
public class StudentDao {
	/**
	 * 保存用户
	 * @param user User对象
	 */
	public void saveUser(Student student){
		Session session = null;					//Session对象	
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事务
			session.save(student);					//持久化student
			session.getTransaction().commit(); 	//提交事务
		} catch (Exception e) {
			e.printStackTrace();				//打印异常信息
			session.getTransaction().rollback();//回滚事务
		}finally{
			HibernateUtil.closeSession();		//关闭Session
		}
	}
	/**
	 * 查询所有学生用户信息
	 * @return List集合
	 */
	public List<Student> findAllUser(){
		Session session = null;					//Session对象
		List<Student> list = null;					//List集合
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事务
			String hql = "from Student";
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
	public Student findUser(String username, String password){
		Session session = null;					//Session对象
		Student user = null;						//用户
		try {
			//获取Session
			session = HibernateUtil.getSession();
			session.beginTransaction();			//开启事务
			//HQL查询语句
			String hql = "from User u where u.username=? and u.password=?";
			Query query = session.createQuery(hql)		//创建Query对象
								.setParameter(0, username)//动态赋值
								.setParameter(1, password);//动态赋值
			user = (Student)query.uniqueResult();			//返回User对象
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
	 * 判断指定姓名的判断学生用户是否存在
	 * @param name 用户名
	 * @return
	 */
	public boolean findUserByName(String name){
		Session session = null;					//Session对象
		boolean exist = false;
		try {
			//获取Session
			
			session = HibernateUtil.getSession();
			
			session.beginTransaction();			//开启事务
			System.out.println("???session");
			System.out.println("session"+session);
			//HQL查询语句
			
			String hql = "from Student u where u.name=?";
	
			Query query = session.createQuery(hql)		//创建Query对象
								.setParameter(0, name);//动态赋值
			
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
