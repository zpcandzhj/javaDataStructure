package stackAndQueue;

/*
 * 用数组实现队列(循环队列)的数据结构
 */
public class Queue {
	private int maxSize;
	private int front;//队头指针
	private int rear;//队尾指针
	private long[] queArray;// 用数组实现队列的存储
	private int nums;// 存储的元素个数

	public Queue(int max) {
		maxSize = max;
		queArray = new long[maxSize];
		nums = 0;
		front = 0;
		rear = -1;
	}

	public void insert(long value) {
		if (isFull()) {
			System.out.print("队列已满！无法完成插入"+value+"，请执行其他操作！ ");
			System.out.println("插入操作前front位置为：" + front + " rear位置为：" + rear);
		} else {
			System.out.println("插入"+value+",插入操作前front位置为：" + front + " rear位置为：" + rear);
			if (rear == maxSize - 1)
				rear = -1;
			queArray[++rear] = value;
			nums++;
		}

	}

	// 返回被删除的元素
	public long remove() {
		System.out.println("删除队头元素,删除操作前front位置为：" + front + " rear位置为：" + rear);
		if (isEmpty()) {
			System.out.print("队列已空！无法完成删除，请执行其他操作！  ");
			System.out.println("此时front位置为：" + front + " rear位置为：" + rear);
			return 0;
		} else {
			if (front == maxSize)
				front = 0;
			long temp = queArray[front++];
			nums--;
			return temp;
		}
	}

	public long peekFront() {
		return queArray[front];
	}

	public boolean isFull() {
		return nums == maxSize;
	}

	public boolean isEmpty() {
		return nums == 0;
	}

	public int size() {
		return nums;
	}
	
	//显示队列的内容（只是显示内容，而不删除）
		public void display(){
			System.out.println(" 调用了队列的display()函数显示队列内容！");
			if(front>rear){
				for(int j=front;j<maxSize;j++){
					System.out.println("queArray["+j+"]:"+queArray[j]);
				}
				for(int k=0;k<=rear;k++){
					System.out.println("queArray["+k+"]:"+queArray[k]);
				}
			}else{
				for(int i=front;i<=rear;i++){
					System.out.println("queArray["+i+"]:"+queArray[i]);
				}
			}
		}
}
