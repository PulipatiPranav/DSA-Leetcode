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
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        ArrayList<Integer> ans = new ArrayList<>();
        add(ans, root);
        int l = 0;
        int r = ans.size()-1;
        
        while(l<r){
            if(ans.get(l) + ans.get(r) == k) return true;
            if(ans.get(l) + ans.get(r) > k) r--;
            else l++;

        }
        return false;

        
    }

    public void add(ArrayList<Integer> l, TreeNode root){
        if(root == null) return;
        add(l, root.left);
        l.add(root.val);
        add(l,root.right);
    }
}