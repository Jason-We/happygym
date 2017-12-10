package services;

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


/**
 * Servlet implementation class Logincheck
 */
@WebServlet("/Logincheck")
public class Logincheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DBConnector db = new DBConnector();
	
	Connection con = db.getConnections();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logincheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String name = request.getParameter("name");
		String psw = request.getParameter("psw");
		String sql = "select * from sys_manager where name=? and psw=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, psw);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				response.sendRedirect("src/main/webapp/homepage.jsp");
			}else{
				System.out.println("用户名或密码错误");
				response.sendRedirect("index.jsp");
			}
/*			rs.close();
			ps.close();
			con.close();*/
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
