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
        ArrayList<LinkedList> result = tree.sameDepthLists(tree);


    }
}
