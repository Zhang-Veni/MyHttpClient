import java.util.Arrays;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] paramArr = new String[] { "zdq137088099", "zhang","qiang" };
		System.out.println(paramArr[0]+paramArr[1]+paramArr[2]);

		Arrays.sort(paramArr);
		System.out.println(paramArr[0]+paramArr[1]+paramArr[2]);
	}

}
