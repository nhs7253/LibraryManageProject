CREATE TABLE user_management(
	user_id VARCHAR2(30) PRIMARY KEY,
	password VARCHAR2(30) NOT NULL,
	user_name VARCHAR2(30) NOT NULL,
	phone_num VARCHAR2(30),
	email VARCHAR2(50) NOT NULL,
	penalty_state VARCHAR2(10)
	
)

insert into user_management values('kitesoo','kitesoo','박연수','01099900','kite_90@naver.com','N');
insert into user_management values('aa','aa','aa','11','aa@.aaa.com''N');
insert into user_management values('bb','aa','bb','22','bb@bb.com','Y');
insert into user_management values('ccc','aa','cc','33','cc@cc.com','N');
DROP TABLE user_management;

select * from USER_MANAGEMENT;

		select user_id,password,user_name,phone_num,email,penalty_state
		from(
			select rownum rnum,user_id,password,user_name,phone_num,email,penalty_state
			from(
				select 	user_id,password,user_name,phone_num,email,penalty_state
				from user_management) 
			where rownum  <= 3)
		where rnum >= 1;