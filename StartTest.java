import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.sql.*;
import java.util.Date;
public class StartTest
{
	JFrame fr;
	JPanel pn,pninstr,pnq,pnrst;
	JLabel lblinstr,lblcare,lblin1,lblin2,lblin3,lblin4,lblin5,lblin6,lblin7,lblin8;
	JLabel lblrs,lbluser,lblmaxscore,lblscore,lblper,lbldt,lblstatus;
	JLabel time,lblImage,lbleQuiz,lbltest,lblwel,lblpow,lblgood,lblscroll,lblIn,lblline,lblearth,lblblink;
	JTextArea txtqus;
	JRadioButton rb1,rb2,rb3,rb4,rbin1,rbin2;
	ButtonGroup gb,gb1;
	JProgressBar pb;
	JButton bt,btok,btstart,btlog,btexit;
	Connection con;
	ResultSet rs;
	Statement st;
	PreparedStatement ps;
	String us,pa,date_time;
	String qs,op1,op2,op3,op4,ans,selans,da,ns,st1;
	String msg,instr,read,i1,i2,i3,i4,i5,i6,i7,i8;
	int r1,r2,r3,r4;
	int c=1,pi,m=24,s=60,nq,nt,mark=0,perc;
	Thread t,t1;
	Date d;
	StartTest(String usn,String pas) 
	{
		us=usn.trim();pa=pas;
		d=new Date();
		fr=new JFrame("eQuiz WelcomE "+us);
		fr.setLayout(null);
		pn=new JPanel();
		pn.setBounds(0,0,750,540);
		pn.setLayout(null);
		pn.setBackground(Color.black);		
		
//####################### Center Setting #####################
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		//fr.setLocation(400,400);
		fr.setLocation( ( (screenDim.width - fr.getSize().width) / 2 )-380,((screenDim.height - fr.getSize().height)/2)-270);

//####################### Icon #########################
		fr.setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Images\\my.gif"));
		ImageIcon wel = new ImageIcon(".\\Images\\new.gif");
		ImageIcon eQ = new ImageIcon(".\\Images\\eQuiz.gif");
		ImageIcon click = new ImageIcon(".\\Images\\click.gif");
		ImageIcon pow = new ImageIcon(".\\Images\\pow.gif");
		
		Font fnt1 = new Font("Monotype Corsiva",Font.BOLD,40);
		Font fnt2 = new Font("Monotype Corsiva",Font.PLAIN,20);

		lblwel =new JLabel("Welcome  " +us.trim());
		lblwel.setBounds(20,20,600,30);
		lblwel.setForeground(Color.lightGray);
		lblwel.setFont(fnt1);
		pn.add(lblwel);

		pn.setBackground(Color.black);
		pn.setLayout(null);
		lblImage = new JLabel(wel);
		lblImage.setBounds(220,0,300,400);
		pn.add(lblImage);

		lbleQuiz=new JLabel(eQ);
		lbleQuiz.setBounds(270,265,200,80);			
		pn.add(lbleQuiz);
			
		lbltest = new JLabel("Testing Yourself");
		lbltest.setBounds(360,285,200,80);
		lbltest.setForeground(Color.lightGray);
		lbltest.setFont(fnt2);
		pn.add(lbltest);

		lblpow =new JLabel(pow);
		lblpow.setBounds(350,440,500,100);			
		pn.add(lblpow);
	
		btok = new JButton(click);
		btok.setBounds(330,370,60,30); 
		OK okact = new OK();
		btok.addActionListener(okact);
		pn.add(btok);
		
		fr.getContentPane().add(pn);

		fr.setSize(750,540);
		fr.setVisible(true);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);		
	}
	public void instructions()
	{

		DBConnection();

		try
		{
			st=con.createStatement();
			rs=st.executeQuery("select * from questionset");
			while(rs.next())
			{
				String s=rs.getString(1).trim();
				if(us.compareToIgnoreCase(s)==0)
				{
					da=rs.getString(2).trim();
					nq=Integer.parseInt(rs.getString(3).trim());
					nt=Integer.parseInt(rs.getString(4).trim());
					con.close();
					break;		
				}
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(fr,"Error in Questionset");
		}


		pn.setBounds(0,0,0,0);
		pninstr=new JPanel();
		pninstr.setBounds(0,0,750,540);
		pninstr.setLayout(null);
		pninstr.setBackground(Color.lightGray);

		ImageIcon good = new ImageIcon(".\\Images\\good.gif");
		ImageIcon inst = new ImageIcon(".\\Images\\inst.gif");
		ImageIcon earth = new ImageIcon(".\\Images\\earth.gif");
		
		Font fnt1 = new Font("Monotype Corsiva",Font.BOLD,40);
		Font fnt2 = new Font("Arial",Font.BOLD,18);
		Font fnt3 = new Font("Arial",Font.BOLD,16);
		Font fnt4 = new Font("Arial",Font.PLAIN,14);
		
		lblearth = new JLabel(earth);
		lblearth.setBounds(225,30,100,50);
		pninstr.add(lblearth);		

		instr = "Instructions";			
		lblinstr = new JLabel(inst);
		lblinstr.setBounds(280,30,200,80);
		lblinstr.setFont(fnt1);
		pninstr.add(lblinstr);
		read = "Read These Instructions Carefully,";
		lblcare = new JLabel(read);
		lblcare.setBounds(100,80,400,30);
		lblcare.setFont(fnt2);
		pninstr.add(lblcare);
		i1= "1) Each questions have 4 options. ";
		lblin1 = new JLabel(i1);
		lblin1.setBounds(150,120,400,30);
		lblin1.setFont(fnt3);
		pninstr.add(lblin1);
		i2= "2) Select one of them & click NEXT button to Continue. ";
		lblin2 = new JLabel(i2);
		lblin2.setBounds(150,150,600,30);
		lblin2.setFont(fnt3);
		pninstr.add(lblin2);	
		i3= "3) No any RETURN option to previous question. ";	
		lblin3 = new JLabel(i3);
		lblin3.setBounds(150,180,600,30);
		lblin3.setFont(fnt3);
		pninstr.add(lblin3);
		i4="4) Unselection is taken as WRONG answer. ";
		lblin4 = new JLabel(i4);
		lblin4.setBounds(150,210,400,30);
		lblin4.setFont(fnt3);
		pninstr.add(lblin4);
		i5="5) Each CORRECT answer have 1 mark. ";
		lblin5 = new JLabel(i5);
		lblin5.setBounds(150,240,400,30);
		lblin5.setFont(fnt3);
		pninstr.add(lblin5);
		i6= "6) NO negative marks. ";
		lblin6 = new JLabel(i6);
		lblin6.setBounds(150,270,400,30);
		lblin6.setFont(fnt3);
		pninstr.add(lblin6);
		i7="7) Need  50% for Passing. ";
		lblin7 = new JLabel(i7);
		lblin7.setBounds(150,300,550,30);
		lblin7.setFont(fnt3);
		pninstr.add(lblin7);
		i8="8) If you agree these instructions, select I accept & click START button. ";
		lblin8 = new JLabel(i8);
		lblin8.setBounds(150,330,600,30);
		lblin8.setFont(fnt3);
		pninstr.add(lblin8);
		
		rbin1 = new JRadioButton("I accept");
		rbin1.setBounds(270,375,100,30);
		rbin1.setBackground(Color.lightGray);
		rbin1.setFont(fnt4);
		
		rbin2 = new JRadioButton("I do not accept");
		rbin2.setBounds(370,375,200,30);
		rbin2.setBackground(Color.lightGray);
		rbin2.setFont(fnt4);
		
		
		gb1=new ButtonGroup();
		gb1.add(rbin1);
		gb1.add(rbin2);

		btstart = new JButton("START");
		btstart.setBounds(320,450,100,30);START startact = new START();
		btstart.addActionListener(startact);
		pninstr.add(btstart);

		lblgood =new JLabel(good);
		lblgood.setBounds(120,375,500,100);			
		pninstr.add(lblgood);

		pninstr.add(rbin1);
		pninstr.add(rbin2);

		fr.getContentPane().add(pninstr);
				
	}
	public void newStart() 
	{
		tempInsert();
		DBConnection();
		try
		{
			st=con.createStatement();
			rs=st.executeQuery("select * from questionset");
			while(rs.next())
			{
				String s=rs.getString(1).trim();
				if(us.compareToIgnoreCase(s)==0)
				{
					da=rs.getString(2).trim();
					nq=Integer.parseInt(rs.getString(3).trim());
					nt=Integer.parseInt(rs.getString(4).trim());
					con.close();
					break;		
				}
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(fr,"Error in Questionset");
		}
		try{pi=100/nq;}catch(Exception e){JOptionPane.showMessageDialog(fr,"Error in Division");}
		DBConnection();
		try
		{
			st=con.createStatement();			
			rs=st.executeQuery("select * from "+us);
			data();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(fr,"Error in ResultStatement");
		}

		Font fnt = new Font("Arial",Font.BOLD,14);
		Font fnt1 = new Font("Arial",Font.BOLD,16);	

		ImageIcon inst1 = new ImageIcon(".\\Images\\inst1.gif");
		ImageIcon earth = new ImageIcon(".\\Images\\earth.gif");
		ImageIcon blink = new ImageIcon(".\\Images\\blink.gif");	
			
		pninstr.setBounds(0,0,0,0);		
		pnq=new JPanel();
		pnq.setBackground(Color.lightGray);
		pnq.setBounds(0,0,750,540);
		pnq.setLayout(null);
		
		lblblink = new JLabel(blink);
		lblblink.setBounds(55,30,60,60);
		pnq.add(lblblink);
		
		txtqus = new JTextArea(c+" . "+qs);
		txtqus.setLineWrap(true);
		txtqus.setEditable(false);
		txtqus.setFont(fnt);
		txtqus.setBackground(Color.lightGray);
		txtqus.setForeground(Color.black);
		txtqus.setBounds(100,50,550,100);
		

		rb1=new JRadioButton(op1);
		rb1.setBounds(100,150,600,20);
		rb1.setBackground(Color.lightGray);
		rb2=new JRadioButton(op2);
		rb2.setBounds(100,200,600,20);
		rb2.setBackground(Color.lightGray);
		rb3=new JRadioButton(op3);
		rb3.setBounds(100,250,600,20);
		rb3.setBackground(Color.lightGray);
		rb4=new JRadioButton(op4);
		rb4.setBounds(100,300,600,20);
		rb4.setBackground(Color.lightGray);
		
		gb=new ButtonGroup();
		gb.add(rb1);
		gb.add(rb2);
		gb.add(rb3);
		gb.add(rb4);
		
		time=new JLabel();
		time.setBounds(670,20,100,20);
		time.setFont(fnt1);
		time.setForeground(Color.green);
		pnq.add(time);

		bt=new JButton("Next");
		NEXT nextact = new NEXT();
		bt.addActionListener(nextact);
		bt.setBounds(330,400,100,30);
		pnq.add(bt);
		pnq.add(txtqus);
		pnq.add(rb1);
		pnq.add(rb2);
		pnq.add(rb3);
		pnq.add(rb4);		
		
		pb=new JProgressBar();
		pb.setBounds(280,350,200,20);
		pb.setString(pb.getValue()+"%");
		pb.setStringPainted(true);
		pnq.add(pb);
		
		lblIn =new JLabel(inst1);
		lblIn.setBounds(0,427,300,80);
		lblIn.setFont(fnt1);
		lblIn.setForeground(Color.red);
		pnq.add(lblIn);

		lblearth = new JLabel(earth);
		lblearth.setBounds(10,440,50,50);
		pnq.add(lblearth);		

		msg = " "+i1+i2+i3+i4+i5+i6+i7;
		lblscroll =new JLabel();
		lblscroll.setBounds(160,450,590,30);
		lblscroll.setFont(fnt1);
		lblscroll.setForeground(Color.blue);
		pnq.add(lblscroll);

		fr.getContentPane().add(pnq);
		
		Scrollthread mt = new Scrollthread();
		t1=new Thread(mt);
		t1.start();

		Timethread tt = new Timethread();
		t=new Thread(tt);
		t.start();
	}
	public void result()
	{
		fr.dispose();
		fr=new JFrame("Result of "+us);
		pnrst=new JPanel();
		pnrst.setBackground(Color.lightGray);
		pnrst.setLayout(null);

//####################### Center Setting #####################
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		//fr.setLocation(400,400);
		fr.setLocation( ( (screenDim.width - fr.getSize().width) / 2 )-380,((screenDim.height - fr.getSize().height)/2)-270);

//####################### Icon #########################
		fr.setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Images\\my.gif"));		
		ImageIcon rst = new ImageIcon(".\\Images\\result.gif");
		ImageIcon loginIcon = new ImageIcon(".\\Images\\login.gif");
		ImageIcon exitIcon = new ImageIcon(".\\Images\\exit.gif");
		ImageIcon line = new ImageIcon(".\\Images\\line.gif");
		
		Font fnt1 = new Font("Monotype Corsiva",Font.BOLD,40);
		Font fnt2 = new Font("Arial",Font.BOLD,18);
		Font fnt3 = new Font("Arial",Font.BOLD,14);
		
		lblrs =new JLabel(rst);
		lblrs.setFont(fnt1);
		lblrs.setBounds(270,40,200,100);

		lbluser =new JLabel("Name                          = "+us);		
		lbluser.setFont(fnt2);
		lbluser.setBounds(200,130,500,30);
			
		lblmaxscore =new JLabel("Max. Score                  = "+nq+"");
		lblmaxscore.setFont(fnt2);
		lblmaxscore.setBounds(200,160,300,30);
	
		lblscore =new JLabel("Score                             = "+mark+"");
		lblscore .setFont(fnt2);
		lblscore.setBounds(200,190,300,30);
		
		perc = (100/nq)*mark;
		lblper =new JLabel("Percentage (%)              = "+perc+""+"%");
		lblper.setFont(fnt2);
		lblper.setBounds(200,220,300,30);
		
		int dd =d.getDate();
		int mm=d.getMonth();
		String y=""+d.getYear();
		String yy =y.substring(1,3);
		String date1 = ""+dd+"-"+""+mm+"-"+yy;
		int hr=d.getHours();
		int min=d.getMinutes();
		int sec=d.getSeconds();
		String time1=""+hr+":"+""+min+":"+""+sec;
		date_time=date1+"/"+time1;

		lbldt =new JLabel("Date/Time                        = "+date_time); 
		lbldt.setFont(fnt2);
		lbldt.setBounds(200,250,500,30);
		
		if(perc >=50)
		st1="Passed";
		else
		st1="Failed";
		lblstatus =new JLabel("Status                                 = "+st1);
		lblstatus.setFont(fnt2);
		lblstatus.setBounds(200,280,300,30);
		
		LOG_EXIT leact = new LOG_EXIT();
		btlog = new JButton("Login",loginIcon);
		btlog.setBounds(200,350,100,30);
		btlog.setFont(fnt3);
		btlog.addActionListener(leact);
		btexit = new JButton("Exit",exitIcon);
		btexit.setBounds(400,350,100,30);
		btexit.setFont(fnt3);
		btexit.addActionListener(leact);

		lblline = new JLabel(line);
		lblline.setBounds(250,400,210,50);
		
		
		pnrst.add(lblrs);
		pnrst.add(lbluser);
		pnrst.add(lblmaxscore);
		pnrst.add(lblscore);
		pnrst.add(lblper);
		pnrst.add(lbldt);
		pnrst.add(lblstatus);
		pnrst.add(btlog);
		pnrst.add(btexit);
		pnrst.add(lblline);
		
		fr.getContentPane().add(pnrst);

		fr.setSize(750,540);
		fr.setVisible(true);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);	
		
		entryResult();		
	}
//###################Methods####################
	public void DBConnection()
	{		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			con=DriverManager.getConnection("jdbc:odbc:datasource","sa","");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(fr,"Error in Connection ");
		}
	}
	
	public void data()
	{
		try
		{
			rs.next();
			qs=rs.getString(1);
			op1=rs.getString(2);
			op2=rs.getString(3);
			op3=rs.getString(4);
			op4=rs.getString(5);
			ans=rs.getString(6);	
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(fr,"Error in Statement");
		}
	}
	public void entryResult()
	{
		try{con.close();}catch(Exception e){}
		DBConnection();
		try
		{
			ps=con.prepareStatement("insert into resultset (name_user,maxscore,score,percentage,da_ti,status) values(?,?,?,?,?,?)");
			ps.setString(1,us);
			ps.setString(2,nq+"".trim());
			ps.setString(3,mark+"".trim());
			ps.setString(4,perc+""+"%".trim());
			ps.setString(5,date_time.trim());
			ps.setString(6,st1.trim());
			ps.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(fr,"Error in EntryResult");}
	}
	public void tempInsert()
	{
		DBConnection();
		String st2 = "Not Completed";
		try
		{
			ps=con.prepareStatement("insert into resultset (name_user,status) values(?,?)");
			ps.setString(1,us.trim());
			ps.setString(2,st2.trim());
			ps.executeUpdate();
			con.close();
		}
		catch(Exception e){JOptionPane.showMessageDialog(fr,"Error in tempInsert");}
	}
	public void tempDelete()
	{
		DBConnection();
		try
		{
			ps=con.prepareStatement("delete from resultset where name_user= ? ");
			ps.setString(1,us);
			ps.executeUpdate();
		}
		catch(Exception e){JOptionPane.showMessageDialog(fr,"Error in tempDelete");}
	}

//############## Thread Classes ##################
	public class Timethread implements Runnable
	{
		public void run()
		{
			m=nt-1;
			for(;;)
			{	
				s--;
				time.setText(m+" : "+s);
				try
				{
					t.sleep(1000);
				}
				catch(Exception e)	
				{}
				if(m==0)
				time.setForeground(Color.red);
				if(m==0&&s==0)
				{
					bt.setEnabled(false);
					JOptionPane.showMessageDialog(fr,"        Time Out");
					try
					{
						tempDelete();
						result();						
						t.stop();
						t1.stop();
					}
					catch(Exception e)	
					{}
					
					
				}
				if(s==0)
				{
					s=60;
					m--;
				}
			}
		}
	}
	public class Scrollthread implements Runnable
	{
		public void run()
		{
			for(;;)
			{	
				lblscroll.setText(msg);
	 		 	try
		  		{	
					t1.sleep(500);
					char  c=msg.charAt(0);
					msg=msg.substring(1,msg.length());
					msg=msg+c;
				}
				 catch(InterruptedException ie)
	 			{ }
			}
		}
	}
//####################Listener###################
	
	public class OK implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==btok)
			{
				instructions();
			}
		}
	}
	public class START implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{	
			if(ae.getSource()==btstart)
			{
				ns="";
				if(rbin1.isSelected())
				ns="yes";
				if(rbin2.isSelected())
				ns="no";
				if(ns.compareTo("yes")==0)
				{
					if(JOptionPane.showConfirmDialog(fr,"Topic : "+da+"\n"+"No.of Questions : "+nq+""+"\n"+"Time : "+nt+""+" min.","Confirmation for eQuiz",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
					{
						if(JOptionPane.showConfirmDialog(fr,"Are You Ready ?","eQuiz",JOptionPane.OK_OPTION)==JOptionPane.OK_OPTION)
						{
							JOptionPane.showMessageDialog(fr,"         ***GOOD LUCK***");
							newStart();
						}
					}
				}
				if(ns.compareTo("no")==0)
				{JOptionPane.showMessageDialog(fr,"Do not Continue...");}
			}
				
		}
	}
	public class NEXT implements ActionListener 
	{
		public void actionPerformed(ActionEvent ae)
		{	
			selans="";
			if(rb1.isSelected())
			selans=op1;
			if(rb2.isSelected())
			selans=op2;
			if(rb3.isSelected())
			selans=op3;
			if(rb4.isSelected())
			selans=op4;
			if(selans.compareTo(ans)==0)
			{	
				mark=mark+1;
				int va=pb.getValue();
				pb.setValue(va+pi);
				pb.setString(pb.getValue()+"%");
				pb.setStringPainted(true);
			}
			else
			{
				
			}
			//gb.clearSelection();
			c++;
			if(c<=nq)
			{
				data();
				txtqus.setText(c+" . "+qs);			
				rb1.setText(op1);
				rb2.setText(op2);
				rb3.setText(op3);
				rb4.setText(op4);
			}
			else
			{
				bt.setEnabled(false);
				try
				{
					t.stop();
					t1.stop();
				}
				catch(Exception e)	
				{}
				JOptionPane.showMessageDialog(fr,"           Finished");
				tempDelete();
				result();
			}
	    
		}
	}
	public class LOG_EXIT implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==btlog)
			{
				if(JOptionPane.showConfirmDialog(fr,"Do you want to Login","eQuiz",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				{
					new Quiz();
					fr.dispose();
				}
			}
			if(ae.getSource()==btexit)
			{
				if(JOptionPane.showConfirmDialog(fr,"Do you want to Exit?","eQuiz",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				{System.exit(0);}
			}
		}
	}	
}