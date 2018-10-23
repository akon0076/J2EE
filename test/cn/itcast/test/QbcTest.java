package cn.itcast.test;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import cn.itcast.domain.Customer;
import cn.itcast.util.HibernateUtils;
public class QbcTest {
	// qbc查询全部
	@Test
	public void qbcTest1() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> cs = criteria.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		session.getTransaction().commit();
		session.close();
	}

	// 只返回一个值
	@Test
	public void qbcTest2() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		// criteria.add(Restrictions.eq("id", 1)).add(Restrictions.eq("name",
		// "李四")); // where id=1 and name="李四"
		criteria.add(Restrictions.and(Restrictions.eq("id", 1),
				Restrictions.eq("name", "王五")));
		Customer c = (Customer) criteria.uniqueResult();
		System.out.println(c);
		session.getTransaction().commit();
		session.close();
	}

	// where id=1 or name="王五"
	@Test
	public void qbcTest3() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.or(Restrictions.eq("id", 1),
				Restrictions.eq("name", "王五"))); // where id=1 and name="李四"
		List<Customer> cs = criteria.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		session.getTransaction().commit();
		session.close();
	}
	// 分页
	@Test
	public void qbcTest4() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.setFirstResult(2);
		criteria.setMaxResults(3);
		List<Customer> cs = criteria.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		session.getTransaction().commit();
		session.close();
	}

}
