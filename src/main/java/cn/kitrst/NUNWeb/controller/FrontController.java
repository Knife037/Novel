package cn.kitrst.NUNWeb.controller;

import cn.kitrst.NUNWeb.dao.MappingDao;
import cn.kitrst.NUNWeb.dao.NovelDao;
import cn.kitrst.NUNWeb.dao.UserDao;
import cn.kitrst.NUNWeb.domain.Mapping;
import cn.kitrst.NUNWeb.domain.Novel;
import cn.kitrst.NUNWeb.domain.User;
import com.sun.istack.internal.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/25.
 */

@Controller
public class FrontController {

    @Resource
    private NovelDao novelDao;

    @Resource
    private UserDao userDao;

    @Resource
    private MappingDao mappingDao;

    @RequestMapping("/login")
    public String login(String username, String password, Model model, HttpSession session) {
        if(username == null || password == null) {
            return "front_login";
        }
        User user = userDao.getUserByUsername(username);
        if(user != null && user.getPassword().equals(password)) {
            model.addAttribute("username", username);
            session.setAttribute("username", username);
            return "redirect:/index";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping("/index")
    public String index() {
        return "front_index";
    }

    @RequestMapping("/mysub")
    public String mysub(HttpSession session, Model model) {
        List<Novel> novels = novelDao.getNovelByUsername((String)session.getAttribute("username"));
        model.addAttribute("novels", novels);
        return "front_mysub";
    }

    @RequestMapping("/delsub")
    public String delsub(String novelName, HttpSession session) {
        if(novelName != null) {
            Mapping mapping = new Mapping();
            mapping.setUsername((String)session.getAttribute("username"));
            mapping.setNovelName(novelName);
            mappingDao.deleteMapping(mapping);
        }
        return "redirect:mysub";
    }

    @RequestMapping("/addsub")
    public String addsub(String novelName, Model model) {
        if(novelName != null) {
            Document doc = null;
            try {
                doc = Jsoup.connect("http://zhannei.baidu.com/cse/search?s=8823758711381329060&ie=utf-8&q=" + java.net.URLEncoder.encode(novelName, "UTF-8"))
                        .timeout(10000).get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Elements elements = doc.select("a[class=result-game-item-title-link]");
            List<Novel> novels = new LinkedList<Novel>();
            for(int i = 0; i < elements.size(); i++) {
                Element ele = elements.get(i);
                Novel novel = new Novel();
                novel.setUrl(ele.attr("href"));
                novel.setNovelName(ele.attr("title"));
                novels.add(novel);
            }
            model.addAttribute("novels", novels);
            return "front_addsub";
        }
        return "front_addsub";
    }

    @RequestMapping("addSubscribe")
    public String addSubScribe(@NotNull String novelName, @NotNull String url, HttpSession session) {

        if(novelDao.getNovelByNovelName(novelName) == null) {
            Novel novel = new Novel();
            novel.setNovelName(novelName);
            novel.setUrl(url);
            novel.setEncoding("UTF-8");
            novelDao.addNovel(novel);
        }

        Mapping mapping = new Mapping();
        mapping.setNovelName(novelName);
        mapping.setUsername((String) session.getAttribute("username"));
        mappingDao.addMapping(mapping);
        return "redirect:/mysub";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }

    @RequestMapping("register")
    public String register(String username, String nickname, String password1, String password2, String email) {
        if(username == null || nickname == null || password1 == null || password2 == null || email == null) {
            return "front_register";
        }
        if(userDao.getUserByUsername(username) != null || !password1.equals(password2)) {
            return "redirect:register";
        }
        User user = new User();
        user.setUsername(username);
        user.setNickname(nickname);
        user.setPassword(password1);
        user.setEmail(email);
        userDao.addUser(user);
        return "redirect:login";
    }

    @RequestMapping("setting")
    public String setting(String nickname, String password1, String password2, String email, Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        if(nickname == null || password1 == null || password2 == null || email == null) {
            User user = userDao.getUserByUsername(username);
            model.addAttribute("user", user);
            return "front_setting";
        }

        User user = new User();
        user.setUsername(username);
        user.setNickname(nickname);
        user.setPassword(password1);
        user.setEmail(email);
        userDao.updateUser(user);
        return "redirect:index";
    }

    @RequestMapping("about")
    public String about() {
        return "front_about";
    }
}
