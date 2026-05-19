/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        // in order travel

        var output: Int? = null
        var counter = 0
        fun travel(node: TreeNode?) {
            if (node == null || output != null) {
                return
            }
            travel(node?.left)
            counter += 1
            if (counter == k) {
                output = node!!.`val`
                return
            }
            travel(node?.right)
        }

        travel(root)

        return output ?: -1
    }
}
