package cn.knife037.servlet;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

import cn.knife037.util.DbUtil;

/**
 * Servlet implementation class AddNovelServlet
 */
@WebServlet("/addNovel")
public class AddNovelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNovelServlet() {
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
		int id = (int)session.getAttribute("id");
		if(username == null) {
			response.sendRedirect("login");
			return ;
		}
		
		String novelName = request.getParameter("name");
		String novelUrl = request.getParameter("url");
		int novelID = 0;
		
		Connection conn = null;
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			conn = DbUtil.getConn();
			sql = "select * from novels where novlName=?";
			pstmt = DbUtil.preparedStatement(conn, sql);
			pstmt.setString(1, novelName);
			rs = DbUtil.getResult(pstmt);

			DbUtil.close(rs);
			DbUtil.close(pstmt);
			
			if(rs != null) {
				
				rs.next();
				novelID = rs.getInt("id");
				
			} else {				
				
				conn.setAutoCommit(false);
				sql = "insert novels(name, url) values(?,?)";
				pstmt = DbUtil.preparedStatement(conn, sql);
				pstmt.setString(1, novelName);
				pstmt.setString(2, novelUrl);
				DbUtil.update(pstmt);
				
				DbUtil.close(pstmt);
				
				sql = "select last_insert_id()";
				pstmt = DbUtil.preparedStatement(conn, sql);
				rs = DbUtil.getResult(pstmt);
				rs.next();
				novelID = rs.getInt("last_insert_id()");
				
				DbUtil.close(rs);
				DbUtil.close(pstmt);
			}
			
			sql = "insert mapping(userID,novlID) values(?,?)";
			pstmt = DbUtil.preparedStatement(conn, sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, novelID);
			DbUtil.update(pstmt);
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(SQLException e) {
			e.printStackTrace();			
		} finally {
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		RequestDispatcher view = request.getRequestDispatcher("addsubscription");
		view.forward(request, response);
		return ; 
	}

}
