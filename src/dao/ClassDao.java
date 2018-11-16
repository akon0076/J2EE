package dao;

import entity.Classes;
import entity.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ClassDao {
    public Boolean addClass(Classes classess){
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        System.out.println(classess.getNumber() + " " + classess.getCode());
        session.save(classess);
        t.commit();
        session.close();
        sessionFactory.close();
        return true;
    }

    public Classes getSingleClass(Integer id) {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        Classes c = (Classes) session.get(Classes.class, id);
        t.commit();
        session.close();
        sessionFactory.close();
        return c;
    }

    public Boolean updateClass(Classes classes) {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        List oldClasses = session.createSQLQuery("select code from Classes  where id = " + classes.getId().toString()).list();
        session.createSQLQuery("update Classes set classes =  " + classes.getCode() + " where classes = "+ oldClasses.get(0));

        session.update(classes);
        t.commit();
        session.close();
        sessionFactory.close();
        return true;
    }

    public Boolean removeClass(Integer id) {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        Classes c = (Classes) session.get(Classes.class, id);
        session.delete(c);
        String hql = "delete Student where classes = :classes";
        session.createQuery(hql).setString("classes",c.getCode()).executeUpdate();
        t.commit();
        session.close();
        sessionFactory.close();
        return true;
    }

}
