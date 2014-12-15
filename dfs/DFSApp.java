package dfs;

public class DFSApp {
	public static void main(String[] args) {
		Graph theGraph=new Graph();
		theGraph.addVertex('A');//位置为0
		theGraph.addVertex('B');//位置为1
		theGraph.addVertex('C');//位置为2
		theGraph.addVertex('D');//位置为3
		theGraph.addVertex('E');//位置为4
		theGraph.addVertex('F');//位置为5
		theGraph.addVertex('G');//位置为6
		theGraph.addVertex('H');//位置为7
		theGraph.addVertex('I');//位置为8
		theGraph.addVertex('J');//位置为9
		theGraph.addVertex('K');//位置为10
		theGraph.addEdge(0, 1);
		theGraph.addEdge(0, 4);
		theGraph.addEdge(0, 5);
		theGraph.addEdge(0, 10);
		theGraph.addEdge(1, 2);
		theGraph.addEdge(1, 6);
		theGraph.addEdge(2, 3);
		theGraph.addEdge(5, 7);
		theGraph.addEdge(5, 9);
		theGraph.addEdge(7, 8);
		theGraph.addEdge(8, 9);
		System.out.println("DFS visit result：");
		theGraph.dfs();
	}
}
