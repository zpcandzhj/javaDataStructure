package dfs;
/*
 * 基于邻接矩阵(二维数组)的图结构实现
 * 采用深度优先(DFS)遍历
 */
public class Graph {
	private final int MAX_NUM=20;
	private Vertex[] vertexList;//保存顶点
	private int adjMatrix[][];//保存边的关系
	private int nVerts;//保存当前图中顶点数
	private StackX theStack;//用于在dfs搜索过程中保存顶点
	
	public Graph(){
		vertexList=new Vertex[MAX_NUM];
		adjMatrix=new int[MAX_NUM][MAX_NUM];
		nVerts=0;
		for(int i=0;i<MAX_NUM;i++){//邻接矩阵赋初值
			for(int j=0;j<MAX_NUM;j++){
				adjMatrix[i][j]=0;
			}
		}
		theStack=new StackX();
	}
	
	public void addVertex(char b){
		vertexList[nVerts++]=new Vertex(b);
	}
	
	public void addEdge(int start,int end){
		adjMatrix[start][end]=1;
		adjMatrix[end][start]=1;
	}
	
	public void displayVertex(int v){
		System.out.print(vertexList[v].label+" ");
	}
	
	public void dfs(){
		vertexList[0].wasVisited=true;
		displayVertex(0);
		theStack.push(0);
		while(!theStack.isEmpty()){
			int v=getAdjUnvisitedVertex(theStack.peek());
			if(v==-1){
				theStack.pop();//目标顶点没有未访问的邻接点了
			}else{
				vertexList[v].wasVisited=true;
				displayVertex(v);
				theStack.push(v);
			}
		}
		//------遍历完成,清除所有访问标志位--------
		for(int i=0;i<nVerts;i++){
			vertexList[i].wasVisited=false;
		}
	}
	//-------返回下标为v的顶点的一个未曾访问过的邻接点-------
	public int getAdjUnvisitedVertex(int v){
		for(int i=0;i<nVerts;i++){
			if(adjMatrix[v][i]==1&&vertexList[i].wasVisited==false){
				return i;
			}
		}
		return -1;
	}
	
}

