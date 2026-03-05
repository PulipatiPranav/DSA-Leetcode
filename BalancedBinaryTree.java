/**
 * ublic * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// My initial approach to the problem involved calculating depth and finding
// if it is a balanced binary tree in two seperate function calls hence leading
// to a time complexity of O(n^2). The optimised approach uses dfs to calculate
// height
// and determine if the tree is balanced at each node in the same function call,
// giving us a linear time complexity.
// Intitial approach -

// class Solution {
// public boolean isBalanced(TreeNode root) {
// if(root == null) return true;

// int l = depth(root.left);
// int r = depth(root.right);
// if(Math.abs(l-r) >1) return false;
// return isBalanced(root.left) && isBalanced(root.right);

// }
// public int depth(TreeNode root){
// if(root == null) return 0;
// int left = depth(root.left);
// int right = depth(root.right);
// return (Math.max(left,right) +1);
// }
// }

// Optimised Approach -
class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;

    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        if (left == -1)
            return -1;
        int right = dfs(root.right);
        if (right == -1)
            return -1;
        if (Math.abs(right - left) > 1)
            return -1;
        return Math.max(left, right) + 1;
    }
}
