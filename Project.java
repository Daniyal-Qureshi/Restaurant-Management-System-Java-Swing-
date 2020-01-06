import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
 public class Project extends JFrame  {
 	// constrcutor It will Login Window
 	Project(){
	        
        setTitle(" Login Form"); 
        JLabel lab=new JLabel("Employee ID");
 	 	JLabel lab2=new JLabel("Password");
        JLabel form=new JLabel("Employee Login Form");
        form.setBounds(50,-20,400,100);
        form.setFont(new Font("Arial",Font.ITALIC,25));
        form.setForeground(Color.RED);
	 	lab.setBounds(50,30,100,100);
	 	lab2.setBounds(50,110,100,100);
	    Container c=getContentPane();
		Color color=new Color(0,150,190);
		c.setBackground(color);
	 	
	 	setResizable(false);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JTextField Id=new JTextField();
		JPasswordField password=new JPasswordField();
		JButton btn=new JButton("Login");
		btn.setBounds(50,230,200,50);
		Cursor cur=new Cursor(Cursor.HAND_CURSOR);
		btn.setCursor(cur);
		
		Id.setBounds(50,100,200,30);
		password.setBounds(50,170,200,30);
		password.setEchoChar('*');
		btn.addActionListener(new Login(Id,password,this));
		add(Id);
		add(password);
		add(btn);
		add(lab);
		add(lab2);
	    add(form);
	    pack();
	    setBounds(50,50,400,400);

       
 	}
 	public static void main(String[] args) {
	Project o=new Project();
	}
}
class Login implements ActionListener{
		JTextField Id, password;
		JFrame jfm;
		//Constructor 
		Login(JTextField Id,JTextField password,JFrame jfm){
		this.Id=Id;
		this.jfm=jfm;
		this.password=password;       
		}

	public void actionPerformed(ActionEvent ae){
	JFrame j=new JFrame();
	JButton ok=new JButton("OK");
	j.setBounds(50,100,220,200);
	j.setLayout(null);
	j.setResizable(false);
	j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JLabel lab=new JLabel("Incorrect Password!");
	lab.setBounds(10,50,500,50);
	ok.setBounds(40,100,70,50);
	ok.setFocusPainted(false);
	ok.setContentAreaFilled(false);
    ok.setFont(new Font("Arial",Font.ITALIC,15));
    ok.setForeground(Color.RED);
    //Cursor Class
	Cursor cur=new Cursor(Cursor.HAND_CURSOR);
	ok.setCursor(cur);
	lab.setFont(new Font("Arial",Font.ITALIC,20));
	j.add(lab);
	j.add(ok);
	
	ok.addActionListener(new ActionListener() {     
      			public void actionPerformed(ActionEvent e) {
      			j.setVisible(false);
      			jfm.setVisible(false);
      			String args[]={};
      			Project.main(args);
            	}
     });
                           	
	if(Id.getText().equals("09011")&&password.getText().equals("0331")){
	j.setVisible(false);
    jfm.setVisible(false);  			
	Main.MainFrame();	
	}
	else
	j.setVisible(true);


}

}

//it is the main class containing menu of Resturant
 class Main{
	static JFrame Main_jfm;
	static int total,counter=0;
	static String receipt="";
//Main Method	
	static void MainFrame(){ 		
	 Main_jfm=new JFrame("Karachi Restaurant");
	Main_jfm.setBounds(0,0,800,700);
	Main_jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Main_jfm.setLayout(null);
	Main_jfm.setVisible(true);
	Main_jfm.setBackground(Color.RED);

	//-----------------------Karachi Restaurant Label---------------
	JLabel Heading=new JLabel("Karachi Restaurant");
	Font font=new Font("Arial",Font.ITALIC,40);
	Heading.setFont(font);
	Heading.setForeground(Color.RED);
	Heading.setBounds(100,10,500,100);
	Main_jfm.add(Heading);
	Main_jfm.setResizable(false);

	//--------------------------Labels of Foods Beverages Dessert
	JLabel[] label=new JLabel[10];
	label[0]=new JLabel("Foods");
	label[1]=new JLabel("Beverages");
	label[2]=new JLabel("Dessert");
	
	label[0].setBounds(100,50,200,150);
	label[1].setBounds(350,50,200,150);
	label[2].setBounds(570,50,200,150);
	Font font1=new Font("Arial",Font.PLAIN,20);

	label[0].setFont(font1);
	label[1].setFont(font1);
	label[2].setFont(font1);

	Main_jfm.add(label[0]);
	Main_jfm.add(label[1]);
	Main_jfm.add(label[2]);

	//------------------Images of food dessert and Beverages
	JButton[] btn=new JButton[3];		
	JButton log=new JButton("Log out");
	ImageIcon img1=new ImageIcon("Resturant\\Food\\food.jpg");
	ImageIcon img2=new ImageIcon("Resturant\\Beverages\\beverages.jpg");
	ImageIcon img3=new ImageIcon("Resturant\\Dessert\\Dessert.jpg");
	  
	//Buttons of food dessert and Beverag	
	btn[0]=new JButton("Food",img1);
	btn[1]=new JButton("Beverages",img2);
	btn[2]=new JButton("Dessert",img3);
	Cursor cur=new Cursor(Cursor.HAND_CURSOR);
	btn[0].setBounds(100,150,200,200);
	btn[1].setBounds(320,150,200,200);
	btn[2].setBounds(540,150,200,200);

	log.setBounds(650,50,120,40);
	log.setFocusPainted(false);
    log.setFont(new Font("Arial",Font.ITALIC,20));
	log.setContentAreaFilled(false);

	Main_jfm.add(btn[0]);
	Main_jfm.add(btn[1]);
	Main_jfm.add(btn[2]);	
	Main_jfm.add(log);	


	btn[0].addActionListener(new eventHandler(Main_jfm));
	btn[1].addActionListener(new eventHandler(Main_jfm));
	btn[2].addActionListener(new eventHandler(Main_jfm));
	log.addActionListener(new eventHandler(Main_jfm));
	
	
	btn[0].setCursor(cur);
	btn[1].setCursor(cur);
	btn[2].setCursor(cur);
	

	Container c=Main_jfm.getContentPane();
	Color color=new Color(0,150,190);
	c.setBackground(color);
	}	


    
}
//-------------------------------event Handler Class---------------------------------
//This class contains methods of main menu


class eventHandler implements ActionListener{
	JFrame M_jfm;
	eventHandler(JFrame j)
	{
	M_jfm=j;
	}


	public void actionPerformed(ActionEvent ae)
	{
	M_jfm.setVisible(false);
	JButton obj=(JButton)ae.getSource();
	String option=obj.getText();
	if(option.equals("Log out")){	
	Project pro=new Project();
	}

	if(option.equals("Food"))
	{
	String[] Adr=new String[4];
	String[] label=new String[4];
	JFrame jfm=new JFrame("Food");
	jfm.setResizable(false);
	jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Adr[0]="Resturant\\Food\\images1.jpg";
	Adr[1]="Resturant\\Food\\images2.jpg";
	Adr[2]="Resturant\\Food\\images3.jpg";
	Adr[3]="Resturant\\Food\\images4.jpg";
	Images(jfm,Adr[0],Adr[1],Adr[2],Adr[3]);
	
	label[0]="Steak Stir Fry(Rs.120)";
	label[1]="Chicken Tikka(Rs.180)";
	label[2]="Roasted Chicken(Rs.150)";
	label[3]="Roasted Chicken Stick(170)";
	
	Label(jfm,label[0],label[1],label[2],label[3]);
	Field_Class.Fields(jfm,label[0],label[1],label[2],label[3]);
	
	}
//-------------------------------------------------------------------------
	if(option.equals("Beverages"))
	{
	JFrame jfm=new JFrame("Beverages");
	String[] Adr=new String[4];
	String[] label=new String[4];

	Adr[0]="Resturant\\Beverages\\images1.jpg";
	Adr[1]="Resturant\\Beverages\\images2.jpg";
	Adr[2]="Resturant\\Beverages\\images3.jpg";
	Adr[3]="Resturant\\Beverages\\images4.jpg";
	Images(jfm,Adr[0],Adr[1],Adr[2],Adr[3]);

	jfm.setResizable(false);
	jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	label[0]="Cherry Juice(Rs.90)";
	label[1]="Soft Drinks(Rs.30)";
	label[2]="Strawberry Shake(Rs.100)";
	label[3]="Apple Juice(Rs.80)";
	Label(jfm,label[0],label[1],label[2],label[3]);
	Field_Class.Fields(jfm,label[0],label[1],label[2],label[3]);
	}
//----------------------------------------------------------------------
	if(option.equals("Dessert"))
	{
	JFrame jfm=new JFrame("Dessert");
	String[] Adr=new String[4];
	String[] label=new String[4];
	Adr[0]="Resturant\\Dessert\\images1.jpg";
	Adr[1]="Resturant\\Dessert\\images2.jpg";
	Adr[2]="Resturant\\Dessert\\images3.jpg";
	Adr[3]="Resturant\\Dessert\\images4.jpg";
	Images(jfm,Adr[0],Adr[1],Adr[2],Adr[3]);

	jfm.setResizable(false);
	jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	label[0]="Strawberry Pie(Rs.150)";
	label[1]="Chocolate Cookie(Rs.120)";
	label[2]="Ice Cream(Rs.130)";
	label[3]="Fruit Pastrie(Rs.60)";
	Label(jfm,label[0],label[1],label[2],label[3]);
	Field_Class.Fields(jfm,label[0],label[1],label[2],label[3]);
	}

	}

	//----------------------------------------Images Method---------------------
	public void Images(JFrame jfm,String Adr1,String Adr2,String Adr3,String Adr4)
	{
	
	jfm.setVisible(true);
	jfm.setLayout(null);
	jfm.setBounds(100,10,700,730);
	ImageIcon img1=new ImageIcon(Adr1);
	ImageIcon img2=new ImageIcon(Adr2);
	ImageIcon img3=new ImageIcon(Adr3);
	ImageIcon img4=new ImageIcon(Adr4);
	JLabel[] label=new  JLabel[10];	
	label[0]=new JLabel(img1);
	label[1]=new JLabel(img2);
	label[2]=new JLabel(img3);
	label[3]=new JLabel(img4);
	
	label[0].setBounds(100,100,220,200);
	label[1].setBounds(350,100,220,200);
	label[2].setBounds(100,400,220,200);
	label[3].setBounds(350,400,220,200);
	
	jfm.add(label[0]);
	jfm.add(label[1]);
	jfm.add(label[2]);
	jfm.add(label[3]);
	Color color=new Color(200,90,100);
	Container c=jfm.getContentPane();
	c.setBackground(color);
	}

//-------------------------------------------Labels Method----------------------------------------------- 

	public void Label(JFrame jfm,String label1,String label2,String label3,String label4)
	{
	JLabel[] label =new JLabel[4];
	label[0]=new JLabel(label1);
	label[1]=new JLabel(label2);
	label[2]=new JLabel(label3);
	label[3]=new JLabel(label4);
	
	label[0].setBounds(100,10,300,100);
	label[1].setBounds(350,10,300,100);
	label[2].setBounds(100,320,300,100);
	label[3].setBounds(350,320,300,100);
	
	jfm.add(label[0]);
	jfm.add(label[1]);
	jfm.add(label[2]);
	jfm.add(label[3]);
	
	Font f=new Font("Arial",Font.ITALIC,20);
	label[0].setFont(f);
	label[1].setFont(f);
	label[2].setFont(f);
	label[3].setFont(f);


	}


}



//------------------------------TextField class------------------------
//it contains methods that will handle the actions and button actions

class Field_Class 
{
	static void Fields(JFrame jfm,String label1,String label2,String label3,String label4){
	JButton  btn=new JButton("Ok");
	JButton  btn2=new JButton("Back");
	JButton  btn3=new JButton("Receipt");


	JTextField[] jfield=new JTextField[4];
	btn.setBounds(100,650,50,30);
	btn2.setBounds(200,650,100,30);
	btn3.setBounds(300,650,100,30);

	
	jfm.add(btn);
	jfm.add(btn2);
	jfm.add(btn3);


 	jfield[0]=new JTextField();
 	jfield[1]=new JTextField();
	jfield[2]=new JTextField();
	jfield[3]=new JTextField();

	jfield[0].setBounds(100,300,220,30);
	jfield[1].setBounds(350,300,220,30);
	jfield[2].setBounds(100,605,220,30);
	jfield[3].setBounds(350,605,220,30);
	
	
	jfm.add(jfield[0]);
	jfm.add(jfield[1]);
	jfm.add(jfield[2]);
	jfm.add(jfield[3]);
	
	Field_Handler obj =new Field_Handler(jfield[0],jfield[1],jfield[2],jfield				
	[3],jfm,label1,label2,label3,label4);
		

	btn.addActionListener(obj);	
	btn2.addActionListener(obj);	
	btn3.addActionListener(obj);	
	
	
	Cursor cur=new Cursor(Cursor.HAND_CURSOR);
	btn.setCursor(cur);
	btn2.setCursor(cur);
	btn3.setCursor(cur);

		

	
	}

}
//--------------------------------Field Handler class---------------------------------
//This class will handle operations related to Menu TextFields
class Field_Handler  implements ActionListener
{ 
	Main obj=new Main();
	JTextField f1, f2, f3, f4;
	JFrame jfm;
	Boolean OK=false;
	String label1,label2,label3,label4;
	int[] num=new int[4];
	

	Field_Handler(JTextField field1,JTextField field2,JTextField field3,
	JTextField field4,JFrame j,String b1,String b2,String b3,String b4)
	{
	f1=field1;
	f2=field2;
	f3=field3;
	f4=field4;
	jfm=j;
	label1=b1;
	label2=b2;
	label3=b3;
	label4=b4;
	}

	public void actionPerformed(ActionEvent ae){
	JButton btn=(JButton)ae.getSource();


	if(btn.getText().equals("Back")){
	obj.Main_jfm.setVisible(true);
	jfm.setVisible(false);
	obj.Main_jfm.setLocation(100,100);
	}

	else if(btn.getText().equals("Ok")){
	OK=true;
		f1.setBackground(Color.WHITE);
		f2.setBackground(Color.WHITE);
		f3.setBackground(Color.WHITE);
		f4.setBackground(Color.WHITE);

	try{
	if(f1.getText().length()==0&&f2.getText().length()==0&&
		f3.getText().length()==0&&f4.getText().length()==0){
		f1.setBackground(Color.RED);
		f2.setBackground(Color.RED);
		f3.setBackground(Color.RED);
		f4.setBackground(Color.RED);

		}	
	

	 if(f1.getText().length()!=0)
	num[0]=Integer.parseInt(f1.getText());
	
	 if(f2.getText().length()!=0)
	num[1]=Integer.parseInt(f2.getText());

	 if(f3.getText().length()!=0)
	num[2]=Integer.parseInt(f3.getText());
	
	 if(f4.getText().length()!=0)
	num[3]=Integer.parseInt(f4.getText());
	}

//If user enters Any Alphanumeric value NumberFormatException is caught by this block
	catch(Exception e)
	{
	JFrame j=new JFrame("Error");
	Container c=j.getContentPane();
	c.setBackground(Color.RED);
	j.setResizable(false);
	j.setBounds(200,200,250,250);	
	j.setVisible(true);
	JLabel message=new JLabel("  Invalid Input!");
	message.setBounds(10,50,500,100);
	message.setFont(new Font("Arial", Font.ITALIC,30));
	j.add(message);
	j.setLayout(null);

	}
		
	if(jfm.getTitle().equals("Food"))
	Food();	

	if(jfm.getTitle().equals("Beverages"))
	Beverages();

	if(jfm.getTitle().equals("Dessert"))
	Dessert();

	}




	else if(btn.getText().equals("Receipt"))
	{
	if(OK==false||obj.total==0){
	JFrame O=new JFrame("No Receipt Generated");
	Container c=O.getContentPane();
	c.setBackground(Color.RED);
	O.setResizable(false);
	O.setVisible(true);
	O.setBounds(150,150,280,200);
	JLabel message=new JLabel("No Receipt yet!");
	message.setBounds(20,50,500,50);
	message.setFont(new Font("Arial",Font.ITALIC,25));
	O.add(message);
	O.setLayout(null);


	}
	else {
	JFrame jfm2=new JFrame("Customer Receipt");	
	jfm2.setVisible(true);
	jfm2.setBounds(100,100,400,400);
	Account(jfm2);	
	jfm2.setLayout(null);
	}
	}
	

	
      }
	
	
	
//----------------------------------------------------------Food Account---------------------------------------------------
//This method will perform computation on prices and quantity of food items
	void Food()
	{
	int account=0;
	if(label1.equals("Steak Stir Fry(Rs.120)")&&num[0]!=0)
	{
	obj.counter++;
	account+=num[0]*120;
	obj.receipt+=obj.counter+".Steak Stir Fry(Rs.120)"+"\t"+num[0]+"\t"+num[0]*120+"\n";                       
     	}
	
	if(label2.equals("Chicken Tikka(Rs.180)")&&num[1]!=0)
	{
	obj.counter++;
	account+=num[1]*180;
	obj.receipt+=obj.counter+".Chicken Tikka(Rs.180)"+"\t"+num[1]+"\t"+num[1]*180+"\n";                      
                                                                                                                                
	}

	if(label3.equals("Roasted Chicken(Rs.150)")&&num[2]!=0)
	{
	obj.counter++;
	account+=num[2]*150;
	obj.receipt+=obj.counter+".Roasted Chicken(Rs.150)"+"\t"+num[2]+"\t"+num[2]*150+"\n";
	}

	if(label4.equals("Roasted Chicken Stick(170)")&&num[3]!=0)
	{
	obj.counter++;
	account+=num[3]*170;
	obj.receipt+=obj.counter+".Roasted Chicken Stick(170)"+"\t"+num[3]+" \t"+num[3]*170+"\n";
	}

	
	obj.total+=account;
	num[0]=0;
	num[1]=0;
	num[2]=0;
	num[3]=0;
	
	
	}
//-----------------------------------------------------Beverages Method-----------------------------
//This method will perform computation on prices and quantity of Beverages items
	
	void Beverages()
	{
	int account=0;
	if(label1.equals("Cherry Juice(Rs.90)")&&num[0]!=0)
	{
	obj.counter++;
	account+=num[0]*90;
	obj.receipt+=obj.counter+".Cherry Juice(Rs.90)"+"\t"+num[0]+" \t"+num[0]*90+"\n";	

	}
	if(label2.equals("Soft Drinks(Rs.30)")&&num[1]!=0)
	{
	obj.counter++;
	account+=num[1]*30;
	obj.receipt+=obj.counter+".Soft Drinks(Rs.30)"+"\t"+num[1]+" \t"+num[1]*30+"\n";
	}


	
	if(label3.equals("Strawberry Shake(Rs.100)")&&num[2]!=0)
	{
	obj.counter++;
	account+=num[2]*100;
	obj.receipt+=obj.counter+".Strawberry Shake(Rs.100)"+" \t"+num[2]+"\t"+num[2]*100+"\n";
	}
	
	if(label4.equals("Apple Juice(Rs.80)")&&num[3]!=0)
	{
	obj.counter++;
	account+=num[3]*80;
	obj.receipt+=obj.counter+".Apple Juice(Rs.80)"+"\t"+num[3]+" \t"+num[3]*80+"\n";
	}
	
	obj.total+=account;
	num[0]=0;
	num[1]=0;
	num[2]=0;
	num[3]=0;
	}
//-----------------------------------------------Dessert Method-------------------------------------
//This method will perform computation on prices and quantity of Dessert items

	void Dessert()
	{


	int account=0;
	if(label1.equals("Strawberry Pie(Rs.150)")&&num[0]!=0)
	{
	obj.counter++;
	account+=num[0]*150;
	obj.receipt+=obj.counter+".Strawberry Pie(Rs.150)"+"\t"+num[0]+"\t"+num[0]*150+"\n";	
	}

	if(label2.equals("Chocolate Cookie(Rs.120)")&&num[1]!=0)
	{
	obj.counter++;
	account+=num[1]*120;
	obj.receipt+=obj.counter+".Chocolate Cookie(Rs.120)"+"\t"+num[1]+"\t"+num[1]*120+"\n";
	}

	if(label3.equals("Ice Cream(Rs.130)")&&num[2]!=0)
	{
	obj.counter++;
	account+=num[2]*130;
	obj.receipt+=obj.counter+".Ice Cream(Rs.130)"+"\t"+num[2]+"\t"+num[2]*130+"\n";
	}

	if(label4.equals("Fruit Pastrie(Rs.60)")&&num[3]!=0)
	{
	obj.counter++;
	account+=num[3]*60;
	obj.receipt+=obj.counter+".Fruit Pastrie(Rs.60)"+"\t"+num[3]+"\t"+num[3]*60+"\n";
	}

	
	obj.total+=account;
	num[0]=0;
	num[1]=0;
	num[2]=0;
	num[3]=0;

	}
//--------------------------------------Account----------------------
//It will calculate Amount decide Discount and generate Receipt 	
	void Account(JFrame jfm2)
	{

	
	String str="";
	int discount=0;
	int Paid_Amount=0;

	

	if(obj.total<=1000)
	 Paid_Amount=obj.total;

	else if(obj.total<=2000&&obj.total>=1000)
	{
	discount=obj.total*10/100;	
	Paid_Amount=obj.total-discount;
	discount=10;
	}

	else if(obj.total>2000&&obj.total<=6000)
	{
	discount=obj.total*30/100;	
	Paid_Amount=obj.total-discount;
	discount=30;
	}

	else if(obj.total>6000)
	{
	discount=obj.total*50/100;	
	Paid_Amount=obj.total-discount;
	discount=50;
	}

	
	
	if(discount!=0)
	{
	str+=" Total amount\t\t"+obj.total+"\n"+" Discount \t\t"+discount+"%"+"\n"
	+" Paid Amount\t\t"+Paid_Amount;	
	}
	
	else
	str+=" Total amount\t\t"+obj.total+"\n"+" Paid Amount \t\t"+Paid_Amount+
	"\n\n Note:Discount is given if your bill exceeds 1000";	
	

	JTextArea Area=new JTextArea("Sr.      Name\t\t"+"Quantity\t"+"Amount  \n"+
				obj.receipt+" \n\n\n"+str);
	Color c=new Color(220,90,100);
	Font f=new Font("Arial",Font.ITALIC,25);

	Area.setBackground(Color.GREEN);
	Border bor=new LineBorder(c,5);
	Area.setBorder(bor);
	Area.setBorder(bor);
	Area.setBackground(Color.GREEN);
	jfm2.add(Area);
	Area.setFont(f);
	Area.setEditable(false);

	JButton account_btn=new JButton("Main Menu");
	Area.add(account_btn);
	
	if(obj.counter>=0&&obj.counter<=10)
	{
	Area.setBounds(0,0,700,600);
	jfm2.setBounds(100,100,718,640);
	account_btn.setBounds(5,545,150,50);
	}

	if(obj.counter>=10)
	{
	Area.setBounds(0,0,700,750);
	jfm2.setBounds(100,100,718,790);	
	account_btn.setBounds(5,690,150,50);
	}

	
	account_btn.addActionListener(new Account(jfm2,jfm));
	}
		
}
//It will reset all Variable and go to main menu to start new Receipt
	class Account  implements ActionListener{
	JFrame jfm2;
	JFrame jfm;
	Account(JFrame j,JFrame j2)
	{
	jfm2=j;
	jfm=j2;
	}

	Main obj=new Main();
		
	public void actionPerformed(ActionEvent ae)
	{
	jfm2.setVisible(false);
	jfm.setVisible(false);
	obj.counter=0;
	obj.receipt="";
	obj.total=0;
	obj.Main_jfm.setVisible(true);
	}
}
