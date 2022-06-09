USE testing
GO
drop table Identification
drop table login_attempt
drop table login_history
drop table profile_info

create table Identification (
	id int  primary key,
	mobile_no char(10) unique
)

create table login_attempt (
	attempt_id int  primary key,
	identity_id int,
	generated_otp char(4),
	user_entered_otp char(4),
	attempt_time datetime,
	is_valid int
)

create table login_history (
	history_id int  primary key,
	identity_id int,
	login_time datetime,
	logout_time datetime,
)

create table profile_info(
	profile_id int primary key,
	identity_id int,
	name char(30),
	gender char(1),
	dob date,
	houseno char(30),
	city char(30),
	state char(30),
	country char(30)
)
go