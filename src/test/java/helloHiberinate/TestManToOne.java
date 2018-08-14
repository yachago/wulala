package helloHiberinate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import enitity.Dept;
import enitity.Emp;
import enitity.Project;
import enitity.User;
import junit.framework.TestCase;

public class TestManToOne extends TestCase {
	
	Configuration config;
	SessionFactory sf;
	Session session ;
	Transaction tx ;
	//多对一，
	public void testFind(){
		config=new Configuration().configure();
		sf=config.buildSessionFactory();
		session=sf.openSession();
		tx=session.beginTransaction();
		User user=(User)session.get(User.class, 1);
		System.out.println(user);
		
		
	}
	//一对多，一个部门查多少员工
	public void testFind2(){
		config=new Configuration().configure();
		sf=config.buildSessionFactory();
		session=sf.openSession();
		tx=session.beginTransaction();
		Dept dept=(Dept)session.get(Dept.class, 3);
		System.out.println(dept);
		System.out.println(dept.getUsers());
	}

	//级联添加
		public void testAdd(){
			config=new Configuration().configure();
			sf=config.buildSessionFactory();
			session=sf.openSession();
			tx=session.beginTransaction();
			Dept dept=new Dept();
			dept.setDeptName("markoche");
			
			User user=new User();
			user.setUserName("小猪佩奇");
			User user2=new User();
			user2.setUserName("乔治");
            dept.getUsers().add(user);
            dept.getUsers().add(user2);
	//		user.setDept(dept);
	//		session.save(user);;
            session.save(dept);
			tx.commit();
		}
		//级联删除
				public void testDel(){
					config=new Configuration().configure();
					sf=config.buildSessionFactory();
					session=sf.openSession();
					tx=session.beginTransaction();
					Dept dept=(Dept)session.load(Dept.class, 11);
				    session.delete(dept);
		          
					tx.commit();
				}
			//	多对多查询
				public void testmanytoMany(){
					config=new Configuration().configure();
					sf=config.buildSessionFactory();
					session=sf.openSession();

                     Project pro=(Project)session.get(Project.class, 1);
                    System.out.println(pro);
                    System.out.println(pro.getEpms());
 
				}
				//多对多删除
				public void tsetDel(){
					config=new Configuration().configure();
					sf=config.buildSessionFactory();
					session=sf.openSession();
					tx=session.beginTransaction();
					Project p=(Project)session.get(Project.class, 1);
					session.delete(p);
					tx.commit();
				}
				//多对多删除项目的员工
				public void tsetDelEmp(){
					config=new Configuration().configure();
					sf=config.buildSessionFactory();
					session=sf.openSession();
					tx=session.beginTransaction();
					Project p=(Project)session.get(Project.class, 1);
					Emp emp=(Emp)session.get(Emp.class,3);
					session.delete(p);
					tx.commit();
				}
				//多对多修改
				public void tsetmanyUpdate(){
					config=new Configuration().configure();
					sf=config.buildSessionFactory();
					session=sf.openSession();
					tx=session.beginTransaction();
					Project p=(Project)session.get(Project.class, 1);
					p.setProId(88);
					session.save(p);
					tx.commit();
				}
				//多对多增加
//				public void tsetmanyadd(){
//					config=new Configuration().configure();
//					sf=config.buildSessionFactory();
//					session=sf.openSession();
//					tx=session.beginTransaction();
//					Project p=new Project(88, "开外挂", "gaungzhou");
//					Emp e1=new Emp(8, "泰坦", 55);
//					Emp e2=new Emp(11, "jumo", 55);
//					p.getEpms().add(e1);
//					p.getEpms().add(e2);
//					session.save(p);
//					tx.commit();
//				}
				
				
}
