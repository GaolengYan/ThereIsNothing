package Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by
 *
 * @author GaolengYan
 * @date 2018/1/9
 */
public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY;
    static {
            Configuration configuration = new Configuration().configure();
            SESSION_FACTORY = configuration.buildSessionFactory();
    }
    public static Session getSession() {
        return SESSION_FACTORY.openSession();
    }
    public static Session getCurrentSession(){
        return SESSION_FACTORY.getCurrentSession();
    }

    public static Transaction beginTransaction(Session session) {
        return session.beginTransaction();
    }
}
