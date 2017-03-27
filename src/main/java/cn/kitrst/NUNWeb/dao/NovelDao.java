package cn.kitrst.NUNWeb.dao;

import cn.kitrst.NUNWeb.domain.Novel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NovelDao {

    public List<Novel> getNovelByUsername(String username) {
        SqlSession session = MyBatisUtil.getSession();
        List<Novel> novels = session.selectList("cn.kitrst.NUNWeb.mapper.NovelMapper.getNovelByUsername", username);
        session.close();
        session = null;
        return novels;
    }

    public void addNovel(Novel novel) {
        SqlSession session = MyBatisUtil.getSession();
        session.insert("cn.kitrst.NUNWeb.mapper.NovelMapper.addNovel", novel);
        session.commit();
        session.close();
        session = null;
    }

    public Novel getNovelByNovelName(String novelName) {
        SqlSession session = MyBatisUtil.getSession();
        Novel novel = session.selectOne("cn.kitrst.NUNWeb.mapper.NovelMapper.getNovelByNovelName", novelName);
        session.close();
        session = null;
        return novel;
    }

}