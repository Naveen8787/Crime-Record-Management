CREATE TABLE ADMINlOGIN (
  USERNAME VARCHAR(50) NOT NULL,
  PASSWORD VARCHAR(50)NOT NULL
);
select * from ADMINLOGIN;
----------------------------------------------------------------------------
CREATE TABLE USERLOGIN (
  USERNAME VARCHAR(50)NOT NULL,
  PASSWORD VARCHAR(50)NOT NULL,
  PRIMARY KEY (USERNAME)
);
select * from USERLOGIN;

CREATE TABLE COMPLAINT_REGISTRATION (
  COMPLAINT_NO NUMBER(11)NOT NULL,
  CNAME VARCHAR(50)NOT NULL,
  OCCUPATION VARCHAR(50)NOT NULL,
  ADDRESS VARCHAR(50)NOT NULL,
  AGE NUMBER(11)NOT NULL,
  GENDER VARCHAR(50)NOT NULL,
  FNAME VARCHAR(50)NOT NULL,
  CDATE DATE NOT NULL,
  NATIONALITY VARCHAR(50)NOT NULL,
  PRIMARY KEY(COMPLAINT_NO)
);
insert into COMPLAINT_REGISTRATION(complaint_no,cname,occupation,address,age,gender,fname,cdate,nationality)
values(1,'Sunny','Software','Jammikunta(M)Karimnagar(D)',22,'Male','Satya',TO_DATE('2020/04/13','YYYY/MM/DD'),'Indian');


select * from COMPLAINT_REGISTRATION;


delete from COMPLAINT_REGISTRATION where complaint_no=5;
CREATE TABLE FIR (
  FIR_NO NUMBER(11) NOT NULL,
  COMPLAINT_NO NUMBER(11) NOT NULL,
  FOREIGN KEY(COMPLAINT_NO) REFERENCES COMPLAINT_REGISTRATION(COMPLAINT_NO), 
  CDATE DATE,
  DESCRIPTION VARCHAR(50)NOT NULL,
  PLACE VARCHAR(50) NOT NULL,
  ACT VARCHAR(50)NOT NULL,
  DISTRICT VARCHAR(50)NOT NULL,
  ADDRESS VARCHAR(50)NOT NULL,
  POLICENAME VARCHAR(50) NOT NULL,
  PRIMARY KEY (FIR_NO)
);

insert into FIR(FIR_NO,COMPLAINT_NO,CDATE,DESCRIPTION,PLACE,ACT,ADDRESS,DISTRICT,POLICENAME)
VALUES(1,1,TO_DATE('2020/04/13','yyyy/mm/dd'),'Stole my Bag and ran away','near Gandhi-statue','Stealing','Jammikunta(M)Karimnagar(D)','Karimnagar(D)','Sai Prasad');
select * from FIR order by fir_no asc ;

CREATE TABLE CHARGESHEET (
  CHARGESHEET_NO NUMBER(11) NOT NULL,
  COMPLAINT_NO NUMBER(11) NOT NULL,   
  FOREIGN KEY(COMPLAINT_NO) REFERENCES COMPLAINT_REGISTRATION(COMPLAINT_NO), 
  POLICESTATION_NAME VARCHAR(50)NOT NULL,
  CHARGESHEET_DATE DATE,
  NAME VARCHAR(50)NOT NULL,
  ACCUSED_NAME VARCHAR(50)NOT NULL,
  OCCUPATION VARCHAR(50)NOT NULL,
  ADDRESS VARCHAR(50)NOT NULL,
  GENDER VARCHAR(50)NOT NULL,
  AGE NUMBER(11)NOT NULL,
  PRIMARY KEY (CHARGESHEET_NO)
);

insert into chargesheet(chargesheet_no,complaint_no,policestation_name,chargesheet_date,name,accused_name,occupation,address,gender,age)
values(1,1,'Jammikunta PS-I',TO_DATE('2020/04/13','YYYY/MM/DD'),'Naveen','Sunny','Software','Jammikunta(M),Krimnagar(D)','Male',22);
select * from chargesheet order by chargesheet_no asc;


CREATE TABLE COMPLAINTSTATUS (
  COMPLAINT_NO NUMBER(11)NOT NULL,
  STATUS VARCHAR(50)NOT NULL,
  PRIMARY KEY (COMPLAINT_NO)
);

insert into COMPLAINTSTATUS(complaint_no,status)
values(1,'Case-Taken-up');
Select * from COMPLAINTSTATUS;


CREATE TABLE CRIMINAL_REGISTRATION (
  CRIMINALNO NUMBER(11) NOT NULL,
  CHARGESHEET_NO NUMBER(11)NOT NULL,
  FOREIGN KEY(CHARGESHEET_NO) REFERENCES CHARGESHEET(CHARGESHEET_NO), 
  CRIMINALNAME VARCHAR(50)NOT NULL,
  AGE NUMBER(11)NOT NULL,
  OCCUPATION VARCHAR(50)NOT NULL,
  CRIMETYPE VARCHAR(50)NOT NULL,
  ADDRESS VARCHAR(50)NOT NULL,
  MOSTWANTED VARCHAR(50)NOT NULL,
  PRIMARY KEY (CRIMINALNO)
);

insert into CRIMINAL_REGISTRATION(CRIMINALNO,CHARGESHEET_NO,CRIMINALNAME,AGE,OCCUPATION,CRIMETYPE,ADDRESS,MOSTWANTED)
values(1,1,'Sunny',22,'software','Stealing','Jammikunta(M),Krimnagar(D)','Yes');
Select * from CRIMINAL_REGISTRATION;


commit;

DROP TABLE COMPLAINT_REGISTRATION;
DROP TABLE FIR;
DROP TABLE CRIMINAL_REGISTRATION;
DROP TABLE MOSTWANTED;
DROP TABLE PRISONER_REGISTRATION;
DROP TABLE COMPLAINTSTATUS;
DROP TABLE CHARGESHEET;





----------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE PRISONER_REGISTRATION (
  PRISONER_NO NUMBER(11)NOT NULL,
  CHARGESHEET_NO NUMBER(11)NOT NULL,
  FOREIGN KEY(CHARGESHEET_NO) REFERENCES CHARGESHEET(CHARGESHEET_NO), 
  FATHERNAME VARCHAR(50)NOT NULL,
  IDENTITY_MARKS VARCHAR(50)NOT NULL,
  HEIGHT NUMBER(11)NOT NULL,
  WEIGHT NUMBER(11)NOT NULL,
  COLOR VARCHAR(50)NOT NULL,
  PRIMARY KEY (PRISONER_NO)
);

CREATE TABLE MOSTWANTED (
  MST_ID NUMBER(11)NOT NULL,
  CHARGESHEET_NO NUMBER(11)NOT NULL,
  FOREIGN KEY(CHARGESHEET_NO) REFERENCES CHARGESHEET(CHARGESHEET_NO),   
  MST_NAME VARCHAR(50)NOT NULL,
  AGE NUMBER(11)NOT NULL,
  GENDER VARCHAR(50)NOT NULL,
  DESCRIPTION VARCHAR(50)NOT NULL,
  PRIMARY KEY (MST_ID)
);
