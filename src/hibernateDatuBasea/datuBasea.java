package hibernateDatuBasea;
import domeinuLogika.Erabiltzailea;
import domeinuLogika.Landetxea;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

public class datuBasea {
    private  SessionFactory ourSessionFactory;
    private  ServiceRegistry serviceRegistry;
    private static datuBasea instantzia;

    public static datuBasea instantzia() {

        if (instantzia == null) {
            instantzia = new datuBasea();
        }
        return instantzia;
    }


    private datuBasea() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public void gorde(Object o) throws Exception {
        Session session = getSession();

        Transaction tx = null;
        try {

            tx = session.beginTransaction();

            session.saveOrUpdate(o);
            tx.commit();
        } catch (HibernateException e) {

            e.printStackTrace();
        } finally {

        }

    }
    public List loginEgin(String nanz, String pass) throws Exception {
        Session session = getSession();

        try {
            String hql = "FROM Erabiltzailea E WHERE E.nan ='"+nanz+"' and E.pasahitza='"+pass+"'";
            Query query = session.createQuery(hql);
            List results = query.list();
       //     List results = session.createCriteria(o.getClass()).add( Example.create(o)).list();
            return results;

        } catch (HibernateException e) {

            e.printStackTrace();
        } finally {

        }
        return null;
    }


    public boolean existitzeDa(String nanzbkia) {
        Session session = getSession();

        try {
            String hql = "FROM Erabiltzailea E WHERE E.nan ='"+nanzbkia+"'";
            Query query = session.createQuery(hql);
            List results = query.list();
if(results.size()>0){
    return true;
}
        } catch (HibernateException e) {

            e.printStackTrace();
        } finally {

        }
        return false;
    }

//    public boolean landetxeaDago(Landetxea landetxea) {
//        Session session = getSession();
//
//        try {
//            String hql = "FROM Landetxea E WHERE E.herria ='"+nanzbkia+"'";
//            Query query = session.createQuery(hql);
//            List results = query.list();
//            if(results.size()>0){
//                return true;
//            }
//        } catch (HibernateException e) {
//
//            e.printStackTrace();
//        } finally {
//
//        }
//        return false;
//    }
}
