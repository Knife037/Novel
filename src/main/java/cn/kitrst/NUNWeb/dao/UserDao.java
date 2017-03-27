package cn.kitrst.NUNWeb.dao;

import cn.kitrst.NUNWeb.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/3/24.
 */

@Repository
public class UserDao {

    public List<User> getUserByNovelName(String novelName) {
        SqlSession session = MyBatisUtil.getSession();
        List<User> users = session.selectList("cn.kitrst.NUNWeb.mapper.UserMapper.getUserByNovelName", novelName);
        session.close();
        session = null;
        return users;
    }

    public void addUser(User user) {
        SqlSession session = MyBatisUtil.getSession();
        session.insert("cn.kitrst.NUNWeb.mapper.UserMapper.addUser", user);
        session.commit();
        session.close();
        session = null;
    }

    public User getUserByUsername(String username) {
        SqlSession session = MyBatisUtil.getSession();
        User user = session.selectOne("cn.kitrst.NUNWeb.mapper.UserMapper.getUserByUsername", username);
        session.close();
        session = null;
        return user;
    }

    public void updateUser(User user) {
        SqlSession session = MyBatisUtil.getSession();
        session.update("cn.kitrst.NUNWeb.mapper.UserMapper.updateUser", user);
        session.commit();
        session.close();
        session = null;
    }

}
