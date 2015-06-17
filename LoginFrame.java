package cn.lntu.t24;

import java.awt.*;
import javax.swing.JFrame;

public class LoginFrame extends JFrame {
	 ;
	public LoginFrame(){
		super("User Login");
		this.setSize(200,130);
		this.setLocation(300, 240);
		this.setBackground(Color.lightGray);
		this.setLayout(new FlowLayout());
		this.add(new Label("userid"));
		this.add(new TextField("user1",10));
		this.add(new Label("password"));
		this.add(new TextField(10));
		this.add(new Button("Ok"));
		this.add(new Button("Cancel"));
		this.setVisible(true);
		
	}
	public static void main(String arg[]){new LoginFrame();}

}
