package stackAndQueue;

public class StackChar {
	private int maxSize;
	private char stackArray[];
	private int top;

	public StackChar(int max) {
		maxSize = max;
		stackArray = new char[max];
		top = -1;
	}

	public void push(char value) {
		if (isFull()) {
			System.out.println("栈已满！");
			System.exit(0);
		}
		stackArray[++top] = value;
	}

	//这个方法有效地从栈中移除了数据项,虽然数据任然存在数组中(直到有新的数据项压入栈中覆盖这个数据项)
	//但是不能再访问它了（java中如此别的不清楚）
	public char pop() {
		if (isEmpty()) {
			System.out.println("栈已空！");
			System.exit(0);
		}
		return stackArray[top--];
	}

	public char peek() {
		return stackArray[top];
	}

	public boolean isFull() {
		return top == maxSize-1;
	}

	public boolean isEmpty() {
		return top == -1;
	}
}
