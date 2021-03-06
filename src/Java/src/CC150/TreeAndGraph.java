package Java.src.CC150;

import com.sun.tools.internal.xjc.reader.gbind.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by YHWH on 1/26/15.
 */
public class TreeAndGraph {
    public class MyTree {
        public Node root;

        public class Node {
            public Node left, right, parent;
            public int value;

            public Node(int value) {
                this.value = value;
            }
        }

        public Node put(Node x, int value) {
            if (x == null) return new Node(value);

            if (value < x.value) {
                x.left = put(x.left, value);
            } else {
                x.right = put(x.right, value);
            }
            return x;
        }

        public void put(int value) {
            root = put(root, value);
        }

        public MyTree(int[] values) {
            for (int value : values) {
                put(value);
            }
        }

        public boolean isBalanced() {
            if (root == null) return true;
            if (getHeight(root) == -1) {
                return false;
            } else {
                return true;
            }
        }

        public int getHeight(Node root) {
            if (root == null) return 0;

            int leftHeight = getHeight(root.left);
            if (leftHeight == -1) return -1;

            int rightHeight = getHeight(root.right);
            if (rightHeight == -1) return -1;

            int heightDiff = leftHeight - rightHeight;
            if (Math.abs(heightDiff) > 1) {
                return -1;
            } else {
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }

        public Node createBinarySearchTree(int[] array){
            return createBinarySearchTree(array, 0, array.length-1, null);
        }
        public Node createBinarySearchTree(int[] array, int start, int end, Node parent){
            if(end<start) return null;

            int middle = Math.round((start + end)/2);
            Node current = new Node(array[middle]);
            current.parent = parent;
            current.left = createBinarySearchTree(array, start, middle - 1, current);
            current.right = createBinarySearchTree(array, middle+1, end, current);

            return current;
        }

        public ArrayList<LinkedList<Node>> sameDepthLists(MyTree tree){
            ArrayList<LinkedList<Node>> array = new ArrayList<LinkedList<Node>>();
            int depth = 1;
            array = createLists(tree.root, array, depth);
            return array;
        }
        public ArrayList<LinkedList<Node>> createLists(Node x, ArrayList<LinkedList<Node>> arr, int depth){
            if(arr.size()<depth)arr.add(new LinkedList<Node>());

            arr.get(depth-1).add(x);

            if(x.left != null) createLists(x.left, arr, depth + 1);
            if(x.right != null) createLists(x.right, arr, depth + 1);

            return arr;
        }

        public boolean checkBST(Node n){
            return checkBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        public boolean checkBST(Node n, int min, int max){
            if(n==null) return true;
            if(n.value <= min || n.value > max) return false;
            if(!checkBST(n.left, min, n.value) || !checkBST(n.right, n.value, max)) return false;
            return true;
        }

        public Node findNext(Node x){
            if(x == null) return null;
            if(x.right !=null){ return leftMostChild(x.right);}
            else{
                Node t = x;
                Node p = x.parent;
                while(p != null && p.left !=t){
                    t = p;
                    p = p.parent;
                }
                return p;
            }
        }
        public Node leftMostChild(Node n){
            if(n==null) return null;
            while(n.left!= null){
                n = n.left;
            }
            return n;
        }

        public boolean containTree(Node t1, Node t2){
            if(t2 == null) return true;
            return subTree(t1, t2);
        }
        boolean subTree(Node r1, Node r2){
            if(r1 == null) return false;
            if(r1.value == r2.value){
                if(matchTree(r1, r2)) return true;
            }
            return (subTree(r1.left, r2) || subTree(r1.right, r2));
        }
        boolean matchTree(Node r1, Node r2){
            if(r2 == null && r1 == null) return true;
            if(r1 == null || r2 == null) return false;
            if(r1.value != r2.value) return false;
            return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
        }

        public void findSum(Node node, int sum, int[] path, int level){
            if(node == null) return;

            path[level] = node.value;

            int t = 0;
            for(int i = level; i >= 0; i--){
                t = t + path[i];
                if(t == sum){
                    print(path, i, level);
                }
            }

            findSum(node.left, sum, path, level+1);
            findSum(node.right, sum, path, level+1);

            path[level] = Integer.MIN_VALUE;
        }
        public void findSum(Node node, int sum){
            int depth = depth(node);
            int[] path = new int[depth];
            findSum(node, sum, path, 0);
        }
        public int depth(Node node){
            if(node == null){
                return 0;
            }
            else{
                return 1 + Math.max(depth(node.left), depth(node.right));
            }

        }
        public void print(int[] path, int start, int end){
            for(int i = start; i <=end; i ++) System.out.print(path[i] + " ");
            System.out.println();
        }
    }

    public class GNode{
        int value;
        Enum state;
        ArrayList<GNode> adj;

        public GNode(int v){
            value = v;
            adj = new ArrayList<GNode>();
        }
        public ArrayList<GNode> getAdj(){
            return adj;
        }
    }
    public class BGraph{
        GNode root;
        ArrayList<GNode> allNodes = new ArrayList<GNode>();

        public BGraph(int V){
            root = new GNode(V);
            allNodes.add(root);
        }
        public GNode addEdge(GNode x, int w){
            GNode y = new GNode(w);
            x.adj.add(y);
            allNodes.add(y);
            return y;
        }
        public GNode addEdge(GNode x, GNode y){
            x.adj.add(y);
            allNodes.add(y);
            return y;
        }
        public GNode getRoot(){
            return root;
        }
        public ArrayList<GNode> getNodes(){
            return allNodes;
        }


    }

    public enum State{
        Unvisited, Visited, Visiting;
    }
    public static boolean hasPath(BGraph g, GNode start, GNode end){
        LinkedList<GNode> q = new LinkedList<GNode>();

        for(GNode n : g.getNodes()){
            n.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        GNode node;
        while(!q.isEmpty()){
            node = q.removeFirst();
            if(node != null){
                System.out.println("start from " + node.value);
                for(GNode adjNode : node.getAdj()){
                    System.out.println("now is " + adjNode.value);
                    if(adjNode.state == State.Unvisited){
                        if(adjNode == end){
                            System.out.println("End is " + adjNode.value);
                            return true;
                        }
                        else{
                            adjNode.state = State.Visiting;
                            q.add(adjNode);
                        }
                    }
                }
                node.state = State.Visited;
                System.out.println(node.value + " is already visited");
            }
        }
        return false;
    }


}
