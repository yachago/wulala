package enitity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Project implements Serializable {

	private int proId;
	private String proName;
	private String proLoc;
	
	private Set<Emp> epms=new HashSet<Emp>();

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProLoc() {
		return proLoc;
	}

	public void setProLoc(String proLoc) {
		this.proLoc = proLoc;
	}

	public Set<Emp> getEpms() {
		return epms;
	}

	public void setEpms(Set<Emp> epms) {
		this.epms = epms;
	}

	

	public Project(int proId, String proName, String proLoc) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.proLoc = proLoc;
	}

	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Project [proId=" + proId + ", proName=" + proName + ", proLoc=" + proLoc +  "]";
	}
	
	
}
