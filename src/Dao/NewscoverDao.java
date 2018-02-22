package Dao;

import Bean.Newscover;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by
 *
 * @author GaolengYan
 * @date 2018/1/9
 */
public class NewscoverDao {
    public void add(List<Newscover> news) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = HibernateUtil.beginTransaction(session);
        try {
            for (Newscover newscover : news) {
                session.save(newscover);
            }
        } catch (Exception e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
    }

    public List findAll() {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = HibernateUtil.beginTransaction(session);
        List list = null;
        try{
            String hql = "from Newscover";
            Query query = session.createQuery(hql);
            list = query.list();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            transaction.commit();
        }
        return list;
    }
    public Newscover findBySrc(String url){
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = HibernateUtil.beginTransaction(session);
        Newscover newscover = null;
        try{
            String hql = "from Newscover where newsContext like ?";
            Query query = session.createQuery(hql).setParameter(0, url);
            newscover = (Newscover) query.uniqueResult();
        }catch (Exception e){
            transaction.rollback();
        }
        transaction.commit();
        return newscover;
    }
}
