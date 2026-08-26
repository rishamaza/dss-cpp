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

Input: 
preorder = [3, 9, 20, 15, 7]
inorder  = [9, 3, 15, 20, 7]

build(0, 4) -> Node 3
â   preIndex = 0 -> reads 3, preIndex becomes 1
â   inIndex of 3 = 1
â
âââ root.left = build(0, 0) -> Node 9
â   â   preIndex = 1 -> reads 9, preIndex becomes 2
â   â   inIndex of 9 = 0
â   â
â   âââ root.left  = build(0, -1) -> null (inStart > inEnd)
â   âââ root.right = build(1, 0)  -> null (inStart > inEnd)
â
âââ root.right = build(2, 4) -> Node 20
    â   preIndex = 2 -> reads 20, preIndex becomes 3
    â   inIndex of 20 = 3
    â
    âââ root.left = build(2, 2) -> Node 15
    â   â   preIndex = 3 -> reads 15, preIndex becomes 4
    â   â   inIndex of 15 = 2
    â   â
    â   âââ root.left  = build(2, 1) -> null (inStart > inEnd)
    â   âââ root.right = build(3, 2) -> null (inStart > inEnd)
    â
    âââ root.right = build(4, 4) -> Node 7
        â   preIndex = 4 -> reads 7, preIndex becomes 5
        â   inIndex of 7 = 4
        â
        âââ root.left  = build(4, 3) -> null (inStart > inEnd)
        âââ root.right = build(5, 4) -> null (inStart > inEnd)

Resulting Tree:
        3
       / \
      9  20
        /  \
       15   7

*/
class Solution {
    private int preIndex = 0;
    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }
    private TreeNode build(int[] preorder,int start,int end) {
        if (start > end) {
            return null;
        }
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int mid = map.get(rootVal);
        root.left = build(preorder, start, mid - 1);
        root.right = build(preorder, mid + 1, end);

        return root;
    }
}
