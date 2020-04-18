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

public class ChargesheetDAO {
	final static String sql="insert into CHARGESHEET(chargesheet_no,complaint_no,Policestation_name,Chargesheet_Date,name,accused_name,occupation,address,gender,age) values(?,?,?,?,?,?,?,?,?,?)";
	List<Crime> Chargesheeetlist=new ArrayList<Crime>();

	public void Chargesheeet(Crime crime) throws ClassNotFoundException, SQLException, IOException {
		PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(sql);
		ps.setInt(1,crime.getChargesheet_no());
		ps.setInt(2,crime.getComplaint_no());
		ps.setString(3,crime.getFname());
		ps.setDate(4,java.sql.Date.valueOf(crime.getDate()));
		ps.setString(5,crime.getName());
		ps.setString(6,crime.getAccused_name());
		ps.setString(7,crime.getOccupation());
		ps.setString(8,crime.getAddress());
		ps.setString(9,crime.getGender());
		ps.setInt(10,crime.getAge());

		ps.executeUpdate();
		ps.close();
		System.out.println("ChargeSheet issued");
	}
public void getAllChargesheeet() throws ClassNotFoundException, SQLException {
		
		Statement st = ConnectionManager.getConnection().createStatement();

		ResultSet rs = st.executeQuery("select * from chargesheet order by chargesheet_no asc");
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getString(3)+"\t"+rs.getDate(4)
			+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getInt(10));	

		}
}
public void deleteChargesheet(int chargesheet_no) throws ClassNotFoundException, SQLException{

	Boolean rowDeleted;
	PreparedStatement ps=ConnectionManager.getConnection().prepareStatement("delete from CHARGESHEET where chargesheet_no=?");
		ps.setInt(1, chargesheet_no);
		
		rowDeleted=ps.executeUpdate()>0;
		   if(rowDeleted) {
			   System.out.println("record deleted");
			}
			else {
					System.out.println("Not found the record");
			}
	}
}
