package lab03;

public class ListNode <E> {
    public ListNode next;
    public String data;


    public ListNode(){
        next = null;
        data = "";

    }

    public ListNode (String data) {
        next = null;
        this.data = data;

    }
    public ListNode getNext() {
        return next;
    }

    public void setNext (ListNode node) {
        next = node;
    }

    public String getData() {
        return data;
    }

    public void setdata (String elem){
        data = elem;
    }

}