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
    public TreeNode balanceBST(TreeNode root) {
        if(root == null) return null;

        ArrayList<Integer> list = new ArrayList<>();

        inorder(root,list);

        return balancetree(list,0,list.size()-1);
    }

    public void inorder(TreeNode root, ArrayList<Integer> list){
        if(root == null) return;

        inorder(root.left,list);
        
        list.add(root.val);

        inorder(root.right,list);

    }

    public TreeNode balancetree(ArrayList<Integer> list,int srt,int end){
        if(srt > end){
            return null;
        }

        int mid = srt + (end-srt) / 2;

        TreeNode root = new TreeNode(list.get(mid));

        root.left = balancetree(list,srt,mid-1);

        root.right = balancetree(list,mid+1,end);

        return root;
    }
}