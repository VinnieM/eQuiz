GO
	create database quiz
GO
	CHECKPOINT
GO
	use quiz
GO
	CHECKPOINT
GO
	create table userset
	(
		name_user varchar(30)  primary key not null,
		id_user int identity(1000,1) not null,
		date_time datetime default getDate() not null
	)
GO
	CHECKPOINT
GO
	select * from userset




GO
	CHECKPOINT
GO
	create table questionset
	(
		name_user varchar(30) primary key not null,
		topic varchar(20) not null,
		noques varchar(3) not null,
		time1 varchar(2)not null
	)

GO
	CHECKPOINT
GO
	select * from questionset


GO
	CHECKPOINT
GO
	create table resultset
	(
		name_user varchar(30) not null,
		maxscore varchar(5),
		score varchar(5),
		percentage varchar(5),
		da_ti varchar(20),
		status varchar(20) not null
	)
GO
	CHECKPOINT
GO
	select * from resultset

