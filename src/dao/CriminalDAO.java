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

public class CriminalDAO {
	final static String sql="insert into CRIMINAL_REGISTRATION(CRIMINALNO,CHARGESHEET_NO,CRIMINALNAME,AGE,OCCUPATION,CRIMETYPE,ADDRESS,MOSTWANTED)values(?,?,?,?,?,?,?,?)";
	List<Crime> CriminalsList=new ArrayList<Crime>();

	public void AddCriminals(Crime crime) throws ClassNotFoundException, SQLException, IOException {
		PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(sql);
		ps.setInt(1,crime.getComplaint_no());
		ps.setInt(2,crime.getChargesheet_no());
		ps.setString(3,crime.getName());
		ps.setInt(4,crime.getAge());
		ps.setString(5,crime.getOccupation());
		ps.setString(6,crime.getCrimeType());
		ps.setString(7,crime.getAddress());
		ps.setString(8,crime.getFname());
		ps.executeUpdate();
		System.out.println("Crimanal has been Regestered");
	}
public void getAllCriminals() throws ClassNotFoundException, SQLException {
		
		Statement st = ConnectionManager.getConnection().createStatement();

		ResultSet rs = st.executeQuery("select * from CRIMINAL_REGISTRATION order by CRIMINALNO asc");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t\t "+rs.getInt(2)+"\t\t  "+rs.getString(3)+"    \t\t"+rs.getString(4)
			+"\t  "+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"    \t"+rs.getString(8));	

		}
}
public void deleteCriminal(int CRIMINALNO) throws ClassNotFoundException, SQLException{

			Boolean rowDeleted;
			PreparedStatement ps=ConnectionManager.getConnection().prepareStatement("delete from CRIMINAL_REGISTRATION where CRIMINALNO=?");
				ps.setInt(1, CRIMINALNO);
				
				rowDeleted=ps.executeUpdate()>0;
				   if(rowDeleted) {
					   System.out.println("record deleted");
					}
					else {
							System.out.println("Not found the record");
					}
			}

}
