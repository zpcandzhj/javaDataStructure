package dfs;
/*
 * 此栈用于深度优先搜寻时，保存访问过的顶点
 */
public class StackX {
	private int size;
	private int[] stackArray;
	private int top;
	public StackX(){
		stackArray=new int[20];
		top=-1;
	}
	
	public void push(int j){
		stackArray[++top]=j;
	}
	
	public int pop(){
		return stackArray[top--];
	}
	
	public int peek(){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
}


