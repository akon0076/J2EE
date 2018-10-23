package cn.itcast.util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtils {
	//����һ��˽�еľ�̬final���͵�Configuration����
	private static final Configuration config;
	//����һ��˽�еľ�̬final���͵�SessionFactory����
	private static final SessionFactory factory;
	//ͨ����̬����鹹��SessionFactory
	static {
		config = new Configuration().configure();
		factory = config.buildSessionFactory();
	}
	//�ṩһ�����еľ�̬�������ⲿ��ȡ��������һ��sesison����
	public static Session getSession() {
		return factory.openSession();
	}
}
