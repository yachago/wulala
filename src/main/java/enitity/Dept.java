package enitity;

import java.util.HashSet;
import java.util.Set;

public class Dept {

	private Integer deptno;
	private String deptName;
	private String deptDesc;
	private Set<User> users=new HashSet<User>();
	
	
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptDesc() {
		return deptDesc;
	}
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}
	public Dept(Integer deptno, String deptName, String deptDesc) {
		super();
		this.deptno = deptno;
		this.deptName = deptName;
		this.deptDesc = deptDesc;
	}
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", deptName=" + deptName + ", deptDesc=" + deptDesc + "]";
	}
	
	
}
