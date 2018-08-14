package enitity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Emp implements Serializable {

	private Integer empId;
	private String empName;
	private Integer empAge;
	private Date hireDate;
	//做项目的员工集合
	private Set<Project> projects=new HashSet<Project>();
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getEmpAge() {
		return empAge;
	}
	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	public Emp(Integer empId, String empName, Integer empAge, Date hireDate, Set<Project> projects) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.hireDate = hireDate;
		this.projects = projects;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", hireDate=" + hireDate
				+ ", projects=" + projects + "]";
	}
	
	
}
