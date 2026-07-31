/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    fun dfs(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var left = dfs(root?.left)
        var right = dfs(root?.right)
        return 1 + maxOf(left, right)
    }

    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        var left = dfs(root?.left)
        var right = dfs(root?.right)
        return Math.abs(right - left) <= 1 && isBalanced(root?.left) && isBalanced(root?.right)
    }
}
