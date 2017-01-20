package cn.knife037.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.knife037.util.DbUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		if(name == null || name == "" || pwd == null || pwd == "") {
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/login.html");
			view.forward(request, response);
			return ;
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();
			String sql = "select * from users where username=?";
			pstmt = DbUtil.preparedStatement(conn, sql);
			pstmt.setString(1, name);
			rs = DbUtil.getResult(pstmt);
			if(rs.next()) {
				String password = rs.getString("password");
				int id = rs.getInt("id");
				if(pwd.equals(password)) {
					
					HttpSession session = request.getSession();
					session.setAttribute("id", id);
					session.setAttribute("username", name);
					
					response.sendRedirect("index");
					return ;
				} else {
					response.sendRedirect("login");
				}
			} else {
				response.sendRedirect("login");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
	}

}
