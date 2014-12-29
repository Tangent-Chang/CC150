package Java.src.CC150;

/**
 * Created by YHWH on 12/28/14.
 */
public class StacksAndQueues {

    public class Node{
        Node next = null;
        Object data = null;
        public Node(Object item){ data = item;}

        public void appendToTail(Object item){
            Node end = new Node(item);
            Node n = this;
            while(n.next!=null){
                n = n.next;
            }
            n.next = end;
        }

        public Node getNext(){ return this.next;}
        public Object getData(){ return this.data;}
        public void setNext(Node n){ this.next = n;}
    }

    public class Stack{
        Node top;
        Object pop(){
            if(top != null){
                Object item = top.data;
                top = top.next;
                return item;
            }
            return null;
        }

        void push(Object item){
            Node t = new Node(item);
            t.next = top;
            top = t;
        }

        Object peek(){ return top.data;}
    }

    public class MinStack extends Stack{
        Stack s;


    }

}
