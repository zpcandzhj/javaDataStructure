package listInsertionSort;

/*
 * 表插入排序
 * 有序链表可以用作一种高效的排序机制
 * 假设有一个无序数组,从这个数组中取出数据然后一个个地插入有序链表,它们将自动排序
 * 将它们从有序链表中删除,重新放入数组,那么数组就排序好了 
 */
public class SortedList {
	private Link first;

	public SortedList() {
		first = null;
	}

	public SortedList(Link[] linkArray) {
		first = null;
		for (int i = 0; i < linkArray.length; i++) {
			insert(linkArray[i]);
		}
	}

	// 此时插入的就直接是结点元素
	public void insert(Link val) {
		Link current = first;
		Link previous = null;
		while (current != null && current.dData < val.dData) {// val在表尾的时候会遇到current=null
			previous = current;
			current = current.next;
		}
		// 如果是空表或者插入元素在表头
		if (previous == null) {
			first = val;
		} else {
			previous.next = val;
		}
		val.next = current;
	}

	// 从有序链表中删除,返回值重新放入数组,那么数组就是排序好了的
	public Link remove() {
		Link temp = first;
		first = first.next;
		return temp;
	}
}
