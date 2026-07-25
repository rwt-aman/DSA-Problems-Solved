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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> ans = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode front = q.poll();

                if(level % 2 == 0){
                    ans.add(front.val);
                }
                else{
                    ans.add(0,front.val);
                }

                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
            list.add(ans);
            level++;
        }
        return list;
    }
}