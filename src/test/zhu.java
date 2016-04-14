package test;

public class zhu {
	String sb;
	char liuzhiyuan='\u0000';
	int i=0;
	public zhu() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		zhu z=new zhu();
		System.out.println(z.sb);
		System.out.println((int)z.liuzhiyuan);
		System.out.println((char)z.i);
//		System.out.printf("%",);
		Class<?> ma = null;
try {
	 ma=Class.forName("test.Ma");
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	ma.newInstance();
//	ma.getMethod(name, parameterTypes)
} catch (InstantiationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IllegalAccessException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
