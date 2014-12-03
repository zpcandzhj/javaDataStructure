package recursion;

/* 一个递归的方法就是每次用不同的参数值反复调用自身
 * 某种参数的值使递归的方法返回，而不再调用自身，这称为基值的情况
 * 当递归的方法返回时，递归过程通过逐渐完成各层方法实例的未执行部分，从最内层返回到最外层的原始调用处
 * 使用递归解决三角数字问题
 * 三角数字序列：1,3,6,10,15,21
 * 注意：人们常常使用递归,是因为它从概念上简化了问题,而不是因为本质上它更有效率
 */
import java.io.*;

public class Triangle {
	public static void main(String[] args) throws IOException {
		System.out.println("please enter a number:");
		int theNumber = getInt();
		int theAnswer = triangle(theNumber);
		System.out.println("Triangle(" + theNumber + "):" + theAnswer);
	}

	public static int triangle(int n) {
		System.out.println("Entering: n=" + n);
		if (n == 1) {
			System.out.println("Returning 1");
			return 1;
		} else {
			int temp = n + triangle(n - 1);
			System.out.println("Returning " + temp);
			return temp;
		}
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}

}
