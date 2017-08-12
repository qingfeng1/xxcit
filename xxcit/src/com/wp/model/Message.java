package com.wp.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



/**
 * 留言信息持久类
 * @author 吴鹏
 *
 */

public class Message {

	private Integer id;//IDbianhao 
	private String title;//标题
	private String content;//留言内容
	private Date createTime;//创建时间
	//private Revert revert;//回复内容
	private User user;//留言用户
	
	private Set<Revert> revert = new HashSet<Revert>(); 
	

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Set<Revert> getRevert() {
		return revert;
	}
	public void setRevert(Set<Revert> revert) {
		this.revert = revert;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", title=" + title + ", content=" + content + ", createTime=" + createTime
				+ ", user=" + user + ", revert=" + revert + "]";
	}

	
	
	
	
}
