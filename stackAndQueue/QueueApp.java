package stackAndQueue;

public class QueueApp {
	public static void main(String[] args) {
		Queue queue = new Queue(10);
		System.out.println("queue.isEmpty(): " + queue.isEmpty());
		queue.insert(12);
		queue.insert(22);
		queue.insert(32);
		queue.insert(42);
		queue.insert(52);
		queue.insert(62);
		queue.insert(72);
		queue.insert(82);
		queue.insert(92);
		queue.insert(102);
		queue.insert(2222);
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.insert(13);
		queue.insert(23);
		queue.insert(33);
		queue.insert(112);
		queue.insert(132);
		queue.insert(4444);
		System.out.println("queue.isFull(): " + queue.isFull());
		queue.display();
		while (!queue.isEmpty()) {
			System.out.print(queue.remove());
		}
		queue.remove();
	}
}
