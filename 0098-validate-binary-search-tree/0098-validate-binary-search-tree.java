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

/*
Common Trap

       10
      /  \
     5    15
         /  \
        6    20
Root (10): Allowed range is (-â, +â).
Left Subtree (5): Range ho jayegi (-â, 10). (Parent value upper bound ban gayi)
Right Subtree (15): Range ho jayegi (10, +â). (Parent value lower bound ban gayi)
15 ke Left Child (6): Range honi chahiye (10, 15).
Par Node ki value 6 hai, jo lower bound 10 ko violate karti hai (6 <= 10) -> INVALID BST!
*/

class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        boolean leftValid = validate(node.left, min, node.val);
        boolean rightValid = validate(node.right, node.val, max);
        return leftValid && rightValid;
    }
}
