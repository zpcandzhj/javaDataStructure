package mergesort;

public class RecMergeSortApp {
	public static void main(String[] args) {
		DataArray theArray = new DataArray(10);
		theArray.insert(11);
		theArray.insert(23);
		theArray.insert(123);
		theArray.insert(83);
		theArray.insert(99);
		theArray.insert(78);
		theArray.insert(63);
		theArray.insert(103);
		theArray.insert(13);
		theArray.insert(203);
		System.out.println("原数组如下：");
		theArray.display();
		theArray.mergeSort();
		System.out.println("排序后原数组如下：");
		theArray.display();
	}
}
