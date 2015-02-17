package Java.test.CC150;

import org.junit.Test;
import static org.junit.Assert.*;
import Java.src.CC150.TreeAndGraph;
import Java.src.CC150.TreeAndGraph.*;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by YHWH on 1/26/15.
 */
public class TreeAndGraphTest {
    TreeAndGraph treeAndGraph = new TreeAndGraph();

    @Test
    public void isBalanced(){
        int[] sample = {6,3,8,2,5,4,10,1};

        MyTree tree = treeAndGraph.new MyTree(sample);
        boolean result =tree.isBalanced();
        assertTrue(result);
    }

    @Test
    public void createGraphTest(){
        BGraph graph = treeAndGraph.new BGraph(9);
        GNode root = graph.getRoot();
        GNode seven = graph.addEdge(root, 7);
        GNode four = graph.addEdge(root, 4);
        GNode five = graph.addEdge(seven, 5);
        GNode two = graph.addEdge(four, 2);
        GNode six = graph.addEdge(four, 6);
        graph.addEdge(five, two);
        graph.addEdge(six, five);

        assertTrue(treeAndGraph.hasPath(graph, root, six));
    }

    @Test
    public void createBinarySearchTreeTest(){
        int[] sample = {3,5,8,9,12,18,21,22,35};
        MyTree tree = treeAndGraph.new MyTree(sample);
        MyTree.Node result = tree.createBinarySearchTree(sample);
        assertEquals(12, result.value);
        assertEquals(5, result.left.value);
        assertEquals(21, result.right.value);
    }

    @Test
    public void sameDepthListsTest(){
        int[] sample = {6,3,8,2,5,4,10,1};
        MyTree tree = treeAndGraph.new MyTree(sample);
        ArrayList<LinkedList<MyTree.Node>> result = tree.sameDepthLists(tree);
        assertEquals(2,result.get(2).getFirst().value);
        assertEquals(10,result.get(2).getLast().value);
    }

    @Test
    public void checkBSTTest(){
        int[] sample1 = {3,5,8,9,12,18,21,22,35};
        MyTree tree1 = treeAndGraph.new MyTree(sample1);
        MyTree.Node result1 = tree1.createBinarySearchTree(sample1);
        assertTrue(tree1.checkBST(result1));

        int[] sample2 = {6,3,8,2,5,4,10,1};
        MyTree tree2 = treeAndGraph.new MyTree(sample2);
        assertTrue(tree2.checkBST(tree2.root));
    }

    @Test
    public void findNextTest(){
        int[] sample = {3,5,8,9,12,18,21,22,35};
        MyTree tree = treeAndGraph.new MyTree(sample);
        MyTree.Node result = tree.createBinarySearchTree(sample);
        assertEquals(12, tree.findNext(result.left.right.right).value);
        assertEquals(21,tree.findNext(result.right.left).value);
    }

    @Test
    public void containTreeTest(){
        int[] big = {3,5,8,9,12,18,21,22,35};
        int[] small1 = {18,21,22,35};
        int[] small2 = {6,3,8,2,5,4,10,1};

        MyTree bigTree = treeAndGraph.new MyTree(big);
        MyTree smallTree1 = treeAndGraph.new MyTree(small1);
        MyTree smallTree2 = treeAndGraph.new MyTree(small2);

        assertTrue(bigTree.containTree(bigTree.root, smallTree1.root));
        assertFalse(bigTree.containTree(bigTree.root, smallTree2.root));
    }

    @Test
    public void findSumTest(){
        int[] sample = {6,3,8,2,5,4,10,1};
        MyTree tree = treeAndGraph.new MyTree(sample);
        tree.findSum(tree.root,12);
    }
}
