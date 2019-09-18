package com.jbox.util;

import net.sf.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.Map;
import java.util.Set;

public class DbUtil {

    public static NativeQuery getQuerySql(Session session, String table, Object o) {
        JSONObject oMap = JSONObject.fromObject(o);
        String q = "select * fomr " + table + getQuery(oMap);
        Set ks = oMap.keySet();
        NativeQuery sql = session.createSQLQuery(q);
        for (Object k : ks) {
            int i = 1;
            i++;
            sql.setParameter(i, k);
        }
        return sql;
    }

    public static String getQuery(JSONObject oMap) {
        StringBuilder sb = new StringBuilder();
        Set ks = oMap.keySet();
        if (ks.size() > 0) {
            sb.append(" where");
        }
        for (Object k : ks) {
            sb.append(" ").append(k).append(" is ").append(oMap.get(k));
        }
        return sb.toString();
    }

}
