package cn.knife037.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.knife037.bean.NovelBean;
import cn.knife037.util.DbUtil;

/**
 * Servlet implementation class SubscriptionServlet
 */
@WebServlet("/subscription")
public class SubscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubscriptionServlet() {
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
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		if(username == null) {
			response.sendRedirect("login");
			return ;
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();
			String sql = "select * from users where username=?";
			pstmt = DbUtil.preparedStatement(conn, sql);
			pstmt.setString(1, username);
			rs = DbUtil.getResult(pstmt);
			
			rs.next();
			int userID = rs.getInt("id");
			
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			
			sql = "select * from mapping where userID=?";
			pstmt = DbUtil.preparedStatement(conn, sql);
			pstmt.setInt(1, userID);
			rs = DbUtil.getResult(pstmt);
			
			
			ArrayList<NovelBean> novels = new ArrayList<NovelBean>();
			
			PreparedStatement pstmt0 = null;
			ResultSet rs0 = null;
			
			String name = null;
			String rectChap = null;
			while(rs.next()) {
				
				int novlID = rs.getInt("novlID");
				pstmt0 = DbUtil.preparedStatement(conn, "select * from novels where id=?");
				pstmt0.setInt(1, novlID);
				rs0 = DbUtil.getResult(pstmt0);
				
				rs0.next();
				
				name = rs0.getString("name");
				rectChap = rs0.getString("rectChap");
				
				novels.add(new NovelBean(novlID, name, rectChap));
				
				DbUtil.close(rs0);
				DbUtil.close(pstmt0);
			}
			
			request.setAttribute("novels", novels);
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/subscription.jsp");
			view.forward(request, response);
			return ;			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
	}

}
