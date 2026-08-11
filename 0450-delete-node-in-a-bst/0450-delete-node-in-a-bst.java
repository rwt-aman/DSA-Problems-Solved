/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val > key){ // move left
            root.left = deleteNode(root.left,key);
        }
        else if(root.val < key){ // move right
            root.right = deleteNode(root.right,key);
        }
        else{ // equal 
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            root.val = minvalue(root.right);

            root.right = deleteNode(root.right,root.val);
        }

        return root;
    }
    
    public int minvalue(TreeNode root){
        int min = root.val;

        while(root.left != null){ // min will be at left only BST
            min = root.left.val;
            root = root.left;
        }

        return min;
    }
}