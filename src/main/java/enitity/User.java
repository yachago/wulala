package enitity;

import java.io.Serializable;

public class User implements Serializable{

	private Integer userId;
	private String userName;
	private String userPwd;
	private Integer userAge;
	private Integer deptno;
	//部门表id
	private Dept dept;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public Integer getUserDp() {
		return deptno;
	}
	public void setUserDp(Integer userDp) {
		this.deptno = userDp;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public User(Integer userId, String userName, String userPwd, Integer userAge, Integer deptno, Dept dept) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userAge = userAge;
		this.deptno = deptno;
		this.dept = dept;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userAge=" + userAge
				+ ", deptno=" + deptno + ", dept=" + dept + "]";
	}
	
	
	
	
}
