package linkStack;

public class Link {
	public long dData;//真实的应用一个节点可能有多种数据项构成
	public Link next;
	public Link(long d){
		dData=d;
		next=null;
	}
	
	public void display(){
		System.out.print(" "+dData);
	}
}
