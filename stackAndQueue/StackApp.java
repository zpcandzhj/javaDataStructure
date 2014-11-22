package stackAndQueue;

public class StackApp {
	public static void main(String[] args) {
		StackX theStack=new StackX(10);
		System.out.println("theStack.isEmpty():"+theStack.isEmpty());
		theStack.push(13);
		theStack.push(23);
		theStack.push(33);
		theStack.push(43);
		theStack.push(63);
		theStack.push(73);
		theStack.push(73);
		theStack.push(813);
		theStack.push(183);
		theStack.push(113);
		System.out.println("############after push################ ");
		System.out.println("theStack.isFull()"+theStack.isFull());
		System.out.println("theStack.pop():"+theStack.pop());
		System.out.println("theStack.peek():"+theStack.peek());
		while(!theStack.isEmpty()){
			long value=theStack.pop();
			System.out.print(value+" ");
		}
		System.out.println();
		System.out.println("theStack.isFull():"+theStack.isFull());
		System.out.println("theStack.isEmpty():"+theStack.isEmpty());
		
		
	}
	
}
