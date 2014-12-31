package Java.src.CC150;

import java.util.ArrayList;
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

}
