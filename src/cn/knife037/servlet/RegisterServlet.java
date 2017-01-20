package cn.knife037.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.knife037.util.DbUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(username == null || nickname == null || email == null || password == null) {
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/register.html");
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
			pstmt.setString(1, username);
			rs = DbUtil.getResult(pstmt);
			System.out.println(username);
			if(!rs.next()) {
				DbUtil.close(rs);
				DbUtil.close(pstmt);
				
				sql = "insert users(username, nickname, password, email) values(?,?,?,?)";
				pstmt = DbUtil.preparedStatement(conn, sql);
				pstmt.setString(1, username);
				pstmt.setString(2, nickname);
				pstmt.setString(3, password);
				pstmt.setString(4, email);
				DbUtil.update(pstmt);
				
				response.sendRedirect("login");
				
			} else {
				PrintWriter pw = response.getWriter();
				pw.write("this username has been registered!!");
				return ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
