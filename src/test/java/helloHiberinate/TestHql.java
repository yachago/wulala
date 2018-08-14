package helloHiberinate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import enitity.Dept;
import enitity.Emp;
import enitity.User;
import junit.framework.TestCase;
import util.HibernateUtil;

public class TestHql extends TestCase {

	
	Transaction tx ;
	public  void find(){
		Session session=HibernateUtil.getSession();
		String sql="from Emp";
		Query q=session.createQuery(sql);
		List<Emp> list=q.list();
		System.out.println(list);
		HibernateUtil.closeSession();
	}
	public  void testFind(){
		Session session=HibernateUtil.getSession();
		String sql="from Emp where empAge>?";
		Query q=session.createQuery(sql);
		q.setParameter(0, 20);
		List<Emp> list=q.list();
		System.out.println(list);
		HibernateUtil.closeSession();
	}
	public  void testFind2(){
		Session session=HibernateUtil.getSession();
		String sql="from Emp where empName like ?";
		Query q=session.createQuery(sql);
		q.setParameter(0, "%剑%");
		List<Emp> list=q.list();
		System.out.println(list);
		HibernateUtil.closeSession();
	}
	//查总条数
	public  void testFind3(){
		Session session=HibernateUtil.getSession();
		String sql="select count(*) from Emp ";
		Query q=session.createQuery(sql);
	    long n=(Long) q.uniqueResult();
		
		System.out.println(n);
		HibernateUtil.closeSession();
	}
	//分页查询
	public  void testFind4(){
		int curr=1;
		int size=3;
		Session session=HibernateUtil.getSession();
		String sql="from Emp ";
		Query q=session.createQuery(sql);
	    q.setFirstResult((curr-1)*size);//跳过的行数
	    q.setMaxResults(size);//每页的条数
		List<Emp> list=q.list();
		System.out.println(list);
		HibernateUtil.closeSession();
	}
	//查单个字段
		public  void testFind5(){
			Session session=HibernateUtil.getSession();
			String sql="select empId,empName from Emp ";
			Query q=session.createQuery(sql);
		    List<Object[]> a=q.list();
		    for (Object[] row : a) {
				System.out.println(row[0]+"-->"+row[1]);
			}
			HibernateUtil.closeSession();
		}
		//多条件动态查询
		public  void testFind6(){
			int empAge=15;
			Date date=new Date();
			Session session=HibernateUtil.getSession();
			DetachedCriteria dc = DetachedCriteria.forClass(Emp.class);
			//两者都满足条件查询
			if(empAge>0){
				dc.add(Restrictions.ge("empAge", empAge));
			}
			if(date!=null){
				dc.add(Restrictions.lt("hireDate", date));
			}
			//两者满足其中一个，或的关系
			Criteria c=dc.getExecutableCriteria(session);
			List<Emp> list=c.list();
			System.out.println(list);
			HibernateUtil.closeSession();
		}
		//多条件动态查询
				public  void testFind7(){
					int empAge=15;
					Date date=new Date();
					Session session=HibernateUtil.getSession();
					DetachedCriteria dc = DetachedCriteria.forClass(Emp.class);
					//两者都满足条件查询
					List list=session.createCriteria(Emp.class).add(
							Restrictions.like("empName", "%剑%")).add(
							Restrictions.or(Restrictions.gt("empAge", new Integer(19)), 
							Restrictions.lt("hireDate", date))
							).list();
					System.out.println(list);
					HibernateUtil.closeSession();
				}
			//子查询
			public void testFind8(){
				Session session=HibernateUtil.getSession();
				String hql="FROM Area WHERE parent_id ="+"(SELECT id FROM Area WHERE name='陕西省')";
				Query q=session.createQuery(hql);
				List<Emp> list=q.list();
				System.out.println(list);
				HibernateUtil.closeSession();
			}
			//多表连接查询(内连接)
			public void testFind9(){
				Session session=HibernateUtil.getSession();
				String hql="FROM User u inner join u.dept";
				Query q=session.createQuery(hql);
				List<Object[]> list=q.list();

                for (Object[] ob : list) {
					User user=(User) ob[0];
					Dept dept=(Dept) ob[1];
					System.out.println(user+" --->"+dept);
				}
				HibernateUtil.closeSession();
			}
			//左外多表连接查询
			public void testFind10(){
				Session session=HibernateUtil.getSession();
				tx=session.beginTransaction();
				Dept dept=new Dept(99, "保安", "保安");
				session.save(dept);
				tx.commit();
				String hql="FROM Dept d left join d.users";
				Query q=session.createQuery(hql);
				List<Object[]> list=q.list();

                for (Object[] ob : list) {
					User user=(User) ob[1];
					Dept dept2=(Dept) ob[0];
					System.out.println(dept2+" --->"+user);
				}
				HibernateUtil.closeSession();
			}
			//原生SQL查询
			public void testFind11(){
				Session session=HibernateUtil.getSession();
				
				String sql="select u.userName ,u.userAge "+ 
				"FROM User u "+
				"where u.userName like ?"+
				"and u.userAge >:age";
				SQLQuery sq=session.createSQLQuery(sql);
				sq.setParameter(0, "%乔%");
				sq.setParameter("age", 19);
				List<Object[]> list=sq.list();

                for (Object[] ob : list) {
					System.out.println(ob[1]+" --->"+ob[0]);
				}
				HibernateUtil.closeSession();
			}
}
