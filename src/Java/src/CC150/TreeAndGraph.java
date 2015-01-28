package Java.src.CC150;

import javax.swing.tree.TreeNode;

/**
 * Created by YHWH on 1/26/15.
 */
public class TreeAndGraph {
    public Node root;
    public class Node{
        Node left, right;
        int value;

        public Node(int value){
            this.value = value;
        }
    }
    public Node put(Node x, int value){
        if (x == null) return new Node(value);

        if(value < x.value ){
            x.left = put(x.left, value);
        }
        else{
            x.right = put(x.right, value);
        }
        return x;
    }

    public void put(int value){
        root = put(root, value);
    }
    public TreeAndGraph(int[] values){
        for(int value : values) {
            put(value);
        }
    }

    public boolean isBalanced(){
        if(root == null) return true;
        if(getHeight(root)== -1){
            return false;
        }
        else{
            return true;
        }
    }
    public int getHeight(Node root){
        if(root == null) return 0;

        int leftHeight = getHeight(root.left);
        if(leftHeight == -1) return -1;

        int rightHeight = getHeight(root.right);
        if(rightHeight == -1) return -1;

        int heightDiff = leftHeight-rightHeight;
        if(Math.abs(heightDiff)>1){
            return -1;
        }
        else {
            return Math.max(leftHeight, rightHeight) +1;
        }
    }
}
