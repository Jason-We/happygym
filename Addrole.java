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
 * Servlet implementation class Addrole
 */
@WebServlet("/Addrole")
public class Addrole extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DBConnector db = new DBConnector();
	
	Connection con = db.getConnections();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addrole() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String r_name = request.getParameter("r_name");
		String r_no = request.getParameter("t_no");
		String r_type = request.getParameter("r_type");
		String r_idnum = request.getParameter("r_idnum");
		
		String sql1 = "select * from p_group where groupno=? limit 1"; 
		String sql2 = "insert into p_group_role(name,groupno,role,idcard)values(?,?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql1);
			ps.setString(1, r_no);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				ps = con.prepareStatement(sql2);
				ps.setString(1, r_name);
				ps.setString(2, r_no);
				ps.setString(3, r_type);
				ps.setString(4, r_idnum);
				int res = ps.executeUpdate();
				if(res != 0){
					System.out.println("创建成功！");
					response.sendRedirect("src/main/webapp/addplayer.jsp");
				}
				//response.sendRedirect("src/main/webapp/homepage.html");
			}else{
				System.out.println("无效的队伍编号！");
				response.sendRedirect("src/main/webapp/addrole.jsp");
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
