/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    var output = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return output
    }

    fun dfs(root: TreeNode?): Int {

        if (root == null) {
            return 0
        }

        val left = dfs(root?.left)
        val right = dfs(root?.right)

        output = maxOf(output, left + right)

        val diameter = 1 + maxOf(left, right)

        return diameter

    }
}