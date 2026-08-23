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
Target: p = 6, q = 2
       3
      / \
     5   1
    / \
   6   2
Step-by-Step Dry Run
1. Node 3 Par:
  - Condition Check: root != 6 aur root != 2 (False)
  - Action: Node 3 left child (Node 5) ko call karta hai.

2. Node 5 Par:
  - Condition Check: root != 6 aur root != 2 (False)
  - Action: Node 5 left child (Node 6) ko call karta hai.

3. Node 6 Par:
  - Base Case Trigger: root == p (6 == 6)
  - Action: Node 6 aage bina calls kiye upar "Node 6" return kar deta hai.

4. Node 5 Par Vaapas (Left Answer Received):
  - Left side se answer mil gaya: Node 6
  - Action: Node 5 ab right child (Node 2) ko call karta hai.

5. Node 2 Par:
  - Base Case Trigger: root == q (2 == 2)
  - Action: Node 2 aage bina calls kiye upar "Node 2" return kar deta hai.

6. Node 5 Par Decision Time:
  - Left result = Node 6 (Not Null)
  - Right result = Node 2 (Not Null)
  - Condition Check: Kyunki left aur right dono Not Null hain (left != null && right != null).
  - Action: Node 5 samajh gaya ki wohi split point hai, isliye upar "Node 5" return kar deta hai.

7. Node 3 Par Vaapas (Right Call):
  - Left side se answer mil gaya: Node 5
  - Action: Node 3 ab right child (Node 1) ko call karta hai.
  - Result: Node 1 ke tree me p ya q na milne par wahan se "Null" return hota hai.

8. Final Decision (Node 3 Par):
  - Left result = Node 5
  - Right result = Null
  - Condition Check: Kyunki right null hai, toh left ka result hi final hai.
  - Action: Node 3 "Node 5" ko parcel ki tarah top-level answer bana kar final return kar deta hai.

â Final LCA Answer = Node 5

*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if (l != null && r != null) {
            return root;
        }
        return l != null ? l : r;
    }
}
