package stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketCheckerApp {
	public static void main(String[] args) throws IOException {
		String input;
		BracketChecker checker;
		String output;
		while(true){
			System.out.println("请输入一个带括号的表达式：");
			System.out.flush();
			 input=getString();
			 if(input.equals("exit")){
				 break;
			 }
			 checker=new BracketChecker(input);
			 checker.check();
		}
	}
	public static  String getString() throws IOException{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader bfr=new BufferedReader(isr);
		String s=bfr.readLine();
		return s;
	}
}
