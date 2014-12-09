package binaryTree;
/*
 * 表示二叉树的结点类
 */
public class Node {
	public int iData;//结点的数据项(key)
	public double dData;
	public Node leftChild;//该节点的左孩子
	public Node rightChild;//该节点的右孩子
	
	public void displayNode(){
		System.out.println("{"+iData+", "+dData+"} ");
	}
	
}
