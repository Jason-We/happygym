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
 * Servlet implementation class Addgroup
 */
@WebServlet("/Addgroup")
public class Addgroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	DBConnector db = new DBConnector();
	
	Connection con = db.getConnections();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addgroup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String t_name = request.getParameter("t_name");
		String t_no = request.getParameter("t_no");
		String t_account = request.getParameter("t_account");
		String t_psw = request.getParameter("t_psw");
		String sql = "insert into p_group(groupname,groupno,account,psw)values(?,?,?,?)";
		String s = "select * from p_group where groupno=?";
		try{
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(1, t_no);
			ResultSet rs = ps.executeQuery();
			if(!rs.next()){
				ps = con.prepareStatement(sql);
				ps.setString(1, t_name);
				ps.setString(2, t_no);
				ps.setString(3, t_account);
				ps.setString(4, t_psw);
				int res = ps.executeUpdate();
				if(res != 0){
					System.out.println("创建成功！");
					response.sendRedirect("src/main/webapp/addrole.jsp");
				}
				//response.sendRedirect("src/main/webapp/homepage.html");
			}else{
				System.out.println("队伍编号已被占用！");
				response.sendRedirect("src/main/webapp/addteam.jsp");
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
