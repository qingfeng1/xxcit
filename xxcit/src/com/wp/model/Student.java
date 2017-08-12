package com.wp.model;

/**
 * 学生持久化类
 * 
 * 用来储存申请加入社团的学生信息
 * @author 吴鹏
 *
 */

public class Student {
	private int id;//ID编号
	private String name;//学生姓名

	private String number;//学生学号
	private String sex;//学生性别
	private String college;//学生所在学院
	private String major;//学生所在专业
	private String st_class;//学生所在班级
	private String phonenumber;//学生电话号码
	private String qqnumber;//学生电话号码
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSt_class() {
		return st_class;
	}
	public void setSt_class(String st_class) {
		this.st_class = st_class;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getQqnumber() {
		return qqnumber;
	}
	public void setQqnumber(String qqnumber) {
		this.qqnumber = qqnumber;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", number=" + number + ", sex=" + sex + ", college=" + college
				+ ", major=" + major + ", st_class=" + st_class + ", phonenumber=" + phonenumber + ", qqnumber="
				+ qqnumber + "]";
	}
	
	
	
}