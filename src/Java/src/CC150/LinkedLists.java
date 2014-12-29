package Java.src.CC150;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by YHWH on 12/13/14.
 */
public class LinkedLists {

    public class LinkedListNode{
        LinkedListNode next = null;
        int data = 0;
        public LinkedListNode(int d){ data = d;}

        public void appendToTail(int d){
            LinkedListNode end = new LinkedListNode(d);
            LinkedListNode n = this;
            while(n.next!=null){
                n = n.next;
            }
            n.next = end;
        }

        public LinkedListNode getNext(){ return this.next;}
        public int getData(){ return this.data;}
        public void setNext(LinkedListNode n){ this.next = n;}
    }

    public LinkedListNode removeDuplicates(LinkedListNode n) {
        Hashtable table = new Hashtable();
        LinkedListNode previous = null;
        LinkedListNode head = n;

        while(n != null){
            if(table.containsKey(n.data)){
                previous.next = n.next;
            }
            else{
                table.put(n.data, true);
                previous = n;
            }
            n = n.next;
        }
        return head;
    }

    public LinkedListNode removeDup(LinkedListNode head) {
        if(head==null) return null;

        LinkedListNode current = head;
        while(current != null){
            LinkedListNode runner = current;
            while(runner.next != null){
                if(runner.next.data == current.data){
                    runner.next = runner.next.next;
                }
                else{
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        return head;
    }

    public int lastKthElement(int k, int length, LinkedListNode head){
        if(head == null) return 0;

        int n = length - k;
        LinkedListNode current = head;

        int i = 0;
        while(i != n){
            current = current.next;
            i++;
        }

        return current.data;
    }

    public int lastKthElementLengthUnknown(int k, LinkedListNode head){
        if(head == null) return 0;

        LinkedListNode current = head;
        LinkedListNode runner = head;

        for(int i = 0; i<k; i++){
            runner = runner.next;
        }

        while(runner != null){
            runner = runner.next;
            current = current.next;
        }

        return current.data;
    }

    public boolean removeMiddle(LinkedListNode current){
        if(current == null || current.next == null) return false;
        current.data = current.next.data;
        current.next = current.next.next;
        return true;
    }

    public LinkedListNode partition(LinkedListNode source, int x){
        LinkedListNode less = null;
        LinkedListNode greater = null;
        LinkedListNode head = null;

        while(source != null){
            LinkedListNode second = source.next;
            if(source.data < x){      //insert source to end of less list
                if(less == null){
                    less = source;
                    head = less;}
                else {
                    less.next = source;
                    less = less.next;
                }
            }
            else{                    //insert source to head of greater list
                source.next = greater;
                greater = source;
            }
            source = second;
        }

        less.next = greater;
        return head;

    }

    public LinkedListNode addList(LinkedListNode num1, LinkedListNode num2, int carry){
        if(num1 == null && num2 == null && carry ==0){ return null;}

        LinkedListNode sumDigit = new LinkedListNode(carry);

        int sum = carry;
        if(num1 != null){ sum = num1.data + sum;}
        if(num2 != null){ sum = num2.data + sum;}

        sumDigit.data = sum%10;

        if(num1 != null || num2 != null){
            LinkedListNode moreDigit = addList(num1==null? null : num1.next, num2==null? null : num2.next, sum > 9? 1 : 0);
            sumDigit.next = moreDigit;
        }

        return sumDigit;
    }

    public LinkedListNode addLists(LinkedListNode num1, LinkedListNode num2){
        if(num1 == null && num2 == null){ return null;}

        LinkedListNode head1 = num1;
        LinkedListNode head2 = num2;

        int length1 =0, length2=0;
        while(num1!=null){
            length1++;
            num1 = num1.next;
        }
        while(num2!=null){
            length2++;
            num2 = num2.next;
        }

        if(length1 > length2){
            for(int i = 0; i < length1-length2; i++){
                LinkedListNode node = new LinkedListNode(0);
                node.next = head2;
                head2 = node;
            }
        }
        else{
            for(int i = 0; i < length2-length1; i++){
                LinkedListNode node = new LinkedListNode(0);
                node.next = head1;
                head1 = node;
            }
        }

        Digit sumDigit = addRecurse(head1, head2);

        if(sumDigit.carry !=0){
            LinkedListNode newDigit = new LinkedListNode(sumDigit.carry);
            newDigit.next = sumDigit.node;
            return newDigit;
        }
        else { return sumDigit.node;}
    }

    private Digit addRecurse(LinkedListNode num1, LinkedListNode num2){
        if(num1==null && num2 == null){ return new Digit(0, null);}

        Digit prevResult = addRecurse(num1==null? null : num1.next, num2==null? null : num2.next);

        int sum = prevResult.carry;
        if(num1 != null){ sum = num1.data + sum;}
        if(num2 != null){ sum = num2.data + sum;}

        Digit result = new Digit(sum>9? 1: 0, new LinkedListNode(sum%10));
        result.node.next = prevResult.node;

        return result;
    }

    public class Digit{
        int carry;
        LinkedListNode node;
        public Digit(int c, LinkedListNode n){
            carry = c;
            node = n;
        }
    }

    public boolean isPalindrome(LinkedListNode head){
        if(head == null) return false;

        Stack<Integer> stack = new Stack<Integer>();

        LinkedListNode current = head;
        LinkedListNode runner = head;

        while(runner != null && runner.next != null){
            stack.push(current.data);
            current = current.next;
            runner = runner.next.next;
        }

        if(runner != null){ current = current.next;}

        while(current != null){
            int top = stack.pop().intValue();
            if(current.data != top){ return false;}
            current = current.next;
        }

        return true;
    }

    private Result palindromeRecurse(LinkedListNode front, int length){
        if(front == null || length == 0){ return new Result(null, true);} //middle element
        else if(length == 1){ return new Result(front.next, true);}
        else if(length == 2){ return new Result(front.next.next, front.data == front.next.data);}

        Result back = palindromeRecurse(front.next, length - 2);
        if(!back.result || back.node == null){ return back;}
        else{
            back.result = front.data == back.node.data;
            back.node = back.node.next;
            return back;
        }
    }

    public class Result{
        LinkedListNode node;
        boolean result;

        public Result(LinkedListNode n, boolean r){
            node = n;
            result = r;
        }
    }

    public boolean isPalin(LinkedListNode head){
        int length =0;
        LinkedListNode source = head;
        while(head != null){
            length++;
            head = head.next;
        }
        Result finalValue = palindromeRecurse(source, length);
        return finalValue.result;
    }

    public LinkedListNode findBeginning(LinkedListNode head){
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        while(fast != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){ break;}
        }

        if(fast == null || fast.next == null){ return null;}

        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

}

