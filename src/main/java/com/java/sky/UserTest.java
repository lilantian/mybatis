package com.java.sky;

import com.java.sky.entity.User;
import com.java.sky.service.IUserOperation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author Sky
 * @date 2020/05/12
 */
public class UserTest {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    public void getUserByID(int userID) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation = session.getMapper(IUserOperation.class);
            User user = userOperation.selectUserByID(userID);
            if (user != null) {
                System.out.println(user.getId() + ":" + user.getUserName() + ":" + user.getuserAddress());
            }
        } finally {
            session.close();
        }
    }

    public void getUserList(String userName) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation = session.getMapper(IUserOperation.class);
            List<User> users = userOperation.selectUsersByName(userName);
            for (User user : users) {
                System.out.println(user.getId() + ":" + user.getUserName() + ":" + user.getuserAddress());
            }
        } finally {
            session.close();
        }
    }

    /**
     * 增加后要commit
     */
    public void addUser() {
        User user = new User();
        user.setuserAddress("place");
        user.setUserName("test_add");
        user.setUserAge(30);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation = session.getMapper(IUserOperation.class);
            userOperation.addUser(user);
            session.commit();
            System.out.println("新增用户ID：" + user.getId());
        } finally {
            session.close();
        }
    }

    /**
     * 修改后要commit
     */
    public void updateUser() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation = session.getMapper(IUserOperation.class);
            User user = userOperation.selectUserByID(1);
            if (user != null) {
                user.setuserAddress("A new place");
                userOperation.updateUser(user);
                session.commit();
            }
        } finally {
            session.close();
        }
    }

    /**
     *
     */
    public void deleteUser(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation = session.getMapper(IUserOperation.class);
            userOperation.deleteUser(id);
            session.commit();
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
        try {
            UserTest userTest = new UserTest();
//            userTest.getUserByID(1);
//            userTest.getUserList("test1");
//            userTest.addUser();
//            userTest.updateUser();
            userTest.deleteUser(6);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
