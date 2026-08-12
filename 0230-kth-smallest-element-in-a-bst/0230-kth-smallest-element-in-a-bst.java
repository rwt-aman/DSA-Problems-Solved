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
class Solution { // most optimize O(n) worst case space is O(h)
    public int kthSmallest(TreeNode root, int k) { //iterative approach (Moorey)
        Stack<TreeNode> st = new Stack<>();

        while(root != null || !st.isEmpty()){ // inorder following

            while(root != null){ //  go to the extreme left 1st node smallest 
                st.push(root);
                root = root.left;
            }

            // visit node 
            root = st.pop();
            k--;

            // kth smallest found
            if(k == 0){
                return root.val;
            }

            // move to right subtree
            root = root.right;

        }

        return -1;
    }
}




// class Solution { // TC:- O(n) and SC:-O(h)
//     // we will use inorder traversal which help to give us sorted elements 
//     int count = 0;
//     int ans = -1;

//     public int kthSmallest(TreeNode root, int k) {
//         inorder(root,k);

//         return ans;
//     }

//     public void inorder(TreeNode root,int k){
//         if(root == null) return;

//         inorder(root.left,k);

//         count++;

//         if(count == k){
//             ans = root.val;
//             return;
//         }

//         inorder(root.right,k);
//     }
// }