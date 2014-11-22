package stackAndQueue;
/*
 * 利用栈实现将一个单词的字符逆序输出
 */
public class WordReverser {
	private String input;
	private String output;
	public WordReverser(String in){
		input=in;
	}
	
	public String doReverse(){
		int stackSize=input.length();
		StackChar sc=new StackChar(stackSize);
		for(int i=0;i<stackSize;i++){
			sc.push(input.charAt(i));
		}
		output="";
		while(!sc.isEmpty()){
			output+=sc.pop();
		}
		return output;
	}
}
