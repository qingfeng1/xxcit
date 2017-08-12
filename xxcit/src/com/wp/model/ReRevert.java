package com.wp.model;

import java.util.Date;

/**
 * 用户回复 回复留言的持久类
 * @author 吴鹏
 *
 */

public class ReRevert {
	private Integer id;//ID 标识
	private String content;//回复内容
	private Integer userid;//被回复信息的人
	
	private Date revertTime;//回复时间
	private User re_userid;//回复留言的用户
	//private Message message;//留言信息
	
	private User re_user;//回复人的id
	
	
	private Revert revert=new Revert();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	public User getRe_user() {
		return re_user;
	}

	public void setRe_user(User re_user) {
		this.re_user = re_user;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRevertTime() {
		return revertTime;
	}

	public void setRevertTime(Date revertTime) {
		this.revertTime = revertTime;
	}



	public User getRe_userid() {
		return re_userid;
	}

	public void setRe_userid(User re_userid) {
		this.re_userid = re_userid;
	}

	public Revert getRevert() {
		return revert;
	}

	public void setRevert(Revert revert) {
		this.revert = revert;
	} 
	
	
	
}
