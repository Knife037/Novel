package cn.kitrst.NUNWeb.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis的工具类
 * @author yuguiyang
 *
 */
public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory = null;

    /**
     * 初始化Session工厂
     * @throws IOException
     */
    private static void initialFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 获取Session
     * @return
     */
    public static SqlSession getSession() {
        if(sqlSessionFactory == null) {
            try {
                initialFactory();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return  sqlSessionFactory.openSession();
    }


}