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
    public TreeNode bstFromPreorder(int[] preorder) {
        return formbst(preorder,0,preorder.length-1);
    }

    public TreeNode formbst(int[] preorder,int start,int end){
        if(start > end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int i = start+1;

        while(i <= end && preorder[i] < root.val){ // finding element greater then root.val
            i++;
        }

        // left subtree forming

        root.left = formbst(preorder,start+1,i-1);

        // right subtree forming

        root.right = formbst(preorder,i,end);

        return root;
    }
}