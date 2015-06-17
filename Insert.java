package cn.lntu.t24;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

	public class Insert extends JFrame {
		
		private JPanel ContentPane;
		private JLabel jlab1 = new JLabel();
		private JLabel jlab2 = new JLabel();
		private JLabel jlab3 = new JLabel();
		private JLabel jlab4 = new JLabel();
		private JLabel jlab5 = new JLabel();
		private JLabel jlab6= new JLabel();
		private JLabel jlab7 = new JLabel();
		private JLabel jlab8 = new JLabel();
		private JTextField jtextfield1 = new JTextField();
		private JTextField jtextfield2 = new JTextField();
		private JTextField jtextfield3 = new JTextField();
		private JTextField jtextfield4 = new JTextField();
		private JTextField jtextfield5 = new JTextField();
		private JComboBox jcombobox1 = new JComboBox();
		private JComboBox jcombobox2 = new JComboBox();
		private JTextArea jtextarea = new JTextArea();
		private JButton sure = new JButton();
	
		public  Insert()
		{
			this.setBounds(320,160,450,450);
			this.setTitle("添加学生信息");//窗体标题
		    ContentPane =(JPanel)this.getContentPane();//将容器转化为JPanel
		    ContentPane.setLayout(null);//设置可更改性
		    ContentPane.setBackground(Color.black);
			jlab1.setText("学号");
			jlab1.setBounds(new Rectangle(30, 11, 51, 33));
			jlab1.setForeground(Color.white);
			jlab2.setText("姓名");
			jlab2.setBounds(new Rectangle(162, 11, 28, 33));
			jlab2.setForeground(Color.white);
			jlab3.setText("性别");
			jlab3.setBounds(new Rectangle(241, 11, 28, 33));
			jlab3.setForeground(Color.white);
			jlab4.setText("出生日期");
			jlab4.setBounds(new Rectangle(31, 53, 55, 33));
			jlab4.setForeground(Color.white);
			jlab5.setText("身份证号");
			jlab5.setBounds(new Rectangle(163, 94, 55, 33));
			jlab5.setForeground(Color.white);
			jlab6.setText("班级");
			jlab6.setBounds(new Rectangle(163, 53, 26, 33));
			jlab6.setForeground(Color.white);
			jlab7.setText("专业");
			jlab7.setBounds(new Rectangle(30, 94, 50, 33));
			jlab7.setForeground(Color.white);
			jlab8.setText("自我介绍");
			jlab8.setBounds(new Rectangle(30, 120, 66, 33));
			jlab8.setForeground(Color.white);
			jtextfield1.setText("");//学号
			jtextfield1.setBounds(new Rectangle(86, 16, 74, 22));
			jtextfield2.setText("");//姓名
			jtextfield2.setBounds(new Rectangle(192, 16, 44, 22));
			jtextfield3.setText("");//出生日期
			jtextfield3.setBounds(new Rectangle(86, 58, 74, 22));
			jtextfield4.setText("");//班级
			jtextfield4.setBounds(new Rectangle(191, 58, 44, 22));
			jtextfield5.setText("");//身份证号
			jtextfield5.setBounds(new Rectangle(230, 98, 158, 22));
			jcombobox1.setBounds(new Rectangle(275, 15, 50, 25));
			jcombobox1.addItem("男");
			jcombobox1.addItem("女");
			jcombobox1.setForeground(Color.black);
			jcombobox1.setBackground(Color.white);
			jcombobox2.setBounds(new Rectangle(86, 98, 75, 25));
			jcombobox2.addItem("软件");
			jcombobox2.addItem("工商");
			jcombobox2.addItem("电信");
			jcombobox2.addItem("电控");
			jcombobox2.addItem("营销");
			jcombobox2.addItem("安全");
			jcombobox2.setForeground(Color.black);
			jcombobox2.setBackground(Color.white);
			jtextarea.setText("");
			jtextarea.setBounds(new Rectangle(84, 139, 285, 92));
			sure.setText("添加");//设置命令按钮
			sure.setBounds(new Rectangle(156, 244, 89, 22));
			sure.addActionListener(new sure_actionperformed());//设置动作监听
	
			ContentPane.add(jlab1);
			ContentPane.add(jlab2);
			ContentPane.add(jlab3);
			ContentPane.add(jlab4);
			ContentPane.add(jlab5);
			ContentPane.add(jlab6);
			ContentPane.add(jlab7);
			ContentPane.add(jlab8);
			ContentPane.add(jtextfield1);
			ContentPane.add(jtextfield2);
			ContentPane.add(jtextfield3);
			ContentPane.add(jtextfield4);
			ContentPane.add(jtextfield5);
			ContentPane.add(jcombobox1);
			ContentPane.add(jcombobox2);
			ContentPane.add(jtextarea);
			ContentPane.add(sure);
	
			this.setVisible(true);//设置可见性
		}
		
		class sure_actionperformed implements ActionListener //设置动作按钮的监听
		{
			public void actionPerformed(ActionEvent e) //创建方法
			{  
			
				try{
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/studentmanager";
				String user="root";    
				String password="123456";    
				Connection conn= DriverManager.getConnection(url,user,password);
				Statement stmt=conn.createStatement();
				String SQL="insert into student(stuno,stuname,stusex,birthdate,stuid,majname,classno,other)   values('"+jtextfield1.getText()+"',   '"+jtextfield2.getText()+"',    '"+jcombobox1.getSelectedItem()+"',    '"+jtextfield3.getText()+"',     '"+jtextfield5.getText()+"',   '"+jcombobox2.getSelectedItem()+"',    '"+jtextfield4.getText()+"', '"+jtextarea.getText()+"')";
			     stmt.executeUpdate(SQL);
			     JOptionPane.showMessageDialog(null, "添加信息成功!");
			     jtextfield1.setText("");
		  			jtextfield2.setText("");
		  			jtextfield3.setText("");
		  			jtextfield4.setText("");
		  			jtextfield5.setText("");
		  			jtextarea.setText("");
				}
			catch(Exception ee)
			{ee.printStackTrace();
			    jtextfield1.setText("");
	  			jtextfield2.setText("");
	  			jtextfield3.setText("");
	  			jtextfield4.setText("");
	  			jtextfield5.setText("");
	  			jtextarea.setText("");
	  			
	  			
//				ee.printStackTrace();
			}
		}
	    }
		public static void main(String[] args) {
			Insert insert=new Insert ();
			// TODO 自动生成方法存根
		}
		}