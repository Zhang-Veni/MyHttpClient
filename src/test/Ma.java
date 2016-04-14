package test;

import java.sql.SQLException;

public class Ma implements If{

public  Ma() {
		// TODO Auto-generated constructor stub
	System.out.println("单例模式");
	}
public void f()throws SQLException
{
	
}
public void other()
{
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If t=new Ma();
		((Ma) t).other();
	}

}
