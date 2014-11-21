package simlpesort;
/*
 * 排序包括比较数据项的关键字和移动相应的数据项(java中实际上是数据项的引用)
 * 这里的三种排序都假定了数组作为数据存储结构
 * 一般来讲插入排序是三种基本排序里面效果最好的(三种算法的时间级都是O(N^2))
 * 特别是对于基本有序的数据来说，插入排序效果要好的多，因为while总是假,这种情况下时间级为O(N)
 * 一般认为三种排序都是稳定的
 * 选择排序虽然把交换次数降到了最低，但是比较的次数任然很大
 * 三种算法都可以“就地”完成排序，除了初始的数组(数据)外几乎不需要其他的内存空间
 * 三种算法都需要一个临时变量来保存暂时数据项(如swap里面的temp、插入排序的temp)
 */
public class SortApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSort b=new BubbleSort(20);
		b.insert(1);
		b.insert(2);
		b.insert(3);
		b.insert(4);
		b.insert(5);
		b.insert(6);
		b.insert(7);
		b.insert(8);
		b.insert(9);
		b.insert(10);
		b.display();
		b.bubbleSort();
		System.out.println("========after bubbleSort========");
		b.display();
		System.out.println("************************##################************************");
		SelectSort s=new SelectSort(20);
		s.insert(100);
		s.insert(1);
		s.insert(2);
		s.insert(3);
		s.insert(4);
		s.insert(5);
		s.insert(6);
		s.insert(7);
		s.insert(8);
		s.insert(9);
		s.insert(10);
		s.display();
		s.secletSort();
		System.out.println("========after selectSort========");
		s.display();
		
		System.out.println("************************##################************************");
		InsertSort i=new InsertSort(20);
		i.insert(100);
		i.insert(1);
		i.insert(2);
		i.insert(3);
		i.insert(4);
		i.insert(5);
		i.insert(6);
		i.insert(7);
		i.insert(8);
		i.insert(9);
		i.insert(10);
		i.display();
		i.insertSort();
		System.out.println("========after insertSort========");
		i.display();
	}
}
