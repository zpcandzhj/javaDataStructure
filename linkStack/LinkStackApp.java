package linkStack;
/*
 * 栈是一种抽象的数据结构
 * 使用基于链表的LinkStack还是使用基于数组的Stack类来书写main方法中的代码,
 * 对与使用者来说是没有分别的
 */
public class LinkStackApp {
	public static void main(String[] args) {
		LinkStack theStack = new LinkStack();
		System.out.println("theStack.isEmpty():" + theStack.isEmpty());
		theStack.push(11);
		theStack.push(12);
		theStack.push(13);
		theStack.push(14);
		theStack.pop();
		theStack.displayStack();
	}
}
