package dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Crime;
import utility.ConnectionManager;

public class FIRDAO {
	static String sql="insert into FIR(FIR_NO,COMPLAINT_NO,CDATE,DESCRIPTION,PLACE,ACT,DISTRICT,ADDRESS,POLICENAME) values(?,?,?,?,?,?,?,?,?)";     
	List<Crime> CrimeList=new ArrayList<Crime>();
	public void AddCrime(Crime crime) throws ClassNotFoundException, SQLException, IOException {
		PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(sql);
		try
		{
		ps.setInt(1,crime.getFir_no());
		ps.setInt(2,crime.getComplaint_no());
		ps.setDate(3,Date.valueOf(crime.getDate()));
		ps.setString(4,crime.getDescriprion());
		ps.setString(5,crime.getPlace());
		ps.setString(6,crime.getAct());
		ps.setString(7,crime.getDistrict());
		ps.setString(8,crime.getAddress());
		ps.setString(9,crime.getPoliceName());
		System.out.println(ps);
		ps.executeUpdate();
		System.out.println("FIR has been Filled");
	} catch (SQLException e) {
		System.out.println(e);
	}
	}
	public void getAllFIR() throws ClassNotFoundException, SQLException {
		
		Statement st = ConnectionManager.getConnection().createStatement();

		ResultSet rs = st.executeQuery("select * from FIR order by fir_no asc");
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getDate(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"
		+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t");

		}	
	}

public void delete(int fir_no) throws ClassNotFoundException, SQLException{
		Boolean rowDeleted;
		PreparedStatement ps=ConnectionManager.getConnection().prepareStatement("delete from FIR where fir_no=?");
		ps.setInt(1, fir_no);		
		rowDeleted=ps.executeUpdate()>0;
			if(rowDeleted) {
			    System.out.println("record deleted");
			}
			else {
				System.out.println("Not found the record");
			}
		}
}
