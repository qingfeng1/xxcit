package com.wp.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户留言回复持久化类
 * @author 吴鹏
 *
 */

public class Revert {
	private Integer id;//回复ID
	private String content;//回复内容
	private Date revertTime;//回复时间
	private User userid;//回复留言的用户
	//private Message message;//留言信息
	
	private Message message=new Message(); 
	
	private Set<ReRevert> rerevert = new HashSet<ReRevert>(); 
	

	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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


	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public User getUserid() {
		return userid;
	}
	public void setUserid(User userid) {
		this.userid = userid;
	}
	public Set<ReRevert> getRerevert() {
		return rerevert;
	}
	public void setRerevert(Set<ReRevert> rerevert) {
		this.rerevert = rerevert;
	}
	
	
	

}
