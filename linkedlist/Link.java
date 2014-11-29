package linkedlist;
//链表中的结点类,主要包含数据项和指向下一个结点的'指针'
public class Link {
	public int iData;
	public double Ddata;
	public Link next;
	
	public Link(int i,double d ){
		iData=i;
		Ddata=d;
		next=null;//刚开始的结点next没有指向
	}
	
	public void displayLink(){
		System.out.println("{"+iData+","+Ddata+"}");
	}
}
