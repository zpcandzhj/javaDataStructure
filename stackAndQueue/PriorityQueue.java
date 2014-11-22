package stackAndQueue;

/*
 * 优先级队列
 * 优先级队列通常使用堆这种数据结构来实现
 * 本例使用简单的数组实现来实现优先级队列
 * 在数据项个数较少时，数组实现的优先级队列还可以满足要求
 * 数据项很多，速度很重要时用堆实现
 */
public class PriorityQueue {
	private int maxSize;
	private int nums;
	private long[] queArray;

	public PriorityQueue(int max) {
		maxSize = max;
		queArray = new long[max];
		nums = 0;
	}

	public void insert(long value) {
		if (isFull())
			System.out.println("��������");
		else {
			// 如果是第一次插入,那么不用排序,直接插入queArray[0]处
			if (nums == 0) {
				queArray[nums++] = value;
			} else {
				int k;
				for (k = nums - 1; k >= 0; k--) {
					// 下标大的作为队头,本程序中数值小的优先级大，安排在队头
					if (value > queArray[k]) {
						queArray[k + 1] = queArray[k];
					} else
						break;
				}
				queArray[k + 1] = value;
				nums++;
			}
		}
	}

	// 实际上没有删除内存中的值,只是使其访问受限,感觉上被删除了
	public long remove() {
		return queArray[--nums];
	}

	// 返回队头元素,由于是有序队列,可以人为规定一个优先级别(降序或升序)
	public long peekMin() {
		return queArray[nums - 1];
	}

	public boolean isFull() {
		return maxSize == nums;
	}

	public boolean isEmpty() {
		return nums == 0;
	}
}
