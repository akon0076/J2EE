import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Customer;
import entity.Employee;

public class TestClass {

	public static void main(String[] args) {
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
		Employee c = new Employee();
		c.setName("rrrrr");
		c.setAge(20);
		c.setNumber("11603080205");
		c.setAge(21);
		// 5.2将数据存储到表中
		session.save(c);
		// 6.提交事务
		 t.commit();
		// 7.关闭资源
		session.close();
		sessionFactory.close();
	}

}
