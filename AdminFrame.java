import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.sql.*;
import java.util.Date;

public class AdminFrame 
{
	int i=0,co,temp=0;
	String s1,s2,s3,s4,timetxt;	
	JFrame fr;
	JPanel pn,pnGeneral,pnUser,pnQuestion,pnTime,pnResult;
	JButton btCreUserApply,btDelUserApply,btApplyAll,btDeletelist,bt,btDeletelist1;
	JLabel lblCreUser,lblUserName,lblDelUser,lblDelName;
	JLabel lblDellistName,blDeletelist1,lblDellistName1;
	JLabel lblImage,lbleQuiz,lbltest,lblpow;
	JTextField txtCreUser,txtDelUser,txtDellistUser,txtDellistUser1;
	JMenuBar menuBar;
	JMenu logMenu,settingsMenu,helpMenu;
	JMenuItem logItem1,logItem2,logItem3;
	JMenuItem settingsItem0,settingsItem1,settingsItem2,settingsItem4;
	JMenuItem helpItem1;
	JTabbedPane tb;
	JList li;
	JTable tU,tQ,tR;
	JScrollPane userjsp;
	JComboBox cb1,cb3,cb4,cb5;
	JRadioButton rbsub1,rbsub2,rbsub3,rbqn1,rbqn2,rbqn3;
	Connection con;
	ResultSet rs;
	Statement st;
	PreparedStatement ps;
			
	AdminFrame()
	{
		fr=new JFrame("eQuiz Master Settings");
		pn=new JPanel();
		pn.setBackground(Color.lightGray);
		pn.setLayout(null);
		fr.getContentPane().add(pn);

//#####################Database Connection ##################
		DBConnection();

//####################### Font Type ######################
		Font fnt = new Font("Monotype Corsiva",Font.BOLD,20);
		Font ft = new Font("Arial",Font.BOLD,14);
		Font fnt1 = new Font("Monotype Corsiva",Font.PLAIN,14);
		Font fnt2 = new Font("Monotype Corsiva",Font.PLAIN,20);
	
//####################### Center Setting #####################
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		fr.setLocation( ( (screenDim.width - fr.getSize().width) / 2 )-380,((screenDim.height - fr.getSize().height)/2)-270);

//####################### Icon #########################
		fr.setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Images\\my.gif"));
		ImageIcon he = new ImageIcon(".\\Images\\my.gif");
		ImageIcon loginIcon = new ImageIcon(".\\Images\\login.gif");
		ImageIcon exitIcon = new ImageIcon(".\\Images\\exit.gif");
		ImageIcon helpIcon = new ImageIcon(".\\Images\\help.gif");
		ImageIcon icon = new ImageIcon(".\\Images\\my11.gif");
		ImageIcon icon1 = new ImageIcon(".\\Images\\user1.gif");
		ImageIcon icon2 = new ImageIcon(".\\Images\\user2.gif");
		ImageIcon generalIcon = new ImageIcon(".\\Images\\1.gif");
		ImageIcon userIcon = new ImageIcon(".\\Images\\2.gif");
		ImageIcon qusIcon = new ImageIcon(".\\Images\\3.gif");
		ImageIcon resultIcon = new ImageIcon(".\\Images\\4.gif");
		ImageIcon removeIcon = new ImageIcon(".\\Images\\cut.gif");
		ImageIcon wel = new ImageIcon(".\\Images\\new.gif");
		ImageIcon eQ = new ImageIcon(".\\Images\\eQuiz.gif");
		ImageIcon pow = new ImageIcon(".\\Images\\pow.gif");
		
//##################### ActionListener ##################
		Action Act =new Action();

//##################### KeyListener #####################		
		InsertUserKeyList IUKL = new InsertUserKeyList();
		DeleteUserKeyList DUKL = new DeleteUserKeyList();
		RemoveKeyList RKL = new RemoveKeyList();
		RemoveKeyList1 RKL1 =new RemoveKeyList1();
		
	
//####################### MenuBar #########################
		menuBar = new JMenuBar();//menuBar.setBackground(Color.lightGray);
        		fr.setJMenuBar(menuBar);

        		logMenu = new JMenu("Login");
		logMenu.setMnemonic('L');
		menuBar.add(logMenu);
			logMenu.add(logItem1 = new JMenuItem("Login ...",loginIcon));
				logItem1.setBackground(Color.lightGray);
				logItem1.setAccelerator(KeyStroke.getKeyStroke("control O"));
				logItem1.setMnemonic('o');
				logItem1.addActionListener(Act);
			logMenu.addSeparator();

			logMenu.add(logItem3 = new JMenuItem("Exit ...",exitIcon));
				logItem3.setBackground(Color.lightGray);
				logItem3.setAccelerator(KeyStroke.getKeyStroke("control X"));
				logItem3.setMnemonic('x');
				logItem3.addActionListener(Act);

        		settingsMenu = new JMenu("Settings");
		settingsMenu.setMnemonic('S');
		menuBar.add(settingsMenu);
			settingsMenu.add(settingsItem0 = new JMenuItem("General ...",generalIcon));
				settingsItem0.setBackground(Color.lightGray);
				settingsItem0.setAccelerator(KeyStroke.getKeyStroke("control G"));
				settingsItem0.setMnemonic('G');
				settingsItem0.addActionListener(Act);
			settingsMenu.add(settingsItem1 = new JMenuItem("User Settings ...",userIcon));
				settingsItem1.setBackground(Color.lightGray);
				settingsItem1.setAccelerator(KeyStroke.getKeyStroke("control U"));
				settingsItem1.setMnemonic('U');
				settingsItem1.addActionListener(Act);
			settingsMenu.add(settingsItem2 = new JMenuItem("Question Settings ...",qusIcon));
				settingsItem2.setBackground(Color.lightGray);
				settingsItem2.setAccelerator(KeyStroke.getKeyStroke("control Q"));
				settingsItem2.setMnemonic('Q');
				settingsItem2.addActionListener(Act);
			
			settingsMenu.add(settingsItem4 = new JMenuItem("Result Settings ...",resultIcon));
				settingsItem4.setBackground(Color.lightGray);
				settingsItem4.setAccelerator(KeyStroke.getKeyStroke("control R"));
				settingsItem4.setMnemonic('R');
				settingsItem4.addActionListener(Act);

		helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		menuBar.add(helpMenu);
			helpMenu.add(helpItem1 = new JMenuItem("About ...",helpIcon));helpItem1.setBackground(Color.lightGray);
			helpItem1.setAccelerator(KeyStroke.getKeyStroke("control A"));
			helpItem1.setMnemonic('A');
			helpItem1.addActionListener(Act);

//######################## Tabbed Pane #####################
//Srolll Bar
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
//General 		
		pnGeneral=new JPanel();
			pnGeneral.setBackground(Color.black);
			pnGeneral.setLayout(null);
			lblImage = new JLabel(wel);
			lblImage.setBounds(220,0,300,400);
			pnGeneral.add(lblImage);

			lbleQuiz=new JLabel(eQ);
			lbleQuiz.setBounds(270,265,200,80);			
			pnGeneral.add(lbleQuiz);
			
			lbltest = new JLabel("Testing Yourself");
			lbltest.setBounds(360,285,200,80);
			lbltest.setForeground(Color.lightGray);
			lbltest.setFont(fnt2);
			pnGeneral.add(lbltest);

			lblpow =new JLabel(pow);
			lblpow.setBounds(340,370,500,100);			
			pnGeneral.add(lblpow);
			
			
//User Settings Table
		pnUser=new JPanel();
					//Font fnt = new Font("Verdana",Font.BOLD,14);
					/*t=new JTable(11,4);
					//t.setFont(fnt);
					t.setValueAt("Sl. No.",0,0);
					t.setValueAt("User",0,1);
					t.setValueAt("Code",0,2);
					t.setValueAt("Date/Time",0,3);
					pnUser.setLayout(null);
					t.setBounds(10,10,558,200);*/
			
			pnUser.setBackground(Color.gray);
			pnUser.setLayout(null);	
			final String[] userHeads = {"Sl. No.","User","Code","Date/Time"};
			final Object[] [] userdata = {{"","","",""},{"","","",""}, {"","","",""}, {"","","",""}, {"","","",""},{"","","",""},
						  {"","","",""}, {"","","",""}, {"","","",""},{"","","",""}, {"","","",""},{"","","",""},
						  {"","","",""},{"","","",""},{"","","",""}, {"","","",""},{"","","",""},{"","","",""},
						   {"","","",""},{"","","",""},{"","","",""}, {"","","",""},{"","","",""},{"","","",""},
						    {"","","",""},{"","","",""},{"","","",""}, {"","","",""},{"","","",""},{"","","",""}};
			tU=new JTable(userdata,userHeads);  
						
				tU.setSelectionBackground(Color.lightGray);
				tU.setFont(ft);
						//int m=tU.getSelectedRow();JOptionPane.showMessageDialog(fr,new Integer(m));
						//tU.addActionListener(Act);
						//tU.setGridColor(Color.white);
						//tU.setForeground(Color.black);
						//tU.setBackground(Color.gray);
			userjsp = new JScrollPane(tU,v,h);
			userjsp.setBounds(10,10,710,220);
			pnUser.add(userjsp);

//Question Seitting Table
		pnQuestion=new JPanel();
			pnQuestion.setBackground(Color.gray);
			pnQuestion.setLayout(null);
			final String[] questionHeads = {"Sl. No.","User","Topic","No.of Questions","Time (Min.)"};
			final Object[] [] questiondata = {{"","","","",""},{"","","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
						  {"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}, {"","","","",""},{"","","","",""},
						  {"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}, {"","","","",""},{"","","","",""},
						  {"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}, {"","","","",""},{"","","","",""},
						  {"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}, {"","","","",""},{"","","","",""},
						  {"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}, {"","","","",""},{"","","","",""},
						  {"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}, {"","","","",""},{"","","","",""},
						  {"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}};
			tQ=new JTable(questiondata,questionHeads);
			tQ.setSelectionBackground(Color.lightGray);
			tQ.setFont(ft);
			JScrollPane questionjsp = new JScrollPane(tQ,v,h);
			questionjsp.setBounds(10,10,710,220);
			pnQuestion.add(questionjsp);
			
			
//Result Setting Table
		pnResult = new JPanel();
			pnResult.setBackground(Color.gray);
			pnResult.setLayout(null);
			final String[] resultHeads = {"Sl. No.","User", "Max. Score","Score","%",
						      "Date/Time",
						      "Status"};
			final Object[] [] resultdata = {{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
						      {"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
						      {"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
						      {"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
						      {"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
						      {"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
						      {"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
						      {"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
						      {"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
						      {"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},
						      {"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""}};
			tR=new JTable(resultdata,resultHeads);
			tR.setSelectionBackground(Color.lightGray);
			tR.setFont(ft);
			JScrollPane resultjsp = new JScrollPane(tR,v,h);
			resultjsp.setBounds(10,10,710,220);
			pnResult.add(resultjsp);

//User Setting "Creation"  		

		lblCreUser=new JLabel(" Create User ");
			lblCreUser.setForeground(Color.white);
			lblCreUser.setFont(fnt);
			lblCreUser.setToolTipText("Type USER name");
		lblUserName=new JLabel("User Name");
		
		txtCreUser=new JTextField(15);
			txtCreUser.setCaretColor(Color.green);
			txtCreUser.setFont(ft);
			
			txtCreUser.addKeyListener(IUKL);
		btCreUserApply=new JButton("Create",icon1);
			btCreUserApply.addActionListener(Act);
			btCreUserApply.setFont(ft);
			btCreUserApply.setToolTipText("Create User");
		lblCreUser.setBounds(140,240,250,80);
		lblUserName.setBounds(50,270,140,100);
		txtCreUser.setBounds(120,310,150,20);
		btCreUserApply.setBounds(130,360,130,25);
		pnUser.add(lblCreUser);
		pnUser.add(lblUserName);
		pnUser.add(txtCreUser);
		pnUser.add(btCreUserApply);

//User Setting "Deletion"
		lblDelUser=new JLabel(" Delete User ");
			lblDelUser.setForeground(Color.white);
			lblDelUser.setFont(fnt);
			lblDelUser.setToolTipText("Type Valid USER name");
		lblDelName=new JLabel("User Name");
		txtDelUser=new JTextField();
			txtDelUser.setCaretColor(Color.red);
			txtDelUser.setFont(ft);
			txtDelUser.addKeyListener(DUKL);
		btDelUserApply=new JButton("Delete",icon2);
			btDelUserApply.addActionListener(Act);
			btDelUserApply.setFont(ft);
			btDelUserApply.setToolTipText("Delete User");
		lblDelUser.setBounds(530,240,250,80);
		lblDelName.setBounds(440,270,140,100);
		txtDelUser.setBounds(510,310,150,20);
		btDelUserApply.setBounds(525,360,120,25);
		pnUser.add(lblDelUser);
		pnUser.add(lblDelName);
		pnUser.add(txtDelUser);
		pnUser.add(btDelUserApply);

//Question Setting "Combobox"		
		String arr[] = {};
		cb1=new JComboBox(arr);
		cb1.addActionListener(Act);
		cb1.setBounds(20,280,130,20);
		pnQuestion.add(cb1);

		String arr1[] = {"<SelectTopic>",
				 "GeneralIT           ",
				 "Aptitude            ",				
				 "Java                "};
		cb3=new JComboBox(arr1);
		cb3.addActionListener(Act);
		cb3.setBounds(170,280,130,20);
		pnQuestion.add(cb3);

		String arr2[] = {"<SelectQuestion>","10 ","20 "};
		cb4=new JComboBox(arr2);
		cb4.addActionListener(Act);
		cb4.setBounds(320,280,130,20);
		pnQuestion.add(cb4);

		String arr3[] = {"<SelectTime>","5 ","10","20","25","50"};
		cb5=new JComboBox(arr3);
		cb5.addActionListener(Act);
		cb5.setBounds(470,280,130,20);
		pnQuestion.add(cb5);
		
//Question Setting "Apply All Button"
		btApplyAll=new JButton("Add",icon);
			btApplyAll.setFont(ft);
			btApplyAll.setToolTipText("Add to List");
			btApplyAll.addActionListener(Act);
			btApplyAll.setBounds(610,270,110,35);
		pnQuestion.add(btApplyAll);

//Question Settings "Delete List"

	
		lblDellistName=new JLabel("User Name");
			lblDellistName.setBounds(390,345,90,35);
		pnQuestion.add(lblDellistName);

		txtDellistUser=new JTextField();
			txtDellistUser.setCaretColor(Color.red);
			txtDellistUser.setFont(ft);
			txtDellistUser.setToolTipText("Type Valid USER name");
			txtDellistUser.addKeyListener(RKL);
			txtDellistUser.setBounds(470,350,121,20);
		pnQuestion.add(txtDellistUser);
		
		btDeletelist=new JButton("Remove",removeIcon);
			btDeletelist.setFont(ft);
			btDeletelist.setToolTipText("Remove from List");
			btDeletelist.addActionListener(Act);
			btDeletelist.setBounds(600,345,120,35);
		pnQuestion.add(btDeletelist);

//Result Settings "Delete List"
		lblDellistName1=new JLabel("User Name");
			lblDellistName1.setBounds(390,345,90,35);
		pnResult.add(lblDellistName1);

		txtDellistUser1=new JTextField();
			txtDellistUser1.setCaretColor(Color.red);
			txtDellistUser1.setFont(ft);
			txtDellistUser1.setToolTipText("Type Valid USER name");
			txtDellistUser1.addKeyListener(RKL1);
			txtDellistUser1.setBounds(470,350,121,20);
		pnResult.add(txtDellistUser1);
		
		btDeletelist1=new JButton("Remove",removeIcon);
			btDeletelist1.setFont(ft);
			btDeletelist1.setToolTipText("Remove from List");
			btDeletelist1.addActionListener(Act);
			btDeletelist1.setBounds(600,345,120,35);
		pnResult.add(btDeletelist1);


//Tabbed Pane Add
 		tb = new JTabbedPane();
		tb.setBackground(Color.gray);
        		tb.addTab("General",generalIcon,pnGeneral,"General Information");
			tb.addTab("User Settings",userIcon,pnUser,"User Settings");
			tb.addTab("Question Settings",qusIcon,pnQuestion,"Question Settings");
			tb.addTab("Result Settings",resultIcon,pnResult,"Result Settings");
		tb.setBounds(7,5,730,472);
		pn.add(tb);
		
//Frame Setting
		displayUser();displayQues();displayResult();
		String str1="<SelectUser>";
		userAddToCombobox(i,str1);
		fr.setSize(750,540);
		fr.setVisible(true);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
	}

//####################	Methods ####################
	public void DBConnection()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			con=DriverManager.getConnection("jdbc:odbc:datasource","sa","");
		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(fr,"Error in Connection 1");}
	}
	public void displayUser()
	{
		try
		{
			st=con.createStatement();
			rs=st.executeQuery("select * from userset");
			co=0;
			while(rs.next())
			{
				co++;
				tU.setValueAt(new Integer(co),(co-1),0);
				tU.setValueAt(rs.getString(1),(co-1),1);
				tU.setValueAt(rs.getString(2),(co-1),2);
				tU.setValueAt(rs.getString(3),(co-1),3);
			}
		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(fr,"User Settings \nError in Connection");}
	}

//Add User to Combobox
	public void userAddToCombobox(int i,String str1)
	{
		if(i==0)
		{	
			cb1.addItem(str1);				
			try
			{
				st=con.createStatement();
				rs=st.executeQuery("select * from userset");
				int co=0;
				while(rs.next())
				{
					String val1=rs.getString(1);
					cb1.addItem(val1);					
				}
			}
			catch(Exception e)
			{JOptionPane.showMessageDialog(fr,"The Process userAddToCombobox is not done");}
		}
		else
		{
			cb1.addItem(str1);
		}
	}

//Remove User From Combobox
	public void userRemoveFromCombobox(String str2)
	{
		cb1.removeAllItems();
		i=0;String str1="<Select>";
		userAddToCombobox(i,str1);					
	}

//Insert User
	public void insertUser()
	{
		try
		{
			ps=con.prepareStatement("insert into userset (name_user) values(?)");
			String st=txtCreUser.getText();
			ps.setString(1,st);
			if(!(st.compareTo("")==0))
			{
				ps.executeUpdate();
				con.close();
				JOptionPane.showMessageDialog(fr,"User " + "'" + st + "'" + " Created...");
				userAddToCombobox(++i,st);
				DBConnection();
				displayUser();
			}
			else
			{JOptionPane.showMessageDialog(fr,"Enter Correct User Name");}
			txtCreUser.setText("");
		}
		catch(SQLException e)
		{
			String st=txtCreUser.getText();
			JOptionPane.showMessageDialog(fr,"User " + "'" + st + "'" + " Already Exist..."+"\n"+"Try with another Name");	
		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(fr,"Error in Creation");}
	}
	public void deleteUser()
	{
		try
		{	
			String s=txtDelUser.getText();
			String sp;
			st=con.createStatement();
			rs=st.executeQuery("select * from questionset");
			int no=0;
			while(rs.next())
			{	
				sp=rs.getString(1).trim();
				if(s.compareTo(sp)==0)
				{no++;}
			}
			con.close();			
			DBConnection();
			
			String sp1;
			st=con.createStatement();
			rs=st.executeQuery("select * from resultset");
			int no1=0;
			while(rs.next())
			{	
				sp1=rs.getString(1).trim();
				if(s.compareTo(sp1)==0)
				{no1++;}
			}
			con.close();			
			DBConnection();

			if(no==0 && no1==0)
			{	
				ps=con.prepareStatement("delete from userset where name_user= ? ");
				if(!(s.compareTo("")==0))
				{
					if(JOptionPane.showConfirmDialog(fr,"Do you want to Delete ?","Delete User",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
					{
						ps.setString(1,s);
						ps.executeUpdate();
						userRemoveFromCombobox(s);
						con.close();
						DBConnection();
						displayUser();
						String su="";
						tU.setValueAt(su,co,0);
						tU.setValueAt(su,co,1);
						tU.setValueAt(su,co,2);
						tU.setValueAt(su,co,3);
					}
				}
				else
				{JOptionPane.showMessageDialog(fr,"Enter Correct User Name");}
				txtDelUser.setText("");
			}
			else
			{JOptionPane.showMessageDialog(fr,s+ " is already in another list"+"\n"+"Delete Process is not Possible");}
		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(fr,"Error in Deletion");}
		txtDelUser.setText("");
	}
	
	public void insertQues()
	{
		try{con.close();}catch(Exception e){}
		DBConnection();
		s1=(String)cb1.getSelectedItem();
		s2=(String)cb3.getSelectedItem();
		s3=(String)cb4.getSelectedItem();
		s4=(String)cb5.getSelectedItem();
		try
		{				
			if((s1.compareTo("<SelectUser>")==0) || (s2.compareTo("<SelectTopic>")==0) || (s3.compareTo("<SelectQuestion>")==0) || (s4.compareTo("<SelectTime>")==0))
			{JOptionPane.showMessageDialog(fr,"Select All Fields");}
			else
			{	
				int no=0,c=0;
				st=con.createStatement();
				rs=st.executeQuery("select * from questionset");
				while(rs.next())
				{
					if(s1.compareTo(rs.getString(1).trim())==0)
					{no++;}				
				}			
				if(no==0)
				{
					ps=con.prepareStatement("insert into questionset (name_user,topic,noques,time1) values(?,?,?,?)");
					if(JOptionPane.showConfirmDialog(fr,"User : "+s1+"\n"+"Topic : "+s2+"\n"+"No.of Questions : "+s3+"\n"+"Time : "+s4+" min.","Insert data",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
					{
						ps.setString(1,s1);
						ps.setString(2,s2);
						ps.setString(3,s3);
						ps.setString(4,s4);
						ps.executeUpdate();
						con.close();
						DBConnection();
						displayQues();
						shedule();
					}
				}
				else
				{JOptionPane.showMessageDialog(fr,"This User Already in the list"+"\n"+"Try with another User");}	
			}
		}			
		catch(Exception e)
		{JOptionPane.showMessageDialog(fr,"Error in Creation");}
		cb1.setSelectedIndex(0);
		cb3.setSelectedIndex(0);
		cb4.setSelectedIndex(0);
		cb5.setSelectedIndex(0);
	}	
	public void displayQues()
	{
		try
		{
			st=con.createStatement();
			rs=st.executeQuery("select * from questionset");
			co=0;
			while(rs.next())
			{
				co++;
				tQ.setValueAt(new Integer(co),(co-1),0);
				tQ.setValueAt(rs.getString(1),(co-1),1);
				tQ.setValueAt(rs.getString(2),(co-1),2);
				tQ.setValueAt(rs.getString(3),(co-1),3);
				tQ.setValueAt(rs.getString(4),(co-1),4);
			}
		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(fr,"Question Settings \nError in Connection");}
	}
	public void removelist()
	{
		try{con.close();}
		catch(Exception e){}
		DBConnection();
		try
		{
			ps=con.prepareStatement("delete from questionset where name_user= ? ");
			String s=txtDellistUser.getText();
			if(!(s.compareTo("")==0))
			{
				if(JOptionPane.showConfirmDialog(fr,"Do you want to Delete ?","Delete User",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				{
					ps.setString(1,s);
					ps.executeUpdate();
					con.close();
					DBConnection();
					displayQues();
					String su="";
					tQ.setValueAt(su,co,0);
					tQ.setValueAt(su,co,1);
					tQ.setValueAt(su,co,2);
					tQ.setValueAt(su,co,3);
					tQ.setValueAt(su,co,4);
			//Drop A particular User Table
					try{con.close();}
					catch(Exception e){}
					DBConnection();
					st=con.createStatement();
					String sta="drop table "+ s.trim();
					st.execute(sta);
				}
			}
			else
			{JOptionPane.showMessageDialog(fr,"Try with Correct User Name");}
			txtDellistUser.setText("");
		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(fr,"Error in Deletion");}
	}
	public void displayResult()
	{
		try
		{
			st=con.createStatement();
			rs=st.executeQuery("select * from resultset");
			co=0;
			while(rs.next())
			{
				co++;
				tR.setValueAt(new Integer(co),(co-1),0);
				tR.setValueAt(rs.getString(1),(co-1),1);
				tR.setValueAt(rs.getString(2),(co-1),2);
				tR.setValueAt(rs.getString(3),(co-1),3);
				tR.setValueAt(rs.getString(4),(co-1),4);
				tR.setValueAt(rs.getString(5),(co-1),5);
				tR.setValueAt(rs.getString(6),(co-1),6);
			}
		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(fr,"Result Settings \nError in Connection");}
	}
	public void removelist1()
	{
		try{con.close();}
		catch(Exception e){}
		DBConnection();
		try
		{
			ps=con.prepareStatement("delete from resultset where name_user= ? ");
			String s=txtDellistUser1.getText();
			if(!(s.compareTo("")==0))
			{
				if(JOptionPane.showConfirmDialog(fr,"Do you want to Delete ?","Delete Result",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				{
					ps.setString(1,s);
					ps.executeUpdate();
					con.close();
					DBConnection();
					displayResult();
					String su="";
					tR.setValueAt(su,co,0);
					tR.setValueAt(su,co,1);
					tR.setValueAt(su,co,2);
					tR.setValueAt(su,co,3);
					tR.setValueAt(su,co,4);
					tR.setValueAt(su,co,5);
					tR.setValueAt(su,co,6);
				}
			}
			else
			{JOptionPane.showMessageDialog(fr,"Try with Correct User Name");}
			txtDellistUser1.setText("");
		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(fr,"Error in Deletion");}
	}
//################Shedule Exam################
	public void shedule()
	{
		Date d=new Date();
		int sec =d.getSeconds();
		temp = sec%10;
		try
		{
			st=con.createStatement();
			String sta;
			switch (temp)
			{
			 	case 0:
					sta="select top "+Integer.parseInt(((String)cb4.getSelectedItem()).trim())+" * into "+((String)cb1.getSelectedItem()).trim()+" from "+((String)cb3.getSelectedItem()).trim()+" order by ansA";
					break;
				case 1:
					sta="select top "+Integer.parseInt(((String)cb4.getSelectedItem()).trim())+" * into "+((String)cb1.getSelectedItem()).trim()+" from "+((String)cb3.getSelectedItem()).trim()+" order by ansA desc";
					break;
				case 2:
					 sta="select top "+Integer.parseInt(((String)cb4.getSelectedItem()).trim())+" * into "+((String)cb1.getSelectedItem()).trim()+" from "+((String)cb3.getSelectedItem()).trim()+" order by ansB";
					break;
				case 3:
					sta="select top "+Integer.parseInt(((String)cb4.getSelectedItem()).trim())+" * into "+((String)cb1.getSelectedItem()).trim()+" from "+((String)cb3.getSelectedItem()).trim()+" order by ansB desc";
					break;
				case 4:
					sta="select top "+Integer.parseInt(((String)cb4.getSelectedItem()).trim())+" * into "+((String)cb1.getSelectedItem()).trim()+" from "+((String)cb3.getSelectedItem()).trim()+" order by ansC";
					break;
				case 5:
					sta="select top "+Integer.parseInt(((String)cb4.getSelectedItem()).trim())+" * into "+((String)cb1.getSelectedItem()).trim()+" from "+((String)cb3.getSelectedItem()).trim()+" order by ansC desc";
					break;	
				case 6:
					sta="select top "+Integer.parseInt(((String)cb4.getSelectedItem()).trim())+" * into "+((String)cb1.getSelectedItem()).trim()+" from "+((String)cb3.getSelectedItem()).trim()+" order by ansD";
					break;
				case 7:
					sta="select top "+Integer.parseInt(((String)cb4.getSelectedItem()).trim())+" * into "+((String)cb1.getSelectedItem()).trim()+" from "+((String)cb3.getSelectedItem()).trim()+" order by ansD desc";
					break;
				default :
					sta="select top "+Integer.parseInt(((String)cb4.getSelectedItem()).trim())+" * into "+((String)cb1.getSelectedItem()).trim()+" from "+((String)cb3.getSelectedItem()).trim();
					break;
			}
		
			st.execute(sta);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(fr,"Error");
		}
		
	}

	
//#################### Listeners #####################
	class Action implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			//LOGIN MENU
			if(ae.getSource()==logItem1)
			{
				if(JOptionPane.showConfirmDialog(fr,"Do you want to Login","Administrator Settings",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				{
					//new Quiz();
					fr.dispose();
				}
			}
			if(ae.getSource()==logItem3)
			{
				if(JOptionPane.showConfirmDialog(fr,"Do you want to Exit?","Administrator Settings",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			
			}

			//SETTINGS MENU
			if(ae.getSource()==settingsItem0)			
			{
				tb.setSelectedIndex(0);
			}
			if(ae.getSource()==settingsItem1)			
			{
				tb.setSelectedIndex(1);
			}
			if(ae.getSource()==settingsItem2)			
			{
				tb.setSelectedIndex(2);
			}
			if(ae.getSource()==settingsItem4)			
			{
				tb.setSelectedIndex(3);
			}

			//HELP MENU		
			if(ae.getSource()==helpItem1)
			{
				JOptionPane.showMessageDialog(fr,"Powered by Sun MicroSystems"+"\n"+"                 Vineeth"+"\n"+"Email: hellsloose@gmail.com","About",JOptionPane.OK_OPTION);
			}

			//CREATE USER
			if(ae.getSource()==btCreUserApply)
			{
				insertUser();
			}

             	 		//DELETE USER
			if(ae.getSource()==btDelUserApply)
			{
				deleteUser();
			}

			//Qus ADD Button
			if(ae.getSource()==btApplyAll)
			{
				insertQues();
			}

			//Qus REMOVE Button
			if(ae.getSource()==btDeletelist)
			{
				removelist();
			}
			
			//Result REMOVE Button
			if(ae.getSource()==btDeletelist1)
			{
				removelist1();
			}								
		}
	}
	
	class InsertUserKeyList implements KeyListener
	{ 
		public void keyTyped(KeyEvent ke)
		{
			if(ke.getKeyChar()==10)
			{
				insertUser();
			}
		}
		public void keyPressed(KeyEvent ke)
		{

		}
		public void keyReleased(KeyEvent ke)
		{
	
		}
	}
	class DeleteUserKeyList implements KeyListener
	{
		public void keyTyped(KeyEvent ke)
		{
			if(ke.getKeyChar()==10)
			{
				deleteUser();
			}
		}
		public void keyPressed(KeyEvent ke)
		{
	
		}
		public void keyReleased(KeyEvent ke)
		{

		}
	}
	class RemoveKeyList implements KeyListener
	{
		public void keyTyped(KeyEvent ke)
		{
			if(ke.getKeyChar()==10)
			{
				removelist();
			}
		}
		public void keyPressed(KeyEvent ke)
		{

		}
		public void keyReleased(KeyEvent ke)
		{

		}
	}
	class RemoveKeyList1 implements KeyListener
	{
		public void keyTyped(KeyEvent ke)
		{
			if(ke.getKeyChar()==10)
			{
				removelist1();
			}
		}
		public void keyPressed(KeyEvent ke)
		{

		}
		public void keyReleased(KeyEvent ke)
		{

		}
	}
//###################### Main ######################
	public static void main(String args[]) throws Exception
	{
		AdminFrame af=new AdminFrame();
	}
}