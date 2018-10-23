package cn.itcast.test;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import cn.itcast.domain.Customer;
/**
 * Query查询
 */
public class QueryTest {
	/**
	 * 使用Query查询全部
	 */
	@Test
	public void findAll_hqlTest() {
		// 加载hibernate.cfg.xml配制文件
		Configuration config = new Configuration().configure();
		// 获取SessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 1.得到一个Session
		Session session = sessionFactory.openSession();
		// 开启事务
		Transaction t = session.beginTransaction();
		// 2.编写HQL
		String hql = "from Customer";//Customer代表的是类
		// 3.调用session.createQuery 创建查询对象
		Query query = session.createQuery(hql); 
		// 4.使用query.list()方法查询数据，并将数据放入一个list集合
		List<Customer> list = query.list();
		for(Customer c : list){ //循环输出集合中的数据
			System.out.println(c);
		}
		// 提交事务
		t.commit();
		// 关闭资源
		session.close();
		sessionFactory.close();
	}
	/**
	 * Query按条件查询
	 */
	@Test
	public void uniqueResult_hqlTest() {
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 1.得到一个Session
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		// 2.编写HQL语句,并调用session.createQuery 创建查询对象
		Query query = session.createQuery("from Customer where id =:id"); // Customer代表的是类
		// 3.调用Query的setInteger()方法设置参数
		query.setInteger("id", 3);
		// 4.调用Query对象的uniqueResult()方法执行查询
		Customer c = (Customer) query.uniqueResult();//结果只返回一个值可以使用uniqurResult();
		System.out.println(c);
		t.commit();
		session.close();
		sessionFactory.close();
	}
	/**
	 * Query按条件查询
	 */
	@Test
	public void param_hqlTest() {
		// 1.加载配置
		Configuration config = new Configuration().configure();// 加载hibernate.cfg.xml
		// 2.获取SessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.得到一个Session
		Session session = sessionFactory.openSession();
		// 4.开启事务
		Transaction t = session.beginTransaction();
		// 5.操作
		Query query = session.createQuery("from Customer where id=:id");
		query.setParameter("id", 1);
		List<Customer> cs = query.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		// 6.提交事务
		t.commit();
		// 7.关闭资源
		session.close();
		sessionFactory.close();
	}
	
	/**
	 * Query分页查询
	 */
	@Test
	public void queryPageTest() {
		// 1.加载配置
		Configuration config = new Configuration().configure();// 加载hibernate.cfg.xml
		// 2.获取SessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.得到一个Session
		Session session = sessionFactory.openSession();
		// 4.开启事务
		Transaction t = session.beginTransaction();
		// 5.操作
		Query query = session.createQuery("from Customer");
		query.setFirstResult(2); // 从第几条开始查询
		query.setMaxResults(3); // 查询几条
		List<Customer> cs = query.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		// 6.提交事务
		t.commit();
		// 7.关闭资源
		session.close();
		sessionFactory.close();
	}
	
	
}
