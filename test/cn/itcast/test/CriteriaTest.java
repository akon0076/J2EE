package cn.itcast.test;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import cn.itcast.domain.Customer;
public class CriteriaTest {
	@Test
	public void qbcTest() {		
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 得到一个Session
		Session session = sessionFactory.openSession();		
		Transaction t = session.beginTransaction();
		//通过session获得Criteria对象
		Criteria criteria = session.createCriteria(Customer.class);
		//执行Criterita的 list()获得结果
		List<Customer> cs = criteria.list();
		for (Customer c : cs) {  //循环输出结果
			System.out.println(c);
		}
		// 提交事务
		t.commit();
		// 关闭资源
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void qbcTest2() {		
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 1.得到一个Session
		Session session = sessionFactory.openSession();		
		Transaction t = session.beginTransaction();
		// 2.通过session获得Criteria对象
		Criteria criteria = session.createCriteria(Customer.class);
	    // 3.使用Restrictions的eq方法设定查询条件为name="王五",
		// 4.向Criteria对象中添加 查询条件
		criteria.add(Restrictions.eq("name", "王五")); 
		// 5.执行Criterita的 list()获得结果
		List<Customer> cs = criteria.list();
		for (Customer c : cs) {  //输出结果
			System.out.println(c);
		}
		// 提交事务
		t.commit();
		// 关闭资源
		session.close();
		sessionFactory.close();
	}
}
