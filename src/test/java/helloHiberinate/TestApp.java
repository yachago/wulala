package helloHiberinate;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import enitity.User;
import junit.framework.TestCase;

public class TestApp extends TestCase{

	Configuration config;
	SessionFactory sf;
	Session session ;
	Transaction tx ;
	//添加
	public void testAdd(){
		config=new Configuration().configure();
		sf=config.buildSessionFactory();
		session=sf.openSession();
		tx=session.beginTransaction();
		
		try {
			User user=new User();
			user.setUserName("车车");
			user.setUserPwd("123");
			user.setUserAge(20);
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	//修改
		public void testUpdate(){
			config=new Configuration().configure();
			sf=config.buildSessionFactory();
			session=sf.openSession();
			tx=session.beginTransaction();
			
			try {
				User user=(User)session.get(User.class, 1);
				user.setUserAge(666);
				tx.commit();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//删除
		public void tsetDel(){
			config=new Configuration().configure();
			sf=config.buildSessionFactory();
			session=sf.openSession();
			tx=session.beginTransaction();
			
			try {
				User user=(User)session.get(User.class, 17);
			session.delete(user);
				tx.commit();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	   public void testFind(){
		   config=new Configuration().configure();
			sf=config.buildSessionFactory();
			session=sf.openSession();
			
			
			try {
				Query q=session.createQuery("from User");
				List<User> list=q.list();
				System.out.println(list);
			} catch (Exception e) {
				// TODO: handle exception
			}

	   }
		
	}


