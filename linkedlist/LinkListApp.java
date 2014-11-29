package linkedlist;

public class LinkListApp {
	public static void main(String[] args) {
		LinkList linklist = new LinkList();
		System.out.println("linklist.isEmpty()?:" + linklist.isEmpty());
		linklist.insert(1, 111);
		linklist.insert(2, 222);
		linklist.insert(3, 333);
		linklist.insert(4, 444);
		linklist.insert(5, 555);
		linklist.displayList();
		while (!linklist.isEmpty()) {
			Link alink = linklist.remove();
			System.out.print("Deleted:");
			alink.displayLink();
		}
		linklist.displayList();
		System.out.println("linklist.isEmpty()?:" + linklist.isEmpty());
		System.out
				.println("===================================================");
		linklist.insert(6, 226);
		linklist.insert(7, 337);
		linklist.insert(8, 228);
		linklist.insert(9, 339);
		linklist.displayList();

		int key = 11;
		System.out.print("linklist.find(" + key + ")");
		Link temp = linklist.find(7);
		if (temp != null)
			temp.displayLink();
		else
			System.out.println("查无此项！");

		System.out.print("linklist.delete(" + key + ")");
		temp = linklist.delete(key);
		if (temp != null)
			temp.displayLink();
		else
			System.out.println("查无此项，删除失败！");
		System.out
				.println("======================删除操作后=======================");
		linklist.displayList();

		
		System.out.println("=========测试本机耗尽内存能容纳多少结点=========");
		int count = 0;
		int val1 = 0;
		int val2 = 0;
		while (true) {
			val1 = (int) (Math.random() * 100000);
			val2 = (int) (Math.random() * 100000);
			linklist.insert(val1, val2);
			count++;
			if (count % 1000000 == 0) {
				//linklist.displayList();
				System.out.println("count=" + count);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("count=" + count);
					e.printStackTrace();
				}
			}
		}

	}
}
