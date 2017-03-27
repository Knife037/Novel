package cn.kitrst.NUNWeb.dao;

import cn.kitrst.NUNWeb.domain.Mapping;
import cn.kitrst.NUNWeb.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/3/25.
 */

@Repository
public class MappingDao {

    public void addMapping(Mapping mapping) {
        SqlSession session = MyBatisUtil.getSession();
        session.insert("cn.kitrst.NUNWeb.mapper.MappingMapper.addMapping", mapping);
        session.commit();
        session.close();
        session = null;
    }

    public void deleteMapping(Mapping mapping) {
        SqlSession session = MyBatisUtil.getSession();
        session.delete("cn.kitrst.NUNWeb.mapper.MappingMapper.deleteMapping", mapping);
        session.commit();
        session.close();
        session = null;
    }
}
