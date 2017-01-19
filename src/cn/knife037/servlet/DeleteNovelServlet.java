package cn.knife037.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.knife037.util.DbUtil;

/**
 * Servlet implementation class DeleteNovelServlet
 */
@WebServlet("/deleteNovel")
public class DeleteNovelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNovelServlet() {
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
		int userID = (int)session.getAttribute("id");
		
		if(username == null) {
			response.sendRedirect("login");
			return ;
		}
		
		
		
		int novlID = Integer.parseInt(request.getParameter("id"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		try {
			conn = DbUtil.getConn();
			String sql = "delete from mapping where ((userID=?) && (novlID=?))";
			pstmt = DbUtil.preparedStatement(conn, sql);
			pstmt.setInt(1, userID);
			pstmt.setInt(2, novlID);
			
			DbUtil.update(pstmt);
			
			response.sendRedirect("subscription");
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
