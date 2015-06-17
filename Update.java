package cn.lntu.t24;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
public class Update extends JFrame implements ActionListener{
	private JPanel ContentPane;
	private JLabel jlab1 = new JLabel();
	private JLabel jlab2 = new JLabel();
	private JLabel jlab3 = new JLabel();
	private JLabel jlab4 = new JLabel();
	private JLabel jlab5 = new JLabel();
	private JTextField jtextfield1 = new JTextField();
	private JTextField jtextfield2 = new JTextField();
	private JTextField jtextfield3 = new JTextField();
	private JTextField jtextfield4 = new JTextField();
	private JButton sure = new JButton();
	private JButton upda = new JButton();
	public Update()
	{
		this.setBounds(320,160,450,450);
		this.setTitle("修改学生信息");
	    ContentPane =(JPanel)this.getContentPane();//将容器转化为JPanel
	    ContentPane.setLayout(null);//设置可更改性
	    ContentPane.setBackground(Color.black);
		jlab1.setText("请先输入学号！");
		jlab1.setBounds(new Rectangle(30, 11, 160, 33));
		jlab1.setForeground(Color.white);
		jlab2.setText("学号");
		jlab2.setBounds(new Rectangle(31,53,100,33));
		jlab2.setForeground(Color.white);
		jlab3.setText("姓名");
		jlab3.setBounds(new Rectangle(30, 94, 100, 33));
		jlab3.setForeground(Color.white);
		jlab4.setText("性别");
		jlab4.setBounds(new Rectangle(30,120,100,33));
		jlab4.setForeground(Color.white);
		jlab5.setText("专业");
		jlab5.setBounds(new Rectangle(30, 150, 100, 33));
		jlab5.setForeground(Color.white);
		
		jtextfield1.setText("");
		jtextfield1.setBounds(new Rectangle(150, 53, 150, 22));
		jtextfield2.setText("");
		jtextfield2.setBounds(new Rectangle(150, 94, 150, 22));
		jtextfield3.setText("");
		jtextfield3.setBounds(new Rectangle(150, 120, 150, 22));
		jtextfield4.setText("");
		jtextfield4.setBounds(new Rectangle(150, 150, 150, 22));
		
		sure.setText("确定");//设置命令按钮
		sure.setBounds(new Rectangle(320, 53, 89, 22));
		sure.addActionListener(this);
		upda.setText("修改");
		upda.setBounds(200, 200, 89, 22);
		upda.addActionListener(this);
		
		ContentPane.add(jlab1);
		ContentPane.add(jlab2);
		ContentPane.add(jlab3);
		ContentPane.add(jlab4);
		ContentPane.add(jlab5);
		ContentPane.add(jtextfield1);
		ContentPane.add(jtextfield2);
		ContentPane.add(jtextfield3);
		ContentPane.add(jtextfield4);
		ContentPane.add(sure);
		ContentPane.add(upda);
		this.setVisible(true);	
	}
	
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==sure)
			{
				try{
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/studentmanager";
					String user="root";    
					String password="123456";    
					Connection conn= DriverManager.getConnection(url,user,password);
					Statement stmt=conn.createStatement();
					String SQL="SELECT stuname,stusex,majname FROM student WHERE stuno='"+jtextfield1.getText()+"'";
				    ResultSet rs=stmt.executeQuery(SQL);
				    while(rs.next())
				    {				    	
				    jtextfield2.setText(rs.getString("stuname"));
				    jtextfield3.setText(rs.getString("stusex"));
				    jtextfield4.setText(rs.getString("majname"));
				    }
				    rs.close();
				    stmt.close();
				    conn.close();
				}catch(Exception ee)
				{
					
					ee.printStackTrace();
				}
			}
			else if(e.getSource()==upda)
			{
				try{
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/studentmanager";
					String user="root";    
					String password="123456";    
					Connection con= DriverManager.getConnection(url,user,password);
				Statement stmt=con.createStatement();
				String SQL="UPDATE student SET stuname= 001e='"+jtextfield4.getText()+"'      " +	" WHERE stuno='"+jtextfield1.getText()+"'";
			    stmt.executeUpdate(SQL);
//			    rs.close();
			    stmt.close();
			    con.close();
			}catch(Exception ee)
			{
				ee.printStackTrace();
			}
			}
			
		}
		public static void main (String arg[]){
			Update update=new Update();
		}
	}
