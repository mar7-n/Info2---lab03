package lab03;

import java.util.EmptyStackException;



public class Stack {
    private int length;
    private ListNode top;

    public Stack() {
        length = 0;
        top = null;
    }

    public void push(String data) {
        ListNode temp = new ListNode(data);
        temp.setNext(top);
        top = temp;
        length++;
    }

    public String pop() throws Underflow {
        if (length == 0) {
            throw new Underflow();
        } else {
            String result = top.getData();
            top = top.getNext();
            length--;
            return result;
        }
    }

    public String peek() throws Underflow {
        if (length == 0) {
            throw new Underflow();
        }
        return top.getData();
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public int size() {
        return length;
    }

    public String toString(){
        ListNode aux = top;
        String result = "";
        if(length > 0) result = aux.getData();
        for (int i = 1; i < length; i++) {
            aux = aux.getNext();
            result += ", " + aux.getData();
        }
        return result;
    }

}
