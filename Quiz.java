import javax.swing.*;
import java.awt.event.*;
import java.awt.*;	
import java.awt.Color;
import java.sql.*;
public class Quiz 
{
	String s,s1;	
	JFrame fr;
	JPanel pn;
	JLabel lblSign,lblName,lblPass;
	JComboBox cb;
	JPasswordField txtPass;
	JButton btOk,btCancel;
	Connection con;
	ResultSet rs;
	Statement st;
	PreparedStatement ps;	
	Quiz()
	{
		fr=new JFrame("eQuiz SignIn");
		pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(Color.lightGray);
		fr.getContentPane().add(pn);

//#######################DBConnection###############
		DBConnection();		
		
//####################### Center Setting #####################
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		//fr.setLocation(400,400);
		fr.setLocation( ( (screenDim.width - fr.getSize().width) / 2 )-150, ((screenDim.height - fr.getSize().height)/2)-100);

//####################### Icon #########################
		fr.setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Images\\my.gif"));

//####################### Font Type ######################
		Font ft = new Font("Monotype Corsiva",Font.BOLD,20);

//####################### Designs #########################		
		lblSign=new JLabel("Sign in");
			lblSign.setForeground(Color.black);
			lblSign.setFont(ft);
		lblSign.setBounds(110,0,80,40);
		pn.add(lblSign);
		lblName=new JLabel("Name");
		lblName.setBounds(50,50,40,20);
		pn.add(lblName);
		lblPass=new JLabel("Password");
		lblPass.setBounds(50,70,80,40);
		pn.add(lblPass);
				
		String arr[] = {"<User>","Master"};
		cb=new JComboBox(arr);
		cb.setBounds(130,50,100,20);
		pn.add(cb);

		Ok_Pass_KeyList OPKL =new Ok_Pass_KeyList();
		Ok_Cancel_ActionList act =new Ok_Cancel_ActionList();
		Cancel_KeyList CKL =new Cancel_KeyList();
			
		txtPass=new JPasswordField();
		txtPass.addKeyListener(OPKL);
		txtPass.setBounds(130,80,100,20);
		pn.add(txtPass);

		btOk=new JButton("Ok");
		btOk.setBounds(50,120,60,20);
		btOk.addKeyListener(OPKL);
		btOk.addActionListener(act);
		pn.add(btOk);

		btCancel=new JButton("Cancel");
		btCancel.setBounds(150,120,80,20);
		
		btCancel.addActionListener(act);
		btCancel.addKeyListener(CKL);
		pn.add(btCancel);
		
		displayUser();
		fr.setSize(290,200);
		fr.setVisible(true);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
	}

//##################### Methods ########################
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
			rs=st.executeQuery("select * from questionset");
			while(rs.next())
			{
				cb.addItem(rs.getString(1));
			}
			con.close();
		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(fr,"Error in Connection");}
	}
	
	public void userCheck()
	{
		String s0=(String)cb.getSelectedItem();
		s1=s0.trim();
		s=new String(txtPass.getPassword());
		try
		{
			con.close();			
			DBConnection();
			String sp1;
			st=con.createStatement();
			rs=st.executeQuery("select * from resultset");
			int no1=0;
			while(rs.next())
			{	
				sp1=rs.getString(1).trim();
				if(s1.compareTo(sp1)==0)
				{no1++;}
			}
			con.close();			
			DBConnection();
		
		if(no1==0)
		{
			if(s1.compareTo("<User>")!=0)
			{
				if((s1.compareTo("Master")==0)&&(s.compareTo("equiz")==0))
				{
					try
					{new AdminFrame();}				
					catch(Exception e){}
					fr.dispose();
				}
				else  if(s1.compareTo("Master")!=0)
				{
					DBConnection();
					int n=0;String str;
					try
					{
						st=con.createStatement();
						rs=st.executeQuery("select * from userset");
						while(rs.next())
						{
							if((s1.compareTo(rs.getString(1).trim())==0))
							{	
								str=new String(rs.getString(2));
								if((s.compareTo(str)==0))
								{n++;}
							}
						}
					}
					catch(Exception e)
					{JOptionPane.showMessageDialog(fr,"Error in Connection");}
					if(n==1)
					{new StartTest(s1,s);fr.dispose();}
					else
					{JOptionPane.showMessageDialog(fr,"Invalid Password");}
				}	
				else
				{JOptionPane.showMessageDialog(fr,"Invalid Name or Password");}
			}
			else
			{JOptionPane.showMessageDialog(fr,"Invalid User");}
		}
		else
		{JOptionPane.showMessageDialog(fr,s1+" "+"already attended test");}


		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(fr,"Error in Connection");}
	}
//##################### Listeners ########################
	class Ok_Cancel_ActionList implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==btOk)
			userCheck();
			if(ae.getSource()==btCancel)
			{
				if(JOptionPane.showConfirmDialog(fr,"Exit Me ???","eQuiz",JOptionPane.OK_OPTION)==JOptionPane.OK_OPTION)
				System.exit(0);
			}
		}
	}
	class Cancel_KeyList implements KeyListener
	{
		public void keyTyped(KeyEvent ke)
		{
			if(ke.getKeyChar()==10)
			{
				if(JOptionPane.showConfirmDialog(fr,"Exit Me ???","eQuiz",JOptionPane.OK_OPTION)==JOptionPane.OK_OPTION)
				System.exit(0);
			}
		}
		public void keyPressed(KeyEvent ke)
		{}
		public void keyReleased(KeyEvent ke)
		{}
		
	}
	class Ok_Pass_KeyList implements KeyListener
	{ 
		public void keyTyped(KeyEvent ke)
		{
			if(ke.getKeyChar()==10)
			userCheck();			
		}
		public void keyPressed(KeyEvent ke)
		{}
		public void keyReleased(KeyEvent ke)
		{}		
	}

//###################### Main ######################
	public static void main(String args[]) 
	{
		Quiz Q=new Quiz();
	}
}
	