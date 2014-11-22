package stackAndQueue;
/*
 * 利用栈来检测一个字符串中的分隔符（括号）
 * 每遇到一个左括号将其进栈,每遇到一个右括号将其与栈顶元素比较,不同就报错
 */
public class BracketChecker {
	private String input;

	public BracketChecker(String in) {
		input = in;
	}

	public void check() {
		int len = input.length();
		StackChar sc = new StackChar(len);
		for (int i = 0; i < len; i++) {
			char c = input.charAt(i);
			switch (c) {
			case '{':
			case '[':
			case '(':
				sc.push(c);
				break;
			case '}':
			case ']':
			case ')':
				if (!sc.isEmpty()) {
					char chx=sc.pop() ;
					if ((c == '}' && chx!= '{')
							|| (c == ']' &&chx != '[')
							|| (c == ')' &&chx!= '('))
						System.out.println("Error1:" + c + " at:" + i);
				} else {
					System.out.println("Error2:" + c + " at:" + i);
				}
				break;
			default:
				break;
			}
		}
		if (!sc.isEmpty()) {
			System.out.println("缺少右括号！");
		}
	}
}
