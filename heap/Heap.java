package heap;
/*
 * 基于数组实现的堆(当然也可以用真正的树来实现堆)
 * 堆的实现通过构造二叉堆（binary heap），实为二叉树的一种
 * 由于其应用的普遍性，当不加限定时，均指该数据结构的这种实现。
 * 这种数据结构具有以下性质：
 * (1)任意节点大(小)于它的所有后裔，最大(小)元在堆的根上（堆序性）。
 * (2)堆总是一棵完全树。
 * (3)堆通常用一个数组实现。
 *  将根节点最大的堆叫做最大堆或大根堆，根节点最小的堆叫做最小堆或小根堆。
 */
public class Heap {
	private Node[] heapArray;//元素的存储机制还是基于数组的
	private int maxSize;
	private int currentSize;
	public Heap(int mx){
		maxSize=mx;
		currentSize=0;
		heapArray=new Node[maxSize];
	}
	//---------判断堆是否为空--------
	public boolean isEmpty(){
		return currentSize==0;
	}
	//---------插入元素操作----------
	public boolean insert(int key){
		if(currentSize==maxSize)
			return false;
		Node newNode =new Node(key);
		heapArray[currentSize]=newNode;//插入元素首先是插入到数组尾的,所以要进行上调
		trickUp(currentSize++);
		return true;
	}
	//---------插入元素首先是插入到数组尾的,所以要进行上调--------
	/* 上调函数,参数是数组元素的下标,都是从currentSize(即刚插入的元素处)处开始调
	 * 比较被调整元素的父节点与该元素的关键字大小,如果大于父节点关键字值,就把父节点往下调，直到不满足条件
	 * 最后把被调的元素安放到目标位置
	 */
	public void trickUp(int index){
		int parent=(index-1)/2;
		Node bottom=heapArray[index];
		while(index>0&&bottom.getKey()>heapArray[parent].getKey()){
			heapArray[index]=heapArray[parent];
			index=parent;
			parent=(index-1)/2;//或者parent=(parent-1)/2;
		}
		heapArray[index]=bottom;
	}
	//-------------出堆(删除元素)操作-----------
	public Node remove(){
		Node root =heapArray[0];
		heapArray[0]=heapArray[--currentSize];//把最后一项放到堆顶
		trickDown(0);
		return root;
	}
	//--------出堆时要把数组最后一个元素放到堆顶,自然要进行下移操作---------
	/* 下移函数,参数是数组元素的下标,都是从0(即堆顶处)处开始调
	 * 只要index<currentSize/2(index标识的节点至少有一个孩子)就进行下去
	 */
	public void trickDown(int index){
		int largerChild;
		Node top=heapArray[index];
		while(index<currentSize/2){
			int leftChild=2*index+1;
			int rightChild=leftChild+1;
			if(rightChild<currentSize&&heapArray[leftChild].getKey()<heapArray[rightChild].getKey()){//最后一个节点的rightChild不一定存在的
				largerChild=rightChild;
			}else{
				largerChild=leftChild;
			}
			if(top.getKey()>heapArray[largerChild].getKey()){
				break;
			}
			heapArray[index]=heapArray[largerChild];//元素上移
			index=largerChild;
		}
		heapArray[index]=top;
	}
	//------------调整元素的优先级---------------
	//参数为要调整的数组元素下标index,新的优先级值
	public boolean changePriority(int index,int newValue){
		if(index<0||index>=currentSize){
			return false;
		}
		int oldValue=heapArray[index].getKey();
		heapArray[index].setKey(newValue);
		if(newValue<oldValue){
			trickDown(index);
		}else{
			trickUp(index);
		}
		return true;
	}
	
	//--------以树形的方式显示堆---------
	 public void displayHeap()
     {
     System.out.print("heapArray: ");    // array format
     for(int m=0; m<currentSize; m++)
        if(heapArray[m] != null)
           System.out.print( heapArray[m].getKey() + " ");
        else
           System.out.print( "-- ");
     System.out.println();
                                         // heap format
     int nBlanks = 32;
     int itemsPerRow = 1;
     int column = 0;
     int j = 0; //在循环内部起作用的                         // current item
     String dots = "...............................";
     System.out.println(dots+dots);      // dotted top line

     while(currentSize > 0)              // for each heap item
        {
        if(column == 0)                  // first item in row?
           for(int k=0; k<nBlanks; k++)  // preceding blanks
              System.out.print(' ');
                                         // display item
        System.out.print(heapArray[j].getKey());

        if(++j == currentSize)           // done?
           break;

        if(++column==itemsPerRow)        // end of row?
           {
           nBlanks /= 2;                 // half the blanks
           itemsPerRow *= 2;             // twice the items
           column = 0;                   // start over on
           System.out.println();         //    new row
           }
        else                             // next item on row
           for(int k=0; k<nBlanks*2-2; k++)
              System.out.print(' ');     // interim blanks
        }  // end for
     System.out.println("\n"+dots+dots); // dotted bottom line
     }  // end displayHeap()
	 
}

