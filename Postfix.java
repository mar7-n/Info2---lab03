package lab03;


import java.util.Objects;

public class Postfix {

	public static void main(String[] args) throws Underflow {
		double random = evaluate("3 3 - 3 -");
		System.out.print(random);
	}

	public static int priority(String u)
	{
		if(u.equals("+")||u.equals("-"))
		{
			return 1;
		}
		if(u.equals("*")||u.equals("/"))
		{
			return 2;
		}
		if(u.equals("^"))
		{
			return 3;
		}
		return 0;
	}

	public String infixToPostfix(String infix) throws Underflow {

		String result = "";
		Stack buffer = new Stack();

		for (int i = 0; i < infix.length(); i++) {
			char a = infix.charAt(i); //считываем каждый элемент строки с индексom i и сохраняем его в а
			if (i == 0) {

				if (a == '*' || a == '/' || a == '^') {
					throw new RuntimeException("Syntax error");
				}
			}
			if (i == infix.length() - 1) {

				if (a == '+' || a == '-' || a == '*' || a == '/' || a == '^') {
					throw new RuntimeException("Syntax error");
				}
			}
			if (a >= 48 && a <= 57 || a >= 65 && a <= 90 || a >= 97 && a <= 122) {
				result = result + " " + a;
			}
			if (a == '(') {
				buffer.push(a + "");
			}
			if (a == ')') {
				while (!Objects.equals(buffer.peek(), "(")) {
					result = result + " " + buffer.pop();

				}
				buffer.pop();
			}
			if (a == '^') {
				buffer.push(a + "");
			}
			if (a == '-' || a == '+' || a == '*' || a == '/') {
				while (!buffer.isEmpty() && buffer.peek() != "(" && priority(a + "") <= priority(buffer.peek())) {
					result = result + " " + buffer.pop();
				}
				buffer.push(a + "");
			}
		}
		while (!buffer.isEmpty()) {
			result = result + " " + buffer.pop();
		}
		return result.substring(1);
	}

	public static double evaluate(String postfix) throws Underflow {
		Stack stack = new Stack();
		String next = postfix.charAt(0) + "";
		for(int i=1;i<postfix.length();i++) {
			char a = postfix.charAt(i);
			if (a < 58 && a > 47) next += a;
			else if (a != ' ') {
				String x = stack.pop();
				String y = stack.pop();
				double aux = 0;
				if (a == '+') aux = Double.parseDouble(y) + Double.parseDouble(x);
				else if (a == '-') aux = Double.parseDouble(y) - Double.parseDouble(x);
				else if (a == '*') aux = Double.parseDouble(y) * Double.parseDouble(x);
				else if (a == '/') aux = Double.parseDouble(y) / Double.parseDouble(x);
				else if (a == '^') aux = Math.pow(Double.parseDouble(y),Double.parseDouble(x));
				stack.push(Double.toString(aux));
				i++;
			}
			else {
				stack.push(next);
				next = "";
			}
		}
		return Double.parseDouble(stack.pop());
	}


}
