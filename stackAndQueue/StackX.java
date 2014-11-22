package stackAndQueue;

/*
 * 不管其他语言中栈的实现如何，在java中栈只是一个逻辑的概念,可以用数组、链表实现
 * 栈是一种满足如下面的ADT定义的数据结构
 * 本程序用数组作为栈的内部存储，所以要先规定栈的容量，如果使用链表来实现栈就不需要
 */
public class StackX {
	private int maxSize;
	private long stackArray[];
	private int top;

	public StackX(int max) {
		maxSize = max;
		stackArray = new long[max];
		top = -1;
	}

	public void push(long value) {
		if (isFull()) {
			System.out.println("栈已满！");
			System.exit(0);
		}
		stackArray[++top] = value;
	}

	//这个方法有效地从栈中移除了数据项,虽然数据任然存在数组中(直到有新的数据项压入栈中覆盖这个数据项)
	//但是不能再访问它了（java中如此别的不清楚）
	public long pop() {
		if (isEmpty()) {
			System.out.println("栈已空！");
			System.exit(0);
		}
		return stackArray[top--];
	}

	public long peek() {
		return stackArray[top];
	}

	public boolean isFull() {
		return top == maxSize-1;
	}

	public boolean isEmpty() {
		return top == -1;
	}
}
