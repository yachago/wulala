package helloHiberinate;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import enitity.Emp;
import junit.framework.TestCase;
import util.HibernateUtil;

public class TestFenYe extends TestCase {

	public void getDevide() throws Exception{
		//分页查询
		int curr=5;
		int size=12;
		Session session=HibernateUtil.getSession();
		String hql="select count(*) from Heros ";
		Query q=session.createQuery(hql);
	    long n=(Long) q.uniqueResult();
		
		System.out.println(n);
		int totalPage=(int) (n%size==0?n/size:n/size+1);
			String hql2="from Heros ";
			Query qq=session.createQuery(hql2);
		    qq.setFirstResult((curr-1)*size);//跳过的行数
		    qq.setMaxResults(size);//每页的条数
			List<Emp> list=qq.list();
			System.out.println("总页数"+totalPage);
			System.out.println(list);
			session.close();
		
	}
}
