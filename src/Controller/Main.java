package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.LocalDate;

import dao.AdminDAO;
import dao.ChargesheetDAO;
import dao.CompalintStatusDAO;
import dao.ComplaintDAO;
import dao.CriminalDAO;
import dao.FIRDAO;
import dao.UserDAO;
import model.Admin;
import model.Crime;
import model.User;
class One{
	void admin() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		String yes = null;
		System.out.println("\n------------------ADMIN OPERATIONS OF CRIME RECORD MANAGEMENT-------------------");
		
		System.out.println("\t 1. DISPLAY ALL COMPLAINTS");//FIR
		System.out.println("\t 2. FILE FIR");//FIR
		System.out.println("\t 3. DISPLAY ALL FIR");//FIR
		System.out.println("\t 4. COMPLAINT STATUS");//COMPLAINTSTATUS
		System.out.println("\t 5. UPDATE COMPLAINT STATUS");//COMPLAINTSTATUS
		System.out.println("\t 6. DELETE FIR");//FIR
		System.out.println("\t 7. ISSUE CHARGESHEET");//CHARGESHEET
		System.out.println("\t 8. DELETE CHARGESHEET RECORD");//COMPLAINT_REGISTRATION
		System.out.println("\t 9. DISPLAY CHARGESHEET RECORD");//COMPLAINT_REGISTRATION
		System.out.println("\t10. CRIMINAL_REGISTRATION");//COMPLAINT_REGISTRATION 
		System.out.println("\t11. DISPLAY CRIMINAL RECORDS");//CRIMINAL_REGISTRATION
		System.out.println("\t12. DELETE CRIMINAL_REGISTRATION");//CRIMINAL_REGISTRATION
		System.out.println("\t13. EXIT");

		System.out.println("--------------------------------------------------------------------------------------");

		do {	
			System.out.println("Enter your Option:");
			int option = 0;
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			//option is given by user and option is of integer type
			option =Integer.parseInt(br.readLine());
			Crime crime=new Crime();
			//Crime crime1=new Crime();
			ComplaintDAO complaintdao=new ComplaintDAO();
			CompalintStatusDAO complaintstatusdao=new CompalintStatusDAO();
			ChargesheetDAO chargesheetdao =new ChargesheetDAO();
			FIRDAO firdao=new FIRDAO();
			CriminalDAO criminaldao=new CriminalDAO();
			
			switch(option) 
			{
		case 1:
				System.out.println("DISPLAY ALL COMPLAINTS BY USER:");
				System.out.println("complaint_no\tcname\t\toccupation\t\t\taddress\t\t\t\tage\t\tgender\t\tfather's name\t\tcdate\t\tnationality");

				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				complaintdao.getAllCOMPLAINTS();
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				break;
		case 2:
				//creating FIR Record
				System.out.println("ADD FIR RECORD");
				System.out.println("FIR no :");
				int fir_no=Integer.parseInt(br.readLine());
				System.out.println("Enter Complaint_no:");
				int complaint_no=Integer.parseInt(br.readLine());
				System.out.println("Enter Descriprion Complaint:");
				String descriprion=br.readLine();
				System.out.println("Enter the Act Performed:");
				String act=br.readLine();
				System.out.println("Enter Place:");
				String place=br.readLine();
				System.out.println("Enter Address:");
				String address=br.readLine();
				System.out.println("Enter District:");
				String district=br.readLine();
				System.out.println("Enter Police Name:");
				String policeName=br.readLine();
				System.out.println("Enter date:");
				LocalDate Date=LocalDate.now();
				crime.setFir_no(fir_no);
				crime.setComplaint_no(complaint_no);
				crime.setDate(Date);
				crime.setDescriprion(descriprion);
				crime.setPlace(place);
				crime.setAct(act);
				crime.setDistrict(district);
				crime.setAddress(address);
				crime.setPoliceName(policeName);
				firdao.AddCrime(crime);
				break;
		case 3:
				//view data of complaints
				System.out.println("DISPLAY ALL FIR's");
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
				firdao.getAllFIR();
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
				break;	
		case 4:
				System.out.println("---------------COMPLAINT STATUS---------------");//COMPLAINTSTATUS
				System.out.println("Enter Complaint_no:");
				int complaint1=Integer.parseInt(br.readLine());
				System.out.println("Enter Satuts:");
				String status=br.readLine();
				crime.setComplaint_no(complaint1);
				crime.setStatus(status);
				complaintstatusdao.ComplaintStatus1(crime);
				break;
		 case 5:
		  		System.out.println("Update complaint Status:");
		  		System.out.println("Enter Complaint_no:");
				int complaints=Integer.parseInt(br.readLine());
				System.out.println("Enter Satuts:");
				String statuses=br.readLine();
				crime.setComplaint_no(complaints);
				crime.setStatus(statuses);
				complaintstatusdao.ModifyCrimeStatus(crime);
				break;
		 case 6:
				//delete record of FIR
				System.out.println("Enter  Fir_no which you want to delete");
				int fir_id=Integer.parseInt(br.readLine());
				firdao.delete(fir_id);
				break;
		 case 7:
				System.out.println("ISSUE CHARGESHEET");
				System.out.println("Enter chargesheet no:");
				int charge=Integer.parseInt(br.readLine());
				System.out.println("Enter FIR_no :");
				int fir=Integer.parseInt(br.readLine());
				System.out.println("Enter Complaint_no:");
				int comp=Integer.parseInt(br.readLine());
				System.out.println("Enter Police Station name:");
				String station=br.readLine();
				System.out.println("Enter police Name:");
				String name=br.readLine();
				System.out.println("Enter Accused name:");
				String Acc=br.readLine();
				System.out.println("Enter Occupation:");
				String occup=br.readLine();
				System.out.println("Enter Address:");
				String address2=br.readLine();
				System.out.println("Enter gender:");
				String gender1=br.readLine();
				System.out.println("Enter age :");
				int age1=Integer.parseInt(br.readLine());
				System.out.println("Enter date:");
				LocalDate Date2=LocalDate.now();
				crime.setChargesheet_no(charge);
				crime.setFir_no(fir);
				crime.setComplaint_no(comp);
				crime.setFname(station);
				crime.setName(name);
				crime.setAccused_name(Acc);
				crime.setOccupation(occup);
				crime.setAddress(address2);
				crime.setGender(gender1);
				crime.setAge(age1);
				crime.setDate(Date2);
				chargesheetdao.Chargesheeet(crime);
				break;
		 case 8:
				//delete record of Chargesheet
				System.out.println("Enter  Chargesheet_No Which you want to delete");
				int Chargesheet_no=Integer.parseInt(br.readLine());
				chargesheetdao.deleteChargesheet(Chargesheet_no);
				break;
				
		 case 9:	
				//view all records of chargesheets
				System.out.println("DISPLAY ALL CHARGESHEETS");
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
				chargesheetdao.getAllChargesheeet();
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
				break;
		 case 10:
				System.out.println("CRIMINAL_REGISTRATION");
				System.out.println("Enter Criminal No:");
				int criminal_no=Integer.parseInt(br.readLine());
				System.out.println("Enter chargesheet no:");
				int chargeSheet_no=Integer.parseInt(br.readLine());
				System.out.println("Enter Criminal name:");
				String criminal=br.readLine();
				System.out.println("Enter age :");
				int ages=Integer.parseInt(br.readLine());
				System.out.println("Enter Occupation:");
				String occupations=br.readLine();
				System.out.println("Enter Address:");
				String addresses=br.readLine();
				System.out.println("Enter Crime Type:");
				String crimeType=br.readLine();
				System.out.println("Enter mostwanted (Yes/No):");
				String mostwanted=br.readLine();
				crime.setChargesheet_no(chargeSheet_no);
				crime.setComplaint_no(criminal_no);
				crime.setName(criminal);
				crime.setAge(ages);
				crime.setOccupation(occupations);
				crime.setAddress(addresses);
				crime.setCrimeType(crimeType);
				crime.setFname(mostwanted);
				criminaldao.AddCriminals(crime);
				break;
		case 11:
				System.out.println("DISPLAY CRIMINAL RECORDS");
				System.out.println("Complaint_no\t ChargeSheet_no\t Criminal Name\t\tAge\t Occupation\tCrime Type\tAddress\t\t\t\tMost wanted");
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
				criminaldao.getAllCriminals();
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
				break;

		case 12:
				System.out.println("Delete criminal registration:");
	  			int CRIMINALNO=Integer.parseInt(br.readLine());
				criminaldao.deleteCriminal(CRIMINALNO);
				break;
		case 13:
				System.out.println("-----------------------THANK YOU!!-----------------------");
				System.exit(0);
				
			}System.out.println("Do you want to continue");
				yes=br.readLine();	
			}while(yes.equals("yes"));
	}
		
//User Functions
void user() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
	String yes = null;
	System.out.println("\n------------------USER OPERATIONS OF CRIME RECORD MANAGEMENT-------------------");
	System.out.println("\t1. CASE REGISTRATION");//COMPLAINT_REGISTRATION
	System.out.println("\t2. DISPLAY ALL CASES REGISTERED");//COMPLAINTSTATUS
	System.out.println("\t3. DISPLAY COMPLAINT STATUS");//COMPLAINTSTATUS
	System.out.println("\t4. DELETE COMPLAINTS");
	System.out.println("\t5. EXIT");
	System.out.println("---------------------------------------------------------------------------------");
	do {	
		System.out.println("Enter your Option From above Crime record management :");
		int option = 0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//option is given by user and option is of integer type
		option =Integer.parseInt(br.readLine());
		//Crime crime=new Crime();
		Crime crime1=new Crime();
		
		ComplaintDAO complaintdao=new ComplaintDAO();
		CompalintStatusDAO complaintstatusdao=new CompalintStatusDAO();
		
		
		switch(option) 
		{
		
		case 1:
			System.out.println("---------------CASE REGISTRATION---------------");//COMPLAINT_REGISTRATION	
			System.out.println("Enter Complaint_no:");
			int complaint=Integer.parseInt(br.readLine());
			System.out.println("Enter Name:");
			String Name=br.readLine();
			System.out.println("Enter Occupation:");
			String occupation=br.readLine();
			System.out.println("Enter Address:");
			String address1=br.readLine();
			System.out.println("Enter Age:");
			int age=Integer.parseInt(br.readLine());
			System.out.println("Enter Gender:");
			String gender=br.readLine();
			System.out.println("Enter Father name:");
			String Fname=br.readLine();
			//System.out.println("Enter Date:");
			LocalDate Date1=LocalDate.now();	
			System.out.println("Enter Nationality:");
			String Nationality=br.readLine();
			crime1.setComplaint_no(complaint);
			crime1.setName(Name);
			crime1.setOccupation(occupation);
			crime1.setAddress(address1);
			crime1.setAge(age);
			crime1.setGender(gender);
			crime1.setFname(Fname);
			crime1.setDate(Date1);
			crime1.setNationality(Nationality);
			complaintdao.AddComplaint(crime1);
		case 2:
		   	//view data of Complaints
			System.out.println("DISPLAY ALL COMPLAINTS:");
			System.out.println("complaint_no\tcname\t\toccupation\t\t\taddress\t\t\t\tage\t\tgender\t\tfather's name\t\tcdate\t\tnationality");

			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			complaintdao.getAllCOMPLAINTS();
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			break;
		case 3:
			//view data of Complaints_Status
			System.out.println("DISPLAY ALL COMPLAINT_STATUS:");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			complaintstatusdao.getAllStatus();
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			break;
		case 4:
			//enter complaint_no which u want to be deleted
			System.out.println("Enter  Complaint_no which you want to delete");
			int Complaint_no=Integer.parseInt(br.readLine());
			complaintdao.deletecase(Complaint_no);
			break;
					
		case 5:
		    System.out.println("------------------EXIT------------------");
			System.exit(0);//this statement is used to exit.
			break;
		

}
	System.out.println("Do you want to continue");
	yes=br.readLine();	
	}while(yes.equals("yes"));
}
}
public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
				System.out.println("\n--------------------------------CRIME RECORD MANAGEMENT--------------------------------");
				while (true) {
				System.out.println("1.ADMIN");
				System.out.println("2.USER");
				System.out.println("3.EXIT");
				System.out.println("-----------------------------------------------------------------------------------------");
				String username=null;
				String password=null;
				//int option = 0;
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				// 
				One one = new One();
				//Validations validate = new Validations();
				int choice =Integer.parseInt(br.readLine());
				switch(choice) {
				//Admin Login functions 
				case 1:
					System.out.println("ADMIN LOGIN DETAILS:");
					System.out.println("Enter Username:");
					username = br.readLine();
					System.out.println("Enter Password:");
					password = br.readLine();
					//Admin object
					Admin admin = new Admin(username, password);
					AdminDAO admindao = new AdminDAO();
					boolean validateAdmin = false;
					validateAdmin = admindao.loginAdmin(admin);
					if(validateAdmin)
					{	
		  				System.out.println("LOGIN SUCESSFUL!!");	
		  				one.admin();

					}
					else
					{
						System.out.println("PLEASE CHECK USERNAME AND PASSWORD");
					}	
					break;
			    //User SignUp and SignIN
				case 2:
					int choice1;
					do {
						System.out.println("---------------------------------------------------------------------------------------");
						System.out.println("USER SIGN-UP & SIGN-IN DETAILS:");
						System.out.println("1.Sign Up");
						System.out.println("2.Sign In");
						System.out.println("3.Exit");
						System.out.println("---------------------------------------------------------------------------------------");
						choice1 = Integer.parseInt(br.readLine());
						switch (choice1) {
						//User Sign Up functions
						case 1:
							System.out.println("--------------USER SIGN-UP AND SIGN-IN------------------");
							System.out.println("SIGN UP DETAILS:");
							System.out.println("Enter Username:");
								username = br.readLine();
								System.out.println("Enter Password:");
								password = br.readLine();
								User user=new User(username, password);
								user.setUsername(username);
								user.setPassword(password);
								UserDAO userdao=new UserDAO();
								int checkAdmin = 0;
								try {
									checkAdmin = userdao.signUp(user);
									} catch (ClassNotFoundException e) {
									e.printStackTrace();
									}
									
								if(checkAdmin!=0)
								{				
									//System.out.println(user.getUsername());
									//System.out.println(user.getPassword());	
									System.out.println("Registration Successful");
									}
								else
								{
									System.out.println("Check your email and password");
								}
											
						case 2:
							//User Sign In functions
							//above sign-up details are entered by user as sign-in details
							System.out.println("SIGN IN DETAILS:");
							System.out.println("Enter Username:");
							username = br.readLine();
							System.out.println("Enter Password:");
							password = br.readLine();
									//user object
									User user1 = new User(username, password);
									user1.setUsername(username);
									user1.setPassword(password);					
									//userdao object
									UserDAO userdao1 = new UserDAO();
								boolean validateUser = false;
								validateUser = userdao1.loginUser(user1);
								if(validateUser) {
									System.out.println("Login Successful !!");
					  				one.user();

								}
								else
								{
									System.out.println(" Please check your Login Details!!");
								}
								break;
								
						case 3:
							System.out.println("RETURNED BACK TO CRIME RECORD OPERATIONS");
							break;
						default:
							System.out.println("Wrong Choice");
							break;
								}
							}while(choice1!=3);
						break;
					case 3:
						System.out.println("THANK YOU!");
						System.exit(0);
						break;
					default:
						System.out.println("Wrong Choice!!");
						break;
				}
			}

		}
}

