package com.wp.model;
/**
 * 用户持久化类
 * @author 吴鹏
 *
 */

public class User {

	private Integer id;			//ID编号
	private String username;	//用户名
	private String password;	//密码
	private String img_head;    //用户头像
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getImg_head() {
		return img_head;
	}
	public void setImg_head(String img_head) {
		this.img_head = img_head;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
