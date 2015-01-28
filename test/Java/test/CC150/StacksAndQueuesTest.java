package Java.test.CC150;

import org.junit.Test;
import static org.junit.Assert.*;
import Java.src.CC150.StacksAndQueues;
import Java.src.CC150.StacksAndQueues.*;

import java.util.Stack;

/**
 * Created by YHWH on 12/28/14.
 */
public class StacksAndQueuesTest {

    StacksAndQueues Test = new StacksAndQueues();

    @Test
    public void minStackTest(){
        MinStack s = Test.new MinStack();
        s.push(5);
        s.push(9);
        assertEquals(5, s.min());
        s.push(4);
        s.push(2);
        assertEquals(2, s.min());
        s.pop();
        assertEquals(4, s.min());

    }

    @Test
    public void hanoiTest(){ Stack result = Test.hanoi(3);}

    @Test
    public void SetOfStacksTest(){
        SetOfStacks stack = Test.new SetOfStacks(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(2, stack.getSize());
        stack.pop();
        assertEquals(1, stack.getSize());
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.popAt(4);
        assertEquals(3, stack.getSize());
    }

    @Test
    public void MyQueueTest(){
        MyQueue queue = Test.new MyQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assertEquals(1, queue.peek());
    }

    @Test
    public void sortStackTest(){
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(3);
        s.push(8);
        s.push(6);
        s.push(5);
        s = Test.sortStack(s);
        assertFalse(5 == s.peek());
    }

    @Test
    public void AnimalTest(){
        AnimalQueue queue = Test.new AnimalQueue();
        queue.enqueue(Test.new Dog("samoyed"));
        queue.enqueue(Test.new Dog("husky"));
        queue.enqueue(Test.new Cat("金吉拉"));
        queue.enqueue(Test.new Cat("美短"));
        queue.enqueue(Test.new Dog("golden"));
        assertEquals("samoyed", queue.dequeueAny().getName());
        assertEquals("金吉拉", queue.dequeueCat().getName());
    }

}
