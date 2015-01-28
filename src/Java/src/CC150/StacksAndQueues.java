package Java.src.CC150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by YHWH on 12/28/14.
 */
public class StacksAndQueues {

    public class MinStack extends Stack<Integer> {
        Stack<Integer> s;

        public MinStack(){ s = new Stack<Integer>();}

        public void push(int value){
            if(value <= min()){ s.push(value);}
            super.push(value);
        }

        public Integer pop(){
            int value = super.pop();
            if(value == min()){ s.pop();}
            return value;
        }

        public int min(){
            if(s.isEmpty()){ return Integer.MAX_VALUE;}
            else{ return s.peek();}
        }
    }

    public Stack hanoi(int diskNum){
        Stack<Integer> originTower = new Stack<Integer>();
        Stack<Integer> bufferTower = new Stack<Integer>();
        Stack<Integer> goalTower = new Stack<Integer>();

        for(int i = diskNum; i >= 1; i--){
            originTower.push(i);
        }
        moveDisks(diskNum, originTower, goalTower, bufferTower);

        return goalTower;
    }
    private void moveDisks(int diskNum, Stack<Integer> originTower, Stack<Integer> goalTower, Stack<Integer> bufferTower){

        if(diskNum>0){
            moveDisks(diskNum-1, originTower, bufferTower, goalTower);
            int disk = originTower.pop();
            goalTower.push(disk);
            System.out.println(originTower + " , " + bufferTower + " , " + goalTower);
            moveDisks(diskNum - 1, bufferTower, goalTower, originTower);
        }

    }

    public class SetOfStacks{

        ArrayList <Stack> stacks = new ArrayList<Stack>();
        int capacity;
        int last = 0;

        public SetOfStacks(int c){
            Stack s = new Stack();
            stacks.add(s);
            capacity = c;
        }

        public int pop(){
            int value =(Integer) stacks.get(last).pop();
            if(stacks.get(last).size() == 0){
                stacks.remove(last);
                last = last - 1;
            }
            return value;
        }
        public void push(int item){
            if(stacks.get(last).size() == capacity){
                last = last + 1;
                stacks.add(new Stack());
            }
            stacks.get(last).push(item);
        }

        public int getSize(){ return stacks.size();}

        public int popAt(int index){
            if(index<0 || index >= stacks.size()){ return 0;}

            int value = (Integer) stacks.get(index).pop();
            int current = index;
            while(current+1<stacks.size()){
                stacks.get(current).push(stacks.get(current+1).pop());
                current = current+1;
            }
            if(stacks.get(last).size() == 0){
                stacks.remove(last);
                last = last - 1;
            }

            return value;
        }

    }

    public class MyQueue<T> {
        Stack<T> stackNew, stackOld;

        public MyQueue(){
            stackNew = new Stack<T>();
            stackOld = new Stack<T>();
        }

        public int size(){
            return stackNew.size() + stackOld.size();
        }

        public void add(T value){
            stackNew.push(value);
        }

        private void shiftStacks(){
            if(stackOld.isEmpty()){
                while(!stackNew.isEmpty()){
                    stackOld.push(stackNew.pop());
                }
            }
        }

        public T peek(){
            shiftStacks();
            return stackOld.peek();
        }

        public T remove(){
            shiftStacks();
            return  stackOld.pop();
        }
    }

    public Stack<Integer> sortStack(Stack<Integer> s){
        Stack<Integer> sorted = new Stack();


        while(!s.isEmpty()){
            int temp = s.pop();
            if(!sorted.isEmpty() && sorted.peek() > temp){
                s.push(sorted.pop());
            }
            sorted.push(temp);
        }

        return sorted;
    }

    public abstract class Animal{
        String name;
        public Animal(String name){ this.name = name;}
        public String getName(){return name;}
    }
    public class Dog extends Animal{
        public Dog(String name){ super(name);}
    }
    public class Cat extends Animal{
        public Cat(String name){ super(name);}
    }
    public class AnimalQueue{
        LinkedList<Animal> animals = new LinkedList<Animal>();
        public void enqueue(Animal a){
            animals.offer(a);
        }

        public Animal dequeueAny(){
            return animals.poll();
        }

        public Animal dequeueDog(){
            int i = 0;
            while(!(animals.get(i) instanceof Dog)){
                i++;
            }
            Animal result = animals.get(i);
            animals.remove(i);
            return result;

        }
        public Animal dequeueCat(){
            int i = 0;
            while(!(animals.get(i) instanceof Cat)){
                i++;
            }
            Animal result = animals.get(i);
            animals.remove(i);
            return result;
        }
    }



}
