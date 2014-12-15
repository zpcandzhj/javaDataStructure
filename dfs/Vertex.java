package dfs;
/*
 * 图中的顶点类
 */
public class Vertex {
	public char label;
	public boolean wasVisited;
	
	public Vertex(char label){
		this.label=label;
		this.wasVisited=false;
	}
}
