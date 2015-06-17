package cn.lntu.t24;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
public class Select extends JFrame implements ActionListener{
	     private JTextArea taInfo=new JTextArea(); 
	     private JPanel panel=new JPanel();
	     private JTextField jtextfield1=new JTextField();
	     private JButton jbutton=new JButton("查询");
	     private JLabel jlabel=new JLabel("学号");
		public  Select()
		{
			super("查询学生信息");
			setBounds(200,300,500,300);
			panel.setLayout(new BorderLayout());
			panel.add(jlabel, BorderLayout.WEST);
			panel.add(jtextfield1,BorderLayout.CENTER);
			panel.add(jbutton,BorderLayout.EAST);
			jbutton.addActionListener(this);
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(panel,BorderLayout.NORTH);
			getContentPane().add(taInfo,BorderLayout.CENTER);	
			this.setVisible(true);
		}
	    
				public void actionPerformed(ActionEvent e) //创建方法
				{  try{
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/studentmanager";
//					Connection con=DriverManager.getConnection(url);
					String user="root";    
					String password="123456";    
					Connection conn= DriverManager.getConnection(url,user,password);
					Statement stmt=conn.createStatement();
					String SQL="SELECT * FROM student    WHERE stuno='"+jtextfield1.getText()+"'";
				    ResultSet rs=stmt.executeQuery(SQL);
				    while(rs.next())
				    {
				    taInfo.setText("学号：");
				    taInfo.append(rs.getString("stuno")+"\n");
				    taInfo.append("姓名：");
				    taInfo.append(rs.getString("stuname")+"\n");
				    taInfo.append("性别：");
				    taInfo.append(rs.getString("stusex")+"\n");
				    taInfo.append("生日：");
				    taInfo.append(rs.getString("birthdate")+"\n");
				    taInfo.append("身份证号：");
				    taInfo.append(rs.getString("stuid")+"\n");
				    taInfo.append("专业：");
				    taInfo.append(rs.getString("majname")+"\n");
				    taInfo.append("班级：");
				    taInfo.append(rs.getString("classno")+"\n");
				    taInfo.append("备注：");
				    taInfo.append(rs.getString("other")+"\n");
				    }
				    rs.close();
				    stmt.close();
				    conn.close();
				}catch(Exception ee)
				{
			
				ee.printStackTrace();
				}
			}
				public static void main(String[] args) {
					Select select=new Select ();
					// TODO 自动生成方法存根
				}
		 }