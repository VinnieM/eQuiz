GO
	use quiz
GO
	CHECKPOINT
GO
	create table Aptitude
	(
		ques Text not null,
		ansA varchar(50) not null,
		ansB varchar(50) not null,
		ansC varchar(50) not null,
		ansD varchar(50) not null,
		ans varchar(50) not null
	)
GO
	CHECKPOINT
GO
	select * from Aptitude
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('The greatest number that will divide 187,233 and 279 leaving the same         remainder in each case is ','35','36','56','30','30')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('On specification, the expression 1-[1-{1-(1-1-1)}]','1','2','3','-1','3')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('By how much is two third of 57 more than one third of 90','8','30','28','38','8')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('In a family , the father took 1/4 of the cake and he had 3 time as much as      others had. The total number of family members is','10','7','8','11','10')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('The average weight of 8 men is increased by 1.5 kg when one of the men    who weight 65kg is replaced by anew  man. The weight of the new man is','76','77','76.5','76.7','77')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('The difference of two number is 11 and 1/5th of their sum is 9. The numbers are','31,20','31,19','30,19','28,17','28,17')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('The sum of three consecutive odd numbers is 57. The middle one is','17','19','23','16','19')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('The total of the ages of A, B, C at present 90 years. Ten years ago, the ratio of their ages was 1:2:3. What is the age of B at present? ','40 yrs','25 yrs','30 yrs','20 yrs','30 yrs')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('What percent is 3% of 5%?','60%','30%','50%','15%','60%')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('x% of y is y% of','100x','0','x','x/100','x')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('A vendor bought a number of bananas at 6 for 5 rupees and sold at 4 for 3 rupees.Find his gain percent','10%','20%','25%','30%','10%')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('If  2A=3B=4C,then A:B:C','2:3:4','2:3:6','6:4:3','3:4:6','6:4:3')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('A,B and C hired a car for Rs.520 and used it for 7,8 and 11 hours respt.        Hire charges paid by B were','Rs. 180','Rs. 130','Rs. 140','Rs. 160','Rs. 160')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('8 men can dig a pit in 20 days. If a man works half as much again as a boy,    then 4 men and 9 boys can dig a similar pit in','10 days','12 days','16 days','13 days','16 days')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('Two pipes A and B can fill a tank in 6 hrs and 4 hrs respt.If they are opened on alternate hrs and if pipe A is opened first,in how many hrs, the tank shall   be full','4','5','4 1/2','5 1/2','5')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('With a speed of 60 kmph a train crosses a pole in 30 sec. The length of the tarin is','500m','1000m','750m','700m','500m')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('A train 270m long is moving at aspped of 24 kmph.It will cross a man              coming from the opposite directon at a speed of 3 kmp, in','36 sec','28 sec','30 sec','24 sec','36 sec')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('If a man rows at te rate of 5 kmph in still water and his rate against the         current is 3.5 kmph,  then the mans rate along the current is ','7 kmph','6.5 kmph','8.5 kmph','6 kmph','6.5 kmph')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('If a sum of money at simple interest doubles in 6 yrs,it will become 4 times in','14 yrs','9 yrs','16 yrs','18 yrs','18 yrs')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('The capacity of a tank of dimensions(8m x 6m x 2.5m)','120 L','12 L','120000 L','1200 L','120000 L')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('9,12,11,14,13,_,15','10','16','12','17','16')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('Find the wrong number in the series(3,8,15,24,34,48,63)','23','34','24','15','34')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('2,4,12,48,240,_','960','480','1440','1080','1440')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('The lest prime number is','0','1','-1','2','2')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('The sum of all prime numbers between 60 and 90 is','373','460','523','427','523')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('How many three diit numbers are divisible by 6 in all','149','150','166','165','150')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('The LCM of 2/3,3/5,4/7,9/13','36','1/36','12/455','22','36')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('0.7683+0.369+0.05+0.8=?','0.8065','1.9836','1.9873','0.8110','1.9873')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('Desending order','7/3,3/5,6/7','7/9,6/7,3/5','7/9,3/5,7/3','6/7,7/9,3/5','6/7,7/9,3/5')
GO
	insert Aptitude (ques,ansA,ansB,ansC,ansD,ans) values ('The fraction for 0.535353... is','53/99','27/53','28/53','34/99','53/99')
