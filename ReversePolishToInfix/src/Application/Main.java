package Application;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		System.out.println("Reverse Polish Notation to Infix notation");
		System.out.println("-----------------------------------------");
		try {
			Scanner scanner = new Scanner(System.in);
			String postFixExpression = scanner.nextLine();
			String infixExpression = GetInfixFromReversePolish(postFixExpression);
			System.out.println("The Infix expression is "+infixExpression);
		}catch(Exception exception) {
			System.out.println("Thrown exception is "+exception.getLocalizedMessage());
		}		
	}
	
	private static String GetInfixFromReversePolish(String postFixExpression) {
		Stack<String> stringStack = new Stack<String>();
		
		for(int index = 0; index < postFixExpression.length(); index++) {
			if(IsAnOperator(postFixExpression.charAt(index))) {
				String poppedValue1 = stringStack.pop();
				String poppedValue2 = stringStack.pop();
				String result = poppedValue2 + postFixExpression.charAt(index) + poppedValue1;
				stringStack.push(result);
			}else {
				stringStack.push(postFixExpression.charAt(index)+"");
			}
		}
		
		return stringStack.pop();
	}
	
	private static boolean IsAnOperator(char element) {
		if(element == '*' || element == '+' ||
				element == '/' || element == '-') {
			return true;
		}
		return false;
	}
}
