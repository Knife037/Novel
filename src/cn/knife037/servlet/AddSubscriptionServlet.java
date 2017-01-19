package cn.knife037.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.regex.Matcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.knife037.bean.NovelBean;

/**
 * Servlet implementation class AddSubscriptionServlet
 */
@WebServlet("/addsubscription")
public class AddSubscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		if(username == null) {
			response.sendRedirect("login");
			return ;
		}
		
		String keyWord = request.getParameter("keyword");
		
		if(keyWord == null) {
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/addSubscription.jsp");
			view.forward(request, response);
			return ;
		}
		
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("<a cpos=\"title\" href=\"(.+?)>");
		java.util.regex.Pattern pattern2 = java.util.regex.Pattern.compile("href=\"(.+?)\" title=\"(.+?)\"");
		String url = "http://zhannei.baidu.com/cse/search?s=8353527289636145615&entry=1&ie=utf-8&q=" + keyWord;
		String SearchHtml = getSourceCode(url, false, "utf-8");
		LinkedList<NovelBean> novels = new LinkedList<NovelBean>();
		if(SearchHtml != null) {
			Matcher mc = pattern.matcher(SearchHtml);
			Matcher mc2 = null;
			while(mc.find()) {
				mc2 = pattern2.matcher(mc.group(0));
				
				if(mc2.find()) {
					NovelBean novel = new NovelBean(0, mc2.group(2), null);
					novel.setUrl(mc2.group(1));
					novels.add(novel);					
				} else {
					System.out.println("no match found");
				}
			}
		} else {
			System.out.println("SearchHtml is null!!!");
		}
		
		request.setAttribute("novels", novels);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/addSubscription.jsp");
		view.forward(request, response);
		return ;
	}

	private static String getSourceCode(String path, boolean isOnce, String encoding) {  
		BufferedReader in = null;
		StringBuilder result = new StringBuilder();
		
		try {

			URL url = new URL(path);
			in = new BufferedReader(new InputStreamReader(url.openStream(), encoding));

			String str = null;
			
			if(isOnce) {
				int times = 0;
				while(++times <= 40 && (str = in.readLine()) != null) {
					result.append(str);
				}
				
			} else {
				while((str = in.readLine()) != null) {
					result.append(str);
				}
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			try {
				if(in != null) {
					in.close();
				}
			} catch (Exception e) {
				System.out.println("Fail to close URL Connection");
			}
		}
		
		return result.toString();
	}

}
