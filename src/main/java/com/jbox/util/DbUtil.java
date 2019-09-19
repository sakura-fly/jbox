package com.jbox.util;

import net.sf.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class DbUtil {

    public static NativeQuery getQuerySql(Session session, String table, Object o) {
        JSONObject oMap = JSONObject.fromObject(o);
        String q = "select * from " + table + getQuery(oMap);
        Set ks = oMap.keySet();
        NativeQuery sql = session.createSQLQuery(q);
        int i = 1;
        for (Object k : ks) {
            if (checkValue(oMap.get(k))){
                sql.setParameter(i, k);
                i++;
            }
        }
        return sql;
    }

    public static String getQuery(JSONObject oMap) {
        StringBuilder sb = new StringBuilder();
        Set ks = oMap.keySet();
        if (ks.size() == 0) {
            return "";
        }
        for (Object k : ks) {
            if (checkValue(oMap.get(k))){

                if (sb.length() == 0) {
                    sb.append(" where");
                } else {
                    sb.append(" and");

                }
                sb.append(" ").append(k).append(" = ").append("?");
            }
        }
        return sb.toString();
    }

    private static boolean checkValue(Object o) {
        return o != null
                && (!(o instanceof String) || !((String) o).isEmpty())
                && (!(o instanceof Integer) || (Integer) o != 0)
                && (!(o instanceof Float) || (Float) o != 0.0F)
                && (!(o instanceof Double) || (Double) o != 0.0d)
                && (!(o instanceof Long) || (Long) o != 0L)
                && (!(o instanceof Byte) || (Byte) o != 0)
                && (!(o instanceof Short) || (Short) o != 0)
                && (!(o instanceof Character) || (Character) o != '\u0000')
                && (!(o instanceof List) || ((List)o).size() != 0);

    }

}
