import java.util.EmptyStackException;

public class Stack {
    private  int length;
    private ListNode top;

    public Stack() {
        length = 0;
        top = null;
    }

    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.setNext(top);
        top = temp;
        length++;
    }

    public int pop(){
        if (size() == 0){
            throw new EmptyStackException();}
        else {
            int result = top.getData();
            top = top.getNext();
            length--;
            return result;
        }
    }
    public int peek(){
        if (size() == 0){
            throw new EmptyStackException();}
        return top.getData();
    }
    public boolean isEmpty() {
        return (length == 0);
    }
    public int size() {
        return length;
    }










}