package org.zb.dormitory.entity;

//学生
public class Student {
	
	private int student_id;
	private int student_dormitoryid;
	private String student_username;
	private String student_password;
	private String student_name;
	private String student_sex;
	private String student_class;
	private String student_state;
	
	public Student(){}
	
	public Student(int student_id, int student_dormitoryid, String student_username, String student_password,
			String student_name, String student_sex, String student_class, String student_state) {
		super();
		this.student_id = student_id;
		this.student_dormitoryid = student_dormitoryid;
		this.student_username = student_username;
		this.student_password = student_password;
		this.student_name = student_name;
		this.student_sex = student_sex;
		this.student_class = student_class;
		this.student_state = student_state;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public Integer getStudent_dormitoryid() {
		return student_dormitoryid;
	}
	public void setStudent_dormitoryid(Integer student_dormitoryid) {
		this.student_dormitoryid = student_dormitoryid;
	}
	public String getStudent_username() {
		return student_username;
	}
	public void setStudent_username(String student_username) {
		this.student_username = student_username;
	}
	public String getStudent_password() {
		return student_password;
	}
	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_sex() {
		return student_sex;
	}
	public void setStudent_sex(String student_sex) {
		this.student_sex = student_sex;
	}
	public String getStudent_class() {
		return student_class;
	}
	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}
	public String getStudent_state() {
		return student_state;
	}
	public void setStudent_state(String student_state) {
		this.student_state = student_state;
	}
	

}
