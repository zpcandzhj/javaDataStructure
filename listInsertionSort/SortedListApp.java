package listInsertionSort;

/*
 * 和基于数组的插入排序相比,表插入排序有个缺点即要开辟差不多两倍的空间：数组和链表必须同时存在内存中
 */
public class SortedListApp {
	public static void main(String[] args) {
		int size = 10;
		Link[] linkArray = new Link[size];
		for (int j = 0; j < size; j++) {
			int n = (int) (Math.random() * 99);
			Link newLink = new Link(n);
			linkArray[j] = newLink;
		}
		// 输出排序前的数组内容
		System.out.println("unsortedArray:");
		for (int i = 0; i < linkArray.length; i++) {
			System.out.print(linkArray[i].dData + " ");
		}
		System.out.println("");

		// 利用数组初始化 一个有序链表
		SortedList theList = new SortedList(linkArray);
		for (int i = 0; i < linkArray.length; i++) {
			linkArray[i] = theList.remove();
		}

		// 输出排序后的数组内容
		System.out.println("sortedArray:");
		for (int i = 0; i < linkArray.length; i++) {
			System.out.print(linkArray[i].dData + " ");
		}
		System.out.println("");

	}
}
