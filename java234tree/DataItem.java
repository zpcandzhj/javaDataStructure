package java234tree;
/*
 * 2-3-4树这种数据结构的结点是用来存放数据项的
 * DataItem类的对象表示存储在节点中的数据项,实际生活中的数据项对象可以表示一个
 * 完整的档案或目录的内容，这里简便起见只存一条long类型的数据
 */
public class DataItem {
	public long dData;
	
	public DataItem(long dd){
		dData=dd;
	}
	public void displayItem(){
		System.out.print("/"+dData);
	}
}
