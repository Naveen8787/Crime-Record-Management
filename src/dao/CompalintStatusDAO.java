package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Crime;
import utility.ConnectionManager;

public class CompalintStatusDAO {
		ConnectionManager con = new ConnectionManager();
		final static String sql="insert into COMPLAINTSTATUS(complaint_no,status) values(?,?)";
		List<Crime> Complaintstatus_list=new ArrayList<Crime>();

	public void ComplaintStatus1(Crime crime) throws ClassNotFoundException, SQLException {
		PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(sql);
		ps.setInt(1,crime.getComplaint_no());
		ps.setString(2,crime.getStatus());
		ps.executeUpdate();
		ps.close();
		System.out.println("Status of Complaint");
	}
public void getAllStatus() throws ClassNotFoundException, SQLException {
		
		Statement st = ConnectionManager.getConnection().createStatement();
		ResultSet rs = st.executeQuery("select * from COMPLAINTSTATUS order by complaint_no asc");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2));	

		}
}
public void ModifyCrimeStatus(Crime crime) throws ClassNotFoundException, SQLException {
String query="update COMPLAINTSTATUS set status=? where Complaint_no=?";
PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(query);
ps.setString(1,crime.getStatus());
ps.setInt(2,crime.getComplaint_no());
ps.executeUpdate();

boolean rowUpdated=ps.executeUpdate()>0;
if(rowUpdated) {
	System.out.println("record updated successfully");
}
else {
		System.out.println("check again");
}
}
}
