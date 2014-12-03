package recursion;

/*
 * 基于递归实现的二分查找
 * 递归的二分查找和非递归的同样的大O效率即O(logN)
 * 递归的二分查找可能简洁一些但是速度可能会慢一些
 */
public class BinarySearchArray {
	private long[] a;
	private int nums;

	public BinarySearchArray(int max) {
		a = new long[max];
		nums = 0;
	}

	public int size() {
		return nums;
	}

	// 因为二分查找是针对有序数据的,所以插入时要有序
	public void insert(long val) {
		int i;
		for (i = 0; i < nums; i++) {
			if (val < a[i])
				break;
		}
		for (int j = nums; j > i; j--) {
			a[j] = a[j - 1];
		}
		a[i] = val;
		nums++;
	}

	// 客户端直接调用private的find方法,而不需要指明lower和upper
	public int find(long seachKey) {
		return recFind(seachKey, 0, nums - 1);
	}

	// 通过private的recFind来避免给客户端程序员暴露太多细节
	private int recFind(long seachKey, int lowerBound, int upperBound) {
		int curIn;
		curIn = (lowerBound + upperBound) / 2;
		if (a[curIn] == seachKey)
			return curIn;
		if (lowerBound > upperBound)
			return nums;// 没找到
		if (seachKey > a[curIn]) {
			return recFind(seachKey, curIn + 1, upperBound);
		} else {
			return recFind(seachKey, lowerBound, curIn - 1);
		}
	}

	public void display() {
		for (int i = 0; i < nums; i++) {
			System.out.print(" a[" + i + "]:" + a[i]);
		}
		System.out.println("");
	}
}
