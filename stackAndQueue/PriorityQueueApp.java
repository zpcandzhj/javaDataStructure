package stackAndQueue;

public class PriorityQueueApp {
	public static void main(String[] args) {
		PriorityQueue queue=new PriorityQueue(10);
		System.out.println("queue.isEmpty():"+queue.isEmpty());
		queue.insert(12);
		queue.insert(22);
		queue.insert(32);
		queue.insert(42);
		queue.insert(92);
		queue.insert(82);
		queue.insert(72);
		queue.insert(62);
		queue.insert(52);
		queue.insert(102);
		System.out.println("queue.peekMin():"+queue.peekMin());
		System.out.println("queue.isFull():"+queue.isFull());
		while(!queue.isEmpty()){
			System.out.print(" "+queue.remove());
		}
		System.out.println("\nqueue.isEmpty():"+queue.isEmpty());
	}
}
