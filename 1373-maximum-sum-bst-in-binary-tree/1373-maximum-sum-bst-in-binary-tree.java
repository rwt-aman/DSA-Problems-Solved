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
    int ans = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);

        return ans;
    }

    // ans -> min,max,sum
    public int[] dfs(TreeNode root){
        //base case;
        if(root == null){
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        }

        int[] leftsubtree = dfs(root.left);
        int[] rightsubtree = dfs(root.right);

        // check if current subtree is bst or not 
        if(leftsubtree[1] < root.val && root.val < rightsubtree[0]){ // 0-> min ans 1-> max
            int currsum = leftsubtree[2] + rightsubtree[2] + root.val; // 2-> sum

            ans = Math.max(ans,currsum);

            int minvalue = Math.min(root.val,leftsubtree[0]);
            int maxvalue = Math.max(root.val,rightsubtree[1]);

            return new int[]{minvalue,maxvalue,currsum};
        }

        int maxsum = Math.max(leftsubtree[2],rightsubtree[2]);

        return new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE,maxsum};
    }
}