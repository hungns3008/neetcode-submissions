/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    fun dfs(node: TreeNode?, maxValue: Int): Int {
        if (node == null) {
            return 0
        }
        val nodeValue = node!!.`val`
        val left = dfs(node?.left, maxOf(maxValue, nodeValue))
        val right = dfs(node?.right, maxOf(maxValue, nodeValue))

        if (nodeValue >= maxValue) {
            return 1 + left + right
        }
        
        return left + right
    }

    fun goodNodes(root: TreeNode?): Int {
        return dfs(root, Int.MIN_VALUE)
    }
}
