package Java.test.CC150;

import org.junit.Test;
import static org.junit.Assert.*;

import Java.src.CC150.LinkedLists;
import Java.src.CC150.LinkedLists.*;


/**
 * Created by YHWH on 12/13/14.
 */
public class LinkedListsTest {
    LinkedLists linkedListTest = new LinkedLists();

    private LinkedListNode setupList(int[] content){

        LinkedListNode list = new LinkedLists().new LinkedListNode(content[0]);
        for(int i=1; i<content.length; i++){
            list.appendToTail(content[i]);
        }
        return list;
    }

    private boolean compareList(LinkedListNode expected, LinkedListNode test){
        boolean result = true;
        while(test != null){
            if(expected.getData() != test.getData()){ result = false;}
            expected = expected.getNext();
            test = test.getNext();
        }

        return result;
    }

    @Test
    public void removeDuplicatesTest(){

        int [] list = {1,2,3,2,1};
        LinkedLists.LinkedListNode sample = setupList(list); //create test data

        int [] list2 = {1,2,3};
        LinkedLists.LinkedListNode expected = setupList(list2); //create validation data

        LinkedLists.LinkedListNode result = linkedListTest.removeDuplicates(sample);

        assertTrue(compareList(expected, result));
    }

    @Test
    public void removeDupTest(){
        int [] list = {1,2,3,2,1};
        LinkedLists.LinkedListNode sample = setupList(list); //create test data

        int [] list2 = {1,2,3};
        LinkedLists.LinkedListNode expected = setupList(list2); //create validation data

        LinkedLists.LinkedListNode result = linkedListTest.removeDup(sample);

        assertTrue(compareList(expected, result));
    }

    @Test
    public void lastKthElementTest(){
        int [] list = {1,2,3,4,5};
        LinkedLists.LinkedListNode sample = setupList(list); //create test data

        int result = linkedListTest.lastKthElement(1, 5, sample);
        int expected = 5;
        assertEquals(expected, result);
    }

    @Test
    public void lastKthElementLengthUnknownTest(){
        int [] list = {1,2,3,4,5};
        LinkedLists.LinkedListNode sample = setupList(list); //create test data

        int result = linkedListTest.lastKthElementLengthUnknown(2, sample);
        int expected = 4;
        assertEquals(expected, result);
    }

    @Test
    public void removeMiddleTest(){
        int [] list = {1,2,3,4,5};
        LinkedLists.LinkedListNode sample = setupList(list); //create test data

        int [] list2 = {2,3,4,5};
        LinkedLists.LinkedListNode expected = setupList(list2); //create validation data

        linkedListTest.removeMiddle(sample);

        assertTrue(compareList(expected, sample));
    }

    @Test
    public void partitionTest(){
        int [] list = {4,5,3,1,2};
        int x = 2;
        LinkedLists.LinkedListNode sample = setupList(list); //create test data

        int [] list2 = {1,2,3,5,4};
        LinkedLists.LinkedListNode expected = setupList(list2); //create validation data

        assertTrue(compareList(expected, linkedListTest.partition(sample, x)));
    }

    @Test
    public void addTest(){
        int [] list1 = {6,1,7};
        int [] list2 = {2,9,5};
        LinkedLists.LinkedListNode sample1 = setupList(list1); //create test data
        LinkedLists.LinkedListNode sample2 = setupList(list2); //create test data

        int [] list3 = {8,0,3,1};
        LinkedLists.LinkedListNode expected1 = setupList(list3); //create validation data
        int [] list4 = {9,1,2};
        LinkedLists.LinkedListNode expected2 = setupList(list4); //create validation data

        LinkedLists.LinkedListNode result = linkedListTest.addList(sample1, sample2, 0);
        assertTrue(compareList(expected1, result));

        LinkedLists.LinkedListNode result2 = linkedListTest.addLists(sample1, sample2);
        assertTrue(compareList(expected2, result2));
    }

    @Test
    public void isPalindromeTest(){
        int [] list = {1,2,3,3,2,1};
        LinkedLists.LinkedListNode sample = setupList(list); //create test data

        assertTrue(linkedListTest.isPalindrome(sample));
        assertTrue(linkedListTest.isPalin(sample));
    }

    @Test
    public void findBeginningTest(){
        LinkedListNode sample = new LinkedLists().new LinkedListNode(1);
        LinkedListNode head = sample;

        for(int i=2; i<=5; i++){
            sample.setNext(new LinkedLists().new LinkedListNode(i));
            sample = sample.getNext();
        }

        sample.setNext(head.getNext().getNext());

        assertEquals(head.getNext().getNext(),linkedListTest.findBeginning(head));
    }

}
