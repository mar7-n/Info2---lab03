package LAB03;

import java.util.EmptyStackException;

public class Stack {
    private  int length;
    private ListNode top;

    public Stack() {
        length = 0;
        top = null;
    }

    public void push(char data){
        ListNode temp = new ListNode(data);
        temp.setNext(top);
        top = temp;
        length++;
    }

    public char pop(){
        if (size() == 0){
            throw new EmptyStackException();}
        else {
            char result = (char) top.getData();
            top = top.getNext();
            length--;
            return result;
        }
    }
    public char peek(){
        if (size() == 0){
            throw new EmptyStackException();}
        return (char) top.getData();
    }
    public boolean isEmpty() {
        return (length == 0);
    }
    public int size() {
        return length;
    }










}
