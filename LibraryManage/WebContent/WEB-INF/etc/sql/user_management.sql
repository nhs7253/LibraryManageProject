CREATE TABLE user_management(
	user_id VARCHAR2(30) PRIMARY KEY,
	password VARCHAR2(30) NOT NULL,
	user_name VARCHAR2(30) NOT NULL,
	phone_num VARCHAR2(30),
	email VARCHAR2(50) NOT NULL,
	penalty_state VARCHAR2(10)
	
)

insert into user_management values('kite','kitesoo','박연수','01099900','kite_90@naver.com','N');
DROP TABLE user_management;

select * from USER_MANAGEMENT;