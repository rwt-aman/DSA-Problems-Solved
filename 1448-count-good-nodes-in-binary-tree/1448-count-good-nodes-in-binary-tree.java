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
class Solution { // we can also create count globally but that is a bad practice
    public int goodNodes(TreeNode root) {
        return dfs(root,root.val);
    }

    public int dfs(TreeNode root,int currmax){
        if(root == null) return 0;

        int count = 0;

        if(root.val >= currmax){
            count++;
            currmax = root.val;
        }

        count += dfs(root.left,currmax);
        count += dfs(root.right,currmax);

        return count;
    }
}