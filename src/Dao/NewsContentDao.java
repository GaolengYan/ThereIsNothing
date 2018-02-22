package Dao;

import Bean.Newscontent;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


/**
 * Created by
 *
 * @author GaolengYan
 * @date 2018/1/18
 */
public class NewsContentDao {
    public void add(Newscontent newscontent) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = HibernateUtil.beginTransaction(session);
        try {
            session.save(newscontent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        transaction.commit();
    }

    public Newscontent findBySrc(String src) {
        Newscontent newscontent = null;
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = HibernateUtil.beginTransaction(session);
        try {
            String hql = "from Newscontent where newssrc like ?";
            Query query = session.createQuery(hql).setParameter(0, src);
            newscontent = (Newscontent) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        transaction.commit();
        return newscontent;
    }
}
