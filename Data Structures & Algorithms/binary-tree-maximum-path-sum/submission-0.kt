/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    var output = Int.MIN_VALUE

    fun dfs(root: TreeNode?): Int { 
        if (root == null) {
            return 0
        }
        var currentValue = root!!.`val`

        var maxLeft = dfs(root?.left)
        var maxRight = dfs(root?.right)

        output = maxOf(output, currentValue + maxLeft + maxRight)

        return maxOf(currentValue + maxOf(maxLeft, maxRight), 0)
    }

    fun maxPathSum(root: TreeNode?): Int {
        dfs(root)
        return output
    }
}
