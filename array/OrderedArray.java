package array;

public class OrderedArray {
	private long[] a;
	private int nums;// 表示数据项个数

	public OrderedArray(int max) {
		a = new long[max];
		nums = 0;
	}

	/*
	 * 由于是数据存放是有序的,使用二分查找速度比较快 二分查找算法的速度T和数据项的个数N的关系： T=K*log2(N)
	 * 由于所有的对数都和其他的对数成比例,通常将常数的底也并入K 由此不必指定指数即： T=K*log(N)
	 */
	private int size() {
		return nums;
	}

	public int find(long searchKey) {
		int lowpos = 0;//  为二分查找做准备
		int highpos = nums - 1;
		int center;
		while (true) {
			center = (lowpos + highpos) / 2;
			if (a[center] == searchKey) {
				return center;
			}
			if (lowpos > highpos) {
				return nums;// 返回nums表明没找到
			}
			if (a[center] > searchKey) {
				highpos = center - 1;
			} else {
				lowpos = center + 1;
			}
		}
	}

	// insert1没有采用二分查找，由于数据是有序插入的，有个寻找插入位置的过程
	public void insert1(long value) {
		int i;
		for (i = 0; i < nums; i++) {
			if (a[i] > value) {
				break;
			}
		}
		for (int k =nums; k >i; k--) {
			a[k] = a[k-1];
		}
		a[i] = value;
		nums++;
	}
	//采用二分查找来找插入位置
	public void insert2(long value){
		
		int lowpos = 0;// 为二分查找做准备
		int highpos = nums - 1;
		int center;
		while (true) {
			center = (lowpos + highpos) / 2;
			//正好待插入的值在原数组里存在,直接移动
			if (a[center] == value) {
				for (int k =nums; k >center; k--) {
					a[k] = a[k-1];
				}
				a[center] = value;
				nums++;
				break;
			}
			//待插入的值在原数组里不存在,移动过程和上面一样的其实，都是从center位置动手
			if (lowpos > highpos) {
				for (int k =nums; k >center; k--) {
					a[k] = a[k-1];
				}
				a[center] = value;
				nums++;
				break;
			}
			
			//既没有找到该值，也没有出现lowpos > highpos的情形
			if (a[center] > value) {
				highpos = center - 1;
			} else {
				lowpos = center + 1;
			}
		}
	}
	

	public boolean delete(long value) {
		int k = find(value);
		if (k == nums) {
			return false;
		}
		for (int j = k; j < nums; j++) {
			a[j] = a[j + 1];
		}
		nums--;
		return true;
	}

	public void display() {
		for (int i = 0; i < nums; i++) {
			System.out.println("a[" + i + "]=" + a[i]);
		}
	}

}
