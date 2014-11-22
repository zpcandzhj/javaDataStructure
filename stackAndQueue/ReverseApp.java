package stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseApp {
public static void main(String[] args) throws IOException {
	String input;
	WordReverser  wr;
	String output;
	while(true){
		System.out.println("请输入一个单词：");
		System.out.flush();
		 input=ReverseApp.getString();
		 if(input.equals("exit")){
			 break;
		 }
		 wr=new WordReverser(input);
		 output=wr.doReverse();
		 System.out.println(input+"逆序输出:"+output+"");
	}
}

public static  String getString() throws IOException{
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader bfr=new BufferedReader(isr);
	String s=bfr.readLine();
	return s;
}
}
