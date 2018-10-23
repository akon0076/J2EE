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
 *  测试类
 */
public class CustomerTest {
	/**
	 *  1.添加操作
	 */
	@Test
	public void insertTest() {
		// 1.加载hibernate.cfg.xml配置
		//Configuration config = new Configuration().configure("/config/hibernate.cfg.xml");//查找指定位置的配制文件
		Configuration config = new Configuration().configure();//默认去类路径的根目录下查找名称为hibernate.cfg.xml的文件
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
		session.save(c);
		// 6.提交事务
		 t.commit();
		// 7.关闭资源
		session.close();
		sessionFactory.close();
	}

	/**
	 *  2.修改操作
	 */
	@Test
	public void updateTest() {
		// 1.加载hibernate.cfg.xml配置
		Configuration config = new Configuration().configure();
		// 2.获取SessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.得到一个Session
		Session session = sessionFactory.openSession();
		// 4.开启事务
		Transaction t = session.beginTransaction();
		// 5.操作
		// 5.1创建一个对象
		Customer c = new Customer();
		c.setId(1);
		c.setName("李四");
		c.setAge(20);
		c.setSex("男");
		c.setCity("广州");
		// 5.2将数据存储到表中
		session.update(c);
		// 6.提交事务
		t.commit();
		// 7.关闭资源
		session.close();
		sessionFactory.close();
	}

	/**
	 *  3.查询操作--根据id查找
	 */
	@Test
	public void findByIdTest() {
		// 1.加载hibernate.cfg.xml配置
		Configuration config = new Configuration().configure();
		// 2.获取SessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.得到一个Session
		Session session = sessionFactory.openSession();
		// 4.开启事务
		Transaction t = session.beginTransaction();
		// 5.操作
		// 对于hibernate中根据id查找操作，它可以使用两个方法 get load
		 Customer c=(Customer) session.get(Customer.class, 1);
		//Customer c = (Customer) session.load(Customer.class, 1);
		 System.out.println("姓名："+c.getName());
		 System.out.println("年龄："+c.getAge());
		 System.out.println("性别："+c.getSex());
		 System.out.println("所在城市："+c.getCity());
		// 6.提交事务
		t.commit();
		// 7.关闭资源
		session.close();
		sessionFactory.close();
	}

	/**
	 *  4.删除操作
	 */
	@Test
	public void deleteByIdTest() {
		// 1.加载hibernate.cfg.xml配置
		Configuration config = new Configuration().configure();
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
}
