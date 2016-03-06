GO
	use quiz
GO
	CHECKPOINT
GO
	create table Java
	(
		ques Text not null, 
		ansA varchar(80) not null,
		ansB varchar(80) not null,
		ansC varchar(80) not null,
		ansD varchar(80) not null,
		ans varchar(80) not null
	)
GO
	CHECKPOINT
GO
	select * from Java
GO
	CHECKPOINT
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('What output is displayed as the result of executing the following                   statement? System.out.println("// Looks like a comment.");','// Looks like a comment','The statement results in a compilation error','Looks like a comment','None of these','// Looks like a comment')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('In order for a source code file, containing the public class Test, to                 successfully compile, which of the following must be true?','It must have a package statement','It must be named Test.java','It must declare a public class named Test','None of these','It must be named Test.java')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('What is the value of a[3] as the result of the following array declaration?','2','1','3','4','4')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('Which of the following are primitive types?','byte','String','character','integer','byte')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('What is the range of the char type?','0 to 216','0 to 215','0 to 215-1','0 to 216+1','0 to 215-1')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('Which of the following can be referenced by this variable?','The methods of a class only','The instance variables and methods of a class','The instance variables of a class only','None of these','The instance variables and methods of a class')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('Which of the following operators are used in conjunction with the this and super references?','The dot operator','The instanceof operator','The new operator','None of these','The dot operator')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('Which of the following statements correctly describes an interface?','Its a concrete class','Its a superclass','Its a type of abstract class','All are correct','Its a type of abstract class')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('An interface contains __ methods','Non-abstract','unimplemented','Implemented','None of these','unimplemented')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('Which of the following classes is used to perform basic console I/O?','None of these','System','Runtime','SecurityManager','System')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('Which of the following method is methods of the Math class?','All are Correct','absolute( )','log( )','cosine( )','log( )')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('Which of the following are true about the Error and Exception classes?','Both classes extend Throwable','The Error class is final and the Exception class is not','Both classes implement Throwable','None of these','Both classes extend Throwable')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('Which of the following are valid statements','public class MyCalc extends Math','Math.max(s);','math.min(s);','None of the above','None of the above')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('When two or more objects are added as listeners for the same event,       which listener is first invoked to handle the event?','The first object that was added as listener','There is no way to determine which listener will be invoked first','The last object that was added as listener','None of these','There is no way to determine which listener will be invoked first')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('Which of the following components generate action events?','Labels','Check boxes','Text Field','Buttons','Buttons')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('How would you set the color of a graphics context called g to cyan?','g.setColor(Color.cyan);','g.setCurrentColor(cyan);','g.setColor(new Color(cyan));','All are same','g.setColor(Color.cyan);')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('What code would you use to construct a 24-point bold serif font?','new Font(Font.SERIF, "BOLD", 24);','new Font("SERIF", Font.BOLD,24);','new Font("BOLD ", 24,Font.SERIF);','None of above','new Font("SERIF", Font.BOLD,24);')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('Which of the following are passed as an argument to the paint( ) method?','A AWT object','A Canvas object ','A Graphics object','A paint object','A Graphics object')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('Which of the following methods are invoked by the AWT to support paint   and repaint operations?','redraw()','repaint( )','draw( )','paint( )','paint( )')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('What is the value of 111 % 13?','9','3','5','7','7')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('What is the result of expression 5.45 + "3,2"?','The double value 8.6','The String "5.453.2"','The long value 8','The float value 8.6','The String "5.453.2"')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('What is the programming construct?','Sequential','Selection -- if and switch statements','Iteration -- for loop, while loop and do-while loop','None of these','Sequential')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('What are the immediate super classes of the following classes?','Container class','Applet class','MenuComponent class','Lang class','Container class')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('Which Component method is used to access a component"s immediate     Container?','getData()','getParent()','getImmediate','getContainer','getParent()')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('Which method is used to set the text of a Label object?','setLabel( )','setTestField()','setText( )','setTextLabel( )','setText( )')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('Which constructor creates a TextArea with 10 rows and 20 columns?','new TextArea(10)','new TextArea(20, 10)','new TextArea(10, 20)','new TextArea(20)','new TextArea(10, 20)')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('A Frame’s background color is set to Color.Yellow, and a Button’s              background color is to Color.Blue. Suppose the Button is added to a Panel,      which is added to the Frame. What background color will be used with the       Panel?','Colr.Black','Color.White','Color.Blue','Colr.Yellow','Colr.Yellow')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('Which of the following may contain a menu bar?','A panel','A menuitem ','A frame','A menu','A frame')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('How do you indicate where a component will be positioned using               Flowlayout?','North, South,East,West','Do nothing, the FlowLayout will position the component','East,West,North, South','Assign a row/column grid reference','Do nothing, the FlowLayout will position the component')
GO
	insert Java (ques,ansA,ansB,ansC,ansD,ans) values('Which method returns the preferred size of a component?','getRequired( )','getPreferredSize( )','getRequiredSize( )','getPreferred( )','getPreferredSize( )')

