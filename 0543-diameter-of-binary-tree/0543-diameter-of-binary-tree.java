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
 [ NODE ]  <-- Yahan path ne TURN liya (l + r)
        /    \
     (l)      (r)
      /        \
   Leaf        Leaf

   Node par: Rasta left se aaya aur right me mud gaya. Isiliye yahan dono add hue: l + r.

    Parent ke paas jaate hue: Path do taraf split nahi ho sakta (Y-shape forbidden hai). Parent ke paas hamesha ek straight line hi ja sakti hai. Isiliye parent ko sirf 1 + Math.max(l, r) milta hai.
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }
    private int dfs(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left, res);
        int r = dfs(root.right, res);

        res[0] = Math.max(res[0], l + r);

        return 1 + Math.max(l, r);
    }
}
