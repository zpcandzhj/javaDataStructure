package java234tree;
/*
 * Node类包括两个数组：childArray和itemArray
 * 第一个数组有四个数据单元，保存节点的所有子节点的引用
 * 第二个数组有三个数据单元保存节点包含的DataItem类型对象的引用
 */
public class Node {
	private static final int ORDER=4;//四个子节点数据单元
	private int numItems;//保存节点中数据项的个数
	private Node parent;//指向节点的父节点的引用
	private Node childArray[]=new Node[ORDER];
	private DataItem itemArray[]=new DataItem[ORDER-1];
	
	//把一个子节点连接到该节点
	public void connectChild(int childNum,Node child){
		childArray[childNum]=child;
		if(child!=null){
			child.parent=this;
		}
	}
	
	//释放一个节点的子节点,并返回它
	public Node disConnectChild(int childNum){
		Node temp=childArray[childNum];
		childArray[childNum]=null;
		return temp;
	}
	
	//获取该节点的指定child节点
	public Node getChild(int childNum){
		return childArray[childNum];
	}
	
	public Node getParent(){
		return parent;
	}
	
	public boolean isLeaf(){
		return (childArray[0]==null)? true:false;
	}
	
	public int getNumItems(){
		return numItems;
	}
	
	//获取指定index的数据项
	public DataItem getItem(int index){
		return itemArray[index];
	}
	
	//判断一个节点的数据项域是否填满
	public boolean isFull(){
		return (numItems==ORDER-1)?true:false;
	}
	
	//查找关键字的项
	public int findItem(long key){
		for(int j=0;j<ORDER-1;j++){
			if(itemArray[j]==null)break;
			else if(itemArray[j].dData==key)return j;
		}
		return -1;//没找到
	}
	
	//向一个节点插入数据项,要考虑如何移动数据项,返回插入位置index
	public int insertItem(DataItem newItem){
		//假设节点不满,在调用此方法处先调用isFull()
		numItems++;
		long newKey=newItem.dData;
		/* 在itemArray中寻找插入位置考虑如何移动数据项
		 * 从节点的右边开始寻找,检查itemArray每一项,
		 * 如果最右边的是空,则向左搜索
		 */
		for(int j=ORDER-2;j>=0;j--)
		{
			if(itemArray[j]==null)continue;
			else{
				long itsKey=itemArray[j].dData;
				if(newKey<itsKey)
					itemArray[j+1]=itemArray[j];//移动
				else{
					//不用移动了,直接插入
					itemArray[j+1]=newItem;
					return j+1;
				}
			}
		}
		//到了这一步就已经移动了所有数据项了,直接在开头插入
		itemArray[0]=newItem;
		return 0;
	}
	
	//删除最大项,用于在分裂节点时使用
	public DataItem removeItem(){
		//假设节点不为空
		DataItem temp=itemArray[numItems-1];
		itemArray[numItems-1]=null;
		numItems--;
		return temp;
	}
	
	public void displayNode(){
		for(int j=0;j<numItems;j++){
			itemArray[j].displayItem();
		}
		System.out.println("/");
	}
}








