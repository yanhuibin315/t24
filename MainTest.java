package cn.lntu.t24;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class MainTest extends JFrame{
	/**************声明变量************/
	private JPanel ContentPane;
	private JButton Insert = new JButton();
	private JButton Select = new JButton();
	private JButton Update = new JButton();
	public MainTest()
	{
		ContentPane = (JPanel)this.getContentPane();
	    ContentPane.setLayout(null);
	    this.setTitle("学生管理系统");
	    this.setBounds(100,200,500,300);
	    ContentPane.setBackground(Color.WHITE);
		/*********3个按钮的设置********/
		Insert.setText("添加学生信息");
		Insert.setVisible(false);
		Insert.setBounds(new Rectangle(70, 50, 120, 33));
		Insert.addActionListener(new MainTest_actionPerformed(this));//加事件监听
		Insert.setForeground(Color.white);
		Insert.setBackground(Color.black);
		Update.setText("修改学生信息");
		Update.setVisible(false);
		Update.setBounds(new Rectangle(210, 50,120, 33));
		Update.addActionListener(new MainTest_actionPerformed(this));//加事件监听
		Update.setForeground(Color.white);
		Update.setBackground(Color.black);
		Select.setText("查询学生信息");
		Select.setVisible(false);
		Select.setBounds(new Rectangle(340, 50, 120, 33));
		Select.addActionListener(new MainTest_actionPerformed(this));//加事件监听
		Select.setForeground(Color.white);
        Select.setBackground(Color.black);
		/*******把控件添加到面板中去*******/
		ContentPane.add(Insert);
		ContentPane.add(Update);
		ContentPane.add(Select);
		this.setVisible(true);
		Insert.setVisible(true);
		Update.setVisible(true);
		Select.setVisible(true);               	
	}
	/**********设置动作按钮的监听事件***********/
	class jenter_actionPerformed implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
                    	//设置3个按钮的可见性
                    	Insert.setVisible(true);
                    	Update.setVisible(true);
                    	Select.setVisible(true);            	
		}
	}
  /***********主窗口的监听事件**************************/
	class MainTest_actionPerformed implements ActionListener
	{
		MainTest adapte ;
		MainTest_actionPerformed(MainTest adapte)
		{
			this.adapte = adapte;
		}
		public void actionPerformed(ActionEvent e)
		{
			/*调用窗口程序*/
			if(e.getSource()==adapte.Insert)
			{
				Insert insert = new Insert();
			}
			else if(e.getSource()==adapte.Update)
			{
				Update update = new Update();
			}
			else if(e.getSource()==adapte.Select)
			{
				Select select = new Select();
			}
		}
	}
	public static void main(String[] args) {
		MainTest maintest=new MainTest ();
		// TODO 自动生成方法存根
	}
}