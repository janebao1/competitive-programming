/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (63.33%)
 * Likes:    2112
 * Dislikes: 66
 * Total Accepted:    731.6K
 * Total Submissions: 1.1M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * return its depth = 3.
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private int maxDepth;

    public int maxDepth(TreeNode root) {
        maxDepth(root, 1);
        return maxDepth;
    }

    private void maxDepth(TreeNode root, int currDepth) {
        if (root == null) {
            return;
        }
        maxDepth = Math.max(maxDepth, currDepth);
        maxDepth(root.left, currDepth+1);
        maxDepth(root.right, currDepth+1);
    }

}
// @lc code=end
