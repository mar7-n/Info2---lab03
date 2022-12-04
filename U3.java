import java.util.Stack;

public class U3{

    public static void main(String[] args) {

       Stack stack = new Stack();

       stack.push(1);
       stack.push(2);
       stack.push(3);
       //stack2.push(4);
       //stack2.push(5);S

       stack.push("blue");
       stack.push("LOOL");
       stack.push("Red");
      // stack.push("green");
       stack.toString();

        System.out.println("Size of stack is: " + stack.size());
        stack.pop();
        stack.pop();
       // stack.pop();

        System.out.println(stack.isEmpty());

        System.out.println("Top element of stack is: " + stack.peek());

    }

    
}
