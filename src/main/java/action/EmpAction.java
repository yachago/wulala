package action;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import enitity.Emp;
import util.HibernateUtil;

public class EmpAction extends ActionSupport {

	private List<Emp> list=new ArrayList<Emp>();
	private Integer age1;
	private Integer age2;
	private String ename;
	private String date;
	private String edate;
	private List<Emp> Clist=new ArrayList<Emp>();
	


	public Integer getAge1() {
		return age1;
	}


	public void setAge1(Integer age1) {
		this.age1 = age1;
	}


	public Integer getAge2() {
		return age2;
	}


	public void setAge2(Integer age2) {
		this.age2 = age2;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getEdate() {
		return edate;
	}


	public void setEdate(String edate) {
		this.edate = edate;
	}


	public List<Emp> getClist() {
		return Clist;
	}


	public void setClist(List<Emp> clist) {
		Clist = clist;
	}


	public List<Emp> getList() {
		return list;
	}


	public void setList(List<Emp> list) {
		this.list = list;
	}


	public String getAllEmp()throws Exception{
		System.out.println("ok---->");
		Session session=HibernateUtil.getSession();
		String sql="from Emp";
		Query q=session.createQuery(sql);
		list=q.list();
		Map map=(Map) ActionContext.getContext().get("request");
		map.put("allEmp", list);
		HibernateUtil.closeSession();
		return "success";
	}
	public String chooseGet()throws Exception{
		System.out.println("是否存在数据"+age1+"--->"+ename);
		boolean f1=false;
		boolean f2=false;
		if(ename ==null || "".equals(ename)){
        	f1=true;
        }
		 if(edate !=null &&"".equals(edate)){
			 f2=true;
		 }
		if(age1==null &&age2==null && f1 && f2){
			Session session=HibernateUtil.getSession();
			String sql="from Emp";
			Query q=session.createQuery(sql);
			Clist=q.list();
			Map map=(Map) ActionContext.getContext().get("request");
			map.put("allEmp", Clist);
			HibernateUtil.closeSession();
			System.out.println("全是控");
			return "success";
		}
		else{
			Session session=HibernateUtil.getSession();
			Criteria c=session.createCriteria(Emp.class);
			Disjunction ds=Restrictions.disjunction();
			if(age1!=null && age2 !=null){
				ds.add(Restrictions.between("empAge", age1, age2));
			}
			if(age1==null){
				ds.add(Restrictions.le("empAge", age2));
			}
            if(age2==null){
				ds.add(Restrictions.ge("empAge", age1));
			}
            if(ename !=null && !"".equals(ename)){
            	ds.add(Restrictions.like("empName", "%"+ename+"%"));
            }
            if(edate !=null &&!"".equals(edate)){
            	
        		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        		String dateString = formatter.format(currentTime);
//        		ParsePosition pos = new ParsePosition(8);
        		Date curr;
        		curr = formatter.parse(edate);
            	if("1".equals(date)){
            		ds.add(Restrictions.le("hireDate", curr));
            	}
            	else{
            		ds.add(Restrictions.ge("hireDate", curr));
            	}
            }
            c.add(ds);
            Clist=c.list();
            System.out.println("aaaaaaaaaaa"+Clist);
            Map map=(Map) ActionContext.getContext().get("request");
    		map.put("chooseEmp", Clist);
    		HibernateUtil.closeSession();
		}
		return "success";
	}
}
