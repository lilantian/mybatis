package com.java.sky;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author Sky
 * @date 2020/04/30
 */
public class Goods {

    public static void main(String[] args) {
        String source = "mybatis-config.xml";
        InputStream inputStream;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream(source);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            List<Map> list = sqlSession.selectList("Goods.queryAll");
            for (Map map : list) {
                System.out.println(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }
}
