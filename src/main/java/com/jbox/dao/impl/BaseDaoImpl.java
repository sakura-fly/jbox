package com.jbox.dao.impl;

import com.jbox.dao.BaseDao;
import com.jbox.util.DbUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseDaoImpl<T> implements BaseDao<T> {

    String table;


    @Resource
    SessionFactory sessionFactory;

    public int add(T t) {
        Session session = sessionFactory.openSession();
        Transaction tt = session.beginTransaction();
        int stat = 1;
        try {
            session.save(t);
            tt.commit();
        } catch (Exception e) {
            stat = -1;
            e.printStackTrace();
        } finally {
            session.close();
        }
        return stat;
    }

    public List<T> list(T t) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<T> r = new ArrayList<>();
        try {
            NativeQuery sql = DbUtil.getQuerySql(session, table, t);
            sql.addEntity(t.getClass());
            r = sql.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return r;
    }
}
