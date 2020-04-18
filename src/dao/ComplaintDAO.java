package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Crime;
import utility.ConnectionManager;

public class ComplaintDAO {
	final static String sql="insert into COMPLAINT_REGISTRATION(complaint_no,cname,occupation,address,age,gender,fname,cdate,nationality) values(?,?,?,?,?,?,?,?,?)";
	List<Crime> ComplaintList=new ArrayList<Crime>();

	public void AddComplaint(Crime crime) throws ClassNotFoundException, SQLException, IOException {
		PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(sql);

		ps.setInt(1,crime.getComplaint_no());
		ps.setString(2,crime.getName());
		ps.setString(3,crime.getOccupation());
		ps.setString(4,crime.getAddress());
		ps.setInt(5,crime.getAge());
		ps.setString(6,crime.getGender());
		ps.setString(7,crime.getFname());
		ps.setDate(8,java.sql.Date.valueOf(crime.getDate()));
		ps.setString(9,crime.getNationality());
		ps.executeUpdate();
		System.out.println("Complaint has been Regestered");
	}
	public void getAllCOMPLAINTS() throws ClassNotFoundException, SQLException {
		
		Statement st = ConnectionManager.getConnection().createStatement();
		ResultSet rs = st.executeQuery("select * from COMPLAINT_REGISTRATION order by complaint_no asc");
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"     \t"+rs.getString(3)+"\t       "+rs.getString(4)
			+"    \t          "+rs.getInt(5)+"\t  \t"+rs.getString(6)+"\t\t"+rs.getString(7)+"\t\t\t"+rs.getDate(8)+"\t\t"+rs.getString(9));
		}
	}
	
	public void deletecase(int complaint_no) throws ClassNotFoundException, SQLException{

			Boolean rowDeleted;
			PreparedStatement ps=ConnectionManager.getConnection().prepareStatement("delete from COMPLAINT_REGISTRATION where complaint_no=?");
				ps.setInt(1, complaint_no);
				
				rowDeleted=ps.executeUpdate()>0;
				   if(rowDeleted) {
					   System.out.println("record deleted");
					}
					else {
							System.out.println("Not found the record");
					}
			}
}
