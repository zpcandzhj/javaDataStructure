package hashchain;

import java.io.*;

public class HashChainApp {
	public static void main(String[] args) throws IOException {
		int aKey;
		int size, n, keysPerCell = 100;
		Link aDataItem;
		// --------控制台输入哈希表的初始配置---------
		System.out.print("Enter the size of hashTable:");
		size = getInt();
		System.out.print("Enter initial number of items:");
		n = getInt();

		HashTable theHashTable = new HashTable(size);
		// -------初始化--------------
		for (int j = 0; j < n; j++) {
			aKey = (int) (Math.random() * keysPerCell * size);
			aDataItem = new Link(aKey);
			theHashTable.insert(aDataItem);
		}

		// -------和用户交互的主程序---------
		while (true) {
			System.out
					.print("Enter first letter of show,insert,delete,find or exit:");
			char choice = getChar();
			switch (choice) {
			case 's':
				theHashTable.displayTable();
				break;
			case 'i':
				System.out.print("Enter the value to insert:");
				aKey = getInt();
				aDataItem = new Link(aKey);
				theHashTable.insert(aDataItem);
				break;
			case 'd':
				System.out.print("Enter the value to delete:");
				aKey = getInt();
				boolean res = theHashTable.delete(aKey);
				if (res == true)
					System.out.println("delete " + aKey + " complete!");
				else
					System.out.println("Can't found:" + aKey
							+ " delete failed!");
				break;
			case 'f':
				System.out.print("Enter the value to find:");
				aKey = getInt();
				aDataItem = theHashTable.find(aKey);
				if (aDataItem != null)
					System.out.println("Found:" + aKey);
				else
					System.out.println("Can't found:" + aKey);
				break;
			case 'e':
				System.exit(0);
			default:
				System.out.println("Invalid entry!");
				break;
			}
		}
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}

	public static char getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}
}
