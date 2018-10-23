package cn.itcast.test;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import cn.itcast.domain.Customer;
public class CustumerTest1 {

	// 1.添加操作
	@Test
	public void insertTest() {
		// 1.加载配置
		Configuration config = new Configuration().configure();// 加载hibernate.cfg.xml
		// 2.获取SessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.得到一个Session
		Session session = sessionFactory.openSession();
		// 4.开启事务
		 Transaction t = session.beginTransaction();
		session.beginTransaction();
		// 5.操作
		// 5.1创建一个对象
		Customer c = new Customer();
		c.setName("王五");
		c.setAge(20);
		c.setCity("上海");
		c.setSex("男");
		// 5.2将数据存储到表中
		Serializable save = session.save(c);
		// 6.提交事务
		 t.commit();
		// 7.关闭资源
		session.close();
		sessionFactory.close();
	}

	// 2.修改操作
	@Test
	public void updateTest() {
		// 1.加载配置
		Configuration config = new Configuration().configure();// 加载hibernate.cfg.xml
		// 2.获取SessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.得到一个Session
		Session session = sessionFactory.openSession();
		// 4.开启事务
		Transaction t = session.beginTransaction();
		// 5.操作
		// 5.1创建一个对象
		Customer c = new Customer();
		c.setName("李四");
		c.setAge(20);
		c.setCity("广州");
		c.setId(1);

		// 5.2将数据存储到表中
		session.update(c);
		// 6.提交事务
		t.commit();
		// 7.关闭资源
		session.close();
		sessionFactory.close();
	}

	// 3.查询操作--根据id查找
	@Test
	public void selectByIdTest() {
		// 1.加载配置
		Configuration config = new Configuration().configure();// 加载hibernate.cfg.xml
		// 2.获取SessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.得到一个Session
		Session session = sessionFactory.openSession();
		// 4.开启事务
		Transaction t = session.beginTransaction();
		// 5.操作
		// 5.1创建一个对象
		// 对于hibernate中根据id查找操作，它可以使用两个方法 get load
		// Customer c=(Customer) session.get(Customer.class, 1);
		Customer c = (Customer) session.load(Customer.class, 1);
		// 6.提交事务
		t.commit();
		// 7.关闭资源
		session.close();
		sessionFactory.close();
	}

	// 4.删除操作
	@Test
	public void deleteByIdTest() {
		// 1.加载配置
		Configuration config = new Configuration().configure();// 加载hibernate.cfg.xml
		// 2.获取SessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.得到一个Session
		Session session = sessionFactory.openSession();
		// 4.开启事务
		Transaction t = session.beginTransaction();
		// 5.操作
		Customer c = (Customer) session.get(Customer.class, 1); // 先查询
		session.delete(c);// 删除
		// 6.提交事务
		t.commit();
		// 7.关闭资源
		session.close();
		sessionFactory.close();
	}
	// 使用hibernate的结构化查询语句 HQL
	@Test
	public void findAll_hqlTest() {
		// 1.加载配置
		Configuration config = new Configuration().configure();// 加载hibernate.cfg.xml
		// 2.获取SessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.得到一个Session
		Session session = sessionFactory.openSession();
		// 4.开启事务
		Transaction t = session.beginTransaction();
		// 5.操作
		Query query = session.createQuery("from Customer"); // Customer代表的是类
		List list = query.list();
		System.out.println(list);
		// 6.提交事务
		t.commit();
		// 7.关闭资源
		session.close();
		sessionFactory.close();
	}

	// 使用sql语句--查询所有
	@Test
	public void findAll_sqlTest() {
		// 1.加载配置
		Configuration config = new Configuration().configure();// 加载hibernate.cfg.xml
		// 2.获取SessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.得到一个Session
		Session session = sessionFactory.openSession();
		// 4.开启事务
		Transaction t = session.beginTransaction();
		// 5.操作
		SQLQuery sqlQuery = session
				.createSQLQuery("select id,name,age,city from customer"); // sql语句
		List list = sqlQuery.list();
		for (int i = 0; i < list.size(); i++) {
			Object[] objs = (Object[]) list.get(i);

			for (int j = 0; j < objs.length; j++) {
				System.out.print(objs[j] + "  ");
			}
			System.out.println();
		}
		// 6.提交事务
		t.commit();
		// 7.关闭资源
		session.close();
		sessionFactory.close();
	}
	// 查询全部---QBC
	@Test
	public void findAll_qbcTest() {
		// 1.加载配置
		Configuration config = new Configuration().configure();// 加载hibernate.cfg.xml
		// 2.获取SessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.得到一个Session
		Session session = sessionFactory.openSession();
		// 4.开启事务
		Transaction t = session.beginTransaction();
		// 5.操作
		Criteria cc = session.createCriteria(Customer.class);
		List list = cc.list();
		System.out.println(list);
		// 6.提交事务
		t.commit();
		// 7.关闭资源
		session.close();
		sessionFactory.close();
	}

}
