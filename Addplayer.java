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
 * Servlet implementation class addplayer
 */
@WebServlet("/Addplayer")
public class Addplayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DBConnector db = new DBConnector();
	
	Connection con = db.getConnections();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addplayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String p_name = request.getParameter("p_name");
		String t_no = request.getParameter("t_no");
		String p_age = request.getParameter("p_age");
		String p_sex = request.getParameter("p_sex");
		//System.out.println(p_sex[0]+"  "+p_sex.length);
		String p_no = request.getParameter("p_no");
		String[] b_sports={},g_sports={};
		if("男".equals(p_sex)){
			b_sports = request.getParameterValues("b_sports");
			System.out.println(p_sex+""+b_sports.length+b_sports[0]);
		}else{
			g_sports = request.getParameterValues("g_sports");
			System.out.println(g_sports.length);
		}
		String[] b_sp={"0","0","0","0","0","0","0"};
		String[] g_sp={"0","0","0","0","0"};
		String sql1 = "select * from p_group where groupno=? limit 1";
		String sql2 ; 
		try{
			PreparedStatement ps = con.prepareStatement(sql1);
			ps.setString(1, t_no);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				if("男".equals(p_sex)){		
					sql2 = "insert into p_group_player(name,sex,age,pno,groupno,dangang,shuanggang,diaohuan,tiaoma,freeticao,anma,benbed)values(?,?,?,?,?,?,?,?,?,?,?,?)";
					for(int i=0;i<b_sports.length;i++){
						if("dangang".equals(b_sports[i])){
							b_sp[0] = "1";
							System.out.println(b_sports[i]);
						}else if("shuanggang".equals(b_sports[i])){
							b_sp[1] = "1";
						}else if("diaohuan".equals(b_sports[i])){
							b_sp[2] = "1";
						}else if("tiaoma".equals(b_sports[i])){
							b_sp[3] = "1";
						}else if("freeticao".equals(b_sports[i])){
							b_sp[4] = "1";
						}else if("anma".equals(b_sports[i])){
							b_sp[5] = "1";
						}else {
							b_sp[6] = "1";
						}
					}
					ps = con.prepareStatement(sql2);
					ps.setString(1, p_name);
					ps.setString(2, p_sex);
					ps.setInt(3, Integer.parseInt(p_age));
					ps.setString(4, p_no);
					ps.setString(5,t_no);
					ps.setString(6,b_sp[0]);
					ps.setString(7,b_sp[1]);
					ps.setString(8,b_sp[2]);
					ps.setString(9,b_sp[3]);
					ps.setString(10,b_sp[4]);
					ps.setString(11,b_sp[5]);
					ps.setString(12,b_sp[6]);
				}else{
					sql2 = "insert into p_group_player(name,sex,age,pno,groupno,tiaoma,gaodigang,pinghengmu,freeticao,benbed)values(?,?,?,?,?,?,?,?,?,?)";
					for(int i=0;i<g_sports.length;i++){
						if("tiaoma".equals(g_sports[i])){
							g_sp[0] = "1";
							System.out.println(g_sports[i]);
						}else if("gaodigang".equals(g_sports[i])){
							g_sp[1] = "1";
						}else if("pinghengmu".equals(g_sports[i])){
							g_sp[2] = "1";
						}else if("freeticao".equals(g_sports[i])){
							g_sp[3] = "1";
						}else{
							g_sp[4] = "1";
						}
					}
					ps = con.prepareStatement(sql2);
					ps.setString(1, p_name);
					ps.setString(2, p_sex);
					ps.setInt(3, Integer.parseInt(p_age));
					ps.setString(4, p_no);
					ps.setString(5,t_no);
					ps.setString(6,g_sp[0]);
					ps.setString(7,g_sp[1]);
					ps.setString(8,g_sp[2]);
					ps.setString(9,g_sp[3]);
					ps.setString(10,g_sp[4]);
				}
				int res = ps.executeUpdate();
				if(res != 0){
					System.out.println("创建成功！");
					response.sendRedirect("src/main/webapp/homepage.jsp");
				}
			}else{
				System.out.println("无效的队伍编号！");
				response.sendRedirect("src/main/webapp/addplayer.jsp");
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
