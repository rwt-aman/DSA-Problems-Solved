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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int maxwidth = 0;

        Queue<long[]> q = new LinkedList<>();
        q.offer(new long[]{0,0});

        // using pair approach
        Queue<TreeNode> qnode = new LinkedList<>();
        Queue<Long> qindex = new LinkedList<>();

        qnode.offer(root);
        qindex.offer(0L); // level

        while(!qnode.isEmpty()){
            int size = qnode.size();
            long first = 0,last = 0;

            for(int i=0;i<size;i++){
                TreeNode node = qnode.poll();
                long idx = qindex.poll();

                if(i == 0) first = idx;
                if(i == size-1) last = idx;

                if(node.left != null){
                    qnode.offer(node.left);
                    qindex.offer(2*idx); // or for left 2*idx+1
                }
                if(node.right != null){
                    qnode.offer(node.right);
                    qindex.offer(2*idx+1);  // or for right 2*idx+2
                }
            }
            maxwidth = (int) Math.max(maxwidth,last-first+1);
        }
        return maxwidth;
    }
}